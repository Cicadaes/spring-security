package com.auth.center.springsecurity.controller;

import com.auth.center.springsecurity.common.base.Constant;
import com.auth.center.springsecurity.common.handler.AuthenticationException;
import com.auth.center.springsecurity.common.model.R;
import com.auth.center.springsecurity.common.model.SysMenu;
import com.auth.center.springsecurity.common.model.SysStatistics;
import com.auth.center.springsecurity.common.model.SysUser;
import com.auth.center.springsecurity.common.model.User;
import com.auth.center.springsecurity.common.util.RedisUtils;
import com.auth.center.springsecurity.common.util.RightsHelper;
import com.auth.center.springsecurity.common.util.Tools;
import com.auth.center.springsecurity.dao.SysStatisticsMapper;
import com.auth.center.springsecurity.dao.SysUserMapper;
import com.auth.center.springsecurity.jwt.JwtAuthenticationRequest;
import com.auth.center.springsecurity.jwt.JwtTokenUtil;
import com.auth.center.springsecurity.jwt.JwtUser;
import com.auth.center.springsecurity.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;
    private final static Gson gson = new Gson();
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private SysStatisticsMapper sysStatisticsMapper;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public R createAuthenticationToken(
        @RequestBody JwtAuthenticationRequest authenticationRequest)
        throws AuthenticationException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        SysUser sysUser = sysUserMapper.findByUsername(authenticationRequest.getUsername());

        //插入字段默认时间
//        sysUser.setUserId("" + new Random().nextInt(1000));
//        sysUser.setLastpasswordresetdate(null);
//        sysUser.setUsername("name" + new Random().nextInt(1000));
//        sysUserMapper.insert(sysUser);
        //根据日期查询转换
        Map map = new HashMap<>();
        map.put("cdate", "2019-01-01");
        map.put("ctime", "2029-01-02 03:04:16");
        List<SysStatistics> rst = sysStatisticsMapper.searchByParam(map);
        logger.info(String.valueOf(rst.size()));

        final String token = jwtTokenUtil.generateToken(sysUser);
        //通过用户ID读取用户信息和角色信息
        User user = sysUserMapper.getUserAndRoleById(sysUser.getUserId());
        redisUtils.set(Constant.USER_ROLE + sysUser.getUserId(), user);
        getAttributeSysMenu("Bearer " + token);
        return R.ok(token);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public R refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return R.ok(refreshedToken);
        } else {
            return R.error("无法刷新,token无效或用户密码近期修改过");
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("用户已被禁用!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("账号密码错误!", e);
        } catch (LockedException e) {
            throw new AuthenticationException("当用户被锁定!", e);
        }
    }

    /**菜单缓存
     * @param tokenHeader
     * @return
     * @throws Exception
     */
    @RequestMapping("/refreshQx")
    public R getAttributeSysMenu(
        @NotNull @RequestHeader("Authorization") String tokenHeader) {
        List<SysMenu> allmenuList = new ArrayList<SysMenu>();

        String token = tokenHeader.substring(7);
        Page page = new Page();
        page.setCurrent(1);
        page.setSize(1000);
        allmenuList = sysMenuService.listAllSysMenuQx("0", page);              //获取所有菜单
        String roleRights = jwtTokenUtil.getPrivateClaimFromToken(token, "rights");
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token, "user_id");
        if (Tools.notEmpty(roleRights)) {
            allmenuList = this.readSysMenu(allmenuList, roleRights);        //根据角色权限获取本权限的菜单列表
        }
        //清空缓存
        redisUtils.del(Constant.USER_MENU + userId);
        refreshMenu(allmenuList, userId);
        return new R(allmenuList);
    }

    private void refreshMenu(List<SysMenu> allmenuList, String userId) {
        if (allmenuList != null && allmenuList.size() > 0) {
            for (int i = 0; i < allmenuList.size(); i++) {
                if (allmenuList.get(i).isHasMenu()) {
                    String url = allmenuList.get(i).getMenuUrl().split(".do")[0];
                    redisUtils.hset(Constant.USER_MENU + userId, url,
                        gson.toJson(allmenuList.get(i).getMenuId()));
                    refreshMenu(allmenuList.get(i).getSubMenu(), userId);
                }
            }
        }
    }

    /**根据角色权限获取本权限的菜单列表(递归处理)
     * @param menuList：传入的总菜单
     * @param roleRights：加密的权限字符串
     * @return
     */
    public List<SysMenu> readSysMenu(List<SysMenu> menuList, String roleRights) {
        for (int i = 0; i < menuList.size(); i++) {
//            if (menuList.get(i).getMenuUrl().equalsIgnoreCase("menu/listAllMenu")) {
//                continue;
//            }
            menuList.get(i)
                .setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMenuId()));
            if (menuList.get(i).isHasMenu()) {    //判断是否有此菜单权限
                this.readSysMenu(menuList.get(i).getSubMenu(), roleRights);//是：继续排查其子菜单
            }
        }
        return menuList;
    }


}

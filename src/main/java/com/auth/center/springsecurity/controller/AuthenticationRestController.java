package com.auth.center.springsecurity.controller;

import com.auth.center.springsecurity.common.base.Const;
import com.auth.center.springsecurity.common.handle.AuthenticationException;
import com.auth.center.springsecurity.common.model.SysMenu;
import com.auth.center.springsecurity.common.model.SysRole;
import com.auth.center.springsecurity.common.model.SysUser;
import com.auth.center.springsecurity.common.model.User;
import com.auth.center.springsecurity.common.util.RightsHelper;
import com.auth.center.springsecurity.common.util.Tools;
import com.auth.center.springsecurity.dao.SysUserMapper;
import com.auth.center.springsecurity.jwt.JwtAuthenticationRequest;
import com.auth.center.springsecurity.jwt.JwtTokenUtil;
import com.auth.center.springsecurity.jwt.JwtUser;
import com.auth.center.springsecurity.service.ISysMenuService;
import com.auth.center.springsecurity.service.JwtAuthenticationResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysMenuService sysMenuService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
        @RequestBody JwtAuthenticationRequest authenticationRequest, HttpSession session)
        throws AuthenticationException {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        User user = (User) session
            .getAttribute(Const.SESSION_USER);            //读取session中的用户信息(单独用户信息)
        if (user == null) {
            User userr = (User) session
                .getAttribute(Const.SESSION_USERROL);        //读取session中的用户信息(含角色信息)
            SysUser sysUser = sysUserMapper.findByUsername(authenticationRequest.getUsername());

            if (null == userr) {
                user = sysUserMapper
                    .getUserAndRoleById(sysUser.getUserId());        //通过用户ID读取用户信息和角色信息
                session.setAttribute(Const.SESSION_USERROL, user);            //存入session
                String USERNAME = user.getUsername();
                SysRole role = user.getSysRole();                          //获取用户角色
                String roleRights = role != null ? role.getRights() : "";            //角色权限(菜单权限)
                session
                    .setAttribute(USERNAME + Const.SESSION_ROLE_RIGHTS,
                        roleRights);  //将角色权限存入session
                session.setAttribute(Const.SESSION_USERNAME, USERNAME);            //放入用户名到session
                List<SysMenu> allmenuList = new ArrayList<SysMenu>();
                allmenuList = this.getAttributeSysMenu(session, USERNAME, roleRights);      //菜单缓存
                if (null == session.getAttribute(USERNAME + Const.SESSION_QX)) {
                    session.setAttribute(USERNAME + Const.SESSION_QX,
                        this.getUQX(USERNAME));//按钮权限放到session中
                }
            }
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
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
        }
    }

    /**菜单缓存
     * @param session
     * @param userName
     * @param roleRights
     * @return
     * @throws Exception
     */
    @RequestMapping("/listMenu")
    public List<SysMenu> getAttributeSysMenu(HttpSession session, String userName,
        String roleRights) {
        List<SysMenu> allmenuList = new ArrayList<SysMenu>();
//        if(null == session.getAttribute(userName + Const.SESSION_allmenuList)){
        allmenuList = sysMenuService.listAllSysMenuQx("0");              //获取所有菜单
        if (Tools.notEmpty(roleRights)) {
            allmenuList = this.readSysMenu(allmenuList, roleRights);        //根据角色权限获取本权限的菜单列表
        }
        session.setAttribute(userName + Const.SESSION_allmenuList, allmenuList);//菜单权限放入session中
//        }else{
//            allmenuList = (List<SysMenu>)session.getAttribute(userName + Const.SESSION_allmenuList);
//        }
        return allmenuList;
    }

    /**根据角色权限获取本权限的菜单列表(递归处理)
     * @param menuList：传入的总菜单
     * @param roleRights：加密的权限字符串
     * @return
     */
    public List<SysMenu> readSysMenu(List<SysMenu> menuList, String roleRights) {
        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i)
                .setHasMenu(RightsHelper.testRights(roleRights, menuList.get(i).getMenuId()));
            if (menuList.get(i).isHasMenu()) {    //判断是否有此菜单权限
                this.readSysMenu(menuList.get(i).getSubMenu(), roleRights);//是：继续排查其子菜单
            }
        }
        return menuList;
    }

    /**切换菜单处理
     * @param allmenuList
     * @param session
     * @param USERNAME
     * @param changeSysMenu
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<SysMenu> changeSysMenuF(List<SysMenu> allmenuList, HttpSession session,
        String USERNAME, String changeSysMenu) {
        List<SysMenu> menuList = new ArrayList<SysMenu>();
        /** 菜单缓存为空 或者 传入的菜单类型和当前不一样的时候，条件成立，重新拆分菜单，把选择的菜单类型放入缓存 */
        if (null == session.getAttribute(USERNAME + Const.SESSION_menuList) || (!changeSysMenu
            .equals(session.getAttribute("changeSysMenu")))) {
            List<SysMenu> menuList1 = new ArrayList<SysMenu>();
            List<SysMenu> menuList2 = new ArrayList<SysMenu>();
            List<SysMenu> menuList3 = new ArrayList<SysMenu>();
            List<SysMenu> menuList4 = new ArrayList<SysMenu>();
            for (int i = 0; i < allmenuList.size(); i++) {//拆分菜单
                SysMenu menu = allmenuList.get(i);
                if ("1".equals(menu.getMenuType())) {
                    menuList1.add(menu);  //系统菜单
                } else if ("2".equals(menu.getMenuType())) {
                    menuList2.add(menu);  //业务菜单
                } else if ("3".equals(menu.getMenuType())) {
                    menuList3.add(menu);  //菜单类型三
                } else if ("4".equals(menu.getMenuType())) {
                    menuList4.add(menu);  //菜单类型四
                }
            }
            session.removeAttribute(USERNAME + Const.SESSION_menuList);
            if ("index".equals(changeSysMenu)) {
                session.setAttribute(USERNAME + Const.SESSION_menuList, menuList2);
                session.removeAttribute("changeSysMenu");
                session.setAttribute("changeSysMenu", "index");
                menuList = menuList2;
            } else if ("2".equals(changeSysMenu)) {
                session.setAttribute(USERNAME + Const.SESSION_menuList, menuList1);
                session.removeAttribute("changeSysMenu");
                session.setAttribute("changeSysMenu", "2");
                menuList = menuList1;
            } else if ("3".equals(changeSysMenu)) {
                session.setAttribute(USERNAME + Const.SESSION_menuList, menuList3);
                session.removeAttribute("changeSysMenu");
                session.setAttribute("changeSysMenu", "3");
                menuList = menuList3;
            } else if ("4".equals(changeSysMenu)) {
                session.setAttribute(USERNAME + Const.SESSION_menuList, menuList4);
                session.removeAttribute("changeSysMenu");
                session.setAttribute("changeSysMenu", "4");
                menuList = menuList4;
            }
        } else {
            menuList = (List<SysMenu>) session.getAttribute(USERNAME + Const.SESSION_menuList);
        }
        return menuList;
    }

    /**获取用户权限
     * @param USERNAME
     * @return
     */
    public Map<String, String> getUQX(String USERNAME) {
//        PageData pd = new PageData();
        Map<String, String> map = new HashMap<String, String>();
//        try {
//            pd.put(Const.SESSION_USERNAME, USERNAME);
//            pd.put("ROLE_ID", userService.findByUsername(pd).get("ROLE_ID").toString());//获取角色ID
//            pd = roleService.findObjectById(pd);										//获取角色信息
//            map.put("adds", pd.getString("ADD_QX"));	//增
//            map.put("dels", pd.getString("DEL_QX"));	//删
//            map.put("edits", pd.getString("EDIT_QX"));	//改
//            map.put("chas", pd.getString("CHA_QX"));	//查
//            List<PageData> buttonQXnamelist = new ArrayList<PageData>();
//            if("admin".equals(USERNAME)){
//                buttonQXnamelist = fhbuttonService.listAll(pd);					//admin用户拥有所有按钮权限
//            }else{
//                buttonQXnamelist = buttonrightsService.listAllBrAndQxname(pd);	//此角色拥有的按钮权限标识列表
//            }
//            for(int i=0;i<buttonQXnamelist.size();i++){
//                map.put(buttonQXnamelist.get(i).getString("QX_NAME"),"1");		//按钮权限
//            }
//        } catch (Exception e) {
//            logger.error(e.toString(), e);
//        }
        return map;
    }

}

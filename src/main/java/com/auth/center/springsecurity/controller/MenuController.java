package com.auth.center.springsecurity.controller;

import com.auth.center.springsecurity.common.model.R;
import com.auth.center.springsecurity.common.util.Jurisdiction;
import com.auth.center.springsecurity.jwt.JwtTokenUtil;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private static final  String menuUrl = "menu/listAllMenu.do"; //菜单地址(权限用)

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Jurisdiction jurisdiction;

    @RequestMapping("menu")
    public R getProtectedGreeting(@NotNull @RequestHeader("Authorization") String tokenHeader) {
        String token = tokenHeader.substring(7);
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token, "user_id");
        if (!jurisdiction.buttonJurisdiction(menuUrl, userId)) {
            return R.error("401","没有权限访问!");
        }
        return R.ok("hello menu!");
    }

}

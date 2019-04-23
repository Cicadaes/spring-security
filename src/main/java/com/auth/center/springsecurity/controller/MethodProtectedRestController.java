package com.auth.center.springsecurity.controller;

import com.auth.center.springsecurity.common.util.Jurisdiction;
import com.auth.center.springsecurity.jwt.JwtTokenUtil;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MethodProtectedRestController {

    private static final  String menuUrl = "menu/listAllMenu.do"; //菜单地址(权限用)

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Jurisdiction jurisdiction;

    @RequestMapping("menu")
    public ResponseEntity<?> getProtectedGreeting(@NotNull @RequestHeader("Authorization") String tokenHeader) {
        String token = tokenHeader.substring(7);
        String userId = jwtTokenUtil.getPrivateClaimFromToken(token, "user_id");
        if (!jurisdiction.buttonJurisdiction(menuUrl, userId)) {
            return ResponseEntity.ok("没有权限访问!");
        }
        return ResponseEntity.ok("hello menu!");
    }

}

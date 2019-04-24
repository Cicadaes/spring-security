package com.auth.center.springsecurity.controller;

import com.auth.center.springsecurity.common.annotation.Permit;
import com.auth.center.springsecurity.common.model.R;
import javax.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private static final  String menuUrl = "menu/listAllMenu.do"; //菜单地址(权限用)

    @RequestMapping("menu")
    @Permit(url=menuUrl)
    public R getProtectedGreeting(@NotNull @RequestHeader("Authorization") String tokenHeader) {
        String token = tokenHeader.substring(7);
        return R.ok("hello menu!");
    }

}

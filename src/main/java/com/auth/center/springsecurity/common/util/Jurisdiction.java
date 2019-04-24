package com.auth.center.springsecurity.common.util;

import com.auth.center.springsecurity.common.base.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Jurisdiction {

    @Autowired
    private  RedisUtils redisUtils;

    /**
     * 按钮权限(方法中校验)
     * @param menuUrl  菜单路径
     * @param userId
     * @return
     */
    public  boolean buttonJurisdiction(String menuUrl, String userId) {
        //判断是否拥有当前点击菜单的权限（内部过滤,防止通过url进入跳过菜单权限）
        boolean haskey = redisUtils
            .hHasKey(Constant.USER_MENU + userId, menuUrl.split(".do")[0]); //获取菜单列表
        if (!haskey) {        //判断有无此菜单权限
            return false;
        }
        return true;

    }

}

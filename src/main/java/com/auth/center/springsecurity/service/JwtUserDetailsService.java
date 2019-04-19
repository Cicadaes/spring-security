package com.auth.center.springsecurity.service;

import com.auth.center.springsecurity.common.model.SysUser;
import com.auth.center.springsecurity.dao.SysUserMapper;
import com.auth.center.springsecurity.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("jwtUserDetailsService")
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserMapper.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("没有找到用户 '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}

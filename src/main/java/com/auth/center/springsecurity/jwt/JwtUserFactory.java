package com.auth.center.springsecurity.jwt;

import com.auth.center.springsecurity.common.model.SysUser;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(SysUser user) {
        List<String> role=new ArrayList<String>();
        role.add(user.getRoleId());

        return new JwtUser(
                user.getUserId(),
                user.getUsername(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                mapToGrantedAuthorities(role),
                user.getEnabled()==0?true:false,
                user.getLastpasswordresetdate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }
}

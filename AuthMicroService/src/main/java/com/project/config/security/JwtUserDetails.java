package com.project.config.security;

import com.project.repository.entity.Auth;
import com.project.repository.entity.EStatus;
import com.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    private AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public UserDetails loadUserByUserId(Long id) throws UsernameNotFoundException {
        Optional<Auth>auth=authService.findById(id);
        if(auth.isEmpty())
            return null;
        List<GrantedAuthority> authorityList =new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(auth.get().getRole().name()));
            boolean status = auth.get().getStatus().equals(EStatus.ACTIVE) ? false : true;
            return User.builder()
                    .username(auth.get().getName())
                    .password("")
                    .accountExpired(false)
                    .accountLocked(status)
                    .authorities(authorityList)
                    .build();

    }



}

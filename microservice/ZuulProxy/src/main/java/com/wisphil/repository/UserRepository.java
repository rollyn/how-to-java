package com.wisphil.repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.wisphil.constant.Constants.*;

@Component
public class UserRepository {

    public User findByUsername(String userId) {

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(API_ROLE));

        User user = new User(API_USER,API_PASSWORD, authorities);
        return user;
    }

}

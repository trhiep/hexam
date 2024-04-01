package com.hexam.services.security;

import com.hexam.models.Person;
import com.hexam.services.user.UserService;
import com.hexam.config.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author trhiep
 */
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = userService.findByUserName(username);
        if (person == null) {
            return null;
        }
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        grantedAuthoritySet.add(new SimpleGrantedAuthority("ROLE_" + person.getUserRole().getRoleCode().toUpperCase()));
        return new CustomUserDetails(person, grantedAuthoritySet);
    }
}

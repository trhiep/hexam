package com.hieptv.hexam.settings;

import com.hieptv.hexam.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author trhiep
 */
public class CustomerUserDetails implements UserDetails {

    private Person person;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomerUserDetails() {
    }

    public CustomerUserDetails(Person person, Collection<? extends GrantedAuthority> authorities) {
        this.person = person;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package org.example;

import org.example.DataAccessLayer.Repository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyUSerDetails implements UserDetails
{
    Repository repo = new Repository();
    private String userName;
    private String password;
    public MyUSerDetails(String s)
    {
        userName = repo.getUser(s).getUSER_ID();
        password = repo.getUser(s).getPASSWORD();
    }

    public MyUSerDetails() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"),new SimpleGrantedAuthority("SITE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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

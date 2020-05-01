package org.example;

import org.example.DataAccessLayer.Repository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService
{
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {


        if(new Repository().getUser(s) == null)
            throw new UsernameNotFoundException("User not found");

        return new MyUSerDetails(s);
    }
}

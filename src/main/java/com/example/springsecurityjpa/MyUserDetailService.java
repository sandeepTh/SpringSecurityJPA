package com.example.springsecurityjpa;

import com.example.springsecurityjpa.model.MyUserDetails;
import com.example.springsecurityjpa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UserDetailsRepositoy userDetailsRepositoy;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userDetailsRepositoy.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("not found " + userName));
        return user.map(MyUserDetails::new).get();
    }
}

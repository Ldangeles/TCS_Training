package com.Coffee.CoffeeNetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Coffee.CoffeeNetwork.repositories.UserRepository;


@Service
public class CoffeeUserDetailsService implements UserDetailsService{
    private UserRepository usersRepository;

    public CoffeeUserDetailsService(@Autowired UserRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return usersRepository.findByUsername(username).map( (user) -> new CoffeeUserDetails(user))
        .orElseThrow( () -> new UsernameNotFoundException("User"+username+" was not found")
        );
    }
}

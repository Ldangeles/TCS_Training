package com.Coffee.CoffeeNetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Coffee.CoffeeNetwork.models.User;
import com.Coffee.CoffeeNetwork.repositories.UserRepository;
import com.Coffee.CoffeeNetwork.requests.LoginRequest;
import com.Coffee.CoffeeNetwork.requests.SignUpRequest;
import com.Coffee.CoffeeNetwork.responses.LoginResponse;
import com.Coffee.CoffeeNetwork.services.JWTService;

@RestController
public class AuthController {
    
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;
    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public AuthController(@Autowired AuthenticationManager authenticationManager, @Autowired JWTService jwtService, @Autowired PasswordEncoder passwordEncoder, @Autowired UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtService.generateToken(request.getUsername());

        LoginResponse response = new LoginResponse(token);
        return response;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpRequest request){

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);
    }

}

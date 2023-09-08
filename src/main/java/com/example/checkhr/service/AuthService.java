package com.example.checkhr.service;

import com.example.checkhr.DTO.AuthRequest;
import com.example.checkhr.config.JwtTokenUtil;
import com.example.checkhr.model.User;
import com.example.checkhr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    public User register(User annonceur){
        annonceur.setPassword(passwordEncoder.encode(annonceur.getPassword()));
        System.out.println(annonceur);
        return this.userRepository.save(annonceur);
    }

    public String login (AuthRequest authRequest){
        System.out.println(authRequest.getUsername() +" " + authRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        } catch (Exception e){
            System.out.println("The exception : "+ e);
        }
        var user= userRepository.findUsersByUsername(authRequest.getUsername()).orElseThrow();
        System.out.println(user.toString());
        var jwtToken = jwtTokenUtil.generateToken(user.getUsername(),user.getRole(),user.getId_user());
        System.out.println("token" + jwtToken);
        return  jwtToken;
    }
}
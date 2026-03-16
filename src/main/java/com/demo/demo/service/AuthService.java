package com.demo.demo.service;

import org.springframework.stereotype.Service;

import com.demo.demo.security.JwtUtil;

@Service
public class AuthService {

    public String login(String username) {

        return JwtUtil.generateToken(username);

    }
}
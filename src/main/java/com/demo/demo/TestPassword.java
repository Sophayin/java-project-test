package com.demo.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestPassword {

    public static void main(String[] args) {
        String rawPassword = "Virak@121";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String encoded = encoder.encode(rawPassword);

        System.out.println("Encoded: " + encoded);
    }
}

package com.demo.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.demo.entity.User;
import com.demo.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        System.out.println("LOGIN TRY: " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        System.out.println("FOUND USER: " + user.getUsername());
        System.out.println("PASSWORD IN DB: " + user.getPassword());

        // 🔥 ADD THIS HERE
        System.out.println(
                new BCryptPasswordEncoder().matches(
                        "Virak@121",
                        user.getPassword()));

        return new CustomUserDetails(user);
    }

}
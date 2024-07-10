package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.hotel.entity.User;
import com.example.hotel.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Handler method to show registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration"; // This will render registration.html from templates folder
    }

    // Handler method to process registration form submission
    @PostMapping("/register")
    public String registerUser(User user) {
        // Encrypt password before saving to database
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPasswordHash(encoder.encode(user.getPasswordHash()));
        userRepository.save(user);
        return "redirect:/login"; // Redirect to login page after successful registration
    }
}
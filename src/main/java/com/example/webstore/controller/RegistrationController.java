package com.example.webstore.controller;

import com.example.webstore.entity.Role;
import com.example.webstore.entity.User;
import com.example.webstore.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping ("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping ("/registration")
    public String addUser(User user, Model model) {
        User userFromBd = userRepository.findByUsername(user.getUsername());
        if (userFromBd != null) {
            model.addAttribute("massage", "Пользователь с таким именем уже существует");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";
    }
}

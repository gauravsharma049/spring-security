package com.spring.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class userController {
    @Autowired
    userRepo uRepo;

    @Autowired 
    BCryptPasswordEncoder passwordEncoder;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/users/profile")
    public String profile(){
        return "profile";
    }
    @GetMapping("users/dashboard")
    public String dashboard(){
        return "dashboard";
    }

    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        uRepo.save(user);
        return "index";
    }
}

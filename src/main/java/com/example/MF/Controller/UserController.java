package com.example.MF.Controller;

import com.example.MF.Dto.UserDto;
import com.example.MF.Entity.User;
import com.example.MF.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model){
        userService.save(userDto);
        model.addAttribute("message", "Registered Successfully");
        return "register";
    }
    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("user-page")
    public String userPage (Model model, Principal principal) {
        UserDetailsService userDetailsService = null;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "user";
    }

    @GetMapping("admin-page")
    public String adminPage (Model model, Principal principal) {
        UserDetailsService userDetailsService = null;
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "admin";
    }


    @GetMapping("users")
    public String users(Model model) {
        model.addAttribute("users", userService.findUsers());
        return "users";
    }

    GetMapping("/upsateUser/{id}")
        public String updateUser(@PathVariable Long id, Model model) {
        User user =userService.getUserId(id);
        model.addAttribute("user", user);
        return "updateForm";
    }

    GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


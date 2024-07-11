package com.example.demo.controller;

import com.example.MF.Entity.User;
import com.example.MF.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin/users";
    }

    @GetMapping("/manager/dashboard")
    public String managerDashboard() {
        return "manager/dashboard";
    }

    @GetMapping("/user/profile/{username}")
    public String userProfile(@PathVariable("username") String username, Model model) {
        User user = userService.getUserByUsername(username);
        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("/users")
    public String users (Model model) {
        model.addAttribute("users", userService.findUsers());
        return "users";
    }

    @GetMapping("/register")
    public String registration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(Model model, @PathVariable Long id) {
        User user = userService.getUserId(id);
        model.addAttribute("user", user);
        return "updateForm";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}


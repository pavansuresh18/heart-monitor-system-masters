package com.JanitriBackendAssignment.Controller;

import com.JanitriBackendAssignment.Service.UserService;
import com.JanitriBackendAssignment.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }
}

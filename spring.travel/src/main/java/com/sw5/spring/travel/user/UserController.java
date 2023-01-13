package com.sw5.spring.travel.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private final UserService userService;

    @GetMapping("/signup")
    public String signup(User)
}

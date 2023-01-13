package com.sw5.spring.travel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = "/home")
    public String main() {
        return "index";
    }

    @RequestMapping(value = "/next")
    public String test() {
        return "test";
    }
}

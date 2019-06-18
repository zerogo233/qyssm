package com.hualy.shopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("/user")
    @ResponseBody
    private Map<String, String> getUser() {
        Map<String, String> result = new HashMap<>();
        result.put("message", "success");
        return result;
    }
}

package com.hayang.blog.application.login.web;

import com.hayang.blog.application.login.domain.LoginParams;
import com.hayang.blog.application.login.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = "/member/login")
    public Map<String, String> login(LoginParams loginParams) {
        Map<String, String> response = new HashMap<>();

        try {
            loginService.login(loginParams);
            response.put("result", "OK");
        }
        catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("result", "FAIL");
        }
        return response;
    }
}

package com.hayang.blog.application.login.web;

import com.hayang.blog.application.login.domain.LoginParams;
import com.hayang.blog.application.login.domain.Member;
import com.hayang.blog.application.login.service.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/member/login")
    public ModelAndView getLoginView(ModelAndView mnv) {
        mnv.setViewName("member/login");
        return mnv;
    }

    @ResponseBody
    @PostMapping(value = "/member/login")
    public Map<String, String> login(LoginParams loginParams) {
        Map<String, String> response = new HashMap<>();

        try {
            loginService.login(loginParams);
            response.put("message", "로그인 성공하였습니다. ");
            response.put("result", "OK");
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            response.put("message", e.getMessage());
            response.put("result", "FAIL");
        }
        return response;
    }

    @GetMapping(value = "/member/signUp")
    public ModelAndView getSignUpView(ModelAndView mnv) {
        mnv.setViewName("member/signup");
        return mnv;
    }

    @ResponseBody
    @PostMapping(value = "/member/signUp")
    public Map<String, String> signUp(Member member) {
        Map<String, String> result = new HashMap<>();
        try {
            loginService.signUp(member);
            result.put("message", "회원가입 성공");
        } catch (Exception e) {
            result.put("message", e.getMessage());
        }

        return result;
    }
}

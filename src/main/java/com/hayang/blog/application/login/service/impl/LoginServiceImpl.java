package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.domain.LoginParams;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean isLogin(LoginParams loginParams) {
        return false;
    }
}

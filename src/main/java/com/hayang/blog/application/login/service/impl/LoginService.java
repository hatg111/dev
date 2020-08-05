package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.domain.LoginParams;

public interface LoginService {
    public boolean isLogin(LoginParams loginParams) throws Exception;
}

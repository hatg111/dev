package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.domain.LoginParams;

public interface LoginService {
    public void login(LoginParams loginParams) throws Exception;
}

package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.domain.LoginParams;
import com.hayang.blog.application.login.domain.Member;

public interface LoginService {

    /**
     * 로그인을 한다.
     *
     * @param loginParams
     * @throws Exception
     */
    public void login(LoginParams loginParams) throws Exception;

    /**
     * 회원가입을 한다.
     *
     * @param member
     * @throws Exception
     */
    public void signUp(Member member) throws Exception;
}

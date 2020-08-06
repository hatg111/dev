package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.dao.LoginMapper;
import com.hayang.blog.application.login.domain.LoginParams;
import com.hayang.blog.application.login.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void login(LoginParams loginParams) throws Exception {
        if (Objects.isNull(loginParams.getMemberId())) {
            throw new Exception("아이디를 입력하세요. ");
        }
        if (Objects.isNull(loginParams.getPassword())) {
            throw new Exception("비번을 입력하세요. ");            }
        Member member = new Member();
        member.setMemberId(loginParams.getMemberId());
        member.setPassword(loginParams.getPassword());

        if (1 != loginMapper.login(member)) {
            throw new Exception("회원정보가 없습니다. ");
        }
    }
}

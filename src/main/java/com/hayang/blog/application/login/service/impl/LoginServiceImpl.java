package com.hayang.blog.application.login.service.impl;

import com.hayang.blog.application.login.dao.LoginMapper;
import com.hayang.blog.application.login.domain.LoginParams;
import com.hayang.blog.application.login.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public void login(LoginParams loginParams) throws Exception {
        nullCheckUtill(loginParams.getMemberId(), "아이디를 입력하세요. ");
        nullCheckUtill(loginParams.getPassword(), "비번을 입력하세요. ");

        Member member = new Member();
        String password = createHash(loginParams.getPassword());
        member.setMemberId(loginParams.getMemberId());
        member.setPassword(password);
        
        if (!(loginMapper.login(member) == 1)) {
            throw new Exception("회원정보가 없습니다. ");
        }
    }

    @Override
    public void signUp(Member member) throws Exception {
        nullCheckUtill(member.getEmail(), "email주소가 없습니다. ");
        nullCheckUtill(member.getPassword(), "PASSWORD가 없습니다. ");
        nullCheckUtill(member.getUserName(), "이름이 없습니다. ");
        System.out.println(member.getEmail());

        member.setEncodedPassword(createHash(member.getPassword()));

        loginMapper.signUp(member);
    }

    private void nullCheckUtill(Object object, String message) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception(message);
        }
    }

    public static String createHash(String str) {
        String hashString = "";
        try {
            // MD2, MD4, MD5, SHA-1, SHA-256, SHA-512
            MessageDigest sh = MessageDigest.getInstance("MD5");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashString = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            hashString = null;
        }
        return hashString;
    }
}

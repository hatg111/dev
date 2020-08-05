package com.hayang.blog.application.login.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class LoginParams {
    private String memberId;
    private String password;
}

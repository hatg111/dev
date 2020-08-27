package com.hayang.blog.application.login.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("Member")
@Data
public class Member {
    private String email;
    private String userName;
    private String memberId;
    private String password;
    private String phoneNumber;

}

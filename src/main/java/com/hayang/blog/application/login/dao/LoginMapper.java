package com.hayang.blog.application.login.dao;

import com.hayang.blog.application.login.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("LoginMapper")
@Mapper
public interface LoginMapper {
    public Integer login(Member member) throws Exception;

    public void signUp(Member member) throws Exception;
}

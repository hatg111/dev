package com.hayang.blog.application.login.dao;

import com.hayang.blog.application.login.domain.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository("loginMapper")
@Mapper
public interface LoginMapper {
    public Integer login(Member member);
}

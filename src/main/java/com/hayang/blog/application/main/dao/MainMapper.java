package com.hayang.blog.application.main.dao;

import com.hayang.blog.application.main.domain.BoardFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mainMapper")
@Mapper
public interface MainMapper {

    /**
     * 파일 정보를 저장한다.
     *
     * @param boardFileList
     */
    public void saveFileList(List<BoardFile> boardFileList);
}

package com.hayang.blog.application.main.dao;

import com.hayang.blog.application.main.domain.BoardFile;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Resource
@Mapper
public interface MainMapper {

    /**
     * 파일 정보를 저장한다.
     *
     * @param boardFileList
     */
    public void saveFileList(List<BoardFile> boardFileList);
}

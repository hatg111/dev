package com.hayang.blog.application.main.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public interface MainService {
    /**
     * 파일을 다운로드한다.
     *
     * @param multipartFile
     */
    //public void downloadFile(MultipartFile multipartFile);

    /**
     * 파일을 업로드한다.
     *
     * @param multipartRequest
     */
    public void uploadFile(MultipartRequest multipartRequest);

}

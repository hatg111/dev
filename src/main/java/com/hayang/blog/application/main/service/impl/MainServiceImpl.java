package com.hayang.blog.application.main.service.impl;

import com.hayang.blog.application.main.dao.MainMapper;
import com.hayang.blog.application.main.domain.BoardFile;
import com.hayang.blog.application.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainMapper mainMapper;

    @Override
    public void uploadFile(MultipartRequest multipartRequest) {
        String path = "C://blogService/blogImage";
        List<MultipartFile> list = null;
        List<BoardFile> fileList = new ArrayList<>();
        Iterator<String> iterator = multipartRequest.getFileNames();

        try {
            File file = new File(path);

            if (!file.exists()) {
                org.apache.commons.io.FileUtils.forceMkdir(file);
            }

            while (iterator.hasNext()) {
                list = multipartRequest.getFiles(iterator.next());
            }

            // 파일 이름 짓고 해당 디렉토리로 multipartFile 저장하기
            for (MultipartFile multipartFile : list) {
                String contentType = multipartFile.getContentType();
                String newFileName = System.nanoTime() + getOriginalFileExtension(contentType);
                String storeFilePath = path + "/" + newFileName;

                BoardFile boardFile = makeBoardFile(multipartFile, storeFilePath);
                fileList.add(boardFile);

                file = new File(path + "/" + newFileName);
                multipartFile.transferTo(file);
            }



        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private String getOriginalFileExtension(String contentType) throws Exception {

        if (ObjectUtils.isEmpty(contentType)) {
            throw new Exception("fileTypeException");
        }
        else {
            if (contentType.contains("image/jpeg")) {
                return ".jpg";
            }
            else if (contentType.contains("image/png")) {
                return ".png";
            }
            else if (contentType.contains("image/gif")) {
                return ".gif";
            }
            else {
                throw new Exception("fileTypeException");
            }
        }
    }

    private BoardFile makeBoardFile(MultipartFile multipartFile, String storedFilePath) {
        BoardFile boardFile = new BoardFile();
        //boardFile.setBno(bno);
        boardFile.setFileSize(multipartFile.getSize());
        boardFile.setOriginalFileName(multipartFile.getOriginalFilename());
        boardFile.setStoreFilePath(storedFilePath);

        return boardFile;
    }
}

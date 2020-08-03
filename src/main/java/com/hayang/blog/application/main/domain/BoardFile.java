package com.hayang.blog.application.main.domain;

import lombok.Data;

@Data
public class BoardFile {
    private String fileName;
    private String originalFileName;
    private String storeFilePath;
    private Integer bno;
    private double fileSize;
}

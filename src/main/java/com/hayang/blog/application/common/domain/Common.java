package com.hayang.blog.application.common.domain;

import lombok.Data;

import java.util.Objects;

@Data
public class Common {
    private static Common common = new Common();

    private Common() {}

    public static Common getInstance() {
        return common;
    }

    public static void nullCheckUtill(Object object, String message) throws Exception {
        if (Objects.isNull(object)) {
            throw new Exception(message);
        }
    }

}

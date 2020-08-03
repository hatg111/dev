package com.hayang.blog.application.main.web;

import com.hayang.blog.application.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping(value = "/")
    public ModelAndView main(ModelAndView mnv) {
        mnv.setViewName("main/view");
        return mnv;
    }

    //@GetMapping(value = "/file/download")
    //@ResponseBody
    //public void downloadFile(ModelAndView mnv, MultipartFile multipartFile) {
    //    mainService.downloadFile(multipartFile);
    //}

    @PostMapping(value = "/file/upload")
    @ResponseBody
    public void uploadFile(ModelAndView mnv, MultipartRequest multipartRequest) {
        mainService.uploadFile(multipartRequest);
    }
}

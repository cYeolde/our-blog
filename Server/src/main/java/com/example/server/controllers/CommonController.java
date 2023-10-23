package com.example.server.controllers;


import com.example.server.pojo.Pic;
import com.example.server.service.IStorageService;
import com.example.server.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@Slf4j
@RequestMapping("/")
public class CommonController {

    @Autowired
    private IStorageService storageService;

    @Value("${uploadPic.accessPath}")
    private String accessPath;

    @Value("${uploadPic.localPath}")
    private String localPath;


    @PostMapping(value = "/uploadPic")
    public Result<String> upload(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        if (file != null) {
            String fileName = file.getOriginalFilename();
            log.info("upload file:{} success", fileName);
            storageService.save(file, fileName, localPath);
            return Result.success(accessPath + fileName);
        }
        else{
            return Result.error();
        }
    }


}

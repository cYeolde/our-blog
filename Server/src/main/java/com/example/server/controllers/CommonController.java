package com.example.server.controllers;


import com.example.server.form.PoiForm;
import com.example.server.pojo.Pic;
import javax.sql.rowset.serial.SerialBlob;
import com.example.server.pojo.Poi;
import com.example.server.service.IPoiService;
import com.example.server.service.IStorageService;
import com.example.server.vo.PoiVo;
import com.example.server.vo.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Blob;
import java.sql.SQLException;


@RestController
@Slf4j
@RequestMapping("/")
public class CommonController {

    @Autowired
    private IStorageService storageService;

    @Autowired
    private IPoiService poiService;

    @Value("${uploadPic.accessPath}")
    private String accessPathPic;

    @Value("${uploadPic.localPath}")
    private String localPathPic;

    @Value("${uploadFile.accessPath}")
    private String accessPathFile;

    @Value("${uploadFile.localPath}")
    private String localPathFile;

    @PostMapping(value = "/uploadFile")
    @ResponseBody
    public Result<PoiVo> uploadNew(@RequestPart("file") MultipartFile file, @RequestPart("poiForm") String poiFormStr) throws JsonProcessingException {
        if (file != null) {
            String fileName = file.getOriginalFilename();
            log.info("upload file:{} success", fileName);
            storageService.save(file, fileName, localPathFile);
            ObjectMapper mapper = new ObjectMapper();
            PoiForm poiForm = mapper.readValue(poiFormStr, PoiForm.class);
            log.info("my info: {}",poiForm);
            Poi poi = new Poi();
            BeanUtils.copyProperties(poiForm, poi);
            poiService.saveMain(poi, poiForm.getPicList());
            PoiVo poiVo = new PoiVo();
            BeanUtils.copyProperties(poi, poiVo);
            poiVo.setPicList(poiForm.getPicList());
            return Result.success(poiVo);
        }
        else{
            return Result.error();
        }

    }
    @PostMapping(value = "/uploadPic")
    public Result<String> upload(HttpServletRequest request, HttpServletResponse response) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        if (file != null) {
            String fileName = file.getOriginalFilename();
            log.info("upload file:{} success", fileName);
            storageService.save(file, fileName, localPathPic);
            return Result.success(accessPathPic + fileName);
        }
        else{
            return Result.error();
        }
    }


}

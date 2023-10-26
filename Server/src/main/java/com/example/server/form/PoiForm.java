package com.example.server.form;

import com.example.server.pojo.Pic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
@Data
public class PoiForm {
    private Integer id;
    private String title;
    private String description;
    private String coverUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp uploadTime;

    private List<Pic> picList;

}

package com.example.server.vo;

import com.example.server.pojo.Pic;
import lombok.Data;

import java.util.List;

@Data
public class PoiVo {
    private String name;
    private String description;
    private Integer id;
    private List<Pic> picList;

}

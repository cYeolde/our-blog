package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("poi_table")
public class Poi {
    private Integer id;
    private String title;
    private String description;
    private String coverUrl;
    private Timestamp uploadTime;
    private String filePath;


}

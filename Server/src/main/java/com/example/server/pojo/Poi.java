package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("poi_table")
public class Poi {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;
    private String description;
    private String coverUrl;
    private Timestamp uploadTime;
    private String filePath;


}

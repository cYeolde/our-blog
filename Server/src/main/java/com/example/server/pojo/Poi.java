package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("poi_table")
public class Poi {
    private Integer id;
    private String name;
    private String description;
    private String coverUrl;


}

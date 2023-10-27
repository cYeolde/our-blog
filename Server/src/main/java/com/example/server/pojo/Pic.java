package com.example.server.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pic_table")
public class Pic {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer poiId;
    private String imgUrl;

}

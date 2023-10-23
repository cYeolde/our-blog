package com.example.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.server.pojo.Pic;
import org.apache.ibatis.annotations.Param;

public interface PicMapper extends BaseMapper<Pic> {
    int deleteByPoiId(@Param("poiId") Integer poiId);
}

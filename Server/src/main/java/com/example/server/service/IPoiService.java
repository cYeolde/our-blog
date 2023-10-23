package com.example.server.service;

import com.example.server.pojo.Pic;
import com.example.server.pojo.Poi;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IPoiService extends IService<Poi> {
    void saveMain(Poi poi, List<Pic> picList);

    void updateMain(Poi poi,List<Pic> picList);

    void delMain(Integer id);

}

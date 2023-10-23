package com.example.server.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.server.exception.PoiException;
import com.example.server.mapper.PicMapper;
import com.example.server.mapper.PoiMapper;
import com.example.server.pojo.Pic;
import com.example.server.pojo.Poi;
import com.example.server.service.IPoiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoiServiceImpl extends ServiceImpl<PoiMapper, Poi> implements IPoiService {

    @Autowired
    private PoiMapper poiMapper;

    @Autowired
    private PicMapper picMapper;

    @Override
    public void saveMain(Poi poi, List<Pic> picList) {
        int row = poiMapper.insert(poi);

        if(row==0){
            throw PoiException.OperateFail();
        }

        if(picList!=null && !picList.isEmpty()){
            for(Pic entity:picList) {

                entity.setPoiId(poi.getId());
                int i_row = picMapper.insert(entity);
                if(i_row==0){
                    throw PoiException.OperateFail();
                }

            }
        }
    }

    @Override
    public void updateMain(Poi poi,List<Pic> picList) {
        poiMapper.updateById(poi);

        //1.先删除子表数据
        picMapper.deleteByPoiId(poi.getId());

        //2.子表数据重新插入
        if(picList!=null && !picList.isEmpty()){
            for(Pic entity:picList) {

                entity.setPoiId(poi.getId());
                picMapper.insert(entity);
            }
        }
    }

    @Override
    public void delMain(Integer id) {
        int row = poiMapper.deleteById(id);
        if(row==0){
            throw PoiException.OperateFail();
        }


        row = picMapper.deleteByPoiId(id);
        if(row==0){
            throw PoiException.OperateFail();
        }
    }
}

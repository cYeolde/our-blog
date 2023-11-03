package com.example.server.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.server.exception.PoiException;
import com.example.server.form.PoiForm;
import com.example.server.pojo.Pic;
import com.example.server.pojo.Poi;
import com.example.server.service.IPicService;
import com.example.server.service.IPoiService;
import com.example.server.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import com.example.server.vo.PoiVo;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/poi")
public class PoiController {

    @Autowired
    private IPoiService poiService;
    @Autowired
    private IPicService picService;


    @GetMapping("/list")
    public Result<IPage<PoiVo>> list(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "6") int pageSize) {
        log.info("my list: pageNum={},pageSize={}",pageNum,pageSize);
        Page<Poi> page = new Page<>(pageNum, pageSize);
        IPage<Poi> pageResult = poiService.page(page);

        List<Poi> poiList = pageResult.getRecords();
        List<PoiVo> voList = new ArrayList<>();
        for (Poi poi : poiList) {
            PoiVo poiVo = new PoiVo();
            QueryWrapper<Pic> query = new QueryWrapper<>();
            query.eq("poi_id", poi.getId());
            List<Pic> picList = picService.list(query);
            BeanUtils.copyProperties(poi, poiVo);
            poiVo.setPicList(picList);
            voList.add(poiVo);
        }
//        List<PoiVo> voList = pageResult.getRecords().stream().map()( poi -> {
//                    PoiVo poiVo = new PoiVo();
//                    BeanUtils.copyProperties(poi, poiVo);
//                    return poiVo;
//                }
//                ).collect(Collectors.toList());
        IPage<PoiVo> pageResultVo = new Page<>(pageNum, pageSize);
        pageResultVo.setRecords(voList);
        pageResultVo.setTotal(pageResult.getTotal());
        return Result.success(pageResultVo);
    }

    @GetMapping("/detail/{id}")
    public Result<PoiVo> detail(@PathVariable int id) {
        log.info("poi detail: id={}",id);
//        Poi poi = poiMapper.selectById(id);
        PoiVo poiVo = new PoiVo();
        Poi poi = poiService.getById(id);
        if(poi==null){
            throw PoiException.notFound();
        }
        QueryWrapper<Pic> query = new QueryWrapper<>();
        query.eq("poi_id", poi.getId());
        List<Pic> picList = picService.list(query);
        BeanUtils.copyProperties(poi, poiVo);
        poiVo.setPicList(picList);

        return Result.success(poiVo);
    }

    @PostMapping("/add")
    public Result<PoiVo> add(@RequestBody PoiForm poiForm) {
        log.info("my info: {}",poiForm);
        Poi poi = new Poi();
        BeanUtils.copyProperties(poiForm, poi);
        poiService.saveMain(poi, poiForm.getPicList());
        return detail(poi.getId());
    }

    @PutMapping("/update/{id}")
    public Result<PoiVo> update(@RequestBody PoiForm poiForm, @PathVariable int id) {
        log.info("poi update: {}}",poiForm);
        Poi poi = new Poi();
        BeanUtils.copyProperties(poiForm, poi);
        poi.setId(id);
        poiService.updateMain(poi,poiForm.getPicList());
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result<PoiVo> delete(@PathVariable int id) {
        log.info("poi delete, id={}",id);
        poiService.delMain(id);
        return Result.success();
    }
}



//package com.example.server.controllers;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Slf4j
//@RequestMapping("/md")
//public class MarkdownController {
//    /**
//     * 获取文章
//     * id: 文章id
//     * @author YSL
//     * 2019-03-04 15:38
//     */
//    @GetMapping("/get")
//    @ResponseBody
//    public Bean test(@RequestParam("id")Integer id){
//        // 获取数据库中的数据，请自行实现。
//        return vueMarkdownMapper.query(id);
//    }
//
//    /**
//     * 保存文章到数据库。
//     * bean：前端传回JSON.stringify({'markdown':markdownCode,'html':htmlCode})格式的数据即可
//     * @author YSL
//     * 2019-03-04 15:26
//     */
//    @PostMapping("/add")
//    @ResponseBody
//    public int test(@RequestBody Bean bean){
//        return vueMarkdownMapper.add(bean);// 保存数据到数据库，请自行实现
//    }
//}
//

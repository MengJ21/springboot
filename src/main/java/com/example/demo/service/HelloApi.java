package com.example.demo.service;

import org.springframework.web.bind.annotation.*;

@RestController// 说明下面的类是服务的类
@RequestMapping("/api/Hello")
public class HelloApi {
    @RequestMapping(value = "/say/{name}",method = RequestMethod.GET)//{}是占位符。
    String sayName(@PathVariable String name) {// 路径变量
        return "您的名字是：" + name;
    }
    @GetMapping("/say2/{name}")
    String sayName2(@PathVariable String name) {// 路径变量
        return "您的名字是：" + name + "同学";
    }
}

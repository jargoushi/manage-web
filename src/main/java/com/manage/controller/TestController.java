package com.manage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test() {

        return "hello";
    }
}

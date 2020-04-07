package com.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String test() {

        return "index";
    }
}

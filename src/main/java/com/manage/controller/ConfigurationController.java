package com.manage.controller;

import com.manage.bean.Manage;
import com.manage.dto.ResponseCode;
import com.manage.service.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content: 配置管理controller
 */
@Controller
@RequestMapping("/manage")
public class ConfigurationController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationController.class);

    @Autowired
    private ConfigurationService configurationService;

    @RequestMapping("/addDeploy")
    @ResponseBody
    public ResponseCode addDeploy(Manage manage) {

        logger.info("新增配置信息, manage=【{}】", manage);
        try {
            configurationService.addDeploy(manage);
            logger.info("新增配置信息成功");
            return new ResponseCode(0000, "成功");
        } catch (Exception e) {
            logger.error("新增配置信息异常", e);
            return new ResponseCode(9999, "失败");
        }
    }

    @RequestMapping("/showDeployView")
    public String showDeployView() {
        return "views/customer/insert";
    }
}

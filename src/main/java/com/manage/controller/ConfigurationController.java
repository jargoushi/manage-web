package com.manage.controller;

import com.manage.bean.Manage;
import com.manage.dto.ResponseCode;
import com.manage.service.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
            return new ResponseCode(200, "成功");
        } catch (Exception e) {
            logger.error("新增配置信息异常", e);
            return new ResponseCode(9999, "失败");
        }
    }

    @RequestMapping("/getConfiguration")
    @ResponseBody
    public ResponseCode getConfiguration() {

        logger.info("展示页面信息 start");
        try {
            Manage manage = configurationService.getConfiguration();
            logger.info("展示页面信息 成功");
            return new ResponseCode(200, "成功", manage);
        } catch (Exception e) {
            logger.info("展示页面信息 失败");
            return new ResponseCode(9999, "失败");
        }
    }

    @RequestMapping("/showDeployView")
    public String showDeployView() {
        return "views/customer/insert";
    }
}

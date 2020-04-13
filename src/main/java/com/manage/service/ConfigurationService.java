package com.manage.service;

import com.manage.bean.Manage;
import com.manage.exception.BizException;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:    配置管理Service
 */
public interface ConfigurationService {

    /**
     * 新增配置用于小程序端展示
     * @param manage
     */
    void addDeploy(Manage manage) throws BizException;

    /**
     * 查询配置信息展示小程序页面
     * @return
     */
    Manage getConfiguration() throws BizException;
}

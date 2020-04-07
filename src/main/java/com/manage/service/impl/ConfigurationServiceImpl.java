package com.manage.service.impl;

import com.manage.bean.Manage;
import com.manage.dto.ErrorCode;
import com.manage.exception.BizException;
import com.manage.mapper.ConfigurationMapper;
import com.manage.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:    配置管理实现
 */
// 交给spring管理, 成为spring容器中的一个bean
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationMapper configurationMapper;

    public void addDeploy(Manage manage) throws BizException {

        int count = configurationMapper.addDeploy(manage);
        if (count < 1) {
            throw new BizException(ErrorCode.DATABASE_ERROR);
        }
    }
}

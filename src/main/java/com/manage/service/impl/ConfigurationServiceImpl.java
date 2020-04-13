package com.manage.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.manage.bean.Manage;
import com.manage.dto.ErrorCode;
import com.manage.exception.BizException;
import com.manage.mapper.ConfigurationMapper;
import com.manage.service.ConfigurationService;
import com.manage.service.util.SystemUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content: 配置管理实现
 */
// 交给spring管理, 成为spring容器中的一个bean
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    private static final Logger logger = LoggerFactory.getLogger(ConfigurationServiceImpl.class);

    @Autowired
    private ConfigurationMapper configurationMapper;

    public void addDeploy(Manage manage) throws BizException {

        MultipartFile[] files = manage.getImgFile();
        String imgs = "";
        if (files != null && files.length > 0) {

            File parentFile = new File("D://uploadImage");
            if (parentFile == null || !parentFile.exists()) {
                parentFile.mkdirs();
            }

            for (MultipartFile file : files) {
                if (file == null || file.isEmpty()) {
                    continue;
                }

                // 这个图片肯定不为空, 需要上传
                // 需要为上传的图片起一个不会重复的名字
                String targetFileName = UUID.randomUUID().toString().replace("-", "") + file.getOriginalFilename();
                File targetFile = new File(parentFile.getPath() + File.separator + targetFileName);

                try {
                    file.transferTo(targetFile);

                    String filePath = "/upload/" + targetFileName;

                    imgs += "http://" + SystemUtil.getLocalIP() + ":" + SystemUtil.getLocalPort() + filePath + ";";
                } catch (Exception e) {
                    logger.error("上传图片失败, fileName={}", file.getOriginalFilename());
                    continue;
                }
            }
        }
        manage.setImg(StringUtils.isEmpty(imgs) ? "" : imgs.substring(0, imgs.length() - 1));
        manage.setCreateTime(new Date());
        int count = configurationMapper.addDeploy(manage);
        if (count < 1) {
            throw new BizException(ErrorCode.DATABASE_ERROR);
        }
    }

    public Manage getConfiguration() throws BizException {

        Manage manage = configurationMapper.getConfiguration();
        if (manage == null) {
            throw new BizException(ErrorCode.NOT_FOUNT_CONFIGURATION);
        }

        String img = manage.getImg();

        if (!StringUtils.isEmpty(img)) {
            String[] split = img.split(";");
            manage.setImgPaths(split);
        }

        return manage;
    }
}

package com.manage.dto;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:
 */
public enum  ErrorCode {

    DATABASE_ERROR("0001", "数据库操作失败"),
    FILE_ERROR("0002", "文件解析失败"),
    NOT_FOUNT_CONFIGURATION("0003", "未配置展示内容");


    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

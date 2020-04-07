package com.manage.exception;

import com.manage.dto.ErrorCode;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/4/7
 * @Content:
 */
public class BizException extends Exception {

    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        super(errorCode.getMsg());
        this.errorCode = errorCode;
    }


}

package com.example.esdata.core.common.exception;

/**
 * 业务异常
 * @author zhongzhaohai
 * @date 2023/6/16 17:06
 */
public class BusinessException extends RuntimeException{

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

}

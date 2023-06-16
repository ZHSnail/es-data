package com.example.esdata.core.web.enums;

import com.example.esdata.core.web.web.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhongzhaohai
 * @date 2023/6/16 16:44
 */
@Getter
@AllArgsConstructor
public enum BaseResponseCode implements ResponseCode {
    SUCCESS(2000,"成功"),
    NOT_FOUND(4004,"接口不存在"),
    INTER_ERR(5000,"服务器内部错误"),
    ;
    private final int code;
    private final String remark;

}

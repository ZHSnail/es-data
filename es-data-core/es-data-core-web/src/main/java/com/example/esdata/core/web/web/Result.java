package com.example.esdata.core.web.web;

import com.example.esdata.core.web.enums.BaseResponseCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author zhongzhaohai
 * @date 2023/6/15 19:02
 */
@Data
@NoArgsConstructor
public class Result<T> {
    @ApiModelProperty(value = "响应码",allowableValues = "2000：成功，4004：接口不存在，5000：服务器内部错误")
    private int code = BaseResponseCode.SUCCESS.getCode();
    @ApiModelProperty("业务数据")
    private T data;
    @ApiModelProperty("报错信息")
    private String msg;
    @ApiModelProperty("异常时为false")
    private boolean isSuccess = true;

    public Result(T data) {
        this.data = data;
    }

    public Result(T data, String msg) {
        this.msg = msg;
        this.data = data;
    }

    public Result(T data, String msg, boolean isSuccess) {
        this.data = data;
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public Result(String msg, boolean isSuccess) {
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

    public Result(ResponseCode responseCode, String msg, boolean isSuccess) {
        this.code = responseCode.getCode();
        this.msg = msg;
        this.isSuccess = isSuccess;
    }

}

package com.zhsnail.esdata.etl.controller;

import com.example.esdata.core.web.web.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhongzhaohai
 * @date 2023/6/16 16:57
 */
@RestController
@RequestMapping("/test")
@ControllerAdvice
public class TestController {

    @GetMapping("/testResult")
    public Result<Void> test(){
        return new Result<>();
    }
}

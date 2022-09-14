package com.inmeasure.common.controller;

import com.inmeasure.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试全局异常处理器的接口
 */
@RestController
@RequestMapping("/demo")
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello everyone.";
    }

    @GetMapping("/error")
    public Result error() {
        int value = 8 / 0;
        return Result.success(value);
    }
}

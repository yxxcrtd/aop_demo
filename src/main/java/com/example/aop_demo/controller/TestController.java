package com.example.aop_demo.controller;

import com.example.aop_demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("1")
    public void test1() {
        testService.test1();
    }

    @GetMapping("2")
    public void test2() {
        testService.test2();
    }

}

package com.example.aop_demo.service.impl;

import com.example.aop_demo.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public long test1() {
        Date startDate = new Date();

        for (int i = 0; i < 5000000; i++) {
            System.out.println(i);
        }

        Date endDate = new Date();

        System.out.println("test1开始时间：" + startDate);
        System.out.println("test1结束时间：" + endDate + "\n");
        return startDate.getTime() - endDate.getTime();
    }

    @Override
    public long test2() {
        Date startDate = new Date();

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }

        Date endDate = new Date();

        System.out.println("test2开始时间：" + startDate);
        System.out.println("test2结束时间：" + endDate + "\n");
        return startDate.getTime() - endDate.getTime();
    }

}

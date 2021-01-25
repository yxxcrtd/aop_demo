package com.example.aop_demo.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ServiceAspect {

    private static final Logger log = LoggerFactory.getLogger(ServiceAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(public * com.example.aop_demo.service.impl.*.*(..))")
    public void serviceImpl() {
    }

    @Before("serviceImpl()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("请求的URL：" + request.getRequestURL().toString());
        System.out.println("请求的方法：" + request.getMethod());
    }

    @AfterReturning(returning = "obj", pointcut = "serviceImpl()")
    public void doAfterReturning(Object obj) throws Exception {
        System.out.println("方法返回值:" + new ObjectMapper().writeValueAsString(obj) + "，方法执行时间:" + (System.currentTimeMillis() - startTime.get()) + "毫秒");
    }

}

## 一，使用脚手架快速生成一个SpringBoot项目：https://start.spring.io


## 二，添加Maven依赖：

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>


## 三，在配置中开启AOP注解：

spring:
    aop:
        proxy-target-class: true
        auto: true  # 开启AOP注解


## 四，ServiceAspect：


## 五，写了2个测试的 ServiceImpl：


## 六，启动，访问：

    第1个：http://localhost:8080/test/1；
    第2个：http://localhost:8080/test/2；
    控制台输出：方法返回值:-19603，方法执行时间:19648毫秒


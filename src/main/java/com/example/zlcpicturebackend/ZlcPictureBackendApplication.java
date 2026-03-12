package com.example.zlcpicturebackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.framework.AopContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
@MapperScan("com.example.zlcpicturebackend.mapper")
public class ZlcPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZlcPictureBackendApplication.class, args);
    }

}

package com.ggg.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.ggg.mybatisplus.mapper")
@EnableAsync
@EnableTransactionManagement  //开启事务
public class MybatisPlusApplication1 {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication1.class,args);
        System.out.println("启动成功！！");
    }
}

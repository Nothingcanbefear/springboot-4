package com.ggg.mybatisplus.controller;


import com.ggg.mybatisplus.entity.TestData;
import com.ggg.mybatisplus.service.impl.TestDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@RestController
@RequestMapping("/testData")
public class TestDataController {

    @Autowired
    private TestDataServiceImpl testDataService;

    @GetMapping("/test")
    public List<TestData> queryData(){
        System.out.println("SUCCESS");
        return testDataService.queryData();
    }


}


package com.ggg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ggg.mybatisplus.entity.TestData;
import com.ggg.mybatisplus.mapper.TestDataMapper;
import com.ggg.mybatisplus.service.ITestDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@Service
public class TestDataServiceImpl extends ServiceImpl<TestDataMapper, TestData> implements ITestDataService {

    @Autowired
    private TestDataMapper testDataMapper;

    public List<TestData> queryData(){
        LambdaQueryWrapper<TestData> wrapper = new LambdaQueryWrapper<>();
       return testDataMapper.selectList( wrapper.le(TestData::getCreateTime, LocalDateTime.now()));
    }

}

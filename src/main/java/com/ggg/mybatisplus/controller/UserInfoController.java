package com.ggg.mybatisplus.controller;


import com.ggg.mybatisplus.common.ResultMap;
import com.ggg.mybatisplus.dto.UserInfoVo;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.entity.UserInfo;
import com.ggg.mybatisplus.mapper.UserInfoMapper;
import com.ggg.mybatisplus.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@Controller
@RequestMapping("//userInfo")
public class UserInfoController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public ResultMap<UserInfoVo> selectById(Long id){
        User user = userMapper.selectById(id);
        UserInfo userInfo = userInfoMapper.selectById(user.getId());
        UserInfoVo userInfoVo = new UserInfoVo();

        userInfoVo.setAge(user.getAge()).setEmail(user.getEmail())
                .setAddress(userInfo.getAddress()).setCareer(userInfo.getCareer());
        return null;
    }

}


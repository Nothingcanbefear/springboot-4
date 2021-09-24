package com.ggg.mybatisplus.service.impl;

import com.ggg.mybatisplus.entity.UserInfo;
import com.ggg.mybatisplus.mapper.UserInfoMapper;
import com.ggg.mybatisplus.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    List<UserInfo> selectAll(){
        return userInfoMapper.selectList(null);
    }

}

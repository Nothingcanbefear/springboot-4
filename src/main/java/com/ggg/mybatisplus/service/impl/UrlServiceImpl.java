package com.ggg.mybatisplus.service.impl;

import com.ggg.mybatisplus.entity.Url;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.mapper.UrlMapper;
import com.ggg.mybatisplus.mapper.UserMapper;
import com.ggg.mybatisplus.service.IUrlService;
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
public class UrlServiceImpl extends ServiceImpl<UrlMapper, Url> implements IUrlService {


}

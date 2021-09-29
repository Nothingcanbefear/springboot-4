package com.ggg.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ggg.mybatisplus.MybatisPlusApplication1;
import com.ggg.mybatisplus.common.ResultMap;
import com.ggg.mybatisplus.dto.UserDto;
import com.ggg.mybatisplus.dto.UserInfoVo;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.entity.UserInfo;
import com.ggg.mybatisplus.mapper.UserInfoMapper;
import com.ggg.mybatisplus.mapper.UserMapper;
import com.ggg.mybatisplus.myenum.InfoEnum;
import com.ggg.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    public ResultMap<List<User>> selectUserByIdOrNameOrEmail(UserDto dto) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId, dto.getId()).or().eq(User::getName, dto.getName())
                .or().eq(User::getEmail, dto.getEmail());
        List<User> users = userMapper.selectList(wrapper);


        if (dto.getPageNumber() == null || dto.getPageSize() == null)
            dto.setPageNumber(1).setPageSize(10);

        PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());

        ResultMap<List<User>> map = new ResultMap<>();

        PageInfo<User> userPageInfo = new PageInfo<>(users);
        if ( CollectionUtils.isEmpty(users)) {
            return map.setCode(InfoEnum.INFO_FAILED.getCode()).setMessage(InfoEnum.INFO_FAILED.getMessage());
        } else {
            return map.setCode(InfoEnum.INFO_SUCCESS.getCode()).setMessage(InfoEnum.INFO_SUCCESS.getMessage()).setPageInfo(userPageInfo);
        }
    }

    /**
     * 插入
     * 信息
     */
    public ResultMap insertUser(UserDto dto) {
        dto = Optional.ofNullable(dto).orElseThrow(() -> new RuntimeException("请传入正确的dto"));
        User user = new User();
        user.setId(dto.getId()).setName(dto.getName()).setAge(dto.getAge())
                .setEmail(dto.getEmail());
        ResultMap<Object> map = new ResultMap<>();
        int insert = 0;
        try {
            insert = userMapper.insert(user);
        } catch (Exception sql) {
            log.error("插入失败{}", sql.getCause().toString());
            return map.setCode(InfoEnum.INSERT_FAILED.getCode()).setMessage(sql.getCause().toString());
        }

        if (insert < 0) {
            return map.setCode(InfoEnum.INSERT_FAILED.getCode()).setMessage(InfoEnum.INSERT_FAILED.getMessage());
        } else {
            return map.setCode(InfoEnum.INSERT_SUCCESS.getCode()).setMessage(InfoEnum.INFO_SUCCESS.getMessage());
        }
    }

    @Async("resolveAsync")
    public void resolve() {
        synchronized (MybatisPlusApplication1.class) {
            for (int i = 0; i <= 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("正在解析，解析进度..." + i + "0%");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public ResultMap updateUserById(UserDto dto) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        dto = Optional.ofNullable(dto).orElseThrow(() -> new RuntimeException("对象为空"));
        User user = userMapper.selectById(dto.getId());
        user.setName(dto.getName()).setEmail(dto.getEmail())
                .setAge(dto.getAge()).setId(dto.getId());
        wrapper.eq(User::getId, user.getId());
        ResultMap<Object> map = new ResultMap<>();
        int update=-1;
        try {
            update = userMapper.updateById(user);
        }catch (Exception e){
            log.error("更新失败{}",e.getCause());
        }
        if (update < 0) {
            return map.setCode(InfoEnum.UPDATE_FAILED.getCode()).setMessage(InfoEnum.UPDATE_FAILED.getMessage());
        } else {
            return map.setCode(InfoEnum.UPDATE_SUCCESS.getCode()).setMessage(InfoEnum.UPDATE_SUCCESS.getMessage());
        }

    }

    public UserInfo queryUserInfoById(Integer age){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getAge,age);

        List<User> users = userMapper.selectList(wrapper);
        HashMap<String, Object> map = new HashMap<>();

        for (User user : users) {
            map.put("user_id",user.getId());
        }

        List<UserInfo> userInfos = userInfoMapper.selectByMap(map);



        UserInfoVo userInfoVo = new UserInfoVo();

        userInfos.forEach(System.out::print);

        return null;
    }


    @Transactional(rollbackFor = Exception.class)
    public void mulInsert(){
        for (int i = 0; i < 100000; i++) {
            User user = new User();
            String str=Integer.toString(i);
            user.setId(Long.valueOf(13+i)).setEmail("ggg"+str+"@ggg"+str+".com")
                    .setName(str).setAge((i+18)%60).setVersion(1);

            userMapper.insert(user);
        }
    }

    public List<User> selectUserByName(String name){
        return userMapper.selectList(new QueryWrapper<User>().lambda().eq(User::getName, name));
    }
}

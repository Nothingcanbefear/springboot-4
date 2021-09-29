package com.ggg.mybatisplus.controller;


import com.ggg.mybatisplus.annotation.AopAnnotation;
import com.ggg.mybatisplus.common.ResultMap;
import com.ggg.mybatisplus.dto.UserDto;
import com.ggg.mybatisplus.entity.User;
import com.ggg.mybatisplus.exception.MyException;
import com.ggg.mybatisplus.myenum.InfoEnum;
import com.ggg.mybatisplus.service.impl.UserServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2021-09-15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/all")
    public List<User> getAllUser(){
      return  userService.getAllUser();
    }

    @PostMapping("/or")
    @AopAnnotation
    public ResultMap<List<User>> selectByIdOrNameOrEmail(@RequestBody UserDto dto){
        Optional.ofNullable(dto.getName())
                .orElseThrow(()->new MyException("姓名不能为空",202));
        return userService.selectUserByIdOrNameOrEmail(dto);
    }

    @PostMapping("/insert")
    public ResultMap insertUser(@RequestBody UserDto dto){
        return userService.insertUser(dto);
    }


//    @GetMapping("/test/{id}")
//    public Integer testSync(@PathVariable("id")Integer id){
//
//        ExecutorService pool = Executors.newFixedThreadPool(2);
//        ThreadTasks threadTasks = new ThreadTasks();
//        threadTasks.setId(id);
//        pool.execute(threadTasks);
//        return threadTasks.getId();
//    }

    @GetMapping("/test/{id}")
    public String  test(@PathVariable("id")Integer id){
        userService.resolve();
        System.out.println(Thread.currentThread().getName());
        return "上传成功";
    }

    @PostMapping("/update")
    public ResultMap updateUser(@RequestBody UserDto dto){
        return userService.updateUserById(dto);
    }

    @PostMapping("/test1")
    public String test1(@RequestParam(value = "id",required = true) String name1){
        Optional.ofNullable(name1).filter((e)-> StringUtils.isNotBlank(e)).
                orElseThrow(()->new RuntimeException("failed"));
        System.out.println(name1);
        return name1;
    }

    @GetMapping("/minsert")
    public String mulInsert(){
        userService.mulInsert();
        return "SUCCESS";
    }

    @GetMapping("/name")
    public ResultMap<List<User>> selectUserByName(@RequestHeader String name){
        List<User> users = userService.selectUserByName(name);

        ResultMap<List<User>> userResultMap = new ResultMap<>();
        userResultMap.setCode(InfoEnum.INSERT_SUCCESS.getCode()).setMessage(InfoEnum.INSERT_SUCCESS.getMessage())
                .setData(users);

        return userResultMap;
    }
}


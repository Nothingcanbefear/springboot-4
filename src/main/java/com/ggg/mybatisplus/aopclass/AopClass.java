package com.ggg.mybatisplus.aopclass;

import com.ggg.mybatisplus.common.ResultMap;
import com.ggg.mybatisplus.dto.UserDto;
import com.ggg.mybatisplus.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class AopClass {

    @Pointcut("@annotation(com.ggg.mybatisplus.annotation.AopAnnotation)")
    private void pointMyCut(){}

    @Order(0)
    @Around("pointMyCut()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("======================");

        Object[] args = joinPoint.getArgs();
        UserDto arg = (UserDto) args[0];
        System.out.println(arg.getEmail());
        Object target = joinPoint.getTarget();
        ResultMap<List<User>> obj= (ResultMap<List<User>>) joinPoint.proceed();
        obj.setMessage("这是我修改后的版本");

        obj.setCode(202);

        return obj;
    }
}

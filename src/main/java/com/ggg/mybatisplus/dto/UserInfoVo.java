package com.ggg.mybatisplus.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    private String address;

    private String career;

    private String name;

    private Integer age;

    private String email;
}

package com.ggg.mybatisplus.dto;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private Integer pageSize;

    private Integer pageNumber;

    @Version
    private Integer version;
}

package com.ggg.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName(value = "token_log")
@Accessors(chain = true)
public class TokenLog {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

    @TableField("token")
    private String token;

    @TableField("name")
    private String name;

    @TableField("email")
    private String email;
}

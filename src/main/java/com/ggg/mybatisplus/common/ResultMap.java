package com.ggg.mybatisplus.common;

import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ResultMap<T> {
    private Integer code;

    private String message;

    private PageInfo pageInfo;

    private T data;

    private String aop;


    public ResultMap(Integer code,String message){
        this(code,message,null,null,null);
    }
}

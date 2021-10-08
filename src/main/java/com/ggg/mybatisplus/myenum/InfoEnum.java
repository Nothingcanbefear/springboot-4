package com.ggg.mybatisplus.myenum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum InfoEnum {

    INFO_SUCCESS("SUCCESS",200),
    INFO_FAILED("FAILED",444),
    INFO_NOTNET("NETERR",400),
    INSERT_FAILED("INSERT FAILED",401),
    INSERT_SUCCESS("INSERT SUCCESS",201),
    UPDATE_SUCCESS("UPDATE SUCCESS",202),
    UPDATE_FAILED("UPDATE FAILED",402),
    LOGIN_FAILED("LOGIN FAILED",403),
    LOGIN_SUCCESS("LOGIN SUCCESS",203);

    private String message;

    private Integer code;

    public String getMessage(){
        return this.message;
    }

    public Integer getCode(){
        return this.code;
    }

}

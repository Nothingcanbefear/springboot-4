package com.ggg.mybatisplus.myenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum InfoEnum {

    INFO_SUCCESS("SUCCESS",200),
    INFO_FAILED("FAILED",444),
    INFO_NOTNET("NETERR",400),
    INSERT_FAILED("INSERT FAILED",401),
    INSERT_SUCCESS("INSERT SUCCESS",201),
    UPDATE_SUCCESS("UPDATE SUCCESS",202),
    UPDATE_FAILED("UPDATE FAILED",402);

    private String message;

    private Integer code;

}

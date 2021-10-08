package com.ggg.mybatisplus.dto;

import com.ggg.mybatisplus.myenum.InfoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Builder
@Data
@Accessors(chain = true)
public class AopDto {
    private String txt;

   private InfoEnum mage;
}

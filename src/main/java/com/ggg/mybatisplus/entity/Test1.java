package com.ggg.mybatisplus.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test1 {
    private String name;

    private String email;


    public void test1(String name,String email){
        this.name=name;
        this.email=email;
    }

}

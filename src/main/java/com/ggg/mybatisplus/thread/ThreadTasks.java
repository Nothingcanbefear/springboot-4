package com.ggg.mybatisplus.thread;

import com.ggg.mybatisplus.MybatisPlusApplication1;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ThreadTasks implements Runnable{

    private Integer id;

    @Override
    public void run() {
        synchronized (MybatisPlusApplication1.class){
            for (int i = 0; i <10 ; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("这是前端传来的ID="+ ++id);
            }
        }
    }
}

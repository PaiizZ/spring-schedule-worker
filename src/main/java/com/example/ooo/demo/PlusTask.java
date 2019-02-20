package com.example.ooo.demo;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.api.annotation.RInject;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class PlusTask implements Callable<Long>, Serializable {

    @RInject
    private RedissonClient redissonClient;

    private String aaa = "";
    private String bbb = "";

    public PlusTask(String aaa, String bbb) {
        this.aaa = aaa;
        this.bbb = bbb;
    }

    @Override
    public Long call() throws Exception {
        RMap<String, Integer> map = redissonClient.getMap("myMap");
        System.out.println(aaa + bbb);
        System.out.println("wtf");
        Long result = 0L;
        for (Integer value : map.values()) {
            result += value;
        }
        return result;
    }

}

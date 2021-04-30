package com.zsl.dybkm;

import com.zsl.dybkm.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {

    @Autowired
    private RedisUtil redisUtil;


    @Test
    public void redisTest(){
        redisUtil.set("haha","张三");
    }
}

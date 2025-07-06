package com.yupi.usercenter.service;

import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest
{
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void test()
    {
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        ListOperations listOperations = redisTemplate.opsForList();
        valueOperations.set("yupiString", "yupi");
        valueOperations.set("yupiInteger", 1);
        valueOperations.set("yupiDouble", 1.0);
        valueOperations.set("yupiBoolean", true);
        User user = new User();
        user.setId(1L);
        user.setUsername("yupi");
        valueOperations.set("yupiUser", user);

        Object yupiString = valueOperations.get("yupiString");
        Assertions.assertEquals("yupi", yupiString);
        Object yupiInteger = valueOperations.get("yupiInteger");
        Assertions.assertEquals(1, yupiInteger);
        Object yupiDouble = valueOperations.get("yupiDouble");
        Assertions.assertEquals(1.0, yupiDouble);
        Object yupiBoolean = valueOperations.get("yupiBoolean");
        Assertions.assertEquals(true, yupiBoolean);
        Object yupiUser = valueOperations.get("yupiUser");
        Assertions.assertEquals(user, yupiUser);
        redisTemplate.delete("yupiString");
    }
}

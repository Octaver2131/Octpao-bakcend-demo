package com.yupi.usercenter.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.usercenter.model.domain.User;
import javafx.scene.control.RadioMenuItem;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void RedissonRest() {
        // list, 数据存在本地 JVM 内存中
        List<String> list = new ArrayList<>();
        list.add("yupi");
        System.out.println("list:" + list.get(0));
        list.remove(0);
        // list, 数据存在 Redis 内存中
        RList<String> rList = redissonClient.getList("test-list");
        rList.add("yupi");
        System.out.println("rlist:" + rList.get(0));
        rList.remove(0);

        // map
        Map<String, Integer> map = new HashMap<>();
        map.put("yupi", 10);
        System.out.println("map:" + map.get("yupi"));

        RMap<String, Integer> rMap = redissonClient.getMap("test-map");
        rMap.put("yupi", 10);
        System.out.println("rmap:" + rMap.get("yupi"));

        // set

        //stack
    }

    @Test
    void testWatchDog() {
        RLock lock = redissonClient.getLock("yupao:precachejob:docache:lock");
        try {
            // 只有一个线程能获取到锁
            if (lock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                Thread.sleep(300000);
                System.out.println("getLock: " + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            // 确保释放锁
            if (lock.isHeldByCurrentThread()) {
                System.out.println("unLock: " + Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}

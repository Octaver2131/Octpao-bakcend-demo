package com.yupi.usercenter.service;

import com.yupi.usercenter.mapper.UserMapper;
import com.yupi.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUserTest {

    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(40, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户
     *
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeyupi");
            user.setAvatarUrl("https://avatars.githubusercontent.com/u/199230757?v=4");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("111 111 1111");
            user.setEmail("111@outlook.com");
            user.setUserStatus(0);
            user.setIsDelete(0);
            user.setUserRole(0);
            user.setPlanetCode("0");
            if (i % 4 == 0) {
                user.setTags("[\"女\", \"Java\"]");
            } else if (i % 4 == 1) {
                user.setTags("[\"男\", \"Python\"]");
            }
            else if (i % 4 == 2) {
                user.setTags("[\"女\", \"C++\"]");
            }
            else {
                user.setTags("[\"男\", \"Go\"]");
            }
            userList.add(user);
        }
        userService.saveBatch(userList,50000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     *
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        // 分十组
        int batchSize = 10000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假用户");
                user.setUserAccount("fakeyupi");
                user.setAvatarUrl("https://avatars.githubusercontent.com/u/199230757?v=4");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("111 111 1111");
                user.setEmail("111@outlook.com");
                user.setUserStatus(0);
                user.setIsDelete(0);
                user.setUserRole(0);
                user.setPlanetCode("0");
                if (i % 4 == 0) {
                    user.setTags("[\"女\", \"Java\"]");
                } else if (i % 4 == 1) {
                    user.setTags("[\"男\", \"Python\"]");
                } else if (i % 4 == 2) {
                    user.setTags("[\"女\", \"C++\"]");
                } else {
                    user.setTags("[\"男\", \"Go\"]");
                }
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            // 异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("thread name: " + Thread.currentThread().getName());
                userService.saveBatch(userList,10000);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}

package com.yupi.usercenter.once;
import java.util.Date;

import com.yupi.usercenter.mapper.UserMapper;
import com.yupi.usercenter.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class InsertUsers {

    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     *
     */
    // @Scheduled(initialDelay = 5000, fixedRate = Long.MAX_VALUE)
    public void doInsertUsers() {
        System.out.println("插入完成");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
//        final int INSERT_NUM = 1000;
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUsername("假用户");
//            user.setUserAccount("fakeyupi");
//            user.setAvatarUrl("https://avatars.githubusercontent.com/u/199230757?v=4");
//            user.setGender(0);
//            user.setUserPassword("12345678");
//            user.setPhone("111 111 1111");
//            user.setEmail("111@outlook.com");
//            user.setUserStatus(0);
//            user.setIsDelete(0);
//            user.setUserRole(0);
//            user.setPlanetCode("0");
//            user.setTags("");
//            userMapper.insert(user);
//        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}

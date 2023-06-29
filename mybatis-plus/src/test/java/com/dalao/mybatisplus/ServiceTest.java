package com.dalao.mybatisplus;

import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Resource
    UserService userService;

    @Test
    public void testCount(){

        int count = userService.count();
        System.out.println(count);

    }

    @Test
    public void testSaveBatch(){

        ArrayList<User> users = new ArrayList<>();

        int age = 16;
        for (int i = 0; i <=5; i++){
            User user = new User();
            user.setName("大佬N" + i);
            age = age*10 + 8;
            user.setAge(age);
            users.add(user);
        }
        boolean b = userService.saveBatch(users);
        System.out.println(b);

    }


    @Test
    public void testSelectAllByName(){

        List<User> users = userService.selectAllByName("大佬");

        users.forEach(System.out::println);

    }
}

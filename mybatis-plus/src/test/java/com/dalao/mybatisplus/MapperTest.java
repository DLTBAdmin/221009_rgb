package com.dalao.mybatisplus;

import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("细佬");
        user.setAge(18);
        user.setEmail("18888888@168.com");
//        user.setCreateTime(LocalDateTime.now());
//        user.setUpdateTime(LocalDateTime.now());
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
        User user = userMapper.selectById(1);
        System.out.println(user);

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testUpdate(){

        User user = new User();
        user.setId(1L);
        user.setAge(168);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testDelete(){
        Map map = new HashMap();
        map.put("username","大佬");

        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }


    @Test
    public void testSelectAllByName(){

        List<User> users = userMapper.selectAllByName("大佬");

        users.forEach(System.out::println);

    }
}

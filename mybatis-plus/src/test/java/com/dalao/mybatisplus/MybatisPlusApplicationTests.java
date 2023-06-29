package com.dalao.mybatisplus;

import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest//自动创建spring上下文环境
class MybatisPlusApplicationTests {

//    @Autowired
    @Resource
    private UserMapper userMapper;

    @Test
    void test() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }

}

package com.dalao.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class WrapperTests {
    @Resource
    UserMapper userMapper;

    /**
     * 查询名字中包含n，年龄大于等于168且小于等于1688888，email不为空的用户
     * */
    @Test
    public void test01(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("username","n")
                .between("age",168,1688888);

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test2(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.orderByAsc("age").orderByAsc("id");

        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test3(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int result =userMapper.delete(queryWrapper);
        System.out.println(result);
    }

    @Test
    public void test4(){

        //组装查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username","n")
                .and(i -> i.lt("age",168)
                .or().isNull("email"));

        //组装更新条件
        User user = new User();
        user.setAge(18);
        user.setEmail("user@168.com");

        //执行更新
        int result = userMapper.update(user, queryWrapper);
        System.out.println(result);


    }

    @Test
    public void test7(){

        //组装查询条件
        UpdateWrapper<User> updaterMapper = new UpdateWrapper<>();
        updaterMapper.set("age",18)
                .set("email","user@167.com")
                .like("username","n")
                .and(i -> i.le("age",18).or().isNull("email"));


//        //组装更新条件
//        User user = new User();
//        user.setAge(18);
//        user.setEmail("user@168.com");

        //执行更新
        int result = userMapper.update(null, updaterMapper);
        System.out.println(result);
    }

    /**
     * 查询
     * age在10-20之间
     * username带u
     * */
    @Test
    public void test8(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        String username= "u";
        Integer start = 10;
        Integer end = 20;

            queryWrapper
                    .like(StringUtils.isNotBlank(username),"username",username)
                    .ge(start != null,"age",start)
                    .le(end != null,"age",start);

        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }

    @Test
    public void test9(){

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        String username= "大";
        Integer start = 10;
        Integer end = 20;

        queryWrapper
                .like(StringUtils.isNotBlank(username),User::getName,username)
                .ge(start != null,User::getAge,start)
                .le(end != null,User::getAge,start);

        List<User> users = userMapper.selectList(queryWrapper);

        users.forEach(System.out::println);
    }
}

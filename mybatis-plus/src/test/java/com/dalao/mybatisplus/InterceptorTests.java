package com.dalao.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dalao.mybatisplus.entity.Product;
import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.mapper.ProductMapper;
import com.dalao.mybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTests {

    @Resource
    UserMapper userMapper;

    @Resource
    ProductMapper productMapper;

    @Test
    public void testConcurrentUpdate(){

        //小李取数据
        Product product1 = productMapper.selectById(1L);

        //小王取数据
        Product product2 = productMapper.selectById(1L);

        //小李改数据 +50
        product1.setPrice(product1.getPrice() + 50);
        int result1 = productMapper.updateById(product1);

        //小王改数据 -30
        product2.setPrice(product2.getPrice() - 30);
        int result2 = productMapper.updateById(product2);

        //老板看价格
        Product product3 = productMapper.selectById(1L);
        System.out.println(product3);
    }

    @Test
    public void testSelectPage(){

        Page<User> pageParam = new Page<>(1, 5);
        userMapper.selectPage(pageParam, null);
        List<User> users = pageParam.getRecords();
        users.forEach(System.out::println);

        long total = pageParam.getTotal();
        System.out.println(total);

        boolean next = pageParam.hasNext();
        System.out.println("是否有下一页" + next);

        boolean previous = pageParam.hasPrevious();
        System.out.println("是否有上一页" + previous);

    }

    @Test
    public void testSelectPageById(){
        Page<User> userPage = new Page<>(1, 5);
        userMapper.selectPageByPage(userPage,50);
        List<User> users = userPage.getRecords();
        users.forEach(System.out::println);
    }

}

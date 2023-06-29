package com.dalao.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dalao.mybatisplus.entity.User;
import com.dalao.mybatisplus.mapper.UserMapper;
import com.dalao.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

/*
    @Resource
    private UserMapper userMapper;
*/

    @Override
    public List<User> selectAllByName(String name) {
        return baseMapper.selectAllByName(name);
    }
}

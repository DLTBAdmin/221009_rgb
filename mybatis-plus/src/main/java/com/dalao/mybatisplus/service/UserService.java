package com.dalao.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dalao.mybatisplus.entity.User;

import java.util.List;

public interface UserService extends IService<User> {

    List<User> selectAllByName(String name);


}

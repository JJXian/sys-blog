package com.example.service;

import com.example.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UserService {

    void add(User user);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    User selectById(Integer id);

    List<User> selectAll(User user);

    PageInfo<User> selectPage(User user, Integer pageNum, Integer pageSize);

    void updateById(User user);
}

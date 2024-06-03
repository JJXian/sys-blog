package com.example.user.mapper;

import com.example.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    void insert(User user);

    User selectByUsername(String username);

    void deleteById(Integer id);

    void updateById(User user);

    User selectById(Integer id);

    List<User> selectAll(User user);

}

package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Blog;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Set;

public interface BlogService extends IService<Blog> {
    void add(Blog blog);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    boolean updateById(Blog blog);

    void updateReadCount(Integer blogId);

    Blog selectById(Integer id);

    List<Blog> selectAll(Blog blog);

    PageInfo<Blog> selectPage(Blog blog, Integer pageNum, Integer pageSize);

    PageInfo<Blog> selectUser(Blog blog, Integer pageNum, Integer pageSize);

    PageInfo<Blog> selectLike(Blog blog, Integer pageNum, Integer pageSize);

    PageInfo<Blog> selectCollect(Blog blog, Integer pageNum, Integer pageSize);

    PageInfo<Blog> selectComment(Blog blog, Integer pageNum, Integer pageSize);

    List<Blog> selectTop();

    Set<Blog> selectRecommend(Integer blogId);
}

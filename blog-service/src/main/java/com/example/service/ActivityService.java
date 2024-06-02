package com.example.service;

import com.example.entity.Activity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ActivityService {
    void add(Activity activity);

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);

    void updateById(Activity activity);

    void updateReadCount(Integer activityId);

    Activity selectById(Integer id);

    List<Activity> selectAll(Activity activity);

    PageInfo<Activity> selectPage(Activity activity, Integer pageNum, Integer pageSize);

    PageInfo<Activity> selectUser(Activity activity, Integer pageNum, Integer pageSize);

    PageInfo<Activity> selectLike(Activity activity, Integer pageNum, Integer pageSize);

    PageInfo<Activity> selectCollect(Activity activity, Integer pageNum, Integer pageSize);

    PageInfo<Activity> selectComment(Activity activity, Integer pageNum, Integer pageSize);

    List<Activity> selectTop();
}

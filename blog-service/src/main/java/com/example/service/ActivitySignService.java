package com.example.service;

import com.example.entity.ActivitySign;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ActivitySignService {
    void add(ActivitySign activitySign);

    void deleteById(Integer id);

    void userDelete(Integer activityId, Integer useId);

    void deleteBatch(List<Integer> ids);

    PageInfo<ActivitySign> selectPage(ActivitySign activitySign, Integer pageNum, Integer pageSize);
}

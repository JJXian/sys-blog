package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Likes;

public interface LikesService extends IService<Likes> {
    void set(Likes likes);

    int selectByFidAndModule(Integer id, String value);

    Likes selectUserLikes(Integer id, String value);
}

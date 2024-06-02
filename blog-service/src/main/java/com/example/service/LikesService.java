package com.example.service;

import com.example.entity.Likes;

public interface LikesService {
    void set(Likes likes);

    int selectByFidAndModule(Integer id, String value);

    Likes selectUserLikes(Integer id, String value);
}

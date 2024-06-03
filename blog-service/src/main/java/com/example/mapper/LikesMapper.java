package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Likes;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LikesMapper extends BaseMapper<Likes> {

//    void insert(Likes likes);

    Likes selectUserLikes(Likes likes);

//    void deleteById(Integer id);

    int selectByFidAndModule(@Param("fid") Integer fid, @Param("module") String module);
}

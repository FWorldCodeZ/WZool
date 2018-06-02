package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.ZoolPhotos;

public interface ZoolPhotosMapper {
    int deleteByPrimaryKey(Integer photoId);

    int insert(ZoolPhotos record);

    int insertSelective(ZoolPhotos record);

    ZoolPhotos selectByPrimaryKey(Integer photoId);

    int updateByPrimaryKeySelective(ZoolPhotos record);

    int updateByPrimaryKey(ZoolPhotos record);
}
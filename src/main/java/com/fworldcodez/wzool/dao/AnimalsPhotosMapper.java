package com.fworldcodez.wzool.dao;

import com.fworldcodez.wzool.pojo.AnimalsPhotos;

public interface AnimalsPhotosMapper {
    int deleteByPrimaryKey(Integer anPhotoId);

    int insert(AnimalsPhotos record);

    int insertSelective(AnimalsPhotos record);

    AnimalsPhotos selectByPrimaryKey(Integer anPhotoId);

    int updateByPrimaryKeySelective(AnimalsPhotos record);

    int updateByPrimaryKey(AnimalsPhotos record);
}
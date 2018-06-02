package com.fworldcodez.wzool.pojo;

public class AnimalsPhotos {
    private Integer anPhotoId;

    private Integer anId;

    private String photosName;

    private String anPhotos;

    public Integer getAnPhotoId() {
        return anPhotoId;
    }

    public void setAnPhotoId(Integer anPhotoId) {
        this.anPhotoId = anPhotoId;
    }

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getPhotosName() {
        return photosName;
    }

    public void setPhotosName(String photosName) {
        this.photosName = photosName == null ? null : photosName.trim();
    }

    public String getAnPhotos() {
        return anPhotos;
    }

    public void setAnPhotos(String anPhotos) {
        this.anPhotos = anPhotos == null ? null : anPhotos.trim();
    }
}
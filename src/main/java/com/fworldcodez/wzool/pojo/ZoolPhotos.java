package com.fworldcodez.wzool.pojo;

public class ZoolPhotos {
    private Integer photoId;

    private String photos;

    private String photosName;

    private Integer zoolId;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos == null ? null : photos.trim();
    }

    public String getPhotosName() {
        return photosName;
    }

    public void setPhotosName(String photosName) {
        this.photosName = photosName == null ? null : photosName.trim();
    }

    public Integer getZoolId() {
        return zoolId;
    }

    public void setZoolId(Integer zoolId) {
        this.zoolId = zoolId;
    }
}
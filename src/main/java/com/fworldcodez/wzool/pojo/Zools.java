package com.fworldcodez.wzool.pojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Zools extends PageBean implements Serializable {
    private Integer zoolId;

    private String zoolName;

    private String zoolDescription;

    private String url;

    private String address;

    private String emial;

    private String type;

    private String startLevel;

    private Date creationTime;

    private List<Cards> cardsList=new ArrayList<>();

    private List<ZoolPhotos> zoolPhotosList=new ArrayList<>();

    public List<Cards> getCardsList() {
        return cardsList;
    }

    public void setCardsList(List<Cards> cardsList) {
        this.cardsList = cardsList;
    }




    public Integer getZoolId() {
        return zoolId;
    }

    public void setZoolId(Integer zoolId) {
        this.zoolId = zoolId;
    }

    public String getZoolName() {
        return zoolName;
    }

    public void setZoolName(String zoolName) {
       // System.out.println("zoolName:"+zoolName);
        this.zoolName = zoolName == null ? null : zoolName.trim();
    }

    public String getZoolDescription() {
        return zoolDescription;
    }

    public void setZoolDescription(String zoolDescription) {
        this.zoolDescription = zoolDescription == null ? null : zoolDescription.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial == null ? null : emial.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(String startLevel) {
        this.startLevel = startLevel == null ? null : startLevel.trim();
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public List<ZoolPhotos> getZoolPhotosList() {
        return zoolPhotosList;
    }

    public void setZoolPhotosList(List<ZoolPhotos> zoolPhotosList) {
        this.zoolPhotosList = zoolPhotosList;
    }
}
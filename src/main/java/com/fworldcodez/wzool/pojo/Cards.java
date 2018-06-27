package com.fworldcodez.wzool.pojo;

import java.util.Date;

public class Cards {
    private Integer cardId;

    private String cardTitle;

    private String cardDescription;

    private Integer zoolId;

    private Integer cardPrice;

    private Integer cardOrtginalPrice;

    private String startTime;

    private String endTime;

    private Long addTime;

    private String cardPhoto;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle == null ? null : cardTitle.trim();
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription == null ? null : cardDescription.trim();
    }

    public Integer getZoolId() {
        return zoolId;
    }

    public void setZoolId(Integer zoolId) {
        this.zoolId = zoolId;
    }

    public Integer getCardPrice() {
        return cardPrice;
    }

    public void setCardPrice(Integer cardPrice) {
        this.cardPrice = cardPrice;
    }

    public Integer getCardOrtginalPrice() {
        return cardOrtginalPrice;
    }

    public void setCardOrtginalPrice(Integer cardOrtginalPrice) {
        this.cardOrtginalPrice = cardOrtginalPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(String cardPhoto) {
        this.cardPhoto = cardPhoto == null ? null : cardPhoto.trim();
    }
}
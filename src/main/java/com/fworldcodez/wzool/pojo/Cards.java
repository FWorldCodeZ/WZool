package com.fworldcodez.wzool.pojo;

import java.util.Date;

public class Cards {
    private Integer cardId;

    private Integer cardDescription;

    private Integer zoolId;

    private Integer cardPrice;

    private Integer cardOrtginalPrice;

    private Date startTime;

    private Date endTime;

    private String cardPhoto;

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(Integer cardDescription) {
        this.cardDescription = cardDescription;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCardPhoto() {
        return cardPhoto;
    }

    public void setCardPhoto(String cardPhoto) {
        this.cardPhoto = cardPhoto == null ? null : cardPhoto.trim();
    }
}
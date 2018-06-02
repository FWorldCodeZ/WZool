package com.fworldcodez.wzool.pojo;

import java.math.BigDecimal;

public class Animals {
    private Integer anId;

    private String anName;

    private String anDescription;

    private String anAge;

    private String anType;

    private BigDecimal anPrice;

    private String url;

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getAnName() {
        return anName;
    }

    public void setAnName(String anName) {
        this.anName = anName == null ? null : anName.trim();
    }

    public String getAnDescription() {
        return anDescription;
    }

    public void setAnDescription(String anDescription) {
        this.anDescription = anDescription == null ? null : anDescription.trim();
    }

    public String getAnAge() {
        return anAge;
    }

    public void setAnAge(String anAge) {
        this.anAge = anAge == null ? null : anAge.trim();
    }

    public String getAnType() {
        return anType;
    }

    public void setAnType(String anType) {
        this.anType = anType == null ? null : anType.trim();
    }

    public BigDecimal getAnPrice() {
        return anPrice;
    }

    public void setAnPrice(BigDecimal anPrice) {
        this.anPrice = anPrice;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
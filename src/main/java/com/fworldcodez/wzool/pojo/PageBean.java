package com.fworldcodez.wzool.pojo;

public class PageBean {
    private int pageNumber=100;//当前页记录大小
    private int pageNow=1;//当前页

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }
}

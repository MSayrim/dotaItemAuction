package com.example.dotaitemauction.Models;

import java.util.Date;

public class SaleItemModel {

    private Integer itemID;
    private Date createDate;
    private Date updateDate;
    private Date deleteDate;
    private boolean isActive;
    private String name;
    private String tumbnail;
    private String Video;
    private Integer sellerID;
    private String paymentType;
    private Float price;
    private Integer stock;

    public SaleItemModel() {
    }

    public SaleItemModel(Integer itemID, Date createDate, Date updateDate, Date deleteDate, boolean isActive, String name, String tumbnail, String video, Integer sellerID, String paymentType, Float price, Integer stock) {
        this.itemID = itemID;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.deleteDate = deleteDate;
        this.isActive = isActive;
        this.name = name;
        this.tumbnail = tumbnail;
        Video = video;
        this.sellerID = sellerID;
        this.paymentType = paymentType;
        this.price = price;
        this.stock = stock;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(Date deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTumbnail() {
        return tumbnail;
    }

    public void setTumbnail(String tumbnail) {
        this.tumbnail = tumbnail;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}

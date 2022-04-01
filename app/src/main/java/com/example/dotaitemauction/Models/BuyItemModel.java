package com.example.dotaitemauction.Models;

public class BuyItemModel {
    private String sellerId;
    private String buyerId;
    private String paymentMethod;
    private String price;
    private String count;
    private String itemId;
    private String dogrulamaKodu;

    public BuyItemModel(String sellerId, String buyerId, String paymentMethod, String price, String count, String itemId, String dogrulamaKodu) {
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.paymentMethod = paymentMethod;
        this.price = price;
        this.count = count;
        this.itemId = itemId;
        this.dogrulamaKodu = dogrulamaKodu;
    }

    @Override
    public String toString() {
        return "BuyItemModel{" +
                "sellerId='" + sellerId + '\'' +
                ", buyerId='" + buyerId + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", price='" + price + '\'' +
                ", count='" + count + '\'' +
                ", itemId='" + itemId + '\'' +
                ", dogrulamaKodu='" + dogrulamaKodu + '\'' +
                '}';
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDogrulamaKodu() {
        return dogrulamaKodu;
    }

    public void setDogrulamaKodu(String dogrulamaKodu) {
        this.dogrulamaKodu = dogrulamaKodu;
    }
}

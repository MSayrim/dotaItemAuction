package com.example.dotaitemauction.Models;

public class BuyedItemPojo {
    private String itemName;
    private String sellerSteamId;
    private String buyerSteamId;
    private int itemRated;
    private String sellerId;
    private String buyerId;
    private String itemId;


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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getItemRated() {
        return itemRated;
    }

    public void setItemRated(int itemRated) {
        this.itemRated = itemRated;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setSellerSteamId(String sellerSteamId) {
        this.sellerSteamId = sellerSteamId;
    }

    public String getSellerSteamId() {
        return sellerSteamId;
    }

    public void setBuyerSteamId(String buyerSteamId) {
        this.buyerSteamId = buyerSteamId;
    }

    public String getBuyerSteamId() {
        return buyerSteamId;
    }

    @Override
    public String toString() {
        return
                "BuyedItemPojo{" +
                        "itemName = '" + itemName + '\'' +
                        ",sellerSteamId = '" + sellerSteamId + '\'' +
                        ",buyerSteamId = '" + buyerSteamId + '\'' +
                        ",itemRated = '" + itemRated + '\'' +
                        "}";
    }
}

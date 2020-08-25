package com.example.dotaitemauction.Models;

public class MarketItem {
    private String itemName;
    private String itemStock;
    private Integer itemTumbnail;

    public MarketItem(String itemName, String itemStock, Integer itemTumbnail) {
        this.itemName = itemName;
        this.itemStock = itemStock;
        this.itemTumbnail = itemTumbnail;
    }



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemStock() {
        return itemStock;
    }

    public void setItemStock(String itemStock) {
        this.itemStock = itemStock;
    }

    public Integer getItemTumbnail() {
        return itemTumbnail;
    }

    public void setItemTumbnail(Integer itemTumbnail) {
        this.itemTumbnail = itemTumbnail;
    }
}

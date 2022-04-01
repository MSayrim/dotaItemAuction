package com.example.dotaitemauction.Models;

public class ItemIdModel {

    private String itemId;
    private String itemName;

    public ItemIdModel(String itemId, String itemName) {
        this.itemName = itemName;
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}

package com.example.dotaitemauction.Models;

public class ItemIdModel {
    String itemName;
    String itemId;

    public ItemIdModel(String itemName, String itemId) {
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

package com.example.dotaitemauction.Models;

public class MarketItemCountPojo {
    private String id;
    private String count;

    public String getId() {
        return id;
    }

    public String getCount() {
        return count;
    }

    @Override
    public String toString() {
        return
                "MarketItemCountPojo{" +
                        "itemId = '" + id + '\'' +
                        ",itemCount = '" + count + '\'' +
                        "}";
    }
}

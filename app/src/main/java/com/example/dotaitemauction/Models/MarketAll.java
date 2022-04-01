package com.example.dotaitemauction.Models;

public class MarketAll {
    private String id;
    private String name;
    private String tumbnail;
    private String itemHero;
    private String itemGame;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTumbnail() {
        return tumbnail;
    }

    public String getItemHero() {
        return itemHero;
    }

    public String getItemGame() {
        return itemGame;
    }

    @Override
    public String toString() {
        return
                "MarketAll{" +
                        "id = '" + id + '\'' +
                        ",name = '" + name + '\'' +
                        ",tumbnail = '" + tumbnail + '\'' +
                        ",itemHero = '" + itemHero + '\'' +
                        ",itemGame = '" + itemGame + '\'' +
                        "}";
    }
}

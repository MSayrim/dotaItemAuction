package com.example.dotaitemauction.Models;

public class MarketAll{
	private String productGame;
	private String productId;
	private String productPic;
	private String productHero;
	private String productName;

	public String getProductGame(){
		return productGame;
	}

	public String getProductId(){
		return productId;
	}

	public String getProductPic(){
		return productPic;
	}

	public String getProductHero(){
		return productHero;
	}

	public String getProductName(){
		return productName;
	}

	@Override
 	public String toString(){
		return 
			"MarketAll{" + 
			"productGame = '" + productGame + '\'' + 
			",productId = '" + productId + '\'' + 
			",productPic = '" + productPic + '\'' + 
			",productHero = '" + productHero + '\'' + 
			",productName = '" + productName + '\'' + 
			"}";
		}
}

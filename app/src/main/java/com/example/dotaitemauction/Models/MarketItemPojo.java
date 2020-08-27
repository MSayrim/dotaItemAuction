package com.example.dotaitemauction.Models;

public class MarketItemPojo{
	private String productSale;
	private String sellerNick;
	private String productId;
	private String method;
	private String rate;
	private String price;
	private String sellerId;
	private String productName;
	private String sellerSteamId;

	public String getProductSale(){
		return productSale;
	}

	public String getSellerNick(){
		return sellerNick;
	}

	public String getProductId(){
		return productId;
	}

	public String getMethod(){
		return method;
	}

	public String getRate(){
		return rate;
	}

	public String getPrice(){
		return price;
	}

	public String getSellerId(){
		return sellerId;
	}

	public String getProductName(){
		return productName;
	}

	public String getSellerSteamId(){
		return sellerSteamId;
	}

	@Override
 	public String toString(){
		return 
			"MarketItemPojo{" + 
			"productSale = '" + productSale + '\'' + 
			",sellerNick = '" + sellerNick + '\'' + 
			",productId = '" + productId + '\'' + 
			",method = '" + method + '\'' + 
			",rate = '" + rate + '\'' + 
			",price = '" + price + '\'' + 
			",sellerId = '" + sellerId + '\'' + 
			",productName = '" + productName + '\'' + 
			",sellerSteamId = '" + sellerSteamId + '\'' + 
			"}";
		}
}

package com.example.dotaitemauction.Models;

import java.util.Date;

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
	private String count;
	private String date;
	private String command;
	private String productImage;



	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getCount() {
		return count;
	}

	public String getDate() {		return date;
	}

	public void setDate(String date) {		this.date = date;
	}

	public void setProductSale(String productSale) {
		this.productSale = productSale;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setSellerSteamId(String sellerSteamId) {
		this.sellerSteamId = sellerSteamId;
	}

	public void setCount(String count) {
		this.count = count;
	}

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
			",count =  '" + count + '\'' +
					",date = '" + date+ '\'' +
			"}";
		}
}

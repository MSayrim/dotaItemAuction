package com.example.dotaitemauction.Models;

public class MarketItemCountPojo{
	private String itemId;
	private String itemCount;

	public String getItemId(){
		return itemId;
	}

	public String getItemCount(){
		return itemCount;
	}

	@Override
 	public String toString(){
		return 
			"MarketItemCountPojo{" + 
			"itemId = '" + itemId + '\'' + 
			",itemCount = '" + itemCount + '\'' + 
			"}";
		}
}

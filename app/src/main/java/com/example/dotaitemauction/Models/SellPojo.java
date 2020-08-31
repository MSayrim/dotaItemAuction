package com.example.dotaitemauction.Models;

public class SellPojo{
	private String result;
	private boolean tf;
	private String satisKodu;
	private int dogrulamaKodu;

	public String getResult(){
		return result;
	}

	public boolean isTf(){
		return tf;
	}

	public String getSatisKodu(){
		return satisKodu;
	}

	public int getDogrulamaKodu(){
		return dogrulamaKodu;
	}

	@Override
 	public String toString(){
		return 
			"SellPojo{" + 
			"result = '" + result + '\'' + 
			",tf = '" + tf + '\'' + 
			",satisKodu = '" + satisKodu + '\'' + 
			",dogrulamaKodu = '" + dogrulamaKodu + '\'' + 
			"}";
		}
}

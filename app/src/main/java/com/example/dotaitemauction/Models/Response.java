package com.example.dotaitemauction.Models;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("result")
	private String result;

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"result = '" + result + '\'' + 
			"}";
		}
}
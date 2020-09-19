package com.example.dotaitemauction.Models;

public class UserRate{
	private double rate;

	public double getRate(){
		return rate;
	}

	@Override
 	public String toString(){
		return 
			"UserRate{" + 
			"rate = '" + rate + '\'' + 
			"}";
		}
}

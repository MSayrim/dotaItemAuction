package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.Models.SellPojo;

import java.util.List;

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<LoginPojo> login(String userName , String userPass)
    {
        Call<LoginPojo> x = getRestApi ().loginControl (userName,userPass  );
        return x;
    }
    public Call<RegisterPojo> register(String userMail , String userPass, String userNick , String userSteamId)
    {
        Call<RegisterPojo> xy = getRestApi ().registerControl (userMail,userPass,userNick,userSteamId  );
        return xy;
    }

    public Call<List<MarketAll>> marketLoader()
    {
        Call<List<MarketAll>> xy = getRestApi ().marketAllItem ();
        return xy;
    }
    public Call<List<MarketItemPojo>> marketDetailLoader()
    {
        Call<List<MarketItemPojo>> xy = getRestApi ().marketLoad ();
        return xy;
    }

    public Call<List<MarketItemCountPojo>> marketItemCount()
    {
        Call<List<MarketItemCountPojo>> xy = getRestApi ().marketItemCount ();
        return xy;
    }

    public Call<SellPojo> sellItem(String itemId , String sellerId, String count , String paymentType , String price)
    {
        Call<SellPojo> xyz = getRestApi ().sellItem (itemId,sellerId,count,paymentType,price );
        return xyz;
    }

}

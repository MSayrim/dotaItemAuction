package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.RegisterPojo;

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
}

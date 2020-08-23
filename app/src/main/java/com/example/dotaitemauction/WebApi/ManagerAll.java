package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.LoginPojo;

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
}

package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.LoginPojo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/connections/dotaItems/login.php")
    Call<LoginPojo> loginControl(@Field( "userName" ) String userName, @Field( "userPass" ) String userPass);

}

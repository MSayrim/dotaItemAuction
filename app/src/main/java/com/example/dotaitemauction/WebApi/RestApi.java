package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.BuyItemModel;
import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.Models.SellPojo;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("/connections/dotaItems/login.php")
    Call<LoginPojo> loginControl(@Field( "userName" ) String userName, @Field( "userPass" ) String userPass);

    @FormUrlEncoded
    @POST("/connections/dotaItems/register.php")
    Call<RegisterPojo> registerControl(@Field( "userMail" ) String userMail, @Field( "userPass" ) String userPass, @Field ( "userNick" ) String userNick, @Field ( "userSteamId" ) String userSteamId);

    @retrofit2.http.GET("/connections/dotaItems/itemList.php")
    Call<List<MarketItemPojo>> marketLoad();

    @retrofit2.http.GET("/connections/dotaItems/itemCount.php")
    Call<List<MarketItemCountPojo>> marketItemCount();

    @retrofit2.http.GET("/connections/dotaItems/itemListAll.php")
    Call<List<MarketAll>> marketAllItem();

    @FormUrlEncoded
    @POST("/connections/dotaItems//sellItem.php")
    Call<SellPojo> sellItem(@Field ( "itemId" ) String itemId, @Field ( "sellerId" ) String sellerId, @Field ( "count" ) String count, @Field ( "paymentType" ) String paymentType, @Field ( "price" ) String price);

    @FormUrlEncoded
    @POST("/connections/dotaItems/buyedItem.php")
    Call<BuyItemModel> buyItem(@Field ( "sellerId" ) String sellerId, @Field ( "buyerId" ) String buyerId , @Field ( "paymentMethod" ) String paymentMethod, @Field ( "price" ) String price , @Field ( "count" ) String count , @Field ( "itemId" ) String itemId , @Field ( "dogrulamaKodu") String dogrulamaKodu );


}

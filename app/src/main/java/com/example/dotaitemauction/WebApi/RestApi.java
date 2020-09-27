package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.BuyItemModel;
import com.example.dotaitemauction.Models.BuyedItemPojo;
import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.ProfilPojo;
import com.example.dotaitemauction.Models.RatePojo;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.Models.Response;
import com.example.dotaitemauction.Models.ResultPojo;
import com.example.dotaitemauction.Models.SellPojo;
import com.example.dotaitemauction.Models.UserRate;

import java.util.List;

import retrofit2.Callback;
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

    @FormUrlEncoded
    @POST("/connections/dotaItems/saled.php")
    Call<List<BuyedItemPojo>> saledItems(@Field ( "sellerId" ) String sellerId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/buyed.php")
    Call<List<BuyedItemPojo>> buyedItems(@Field ( "buyerId" ) String buyerId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/onSaleEdit.php")
    Call<Response> onSaleItems (@Field ( "itemPrice" ) String itemPrice , @Field ( "itemCount" ) String itemCount,@Field ( "command" ) String command,@Field ( "sellerId" ) String sellerId,@Field ( "itemId" ) String itemId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/ratenow.php")
    Call<RatePojo> rateUser(@Field ( "ratedItem" ) String ratedItem , @Field ( "whoRate" ) String whoRate , @Field ( "ratePosition" ) String ratePosition , @Field ( "ratedUser" ) String ratedUser, @Field ( "rate" ) String rate);

    @FormUrlEncoded
    @POST("/connections/dotaItems/rateget.php")
    Call<UserRate> rateGet(@Field ( "userId" ) String  userId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/profil.php")
    Call<ProfilPojo> profilGet(@Field ( "userId" )String userId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/updateMail.php")
    Call<ResultPojo> updateMail(@Field ( "userId" ) String userId, @Field ( "password" ) String password, @Field ( "mail" ) String newMail);


    @FormUrlEncoded
    @POST("/connections/dotaItems/updateNick.php")
    Call<ResultPojo> updateNick(@Field ( "userId" ) String userId, @Field ( "password" ) String password,@Field ( "nick" ) String newNick);


    @FormUrlEncoded
    @POST("/connections/dotaItems/updatePass.php")
    Call<ResultPojo> updatePass(@Field ( "userId" ) String userId, @Field ( "password" ) String password,@Field ( "newPassword" ) String newPassword);

}

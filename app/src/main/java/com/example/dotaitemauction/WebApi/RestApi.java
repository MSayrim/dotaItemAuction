package com.example.dotaitemauction.WebApi;

import com.example.dotaitemauction.Models.BuyItemModel;
import com.example.dotaitemauction.Models.BuyedItemPojo;
import com.example.dotaitemauction.Models.LoginModel;
import com.example.dotaitemauction.Models.LoginPojo;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.ProfilPojo;
import com.example.dotaitemauction.Models.RatePojo;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.Models.Response;
import com.example.dotaitemauction.Models.ResultPojo;
import com.example.dotaitemauction.Models.SaleItemModel;
import com.example.dotaitemauction.Models.SellPojo;
import com.example.dotaitemauction.Models.UserRate;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestApi {


    @POST("api/Users/Login")
    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    Call<LoginPojo> loginControl(@Body LoginModel loginModel);

    @FormUrlEncoded
    @POST("/connections/dotaItems/register.php")
    Call<RegisterPojo> registerControl(@Field("userMail") String userMail, @Field("userPass") String userPass, @Field("userNick") String userNick, @Field("userSteamId") String userSteamId);

    @retrofit2.http.GET("/connections/dotaItems/itemList.php")
    Call<List<MarketItemPojo>> marketLoad();


    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @retrofit2.http.GET("api/Items/GetItemsCount")
    Call<List<MarketItemCountPojo>> marketItemCount();


    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @retrofit2.http.GET("api/Items")
    Call<List<MarketAll>> marketAllItem();


    @Headers({
            "Content-Type: application/json;charset=utf-8",
            "Accept: application/json;charset=utf-8",
            "Cache-Control: max-age=640000"
    })
    @POST("api/OnSaleItems")
    Call<SellPojo> sellItem(@Body SaleItemModel saleItemModel);
    //Call<SellPojo> sellItem(@Field ( "itemId" ) String itemId, @Field ( "sellerId" ) String sellerId, @Field ( "count" ) String count, @Field ( "paymentType" ) String paymentType, @Field ( "price" ) String price);

    @FormUrlEncoded
    @POST("/connections/dotaItems/buyedItem.php")
    Call<BuyItemModel> buyItem(@Field("sellerId") String sellerId, @Field("buyerId") String buyerId, @Field("paymentMethod") String paymentMethod, @Field("price") String price, @Field("count") String count, @Field("itemId") String itemId, @Field("dogrulamaKodu") String dogrulamaKodu);

    @FormUrlEncoded
    @POST("/connections/dotaItems/saled.php")
    Call<List<BuyedItemPojo>> saledItems(@Field("sellerId") String sellerId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/buyed.php")
    Call<List<BuyedItemPojo>> buyedItems(@Field("buyerId") String buyerId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/onSaleEdit.php")
    Call<Response> onSaleItems(@Field("itemPrice") String itemPrice, @Field("itemCount") String itemCount, @Field("command") String command, @Field("sellerId") String sellerId, @Field("itemId") String itemId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/ratenow.php")
    Call<RatePojo> rateUser(@Field("ratedItem") String ratedItem, @Field("whoRate") String whoRate, @Field("ratePosition") String ratePosition, @Field("ratedUser") String ratedUser, @Field("rate") String rate);

    @FormUrlEncoded
    @POST("/connections/dotaItems/rateget.php")
    Call<UserRate> rateGet(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/profil.php")
    Call<ProfilPojo> profilGet(@Field("userId") String userId);

    @FormUrlEncoded
    @POST("/connections/dotaItems/updateMail.php")
    Call<ResultPojo> updateMail(@Field("userId") String userId, @Field("password") String password, @Field("mail") String newMail);


    @FormUrlEncoded
    @POST("/connections/dotaItems/updateNick.php")
    Call<ResultPojo> updateNick(@Field("userId") String userId, @Field("password") String password, @Field("nick") String newNick);


    @FormUrlEncoded
    @POST("/connections/dotaItems/updatePass.php")
    Call<ResultPojo> updatePass(@Field("userId") String userId, @Field("password") String password, @Field("newPassword") String newPassword);

}

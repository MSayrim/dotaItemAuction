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

import retrofit2.Call;


public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();

    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }

    public Call<LoginPojo> login(String email , String userPass)
    {
        Call<LoginPojo> x = getRestApi ().loginControl (email,userPass);
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

    public Call<BuyItemModel> buyItem(String sellerId, String buyerId , String paymentMethod,String price ,  String count , String itemId ,  String dogrulamaKodu)
    {
        Call<BuyItemModel> asd = getRestApi ().buyItem ( sellerId,buyerId,paymentMethod,price,count,itemId,dogrulamaKodu );
        return asd;
    }

    public Call<List<BuyedItemPojo>> buyedItems(String buyerId)
    {
        Call<List<BuyedItemPojo>> asd = getRestApi ().buyedItems ( buyerId );
        return asd;
    }
    public Call<List<BuyedItemPojo>> saledItems(String sellerId)
    {
        Call<List<BuyedItemPojo>> asd = getRestApi ().saledItems ( sellerId );
        return asd;
    }

    public Call<Response> onSaleItems(String itemPrice ,String itemCount ,String command,String sellerId, String itemId)
    {
        Call<Response> asd = getRestApi ().onSaleItems ( itemPrice,itemCount,command,sellerId,itemId );
        return asd;
    }

    public Call<RatePojo> rateUser(String ratedItem , String whoRate , String ratePosition , String ratedUser, String rate)
    {
        Call<RatePojo> asd = getRestApi ().rateUser ( ratedItem,whoRate,ratePosition,ratedUser,rate );
        return asd;
    }

    public Call<UserRate> userRate(String userId)
    {
        Call<UserRate> asd = getRestApi ().rateGet ( userId );
        return asd;
    }

    public Call<ProfilPojo> profil(String userId)
    {
        Call<ProfilPojo> asd = getRestApi ().profilGet ( userId );
        return asd;
    }


    public Call<ResultPojo> updateMail(String id , String password, String newMail)
    {
        Call<ResultPojo> asd = getRestApi ().updateMail ( id,password,newMail );
        return asd;
    }
    public Call<ResultPojo> updateNick(String id ,String password,String newNick )
    {
        Call<ResultPojo> asd = getRestApi ().updateMail ( id,password,newNick );
        return asd;
    }

    public Call<ResultPojo> updatePass(String id ,String password,String newPass )
    {
        Call<ResultPojo> asd = getRestApi ().updateMail ( id,password,newPass );
        return asd;
    }


}

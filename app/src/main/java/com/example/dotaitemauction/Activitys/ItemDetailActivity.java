package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.dotaitemauction.Adapters.MarketListDetailAdapter;
import com.example.dotaitemauction.Models.BuyItemModel;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.Utils.GifImageView;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class ItemDetailActivity extends AppCompatActivity {

    TextView itemDetailName;
    TextView itemDetailCount;
    TextView itemDetailSellerNick;
    TextView itemDetailSellerSteamId;
    TextView itemDetailMethod;
    TextView itemDetailPrice;
    Integer securityCode;
    TextView securityText;
    EditText securityCheckText;
    Button buyButton;
    String securityCodeS;
    String sellerId;

    BuyItemModel respondOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_item_detail );
        itemDetailName= (TextView) findViewById (  R.id.itemNameDetail);
        itemDetailCount= (TextView) findViewById (  R.id.itemCountDetail);
        itemDetailSellerNick= (TextView) findViewById (  R.id.itemSellerNickDetail);
        itemDetailSellerSteamId= (TextView) findViewById (  R.id.itemSellerSteamIdDetail);
        itemDetailMethod= (TextView) findViewById (  R.id.itemMethodDetail);
        itemDetailPrice= (TextView) findViewById (  R.id.itemPriceDetail);
        securityText = (TextView) findViewById ( R.id.security);
        securityCheckText = (EditText) findViewById ( R.id.secuirtyCheck );
        buyButton = (Button) findViewById ( R.id.buyItemButton );

        securityCode = new Random (  ).nextInt (9999999-1000000);
        securityCodeS = securityCode.toString ();
        securityText.setText ( securityCodeS );


        final Intent intent = getIntent ();
        itemDetailName.setText ( intent.getStringExtra ( "name" ) );

        itemDetailCount.setText ( intent.getStringExtra ( "count" ) );

        itemDetailSellerNick.setText ( intent.getStringExtra ( "nick" ) );

        itemDetailSellerSteamId.setText ( intent.getStringExtra ( "steam id" ) );

        itemDetailMethod.setText ( intent.getStringExtra ( "method" ) );

        itemDetailPrice.setText ( intent.getStringExtra ( "price" ) );

        sellerId = intent.getStringExtra ( "sellerId" );


        if(sellerId.equals ( currentUserId ))
        {

            buyButton.setEnabled ( false );

        }

        buyButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                if(securityCheckText.getText ().toString ().equals (  securityCodeS))
                {
                    String verified = "verified";
                    securityText.setText ( verified );
                    String one =intent.getStringExtra ( "sellerId" ) ;
                    String two =intent.getStringExtra ( "method" ) ;
                    String three = intent.getStringExtra ( "price" ) ;
                    String four = intent.getStringExtra ( "count" );
                    String five = intent.getStringExtra ( "itemId" );



                    loader ( one,currentUserId,two ,three,four,five,verified  );
                    Intent back = new Intent ( getApplicationContext (),MarketActivity.class );
                    startActivity ( back );
                    finish ();

                }
            }
        } );
    }




    public void loader(String sellerId, String buyerId , String paymentMethod,String price ,  String count , String itemId ,  String dogrulamaKodu)
    {
        final Call<BuyItemModel> buyItemModelCall = ManagerAll.getInstance().buyItem (sellerId,buyerId,paymentMethod,price,count,itemId,dogrulamaKodu);
        buyItemModelCall.enqueue ( new Callback<BuyItemModel> () {
            @Override
            public void onResponse(final Call<BuyItemModel> call2, final Response<BuyItemModel> response) {

                respondOne = response.body ();


            }

            @Override
            public void onFailure(Call<BuyItemModel> call, Throwable t) {

            }

        } );
    }


}

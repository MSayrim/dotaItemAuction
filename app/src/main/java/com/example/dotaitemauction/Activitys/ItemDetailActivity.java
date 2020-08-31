package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.dotaitemauction.R;
import com.example.dotaitemauction.Utils.GifImageView;

public class ItemDetailActivity extends AppCompatActivity {

    TextView itemDetailName;
    TextView itemDetailCount;
    TextView itemDetailSellerNick;
    TextView itemDetailSellerSteamId;
    TextView itemDetailMethod;
    TextView itemDetailPrice;

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






    }

    public void onResume(){
        super.onResume ();

        Intent intent = getIntent ();
        itemDetailName.setText ( intent.getStringExtra ( "name" ) );

        itemDetailCount.setText ( intent.getStringExtra ( "count" ) );

        itemDetailSellerNick.setText ( intent.getStringExtra ( "nick" ) );

        itemDetailSellerSteamId.setText ( intent.getStringExtra ( "steam id" ) );

        itemDetailMethod.setText ( intent.getStringExtra ( "method" ) );

        itemDetailPrice.setText ( intent.getStringExtra ( "price" ) );
    }


}

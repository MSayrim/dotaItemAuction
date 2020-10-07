package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.dotaitemauction.Adapters.MarketListDetailAdapter;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class MarketDetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;

    MarketListDetailAdapter marketListDetailAdapter;
    List<MarketItemPojo> respondOne;
    List<MarketItemPojo> respondfiltred;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_market_detail );
        listView = (ListView) findViewById(R.id.marketListDetailList);
        respondOne = new ArrayList<>();
        loader();
        listView.setOnItemClickListener (MarketDetailActivity.this);

    }
    public void loader()
    {
        final Call<List<MarketItemPojo>> marketLoader = ManagerAll.getInstance().marketDetailLoader ();
        marketLoader.enqueue ( new Callback<List<MarketItemPojo>> () {
            @Override
            public void onResponse(final Call<List<MarketItemPojo>> call2, final Response<List<MarketItemPojo>> response) {
                respondOne = response.body ();
                Intent intent1 = getIntent ();
                String focusItem = intent1.getStringExtra( "curent item" );
                respondfiltred = new ArrayList<>();
                for(int i = 0 ; i<respondOne.size();i++)
                {
                    if(respondOne.get(i).getProductName().equals(focusItem))
                    {
                        String date = respondOne.get(i).getDate();
                        respondfiltred.add(respondOne.get(i));
                    }
                }
                marketListDetailAdapter = new MarketListDetailAdapter(respondfiltred,getApplicationContext());
                listView.setAdapter ( marketListDetailAdapter );
            }
            @Override
            public void onFailure(Call<List<MarketItemPojo>> call, Throwable t) {
            }

        } );
        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext (),ItemDetailActivity.class );
        intent.putExtra("sellerId",respondfiltred.get(i).getSellerId());
        intent.putExtra("name",respondfiltred.get(i).getProductName());
        intent.putExtra("method",respondfiltred.get(i).getMethod());
        intent.putExtra("price",respondfiltred.get(i).getPrice());
        intent.putExtra("nick",respondfiltred.get(i).getSellerNick());
        intent.putExtra("steam id",respondfiltred.get(i).getSellerSteamId());
        intent.putExtra("count" , respondfiltred.get(i).getCount());
        intent.putExtra("itemId",respondfiltred.get(i).getProductId());
        startActivity(intent);
    }


}

package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.dotaitemauction.Adapters.MarketListAdapter;
import com.example.dotaitemauction.Adapters.SaledItemsAdapter;
import com.example.dotaitemauction.Models.BuyItemModel;
import com.example.dotaitemauction.Models.BuyedItemPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class SaledItemActivity extends AppCompatActivity {

    List<BuyedItemPojo> respondOne;
    SaledItemsAdapter saledItemsAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_saled_item );
        listView = (ListView) findViewById ( R.id.saledItemListView );

        loader (currentUserId);
    }




    public void loader(String sellerId)
    {
        final Call<List<BuyedItemPojo>> buyItemModelCall = ManagerAll.getInstance().saledItems (sellerId);
        buyItemModelCall.enqueue ( new Callback<List<BuyedItemPojo>> () {
            @Override
            public void onResponse(final Call<List<BuyedItemPojo>> call2, final Response<List<BuyedItemPojo>> response) {

                respondOne = response.body ();

                saledItemsAdapter = new SaledItemsAdapter ( respondOne,getApplicationContext () );
                saledItemsAdapter.notifyDataSetChanged ();
                listView.setAdapter ( saledItemsAdapter );

            }

            @Override
            public void onFailure(Call<List<BuyedItemPojo>> call, Throwable t) {

            }

        } );
    }
}

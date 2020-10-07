package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dotaitemauction.Adapters.MarketListDetailAdapter;
import com.example.dotaitemauction.Adapters.OnSaleAdapter;
import com.example.dotaitemauction.Adapters.TempAdapter;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class OnSaleItemActivity extends AppCompatActivity  {

    List<MarketItemPojo> respondOne;

    List<MarketItemPojo> respondfiltred;
    OnSaleAdapter onSaleAdapter;
    ListView listView;
    Button button1;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.temp_list );
        listView = (ListView) findViewById ( R.id.tempList );



    }

    public void onResume() {
        super.onResume ();
        loader ();
    }

    public void loader()
    {
        final Call<List<MarketItemPojo>> marketLoader = ManagerAll.getInstance().marketDetailLoader ();
        marketLoader.enqueue ( new Callback<List<MarketItemPojo>> () {
            @Override
            public void onResponse(final Call<List<MarketItemPojo>> call2, final Response<List<MarketItemPojo>> response) {
                respondOne = response.body ();


                respondfiltred = new ArrayList<> (  );
                for(int i = 0 ; i<respondOne.size ();i++)
                {
                    if(respondOne.get (i).getSellerId ().equals ( currentUserId ))
                    {
                        String date = respondOne.get ( i ).getDate ();
                        respondfiltred.add ( respondOne.get ( i ) );




                        final retrofit2.Call<List<MarketAll>> marketLoader = ManagerAll.getInstance().marketLoader ();
                        final int finalI = i;
                        marketLoader.enqueue ( new Callback<
                                List<MarketAll>> () {
                            @Override
                            public void onResponse(final retrofit2.Call<List<MarketAll>> call2, final retrofit2.Response<
                                    List<MarketAll>> response2) {


                                String pict = null;
                                for(int j = 0 ; j<response2.body ().size ();j++) {

                                    if (respondOne.get ( finalI ).getProductName ().equals ( response2.body ().get ( j ).getProductName ().toString () )) {
                                        pict = response2.body ().get ( j ).getProductPic ().toString ();
                                          respondfiltred.get ( finalI ).setProductImage ( pict );
                                    }

                                }



                            }

                            @Override
                            public void onFailure(Call<List<MarketAll>> call, Throwable t) {

                            }

                        } );

                        onSaleAdapter = new OnSaleAdapter ( respondfiltred,OnSaleItemActivity.this );
                        listView.invalidateViews ();
                        listView.refreshDrawableState();
                        onSaleAdapter.notifyDataSetChanged ();
                        listView.setAdapter ( onSaleAdapter );



                    }
                }


            }

            @Override
            public void onFailure(Call<List<MarketItemPojo>> call, Throwable t) {

            }

        } );
    }


}

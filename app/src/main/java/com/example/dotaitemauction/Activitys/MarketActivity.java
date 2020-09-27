package com.example.dotaitemauction.Activitys;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.dotaitemauction.Adapters.MarketListAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketActivity extends AppCompatActivity implements OnItemClickListener {

    ListView listView;
    MarketActivity marketActivity;
    MarketListAdapter marketListAdapter;
    Context context;
    List<MarketAll> respondOne;
    List<MarketItemCountPojo> respondTwo;
    String id;
    Intent sellIntent;

    ProgressBar loadingProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_market );
        marketActivity = this;
        Toolbar toolbar = findViewById ( R.id.toolbar );
        FloatingActionButton fab = findViewById ( R.id.fab);

        loadingProgressBar = findViewById ( R.id.loading );


        sellIntent = new Intent (getApplicationContext (), SellItemActivity.class );
        Intent idIntent=getIntent ();
        id = idIntent.getStringExtra ( "id" );
        sellIntent.putExtra ( "id",id );
        fab.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {


                startActivity ( sellIntent );
            }
        } );
        listView = findViewById ( R.id.marketList );
        context = getApplicationContext ();
        setSupportActionBar(toolbar);
        listView.setOnItemClickListener (MarketActivity.this);
    }

  public void onResume() {
        super.onResume ();


        loader ();
    }

    public void loader()
    {
        final Call<List<MarketAll>> marketLoader = ManagerAll.getInstance().marketLoader ();
        marketLoader.enqueue ( new Callback<List<MarketAll>> () {
            @Override
            public void onResponse(final Call<List<MarketAll>> call2, final Response<List<MarketAll>> response) {
                respondOne = response.body ();

                final Call<List<MarketItemCountPojo>> categoryList = ManagerAll.getInstance().marketItemCount ();
                categoryList.enqueue ( new Callback<List<MarketItemCountPojo>> () {
                    @Override
                    public void onResponse(final Call<List<MarketItemCountPojo>> call2, final Response<List<MarketItemCountPojo>> response) {
                        respondTwo = response.body ();
                        marketListAdapter = new MarketListAdapter ( respondOne,getApplicationContext (),respondTwo );
                        listView.setAdapter ( marketListAdapter );


                    }
                    @Override
                    public void onFailure(Call<List<MarketItemCountPojo>> call, Throwable t) {
                    }
                } );
            }
            @Override
            public void onFailure(Call<List<MarketAll>> call, Throwable t) {
            }
        } );
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate ( R.menu.menu, menu );

        MenuItem myActionMenuItem = menu.findItem(R.id.searchItem);
        SearchView searchView = (SearchView)myActionMenuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    marketListAdapter.filter(" ");
                    listView.clearTextFilter();
                }
                else {
                    marketListAdapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent idIntent=getIntent ();
        String id = idIntent.getStringExtra ( "id" );


        switch (item.getItemId ()) {
            case R.id.action_deliver:
                Intent goIntent = new Intent (getApplicationContext (), SaledItemActivity.class );
                goIntent.putExtra ( "id" , id );
                startActivity ( goIntent );
                return true;
            case R.id.action_mysells:
                Intent goIntent1 = new Intent (getApplicationContext (), OnSaleItemActivity.class );
                goIntent1.putExtra ( "id" , id );
                startActivity ( goIntent1 );
                return true;
            case R.id.action_profile:
                Intent goIntent3 = new Intent (getApplicationContext (), ProfileActivity.class );
                goIntent3.putExtra ( "id" , id );
                startActivity ( goIntent3 );
                return true;
            case R.id.action_purchase:
                Intent goIntent4 = new Intent (getApplicationContext (), PurchaseItemActivity.class );
                goIntent4.putExtra ( "id" , id );
                startActivity ( goIntent4 );
                return true;
            case R.id.action_upgrade:
                Intent goIntent5 = new Intent (getApplicationContext (), UpgradeAccountActivity.class );
                goIntent5.putExtra ( "id" , id );
                startActivity ( goIntent5 );
                return true;
            case R.id.action_settings:
                Intent goIntent6 = new Intent (getApplicationContext (), SettingsActivity.class );
                goIntent6.putExtra ( "id" , id );
                startActivity ( goIntent6 );
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent idIntent=getIntent ();
        String id = idIntent.getStringExtra ( "id" );

        Intent intent = new Intent(getApplicationContext (),MarketDetailActivity.class );
        intent.putExtra ( "curent item",respondOne.get ( i ).getProductName () );
        intent.putExtra ( "id",id );


        startActivity(intent);
    }
}

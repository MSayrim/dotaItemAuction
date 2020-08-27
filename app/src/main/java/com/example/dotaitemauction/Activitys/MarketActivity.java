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
import android.widget.SearchView;

import com.example.dotaitemauction.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity implements OnItemClickListener {

    ListView listView;
    MarketActivity marketActivity;
    MarketListAdapter marketListAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_market );
        marketActivity = this;
        Toolbar toolbar = findViewById ( R.id.toolbar );

        FloatingActionButton fab = findViewById ( R.id.fab);
        fab.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent sellIntent = new Intent (getApplicationContext (), SellItemActivity.class );
                startActivity ( sellIntent );
            }
        } );
        context = getApplicationContext ();
        loader ();


        listView.setOnItemClickListener (MarketActivity.this);
        //bu dogru
    }

    public void loader()
    {


        listView = findViewById ( R.id.marketList );




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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

/*Intent goIntent = new Intent (getApplicationContext (), SaledItemActivity.class );
                startActivity ( goIntent );

                intentAdapter.profile ( this )*/

        switch (item.getItemId ()) {
            case R.id.action_deliver:
                Intent goIntent = new Intent (getApplicationContext (), SaledItemActivity.class );
                startActivity ( goIntent );
                return true;
            case R.id.action_mysells:
                Intent goIntent1 = new Intent (getApplicationContext (), OnSaleItemActivity.class );
                startActivity ( goIntent1 );
                return true;
            case R.id.action_profile:
                Intent goIntent3 = new Intent (getApplicationContext (), ProfileActivity.class );
                startActivity ( goIntent3 );
                return true;
            case R.id.action_purchase:
                Intent goIntent4 = new Intent (getApplicationContext (), PurchaseItemActivity.class );
                startActivity ( goIntent4 );
                return true;
            case R.id.action_upgrade:
                Intent goIntent5 = new Intent (getApplicationContext (), UpgradeAccountActivity.class );
                startActivity ( goIntent5 );
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext (),MarketDetailActivity.class );

        startActivity(intent);
    }
}

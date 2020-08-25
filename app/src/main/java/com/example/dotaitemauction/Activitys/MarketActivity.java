package com.example.dotaitemauction.Activitys;

import android.os.Bundle;

import com.example.dotaitemauction.Adapters.MarketListAdapter;
import com.example.dotaitemauction.Models.MarketItem;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.ListView;

import com.example.dotaitemauction.R;

import java.util.ArrayList;
import java.util.List;

public class MarketActivity extends AppCompatActivity {

    ListView listView;
    List<MarketItem> mock;
    MarketActivity marketActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_market );
        marketActivity = this;

        listView = findViewById ( R.id.marketList );
        loader ();

    }


    public void loader()
    {


        mock = new ArrayList<> (  );

        mock.add ( new MarketItem ( "murat","1231",R.drawable.ic_launcher_background) );
        mock.add ( new MarketItem ( "mura3t","123111",R.drawable.ic_launcher_background ) );
        mock.add ( new MarketItem ( "mura2t","123331",R.drawable.ic_launcher_background ) );





        final MarketListAdapter marketListAdapter = new MarketListAdapter (mock,marketActivity);
        listView.setAdapter ( marketListAdapter );



    }

}

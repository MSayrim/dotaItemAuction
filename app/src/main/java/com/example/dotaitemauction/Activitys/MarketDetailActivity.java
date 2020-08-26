package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dotaitemauction.R;

public class MarketDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_market_detail );

        Intent intent = getIntent ();
        String category = intent.getStringExtra ( "category" );
        TextView textView = (TextView) findViewById ( R.id.textView5 );
        textView.setText ( category );
    }
}

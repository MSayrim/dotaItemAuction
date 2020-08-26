package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dotaitemauction.R;

public class SellItemActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sell_item );

        button = (Button) findViewById ( R.id.sellButton );

        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent goback = new Intent (getApplicationContext (), MarketActivity.class );
                startActivity ( goback );
                finish ();
            }
        } );
    }
}

package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dotaitemauction.R;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        Intent intent = getIntent ();
        String id = intent.getStringExtra ( "id" );
        textView = (TextView) findViewById ( R.id.idShower );
        textView.setText ( "YOUR ID IS: \n" + id );

    }
}

package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dotaitemauction.R;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UpgradeAccountActivity extends AppCompatActivity {
    Spinner monthSpinner;
    Spinner itemListSpinner;
    TextView price;
    TextView predate;
    TextView count;
    Button calculate;
    Calendar calendar;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_upgrade_account );
        monthSpinner =(Spinner) findViewById ( R.id.monthSpinner );
        itemListSpinner = (Spinner) findViewById ( R.id.itemListSpinner );
        price = (TextView) findViewById ( R.id.package_price );
        predate = (TextView) findViewById ( R.id.premiumDate );
        count = (TextView) findViewById ( R.id.itemCount );
        calculate = (Button) findViewById ( R.id.calculate );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource ( this,R.array.premium_month,android.R.layout.simple_spinner_item );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource ( this,R.array.list_item,android.R.layout.simple_spinner_item );
        monthSpinner.setAdapter ( adapter );
        itemListSpinner.setAdapter ( adapter2 );
        Intent idIntent = getIntent ();
        id = idIntent.getStringExtra ( "id" );
        calculate.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Double result1 = selectedItemList ()*selectedMonth ();
                DecimalFormat df = new DecimalFormat("#.##");
                String result =df.format ( result1 );
                predate.setText ( calendar.getTime().toString () );
                price.setText ( result );
            }
        } );
    }


    public double selectedMonth(){
        double price = 0;
        double monthprice = 1;
        String text = monthSpinner.getSelectedItem ().toString ();
        if(text.equals ("1 Month")){
            TimeWishperer ( 1 );
            price = monthprice;
        }
        if(text.equals ("3 Month %5 OFF")){
            TimeWishperer ( 3 );
            price = monthprice*0.95*3;
        }
        if(text.equals ("6 Month %10 OFF")){
            TimeWishperer ( 6 );
            price = monthprice*0.9*6;
        }
        if(text.equals ("9 Month %15 OFF")){
            TimeWishperer ( 9 );
            price = monthprice*0.85*9;
        }
        if(text.equals ("12 Month %25 OFF")){
            TimeWishperer ( 12 );
            price = monthprice*0.75*12;
        }
        return price;
    }

    public double selectedItemList(){
        double price = 0;
        double itemListPrice = 0.8;
        String text = itemListSpinner.getSelectedItem ().toString ();
        if(text.equals ("5 item")){
            count.setText ("10" );
            price = itemListPrice*5;
        }
        if(text.equals ("10 item %5 OFF")){
            count.setText ("15" );
            price = itemListPrice*10*0.95;
        }
        if(text.equals ("25 item %10 OFF")){
            count.setText ("30" );
            price = itemListPrice*30*0.9;
        }
        if(text.equals ("50 item %15 OFF")){
            count.setText ("55" );
            price = itemListPrice*50*0.85;
        }
        if(text.equals ("100 item %25 OFF")){
            count.setText ("105" );
            price = itemListPrice*100*0.75;
        }
        return price;
    }

    public void TimeWishperer(int a)
    {
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy:MM:dd:HH:mm");
        String currentDateandTime = sdf.format(new Date());
        Date date = null;
        try {
            date = sdf.parse(currentDateandTime);
        } catch (ParseException e) {
            e.printStackTrace ();
        }
        calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, a);
    }
}

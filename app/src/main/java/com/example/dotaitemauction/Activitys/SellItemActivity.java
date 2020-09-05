package com.example.dotaitemauction.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaitemauction.Adapters.NothingSelectedSpinnerAdapter;
import com.example.dotaitemauction.Models.ItemIdModel;
import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.RegisterPojo;
import com.example.dotaitemauction.Models.SellPojo;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dotaitemauction.Activitys.LoginActivity.currentUserId;

public class SellItemActivity extends AppCompatActivity {

    Button button;
    Spinner itemSpinner;
    Spinner sellMethodSpinner;
    ArrayList<String> methodNames;
    ArrayList<String> itemNames;
    List<MarketAll> respondOne;
    EditText countItemText;
    EditText priceText;
    List<ItemIdModel> itemIdModels;
    String tempItemId;
    String sellerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sell_item );
        button = (Button) findViewById ( R.id.sellButton );
        countItemText = (EditText) findViewById ( R.id.countItemText );
        priceText = (EditText) findViewById ( R.id.sellPrice );
        Intent intentSellerId = getIntent ();
        sellerId = intentSellerId.getStringExtra ( "id" );

        methodNames = new ArrayList<> (  );
        itemNames = new ArrayList<> (  );
        itemIdModels = new ArrayList<ItemIdModel> (  );
        methodNames.add ( "cash only" );
        methodNames.add ( "immortal trade" );
        loader ();





        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                String tempName = itemSpinner.getSelectedItem ().toString ();
                String tempMethod = sellMethodSpinner.getSelectedItem ().toString ();
                String tempPrice = priceText.getText ().toString ();
                String tempCount = countItemText.getText ().toString ();

                for (int i = 0 ; i<itemIdModels.size ();i++)
                {

                    if(itemIdModels.get ( i ).getItemName ().equals ( tempName ))
                    {
                        tempItemId = itemIdModels.get ( i ).getItemId ();
                    }

                }

                    seller ( tempItemId,currentUserId,tempCount,tempMethod,tempPrice );



            }
        } );
    }

    public void loader() {
        final Call<List<MarketAll>> marketLoader = ManagerAll.getInstance ().marketLoader ();
        marketLoader.enqueue ( new Callback<List<MarketAll>> () {
            @Override
            public void onResponse(final Call<List<MarketAll>> call2, final Response<List<MarketAll>> response) {
                respondOne = response.body ();


                for (int i=0 ; i<respondOne.size ();i++)
                {
                    if(respondOne.get (  i).getProductName () != null) {
                        String temp = respondOne.get ( i ).getProductName () ;
                        String temp2= respondOne.get ( i ).getProductId ().toString ();

                        ItemIdModel item = new ItemIdModel ( temp,temp2 );
                        itemIdModels.add ( item );

                        itemNames.add ( temp );
                    }
                }


                spinnerLoader (itemNames,methodNames);
            }

            @Override
            public void onFailure(Call<List<MarketAll>> call, Throwable t) {

            }

        } );
    }

    public void seller (String itemId , String sellerId, String count , String paymentType , String price)
    {
        final Call<SellPojo> request = ManagerAll.getInstance ().sellItem ( itemId,sellerId,count,paymentType,price );

        request.enqueue ( new Callback<SellPojo> () {
            @Override
            public void onResponse(Call<SellPojo> call, Response<SellPojo> response) {
                Toast.makeText ( getApplicationContext (),response.body ().getSatisKodu () + response.body ().getResult (),Toast.LENGTH_LONG ).show ();

                if(response.body ().getResult ().equals ( "Listeleme basarili" )){
                    Intent goback = new Intent (getApplicationContext (), MarketActivity.class );

                    startActivity ( goback );
                    finish ();
                }
            }

            @Override
            public void onFailure(Call<SellPojo> call, Throwable t) {

            }
        } );
    }




    public void spinnerLoader(List<String> itemList , List<String> method)
    {
        sellMethodSpinner = (Spinner) findViewById ( R.id.sellMethodSpinner );
        itemSpinner = (Spinner) findViewById ( R.id.itemNameSpinner );
        final ArrayAdapter<CharSequence> adapter = new ArrayAdapter ( this, android.R.layout.simple_spinner_item, itemList );
        final ArrayAdapter<CharSequence> adapter2 = new ArrayAdapter ( this, android.R.layout.simple_spinner_item, method );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter ( adapter );
        sellMethodSpinner.setAdapter ( adapter2 );


    };
}

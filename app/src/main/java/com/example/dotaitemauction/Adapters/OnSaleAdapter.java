package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.Response;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class OnSaleAdapter extends BaseAdapter {


    List<Response> respondOne;
    private List<MarketItemPojo> items;
    private Context context;
    ArrayList<MarketItemPojo> arrayList;

    public OnSaleAdapter(List<MarketItemPojo> items , Context context )
    {
        this.items = items;
        this.context = context;

        this.arrayList = new ArrayList<MarketItemPojo>();
        this.arrayList.addAll(items);
    }

    @Override
    public int getCount() {
        return items.size ();
    }

    @Override
    public Object getItem(int i) {
        return items.get ( i );
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        convertView = LayoutInflater.from ( context ).inflate ( R.layout.on_sale_content, parent, false );


        TextView itemName = convertView.findViewById ( R.id.onSaleItemName );
        final EditText itemCount = convertView.findViewById ( R.id.onSaleItemCount );
        final EditText itemPrice = convertView.findViewById ( R.id.onSaleItemPrice );
        final TextView itemCurrentCount = convertView.findViewById ( R.id.currentItemCount );

        final TextView itemCurrentPrice = convertView.findViewById ( R.id.currentItemPrice );
        Button editButton = convertView.findViewById ( R.id.editButton );
        Button deleteButton = convertView.findViewById ( R.id.deleteButton );






        final MarketItemPojo item = items.get ( position );




        itemName.setText ( item.getProductName () + " " );
        itemCurrentCount.setText ( item.getCount () );
        itemCurrentPrice.setText ( item.getPrice () );


        View.OnClickListener yourClickListener = new View.OnClickListener () {
            public void onClick(View v) {
                //put your desired action here
                v.callOnClick ();
            }
        };

        editButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                String value = "2";
                String value2 = itemCount.getText ().toString ();

                String value3= itemPrice.getText ().toString ();

                if(!value2.equals ( "" ) ) {
                    itemCurrentCount.setText ( itemCount.getText ().toString () );
                }
                if(!value3.equals ( "" ) ) {
                    itemCurrentPrice.setText ( itemPrice.getText ().toString () );
                }

                String temp1 = itemPrice.getText ().toString ();
                String temp2 = itemCount.getText ().toString ();
                String temp3 = item.getSellerId ();
                String temp4 = item.getProductId () ;

                edit (temp1 ,temp2,value,temp3,temp4);

            }
        } );

        deleteButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                String value = "0";

                String temp1 = itemPrice.getText ().toString ();
                String temp2 = itemCount.getText ().toString ();
                String temp3 = item.getSellerId ();
                String temp4 = item.getProductId () ;

                edit ( temp1,temp2,value,temp3,temp4 );

            }
        } );


        return convertView;
    }


    public void edit(String itemPrice ,String itemCount ,String command,String sellerId, String itemId)
    {
        final retrofit2.Call<Response> marketLoader = ManagerAll.getInstance().onSaleItems (itemPrice,itemCount,command,sellerId,itemId);
        marketLoader.enqueue ( new Callback<Response> () {
            @Override
            public void onResponse(final retrofit2.Call<Response> call2, final retrofit2.Response<Response> response) {



            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }

        } );
    }

}

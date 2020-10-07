package com.example.dotaitemauction.Adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.Response;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

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


        convertView = LayoutInflater.from ( context ).inflate ( R.layout.content_on_sale, parent, false );
       // convertView = LayoutInflater.from ( context ).inflate ( R.layout.test_content, parent, false );


        final MarketItemPojo item = items.get ( position );
        TextView itemName = convertView.findViewById ( R.id.onSaleItemName );
        final TextView itemCurrentCount = convertView.findViewById ( R.id.currentItemCount );
        final TextView itemCurrentPrice = convertView.findViewById ( R.id.currentItemPrice );
        Button dialogButton = convertView.findViewById ( R.id.dialogButton );
        final FrameLayout frameLayout = convertView.findViewById ( R.id.frameLay );
        String pic= "https://www.3boyutlucanavar.com/connections/dotaItems/itemPics/"+item.getProductImage () ;



        Picasso.with(context).load(pic).into( new Target (){
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                frameLayout.setBackground(new BitmapDrawable (context.getResources(), bitmap));
            }

            @Override
            public void onBitmapFailed(final Drawable errorDrawable) {
                Log.d("TAG", "FAILED");
            }

            @Override
            public void onPrepareLoad(final Drawable placeHolderDrawable) {
                Log.d("TAG", "Prepare Load");
            }

        });







        itemName.setText ( item.getProductName () + " " );
        itemCurrentCount.setText ( item.getCount () );
        itemCurrentPrice.setText ( item.getPrice () );


        View.OnClickListener yourClickListener = new View.OnClickListener () {
            public void onClick(View v) {
                //put your desired action here
                v.callOnClick ();
            }
        };



        dialogButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {

                final AlertDialog dialogBuilder1 = new AlertDialog.Builder( context).create();
                final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View dialogView = inflater.inflate(R.layout.dialog_on_sale, null);
                dialogBuilder1.getWindow().setBackgroundDrawable(new ColorDrawable (android.graphics.Color.TRANSPARENT));

                Toast toast = Toast.makeText(context, "Bilgilendirme mesajı", Toast.LENGTH_LONG);
                toast.show();

                final EditText itemPrice = (EditText) dialogView.findViewById(R.id.itemPriceET);
                final EditText itemCount = (EditText) dialogView.findViewById(R.id.itemCountET);
                TextView itemName2 = (TextView) dialogView.findViewById ( R.id.selectedItemNameText );
                Button button1 = (Button) dialogView.findViewById(R.id.selectedItemEditButton);
                Button button2 = (Button) dialogView.findViewById(R.id.selectedItemDeteleButton);
                Button button3 = (Button) dialogView.findViewById(R.id.dissmissButton);

                itemPrice.setText ( item.getPrice ().toString () );
                itemCount.setText ( item.getCount ().toString () );

                itemName2.setText ( item.getProductName () );

                button1.setOnClickListener(new View.OnClickListener() {
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

                        String temp1 = itemCurrentPrice.getText ().toString ();
                        String temp2 = itemCurrentCount.getText ().toString ();
                        String temp3 = item.getSellerId ();
                        String temp4 = item.getProductId () ;

                        edit (temp1 ,temp2,value,temp3,temp4);
                        itemPrice.setText ( temp1);
                        itemCount.setText ( temp2 );

                        dialogBuilder1.dismiss();
                    }
                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // DO SOMETHINGS

                        String value = "0";

                        String temp1 = itemPrice.getText ().toString ();
                        String temp2 = itemCount.getText ().toString ();
                        String temp3 = item.getSellerId ();
                        String temp4 = item.getProductId () ;

                        edit ( temp1,temp2,value,temp3,temp4 );
                        dialogBuilder1.dismiss ();

                    }

                });

                button3.setOnClickListener ( new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        dialogBuilder1.dismiss ();
                    }
                } );

                dialogBuilder1.setView(dialogView);
                dialogBuilder1.show();
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

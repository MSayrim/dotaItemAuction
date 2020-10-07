package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemCountPojo;
import com.example.dotaitemauction.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class MarketListAdapter extends BaseAdapter {

    private List<MarketAll> items;
    private Context context;
    private List<MarketItemCountPojo> itemCount;
    ArrayList<MarketAll> arrayList;

    public MarketListAdapter(List<MarketAll> items , Context context,List<MarketItemCountPojo> itemCount)
    {
        this.items = items;
        this.context = context;
        this.arrayList = new ArrayList<MarketAll>();
        this.arrayList.addAll(items);
        this.itemCount = itemCount;
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
        convertView = LayoutInflater.from ( context ).inflate ( R.layout.content_market,parent,false );
        TextView NameView = convertView.findViewById(R.id.itemName );
        TextView StockView = convertView.findViewById(R.id.itemStock);
        MarketAll item = items.get(position);
        NameView.setText( item.getProductName () +" " );
        StockView.setText (itemCount.get ( position ).getItemCount () + " " );
        String pic= "https://www.3boyutlucanavar.com/connections/dotaItems/itemPics/"+item.getProductPic ();
        View.OnClickListener yourClickListener = new View.OnClickListener () {
            public void onClick(View v) {
                //put your desired action here


                v.callOnClick();
            }
        };
//.transform ( new RoundedTransformation (15,5) )
        final View finalConvertView = convertView;
        Picasso.with(context).load(pic).into( new Target (){
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                finalConvertView.setBackground(new BitmapDrawable (context.getResources(), bitmap));
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







        return convertView;
    }
    public void filter(String charText){
        charText = charText.toLowerCase( Locale.getDefault());
        items.clear();
        if (charText.length()==0){
            items.addAll(arrayList);
        }
        else {
            for (MarketAll marketItem : arrayList){
                if (marketItem.getProductName ().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    items.add (marketItem);
                }
            }
        }
        notifyDataSetChanged();
    }



    @Override
    public boolean areAllItemsEnabled()
    {
        return true;
    }

    @Override
    public boolean isEnabled(int arg0)
    {
        return true;
    }




}

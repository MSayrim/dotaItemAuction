package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.R;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;



public class MarketListAdapter extends BaseAdapter {

    private List<MarketItem> items;
    private Context context;
    ArrayList<MarketItem> arrayList;

    public MarketListAdapter(List<MarketItem> items , Context context)
    {
        this.items = items;
        this.context = context;
        this.arrayList = new ArrayList<MarketItem>();
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


        convertView = LayoutInflater.from ( context ).inflate ( R.layout.market_context,parent,false );

        TextView NameView = convertView.findViewById(R.id.itemName );
        TextView StockView = convertView.findViewById(R.id.itemStock);
        ImageView tumbnail = convertView.findViewById ( R.id.tumbnailPic );
        MarketItem item = items.get(position);
        NameView.setText( item.getItemName () +" " );
        StockView.setText ( item.getItemStock () + " " );
        tumbnail.setImageResource ( item.getItemTumbnail () );
        //String pic= "https://www.3boyutlucanavar.com/wp-content/uploads/2020/assets/"+item.getItemTumbnail ();
        //Picasso.with ( context ).load ( item.getItemTumbnail ()).into (tumbnail  );

        View.OnClickListener yourClickListener = new View.OnClickListener () {
            public void onClick(View v) {
                //put your desired action here
                v.callOnClick();
            }
        };


        return convertView;
    }
    public void filter(String charText){
        charText = charText.toLowerCase( Locale.getDefault());
        items.clear();
        if (charText.length()==0){
            items.addAll(arrayList);
        }
        else {
            for (MarketItem marketItem : arrayList){
                if (marketItem.getItemName ().toLowerCase(Locale.getDefault())
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

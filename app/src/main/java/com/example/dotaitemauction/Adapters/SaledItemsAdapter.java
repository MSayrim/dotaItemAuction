package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.Models.BuyedItemPojo;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.R;

import java.util.ArrayList;
import java.util.List;

public class SaledItemsAdapter extends BaseAdapter {

        private List<BuyedItemPojo> items;
        private Context context;
        String value;
        ArrayList<BuyedItemPojo> arrayList;

        public SaledItemsAdapter(List<BuyedItemPojo> items , Context context )
        {
            this.items = items;
            this.context = context;

            this.arrayList = new ArrayList<BuyedItemPojo>();
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


            convertView = LayoutInflater.from ( context ).inflate ( R.layout.saled_item_content, parent, false );


            TextView itemName = convertView.findViewById ( R.id.saledItemNameView );
            TextView sellerSteamId = convertView.findViewById ( R.id.saledItemSellerSteamIdView );
            TextView buyerSteamId = convertView.findViewById ( R.id.saledItemBuyerSteamIdView );


            BuyedItemPojo item = items.get ( position );


            itemName.setText ( item.getItemName () + " " );
            sellerSteamId.setText ( item.getSellerSteamId () );
            buyerSteamId.setText ( item.getBuyerSteamId () );


            View.OnClickListener yourClickListener = new View.OnClickListener () {
                public void onClick(View v) {
                    //put your desired action here
                    v.callOnClick ();
                }
            };


            return convertView;
        }



}

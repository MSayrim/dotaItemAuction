package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.Models.MarketAll;
import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.Models.UserRate;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;


public class MarketListDetailAdapter  extends BaseAdapter {

        private List<MarketItemPojo> items;
        private Context context;
        String value;
        ArrayList<MarketItemPojo> arrayList;
        RatingBar rate;

        public MarketListDetailAdapter(List<MarketItemPojo> items , Context context )
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


            convertView = LayoutInflater.from ( context ).inflate ( R.layout.detail_list, parent, false );


            TextView NameView = convertView.findViewById ( R.id.itemNameView );
            TextView paymentMethod = convertView.findViewById ( R.id.paymentMethodView );
            TextView price = convertView.findViewById ( R.id.sellPriceView );
            rate = convertView.findViewById ( R.id.ratingBar );

                MarketItemPojo item = items.get ( position );
                rate(item.getSellerId ());
                NameView.setText ( item.getProductName () + " " );
                paymentMethod.setText ( item.getMethod () );
                price.setText ( item.getPrice () );
                float userRate = Float.parseFloat(item.getRate () );
                rate.setRating (userRate );

                View.OnClickListener yourClickListener = new View.OnClickListener () {
                    public void onClick(View v) {
                        //put your desired action here
                        v.callOnClick ();
                    }
                };


                return convertView;
            }

    public void rate(String buyerId)
    {
        final Call<UserRate> buyItemModelCall = ManagerAll.getInstance().userRate (buyerId);
        buyItemModelCall.enqueue ( new Callback<UserRate> (){


            @Override
            public void onResponse(Call<UserRate> call, retrofit2.Response<UserRate> response) {

                double result = response.body ().getRate ();
                rate.setRating ( Float.parseFloat ( String.valueOf ( result ) ) );


            }

            @Override
            public void onFailure(Call<UserRate> call, Throwable t) {

            }
        } );

    }


    }


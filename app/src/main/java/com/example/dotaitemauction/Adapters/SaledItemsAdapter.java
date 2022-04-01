package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dotaitemauction.Models.BuyedItemPojo;
import com.example.dotaitemauction.Models.RatePojo;
import com.example.dotaitemauction.Models.UserRate;
import com.example.dotaitemauction.R;
import com.example.dotaitemauction.WebApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class SaledItemsAdapter extends BaseAdapter {

    private List<BuyedItemPojo> items;
    private Context context;
    String sellerZeroBuyerOne;
    ArrayList<BuyedItemPojo> arrayList;
    RatingBar ratingBar;
    Button rateButton;
    RatePojo respondOne;

    public SaledItemsAdapter(List<BuyedItemPojo> items, Context context, String sellerZeroBuyerOne) {
        this.items = items;
        this.context = context;
        this.sellerZeroBuyerOne = sellerZeroBuyerOne;
        this.arrayList = new ArrayList<BuyedItemPojo>();
        this.arrayList.addAll(items);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        convertView = LayoutInflater.from(context).inflate(R.layout.content_saled_item, parent, false);
        TextView itemName = convertView.findViewById(R.id.saledItemNameView);
        TextView sellerSteamId = convertView.findViewById(R.id.saledItemSellerSteamIdView);
        TextView buyerSteamId = convertView.findViewById(R.id.saledItemBuyerSteamIdView);
        ratingBar = convertView.findViewById(R.id.userRateBar);
        rateButton = convertView.findViewById(R.id.rateButton);


        final BuyedItemPojo item = items.get(position);
        itemName.setText(item.getItemName() + " ");
        sellerSteamId.setText(item.getSellerSteamId());
        buyerSteamId.setText(item.getBuyerSteamId());

        if (sellerZeroBuyerOne.equals(0)) {
            rates(item.getBuyerId());
        } else {
            rates(item.getSellerId());
        }
        if (item.getItemRated() > 1) {
            rateButton.setEnabled(false);
        }
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getItemRated() < 1) {
                    String ratedItem = item.getItemId();
                    String whoRate = item.getBuyerId();
                    String ratePosition = sellerZeroBuyerOne;
                    String ratedUser = item.getSellerId();
                    String rate = String.valueOf(ratingBar.getRating());
                    rate(ratedItem, whoRate, ratePosition, ratedUser, rate);

                    item.setItemRated(1);
                    view.setEnabled(false);
                }
            }
        });

        View.OnClickListener yourClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //put your desired action here
                v.callOnClick();
            }
        };

        return convertView;
    }


    public void rate(String ratedItem, String whoRate, final String ratePosition, String ratedUser, String rate) {
        final retrofit2.Call<RatePojo> marketLoader = ManagerAll.getInstance().rateUser(ratedItem, whoRate, ratePosition, ratedUser, rate);
        marketLoader.enqueue(new Callback<RatePojo>() {
            @Override
            public void onResponse(final retrofit2.Call<RatePojo> call2, final retrofit2.Response<RatePojo> response) {
            }

            @Override
            public void onFailure(Call<RatePojo> call, Throwable t) {
            }

        });
    }


    public void rates(String buyerId) {
        final Call<UserRate> buyItemModelCall = ManagerAll.getInstance().userRate(buyerId);
        buyItemModelCall.enqueue(new Callback<UserRate>() {
            @Override
            public void onResponse(Call<UserRate> call, retrofit2.Response<UserRate> response) {

                double result = response.body().getRate();
                ratingBar.setRating(Float.parseFloat(String.valueOf(result)));
            }

            @Override
            public void onFailure(Call<UserRate> call, Throwable t) {
            }
        });

    }


}

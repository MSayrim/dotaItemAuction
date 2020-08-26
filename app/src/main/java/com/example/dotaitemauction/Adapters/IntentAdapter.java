package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;

import com.example.dotaitemauction.Activitys.OnSaleItemActivity;
import com.example.dotaitemauction.Activitys.ProfileActivity;
import com.example.dotaitemauction.Activitys.PurchaseItemActivity;
import com.example.dotaitemauction.Activitys.SaledItemActivity;
import com.example.dotaitemauction.Activitys.UpgradeAccountActivity;
import com.example.dotaitemauction.Activitys.UpgradeStatuActivity;

public class IntentAdapter {



    public void profile(Context context)
    {
        Intent profileIntent = new Intent (context, ProfileActivity.class );
        context.startActivity ( profileIntent );
    }
    public void onSaleItem(Context context)
    {
        Intent onSaleItemIntent = new Intent (context, OnSaleItemActivity.class );
        context.startActivity ( onSaleItemIntent );
    }
    public void purchaseItem(Context context)
    {
        Intent purchaseItemIntent = new Intent (context, PurchaseItemActivity.class );
        context.startActivity ( purchaseItemIntent );
    }
    public void saledItem(Context context)
    {
        Intent saledItemIntent = new Intent (context, SaledItemActivity.class );
        context.startActivity ( saledItemIntent );
    }
    public void upgradeAccount(Context context)
    {
        Intent upgradeAccountIntent = new Intent (context, UpgradeAccountActivity.class );
        context.startActivity ( upgradeAccountIntent );
    }
    public void upgradeStatu(Context context)
    {
        Intent upgradeStatuIntent = new Intent (context, UpgradeStatuActivity.class );
        context.startActivity ( upgradeStatuIntent );
    }


}

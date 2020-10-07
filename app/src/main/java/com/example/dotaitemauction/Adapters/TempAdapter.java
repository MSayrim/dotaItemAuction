package com.example.dotaitemauction.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dotaitemauction.Models.MarketItemPojo;
import com.example.dotaitemauction.R;

import java.util.ArrayList;
import java.util.List;

public class TempAdapter extends BaseAdapter implements View.OnClickListener {

    private List<MarketItemPojo> items;
    private Context context;
    ArrayList<MarketItemPojo> arrayList;

    public TempAdapter(List<MarketItemPojo> items , Context context )
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
    public View getView(int i, View view, ViewGroup viewGroup) {


        view = LayoutInflater.from ( context ).inflate ( R.layout.temp_list_content,viewGroup,false );

        final MarketItemPojo item = items.get ( i );

        final TextView itemCurrentCount = view.findViewById ( R.id.tempItem );

        itemCurrentCount.setText ( item.getProductName () );

        View.OnClickListener yourClickListener = new View.OnClickListener () {
            public void onClick(View v) {

                Toast.makeText ( context,"Hatalı şifre veya Kullanıcı adı2222",Toast.LENGTH_LONG ).show ();

                v.callOnClick();
            }
        };

        return view;
    }

    @Override
    public void onClick(View view) {

        Toast.makeText ( context,"Hatalı şifre veya Kullanıcı adı33333",Toast.LENGTH_LONG ).show ();
    }
}

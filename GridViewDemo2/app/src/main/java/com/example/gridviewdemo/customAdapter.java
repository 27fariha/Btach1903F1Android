package com.example.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class customAdapter extends BaseAdapter {
    Context context;
    int logo_index[];
    LayoutInflater layoutInflater;

    public customAdapter(Context context, int[] logo_index) {
        this.context = context;
        this.logo_index = logo_index;
        layoutInflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return logo_index.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=layoutInflater.inflate(R.layout.gridviewimg,null);
        ImageView icon =(ImageView)convertView.findViewById(R.id.imageView);
        icon.setImageResource(logo_index[position]);


        return convertView;
    }
}

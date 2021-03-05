package com.example.customlist1903f1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter {
    Context context;
    int[] img_index;
    String[] imgtitle;
    String[] imgdes;
    LayoutInflater inflater;

    public customAdapter(Context context, int[] img_index, String[] imgtitle, String[] imgdes) {
        this.context = context;
        this.img_index = img_index;
        this.imgtitle = imgtitle;
        this.imgdes = imgdes;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return img_index.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        view=inflater.inflate(R.layout.customlistview,null);
        ImageView img=view.findViewById(R.id.imageView);
        TextView imgtitlee=view.findViewById(R.id.imgtitle);
        TextView imgdesss=view.findViewById(R.id.imgdes);
        img.setImageResource(img_index[i]);
        imgtitlee.setText(imgtitle[i]);
        imgdesss.setText(imgdes[i]);
        return view;
    }
}

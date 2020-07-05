package com.example.shopping_store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class ProductAdapter extends BaseAdapter {
    private LinkedList<Product> products;
    private Context context;

    public ProductAdapter(LinkedList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.product_layout,parent,false);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.imageView);
        TextView Name = (TextView) convertView.findViewById(R.id.name);
        img_icon.setBackgroundResource(products.get(position).getImgId());
        Name.setText(products.get(position).getName());

        return convertView;
    }
}

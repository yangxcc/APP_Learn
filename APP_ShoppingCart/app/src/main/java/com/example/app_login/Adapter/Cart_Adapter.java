package com.example.app_login.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app_login.Bean.CartBean;
import com.example.app_login.R;

import java.util.List;

public class Cart_Adapter extends ArrayAdapter<CartBean> {
    List<CartBean> cartList;
    private int resourceId;
    private Context context;   //在context环境下把cartlist这个数据放到adapter中

    public Cart_Adapter(@NonNull Context context, int resource, @NonNull List<CartBean> objects) {
        super(context, resource, objects);
        this.cartList = objects;
        this.context = context;
        this.resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CartBean cart = cartList.get(position);
        ViewHolder viewHolder;

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(resourceId,null);
            viewHolder = new ViewHolder();
            viewHolder.is_checked = convertView.findViewById(R.id.is_checked);
            viewHolder.type_of_product = convertView.findViewById(R.id.type_of_product);
            viewHolder.price_of_product = convertView.findViewById(R.id.price_of_product);
            viewHolder.number_of_product = convertView.findViewById(R.id.number_of_product);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 获取控件实例
        viewHolder.type_of_product.setText(cart.getType_of_product());
        viewHolder.number_of_product.setText(String.valueOf(cart.getNumber()));
        viewHolder.price_of_product.setText(String.valueOf(cart.getPrice_of_product()));

        viewHolder.is_checked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true){
                    Toast.makeText(context,"已选中",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"取消选中",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView type_of_product;
        TextView price_of_product;
        TextView number_of_product;
        CheckBox is_checked;
    }
}

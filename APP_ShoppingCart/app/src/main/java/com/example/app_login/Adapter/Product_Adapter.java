package com.example.app_login.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app_login.Bean.CartBean;
import com.example.app_login.Bean.ProductBean;
import com.example.app_login.R;

import java.util.ArrayList;
import java.util.List;

public class Product_Adapter extends ArrayAdapter<ProductBean> {
    private int resourceId;
    private Context context;
    private List<ProductBean> productList;
    public static List<CartBean> CartList = new ArrayList<>() ;     //直接使用静态参数，将cartlist值从adapter传到activity中，不用从写接口方法
    CartBean cartBean;  // 要想在适配器中实现传值可以编写一组set、get方法，用上面的方法

//    private CartButtonClickListener cartButtonClickListener;
//
//    //定义一个监控器接口，为了将adapter中的值传入activity中
//    public static interface CartButtonClickListener{
//        public void addClick(List<CartBean> CartList);   // 自行配置参数，需要传到activity中的值
//    }
//
//    public void setCartButtonClickListener(CartButtonClickListener cartButtonClickListener) {
//        this.cartButtonClickListener = cartButtonClickListener;
//    }

    // 适配器的构造函数，把要适配的数据传入这里
    public Product_Adapter(Context context, int resource, List<ProductBean> list) {
        super(context, resource,list);    //!!!!!!!构造函数中拉下了list，导致一直构造成空值
        this.context = context;
        this.productList = list;
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ProductBean product = productList.get(position);  //获取当前的产品示例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        final ViewHolder viewHolder;

        if (convertView == null){
            // 避免ListView每次都要重新加载布局
            convertView = LayoutInflater.from(context).inflate(resourceId,null);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder = new ViewHolder();
            viewHolder.product_image = convertView.findViewById(R.id.product_image);
            viewHolder.product_description = convertView.findViewById(R.id.product_description);
            viewHolder.product_price = convertView.findViewById(R.id.product_price);

            convertView.setTag(viewHolder);  //将控件的实例存储到视图中
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 获取控件实例，并调用set...方法使其显示出来
        viewHolder.product_image.setImageResource(product.getImgUrl());
        viewHolder.product_description.setText(product.getDescription());
        viewHolder.product_price.setText("$"+product.getPrice());
        viewHolder.add_button = convertView.findViewById(R.id.add_button);
        viewHolder.sub_button = convertView.findViewById(R.id.sub_button);
        viewHolder.product_number = convertView.findViewById(R.id.product_number);
        viewHolder.cart = convertView.findViewById(R.id.cart);
        Log.i("xxxx",product.getDescription());

        viewHolder.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(viewHolder.product_number.getText().toString());
                number++;
                viewHolder.product_number.setText(String.valueOf(number));
            //    Log.i("1111", String.valueOf(number));
            }
        });

        viewHolder.sub_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(viewHolder.product_number.getText().toString());
                if (number == 0){
                    viewHolder.product_number.setText(String.valueOf(number));
                    Toast.makeText(context,"并无选购商品，无法减少",Toast.LENGTH_LONG).show();
                }else {
                    number--;
                    viewHolder.product_number.setText(String.valueOf(number));
                }
            }
        });

        viewHolder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = 0;
                int number = Integer.parseInt(viewHolder.product_number.getText().toString());
                if (number==0){
                    Toast.makeText(context,"请先购买，在加入购物车",Toast.LENGTH_SHORT).show();
                }else {
                    total = total + number*product.getPrice();
                    Toast.makeText(context,"您购买了"+number+"件"+product.getDescription()+"总计"+String.valueOf(total)+"元",Toast.LENGTH_SHORT).show();
                    cartBean = new CartBean(product.getDescription(),number,product.getPrice());
                    CartList.add(cartBean);   //现在的问题就是怎么把这个cartlist从适配器弄到activity中
//                    if (cartButtonClickListener!=null){
//                        cartButtonClickListener.addClick(CartList);
//                    }
                    Log.i("11111",String.valueOf(CartList.size()));
                }
            }
        });

    //    Log.i("111111111",this.setCartList(CartList));

        return convertView;
    }

    //自定义内部类，对数据进行缓存
    class ViewHolder{
        ImageView product_image;
        TextView product_description;
        TextView product_price;
        Button sub_button;
        Button add_button;
        TextView product_number;
        ImageButton cart;
    }
}

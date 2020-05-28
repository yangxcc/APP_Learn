package com.example.app_login.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.app_login.Adapter.Cart_Adapter;
import com.example.app_login.Bean.CartBean;
import com.example.app_login.R;

import java.util.ArrayList;
import java.util.List;

public class Shopping_Cart extends AppCompatActivity {
    List<CartBean> cartList = new ArrayList<>();
    Button buy_button;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        initCart();
        Cart_Adapter adapter = new Cart_Adapter(Shopping_Cart.this,R.layout.cart,cartList);
        ListView listView = findViewById(R.id.cart_item_layout);
        listView.setAdapter(adapter);

        buy_button = Shopping_Cart.this.findViewById(R.id.buy_button);
        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                for (int i=0;i<cartList.size();i++){
                    total += cartList.get(i).getPrice_of_product();
                }
                Log.i("111111", String.valueOf(total));
                Toast.makeText(Shopping_Cart.this,"选中商品的总价为"+String.valueOf(total),Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initCart() {
//        CartBean cart1 = new CartBean("lanqiu",10,1);
////        CartBean cart2 = new CartBean("qiuqiu",5,23);
////        cartList.add(cart1);
////        cartList.add(cart2);
        Intent intent = this.getIntent();
        cartList = (List<CartBean>) intent.getSerializableExtra("show_cart");  //现在的问题是没有穿过值来

    }
}

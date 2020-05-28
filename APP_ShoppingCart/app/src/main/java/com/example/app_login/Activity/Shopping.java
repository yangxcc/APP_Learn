package com.example.app_login.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.app_login.Adapter.Product_Adapter;
import com.example.app_login.Bean.CartBean;
import com.example.app_login.Bean.ProductBean;
import com.example.app_login.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shopping extends AppCompatActivity {

    TextView Upper_Navigation;
    private List<ProductBean> productList=new ArrayList<>();
    ListView listView;
    private Button add_button,sub_button;
    private EditText product_number;
    int num = 0;
    Menu menu;
    static  List<CartBean> CartList = new ArrayList<>();


    // 加载选项菜单必须重写这个方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upper_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 设置购物界面中的产品
    public void initProduct(){
        ProductBean product1 = new ProductBean(R.mipmap.basketball,"篮球",66.6);
        ProductBean product2 = new ProductBean(R.mipmap.kobeshoes,"篮球鞋",88.8);
        ProductBean product3 = new ProductBean(R.mipmap.kobecloth,"科比球衣",50.0);
        ProductBean product4 = new ProductBean(R.mipmap.wristband,"24号手环",10);
        ProductBean product5 = new ProductBean(R.mipmap.kobe_book,"科比的书",30.2);
        ProductBean product_null = new ProductBean(R.mipmap.kobe1,"",0.0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product_null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_shopping);
        setContentView(R.layout.activity_shopping);

        Upper_Navigation = Shopping.this.findViewById(R.id.Upper_Navigation);  //一定要写在oncreate后面！！！！
        Intent intent = this.getIntent();
        String username = intent.getStringExtra("username");
        Log.i("1",username);
        Spannable text = new SpannableString("请随意购买,"+username);  //便于设置字体格式
        Log.i("1",text.toString());
        Upper_Navigation.setText(text);

        // 先拿到数据并放在适配器上
        initProduct(); //初始化产品数据
        Product_Adapter adapter=new Product_Adapter(Shopping.this,R.layout.shop,productList);  //adapter没东西,解决了
        Log.i("1111", String.valueOf(adapter.getItem(2)));
        Log.i("1111", String.valueOf(productList.get(2)));

        // 将适配器上的数据传递给listView
        listView=findViewById(R.id.listview);
        listView.setAdapter(adapter);
     //   Log.i("2", String.valueOf(productList.get(2)));

       /*
       * listview中控件的监听要在adapter里面写！！！！！！
       * */

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 根据所选择的不同菜单项来编写不同的代码
        switch (item.getItemId()){
            case R.id.CART:
                // 跳转到Shopping_Cart
                CartList = Product_Adapter.CartList;

                Log.i("111111", String.valueOf(CartList.get(0)));//CartList为空，值没有从适配器传过来,静态变量传过来了
                Intent intent = new Intent();
                intent.setClass(Shopping.this, Shopping_Cart.class);
                intent.putExtra("show_cart", (Serializable) CartList);// 在这里传递一个cartbean类型的列表,在Shoppingcart中得到这个参数
                startActivity(intent);

            case R.id.EXIT:
                Shopping.this.finish();
        }
        return super.onOptionsItemSelected(item);
    }



}

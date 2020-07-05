package com.example.shopping_store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //加载分类列表的fragment
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ListFragment listFragment=new ListFragment();
        ft.replace(R.id.left,listFragment);
        ft.commit();
        //加载商品展示fragment
        FragmentManager manager1 = getSupportFragmentManager();
        FragmentTransaction ft1 = manager1.beginTransaction();
        ProductFragment productFragment=new ProductFragment();
        ft1.replace(R.id.right,productFragment);
        ft1.commit();
    }
}

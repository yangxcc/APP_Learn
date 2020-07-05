package com.example.shopping_store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.LinkedList;
import java.util.List;

public class ProductFragment extends Fragment {
    private List<Product> product= null;
    private Context context;
    private ProductAdapter adapter = null;
    private GridView list_product;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.gridview,container,false);
        list_product = (GridView) view.findViewById(R.id.gridview);
        context=getContext();
        product= new LinkedList<Product>();
        product.add(new Product(R.drawable.shanzhu,"山竹"));
        product.add(new Product(R.drawable.apple,"苹果"));
        product.add(new Product(R.drawable.banana,"香蕉"));
        product.add(new Product(R.drawable.blueberry,"蓝莓"));
        product.add(new Product(R.drawable.coconut,"椰子"));
        product.add(new Product(R.drawable.lemon,"柠檬"));
        product.add(new Product(R.drawable.lizhi,"荔枝"));
        product.add(new Product(R.drawable.mango,"芒果"));
        product.add(new Product(R.drawable.nihoutao,"猕猴桃"));
        product.add(new Product(R.drawable.putao,"葡萄"));
        product.add(new Product(R.drawable.hamigua,"哈密瓜"));
        adapter = new ProductAdapter((LinkedList<Product>)product, context);
        list_product.setAdapter(adapter);

        return view;
    }
}

package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button,button2;           //声明一个button对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);    //这句话决定了选择哪一个布局
        //setContentView(R.layout.mylayout);

        button = findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {        //生命周期的一个阶段，表示activity创建时
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"ok",Toast.LENGTH_LONG).show();    //this代表的是ok显示的位置，Toast.LENGTH_LONG表示ok显示的时间
                button.setText(R.string.button_text);    //同样是读取资源文件，不同的是两者添加的位置不同，这个string资源在values文件夹下的strings.xml
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout layout = findViewById(R.id.layout);
                layout.setOrientation(LinearLayout.HORIZONTAL);
            }
        });
    }
}

package com.example.mywork1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    Button button;
    TextView touming;

    LinearLayout linearLayout;
    SeekBar color_R,color_G,color_B;
    int r = 0,g = 0,b = 0;
    TextView int_r,int_g,int_b;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        setContentView(R.layout.new_layout);

        /*通过seekBar1来改变透明度*/
        seekBar1 = findViewById(R.id.seekBar);
        button = findViewById(R.id.b2);
        touming = findViewById(R.id.touming);
        final int[] tm = {0};
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                /*通知进度已经被修改。客户端可以使用fromUser参数区分用户触发的改变还是编程触发的改变
                * 参数
                * seekBar 当前被修改进度的SeekBar
                * progress 当前的进度值。此值的取值范围为0到max之间。Max为用户通过setMax(int)设置的值，默认为100
                * fromUser如果是用户触发的改变则返回True*/

                //设置button2的背景
                button.getBackground().setAlpha(255-progress);
                tm[0] = seekBar.getProgress();
                String string_tm = "透明度为：" +String.valueOf(tm[0]);
                touming.setText(string_tm);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                /*通知用户已经开始一个触摸拖动手势。
                 * 客户端可能需要使用这个来禁用seekbar的滑动功能。
                 * 参数
                 * seekBar 触摸的SeekBar*/
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                /*通知用户触摸手势已经结束。户端可能需要使用这个来启用seekbar的滑动功能。
                * 参数
                * seekBar 触摸的SeekBar*/
            }
        });
//        Button button = findViewById(R.id.button);
//        button.setBackground(Drawable.createFromPath("@drawable/button_shape"));
         linearLayout = findViewById(R.id.LinearLayout);
         color_R = findViewById(R.id.R);
         color_G = findViewById(R.id.G);
         color_B = findViewById(R.id.B);
         int_r = findViewById(R.id.int_R);
         int_g = findViewById(R.id.int_G);
         int_b = findViewById(R.id.int_B);

         color_R.setMax(255);
         color_G.setMax(255);
         color_B.setMax(255);

         color_R.setProgress(0);
         color_G.setProgress(0);
         color_B.setProgress(0);

         color_R.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {
             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {
                 r = seekBar.getProgress();
                 String int_color_r = "R:"+String.valueOf(r);
                 int_r.setText(int_color_r);
                 linearLayout.setBackgroundColor(Color.rgb(r,g,b));
             }
         });
         color_G.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {
             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {
                 g = seekBar.getProgress();
                 String int_color_g = "G"+String.valueOf(g);
                 int_g.setText(int_color_g);
                 linearLayout.setBackgroundColor(Color.rgb(r,g,b));
             }
         });
         color_B.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {
             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {
                 b = seekBar.getProgress();
                 String int_color_b = "B:"+String.valueOf(b);
                 int_b.setText(int_color_b);
                 linearLayout.setBackgroundColor(Color.rgb(r,g,b));
             }
         });
    }

}

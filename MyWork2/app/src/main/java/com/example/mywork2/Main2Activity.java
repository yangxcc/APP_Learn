package com.example.mywork2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

// 第1种方法,在Java类中载入列表数据,在这里只是列出了一些静态数据，将这些数据加载到spinner中

public class Main2Activity extends AppCompatActivity {

    Spinner spinner;
    TextView textView,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    private ArrayAdapter<String> adapter;
    private List<String> names;
    private String[] text = {"第一条文本内容","电子商务APP开发",
            "来一段很长很长的文本来一段很长很长的文本来一段很长很长的文本来一段很长很长的文本",
            "第二条文本内容","第三个","assssxscecsccd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        find_and_modify_view();
    }
// 加载spinner的文本内容
    public void find_and_modify_view(){
        spinner = findViewById(R.id.spinner);
        names = new ArrayList<String>();
        for (int i=0;i<text.length;i++){
            names.add(text[i]);
        }
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item ,names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

       // 将选中内容加载到textview中
      /*1、走马灯
      * 2、阴影
      * 3、文字旋转
      * 4、文字缩放
      * 5、上下左右加小图修饰
      * 6、五颜六色的背景、前景或边框
      * 7、同一个TextView内的文字具有不同颜色
      * 8、图文混排*/
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected_text = parent.getSelectedItem().toString();
                textView.setText(selected_text);  //将选中内容加载到textview中
                textView2.setText(selected_text);
                textView3.setText(selected_text);
                textView4.setText(selected_text);
                textView5.setText(selected_text);
                textView6.setText(selected_text);

                // 第一个textview走马灯展示(需要是长文本)
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                textView.setFocusable(true);
                textView.setFocusableInTouchMode(true);
                textView.requestFocus();

                //第二个textview阴影效果展示
                textView2.setShadowLayer(1F,11F,5F, Color.RED);

                // 第三个textview旋转
                textView3.setRotation(45);
                textView3.setPivotX(400);
                textView3.setPivotY(0);     //这个是textview旋转，不是其中的文本旋转

                //第4个textview文字缩放
                textView4.setTextScaleX(2);  //scalex、scaley分别表示文字的倍高和倍宽

                //第5个textview文本周围加图标
                Drawable myicon1 = getResources().getDrawable(R.mipmap.ic_launcher_round);
                Drawable myicon2 = getResources().getDrawable(R.drawable.picture);
                myicon1.setBounds(0,0,50,50);
                myicon2.setBounds(0,0,50,50);   //不设置边界显示不出来
                textView5.setCompoundDrawables(myicon1,myicon2,null,null);

                // 第6个textview设置背景、前景或边框  创建xml文件，在其中设计其他属性

                //第7个textview设置同一句话中的不同颜色
                int length = selected_text.length();
                SpannableStringBuilder mystring=new SpannableStringBuilder(selected_text);
                ForegroundColorSpan colorspan=new ForegroundColorSpan(Color.parseColor("#FF7654"));
                mystring.setSpan(colorspan,0,2, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                ForegroundColorSpan colorspan1=new ForegroundColorSpan(Color.parseColor("#9a00ff"));
                mystring.setSpan(colorspan1,3,length, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
                List<AbsoluteSizeSpan> sizeSpans = new ArrayList<AbsoluteSizeSpan>();
                for(int j=1;j<100;j++){
                    AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(j*10);
                    sizeSpans.add(sizeSpan);
                }
                for (int i=0;i<length;i++){
                    mystring.setSpan(sizeSpans.get(i),i,i+1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                }
                textView7.setText(mystring);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //第8个textview图文混排
        SpannableStringBuilder myString=new SpannableStringBuilder("少无适俗韵，性本爱丘山。");
        ImageSpan img = new ImageSpan(this,R.mipmap.ic_launcher_round);   //不能再setOnItemSelectedListener中使用
        myString.setSpan(img,10,11,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView8.setText(myString);


    }


}

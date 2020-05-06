package com.example.mywork2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("1","创建，调用onCreate方法");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("2", "激活，调用onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        long SystemBeginTime = System.currentTimeMillis();
        for (int i=0;i<5000;i++){
            System.out.println("oo");
        }
        long SystemEndTime = System.currentTimeMillis();
        long LogBeginTime = System.currentTimeMillis();
        for (int i=0;i<5000;i++){
            Log.d("test","oo");
        }
        long LogEndTime = System.currentTimeMillis();
        long system =  SystemEndTime - SystemBeginTime ;
        long log =  LogEndTime - LogBeginTime ;
        Log.d("system time",system+"");  //直接按字符串输出，不用把long转换成string类型
        Log.d("log time",log+"");
        Log.i("3","恢复，调用onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("4","暂停，调用onPause方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("5","停止，调用onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("6","销毁，调用onDestory方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("7","重启，调用onRestart方法");
    }
}

package com.example.app_login.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.app_login.R;

public class MainActivity extends AppCompatActivity {
    Button Login_Button;
    RadioButton Agree_RadioButton;
    AutoCompleteTextView login_input_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login_input_text = findViewById(R.id.login_input_username);
        String[] tips = getResources().getStringArray(R.array.username);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,tips);
        login_input_text.setAdapter(adapter);
        login_input_text.setThreshold(1);   // 输入一个字符便开始提示

        Login_Button = findViewById(R.id.login_btn);

        Agree_RadioButton = findViewById(R.id.agree_radioButton);
        Agree_RadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("是否标记为已读");
                builder.setMessage("需要获得登陆权限，是否同意");
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Agree_RadioButton.setChecked(true);
                        Login_Button.setEnabled(true);
                        Login_Button.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_selector));
                    }
                });
                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Agree_RadioButton.setChecked(false);
                        Login_Button.setEnabled(false);
                    }
                });
                builder.create().show();
            }
        });

        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, Shopping.class);
                intent.putExtra("username",login_input_text.getText().toString());
                startActivity(intent);
            }
        });
    }
}

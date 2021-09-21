package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";

    EditText username, password;
    Button btn_user, btn_guest;
    TextView user, line;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_user = findViewById(R.id.btn_login_user);
        btn_guest = findViewById(R.id.btn_login_guest);
        user = findViewById(R.id.user);
        line = findViewById(R.id.line);

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                String password_text = password.getText().toString();
                if (username_text.length() == 0)
                    username.setHint("Bạn chưa nhập tên đăng nhập");
                if (password_text.length() == 0)
                    password.setHint("Bạn chưa nhập mật khẩu");
                if (username_text.length() > 0){
                    if (password_text.length() > 0){
                        Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                        intent.putExtra(KEY_USER_TO_MAIN, username_text);
                        startActivity(intent);
                    }

                }
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username_text = username.getText().toString();
                if (btn_guest.getText().toString().equals("Tài khoản khách")) {
                    Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}
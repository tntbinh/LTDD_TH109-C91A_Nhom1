package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.app.Person;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newsapp.object.ConnectionReceiver;
import com.example.newsapp.object.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";

    EditText username, password;
    Button btn_user, btn_guest, btn_register;
    TextView line, error;
    ArrayList<User> userList = new ArrayList<>();

    User user1 = new User("user1", "123456789");
    User user2 = new User("user2", "12345");
    User admin = new User("admin", "11111");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        getAllUser();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_user = findViewById(R.id.btn_login_user);
        btn_guest = findViewById(R.id.btn_login_guest);
        btn_register = findViewById(R.id.btn_register);
        line = findViewById(R.id.line);
        error = findViewById(R.id.error);

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ret = ConnectionReceiver.isConnected();
                if (ret == true){
                    error.setText("");
                    boolean flag = false;
                    String username_text = username.getText().toString();
                    String password_text = password.getText().toString();
                    if (username_text.length() == 0)
                        username.setHint("Bạn chưa nhập tên đăng nhập");
                    if (password_text.length() == 0)
                        password.setHint("Bạn chưa nhập mật khẩu");
                    if (username_text.length() > 0){
                        if (password_text.length() > 0){
                            for (int i = 0; i < userList.size(); i++) {
                                if (userList.get(i).getUsername().equals(username_text)){
                                    if (userList.get(i).getPassword().equals(password_text)){
                                        flag = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (flag){
                            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                            intent.putExtra(KEY_USER_TO_MAIN, username_text);
                            startActivity(intent);
                        }
                        else{
                            username.setText("");
                            password.setText("");
                            username.setHint("Không hợp lệ");
                            password.setHint("Không hợp lệ");
                        }
                    }
                }
                else{
                    error.setText("Thiết bị chưa kết nối internet");
                }
            }
        });

        btn_guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ret = ConnectionReceiver.isConnected();
                if (ret == true){
                    error.setText("");
                    Intent intent = new Intent(MainActivity.this, NewsActivity.class);
                    startActivity(intent);
                }
                else{
                    error.setText("Thiết bị chưa kết nối internet");
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void getAllUser(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference allPost = database.getReference("users");

        allPost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    User user = item.getValue(User.class);
                    userList.add(user);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(MainActivity.this, "Get list users fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
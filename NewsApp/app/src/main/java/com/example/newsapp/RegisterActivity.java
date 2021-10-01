package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.newsapp.object.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    Button confirm, close;
    ArrayList<User> userList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getAllUser();
        confirm = findViewById(R.id.btn_confirm);
        close = findViewById(R.id.btn_close);
        EditText edtUserName = findViewById(R.id.edtName);
        EditText edtPassword = findViewById(R.id.edtEmail);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = edtUserName.getText().toString();
                String txt_password = edtPassword.getText().toString();
                if (txt_username.length() > 0){
                    if (txt_password.length() > 0){
                        User new_user = new User(txt_username, txt_password);
                        if(!checkUserExist(new_user)){
                            addUser(new_user);
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                        else{
                            edtUserName.setText("");
                            edtPassword.setText("");
                            edtUserName.setHint("Tài khoản đã tồn tại");
                            edtPassword.setHint("Tài khoản đã tồn tại");
                        }
                    }
                }
                else{
                    edtUserName.setText("");
                    edtPassword.setText("");
                    edtUserName.setHint("Không hợp lệ");
                    edtPassword.setHint("Không hợp lệ");
                }
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private boolean checkUserExist(User user){
        boolean flag = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(user.getUsername())){
                flag = true;
                break;
            }
        }
        return flag;
    }

    private void getAllUser(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference allPost = database.getReference("users");

        allPost.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot item : dataSnapshot.getChildren()) {
                    User getuser = item.getValue(User.class);
                    userList.add(getuser);
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(RegisterActivity.this, "Get list users fail", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void addUser(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");
        String pathObject = String.valueOf(user.getUsername());
        myRef.child(pathObject).setValue(user);
    }
}
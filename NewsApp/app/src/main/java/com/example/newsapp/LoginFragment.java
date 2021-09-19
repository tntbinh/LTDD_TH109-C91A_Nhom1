package com.example.newsapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginFragment extends Fragment {

    EditText username, password;
    Button btn_user, btn_guest;
    TextView user, line;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        btn_user = view.findViewById(R.id.btn_login_user);
        btn_guest = view.findViewById(R.id.btn_login_guest);
        user = view.findViewById(R.id.user);
        line = view.findViewById(R.id.line);

        btn_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username.setVisibility(View.INVISIBLE);
                password.setVisibility(View.INVISIBLE);
                btn_user.setVisibility(View.INVISIBLE);
                btn_guest.setVisibility(View.INVISIBLE);
                line.setVisibility(View.INVISIBLE);
                user.setText("Xin chào " + username.getText().toString());
                user.setVisibility(View.VISIBLE);

            }
        });
        return view;
    }
}
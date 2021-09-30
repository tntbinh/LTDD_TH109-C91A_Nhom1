package com.example.newsapp.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.newsapp.DetailItemSearchActivity;
import com.example.newsapp.object.SearchYoutube;
import com.example.newsapp.R;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class VideoFragment extends Fragment {
    @Nullable

    ImageButton btnVNE;
    ImageButton btnTNien;
    ImageButton btnTT;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        btnVNE = view.findViewById(R.id.btnVNE);
        btnTNien = view.findViewById(R.id.btnTNien);
        btnTT = view.findViewById(R.id.btnTTre);

        btnVNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goToPage("youtube.com/c/VnExpressOfficial");
                Intent intent = new Intent(getActivity(), DetailItemSearchActivity.class);
                intent.putExtra("linkTinTuc", "https://www.youtube.com/channel/UCVRqZH5QnrnbMWhElPBD-MQ");
                startActivity(intent);
            }
        });
        btnTNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goToPage("facebook.com/congdongvnexpress");
                Intent intent = new Intent(getActivity(), DetailItemSearchActivity.class);
                intent.putExtra("linkTinTuc", "https://facebook.com/congdongvnexpress");
                startActivity(intent);
            }
        });
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                goToPage("vnexpress.net/podcast");
                Intent intent = new Intent(getActivity(), DetailItemSearchActivity.class);
                intent.putExtra("linkTinTuc", "https://vnexpress.net/podcast");
                startActivity(intent);
            }
        });

        return view;
    }


}

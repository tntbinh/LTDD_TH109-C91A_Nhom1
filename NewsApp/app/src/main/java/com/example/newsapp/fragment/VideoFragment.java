package com.example.newsapp.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

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

    int width = 0;

    WebView mWebView;
    SearchView searchView;

    String keyWord;

    String url_api = "";

    LinearLayout mLinearLayout_introBtn;

    ImageButton btnVNE;
    ImageButton btnTNien;
    ImageButton btnTT;

    ImageButton btnBack;
    ImageButton btnHome;

    @SuppressLint("SetJavaScriptEnabled")
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        mWebView = view.findViewById(R.id.webView_YoutubeResult);
        searchView = view.findViewById(R.id.searchView_Video);
        btnVNE = view.findViewById(R.id.btnVNE);
        btnTNien = view.findViewById(R.id.btnTNien);
        btnTT = view.findViewById(R.id.btnTTre);
        btnBack = view.findViewById(R.id.btn_Back);
        btnHome = view.findViewById(R.id.btn_Home);

        btnVNE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage("youtube.com/c/VnExpressOfficial");
                mLinearLayout_introBtn.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
            }
        });
        btnTNien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage("youtube.com/c/BáoThanhNiênTV");
                mLinearLayout_introBtn.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
            }
        });
        btnTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPage("https://www.youtube.com/c/B%C3%A1oTu%E1%BB%95iTr%E1%BA%BBtv");
                mLinearLayout_introBtn.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mWebView.goBack();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.setVisibility(View.GONE);
                mLinearLayout_introBtn.setVisibility(View.VISIBLE);
                mWebView.loadUrl("about:blank");
                mWebView.clearHistory();
            }
        });



        mLinearLayout_introBtn = view.findViewById(R.id.linearLayout_introButton);

        mWebView.setVisibility(View.GONE);

        width = (int) getActivity().getApplicationContext().getResources().getDisplayMetrics().xdpi;

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                keyWord = searchView.getQuery().toString();

                mLinearLayout_introBtn.setVisibility(View.GONE);
                mWebView.setVisibility(View.VISIBLE);

                SearchYoutube dR = new SearchYoutube(mWebView, keyWord ,width);
                url_api = EntriesTraCau();
                dR.execute(url_api);

                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return view;
    }

    private String EntriesTraCau() {
        final String word = keyWord;
        final String word_id = word.toLowerCase();
        return "https://api.tracau.vn/WBBcwnwQpV89/trans/" + word_id;
    }

    public void goToPage(String URL){
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://www." + URL);
    }


}

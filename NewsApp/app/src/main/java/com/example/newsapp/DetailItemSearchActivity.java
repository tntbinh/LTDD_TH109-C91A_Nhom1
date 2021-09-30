package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class DetailItemSearchActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_item_search);

        webview = (WebView) findViewById(R.id.webviewTinTuc);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().getDomStorageEnabled();

        Intent intent = getIntent();

        String link = intent.getStringExtra("linkTinTuc");

        webview.loadUrl(link);

        webview.setWebViewClient(new loadWebView());
    }
    private class loadWebView extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
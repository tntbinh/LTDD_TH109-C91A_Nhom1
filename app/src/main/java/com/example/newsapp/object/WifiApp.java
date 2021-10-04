package com.example.newsapp.object;

import android.app.Application;
/**
 * Created by https://giasutinhoc.vn
 */
public class WifiApp extends Application {
    static WifiApp wifiInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        wifiInstance = this;
    }
    public static synchronized WifiApp getInstance() {
        return wifiInstance;
    }
}
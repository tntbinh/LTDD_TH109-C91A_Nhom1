package com.example.newsapp.object;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.newsapp.object.WifiApp;

/**
 * Created by https://giasutinhoc.vn
 */
public class ConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
    }
    public static boolean isConnected() {
        ConnectivityManager
                cm = (ConnectivityManager) WifiApp.getInstance().getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }
}
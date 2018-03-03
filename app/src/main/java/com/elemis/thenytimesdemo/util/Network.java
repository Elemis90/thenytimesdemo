package com.elemis.thenytimesdemo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.elemis.thenytimesdemo.R;

/**
 * Created by elemis on 2018. 02. 25..
 */

public final class Network {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        boolean isOnline = netInfo != null && netInfo.isConnectedOrConnecting();
        if (!isOnline) {
            Toast.makeText(context, R.string.noInternet, Toast.LENGTH_SHORT).show();
        }
        return isOnline;
    }
}
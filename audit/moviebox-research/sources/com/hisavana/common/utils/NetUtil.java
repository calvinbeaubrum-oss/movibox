package com.hisavana.common.utils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.cloud.sdk.commonutil.util.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NetUtil {
    public static boolean checkNetworkState() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (f.a().getApplicationContext() == null || (connectivityManager = (ConnectivityManager) f.a().getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}

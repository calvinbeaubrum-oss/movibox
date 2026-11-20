package com.cloud.tmc.integration.networkenv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class NetworkReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f30831a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f30832b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f30833c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f30834d = -3;

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return 0;
            }
            if (activeNetworkInfo.getType() == 0) {
                return 1;
            }
        }
        return -1;
    }

    public long b() {
        return Long.valueOf(new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())).longValue();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            long jB = b();
            if (jB == f30831a || jB == f30832b || jB == f30833c) {
                return;
            }
            int iA = a(context);
            if (iA == 0 && f30834d != 0) {
                f30831a = jB;
                f30834d = iA;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("wifi：");
                sb2.append(jB);
                return;
            }
            if (iA == 1 && f30834d != 1) {
                f30832b = jB;
                f30834d = iA;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("数据网络：");
                sb3.append(jB);
                return;
            }
            if (iA != -1 || f30834d == -1) {
                return;
            }
            f30833c = jB;
            f30834d = iA;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("无网络：");
            sb4.append(jB);
        }
    }
}

package com.transsion.ga;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import athena.j0;
import com.alibaba.sdk.android.oss.common.RequestParameters;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f51967b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f51968a = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if ("android.intent.action.SCREEN_OFF".equals(action)) {
            j0.f13695c = false;
            return;
        }
        if ("android.intent.action.SCREEN_ON".equals(action)) {
            j0.f13695c = true;
            return;
        }
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            if (this.f51968a) {
                this.f51968a = false;
                return;
            }
            try {
                if (j0.r(context) && j0.f13695c) {
                    AthenaAnalytics.P();
                    AthenaAnalytics.u();
                    return;
                }
                return;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
        if ("android.location.PROVIDERS_CHANGED".equals(action)) {
            if (j0.g(context, "android.permission.ACCESS_FINE_LOCATION") || j0.g(context, "android.permission.ACCESS_COARSE_LOCATION")) {
                try {
                    LocationManager locationManager = (LocationManager) context.getApplicationContext().getSystemService(RequestParameters.SUBRESOURCE_LOCATION);
                    if (!locationManager.isProviderEnabled("gps") && !locationManager.isProviderEnabled("network")) {
                        return;
                    }
                    AthenaAnalytics.z(9999).e(502, 3000L);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
    }
}

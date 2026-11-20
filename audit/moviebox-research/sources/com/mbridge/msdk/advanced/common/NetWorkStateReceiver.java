package com.mbridge.msdk.advanced.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbsignalcommon.windvane.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class NetWorkStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f42791a = "NetWorkStateReceiver";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebView f42792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f42793c;

    public NetWorkStateReceiver(WebView webView) {
        this.f42792b = webView;
    }

    private void a(WebView webView, int i11) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i11);
                g.a().a(webView, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th2) {
                ad.a(f42791a, th2.getMessage());
            }
        }
    }

    public final void a() {
        this.f42792b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.f42792b, 0);
                return;
            }
            if (!com.mbridge.msdk.foundation.same.a.f44390z) {
                a(this.f42792b, 0);
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                a(this.f42792b, 0);
                return;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                if (activeNetworkInfo.getType() == 1) {
                    a(this.f42792b, 9);
                    return;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    a(this.f42792b, 0);
                    return;
                }
                int networkType = telephonyManager.getNetworkType();
                this.f42793c = networkType;
                int iB = z.b(networkType);
                this.f42793c = iB;
                a(this.f42792b, iB);
            }
        } catch (Throwable th2) {
            ad.a(f42791a, th2.getMessage());
        }
    }
}

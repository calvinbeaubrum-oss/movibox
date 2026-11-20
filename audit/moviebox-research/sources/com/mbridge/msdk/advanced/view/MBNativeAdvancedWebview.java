package com.mbridge.msdk.advanced.view;

import android.content.Context;
import android.content.IntentFilter;
import com.mbridge.msdk.advanced.common.NetWorkStateReceiver;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import kn.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class MBNativeAdvancedWebview extends WindVaneWebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f42870e = "MBNativeAdvancedWebview";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f42871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private NetWorkStateReceiver f42872g;

    public MBNativeAdvancedWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            b bVar = this.f42871f;
            if (bVar != null) {
                bVar.c();
                this.f42871f = null;
                ad.a("OMSDK", "finish adSession");
            }
        } catch (Exception e11) {
            ad.a("OMSDK", e11.getMessage());
        }
    }

    public b getAdSession() {
        return this.f42871f;
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerNetWorkReceiver();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unregisterNetWorkReceiver();
    }

    public void registerNetWorkReceiver() {
        try {
            if (this.f42872g == null) {
                this.f42872g = new NetWorkStateReceiver(this);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            getContext().registerReceiver(this.f42872g, intentFilter);
        } catch (Throwable th2) {
            ad.a(f42870e, th2.getMessage());
        }
    }

    public void setAdSession(b bVar) {
        this.f42871f = bVar;
    }

    public void unregisterNetWorkReceiver() {
        try {
            NetWorkStateReceiver netWorkStateReceiver = this.f42872g;
            if (netWorkStateReceiver != null) {
                netWorkStateReceiver.a();
                getContext().unregisterReceiver(this.f42872g);
            }
        } catch (Throwable th2) {
            ad.a(f42870e, th2.getMessage());
        }
    }
}

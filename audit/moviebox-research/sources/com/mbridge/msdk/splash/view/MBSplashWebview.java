package com.mbridge.msdk.splash.view;

import android.content.Context;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import kn.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class MBSplashWebview extends WindVaneWebView {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f47297e = "MBSplashWebview";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f47298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f47299g;

    public MBSplashWebview(Context context) {
        super(context);
        setBackgroundColor(0);
    }

    public void finishAdSession() {
        try {
            b bVar = this.f47299g;
            if (bVar != null) {
                bVar.c();
                this.f47299g = null;
                ad.a("OMSDK", "finish adSession");
            }
        } catch (Exception e11) {
            ad.a("OMSDK", e11.getMessage());
        }
    }

    public b getAdSession() {
        return this.f47299g;
    }

    public String getRequestId() {
        return this.f47298f;
    }

    public void setAdSession(b bVar) {
        this.f47299g = bVar;
    }

    public void setRequestId(String str) {
        this.f47298f = str;
    }
}

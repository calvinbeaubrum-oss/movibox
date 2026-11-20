package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.mbsignalcommon.base.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Boolean f45749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f45750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Boolean f45751c;

    public static boolean a(final Context context) {
        g gVarA;
        try {
            gVarA = h.a().a(c.m().k());
        } catch (Exception unused) {
            gVarA = null;
        }
        if (gVarA != null) {
            f45751c = Boolean.valueOf(gVarA.aE());
        } else {
            f45751c = Boolean.FALSE;
        }
        Boolean bool = f45751c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f45749a == null) {
                try {
                    f45749a = Boolean.valueOf(c(context));
                } catch (Exception unused2) {
                    f45749a = Boolean.FALSE;
                }
            }
            if (f45749a == null) {
                f45749a = new Boolean(false);
            }
            return f45749a.booleanValue();
        }
        if (f45749a == null && f45750b == null) {
            f45750b = new Handler(Looper.getMainLooper());
            f45750b.post(new Runnable() { // from class: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.f45749a == null) {
                        try {
                            Boolean unused3 = a.f45749a = Boolean.valueOf(a.c(context));
                        } catch (Exception unused4) {
                            Boolean unused5 = a.f45749a = Boolean.FALSE;
                        }
                    }
                }
            });
        }
        if (f45749a == null) {
            return true;
        }
        return f45749a.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
            webView.setWebViewClient(new b());
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        try {
            webView.destroy();
            return true;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            ad.a("MBWebViewChecker", "destroy webview error", e11);
            return true;
        }
    }
}

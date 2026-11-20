package com.bytedance.sdk.openadsdk.core.widget.sc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Tf;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class zY {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WeakReference<Context> f28567sc;
    private boolean pFF = true;
    private final boolean zY = true;
    private final boolean We = true;
    private final boolean ExN = false;
    private final boolean TRI = true;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f28566qr = true;

    private zY(Context context) {
        this.f28567sc = new WeakReference<>(context);
    }

    public static void pFF(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th2) {
            Tf.pFF(th2.toString());
        }
    }

    public static zY sc(Context context) {
        return new zY(context);
    }

    private void sc(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th2) {
            Tf.pFF(th2.toString());
        }
    }

    public static void sc(com.bytedance.sdk.component.Ol.We we2) {
        if (we2 == null) {
            return;
        }
        int iSc = com.bytedance.sdk.openadsdk.YIK.sc.sc("clear_web_cache_new", 0);
        if (iSc == 0) {
            we2.sc(true);
        } else if (iSc == 1) {
            we2.sc(false);
        }
    }

    public zY pFF(boolean z11) {
        this.pFF = z11;
        return this;
    }

    public zY sc(boolean z11) {
        this.f28566qr = z11;
        return this;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void sc(WebView webView) {
        if (webView == null || this.f28567sc.get() == null) {
            return;
        }
        pFF(webView);
        WebSettings settings = webView.getSettings();
        sc(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e11) {
            Tf.sc("SSWebSettings", e11.getMessage());
        }
        try {
            if (this.pFF) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th2) {
            Tf.sc("SSWebSettings", th2.getMessage());
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setSavePassword(false);
        try {
            if (this.f28566qr) {
                webView.setLayerType(2, null);
            } else {
                webView.setLayerType(0, null);
            }
        } catch (Throwable th3) {
            Tf.sc("SSWebSettings", th3.getMessage());
        }
    }
}

package com.applovin.impl;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.CollectionUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tr {
    public static void a(WebView webView) {
        ViewParent parent = webView.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(webView);
        }
        webView.loadUrl("about:blank");
        webView.onPause();
    }

    public static void a(WebView webView, String str) {
        if (webView == null) {
            return;
        }
        if (z3.e()) {
            webView.evaluateJavascript(str, null);
            return;
        }
        webView.loadUrl("javascript:" + str);
    }

    public static void a(WebView webView, String str, String str2, com.applovin.impl.sdk.j jVar) {
        if (webView == null) {
            return;
        }
        try {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a(str2, "Forwarding \"" + str + "\" to WebView");
            }
            webView.loadUrl(str);
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a(str2, "Unable to forward to WebView", th2);
            }
            jVar.E().a(str2, th2, CollectionUtils.hashMap("operation", str));
        }
    }

    public static void b(WebView webView) {
        if (webView == null) {
            return;
        }
        a(webView);
        webView.removeAllViews();
        webView.destroyDrawingCache();
        webView.destroy();
    }
}

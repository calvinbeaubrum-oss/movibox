package com.bytedance.sdk.component.sc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WP extends sc {
    static final /* synthetic */ boolean WH = true;
    protected WebView Ol;
    protected String Qj;

    private void sc(String str, final String str2) {
        if (this.TRI || TextUtils.isEmpty(str2)) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.component.sc.WP.1
            @Override // java.lang.Runnable
            public void run() {
                if (WP.this.TRI) {
                    return;
                }
                try {
                    WP.this.Ol.evaluateJavascript(str2, null);
                } catch (Throwable unused) {
                }
            }
        };
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.We.post(runnable);
        } else {
            runnable.run();
        }
    }

    public void We() {
        this.Ol.removeJavascriptInterface(this.Qj);
    }

    @Override // com.bytedance.sdk.component.sc.sc
    @JavascriptInterface
    public void invokeMethod(String str) {
        super.invokeMethod(str);
    }

    @Override // com.bytedance.sdk.component.sc.sc
    public void pFF() {
        super.pFF();
        We();
    }

    @Override // com.bytedance.sdk.component.sc.sc
    @SuppressLint({"JavascriptInterface", "AddJavascriptInterface"})
    public void pFF(WH wh2) {
        this.Ol = wh2.f27001sc;
        this.Qj = wh2.zY;
        if (wh2.SR) {
            return;
        }
        zY();
    }

    @Override // com.bytedance.sdk.component.sc.sc
    public Context sc(WH wh2) {
        Context context = wh2.ExN;
        if (context != null) {
            return context;
        }
        WebView webView = wh2.f27001sc;
        if (webView != null) {
            return webView.getContext();
        }
        throw new IllegalStateException("WebView cannot be null!");
    }

    @Override // com.bytedance.sdk.component.sc.sc
    public String sc() {
        return this.Ol.getUrl();
    }

    @Override // com.bytedance.sdk.component.sc.sc
    public void sc(String str) {
        sc(str, "javascript:" + this.Qj + "._handleMessageFromToutiao(" + str + ")");
    }

    @Override // com.bytedance.sdk.component.sc.sc
    public void sc(String str, dE dEVar) {
        if (dEVar == null || TextUtils.isEmpty(dEVar.Qj)) {
            super.sc(str, dEVar);
            return;
        }
        String str2 = dEVar.Qj;
        sc(str, String.format("javascript:(function(){   const iframe = document.querySelector(atob('%s'));   if (iframe && iframe.contentWindow) {        iframe.contentWindow.postMessage(%s, atob('%s'));   }})()", Base64.encodeToString(String.format("iframe[src=\"%s\"", str2).getBytes(), 2), str, Base64.encodeToString(str2.getBytes(), 2)));
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void zY() {
        if (!WH && this.Ol == null) {
            throw new AssertionError();
        }
        this.Ol.addJavascriptInterface(this, this.Qj);
    }
}

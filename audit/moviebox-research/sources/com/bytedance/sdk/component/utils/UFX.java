package com.bytedance.sdk.component.utils;

import android.annotation.TargetApi;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class UFX {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final sc f27032sc = new pFF();

    /* JADX INFO: compiled from: source.java */
    @TargetApi(19)
    public static class pFF extends sc {
        private pFF() {
            super();
        }

        @Override // com.bytedance.sdk.component.utils.UFX.sc
        public void sc(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            if (str != null && str.startsWith("javascript:")) {
                try {
                    webView.evaluateJavascript(str, null);
                    return;
                } catch (Throwable th2) {
                    boolean z11 = th2 instanceof IllegalStateException;
                }
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class sc {
        private sc() {
        }

        public void sc(WebView webView, String str) {
            if (webView == null) {
                return;
            }
            try {
                webView.loadUrl(str);
            } catch (Throwable unused) {
            }
        }
    }

    public static void sc(WebView webView, String str) {
        f27032sc.sc(webView, str);
    }
}

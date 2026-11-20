package com.vungle.warren.ui.view;

import android.annotation.SuppressLint;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class g {
    @SuppressLint({"NewApi"})
    public static void a(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        webView.setVisibility(4);
    }
}

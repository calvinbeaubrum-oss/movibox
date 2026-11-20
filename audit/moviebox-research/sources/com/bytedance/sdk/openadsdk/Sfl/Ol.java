package com.bytedance.sdk.openadsdk.Sfl;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ol {
    private static void pFF(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th2) {
            qr.sc("WebViewSettings", "removeJavascriptInterfacesSafe error", th2);
        }
    }

    private static void sc(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th2) {
            qr.sc("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th2);
        }
    }

    public static void sc(WebView webView) {
        if (webView == null) {
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
        } catch (Throwable th2) {
            qr.sc("WebViewSettings", "setJavaScriptEnabled error", th2);
        }
        try {
            settings.setSupportZoom(false);
        } catch (Throwable th3) {
            qr.sc("WebViewSettings", "setSupportZoom error", th3);
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setBlockNetworkImage(false);
        settings.setDisplayZoomControls(false);
        int i11 = Build.VERSION.SDK_INT;
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setSavePassword(false);
        boolean z11 = i11 >= 28;
        try {
            if (z11) {
                if (z11) {
                    webView.setLayerType(2, null);
                }
                webView.getSettings().setMixedContentMode(0);
            }
            webView.setLayerType(0, null);
        } catch (Throwable th4) {
            qr.sc("WebViewSettings", "setLayerType error", th4);
        }
        webView.getSettings().setMixedContentMode(0);
    }
}

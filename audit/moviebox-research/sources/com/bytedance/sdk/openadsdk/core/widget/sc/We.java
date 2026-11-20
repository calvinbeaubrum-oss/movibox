package com.bytedance.sdk.openadsdk.core.widget.sc;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.We.UFX;
import com.bytedance.sdk.openadsdk.core.HJN;
import com.bytedance.sdk.openadsdk.core.SR;
import com.bytedance.sdk.openadsdk.utils.Xc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class We extends WebChromeClient {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static final String f28561sc = WebChromeClient.class.getSimpleName();
    private com.bytedance.sdk.openadsdk.common.We We;
    private final HJN pFF;
    private UFX zY;

    public We(HJN hjn) {
        this.pFF = hjn;
    }

    public We(HJN hjn, UFX ufx) {
        this.pFF = hjn;
        this.zY = ufx;
    }

    public We(HJN hjn, UFX ufx, com.bytedance.sdk.openadsdk.common.We we2) {
        this(hjn, ufx);
        this.We = we2;
    }

    private boolean sc(@NonNull final String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (str.regionMatches(true, 0, "bytedance:", 0, 10)) {
                SR.zY().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.widget.sc.We.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Xc.sc(Uri.parse(str), We.this.pFF);
                    }
                });
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i11, String str2) {
        if (!TextUtils.isEmpty(str)) {
            sc(str);
        }
        super.onConsoleMessage(str, i11, str2);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !sc(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i11) {
        super.onProgressChanged(webView, i11);
        UFX ufx = this.zY;
        if (ufx != null) {
            ufx.sc(webView, i11);
        }
        com.bytedance.sdk.openadsdk.common.We we2 = this.We;
        if (we2 != null) {
            we2.sc(webView, i11);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }
}

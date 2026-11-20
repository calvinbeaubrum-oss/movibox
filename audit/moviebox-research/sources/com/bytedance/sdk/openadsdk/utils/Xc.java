package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Xc {
    public static String sc(WebView webView, int i11) {
        if (webView == null) {
            return "";
        }
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return "";
        }
        return userAgentString + " open_news open_news_u_s/" + i11;
    }

    public static void sc(Uri uri, com.bytedance.sdk.openadsdk.core.HJN hjn) {
        if (hjn == null || !hjn.sc(uri)) {
            return;
        }
        try {
            hjn.pFF(uri);
        } catch (Exception e11) {
            e11.toString();
        }
    }
}

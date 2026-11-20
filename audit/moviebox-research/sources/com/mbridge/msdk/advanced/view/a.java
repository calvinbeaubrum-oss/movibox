package com.mbridge.msdk.advanced.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.advanced.b.c;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f42876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.advanced.b.a f42877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f42878c = "NativeAdvancedWebViewClient";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f42879d = x.a("YkRXhr5AWBPfNgzuH7JQ+2Ha");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f42880e = x.a("Y+xgWkl2");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c f42881f;

    public a(String str, com.mbridge.msdk.advanced.b.a aVar, c cVar) {
        this.f42876a = str;
        this.f42877b = aVar;
        this.f42881f = cVar;
    }

    private WebResourceResponse a(WebView webView, String str) {
        Uri uri;
        String scheme;
        if (!TextUtils.isEmpty(str) && this.f42881f != null) {
            try {
                String strD = "";
                if (str.startsWith("file") && str.contains(this.f42879d)) {
                    strD = str.replace("file://", "");
                }
                if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (scheme = uri.getScheme()) != null && !TextUtils.isEmpty(scheme) && (scheme.equals(this.f42880e) || scheme.equals("mb-h5"))) {
                    strD = this.f42881f.d(URLDecoder.decode(Uri.parse(str).getQueryParameter("uri")));
                }
                if (!TextUtils.isEmpty(strD)) {
                    ad.a("NativeAdvancedWebViewClient", "replace url : " + strD);
                    if (!strD.contains("127.0.0.1") && !strD.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        HashMap map = new HashMap();
                        map.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                        WebResourceResponse webResourceResponse = new WebResourceResponse(MimeTypes.VIDEO_MP4, "utf-8", new FileInputStream(strD));
                        webResourceResponse.setResponseHeaders(map);
                        return webResourceResponse;
                    }
                    return null;
                }
            } catch (Throwable th2) {
                ad.b("NativeAdvancedWebViewClient", th2.getMessage());
            }
        }
        return null;
    }

    public final void a() {
        if (this.f42881f != null) {
            this.f42881f = null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.c.b.a.a().b(), new ValueCallback<String>() { // from class: com.mbridge.msdk.advanced.view.a.1
                @Override // android.webkit.ValueCallback
                public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                }
            });
        } catch (Throwable th2) {
            ad.a("NativeAdvancedWebViewClient", "onPageStarted", th2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return a(webView, webResourceRequest.getUrl().toString());
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return a(webView, str);
    }

    @Override // com.mbridge.msdk.mbsignalcommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            try {
                WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
                if (System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.b.a.f43105c && com.mbridge.msdk.click.b.a.a(((com.mbridge.msdk.advanced.signal.b) windVaneWebView.getObject()).a().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f43104b)) {
                    return false;
                }
            } catch (Exception e11) {
                ad.b("NativeAdvancedWebViewClient", e11.getMessage());
            }
            ad.b("NativeAdvancedWebViewClient", "Use html to open url.");
            com.mbridge.msdk.advanced.b.a aVar = this.f42877b;
            if (aVar == null) {
                return true;
            }
            aVar.a(false, str);
            return true;
        } catch (Throwable th2) {
            ad.a("NativeAdvancedWebViewClient", "shouldOverrideUrlLoading", th2);
            return false;
        }
    }
}

package com.bytedance.sdk.component.Ol;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebBackForwardList;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends WebViewClient {
    private final sc.InterfaceC0245sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final WebViewClient f26542sc;
    private final List<String> zY;

    public ExN(sc.InterfaceC0245sc interfaceC0245sc, WebViewClient webViewClient, List<String> list) {
        this.pFF = interfaceC0245sc;
        this.f26542sc = webViewClient;
        this.zY = list;
    }

    private int sc(WebView webView) {
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            if (webBackForwardListCopyBackForwardList != null) {
                return webBackForwardListCopyBackForwardList.getCurrentIndex() + 1;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f26542sc.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        sc.InterfaceC0245sc interfaceC0245sc = this.pFF;
        if (interfaceC0245sc != null) {
            interfaceC0245sc.sc(sc(webView));
        }
        this.f26542sc.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        this.f26542sc.onReceivedError(webView, i11, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f26542sc.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f26542sc.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.f26542sc.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return Build.VERSION.SDK_INT >= 26 ? this.f26542sc.onRenderProcessGone(webView, renderProcessGoneDetail) : super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        sc.InterfaceC0245sc interfaceC0245sc;
        if (pFF.sc(this.zY, webResourceRequest.getUrl().toString()) && (interfaceC0245sc = this.pFF) != null) {
            interfaceC0245sc.sc();
        }
        return this.f26542sc.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return this.f26542sc.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        sc.InterfaceC0245sc interfaceC0245sc = this.pFF;
        if (interfaceC0245sc != null) {
            interfaceC0245sc.sc();
        }
        return this.f26542sc.shouldOverrideUrlLoading(webView, str);
    }
}

package com.mbridge.msdk.mbsignalcommon.commonwebview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WebViewClient> f45727a = new CopyOnWriteArrayList<>();

    public final void a(WebViewClient webViewClient) {
        this.f45727a.add(webViewClient);
    }

    public final void b(WebViewClient webViewClient) {
        this.f45727a.remove(webViewClient);
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().doUpdateVisitedHistory(webView, str, z11);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onFormResubmission(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onLoadResource(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    it.next().onPageCommitVisible(webView, str);
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onPageStarted(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        try {
            Iterator<WebViewClient> it = this.f45727a.iterator();
            while (it.hasNext()) {
                it.next().onReceivedClientCertRequest(webView, clientCertRequest);
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedError(webView, i11, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    it.next().onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    it.next().onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedLoginRequest(webView, str, str2, str3);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        boolean zOnRenderProcessGone = false;
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    zOnRenderProcessGone = it.next().onRenderProcessGone(webView, renderProcessGoneDetail);
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
        return zOnRenderProcessGone;
    }

    @Override // android.webkit.WebViewClient
    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    it.next().onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f11, float f12) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onScaleChanged(webView, f11, f12);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onTooManyRedirects(webView, message, message2);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        while (it.hasNext()) {
            it.next().onUnhandledKeyEvent(webView, keyEvent);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        WebResourceResponse webResourceResponseShouldInterceptRequest = null;
        try {
            Iterator<WebViewClient> it = this.f45727a.iterator();
            while (it.hasNext()) {
                webResourceResponseShouldInterceptRequest = it.next().shouldInterceptRequest(webView, webResourceRequest);
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
        return webResourceResponseShouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        WebResourceResponse webResourceResponseShouldInterceptRequest = null;
        while (it.hasNext()) {
            webResourceResponseShouldInterceptRequest = it.next().shouldInterceptRequest(webView, str);
        }
        return webResourceResponseShouldInterceptRequest;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        boolean zShouldOverrideKeyEvent = false;
        while (it.hasNext()) {
            zShouldOverrideKeyEvent = it.next().shouldOverrideKeyEvent(webView, keyEvent);
        }
        return zShouldOverrideKeyEvent;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean z11 = false;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                Iterator<WebViewClient> it = this.f45727a.iterator();
                while (it.hasNext()) {
                    boolean zShouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, webResourceRequest);
                    if (zShouldOverrideUrlLoading) {
                        z11 = zShouldOverrideUrlLoading;
                    }
                }
            }
        } catch (Exception e11) {
            ad.b("CommonWebViewClient", e11.getMessage());
        }
        return z11;
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Iterator<WebViewClient> it = this.f45727a.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            boolean zShouldOverrideUrlLoading = it.next().shouldOverrideUrlLoading(webView, str);
            if (zShouldOverrideUrlLoading) {
                z11 = zShouldOverrideUrlLoading;
            }
        }
        return z11;
    }
}

package com.applovin.impl.adview;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f17582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebViewRenderProcessClient f17583b = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends WebViewRenderProcessClient {
        public a() {
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        }

        @Override // android.webkit.WebViewRenderProcessClient
        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            if (webView instanceof b) {
                com.applovin.impl.sdk.ad.b currentAd = ((b) webView).getCurrentAd();
                d.this.f17582a.J();
                if (com.applovin.impl.sdk.n.a()) {
                    d.this.f17582a.J().b("AdWebViewRenderProcessClient", "WebView render process unresponsive for ad: " + currentAd);
                }
            }
        }
    }

    public d(com.applovin.impl.sdk.j jVar) {
        this.f17582a = jVar;
    }

    public WebViewRenderProcessClient a() {
        return this.f17583b;
    }
}

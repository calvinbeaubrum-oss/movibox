package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class rr extends pi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f22187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f22188b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(Uri uri, com.applovin.impl.adview.l lVar);

        void a(com.applovin.impl.adview.l lVar);

        void a(com.applovin.impl.adview.l lVar, Bundle bundle);

        void b(Uri uri, com.applovin.impl.adview.l lVar);

        void b(com.applovin.impl.adview.l lVar);

        void c(com.applovin.impl.adview.l lVar);

        void d(com.applovin.impl.adview.l lVar);
    }

    public rr(com.applovin.impl.sdk.j jVar) {
        this.f22187a = jVar.J();
    }

    private void a(WebView webView, String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f22187a.d("WebViewButtonClient", "Processing click on ad URL \"" + str + "\"");
        }
        if (str == null || !(webView instanceof com.applovin.impl.adview.l)) {
            return;
        }
        com.applovin.impl.adview.l lVar = (com.applovin.impl.adview.l) webView;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        String host = uri.getHost();
        String path = uri.getPath();
        a aVar = (a) this.f22188b.get();
        if ("applovin".equalsIgnoreCase(scheme) && "com.applovin.sdk".equalsIgnoreCase(host) && aVar != null) {
            if ("/track_click".equals(path)) {
                aVar.b(lVar);
                return;
            }
            if ("/close_ad".equals(path)) {
                aVar.a(lVar);
                return;
            }
            if ("/skip_ad".equals(path)) {
                aVar.d(lVar);
                return;
            }
            if ("/direct_download".equals(path)) {
                aVar.a(lVar, tp.a(uri));
                return;
            }
            if ("/load_url".equals(path)) {
                aVar.a(uri, lVar);
                return;
            }
            if ("/template_error".equals(path)) {
                aVar.b(uri, lVar);
                return;
            }
            if ("/fully_watched".equals(path)) {
                aVar.c(lVar);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f22187a.k("WebViewButtonClient", "Unknown URL: " + str);
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f22187a.k("WebViewButtonClient", "Path: " + path);
            }
        }
    }

    public void a(WeakReference weakReference) {
        this.f22188b = weakReference;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a(webView, str);
        return true;
    }
}

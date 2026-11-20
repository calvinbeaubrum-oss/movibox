package com.applovin.impl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr extends pi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f21981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f21982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WebView f21983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f21984d = Collections.synchronizedSet(new HashSet());

    public qr(com.applovin.impl.sdk.j jVar) {
        this.f21981a = jVar;
        this.f21982b = jVar.J();
    }

    private WebView a(String str) {
        yp.b();
        WebView webViewB = yp.b(com.applovin.impl.sdk.j.l(), "web tracker");
        if (webViewB == null) {
            return null;
        }
        webViewB.getSettings().setJavaScriptEnabled(true);
        webViewB.setWebViewClient(this);
        webViewB.loadData("<html><head><link rel=\"icon\" href=\"data:,\">" + str + "</head><body></body></html>", "text/html", "UTF-8");
        return webViewB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f21983c.destroy();
        this.f21983c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final WebView webView) {
        if (webView == null || !this.f21984d.remove(webView)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.k20
            @Override // java.lang.Runnable
            public final void run() {
                webView.destroy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.applovin.impl.sdk.network.e eVar, AppLovinPostbackListener appLovinPostbackListener) {
        String strAppendQueryParameters = StringUtils.appendQueryParameters(eVar.f(), eVar.i(), ((Boolean) this.f21981a.a(sj.f23064t3)).booleanValue());
        if (this.f21983c == null) {
            WebView webViewA = a("<script>window.al_firePostback = function(url) {\n    setTimeout(function() {\n        var img = new Image();\n        img.src = url;\n    }, 100);\n}\n</script>");
            this.f21983c = webViewA;
            if (webViewA == null) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f21982b.b("WebTrackerManager", "Failed to fire postback since web view could not be created");
                }
                appLovinPostbackListener.onPostbackFailure(strAppendQueryParameters, -1);
                return;
            }
        }
        tr.a(this.f21983c, "al_firePostback('" + strAppendQueryParameters + "')");
        appLovinPostbackListener.onPostbackSuccess(strAppendQueryParameters);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        final WebView webViewA = a(str);
        if (webViewA != null) {
            this.f21984d.add(webViewA);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.l20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20324a.b(webViewA);
                }
            }, ((Integer) this.f21981a.a(sj.Z2)).intValue());
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f21982b.b("WebTrackerManager", "Failed to fire tracker since web view could not be created");
        }
    }

    public void a(final com.applovin.impl.sdk.network.e eVar, final AppLovinPostbackListener appLovinPostbackListener) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.j20
            @Override // java.lang.Runnable
            public final void run() {
                this.f19830a.b(eVar, appLovinPostbackListener);
            }
        });
    }

    public void b(final String str) {
        if (!AppLovinSdkUtils.isValidString(str)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f21982b.b("WebTrackerManager", "Failed to fire tracker due to empty script string");
            }
        } else if (str.startsWith("<script")) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.h20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19334a.c(str);
                }
            });
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f21982b.b("WebTrackerManager", "Failed to fire tracker due to improperly formatted script tag");
        }
    }

    @Override // com.applovin.impl.pi, android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (webView == this.f21983c) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.i20
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19614a.a();
                }
            });
        } else {
            b(webView);
        }
        return super.onRenderProcessGone(webView, renderProcessGoneDetail);
    }
}

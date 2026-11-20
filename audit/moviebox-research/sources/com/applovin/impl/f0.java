package com.applovin.impl;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.hisavana.common.tracking.TrackingKey;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f18831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f18832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.adview.a f18833c;

    public f0(com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        this.f18831a = jVar;
        this.f18832b = jVar.J();
        this.f18833c = aVar;
    }

    private void a(ConsoleMessage consoleMessage) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.al_onPoststitialShow_evaluation_error"), null);
        com.applovin.impl.sdk.ad.b bVarI = this.f18833c.i();
        if (bVarI != null) {
            String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber();
            Map mapA = ma.a(bVarI);
            mapA.put("source", "AdWebView:onPoststitialShowEvaluationError");
            mapA.put("top_main_method", str);
            mapA.put(TrackingKey.ERROR_MESSAGE, consoleMessage.message());
            this.f18831a.E().a(la.R, mapA);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i11, String str2) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f18832b.k("AdWebView", "console.log[" + i11 + "] :" + str);
        }
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = consoleMessage.messageLevel() + ": " + consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message();
        if (com.applovin.impl.sdk.n.a()) {
            this.f18832b.a("AdWebView", str);
        }
        if (consoleMessage.messageLevel() != ConsoleMessage.MessageLevel.ERROR) {
            return true;
        }
        if (!consoleMessage.message().contains("al_onPoststitialShow") && !consoleMessage.message().contains("al_showPostitial")) {
            return true;
        }
        a(consoleMessage);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f18832b.k("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f18832b.k("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!com.applovin.impl.sdk.n.a()) {
            return true;
        }
        this.f18832b.k("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i11) {
        com.applovin.impl.adview.a aVar;
        if (i11 != 100 || (aVar = this.f18833c) == null) {
            return;
        }
        aVar.c(webView);
    }
}

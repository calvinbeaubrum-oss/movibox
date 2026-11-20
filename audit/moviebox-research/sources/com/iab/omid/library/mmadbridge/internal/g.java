package com.iab.omid.library.mmadbridge.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static g f42367a = new g();

    /* JADX INFO: compiled from: source.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebView f42368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f42369b;

        public a(g gVar, WebView webView, String str) {
            this.f42368a = webView;
            this.f42369b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f42368a.loadUrl(this.f42369b);
        }
    }

    public static final g a() {
        return f42367a;
    }

    public void b(WebView webView) {
        h(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f11) {
        h(webView, "setDeviceVolume", Float.valueOf(f11));
    }

    public void d(WebView webView, String str) {
        h(webView, "setNativeViewHierarchy", str);
    }

    public void e(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        p(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    public void f(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            h(webView, "publishMediaEvent", str, jSONObject);
        } else {
            h(webView, "publishMediaEvent", str);
        }
    }

    public void g(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        h(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public void h(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            nn.d.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb2.append(str);
        sb2.append("(");
        k(sb2, objArr);
        sb2.append(")}");
        i(webView, sb2);
    }

    public void i(WebView webView, StringBuilder sb2) {
        String string = sb2.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(string);
        } else {
            handler.post(new a(this, webView, string));
        }
    }

    public void j(WebView webView, JSONObject jSONObject) {
        h(webView, "init", jSONObject);
    }

    public void k(StringBuilder sb2, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                sb2.append('\"');
            } else {
                if (obj instanceof String) {
                    String string = obj.toString();
                    if (string.startsWith("{")) {
                        sb2.append(string);
                    } else {
                        sb2.append('\"');
                        sb2.append(string);
                    }
                } else {
                    sb2.append(obj);
                }
                sb2.append(",");
            }
            sb2.append('\"');
            sb2.append(",");
        }
        sb2.setLength(sb2.length() - 1);
    }

    public void l(WebView webView) {
        h(webView, "publishImpressionEvent", new Object[0]);
    }

    public void m(WebView webView, String str) {
        h(webView, "setState", str);
    }

    public void n(WebView webView, @NonNull JSONObject jSONObject) {
        h(webView, "publishLoadedEvent", jSONObject);
    }

    public void o(WebView webView, @NonNull JSONObject jSONObject) {
        h(webView, "setLastActivity", jSONObject);
    }

    public boolean p(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }
}

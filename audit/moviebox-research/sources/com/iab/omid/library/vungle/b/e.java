package com.iab.omid.library.vungle.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f42435a = new e();

    public static final e a() {
        return f42435a;
    }

    public void b(WebView webView) {
        f(webView, "finishSession", new Object[0]);
    }

    public void c(WebView webView, float f11) {
        f(webView, "setDeviceVolume", Float.valueOf(f11));
    }

    public void d(WebView webView, String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return;
        }
        j(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};this.omidVerificationProperties.injectionId = '%INJECTION_ID%';var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
    }

    public void e(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        f(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public void f(WebView webView, String str, Object... objArr) {
        if (webView == null) {
            un.c.a("The WebView is null for " + str);
            return;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
        sb2.append(str);
        sb2.append("(");
        i(sb2, objArr);
        sb2.append(")}");
        g(webView, sb2);
    }

    public void g(final WebView webView, StringBuilder sb2) {
        final String string = sb2.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(string);
        } else {
            handler.post(new Runnable() { // from class: com.iab.omid.library.vungle.b.e.1
                @Override // java.lang.Runnable
                public void run() {
                    webView.loadUrl(string);
                }
            });
        }
    }

    public void h(WebView webView, JSONObject jSONObject) {
        f(webView, "init", jSONObject);
    }

    public void i(StringBuilder sb2, Object[] objArr) {
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

    public boolean j(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    public void k(WebView webView, String str) {
        f(webView, "setNativeViewHierarchy", str);
    }

    public void l(WebView webView, String str) {
        f(webView, "setState", str);
    }
}

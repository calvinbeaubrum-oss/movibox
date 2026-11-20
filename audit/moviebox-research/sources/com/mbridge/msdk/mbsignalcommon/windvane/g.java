package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g f45796a = new g();

    private g() {
    }

    public static g a() {
        return f45796a;
    }

    public final void a(WebView webView) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_version", "1.0.0");
            f45796a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f45672j, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception unused) {
            f45796a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f45672j, "");
        } catch (Throwable unused2) {
            f45796a.a(webView, com.mbridge.msdk.mbsignalcommon.base.e.f45672j, "");
        }
    }

    public final void a(WebView webView, String str, String str2) {
        String str3 = TextUtils.isEmpty(str2) ? String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, j.c(str2));
        if (webView != null) {
            if ((webView instanceof WindVaneWebView) && ((WindVaneWebView) webView).isDestoryed()) {
                return;
            }
            try {
                webView.loadUrl(str3);
            } catch (Exception e11) {
                e11.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            String str2 = TextUtils.isEmpty(str) ? String.format("javascript:window.WindVane.onSuccess(%s,'');", aVar.f45779g) : String.format("javascript:window.WindVane.onSuccess(%s,'%s');", aVar.f45779g, j.c(str));
            WindVaneWebView windVaneWebView = aVar.f45774b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f45774b.loadUrl(str2);
            } catch (Exception e11) {
                e11.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void a(Object obj, String str, String str2) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            String str3 = TextUtils.isEmpty(str2) ? String.format("javascript:window.WindVane.fireEvent('%s', '');", str) : String.format("javascript:window.WindVane.fireEvent('%s','%s');", str, j.c(str2));
            WindVaneWebView windVaneWebView = aVar.f45774b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f45774b.loadUrl(str3);
            } catch (Exception e11) {
                e11.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void b(Object obj, String str) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(str)) {
                String.format("javascript:window.WindVane.onFailure(%s,'');", aVar.f45779g);
            } else {
                str = j.c(str);
            }
            String str2 = String.format("javascript:window.WindVane.onFailure(%s,'%s');", aVar.f45779g, str);
            WindVaneWebView windVaneWebView = aVar.f45774b;
            if (windVaneWebView == null || windVaneWebView.isDestoryed()) {
                return;
            }
            try {
                aVar.f45774b.loadUrl(str2);
            } catch (Exception e11) {
                e11.printStackTrace();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }
}

package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0501a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f45738a = new a();
    }

    public static a a() {
        return C0501a.f45738a;
    }

    private void c(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final void a(WebView webView) {
        c(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public final void a(WebView webView, double d11) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d11)));
    }

    public final void a(WebView webView, float f11, float f12) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f11), Float.valueOf(f12)));
    }

    public final void a(WebView webView, float f11, float f12, float f13, float f14) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13), Float.valueOf(f14)));
    }

    public final void a(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }

    public final void a(WebView webView, String str, String str2) {
        c(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public final void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        c(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject.toString()));
    }

    public final void b(WebView webView, float f11, float f12) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f11), Float.valueOf(f12)));
    }

    public final void b(WebView webView, float f11, float f12, float f13, float f14) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f11), Float.valueOf(f12), Float.valueOf(f13), Float.valueOf(f14)));
    }

    public final void b(WebView webView, String str) {
        c(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    public final void c(WebView webView, float f11, float f12) {
        c(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f11), Float.valueOf(f12)));
    }
}

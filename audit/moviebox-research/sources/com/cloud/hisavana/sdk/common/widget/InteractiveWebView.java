package com.cloud.hisavana.sdk.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class InteractiveWebView extends WebView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f29528b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f29529a;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        @JavascriptInterface
        public void handleClick() {
            z.a().d("InteractiveWebView", "handleClick");
            if (InteractiveWebView.f29528b != null) {
                InteractiveWebView.f29528b.b();
            }
        }

        @JavascriptInterface
        public void interactiveEvent(String str) {
            z.a().d("InteractiveWebView", "interactiveEvent");
            if (InteractiveWebView.f29528b != null) {
                InteractiveWebView.f29528b.a(str);
            }
        }

        @JavascriptInterface
        public void timeoutShutdown() {
            z.a().d("InteractiveWebView", "timeoutShutdown");
            if (InteractiveWebView.f29528b != null) {
                InteractiveWebView.f29528b.c();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(String str);

        void b();

        void c();
    }

    public InteractiveWebView(@NonNull Context context) {
        super(context);
        b();
    }

    public InteractiveWebView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public InteractiveWebView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b();
    }

    public final void b() {
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportZoom(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDisplayZoomControls(true);
        settings.setCacheMode(-1);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        setWebViewClient(new x9.b());
        setWebChromeClient(new WebChromeClient());
        a aVar = new a();
        this.f29529a = aVar;
        addJavascriptInterface(aVar, "InteractiveWebView");
    }

    @Override // android.webkit.WebView
    public void destroy() {
        try {
            getSettings().setJavaScriptEnabled(false);
            setWebChromeClient(null);
            clearHistory();
            clearCache(true);
            loadUrl("about:blank");
            freeMemory();
            super.destroy();
        } catch (Exception e11) {
            z.a().e("InteractiveWebView", "destroy " + Log.getStackTraceString(e11));
        }
    }

    public void setmListener(b bVar) {
        f29528b = bVar;
    }
}

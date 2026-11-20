package com.polygamma.ogm;

import android.webkit.WebView;
import com.google.common.util.concurrent.v;
import io.d0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f48891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebView f48892b;

    public z(v vVar, WebView webView) {
        this.f48891a = vVar;
        this.f48892b = webView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!d0.c()) {
            this.f48891a.execute(this);
            return;
        }
        WebView webView = this.f48892b;
        this.f48892b = null;
        if (webView != null) {
            try {
                webView.removeAllViews();
                webView.clearHistory();
                webView.loadUrl("about:blank");
                webView.onPause();
                webView.removeAllViews();
                webView.destroyDrawingCache();
            } finally {
                webView.destroy();
            }
        }
    }
}

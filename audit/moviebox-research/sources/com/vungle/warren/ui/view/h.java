package com.vungle.warren.ui.view;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface h {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean f(String str, JsonObject jsonObject);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void g(String str, boolean z11);

        boolean i(WebView webView, boolean z11);

        void t(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess);
    }

    void a(boolean z11);

    void b(b bVar);

    void c(boolean z11);

    void d(a aVar);

    void e(com.vungle.warren.omsdk.b bVar);

    void f(boolean z11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);
}

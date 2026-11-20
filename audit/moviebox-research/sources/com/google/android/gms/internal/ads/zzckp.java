package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@TargetApi(21)
public final class zzckp extends zzcko {
    public zzckp(zzcjk zzcjkVar, zzbbp zzbbpVar, boolean z11, @Nullable zzehs zzehsVar) {
        super(zzcjkVar, zzbbpVar, z11, zzehsVar);
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzO(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}

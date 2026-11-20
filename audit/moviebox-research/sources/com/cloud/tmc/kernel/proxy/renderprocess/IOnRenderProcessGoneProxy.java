package com.cloud.tmc.kernel.proxy.renderprocess;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.integration.defaultImpl.OnRenderProcessGoneManager")
public interface IOnRenderProcessGoneProxy {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);
    }

    void received(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail);

    void register(a aVar);

    void unRegister(a aVar);
}

package com.cloud.tmc.kernel.proxy.render;

import android.content.Context;
import zb.c;
import zc.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.defaultimpl.WebViewImp")
public interface IWebViewFactory {
    void clear();

    k createWebView(Context context);

    k createWebView(Context context, int i11);
}

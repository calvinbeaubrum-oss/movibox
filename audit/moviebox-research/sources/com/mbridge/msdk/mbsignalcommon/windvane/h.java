package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f45797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Object f45798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected WindVaneWebView f45799d;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.f45797b = context;
        this.f45799d = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.f45798c = obj;
        this.f45799d = windVaneWebView;
    }
}

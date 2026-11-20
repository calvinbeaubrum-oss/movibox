package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface InterceptorCallback {
    void onContinue(Postcard postcard);

    void onInterrupt(Throwable th2);
}

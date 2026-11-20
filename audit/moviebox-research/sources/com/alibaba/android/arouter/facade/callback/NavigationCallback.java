package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface NavigationCallback {
    void onArrival(Postcard postcard);

    void onFound(Postcard postcard);

    void onInterrupt(Postcard postcard);

    void onLost(Postcard postcard);
}

package com.applovin.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class vl implements l3 {
    @Override // com.applovin.impl.l3
    public long a() {
        return SystemClock.uptimeMillis();
    }

    @Override // com.applovin.impl.l3
    public ja a(Looper looper, Handler.Callback callback) {
        return new wl(new Handler(looper, callback));
    }

    @Override // com.applovin.impl.l3
    public void b() {
    }

    @Override // com.applovin.impl.l3
    public long c() {
        return SystemClock.elapsedRealtime();
    }
}

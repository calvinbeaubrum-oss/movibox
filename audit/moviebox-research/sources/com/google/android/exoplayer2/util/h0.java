package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class h0 implements e {
    @Override // com.google.android.exoplayer2.util.e
    public void a() {
    }

    @Override // com.google.android.exoplayer2.util.e
    public o createHandler(Looper looper, @Nullable Handler.Callback callback) {
        return new i0(new Handler(looper, callback));
    }

    @Override // com.google.android.exoplayer2.util.e
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.exoplayer2.util.e
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }
}

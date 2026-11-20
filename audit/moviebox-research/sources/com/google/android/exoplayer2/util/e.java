package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f35556a = new h0();

    void a();

    o createHandler(Looper looper, @Nullable Handler.Callback callback);

    long elapsedRealtime();

    long uptimeMillis();
}

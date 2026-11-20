package com.polygamma.ogm;

import android.os.SystemClock;
import p007do.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class i extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f48875e;

    public i(x xVar, Runnable runnable, long j11, long j12) {
        super(xVar, runnable, j11);
        com.google.common.base.m.d(j12 >= 0);
        this.f48875e = j12;
    }

    @Override // com.polygamma.ogm.l
    public final long a() {
        return SystemClock.uptimeMillis() + this.f48875e;
    }
}

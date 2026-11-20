package com.apm.insight.j;

import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f16842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f16843b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f16844c;

    public a(Handler handler, long j11) {
        this.f16842a = handler;
        this.f16844c = j11;
    }

    public final void a() {
        this.f16842a.post(this);
    }

    public final void a(long j11) {
        if (j11 > 0) {
            this.f16842a.postDelayed(this, j11);
        } else {
            this.f16842a.post(this);
        }
    }

    public final long b() {
        return this.f16844c;
    }
}

package com.vungle.warren.utility;

import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class o extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f62609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f62610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f62611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f62612d;

    public o(@NonNull Runnable runnable, long j11) {
        this.f62611c = j11;
        this.f62612d = runnable;
    }

    public synchronized void a() {
        removeMessages(0);
        removeCallbacks(this.f62612d);
        this.f62610b = 0L;
        this.f62609a = 0L;
    }

    public synchronized void b() {
        if (hasMessages(0)) {
            this.f62610b += System.currentTimeMillis() - this.f62609a;
            removeMessages(0);
            removeCallbacks(this.f62612d);
        }
    }

    public synchronized void c() {
        if (this.f62611c <= 0) {
            return;
        }
        if (!hasMessages(0)) {
            long j11 = this.f62611c - this.f62610b;
            this.f62609a = System.currentTimeMillis();
            postDelayed(this.f62612d, j11);
        }
    }
}

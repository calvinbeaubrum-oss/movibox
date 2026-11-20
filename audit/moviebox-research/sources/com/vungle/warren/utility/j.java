package com.vungle.warren.utility;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class j implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f62601a = new Handler(Looper.getMainLooper());

    @Override // com.vungle.warren.utility.r
    public void a(@NonNull Runnable runnable, long j11) {
        this.f62601a.postAtTime(runnable, c(j11));
    }

    @Override // com.vungle.warren.utility.r
    public void b() {
        this.f62601a.removeCallbacksAndMessages(null);
    }

    public final long c(long j11) {
        return SystemClock.uptimeMillis() + j11;
    }
}

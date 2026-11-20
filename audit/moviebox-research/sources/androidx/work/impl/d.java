package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements androidx.work.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f13417a = androidx.core.os.g.a(Looper.getMainLooper());

    @Override // androidx.work.o
    public void a(@NonNull Runnable runnable) {
        this.f13417a.removeCallbacks(runnable);
    }

    @Override // androidx.work.o
    public void b(long j11, @NonNull Runnable runnable) {
        this.f13417a.postDelayed(runnable, j11);
    }
}

package com.vungle.warren.utility;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f62606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadFactory f62607b = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AtomicInteger f62608c = new AtomicInteger(0);

    public n(String str) {
        this.f62606a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(@NonNull Runnable runnable) {
        Thread threadNewThread = this.f62607b.newThread(runnable);
        threadNewThread.setName(this.f62606a + "-th-" + this.f62608c.incrementAndGet());
        return threadNewThread;
    }
}

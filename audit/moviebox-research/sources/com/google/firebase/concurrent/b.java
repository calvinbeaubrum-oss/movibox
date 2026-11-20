package com.google.firebase.concurrent;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f38978f = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f38979a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StrictMode.ThreadPolicy f38982d;

    public b(String str, int i11, StrictMode.ThreadPolicy threadPolicy) {
        this.f38980b = str;
        this.f38981c = i11;
        this.f38982d = threadPolicy;
    }

    public final /* synthetic */ void b(Runnable runnable) {
        Process.setThreadPriority(this.f38981c);
        StrictMode.ThreadPolicy threadPolicy = this.f38982d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f38978f.newThread(new Runnable() { // from class: com.google.firebase.concurrent.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f38976a.b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f38980b, Long.valueOf(this.f38979a.getAndIncrement())));
        return threadNewThread;
    }
}

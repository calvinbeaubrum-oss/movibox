package com.bytedance.sdk.component.Qj.zY;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We implements ThreadFactory {
    protected final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final ThreadGroup f26579sc;
    private final AtomicInteger zY = new AtomicInteger(1);

    public We(String str) {
        this.f26579sc = new ThreadGroup("pag_g_".concat(String.valueOf(str)));
        this.pFF = sc(str);
    }

    public static String sc(String str) {
        return "pag_".concat(String.valueOf(str));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadSc = sc(this.f26579sc, runnable, this.pFF + "_" + this.zY.getAndIncrement());
        if (threadSc.isDaemon()) {
            threadSc.setDaemon(false);
        }
        return threadSc;
    }

    public Thread sc(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }
}

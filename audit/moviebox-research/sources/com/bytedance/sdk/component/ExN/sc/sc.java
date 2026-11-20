package com.bytedance.sdk.component.ExN.sc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements ThreadFactory {
    private final AtomicInteger pFF = new AtomicInteger(1);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final ThreadGroup f26499sc;

    public sc(String str) {
        this.f26499sc = new ThreadGroup("tt_img_".concat(String.valueOf(str)));
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f26499sc, runnable, "tt_img_" + this.pFF.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}

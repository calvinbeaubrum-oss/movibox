package com.bytedance.sdk.component.Qj;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ol implements ThreadFactory {
    public static final String THREAD_GROUP_NAME_PRE = "csj_g_";
    public static final String THREAD_NAME_PRE = "csj_";
    private final AtomicInteger We;
    protected final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected final ThreadGroup f26554sc;
    protected int zY;

    public Ol(int i11, String str) {
        this.We = new AtomicInteger(1);
        this.zY = i11;
        this.f26554sc = new ThreadGroup(THREAD_GROUP_NAME_PRE.concat(String.valueOf(str)));
        this.pFF = THREAD_NAME_PRE.concat(String.valueOf(str));
    }

    public Ol(String str) {
        this(5, str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread threadSc = sc(this.f26554sc, runnable, this.pFF + this.We.getAndIncrement());
        if (threadSc.isDaemon()) {
            threadSc.setDaemon(false);
        }
        int i11 = this.zY;
        if (i11 > 10 || i11 <= 0) {
            this.zY = 5;
        }
        threadSc.setPriority(this.zY);
        return threadSc;
    }

    public Thread sc(ThreadGroup threadGroup, Runnable runnable, String str) {
        return new Thread(threadGroup, runnable, str);
    }
}

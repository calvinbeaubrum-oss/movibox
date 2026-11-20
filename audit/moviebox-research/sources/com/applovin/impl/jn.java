package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jn extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f19997h;

    public jn(com.applovin.impl.sdk.j jVar, String str, Runnable runnable) {
        this(jVar, false, str, runnable);
    }

    public jn(com.applovin.impl.sdk.j jVar, boolean z11, String str, Runnable runnable) {
        super("TaskRunnable:" + str, jVar, z11);
        this.f19997h = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f19997h.run();
    }
}

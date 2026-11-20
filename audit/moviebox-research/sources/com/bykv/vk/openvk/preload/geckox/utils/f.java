package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f25869a;

    public static f a() {
        if (f25869a == null) {
            synchronized (f.class) {
                try {
                    if (f25869a == null) {
                        f25869a = new f();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f25869a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.p().execute(runnable);
    }
}

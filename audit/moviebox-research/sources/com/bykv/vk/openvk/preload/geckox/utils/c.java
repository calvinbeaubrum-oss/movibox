package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f25867a;

    public static c a() {
        if (f25867a == null) {
            synchronized (c.class) {
                try {
                    if (f25867a == null) {
                        f25867a = new c();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f25867a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.p().execute(runnable);
    }
}

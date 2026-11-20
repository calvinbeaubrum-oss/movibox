package com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class z {
    public static boolean a(Throwable th2, Class<? extends Throwable> cls) {
        return cls.isInstance(th2);
    }

    public static void b(Throwable th2) {
        com.google.common.base.m.p(th2);
        if (th2 instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }
}

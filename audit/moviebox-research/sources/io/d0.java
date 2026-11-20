package io;

import android.os.Build;
import android.os.Looper;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d0 {
    public static void a() {
        com.google.common.base.m.w(c(), "executing thread is not main thread");
    }

    public static void b() {
        com.google.common.base.m.w(!c(), "executing thread is main thread");
    }

    public static boolean c() {
        return Thread.currentThread().equals(Looper.getMainLooper().getThread());
    }

    public static ReadWriteLock d() {
        return Build.VERSION.SDK_INT >= 24 ? c0.a().asReadWriteLock() : new ReentrantReadWriteLock();
    }
}

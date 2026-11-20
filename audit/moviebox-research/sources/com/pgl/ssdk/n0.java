package com.pgl.ssdk;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class n0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile n0 f48812a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f48814c = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f48813b = Thread.getDefaultUncaughtExceptionHandler();

    private n0() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static n0 b() {
        if (f48812a == null) {
            synchronized (n0.class) {
                try {
                    if (f48812a == null) {
                        f48812a = new n0();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48812a;
    }

    public boolean a() {
        return this.f48814c;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        this.f48814c = true;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f48813b;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }
}

package com.mbridge.msdk.foundation.same.report;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f44862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f44863b = false;

    private j() {
    }

    public static synchronized j a() {
        try {
            if (f44862a == null) {
                f44862a = new j();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44862a;
    }

    public final synchronized void a(String str) {
    }

    public final synchronized boolean b() {
        return false;
    }
}

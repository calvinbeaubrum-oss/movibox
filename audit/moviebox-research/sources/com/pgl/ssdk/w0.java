package com.pgl.ssdk;

import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z0<x0> f48856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a1 f48857b;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final w0 f48858a = new w0();
    }

    private w0() {
        this.f48856a = z0.a(2);
    }

    public static w0 a() {
        return b.f48858a;
    }

    private x0 a(a1.a aVar, String str) {
        if (n0.b().a()) {
            return null;
        }
        try {
            HandlerThread handlerThread = new HandlerThread(str);
            handlerThread.start();
            return new x0(handlerThread, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public a1 a(String str) {
        return b(null, str);
    }

    public a1 b() {
        if (this.f48857b == null) {
            synchronized (w0.class) {
                try {
                    if (this.f48857b == null) {
                        this.f48857b = a("ssdk_net_handler");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f48857b;
    }

    public a1 b(a1.a aVar, String str) {
        x0 x0Var = (x0) this.f48856a.a();
        if (x0Var == null) {
            return a(aVar, str);
        }
        x0Var.a(aVar);
        x0Var.a(str);
        return x0Var;
    }

    public a1 c() {
        if (this.f48857b == null) {
            synchronized (w0.class) {
                try {
                    if (this.f48857b == null) {
                        this.f48857b = a("ssdk_handler");
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f48857b;
    }
}

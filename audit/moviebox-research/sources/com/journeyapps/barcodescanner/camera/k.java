package com.journeyapps.barcodescanner.camera;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static k f42620e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f42621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HandlerThread f42622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f42623c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f42624d = new Object();

    public static k d() {
        if (f42620e == null) {
            f42620e = new k();
        }
        return f42620e;
    }

    public final void a() {
        synchronized (this.f42624d) {
            try {
                if (this.f42621a == null) {
                    if (this.f42623c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f42622b = handlerThread;
                    handlerThread.start();
                    this.f42621a = new Handler(this.f42622b.getLooper());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void b() {
        synchronized (this.f42624d) {
            try {
                int i11 = this.f42623c - 1;
                this.f42623c = i11;
                if (i11 == 0) {
                    f();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(Runnable runnable) {
        synchronized (this.f42624d) {
            a();
            this.f42621a.post(runnable);
        }
    }

    public void e(Runnable runnable) {
        synchronized (this.f42624d) {
            this.f42623c++;
            c(runnable);
        }
    }

    public final void f() {
        synchronized (this.f42624d) {
            this.f42622b.quit();
            this.f42622b = null;
            this.f42621a = null;
        }
    }
}

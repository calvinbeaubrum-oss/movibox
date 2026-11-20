package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f30312a;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final t f30313a = new t();
    }

    public t() {
        HandlerThread handlerThread = new HandlerThread("h_work_thread");
        handlerThread.start();
        this.f30312a = new Handler(handlerThread.getLooper());
    }

    public static t a() {
        return b.f30313a;
    }

    public void b(Runnable runnable) {
        try {
            Handler handler = this.f30312a;
            if (handler == null || runnable == null) {
                return;
            }
            if (handler.getLooper().equals(Looper.myLooper())) {
                runnable.run();
            } else {
                this.f30312a.post(runnable);
            }
        } catch (Exception unused) {
        }
    }

    public void c(Runnable runnable, long j11) {
        Handler handler = this.f30312a;
        if (handler == null || runnable == null) {
            return;
        }
        handler.postDelayed(runnable, j11);
    }
}

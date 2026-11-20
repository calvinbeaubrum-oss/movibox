package com.cloud.sdk.commonutil.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f30276a;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f30277a = new d();
    }

    public d() {
        HandlerThread handlerThread = new HandlerThread("h_db_thread");
        handlerThread.start();
        this.f30276a = new Handler(handlerThread.getLooper());
    }

    public static d a() {
        return b.f30277a;
    }

    public void b(Runnable runnable) {
        try {
            Handler handler = this.f30276a;
            if (handler == null || runnable == null) {
                return;
            }
            if (handler.getLooper().equals(Looper.myLooper())) {
                runnable.run();
            } else {
                this.f30276a.post(runnable);
            }
        } catch (Exception unused) {
        }
    }
}

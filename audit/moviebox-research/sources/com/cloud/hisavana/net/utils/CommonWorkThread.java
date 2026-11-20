package com.cloud.hisavana.net.utils;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class CommonWorkThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f29031a;

    /* JADX INFO: compiled from: source.java */
    public static class WorkThreadHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final CommonWorkThread f29032a = new CommonWorkThread();

        private WorkThreadHolder() {
        }
    }

    private CommonWorkThread() {
        HandlerThread handlerThread = new HandlerThread("common_work_thread");
        handlerThread.start();
        this.f29031a = new Handler(handlerThread.getLooper());
    }

    public static CommonWorkThread a() {
        return WorkThreadHolder.f29032a;
    }

    public void b(Runnable runnable) {
        Handler handler = this.f29031a;
        if (handler != null) {
            handler.post(runnable);
        }
    }
}

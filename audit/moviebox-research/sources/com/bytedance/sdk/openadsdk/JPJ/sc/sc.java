package com.bytedance.sdk.openadsdk.JPJ.sc;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static HandlerThread pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static Handler f27101sc;

    public static Handler sc() {
        try {
            HandlerThread handlerThread = pFF;
            if (handlerThread == null || !handlerThread.isAlive()) {
                synchronized (sc.class) {
                    try {
                        HandlerThread handlerThread2 = pFF;
                        if (handlerThread2 == null || !handlerThread2.isAlive()) {
                            HandlerThread handlerThread3 = new HandlerThread("csj_ev");
                            pFF = handlerThread3;
                            handlerThread3.start();
                            f27101sc = new Handler(pFF.getLooper());
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } else if (f27101sc == null) {
                synchronized (sc.class) {
                    try {
                        if (f27101sc == null) {
                            f27101sc = new Handler(pFF.getLooper());
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return f27101sc;
    }
}

package com.bytedance.sdk.component.TRI.sc.qr;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private static volatile Handler pFF = null;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile HandlerThread f26627sc = null;
    private static int zY = 3000;

    static {
        HandlerThread handlerThread = new HandlerThread("csj_ad_log", 10);
        f26627sc = handlerThread;
        handlerThread.start();
    }

    public static int pFF() {
        if (zY <= 0) {
            zY = AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS;
        }
        return zY;
    }

    public static Handler sc() {
        if (f26627sc == null || !f26627sc.isAlive()) {
            synchronized (sc.class) {
                try {
                    if (f26627sc == null || !f26627sc.isAlive()) {
                        HandlerThread handlerThread = new HandlerThread("csj_init_handle", -1);
                        f26627sc = handlerThread;
                        handlerThread.start();
                        pFF = new Handler(f26627sc.getLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } else if (pFF == null) {
            synchronized (sc.class) {
                try {
                    if (pFF == null) {
                        pFF = new Handler(f26627sc.getLooper());
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
        return pFF;
    }
}

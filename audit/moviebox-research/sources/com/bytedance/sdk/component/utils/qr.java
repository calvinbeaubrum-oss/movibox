package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static volatile Handler f27037sc;

    public static Handler pFF() {
        if (f27037sc == null) {
            synchronized (qr.class) {
                try {
                    if (f27037sc == null) {
                        f27037sc = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f27037sc;
    }

    public static Handler sc() {
        return com.bytedance.sdk.component.Qj.sc.sc.sc().pFF();
    }
}

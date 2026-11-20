package com.apm.insight.runtime;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile r f17102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Handler f17103b;

    public static r a() {
        if (f17102a == null) {
            b();
        }
        return f17102a;
    }

    private static HandlerThread b() {
        if (f17102a == null) {
            synchronized (n.class) {
                try {
                    if (f17102a == null) {
                        r rVar = new r("default_npth_thread");
                        f17102a = rVar;
                        rVar.b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f17102a.c();
    }
}

package com.mbridge.msdk.foundation.same.c;

import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AtomicBoolean f44492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f44493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f44494c;

    public static ThreadPoolExecutor a() {
        if (f44494c == null) {
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f44494c = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.c.g.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-image-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        f44494c.allowCoreThreadTimeOut(true);
        return f44494c;
    }

    public static boolean b() {
        if (f44492a == null) {
            f44492a = new AtomicBoolean(af.a().a("u_i_l_l_n", true));
        }
        AtomicBoolean atomicBoolean = f44492a;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public static boolean c() {
        if (f44493b == null) {
            f44493b = new AtomicBoolean(af.a().a("u_i_l_l_b_d", false));
        }
        AtomicBoolean atomicBoolean = f44493b;
        return atomicBoolean != null && atomicBoolean.get();
    }
}

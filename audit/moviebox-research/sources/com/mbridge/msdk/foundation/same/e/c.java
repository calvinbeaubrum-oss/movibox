package com.mbridge.msdk.foundation.same.e;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f44511a;

    private static int a(int i11, String str) {
        try {
            int iA = af.a().a(str, i11);
            return iA <= 0 ? i11 : iA;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return i11;
            }
            ad.b("CommonTaskLoaderThreadPool", e11.getMessage());
            return i11;
        }
    }

    public static ThreadPoolExecutor a() {
        if (f44511a == null) {
            int iA = a(10, "c_t_l_t_p_c");
            int iA2 = a(50, "c_t_l_t_p_m");
            int iA3 = a(5, "c_t_l_t_p_t");
            int i11 = iA2 < iA ? iA : iA2;
            try {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor for core " + iA + " max " + i11 + " timeout " + iA3);
                }
                f44511a = new ThreadPoolExecutor(iA, i11, iA3, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.e.c.1
                    @Override // java.util.concurrent.ThreadFactory
                    public final Thread newThread(Runnable runnable) {
                        Thread thread = new Thread(runnable);
                        thread.setName("mb-task-loader-thread");
                        return thread;
                    }
                }, new ThreadPoolExecutor.DiscardPolicy());
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonTaskLoaderThreadPool", "create ThreadPoolExecutor failed ", e11);
                }
            }
        }
        if (f44511a == null) {
            int iAvailableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            f44511a = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.e.c.1
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setName("mb-task-loader-thread");
                    return thread;
                }
            }, new ThreadPoolExecutor.DiscardPolicy());
        }
        f44511a.allowCoreThreadTimeOut(true);
        return f44511a;
    }
}

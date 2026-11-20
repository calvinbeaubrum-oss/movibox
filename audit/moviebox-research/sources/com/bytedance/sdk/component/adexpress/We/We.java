package com.bytedance.sdk.component.adexpress.We;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    public static void pFF(com.bytedance.sdk.component.Qj.Qj qj2, int i11) {
        if (qj2 == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        ExecutorService executorServiceQl = zYVarZY != null ? zYVarZY.Ql() : null;
        if (executorServiceQl == null) {
            com.bytedance.sdk.component.Qj.TRI.sc(qj2);
        } else {
            qj2.setPriority(i11);
            executorServiceQl.execute(qj2);
        }
    }

    public static ScheduledFuture sc(Runnable runnable, long j11, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.Qj.TRI.TRI().schedule(runnable, j11, timeUnit);
    }

    public static void sc(com.bytedance.sdk.component.Qj.Qj qj2, int i11) {
        if (qj2 == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.sc.sc.zY zYVarZY = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().zY();
        ExecutorService executorServiceSR = zYVarZY != null ? zYVarZY.SR() : null;
        if (executorServiceSR == null) {
            com.bytedance.sdk.component.Qj.TRI.sc(qj2, i11);
        } else {
            qj2.setPriority(i11);
            executorServiceSR.execute(qj2);
        }
    }
}

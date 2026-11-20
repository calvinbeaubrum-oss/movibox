package io;

import androidx.annotation.Nullable;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class g {
    public static <V> void a(com.google.common.util.concurrent.s<V> sVar, c<V, ? super Throwable> cVar) {
        b(sVar, cVar, MoreExecutors.a());
    }

    public static <V> void b(com.google.common.util.concurrent.s<V> sVar, c<V, ? super Throwable> cVar, Executor executor) {
        sVar.addListener(new com.polygamma.ogm.s(sVar, cVar), executor);
    }

    public static void c(@Nullable Future<?> future) {
        if (future != null) {
            future.cancel(false);
            try {
                Futures.e(future);
            } catch (Throwable unused) {
            }
        }
    }

    public static void d(Iterable<Future<?>> iterable) {
        for (Future<?> future : iterable) {
            if (future != null) {
                future.cancel(false);
            }
        }
        for (Future<?> future2 : iterable) {
            if (future2 != null) {
                try {
                    Futures.e(future2);
                } catch (Throwable unused) {
                }
            }
        }
    }
}

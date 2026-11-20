package io.reactivex.rxjava3.internal.util;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d {
    public static void a(u30.c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    public static void b(u30.c<?> cVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th2) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> boolean c(u30.c<? super T> cVar, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t11);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            atomicThrowable.tryTerminateConsumer(cVar);
        }
        return false;
    }
}

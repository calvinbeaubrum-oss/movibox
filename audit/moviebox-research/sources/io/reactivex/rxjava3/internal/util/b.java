package io.reactivex.rxjava3.internal.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    public static void a() {
        if (p10.a.j()) {
            if ((Thread.currentThread() instanceof io.reactivex.rxjava3.internal.schedulers.f) || p10.a.p()) {
                throw new IllegalStateException("Attempt to block on a Scheduler " + Thread.currentThread().getName() + " that doesn't support blocking operators as they may lead to deadlock");
            }
        }
    }
}

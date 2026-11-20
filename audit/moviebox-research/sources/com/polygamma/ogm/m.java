package com.polygamma.ogm;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import p007do.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class m extends FutureTask implements com.google.common.util.concurrent.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.common.util.concurrent.i f48883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f48884b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(x xVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f48884b = xVar;
        Objects.requireNonNull(runnable);
        this.f48883a = new com.google.common.util.concurrent.i();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(x xVar, Callable callable) {
        super(callable);
        this.f48884b = xVar;
        Objects.requireNonNull(callable);
        this.f48883a = new com.google.common.util.concurrent.i();
    }

    @Override // com.google.common.util.concurrent.s
    public final void addListener(Runnable runnable, Executor executor) {
        this.f48883a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public final void done() {
        x xVar = this.f48884b;
        if (xVar.f63514b.decrementAndGet() == 0) {
            Lock lock = xVar.f63513a.readLock();
            lock.lock();
            try {
                if (xVar.f63516d == 1) {
                    xVar.b();
                }
                lock.unlock();
            } catch (Throwable th2) {
                lock.unlock();
                throw th2;
            }
        }
        this.f48883a.b();
    }
}

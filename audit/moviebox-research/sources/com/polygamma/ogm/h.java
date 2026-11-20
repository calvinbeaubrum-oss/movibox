package com.polygamma.ogm;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import p007do.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f48873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f48874d;

    public h(x xVar, p007do.s sVar, Runnable runnable) {
        super(xVar, runnable, null);
        Objects.requireNonNull(sVar);
        this.f48873c = sVar;
    }

    public h(x xVar, p007do.s sVar, Callable callable) {
        super(xVar, callable);
        Objects.requireNonNull(sVar);
        this.f48873c = sVar;
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        if (this.f48874d) {
            super.run();
            return;
        }
        if (isDone()) {
            return;
        }
        this.f48874d = true;
        try {
            this.f48873c.execute(this);
        } catch (RejectedExecutionException e11) {
            setException(e11);
        }
    }
}

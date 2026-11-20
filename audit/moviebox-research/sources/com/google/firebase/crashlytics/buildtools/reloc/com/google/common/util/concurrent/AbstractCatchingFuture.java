package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends AbstractFuture.g<V> implements Runnable {
    Class<X> exceptionType;
    F fallback;
    i0<? extends V> inputFuture;

    /* JADX INFO: compiled from: source.java */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, g<? super X, ? extends V>, i0<? extends V>> {
        public AsyncCatchingFuture(i0<? extends V> i0Var, Class<X> cls, g<? super X, ? extends V> gVar) {
            super(i0Var, cls, gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractCatchingFuture
        public i0<? extends V> doFallback(g<? super X, ? extends V> gVar, X x11) throws Exception {
            i0<? extends V> i0VarApply = gVar.apply(x11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(i0VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            return i0VarApply;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(i0<? extends V> i0Var) {
            setFuture(i0Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V>, V> {
        public CatchingFuture(i0<? extends V> i0Var, Class<X> cls, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V> dVar) {
            super(i0Var, cls, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractCatchingFuture
        public V doFallback(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V> dVar, X x11) throws Exception {
            return dVar.apply(x11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(V v11) {
            set(v11);
        }
    }

    public AbstractCatchingFuture(i0<? extends V> i0Var, Class<X> cls, F f11) {
        this.inputFuture = (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(i0Var);
        this.exceptionType = (Class) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cls);
        this.fallback = (F) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(f11);
    }

    public static <V, X extends Throwable> i0<V> create(i0<? extends V> i0Var, Class<X> cls, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V> dVar, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(i0Var, cls, dVar);
        i0Var.addListener(catchingFuture, MoreExecutors.b(executor, catchingFuture));
        return catchingFuture;
    }

    public static <X extends Throwable, V> i0<V> create(i0<? extends V> i0Var, Class<X> cls, g<? super X, ? extends V> gVar, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(i0Var, cls, gVar);
        i0Var.addListener(asyncCatchingFuture, MoreExecutors.b(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    public abstract T doFallback(F f11, X x11) throws Exception;

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        i0<? extends V> i0Var = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        String strPendingToString = super.pendingToString();
        if (i0Var != null) {
            str = "inputFuture=[" + i0Var + "], ";
        } else {
            str = "";
        }
        if (cls == null || f11 == null) {
            if (strPendingToString == null) {
                return null;
            }
            return str + strPendingToString;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f11 + "]";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    public final void run() throws ExecutionException {
        Object objD;
        i0<? extends V> i0Var = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        if (((f11 == null) | (i0Var == null) | (cls == null)) || isCancelled()) {
            return;
        }
        ?? r11 = (Class<X>) null;
        this.inputFuture = null;
        try {
            objD = Futures.d(i0Var);
            th = null;
        } catch (ExecutionException e11) {
            th = (Throwable) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11.getCause());
            objD = null;
        } catch (Throwable th2) {
            th = th2;
            objD = null;
        }
        if (th == null) {
            set(objD);
            return;
        }
        if (!k0.a(th, cls)) {
            setException(th);
            return;
        }
        try {
            Object objDoFallback = doFallback(f11, th);
            this.exceptionType = null;
            this.fallback = null;
            setResult(objDoFallback);
        } catch (Throwable th3) {
            try {
                setException(th3);
            } finally {
                this.exceptionType = null;
                this.fallback = null;
            }
        }
    }

    public abstract void setResult(T t11);
}

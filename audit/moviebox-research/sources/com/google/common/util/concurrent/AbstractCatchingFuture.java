package com.google.common.util.concurrent;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractCatchingFuture<V, X extends Throwable, F, T> extends k.a<V> implements Runnable {
    Class<X> exceptionType;
    F fallback;
    s<? extends V> inputFuture;

    /* JADX INFO: compiled from: source.java */
    public static final class AsyncCatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, f<? super X, ? extends V>, s<? extends V>> {
        public AsyncCatchingFuture(s<? extends V> sVar, Class<X> cls, f<? super X, ? extends V> fVar) {
            super(sVar, cls, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public s<? extends V> doFallback(f<? super X, ? extends V> fVar, X x11) throws Exception {
            s<? extends V> sVarApply = fVar.apply(x11);
            com.google.common.base.m.r(sVarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return sVarApply;
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(s<? extends V> sVar) {
            setFuture(sVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class CatchingFuture<V, X extends Throwable> extends AbstractCatchingFuture<V, X, com.google.common.base.f<? super X, ? extends V>, V> {
        public CatchingFuture(s<? extends V> sVar, Class<X> cls, com.google.common.base.f<? super X, ? extends V> fVar) {
            super(sVar, cls, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public V doFallback(com.google.common.base.f<? super X, ? extends V> fVar, X x11) throws Exception {
            return fVar.apply(x11);
        }

        @Override // com.google.common.util.concurrent.AbstractCatchingFuture
        public void setResult(V v11) {
            set(v11);
        }
    }

    public AbstractCatchingFuture(s<? extends V> sVar, Class<X> cls, F f11) {
        this.inputFuture = (s) com.google.common.base.m.p(sVar);
        this.exceptionType = (Class) com.google.common.base.m.p(cls);
        this.fallback = (F) com.google.common.base.m.p(f11);
    }

    public static <V, X extends Throwable> s<V> create(s<? extends V> sVar, Class<X> cls, com.google.common.base.f<? super X, ? extends V> fVar, Executor executor) {
        CatchingFuture catchingFuture = new CatchingFuture(sVar, cls, fVar);
        sVar.addListener(catchingFuture, MoreExecutors.c(executor, catchingFuture));
        return catchingFuture;
    }

    public static <X extends Throwable, V> s<V> create(s<? extends V> sVar, Class<X> cls, f<? super X, ? extends V> fVar, Executor executor) {
        AsyncCatchingFuture asyncCatchingFuture = new AsyncCatchingFuture(sVar, cls, fVar);
        sVar.addListener(asyncCatchingFuture, MoreExecutors.c(executor, asyncCatchingFuture));
        return asyncCatchingFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }

    public abstract T doFallback(F f11, X x11) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        s<? extends V> sVar = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        String strPendingToString = super.pendingToString();
        if (sVar != null) {
            str = "inputFuture=[" + sVar + "], ";
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
    public final void run() {
        Throwable e11;
        Object objD;
        s<? extends V> sVar = this.inputFuture;
        Class<X> cls = this.exceptionType;
        F f11 = this.fallback;
        if (((f11 == null) || ((sVar == 0) | (cls == null))) || isCancelled()) {
            return;
        }
        ?? r11 = (Class<X>) null;
        this.inputFuture = null;
        try {
            e11 = sVar instanceof ij.a ? ij.b.a((ij.a) sVar) : null;
            objD = e11 == null ? Futures.d(sVar) : null;
        } catch (Error e12) {
            e11 = e12;
        } catch (RuntimeException e13) {
            e11 = e13;
        } catch (ExecutionException e14) {
            Throwable cause = e14.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + sVar.getClass() + " threw " + e14.getClass() + " without a cause");
            }
            e11 = cause;
        }
        if (e11 == null) {
            set(x.a(objD));
            return;
        }
        if (!z.a(e11, cls)) {
            setFuture(sVar);
            return;
        }
        try {
            Object objDoFallback = doFallback(f11, e11);
            this.exceptionType = null;
            this.fallback = null;
            setResult(objDoFallback);
        } catch (Throwable th2) {
            try {
                z.b(th2);
                setException(th2);
            } finally {
                this.exceptionType = null;
                this.fallback = null;
            }
        }
    }

    public abstract void setResult(T t11);
}

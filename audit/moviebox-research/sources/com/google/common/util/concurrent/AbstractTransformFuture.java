package com.google.common.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractTransformFuture<I, O, F, T> extends k.a<O> implements Runnable {
    F function;
    s<? extends I> inputFuture;

    /* JADX INFO: compiled from: source.java */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, f<? super I, ? extends O>, s<? extends O>> {
        public AsyncTransformFuture(s<? extends I> sVar, f<? super I, ? extends O> fVar) {
            super(sVar, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public s<? extends O> doTransform(f<? super I, ? extends O> fVar, I i11) throws Exception {
            s<? extends O> sVarApply = fVar.apply(i11);
            com.google.common.base.m.r(sVarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fVar);
            return sVarApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(s<? extends O> sVar) {
            setFuture(sVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, com.google.common.base.f<? super I, ? extends O>, O> {
        public TransformFuture(s<? extends I> sVar, com.google.common.base.f<? super I, ? extends O> fVar) {
            super(sVar, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public O doTransform(com.google.common.base.f<? super I, ? extends O> fVar, I i11) {
            return fVar.apply(i11);
        }

        @Override // com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(O o11) {
            set(o11);
        }
    }

    public AbstractTransformFuture(s<? extends I> sVar, F f11) {
        this.inputFuture = (s) com.google.common.base.m.p(sVar);
        this.function = (F) com.google.common.base.m.p(f11);
    }

    public static <I, O> s<O> create(s<I> sVar, com.google.common.base.f<? super I, ? extends O> fVar, Executor executor) {
        com.google.common.base.m.p(fVar);
        TransformFuture transformFuture = new TransformFuture(sVar, fVar);
        sVar.addListener(transformFuture, MoreExecutors.c(executor, transformFuture));
        return transformFuture;
    }

    public static <I, O> s<O> create(s<I> sVar, f<? super I, ? extends O> fVar, Executor executor) {
        com.google.common.base.m.p(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(sVar, fVar);
        sVar.addListener(asyncTransformFuture, MoreExecutors.c(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    public abstract T doTransform(F f11, I i11) throws Exception;

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        s<? extends I> sVar = this.inputFuture;
        F f11 = this.function;
        String strPendingToString = super.pendingToString();
        if (sVar != null) {
            str = "inputFuture=[" + sVar + "], ";
        } else {
            str = "";
        }
        if (f11 != null) {
            return str + "function=[" + f11 + "]";
        }
        if (strPendingToString == null) {
            return null;
        }
        return str + strPendingToString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        s<? extends I> sVar = this.inputFuture;
        F f11 = this.function;
        if ((isCancelled() | (sVar == null)) || (f11 == null)) {
            return;
        }
        this.inputFuture = null;
        if (sVar.isCancelled()) {
            setFuture(sVar);
            return;
        }
        try {
            try {
                Object objDoTransform = doTransform(f11, Futures.d(sVar));
                this.function = null;
                setResult(objDoTransform);
            } catch (Throwable th2) {
                try {
                    z.b(th2);
                    setException(th2);
                } finally {
                    this.function = null;
                }
            }
        } catch (Error e11) {
            setException(e11);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e12) {
            setException(e12);
        } catch (ExecutionException e13) {
            setException(e13.getCause());
        }
    }

    public abstract void setResult(T t11);
}

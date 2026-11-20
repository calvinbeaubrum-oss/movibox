package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractTransformFuture<I, O, F, T> extends AbstractFuture.g<O> implements Runnable {
    F function;
    i0<? extends I> inputFuture;

    /* JADX INFO: compiled from: source.java */
    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, g<? super I, ? extends O>, i0<? extends O>> {
        public AsyncTransformFuture(i0<? extends I> i0Var, g<? super I, ? extends O> gVar) {
            super(i0Var, gVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractTransformFuture
        public i0<? extends O> doTransform(g<? super I, ? extends O> gVar, I i11) throws Exception {
            i0<? extends O> i0VarApply = gVar.apply(i11);
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.o(i0VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
            return i0VarApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(i0<? extends O> i0Var) {
            setFuture(i0Var);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super I, ? extends O>, O> {
        public TransformFuture(i0<? extends I> i0Var, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super I, ? extends O> dVar) {
            super(i0Var, dVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractTransformFuture
        public O doTransform(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super I, ? extends O> dVar, I i11) {
            return dVar.apply(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractTransformFuture
        public void setResult(O o11) {
            set(o11);
        }
    }

    public AbstractTransformFuture(i0<? extends I> i0Var, F f11) {
        this.inputFuture = (i0) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(i0Var);
        this.function = (F) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(f11);
    }

    public static <I, O> i0<O> create(i0<I> i0Var, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super I, ? extends O> dVar, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(dVar);
        TransformFuture transformFuture = new TransformFuture(i0Var, dVar);
        i0Var.addListener(transformFuture, MoreExecutors.b(executor, transformFuture));
        return transformFuture;
    }

    public static <I, O> i0<O> create(i0<I> i0Var, g<? super I, ? extends O> gVar, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(i0Var, gVar);
        i0Var.addListener(asyncTransformFuture, MoreExecutors.b(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    public abstract T doTransform(F f11, I i11) throws Exception;

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
    public String pendingToString() {
        String str;
        i0<? extends I> i0Var = this.inputFuture;
        F f11 = this.function;
        String strPendingToString = super.pendingToString();
        if (i0Var != null) {
            str = "inputFuture=[" + i0Var + "], ";
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
        i0<? extends I> i0Var = this.inputFuture;
        F f11 = this.function;
        if ((isCancelled() | (i0Var == null)) || (f11 == null)) {
            return;
        }
        this.inputFuture = null;
        try {
            try {
                try {
                    try {
                        Object objDoTransform = doTransform(f11, Futures.d(i0Var));
                        this.function = null;
                        setResult(objDoTransform);
                    } catch (UndeclaredThrowableException e11) {
                        setException(e11.getCause());
                        this.function = null;
                    }
                } catch (Throwable th2) {
                    setException(th2);
                    this.function = null;
                }
            } catch (Throwable th3) {
                this.function = null;
                throw th3;
            }
        } catch (Error e12) {
            setException(e12);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e13) {
            setException(e13);
        } catch (ExecutionException e14) {
            setException(e14.getCause());
        }
    }

    public abstract void setResult(T t11);
}

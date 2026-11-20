package com.google.common.util.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class Futures extends q {

    /* JADX INFO: compiled from: source.java */
    public static final class CallbackListener<V> implements Runnable {
        final o<? super V> callback;
        final Future<V> future;

        public CallbackListener(Future<V> future, o<? super V> oVar) {
            this.future = future;
            this.callback = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.future;
            if ((future instanceof ij.a) && (thA = ij.b.a((ij.a) future)) != null) {
                this.callback.a(thA);
                return;
            }
            try {
                this.callback.onSuccess(Futures.d(this.future));
            } catch (Error e11) {
                e = e11;
                this.callback.a(e);
            } catch (RuntimeException e12) {
                e = e12;
                this.callback.a(e);
            } catch (ExecutionException e13) {
                this.callback.a(e13.getCause());
            }
        }

        public String toString() {
            return com.google.common.base.h.b(this).j(this.callback).toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.h<V> implements Runnable {
        private s<V> delegate;

        public NonCancellationPropagatingFuture(s<V> sVar) {
            this.delegate = sVar;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            s<V> sVar = this.delegate;
            if (sVar == null) {
                return null;
            }
            return "delegate=[" + sVar + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            s<V> sVar = this.delegate;
            if (sVar != null) {
                setFuture(sVar);
            }
        }
    }

    public static <V> void a(s<V> sVar, o<? super V> oVar, Executor executor) {
        com.google.common.base.m.p(oVar);
        sVar.addListener(new CallbackListener(sVar, oVar), executor);
    }

    public static <V, X extends Throwable> s<V> b(s<? extends V> sVar, Class<X> cls, com.google.common.base.f<? super X, ? extends V> fVar, Executor executor) {
        return AbstractCatchingFuture.create(sVar, cls, fVar, executor);
    }

    public static <V, X extends Throwable> s<V> c(s<? extends V> sVar, Class<X> cls, f<? super X, ? extends V> fVar, Executor executor) {
        return AbstractCatchingFuture.create(sVar, cls, fVar, executor);
    }

    public static <V> V d(Future<V> future) throws ExecutionException {
        com.google.common.base.m.z(future.isDone(), "Future was expected to be done: %s", future);
        return (V) c0.a(future);
    }

    public static <V> V e(Future<V> future) {
        com.google.common.base.m.p(future);
        try {
            return (V) c0.a(future);
        } catch (ExecutionException e11) {
            l(e11.getCause());
            throw new AssertionError();
        }
    }

    public static <V> s<V> f(Throwable th2) {
        com.google.common.base.m.p(th2);
        return new r.a(th2);
    }

    public static <V> s<V> g(V v11) {
        return v11 == null ? (s<V>) r.f38949b : new r(v11);
    }

    public static s<Void> h() {
        return r.f38949b;
    }

    public static <I, O> s<O> i(s<I> sVar, com.google.common.base.f<? super I, ? extends O> fVar, Executor executor) {
        return AbstractTransformFuture.create(sVar, fVar, executor);
    }

    public static <I, O> s<O> j(s<I> sVar, f<? super I, ? extends O> fVar, Executor executor) {
        return AbstractTransformFuture.create(sVar, fVar, executor);
    }

    public static <V> s<V> k(s<V> sVar, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return sVar.isDone() ? sVar : TimeoutFuture.e(sVar, j11, timeUnit, scheduledExecutorService);
    }

    public static void l(Throwable th2) {
        if (!(th2 instanceof Error)) {
            throw new UncheckedExecutionException(th2);
        }
        throw new ExecutionError((Error) th2);
    }
}

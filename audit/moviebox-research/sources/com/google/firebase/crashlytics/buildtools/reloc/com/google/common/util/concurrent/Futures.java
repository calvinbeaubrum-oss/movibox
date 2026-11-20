package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class Futures extends f0 {

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Futures$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Future val$scheduled;

        public AnonymousClass1(Future future) {
            this.val$scheduled = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$scheduled.cancel(false);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.Futures$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ImmutableList val$delegates;
        final /* synthetic */ int val$localI;
        final /* synthetic */ a val$state;

        public AnonymousClass3(a aVar, ImmutableList immutableList, int i11) {
            this.val$delegates = immutableList;
            this.val$localI = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(null, this.val$delegates, this.val$localI);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class CallbackListener<V> implements Runnable {
        final d0<? super V> callback;
        final Future<V> future;

        public CallbackListener(Future<V> future, d0<? super V> d0Var) {
            this.future = future;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
        
            throw null;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                Futures.d(this.future);
                throw null;
            } catch (Error | RuntimeException unused) {
                throw null;
            } catch (ExecutionException e11) {
                e11.getCause();
                throw null;
            }
        }

        public String toString() {
            return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.f.b(this).h(null).toString();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class NonCancellationPropagatingFuture<V> extends AbstractFuture.g<V> implements Runnable {
        private i0<V> delegate;

        public NonCancellationPropagatingFuture(i0<V> i0Var) {
            this.delegate = i0Var;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.delegate = null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.util.concurrent.AbstractFuture
        public String pendingToString() {
            i0<V> i0Var = this.delegate;
            if (i0Var == null) {
                return null;
            }
            return "delegate=[" + i0Var + "]";
        }

        @Override // java.lang.Runnable
        public void run() {
            i0<V> i0Var = this.delegate;
            if (i0Var != null) {
                setFuture(i0Var);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a<T> {
        public static /* synthetic */ void a(a aVar, ImmutableList immutableList, int i11) {
            throw null;
        }
    }

    public static <V> void a(i0<V> i0Var, d0<? super V> d0Var, Executor executor) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(d0Var);
        i0Var.addListener(new CallbackListener(i0Var, d0Var), executor);
    }

    public static <V, X extends Throwable> i0<V> b(i0<? extends V> i0Var, Class<X> cls, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super X, ? extends V> dVar, Executor executor) {
        return AbstractCatchingFuture.create(i0Var, cls, dVar, executor);
    }

    public static <V, X extends Throwable> i0<V> c(i0<? extends V> i0Var, Class<X> cls, g<? super X, ? extends V> gVar, Executor executor) {
        return AbstractCatchingFuture.create(i0Var, cls, gVar, executor);
    }

    public static <V> V d(Future<V> future) throws ExecutionException {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.w(future.isDone(), "Future was expected to be done: %s", future);
        return (V) n0.a(future);
    }

    public static <V> i0<V> e(Throwable th2) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(th2);
        return new g0.a(th2);
    }

    public static <V> i0<V> f(V v11) {
        return v11 == null ? g0.b.f40008c : new g0.b(v11);
    }

    public static <I, O> i0<O> g(i0<I> i0Var, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<? super I, ? extends O> dVar, Executor executor) {
        return AbstractTransformFuture.create(i0Var, dVar, executor);
    }

    public static <I, O> i0<O> h(i0<I> i0Var, g<? super I, ? extends O> gVar, Executor executor) {
        return AbstractTransformFuture.create(i0Var, gVar, executor);
    }

    public static <V> i0<V> i(i0<V> i0Var, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return TimeoutFuture.c(i0Var, j11, timeUnit, scheduledExecutorService);
    }
}

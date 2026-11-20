package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class LottieTask<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f15063e = Executors.newCachedThreadPool(new g7.g());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<m0<T>> f15064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<m0<Throwable>> f15065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f15066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public volatile q0<T> f15067d;

    /* JADX INFO: compiled from: source.java */
    public static class LottieFutureTask<T> extends FutureTask<q0<T>> {
        private LottieTask<T> lottieTask;

        public LottieFutureTask(LottieTask<T> lottieTask, Callable<q0<T>> callable) {
            super(callable);
            this.lottieTask = lottieTask;
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.lottieTask.l(get());
                } catch (InterruptedException | ExecutionException e11) {
                    this.lottieTask.l(new q0(e11));
                }
            } finally {
                this.lottieTask = null;
            }
        }
    }

    public LottieTask(T t11) {
        this.f15064a = new LinkedHashSet(1);
        this.f15065b = new LinkedHashSet(1);
        this.f15066c = new Handler(Looper.getMainLooper());
        this.f15067d = null;
        l(new q0<>(t11));
    }

    public LottieTask(Callable<q0<T>> callable) {
        this(callable, false);
    }

    public LottieTask(Callable<q0<T>> callable, boolean z11) {
        this.f15064a = new LinkedHashSet(1);
        this.f15065b = new LinkedHashSet(1);
        this.f15066c = new Handler(Looper.getMainLooper());
        this.f15067d = null;
        if (!z11) {
            f15063e.execute(new LottieFutureTask(this, callable));
            return;
        }
        try {
            l(callable.call());
        } catch (Throwable th2) {
            l(new q0<>(th2));
        }
    }

    public synchronized LottieTask<T> c(m0<Throwable> m0Var) {
        try {
            q0<T> q0Var = this.f15067d;
            if (q0Var != null && q0Var.a() != null) {
                m0Var.onResult(q0Var.a());
            }
            this.f15065b.add(m0Var);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    public synchronized LottieTask<T> d(m0<T> m0Var) {
        try {
            q0<T> q0Var = this.f15067d;
            if (q0Var != null && q0Var.b() != null) {
                m0Var.onResult(q0Var.b());
            }
            this.f15064a.add(m0Var);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    @Nullable
    public q0<T> e() {
        return this.f15067d;
    }

    public final synchronized void f(Throwable th2) {
        ArrayList arrayList = new ArrayList(this.f15065b);
        if (arrayList.isEmpty()) {
            g7.f.d("Lottie encountered an error but no failure listener was added:", th2);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((m0) it.next()).onResult(th2);
        }
    }

    public final void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.f15066c.post(new Runnable() { // from class: com.airbnb.lottie.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15323a.h();
                }
            });
        }
    }

    public final void h() {
        q0<T> q0Var = this.f15067d;
        if (q0Var == null) {
            return;
        }
        if (q0Var.b() != null) {
            i(q0Var.b());
        } else {
            f(q0Var.a());
        }
    }

    public final synchronized void i(T t11) {
        Iterator it = new ArrayList(this.f15064a).iterator();
        while (it.hasNext()) {
            ((m0) it.next()).onResult(t11);
        }
    }

    public synchronized LottieTask<T> j(m0<Throwable> m0Var) {
        this.f15065b.remove(m0Var);
        return this;
    }

    public synchronized LottieTask<T> k(m0<T> m0Var) {
        this.f15064a.remove(m0Var);
        return this;
    }

    public final void l(@Nullable q0<T> q0Var) {
        if (this.f15067d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f15067d = q0Var;
        g();
    }
}

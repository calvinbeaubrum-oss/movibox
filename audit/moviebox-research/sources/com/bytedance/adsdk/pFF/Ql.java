package com.bytedance.adsdk.pFF;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.component.sdk.annotation.RestrictTo;
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
/* JADX INFO: loaded from: classes3.dex */
public class Ql<T> {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static Executor f26125sc = Executors.newCachedThreadPool();
    private volatile Tf<T> ExN;
    private final Handler We;
    private final Set<UFX<T>> pFF;
    private final Set<UFX<Throwable>> zY;

    /* JADX INFO: compiled from: source.java */
    public class sc extends FutureTask<Tf<T>> {
        public sc(Callable<Tf<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                Ql.this.sc((Tf) get());
            } catch (InterruptedException | ExecutionException e11) {
                Ql.this.sc(new Tf(e11));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Ql(Callable<Tf<T>> callable) {
        this(callable, false);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Ql(Callable<Tf<T>> callable, boolean z11) {
        this.pFF = new LinkedHashSet(1);
        this.zY = new LinkedHashSet(1);
        this.We = new Handler(Looper.getMainLooper());
        this.ExN = null;
        if (!z11) {
            f26125sc.execute(new sc(callable));
            return;
        }
        try {
            sc((Tf) callable.call());
        } catch (Throwable th2) {
            sc((Tf) new Tf<>(th2));
        }
    }

    private void sc() {
        this.We.post(new Runnable() { // from class: com.bytedance.adsdk.pFF.Ql.1
            @Override // java.lang.Runnable
            public void run() {
                Tf tf2 = Ql.this.ExN;
                if (tf2 == null) {
                    return;
                }
                if (tf2.sc() != null) {
                    Ql.this.sc(tf2.sc());
                } else {
                    Ql.this.sc(tf2.pFF());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(Tf<T> tf2) {
        if (this.ExN != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.ExN = tf2;
        sc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(T t11) {
        Iterator it = new ArrayList(this.pFF).iterator();
        while (it.hasNext()) {
            ((UFX) it.next()).sc(t11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sc(Throwable th2) {
        ArrayList arrayList = new ArrayList(this.zY);
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UFX) it.next()).sc(th2);
        }
    }

    public synchronized Ql<T> We(UFX<Throwable> ufx) {
        this.zY.remove(ufx);
        return this;
    }

    public synchronized Ql<T> pFF(UFX<T> ufx) {
        this.pFF.remove(ufx);
        return this;
    }

    public synchronized Ql<T> sc(UFX<T> ufx) {
        try {
            Tf<T> tf2 = this.ExN;
            if (tf2 != null && tf2.sc() != null) {
                ufx.sc(tf2.sc());
            }
            this.pFF.add(ufx);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }

    public synchronized Ql<T> zY(UFX<Throwable> ufx) {
        try {
            Tf<T> tf2 = this.ExN;
            if (tf2 != null && tf2.pFF() != null) {
                ufx.sc(tf2.pFF());
            }
            this.zY.add(ufx);
        } catch (Throwable th2) {
            throw th2;
        }
        return this;
    }
}

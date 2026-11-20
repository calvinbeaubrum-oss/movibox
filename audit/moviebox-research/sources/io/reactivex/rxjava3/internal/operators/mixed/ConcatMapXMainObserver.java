package io.reactivex.rxjava3.internal.operators.mixed;

import h10.b;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import m10.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ConcatMapXMainObserver<T> extends AtomicInteger implements o<T>, b {
    private static final long serialVersionUID = -3214213361171757852L;
    volatile boolean disposed;
    volatile boolean done;
    final ErrorMode errorMode;
    final AtomicThrowable errors = new AtomicThrowable();
    final int prefetch;
    g<T> queue;
    b upstream;

    public ConcatMapXMainObserver(int i11, ErrorMode errorMode) {
        this.errorMode = errorMode;
        this.prefetch = i11;
    }

    public void clearValue() {
    }

    @Override // h10.b
    public final void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        disposeInner();
        this.errors.tryTerminateAndReport();
        if (getAndIncrement() == 0) {
            this.queue.clear();
            clearValue();
        }
    }

    public abstract void disposeInner();

    public abstract void drain();

    @Override // h10.b
    public final boolean isDisposed() {
        return this.disposed;
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onComplete() {
        this.done = true;
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                disposeInner();
            }
            this.done = true;
            drain();
        }
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onNext(T t11) {
        if (t11 != null) {
            this.queue.offer(t11);
        }
        drain();
    }

    @Override // io.reactivex.rxjava3.core.o
    public final void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof m10.b) {
                m10.b bVar2 = (m10.b) bVar;
                int iRequestFusion = bVar2.requestFusion(7);
                if (iRequestFusion == 1) {
                    this.queue = bVar2;
                    this.done = true;
                    onSubscribeDownstream();
                    drain();
                    return;
                }
                if (iRequestFusion == 2) {
                    this.queue = bVar2;
                    onSubscribeDownstream();
                    return;
                }
            }
            this.queue = new a(this.prefetch);
            onSubscribeDownstream();
        }
    }

    public abstract void onSubscribeDownstream();
}

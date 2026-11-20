package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.i;
import java.util.concurrent.atomic.AtomicReference;
import m10.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class InnerQueuedObserver<T> extends AtomicReference<h10.b> implements o<T>, h10.b {
    private static final long serialVersionUID = -5417183359794346637L;
    volatile boolean done;
    int fusionMode;
    final b<T> parent;
    final int prefetch;
    g<T> queue;

    public InnerQueuedObserver(b<T> bVar, int i11) {
        this.prefetch = i11;
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public boolean isDone() {
        return this.done;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onComplete() {
        throw null;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onError(Throwable th2) {
        throw null;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onNext(T t11) {
        if (this.fusionMode != 0) {
            throw null;
        }
        throw null;
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            if (bVar instanceof m10.b) {
                m10.b bVar2 = (m10.b) bVar;
                int iRequestFusion = bVar2.requestFusion(3);
                if (iRequestFusion == 1) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    throw null;
                }
                if (iRequestFusion == 2) {
                    this.fusionMode = iRequestFusion;
                    this.queue = bVar2;
                    return;
                }
            }
            this.queue = i.c(-this.prefetch);
        }
    }

    public g<T> queue() {
        return this.queue;
    }

    public void setDone() {
        this.done = true;
    }
}

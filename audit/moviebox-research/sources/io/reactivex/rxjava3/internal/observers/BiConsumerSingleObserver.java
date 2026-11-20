package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.q;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class BiConsumerSingleObserver<T> extends AtomicReference<h10.b> implements q<T>, h10.b {
    private static final long serialVersionUID = 4943102778943297569L;
    final k10.b<? super T, ? super Throwable> onCallback;

    public BiConsumerSingleObserver(k10.b<? super T, ? super Throwable> bVar) {
    }

    @Override // h10.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onError(Throwable th2) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            throw null;
        } catch (Throwable th3) {
            i10.a.b(th3);
            p10.a.q(new CompositeException(th2, th3));
        }
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSubscribe(h10.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.rxjava3.core.q
    public void onSuccess(T t11) {
        try {
            lazySet(DisposableHelper.DISPOSED);
            throw null;
        } catch (Throwable th2) {
            i10.a.b(th2);
            p10.a.q(th2);
        }
    }
}

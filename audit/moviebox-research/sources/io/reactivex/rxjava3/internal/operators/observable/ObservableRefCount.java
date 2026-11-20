package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ObservableRefCount<T> extends io.reactivex.rxjava3.core.j<T> {

    /* JADX INFO: compiled from: source.java */
    public static final class RefConnection extends AtomicReference<h10.b> implements Runnable, k10.f<h10.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final ObservableRefCount<?> parent;
        long subscriberCount;
        h10.b timer;

        public RefConnection(ObservableRefCount<?> observableRefCount) {
        }

        @Override // k10.f
        public void accept(h10.b bVar) {
            DisposableHelper.replace(this, bVar);
            throw null;
        }

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }
}

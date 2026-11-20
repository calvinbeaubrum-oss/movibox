package io.reactivex.rxjava3.internal.disposables;

import h10.b;
import i10.a;
import java.util.concurrent.atomic.AtomicReference;
import k10.e;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class CancellableDisposable extends AtomicReference<e> implements b {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableDisposable(e eVar) {
        super(eVar);
    }

    @Override // h10.b
    public void dispose() {
        e andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Throwable th2) {
            a.b(th2);
            p10.a.q(th2);
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get() == null;
    }
}

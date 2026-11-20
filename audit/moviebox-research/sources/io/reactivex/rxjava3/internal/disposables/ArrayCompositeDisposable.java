package io.reactivex.rxjava3.internal.disposables;

import h10.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<b> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i11) {
        super(i11);
    }

    @Override // h10.b
    public void dispose() {
        b andSet;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i11 = 0; i11 < length; i11++) {
                b bVar = get(i11);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (bVar != disposableHelper && (andSet = getAndSet(i11, disposableHelper)) != disposableHelper && andSet != null) {
                    andSet.dispose();
                }
            }
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public b replaceResource(int i11, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i11);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i11, bVar2, bVar));
        return bVar2;
    }

    public boolean setResource(int i11, b bVar) {
        b bVar2;
        do {
            bVar2 = get(i11);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i11, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}

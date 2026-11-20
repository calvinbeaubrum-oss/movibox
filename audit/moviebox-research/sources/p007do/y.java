package p007do;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends PhantomReference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f63517a;

    public y(Object obj, ReferenceQueue referenceQueue, Runnable runnable) {
        super(obj, referenceQueue);
        this.f63517a = new AtomicReference(runnable);
    }

    @Override // java.lang.ref.Reference
    public final void clear() {
        Runnable runnable = (Runnable) this.f63517a.getAndSet(null);
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                super.clear();
            }
        }
    }
}

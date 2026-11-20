package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.a;
import io.reactivex.rxjava3.core.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class CompletableTimeout extends a {

    /* JADX INFO: compiled from: source.java */
    public final class DisposeTask implements Runnable {
        final b downstream;
        private final AtomicBoolean once;
        final h10.a set;
        final /* synthetic */ CompletableTimeout this$0;

        public DisposeTask(CompletableTimeout completableTimeout, AtomicBoolean atomicBoolean, h10.a aVar, b bVar) {
            this.once = atomicBoolean;
            this.set = aVar;
            this.downstream = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.once.compareAndSet(false, true)) {
                this.set.d();
                throw null;
            }
        }
    }
}

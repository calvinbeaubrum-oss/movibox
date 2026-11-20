package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class FlowableConcatMap$SimpleScalarSubscription<T> extends AtomicBoolean implements u30.d {
    private static final long serialVersionUID = -7606889335172043256L;
    final u30.c<? super T> downstream;
    final T value;

    public FlowableConcatMap$SimpleScalarSubscription(T t11, u30.c<? super T> cVar) {
        this.value = t11;
        this.downstream = cVar;
    }

    @Override // u30.d
    public void cancel() {
    }

    @Override // u30.d
    public void request(long j11) {
        if (j11 <= 0 || !compareAndSet(false, true)) {
            return;
        }
        u30.c<? super T> cVar = this.downstream;
        cVar.onNext(this.value);
        cVar.onComplete();
    }
}

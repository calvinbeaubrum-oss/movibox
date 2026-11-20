package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class ObservableSampleTimed$SampleTimedNoLast<T> extends ObservableSampleTimed$SampleTimedObserver<T> {
    private static final long serialVersionUID = -7139995637533111443L;

    public ObservableSampleTimed$SampleTimedNoLast(io.reactivex.rxjava3.core.o<? super T> oVar, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        super(oVar, j11, timeUnit, scheduler);
    }

    @Override // io.reactivex.rxjava3.internal.operators.observable.ObservableSampleTimed$SampleTimedObserver
    public void complete() {
        this.downstream.onComplete();
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }
}

package io.reactivex.rxjava3.parallel;

import k10.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // k10.c
    public ParallelFailureHandling apply(Long l11, Throwable th2) {
        return this;
    }
}

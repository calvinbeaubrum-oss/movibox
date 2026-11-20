package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.i;
import k10.h;
import u30.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum MaybeToPublisher implements h<i<Object>, b<Object>> {
    INSTANCE;

    public static <T> h<i<T>, b<T>> instance() {
        return INSTANCE;
    }

    @Override // k10.h
    public b<Object> apply(i<Object> iVar) {
        return new MaybeToFlowable(iVar);
    }
}

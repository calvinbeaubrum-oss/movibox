package io.reactivex.rxjava3.internal.operators.flowable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum FlowableInternalHelper$RequestMax implements k10.f<u30.d> {
    INSTANCE;

    @Override // k10.f
    public void accept(u30.d dVar) {
        dVar.request(Long.MAX_VALUE);
    }
}

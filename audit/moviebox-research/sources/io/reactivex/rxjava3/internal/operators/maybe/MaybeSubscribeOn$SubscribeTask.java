package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
final class MaybeSubscribeOn$SubscribeTask<T> implements Runnable {
    final h<? super T> observer;
    final i<T> source;

    public MaybeSubscribeOn$SubscribeTask(h<? super T> hVar, i<T> iVar) {
        this.observer = hVar;
        this.source = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.source.a(this.observer);
    }
}

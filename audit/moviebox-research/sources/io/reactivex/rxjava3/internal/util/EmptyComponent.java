package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum EmptyComponent implements io.reactivex.rxjava3.core.f<Object>, o<Object>, io.reactivex.rxjava3.core.h<Object>, q<Object>, io.reactivex.rxjava3.core.b, u30.d, h10.b {
    INSTANCE;

    public static <T> o<T> asObserver() {
        return INSTANCE;
    }

    public static <T> u30.c<T> asSubscriber() {
        return INSTANCE;
    }

    @Override // u30.d
    public void cancel() {
    }

    @Override // h10.b
    public void dispose() {
    }

    @Override // h10.b
    public boolean isDisposed() {
        return true;
    }

    @Override // u30.c
    public void onComplete() {
    }

    @Override // u30.c
    public void onError(Throwable th2) {
        p10.a.q(th2);
    }

    @Override // u30.c
    public void onNext(Object obj) {
    }

    @Override // io.reactivex.rxjava3.core.o
    public void onSubscribe(h10.b bVar) {
        bVar.dispose();
    }

    @Override // u30.c
    public void onSubscribe(u30.d dVar) {
        dVar.cancel();
    }

    @Override // io.reactivex.rxjava3.core.h
    public void onSuccess(Object obj) {
    }

    @Override // u30.d
    public void request(long j11) {
    }
}

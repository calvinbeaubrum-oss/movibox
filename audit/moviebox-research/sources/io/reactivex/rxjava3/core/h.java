package io.reactivex.rxjava3.core;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface h<T> {
    void onComplete();

    void onError(Throwable th2);

    void onSubscribe(h10.b bVar);

    void onSuccess(T t11);
}

package io.reactivex.rxjava3.core;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface o<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t11);

    void onSubscribe(h10.b bVar);
}

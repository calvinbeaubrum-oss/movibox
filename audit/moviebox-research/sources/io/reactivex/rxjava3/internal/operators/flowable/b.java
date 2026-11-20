package io.reactivex.rxjava3.internal.operators.flowable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface b<T> {
    void innerComplete();

    void innerError(Throwable th2);

    void innerNext(T t11);
}

package io.reactivex.rxjava3.internal.util;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface h<T, U> {
    boolean accept(u30.c<? super U> cVar, T t11);

    boolean cancelled();

    boolean done();

    Throwable error();

    int leave(int i11);

    long produced(long j11);

    long requested();
}

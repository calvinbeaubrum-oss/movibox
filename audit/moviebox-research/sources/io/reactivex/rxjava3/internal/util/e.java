package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.core.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface e<T, U> {
    void accept(o<? super U> oVar, T t11);

    boolean cancelled();

    boolean done();

    Throwable error();

    int leave(int i11);
}

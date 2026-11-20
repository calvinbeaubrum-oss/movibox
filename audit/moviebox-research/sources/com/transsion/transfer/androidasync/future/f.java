package com.transsion.transfer.androidasync.future;

import java.util.concurrent.Future;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public interface f<T> extends a, Future<T> {
    <R> f<R> a(z<R, T> zVar);

    f<T> i(d dVar);

    void j(g<T> gVar);

    <R> f<R> r(y<R, T> yVar);

    f<T> s(x<T> xVar);
}

package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.core.h;
import io.reactivex.rxjava3.core.o;
import io.reactivex.rxjava3.core.q;
import m10.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum EmptyDisposable implements b<Object> {
    INSTANCE,
    NEVER;

    public static void complete(io.reactivex.rxjava3.core.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onComplete();
    }

    public static void complete(h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onComplete();
    }

    public static void complete(o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onComplete();
    }

    public static void error(Throwable th2, io.reactivex.rxjava3.core.b bVar) {
        bVar.onSubscribe(INSTANCE);
        bVar.onError(th2);
    }

    public static void error(Throwable th2, h<?> hVar) {
        hVar.onSubscribe(INSTANCE);
        hVar.onError(th2);
    }

    public static void error(Throwable th2, o<?> oVar) {
        oVar.onSubscribe(INSTANCE);
        oVar.onError(th2);
    }

    public static void error(Throwable th2, q<?> qVar) {
        qVar.onSubscribe(INSTANCE);
        qVar.onError(th2);
    }

    @Override // m10.g
    public void clear() {
    }

    @Override // h10.b
    public void dispose() {
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this == INSTANCE;
    }

    @Override // m10.g
    public boolean isEmpty() {
        return true;
    }

    @Override // m10.g
    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // m10.g
    public Object poll() {
        return null;
    }

    @Override // m10.c
    public int requestFusion(int i11) {
        return i11 & 2;
    }
}

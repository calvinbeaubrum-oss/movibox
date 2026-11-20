package com.google.common.util.concurrent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b0<V> extends AbstractFuture.h<V> {
    public static <V> b0<V> b() {
        return new b0<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.h, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean isDone() {
        return super.isDone();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(V v11) {
        return super.set(v11);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th2) {
        return super.setException(th2);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(s<? extends V> sVar) {
        return super.setFuture(sVar);
    }
}

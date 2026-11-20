package com.bytedance.sdk.component.Qj;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class qr<V> extends FutureTask<V> implements Comparable<qr<V>> {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26562sc;

    public qr(Runnable runnable, V v11, int i11, int i12) {
        super(runnable, v11);
        this.f26562sc = i11 == -1 ? 5 : i11;
        this.pFF = i12;
    }

    public qr(Callable<V> callable, int i11, int i12) {
        super(callable);
        this.f26562sc = i11 == -1 ? 5 : i11;
        this.pFF = i12;
    }

    public int sc() {
        return this.f26562sc;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(qr qrVar) {
        if (sc() < qrVar.sc()) {
            return 1;
        }
        return sc() > qrVar.sc() ? -1 : 0;
    }
}

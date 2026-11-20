package io.reactivex.rxjava3.internal.operators.observable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p<T> extends io.reactivex.rxjava3.core.j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.rxjava3.subjects.a<T> f67455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f67456b = new AtomicBoolean();

    public p(io.reactivex.rxjava3.subjects.a<T> aVar) {
        this.f67455a = aVar;
    }

    public boolean F() {
        return !this.f67456b.get() && this.f67456b.compareAndSet(false, true);
    }

    @Override // io.reactivex.rxjava3.core.j
    public void z(io.reactivex.rxjava3.core.o<? super T> oVar) {
        this.f67455a.subscribe(oVar);
        this.f67456b.set(true);
    }
}

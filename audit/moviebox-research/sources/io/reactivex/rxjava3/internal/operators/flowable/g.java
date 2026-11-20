package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g<T> extends io.reactivex.rxjava3.core.e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final io.reactivex.rxjava3.processors.a<T> f67377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f67378c = new AtomicBoolean();

    public g(io.reactivex.rxjava3.processors.a<T> aVar) {
        this.f67377b = aVar;
    }

    @Override // io.reactivex.rxjava3.core.e
    public void g(u30.c<? super T> cVar) {
        this.f67377b.subscribe(cVar);
        this.f67378c.set(true);
    }

    public boolean h() {
        return !this.f67378c.get() && this.f67378c.compareAndSet(false, true);
    }
}

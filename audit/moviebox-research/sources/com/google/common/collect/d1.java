package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d1<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f38686a;

    public d1(Iterator<? extends F> it) {
        this.f38686a = (Iterator) com.google.common.base.m.p(it);
    }

    public abstract T a(F f11);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f38686a.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f38686a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f38686a.remove();
    }
}

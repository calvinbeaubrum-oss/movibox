package com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e1<F, T> extends d1<F, T> implements ListIterator<T> {
    public e1(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t11) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return Iterators.d(this.f38686a);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t11) {
        throw new UnsupportedOperationException();
    }
}

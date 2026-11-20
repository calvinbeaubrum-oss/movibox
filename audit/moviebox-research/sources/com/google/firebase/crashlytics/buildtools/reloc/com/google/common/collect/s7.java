package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.ListIterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class s7<F, T> extends r7<F, T> implements ListIterator<T> {
    public s7(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t11) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return Iterators.c(this.f39757a);
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

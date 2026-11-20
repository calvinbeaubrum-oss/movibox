package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<E> extends h1<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f38674b;

    public a(int i11) {
        this(i11, 0);
    }

    public a(int i11, int i12) {
        com.google.common.base.m.s(i12, i11);
        this.f38673a = i11;
        this.f38674b = i12;
    }

    public abstract E a(int i11);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f38674b < this.f38673a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f38674b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f38674b;
        this.f38674b = i11 + 1;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f38674b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f38674b - 1;
        this.f38674b = i11;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f38674b - 1;
    }
}

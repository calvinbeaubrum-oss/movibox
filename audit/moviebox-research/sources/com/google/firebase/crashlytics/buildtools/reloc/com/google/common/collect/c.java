package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class c<E> extends u7<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f39677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39678b;

    public c(int i11) {
        this(i11, 0);
    }

    public c(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.q(i12, i11);
        this.f39677a = i11;
        this.f39678b = i12;
    }

    public abstract E a(int i11);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f39678b < this.f39677a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f39678b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f39678b;
        this.f39678b = i11 + 1;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f39678b;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f39678b - 1;
        this.f39678b = i11;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f39678b - 1;
    }
}

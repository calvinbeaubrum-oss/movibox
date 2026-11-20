package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class c extends qp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f18064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18065b;

    public c(int i11, int i12) {
        Preconditions.checkPositionIndex(i12, i11);
        this.f18064a = i11;
        this.f18065b = i12;
    }

    public abstract Object a(int i11);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f18065b < this.f18064a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f18065b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f18065b;
        this.f18065b = i11 + 1;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f18065b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i11 = this.f18065b - 1;
        this.f18065b = i11;
        return a(i11);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f18065b - 1;
    }
}

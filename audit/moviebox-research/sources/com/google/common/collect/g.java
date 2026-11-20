package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class g<T> extends g1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f38697a;

    public g(T t11) {
        this.f38697a = t11;
    }

    public abstract T a(T t11);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f38697a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t11 = this.f38697a;
        if (t11 == null) {
            throw new NoSuchElementException();
        }
        this.f38697a = a(t11);
        return t11;
    }
}

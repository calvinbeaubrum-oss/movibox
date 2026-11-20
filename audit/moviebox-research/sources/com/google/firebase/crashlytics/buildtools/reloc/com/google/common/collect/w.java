package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class w<T> extends t7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f39785a;

    public w(T t11) {
        this.f39785a = t11;
    }

    public abstract T a(T t11);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f39785a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return this.f39785a;
        } finally {
            this.f39785a = a(this.f39785a);
        }
    }
}

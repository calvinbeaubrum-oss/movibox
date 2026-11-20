package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class p2<T> extends t2 implements Iterator<T> {
    public abstract Iterator<T> f();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return f().hasNext();
    }

    public T next() {
        return f().next();
    }
}

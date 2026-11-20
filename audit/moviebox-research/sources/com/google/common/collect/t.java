package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t<T> extends x implements Iterator<T> {
    @Override // java.util.Iterator
    public boolean hasNext() {
        return u().hasNext();
    }

    public T next() {
        return u().next();
    }

    public abstract Iterator<T> u();
}

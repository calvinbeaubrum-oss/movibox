package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class w<E> extends r<E> implements j0<E> {
    @Override // com.google.common.collect.j0
    public int add(E e11, int i11) {
        return u().add(e11, i11);
    }

    @Override // com.google.common.collect.j0
    public int count(Object obj) {
        return u().count(obj);
    }

    public abstract Set<j0.a<E>> entrySet();

    @Override // java.util.Collection, com.google.common.collect.j0
    public boolean equals(Object obj) {
        return obj == this || u().equals(obj);
    }

    @Override // java.util.Collection, com.google.common.collect.j0
    public int hashCode() {
        return u().hashCode();
    }

    @Override // com.google.common.collect.j0
    public int remove(Object obj, int i11) {
        return u().remove(obj, i11);
    }

    @Override // com.google.common.collect.j0
    public int setCount(E e11, int i11) {
        return u().setCount(e11, i11);
    }

    @Override // com.google.common.collect.j0
    public boolean setCount(E e11, int i11, int i12) {
        return u().setCount(e11, i11, i12);
    }

    @Override // com.google.common.collect.r
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // com.google.common.collect.r
    public void standardClear() {
        Iterators.e(entrySet().iterator());
    }

    @Override // com.google.common.collect.r
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.r
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // com.google.common.collect.r
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.j(this, collection);
    }

    @Override // com.google.common.collect.r
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // com.google.common.collect.r
    public String standardToString() {
        return entrySet().toString();
    }

    public abstract j0<E> u();
}

package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d<E> extends AbstractCollection<E> implements j0<E> {
    private transient Set<E> elementSet;
    private transient Set<j0.a<E>> entrySet;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multisets.c<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.c
        public j0<E> a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return d.this.elementIterator();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Multisets.d<E> {
        public b() {
        }

        @Override // com.google.common.collect.Multisets.d
        public j0<E> a() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<j0.a<E>> iterator() {
            return d.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.distinctElements();
        }
    }

    public int add(E e11, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(E e11) {
        add(e11, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Set<E> createElementSet() {
        return new a();
    }

    public Set<j0.a<E>> createEntrySet() {
        return new b();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set != null) {
            return set;
        }
        Set<E> setCreateElementSet = createElementSet();
        this.elementSet = setCreateElementSet;
        return setCreateElementSet;
    }

    public abstract Iterator<j0.a<E>> entryIterator();

    public Set<j0.a<E>> entrySet() {
        Set<j0.a<E>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        Set<j0.a<E>> setCreateEntrySet = createEntrySet();
        this.entrySet = setCreateEntrySet;
        return setCreateEntrySet;
    }

    @Override // java.util.Collection, com.google.common.collect.j0
    public final boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.j0
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    public int remove(Object obj, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.j(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    public int setCount(E e11, int i11) {
        return Multisets.l(this, e11, i11);
    }

    public boolean setCount(E e11, int i11, int i12) {
        return Multisets.m(this, e11, i11, i12);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class w2<E> extends v2<E> implements SortedSet<E> {
    private int f(Object obj, Object obj2) {
        Comparator<? super E> comparator = comparator();
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }

    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.v2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public abstract SortedSet<E> delegate();

    @Override // java.util.SortedSet
    public E first() {
        return delegate().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e11) {
        return delegate().headSet(e11);
    }

    @Override // java.util.SortedSet
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardContains(Object obj) {
        try {
            return f(tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.n2
    public boolean standardRemove(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext() && f(it.next(), obj) == 0) {
                it.remove();
                return true;
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(E e11, E e12) {
        return tailSet(e11).headSet(e12);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e11, E e12) {
        return delegate().subSet(e11, e12);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e11) {
        return delegate().tailSet(e11);
    }
}

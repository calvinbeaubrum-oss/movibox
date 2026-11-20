package com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b0<E> extends z<E> implements SortedSet<E> {
    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return u().comparator();
    }

    @Override // com.google.common.collect.z, com.google.common.collect.r, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract SortedSet<E> u();

    @Override // java.util.SortedSet
    public E first() {
        return u().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e11) {
        return u().headSet(e11);
    }

    @Override // java.util.SortedSet
    public E last() {
        return u().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.r
    public boolean standardContains(Object obj) {
        try {
            return a0.u(comparator(), tailSet(obj).first(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.r
    public boolean standardRemove(Object obj) {
        try {
            Iterator<E> it = tailSet(obj).iterator();
            if (it.hasNext()) {
                if (a0.u(comparator(), it.next(), obj) == 0) {
                    it.remove();
                    return true;
                }
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
        return u().subSet(e11, e12);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e11) {
        return u().tailSet(e11);
    }
}

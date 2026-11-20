package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface j0<E> extends Collection<E> {

    /* JADX INFO: compiled from: source.java */
    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e11, int i11);

    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    boolean equals(Object obj);

    int hashCode();

    int remove(Object obj, int i11);

    boolean remove(Object obj);

    int setCount(E e11, int i11);

    boolean setCount(E e11, int i11, int i12);

    int size();
}

package com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface z0<E> extends j0, x0<E> {
    Comparator<? super E> comparator();

    z0<E> descendingMultiset();

    @Override // com.google.common.collect.j0
    NavigableSet<E> elementSet();

    @Override // com.google.common.collect.j0
    Set<j0.a<E>> entrySet();

    j0.a<E> firstEntry();

    z0<E> headMultiset(E e11, BoundType boundType);

    j0.a<E> lastEntry();

    j0.a<E> pollFirstEntry();

    j0.a<E> pollLastEntry();

    z0<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2);

    z0<E> tailMultiset(E e11, BoundType boundType);
}

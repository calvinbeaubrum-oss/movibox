package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface g7<E> extends l6, e7<E> {
    Comparator<? super E> comparator();

    g7<E> descendingMultiset();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    NavigableSet<E> elementSet();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    Set<l6.a<E>> entrySet();

    l6.a<E> firstEntry();

    g7<E> headMultiset(E e11, BoundType boundType);

    l6.a<E> lastEntry();

    l6.a<E> pollFirstEntry();

    l6.a<E> pollLastEntry();

    g7<E> subMultiset(E e11, BoundType boundType, E e12, BoundType boundType2);

    g7<E> tailMultiset(E e11, BoundType boundType);
}

package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface l6<E> extends Collection<E> {

    /* JADX INFO: compiled from: source.java */
    public interface a<E> {
        int getCount();

        E getElement();

        String toString();
    }

    int add(E e11, int i11);

    @Override // java.util.Collection
    boolean add(E e11);

    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    boolean equals(Object obj);

    void forEachEntry(ObjIntConsumer<? super E> objIntConsumer);

    int hashCode();

    int remove(Object obj, int i11);

    @Override // java.util.Collection
    boolean remove(Object obj);

    int setCount(E e11, int i11);

    boolean setCount(E e11, int i11, int i12);

    int size();
}

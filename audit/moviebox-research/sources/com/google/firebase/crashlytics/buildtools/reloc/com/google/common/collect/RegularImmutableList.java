package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0]);
    final transient Object[] array;

    public RegularImmutableList(Object[] objArr) {
        this.array = objArr;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        Object[] objArr2 = this.array;
        System.arraycopy(objArr2, 0, objArr, i11, objArr2.length);
        return i11 + this.array.length;
    }

    @Override // java.util.List
    public E get(int i11) {
        return (E) this.array[i11];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
    public u7<E> listIterator(int i11) {
        Object[] objArr = this.array;
        return Iterators.m(objArr, 0, objArr.length, i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.array.length;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.array, 1296);
    }
}

package com.google.common.collect;

import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0], 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f38559a;
    final transient Object[] array;

    public RegularImmutableList(Object[] objArr, int i11) {
        this.array = objArr;
        this.f38559a = i11;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        System.arraycopy(this.array, 0, objArr, i11, this.f38559a);
        return i11 + this.f38559a;
    }

    @Override // java.util.List
    public E get(int i11) {
        com.google.common.base.m.n(i11, this.f38559a);
        E e11 = (E) this.array[i11];
        Objects.requireNonNull(e11);
        return e11;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.array;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.f38559a;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f38559a;
    }
}

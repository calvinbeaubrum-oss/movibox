package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.base.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(ObjectArrays.EMPTY_ARRAY);
    private final transient Object[] array;
    private final transient int offset;
    private final transient int size;

    public RegularImmutableList(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public RegularImmutableList(Object[] objArr, int i11, int i12) {
        this.offset = i11;
        this.size = i12;
        this.array = objArr;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        System.arraycopy(this.array, this.offset, objArr, i11, this.size);
        return i11 + this.size;
    }

    @Override // java.util.List
    public E get(int i11) {
        Preconditions.checkElementIndex(i11, this.size);
        return (E) this.array[i11 + this.offset];
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.size != this.array.length;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i11) {
        return Iterators.forArray(this.array, this.offset, this.size, i11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableList
    public ImmutableList<E> subListUnchecked(int i11, int i12) {
        return new RegularImmutableList(this.array, this.offset + i11, i12 - i11);
    }
}

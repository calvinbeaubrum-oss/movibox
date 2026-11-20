package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient int[] f38297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient int[] f38298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient int f38299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient int f38300i;

    public CompactLinkedHashSet() {
    }

    public CompactLinkedHashSet(int i11) {
        super(i11);
    }

    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> compactLinkedHashSetCreateWithExpectedSize = createWithExpectedSize(collection.size());
        compactLinkedHashSetCreateWithExpectedSize.addAll(collection);
        return compactLinkedHashSetCreateWithExpectedSize;
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> compactLinkedHashSetCreateWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(compactLinkedHashSetCreateWithExpectedSize, eArr);
        return compactLinkedHashSetCreateWithExpectedSize;
    }

    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i11) {
        return new CompactLinkedHashSet<>(i11);
    }

    public final void A(int i11, int i12) {
        if (i11 == -2) {
            this.f38299h = i12;
        } else {
            B(i11, i12);
        }
        if (i12 == -2) {
            this.f38300i = i11;
        } else {
            z(i12, i11);
        }
    }

    public final void B(int i11, int i12) {
        y()[i11] = i12 + 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int adjustAfterRemove(int i11, int i12) {
        return i11 >= size() ? i12 : i11;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int allocArrays() {
        int iAllocArrays = super.allocArrays();
        this.f38297f = new int[iAllocArrays];
        this.f38298g = new int[iAllocArrays];
        return iAllocArrays;
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.f38299h = -2;
        this.f38300i = -2;
        int[] iArr = this.f38297f;
        if (iArr != null && this.f38298g != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.f38298g, 0, size(), 0);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashSet
    public Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> setConvertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.f38297f = null;
        this.f38298g = null;
        return setConvertToHashFloodingResistantImplementation;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int firstEntryIndex() {
        return this.f38299h;
    }

    @Override // com.google.common.collect.CompactHashSet
    public int getSuccessor(int i11) {
        return y()[i11] - 1;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void init(int i11) {
        super.init(i11);
        this.f38299h = -2;
        this.f38300i = -2;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void insertEntry(int i11, E e11, int i12, int i13) {
        super.insertEntry(i11, e11, i12, i13);
        A(this.f38300i, i11);
        A(i11, -2);
    }

    @Override // com.google.common.collect.CompactHashSet
    public void moveLastEntry(int i11, int i12) {
        int size = size() - 1;
        super.moveLastEntry(i11, i12);
        A(w(i11), getSuccessor(i11));
        if (i11 < size) {
            A(w(size), i11);
            A(i11, getSuccessor(size));
        }
        x()[size] = 0;
        y()[size] = 0;
    }

    @Override // com.google.common.collect.CompactHashSet
    public void resizeEntries(int i11) {
        super.resizeEntries(i11);
        this.f38297f = Arrays.copyOf(x(), i11);
        this.f38298g = Arrays.copyOf(y(), i11);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return l0.f(this);
    }

    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) l0.g(this, tArr);
    }

    public final int w(int i11) {
        return x()[i11] - 1;
    }

    public final int[] x() {
        int[] iArr = this.f38297f;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final int[] y() {
        int[] iArr = this.f38298g;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final void z(int i11, int i12) {
        x()[i11] = i12 + 1;
    }
}

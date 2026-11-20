package com.google.common.collect;

import com.google.common.primitives.Ints;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient long[] f38578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f38579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f38580c;
    final transient RegularImmutableSortedSet<E> elementSet;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f38577d = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i11, int i12) {
        this.elementSet = regularImmutableSortedSet;
        this.f38578a = jArr;
        this.f38579b = i11;
        this.f38580c = i12;
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.f38578a = f38577d;
        this.f38579b = 0;
        this.f38580c = 0;
    }

    public final int a(int i11) {
        long[] jArr = this.f38578a;
        int i12 = this.f38579b;
        return (int) (jArr[(i12 + i11) + 1] - jArr[i12 + i11]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public int count(Object obj) {
        int iIndexOf = this.elementSet.indexOf(obj);
        if (iIndexOf >= 0) {
            return a(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public j0.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public j0.a<E> getEntry(int i11) {
        return Multisets.g(this.elementSet.asList().get(i11), a(i11));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i11, int i12) {
        com.google.common.base.m.u(i11, i12, this.f38580c);
        if (i11 == i12) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i11 == 0 && i12 == this.f38580c) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i11, i12), this.f38578a, this.f38579b + i11, i12 - i11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e11, com.google.common.base.m.p(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f38579b > 0 || this.f38580c < this.f38578a.length - 1;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public j0.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f38580c - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public int size() {
        long[] jArr = this.f38578a;
        int i11 = this.f38579b;
        return Ints.l(jArr[this.f38580c + i11] - jArr[i11]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e11, com.google.common.base.m.p(boundType) == BoundType.CLOSED), this.f38580c);
    }
}

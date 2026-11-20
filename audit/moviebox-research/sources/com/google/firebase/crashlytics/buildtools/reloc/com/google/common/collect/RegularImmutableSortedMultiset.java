package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives.Ints;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient long[] f39569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f39570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f39571c;
    final transient RegularImmutableSortedSet<E> elementSet;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f39568d = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new RegularImmutableSortedMultiset(Ordering.natural());

    public RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i11, int i12) {
        this.elementSet = regularImmutableSortedSet;
        this.f39569a = jArr;
        this.f39570b = i11;
        this.f39571c = i12;
    }

    public RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.emptySet(comparator);
        this.f39569a = f39568d;
        this.f39570b = 0;
        this.f39571c = 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        int iIndexOf = this.elementSet.indexOf(obj);
        if (iIndexOf >= 0) {
            return s(iIndexOf);
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(0);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(objIntConsumer);
        for (int i11 = 0; i11 < this.f39571c; i11++) {
            objIntConsumer.accept(this.elementSet.asList().get(i11), s(i11));
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
    public l6.a<E> getEntry(int i11) {
        return Multisets.g(this.elementSet.asList().get(i11), s(i11));
    }

    public ImmutableSortedMultiset<E> getSubMultiset(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, this.f39571c);
        if (i11 == i12) {
            return ImmutableSortedMultiset.emptyMultiset(comparator());
        }
        return (i11 == 0 && i12 == this.f39571c) ? this : new RegularImmutableSortedMultiset(this.elementSet.getSubSet(i11, i12), this.f39569a, this.f39570b + i11, i12 - i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return getSubMultiset(0, this.elementSet.headIndex(e11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f39570b > 0 || this.f39571c < this.f39569a.length - 1;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return getEntry(this.f39571c - 1);
    }

    public final int s(int i11) {
        long[] jArr = this.f39569a;
        int i12 = this.f39570b;
        return (int) (jArr[(i12 + i11) + 1] - jArr[i12 + i11]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        long[] jArr = this.f39569a;
        int i11 = this.f39570b;
        return Ints.i(jArr[this.f39571c + i11] - jArr[i11]);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return getSubMultiset(this.elementSet.tailIndex(e11, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(boundType) == BoundType.CLOSED), this.f39571c);
    }
}

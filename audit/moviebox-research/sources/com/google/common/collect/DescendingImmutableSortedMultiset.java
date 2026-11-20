package com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableSortedMultiset<E> f38315a;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f38315a = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public int count(Object obj) {
        return this.f38315a.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f38315a;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j0
    public ImmutableSortedSet<E> elementSet() {
        return this.f38315a.elementSet().descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public j0.a<E> firstEntry() {
        return this.f38315a.lastEntry();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    public j0.a<E> getEntry(int i11) {
        return this.f38315a.entrySet().asList().reverse().get(i11);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return this.f38315a.tailMultiset((Object) e11, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f38315a.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public j0.a<E> lastEntry() {
        return this.f38315a.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j0
    public int size() {
        return this.f38315a.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.z0
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return this.f38315a.headMultiset((Object) e11, boundType).descendingMultiset();
    }
}

package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class DescendingImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableSortedMultiset<E> f39295a;

    public DescendingImmutableSortedMultiset(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.f39295a = immutableSortedMultiset;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int count(Object obj) {
        return this.f39295a.count(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.f39295a;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public ImmutableSortedSet<E> elementSet() {
        return this.f39295a.elementSet().descendingSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> firstEntry() {
        return this.f39295a.lastEntry();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer consumer) {
        k6.a(this, consumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultisetFauxverideShim, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        k6.b(this, objIntConsumer);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMultiset
    public l6.a<E> getEntry(int i11) {
        return this.f39295a.entrySet().asList().reverse().get(i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> headMultiset(E e11, BoundType boundType) {
        return this.f39295a.tailMultiset((Object) e11, boundType).descendingMultiset();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.f39295a.isPartialView();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public l6.a<E> lastEntry() {
        return this.f39295a.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.l6
    public int size() {
        return this.f39295a.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSortedMultiset, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.g7
    public ImmutableSortedMultiset<E> tailMultiset(E e11, BoundType boundType) {
        return this.f39295a.headMultiset((Object) e11, boundType).descendingMultiset();
    }
}

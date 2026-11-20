package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f39574a;
    final transient E element;

    public SingletonImmutableSet(E e11) {
        this.element = (E) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
    }

    public SingletonImmutableSet(E e11, int i11) {
        this.element = e11;
        this.f39574a = i11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        objArr[i11] = this.element;
        return i11 + 1;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i11 = this.f39574a;
        if (i11 != 0) {
            return i11;
        }
        int iHashCode = this.element.hashCode();
        this.f39574a = iHashCode;
        return iHashCode;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return this.f39574a != 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return Iterators.v(this.element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.element.toString() + ']';
    }
}

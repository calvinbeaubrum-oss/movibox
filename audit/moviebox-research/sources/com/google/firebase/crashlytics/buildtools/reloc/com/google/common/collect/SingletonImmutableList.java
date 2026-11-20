package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collections;
import java.util.Spliterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    public SingletonImmutableList(E e11) {
        this.element = (E) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(e11);
    }

    @Override // java.util.List
    public E get(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, 1);
        return this.element;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return Iterators.v(this.element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return Collections.singleton(this.element).spliterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i12, 1);
        return i11 == i12 ? ImmutableList.of() : this;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.element.toString() + ']';
    }
}

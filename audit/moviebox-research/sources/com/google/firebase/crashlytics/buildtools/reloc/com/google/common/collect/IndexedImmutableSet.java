package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        return asList().copyIntoArray(objArr, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return new ImmutableAsList<E>() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.IndexedImmutableSet.1
            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
            public ImmutableCollection<E> delegateCollection() {
                return IndexedImmutableSet.this;
            }

            @Override // java.util.List
            public E get(int i11) {
                return (E) IndexedImmutableSet.this.get(i11);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(consumer);
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            consumer.accept(get(i11));
        }
    }

    public abstract E get(int i11);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableSet, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public t7<E> iterator() {
        return asList().iterator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return x1.c(size(), 1297, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.f5
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                return this.f39687a.get(i11);
            }
        });
    }
}

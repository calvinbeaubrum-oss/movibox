package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i11) {
        return this.delegateList.copyIntoArray(objArr, i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.delegateList.forEach(consumer);
    }

    @Override // java.util.List
    public E get(int i11) {
        return this.delegateList.get(i11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableList, java.util.List
    public u7<E> listIterator(int i11) {
        return this.delegateList.listIterator(i11);
    }
}

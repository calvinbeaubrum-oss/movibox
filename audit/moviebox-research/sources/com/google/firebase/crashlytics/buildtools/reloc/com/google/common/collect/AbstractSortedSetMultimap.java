package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    public AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public abstract SortedSet<V> createCollection();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return (SortedSet<V>) unmodifiableCollectionSubclass((Collection) createCollection());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public SortedSet<V> get(K k11) {
        return (SortedSet) super.get((Object) k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public SortedSet<V> removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public SortedSet<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((Object) k11, (Iterable) iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return collection instanceof NavigableSet ? Sets.j((NavigableSet) collection) : Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    public abstract /* synthetic */ Comparator valueComparator();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractSetMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k11, Collection<V> collection) {
        return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.m(k11, (NavigableSet) collection, null) : new AbstractMapBasedMultimap.o(k11, (SortedSet) collection, null);
    }
}

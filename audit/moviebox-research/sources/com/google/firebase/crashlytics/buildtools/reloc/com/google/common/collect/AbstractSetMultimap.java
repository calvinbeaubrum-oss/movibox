package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements z6<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public abstract Set<V> createCollection();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<V> get(K k11) {
        return (Set) super.get((Object) k11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public boolean put(K k11, V v11) {
        return super.put(k11, v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.s
    public Set<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((Object) k11, (Iterable) iterable);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k11, Collection<V> collection) {
        return new AbstractMapBasedMultimap.n(k11, (Set) collection);
    }
}

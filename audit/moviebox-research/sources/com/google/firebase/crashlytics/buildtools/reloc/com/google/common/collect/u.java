package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class u<K, V> extends Maps.h<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: compiled from: source.java */
    public final class b extends Maps.f<K, V> {
        public b() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.f
        public Iterator<Map.Entry<K, V>> g() {
            return u.this.a();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.f
        public NavigableMap<K, V> u() {
            return u.this;
        }
    }

    public abstract Iterator<Map.Entry<K, V>> a();

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k11) {
        return tailMap(k11, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k11) {
        return (K) Maps.k(ceilingEntry(k11));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new b();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.o(entryIterator(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k11) {
        return headMap(k11, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k11) {
        return (K) Maps.k(floorEntry(k11));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k11) {
        return headMap(k11, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k11) {
        return tailMap(k11, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k11) {
        return (K) Maps.k(higherEntry(k11));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.o(a(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k11) {
        return headMap(k11, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k11) {
        return (K) Maps.k(lowerEntry(k11));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new Maps.j(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.s(entryIterator());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.s(a());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k11, K k12) {
        return subMap(k11, true, k12, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k11) {
        return tailMap(k11, true);
    }
}

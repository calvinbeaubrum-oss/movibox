package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class s<K, V> implements z5<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient l6<K> keys;
    private transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multimaps.b<K, V> {
        public a() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Multimaps.b
        public z5<K, V> a() {
            return s.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return s.this.entryIterator();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return s.this.entrySpliterator();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends s<K, V>.a implements Set<Map.Entry<K, V>> {
        public b() {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            s.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return s.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return s.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return s.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return s.this.valueSpliterator();
        }
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract l6<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionCreateEntries = createEntries();
        this.entries = collectionCreateEntries;
        return collectionCreateEntries;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entryIterator(), size(), this instanceof z6 ? 1 : 0);
    }

    public boolean equals(Object obj) {
        return Multimaps.c(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySet = setCreateKeySet;
        return setCreateKeySet;
    }

    public l6<K> keys() {
        l6<K> l6Var = this.keys;
        if (l6Var != null) {
            return l6Var;
        }
        l6<K> l6VarCreateKeys = createKeys();
        this.keys = l6VarCreateKeys;
        return l6VarCreateKeys;
    }

    public boolean put(K k11, V v11) {
        return get(k11).add(v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean putAll(z5<? extends K, ? extends V> z5Var) {
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : z5Var.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    public boolean putAll(K k11, Iterable<? extends V> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k11).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k11), it);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z5
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public Collection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(iterable);
        Collection<V> collectionRemoveAll = removeAll(k11);
        putAll(k11, iterable);
        return collectionRemoveAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.y(entries().iterator());
    }

    public Spliterator<V> valueSpliterator() {
        return Spliterators.spliterator(valueIterator(), size(), 0);
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.values = collectionCreateValues;
        return collectionCreateValues;
    }
}

package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c<K, V> implements h0<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient j0<K> keys;
    private transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public class a extends Multimaps.b<K, V> {
        public a() {
        }

        @Override // com.google.common.collect.Multimaps.b
        public h0<K, V> a() {
            return c.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return c.this.entryIterator();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        public b(c cVar) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return Sets.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.d(this);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0399c extends AbstractCollection<V> {
        public C0399c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return c.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c.this.size();
        }
    }

    @Override // com.google.common.collect.h0
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapCreateAsMap = createAsMap();
        this.asMap = mapCreateAsMap;
        return mapCreateAsMap;
    }

    @Override // com.google.common.collect.h0
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

    public abstract j0<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // com.google.common.collect.h0
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

    public boolean equals(Object obj) {
        return Multimaps.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.h0
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.h0
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.keySet = setCreateKeySet;
        return setCreateKeySet;
    }

    public j0<K> keys() {
        j0<K> j0Var = this.keys;
        if (j0Var != null) {
            return j0Var;
        }
        j0<K> j0VarCreateKeys = createKeys();
        this.keys = j0VarCreateKeys;
        return j0VarCreateKeys;
    }

    @Override // com.google.common.collect.h0
    public boolean put(K k11, V v11) {
        return get(k11).add(v11);
    }

    public boolean putAll(h0<? extends K, ? extends V> h0Var) {
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : h0Var.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    public boolean putAll(K k11, Iterable<? extends V> iterable) {
        com.google.common.base.m.p(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k11).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && Iterators.a(get(k11), it);
    }

    @Override // com.google.common.collect.h0
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public Collection<V> replaceValues(K k11, Iterable<? extends V> iterable) {
        com.google.common.base.m.p(iterable);
        Collection<V> collectionRemoveAll = removeAll(k11);
        putAll(k11, iterable);
        return collectionRemoveAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return Maps.D(entries().iterator());
    }

    @Override // com.google.common.collect.h0
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

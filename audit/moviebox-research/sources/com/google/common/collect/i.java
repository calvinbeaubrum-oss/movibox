package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i<R, C, V> implements b1<R, C, V> {
    private transient Set<b1.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public class a extends d1<b1.a<R, C, V>, V> {
        public a(i iVar, Iterator it) {
            super(it);
        }

        @Override // com.google.common.collect.d1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(b1.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractSet<b1.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof b1.a)) {
                return false;
            }
            b1.a aVar = (b1.a) obj;
            Map map = (Map) Maps.v(i.this.rowMap(), aVar.getRowKey());
            return map != null && m.c(map.entrySet(), Maps.i(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<b1.a<R, C, V>> iterator() {
            return i.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof b1.a)) {
                return false;
            }
            b1.a aVar = (b1.a) obj;
            Map map = (Map) Maps.v(i.this.rowMap(), aVar.getRowKey());
            return map != null && m.d(map.entrySet(), Maps.i(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            i.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return i.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return i.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return i.this.size();
        }
    }

    public abstract Iterator<b1.a<R, C, V>> cellIterator();

    @Override // com.google.common.collect.b1
    public Set<b1.a<R, C, V>> cellSet() {
        Set<b1.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<b1.a<R, C, V>> setCreateCellSet = createCellSet();
        this.cellSet = setCreateCellSet;
        return setCreateCellSet;
    }

    public void clear() {
        Iterators.e(cellSet().iterator());
    }

    @Override // com.google.common.collect.b1
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.v(rowMap(), obj);
        return map != null && Maps.u(map, obj2);
    }

    public boolean containsColumn(Object obj) {
        return Maps.u(columnMap(), obj);
    }

    public boolean containsRow(Object obj) {
        return Maps.u(rowMap(), obj);
    }

    public boolean containsValue(Object obj) {
        Iterator<Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set<b1.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    public boolean equals(Object obj) {
        return Tables.a(this, obj);
    }

    public V get(Object obj, Object obj2) {
        Map map = (Map) Maps.v(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.v(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V put(R r11, C c11, V v11) {
        return row(r11).put(c11, v11);
    }

    public void putAll(b1<? extends R, ? extends C, ? extends V> b1Var) {
        for (b1.a<? extends R, ? extends C, ? extends V> aVar : b1Var.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    public V remove(Object obj, Object obj2) {
        Map map = (Map) Maps.v(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.w(map, obj2);
    }

    @Override // com.google.common.collect.b1
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
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

    public Iterator<V> valuesIterator() {
        return new a(this, cellSet().iterator());
    }
}

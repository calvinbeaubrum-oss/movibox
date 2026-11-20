package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Function;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class z<R, C, V> implements p7<R, C, V> {
    private transient Set<p7.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    /* JADX INFO: compiled from: source.java */
    public class a extends r7<p7.a<R, C, V>, V> {
        public a(Iterator it) {
            super(it);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.r7
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(p7.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractSet<p7.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof p7.a)) {
                return false;
            }
            p7.a aVar = (p7.a) obj;
            Map map = (Map) Maps.s(z.this.rowMap(), aVar.getRowKey());
            return map != null && j2.d(map.entrySet(), Maps.g(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<p7.a<R, C, V>> iterator() {
            return z.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof p7.a)) {
                return false;
            }
            p7.a aVar = (p7.a) obj;
            Map map = (Map) Maps.s(z.this.rowMap(), aVar.getRowKey());
            return map != null && j2.e(map.entrySet(), Maps.g(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return z.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<p7.a<R, C, V>> spliterator() {
            return z.this.cellSpliterator();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            z.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return z.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return z.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return z.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return z.this.valuesSpliterator();
        }
    }

    public abstract Iterator<p7.a<R, C, V>> cellIterator();

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<p7.a<R, C, V>> cellSet() {
        Set<p7.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<p7.a<R, C, V>> setCreateCellSet = createCellSet();
        this.cellSet = setCreateCellSet;
        return setCreateCellSet;
    }

    public abstract Spliterator<p7.a<R, C, V>> cellSpliterator();

    public void clear() {
        Iterators.d(cellSet().iterator());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) Maps.s(rowMap(), obj);
        return map != null && Maps.r(map, obj2);
    }

    public boolean containsColumn(Object obj) {
        return Maps.r(columnMap(), obj);
    }

    public boolean containsRow(Object obj) {
        return Maps.r(rowMap(), obj);
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

    public Set<p7.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    public boolean equals(Object obj) {
        return Tables.a(this, obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V get(Object obj, Object obj2) {
        Map map = (Map) Maps.s(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.s(map, obj2);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V put(R r11, C c11, V v11) {
        return row(r11).put(c11, v11);
    }

    public void putAll(p7<? extends R, ? extends C, ? extends V> p7Var) {
        for (p7.a<? extends R, ? extends C, ? extends V> aVar : p7Var.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    public V remove(Object obj, Object obj2) {
        Map map = (Map) Maps.s(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) Maps.t(map, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
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
        return new a(cellSet().iterator());
    }

    public Spliterator<V> valuesSpliterator() {
        return x1.e(cellSpliterator(), new Function() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.y
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((p7.a) obj).getValue();
            }
        });
    }
}

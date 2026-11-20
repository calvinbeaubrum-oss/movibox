package com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* JADX INFO: compiled from: source.java */
    public static class Factory<C, V> implements com.google.common.base.q<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.common.base.q
        /* JADX INFO: renamed from: get */
        public TreeMap<C, V> get2() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C f38620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f38621d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Comparator f38622f;

        public a(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f38621d = it;
            this.f38622f = comparator;
        }

        @Override // com.google.common.collect.AbstractIterator
        public C a() {
            while (this.f38621d.hasNext()) {
                C c11 = (C) this.f38621d.next();
                C c12 = this.f38620c;
                if (c12 == null || this.f38622f.compare(c11, c12) != 0) {
                    this.f38620c = c11;
                    return c11;
                }
            }
            this.f38620c = null;
            return b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f38623d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C f38624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public transient SortedMap<C, V> f38625g;

        public b(TreeBasedTable treeBasedTable, R r11) {
            this(r11, null, null);
        }

        public b(R r11, C c11, C c12) {
            super(r11);
            this.f38623d = c11;
            this.f38624f = c12;
            com.google.common.base.m.d(c11 == null || c12 == null || g(c11, c12) <= 0);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        @Override // com.google.common.collect.StandardTable.g
        public void d() {
            k();
            SortedMap<C, V> sortedMap = this.f38625g;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f38609a);
            this.f38625g = null;
            this.f38610b = null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            e();
            Map<C, V> map = this.f38610b;
            if (map != null) {
                return (C) ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        public int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // com.google.common.collect.StandardTable.g
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> c() {
            k();
            SortedMap<C, V> sortedMapTailMap = this.f38625g;
            if (sortedMapTailMap == null) {
                return null;
            }
            C c11 = this.f38623d;
            if (c11 != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(c11);
            }
            C c12 = this.f38624f;
            return c12 != null ? sortedMapTailMap.headMap(c12) : sortedMapTailMap;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c11) {
            com.google.common.base.m.d(j(com.google.common.base.m.p(c11)));
            return new b(this.f38609a, this.f38623d, c11);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedSet<C> keySet() {
            return new Maps.n(this);
        }

        public boolean j(Object obj) {
            C c11;
            C c12;
            return obj != null && ((c11 = this.f38623d) == null || g(c11, obj) <= 0) && ((c12 = this.f38624f) == null || g(c12, obj) > 0);
        }

        public void k() {
            SortedMap<C, V> sortedMap = this.f38625g;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f38609a))) {
                this.f38625g = (SortedMap) TreeBasedTable.this.backingMap.get(this.f38609a);
            }
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            e();
            Map<C, V> map = this.f38610b;
            if (map != null) {
                return (C) ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c11, V v11) {
            com.google.common.base.m.d(j(com.google.common.base.m.p(c11)));
            return (V) super.put(c11, v11);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c11, C c12) {
            com.google.common.base.m.d(j(com.google.common.base.m.p(c11)) && j(com.google.common.base.m.p(c12)));
            return new b(this.f38609a, c11, c12);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c11) {
            com.google.common.base.m.d(j(com.google.common.base.m.p(c11)));
            return new b(this.f38609a, c11, this.f38624f);
        }
    }

    public TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new Factory(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(Ordering.natural(), Ordering.natural());
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        com.google.common.base.m.p(comparator);
        com.google.common.base.m.p(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Iterator lambda$createColumnKeyIterator$0(Map map) {
        return map.keySet().iterator();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.b1
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.b1
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.b1
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> comparatorColumnComparator = columnComparator();
        return new a(this, Iterators.s(e0.s(this.backingMap.values(), new com.google.common.base.f() { // from class: com.google.common.collect.f1
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return TreeBasedTable.lambda$createColumnKeyIterator$0((Map) obj);
            }
        }), comparatorColumnComparator), comparatorColumnComparator);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ void putAll(b1 b1Var) {
        super.putAll(b1Var);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.b1
    public SortedMap<C, V> row(R r11) {
        return new b(this, r11);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.i, com.google.common.collect.b1
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.b1
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.b1
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, com.google.common.collect.i
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}

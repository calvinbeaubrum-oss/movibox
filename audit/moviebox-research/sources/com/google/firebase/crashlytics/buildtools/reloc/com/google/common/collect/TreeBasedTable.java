package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* JADX INFO: compiled from: source.java */
    public static class Factory<C, V> implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public Factory(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.q, java.util.function.Supplier
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d<Map<C, V>, Iterator<C>> {
        public a() {
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.d, java.util.function.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public C f39611c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f39612d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Comparator f39613f;

        public b(Iterator it, Comparator comparator) {
            this.f39612d = it;
            this.f39613f = comparator;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.AbstractIterator
        public C a() {
            while (this.f39612d.hasNext()) {
                C c11 = (C) this.f39612d.next();
                C c12 = this.f39611c;
                if (c12 == null || this.f39613f.compare(c11, c12) != 0) {
                    this.f39611c = c11;
                    return c11;
                }
            }
            this.f39611c = null;
            return b();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends StandardTable<R, C, V>.g implements SortedMap<C, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f39615d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C f39616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public transient SortedMap<C, V> f39617g;

        public c(TreeBasedTable treeBasedTable, R r11) {
            this(r11, null, null);
        }

        public c(R r11, C c11, C c12) {
            super(r11);
            this.f39615d = c11;
            this.f39616f = c12;
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(c11 == null || c12 == null || g(c11, c12) <= 0);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return j(obj) && super.containsKey(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable.g
        public void d() {
            if (k() == null || !this.f39617g.isEmpty()) {
                return;
            }
            TreeBasedTable.this.backingMap.remove(this.f39598a);
            this.f39617g = null;
            this.f39599b = null;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable.g
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> a() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (a() != null) {
                return a().firstKey();
            }
            throw new NoSuchElementException();
        }

        public int g(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable.g
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> c() {
            SortedMap<C, V> sortedMapK = k();
            if (sortedMapK == null) {
                return null;
            }
            C c11 = this.f39615d;
            if (c11 != null) {
                sortedMapK = sortedMapK.tailMap(c11);
            }
            C c12 = this.f39616f;
            return c12 != null ? sortedMapK.headMap(c12) : sortedMapK;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(j(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11)));
            return new c(this.f39598a, this.f39615d, c11);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedSet<C> keySet() {
            return new Maps.k(this);
        }

        public boolean j(Object obj) {
            C c11;
            C c12;
            return obj != null && ((c11 = this.f39615d) == null || g(c11, obj) <= 0) && ((c12 = this.f39616f) == null || g(c12, obj) > 0);
        }

        public SortedMap<C, V> k() {
            SortedMap<C, V> sortedMap = this.f39617g;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f39598a))) {
                this.f39617g = (SortedMap) TreeBasedTable.this.backingMap.get(this.f39598a);
            }
            return this.f39617g;
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (a() != null) {
                return a().lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable.g, java.util.AbstractMap, java.util.Map
        public V put(C c11, V v11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(j(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11)));
            return (V) super.put(c11, v11);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c11, C c12) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(j(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11)) && j(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c12)));
            return new c(this.f39598a, c11, c12);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(j(com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11)));
            return new c(this.f39598a, c11, this.f39616f);
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
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> comparatorColumnComparator = columnComparator();
        return new b(Iterators.q(j5.n(this.backingMap.values(), new a()), comparatorColumnComparator), comparatorColumnComparator);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ void putAll(p7 p7Var) {
        super.putAll(p7Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public SortedMap<C, V> row(R r11) {
        return new c(this, r11);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardRowSortedTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardRowSortedTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.StandardTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }
}

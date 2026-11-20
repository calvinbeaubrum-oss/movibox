package com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class ArrayTable<R, C, V> extends i<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.common.collect.a<b1.a<R, C, V>> {
        public a(int i11) {
            super(i11);
        }

        @Override // com.google.common.collect.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b1.a<R, C, V> a(int i11) {
            return ArrayTable.this.getCell(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Tables.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f38252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f38253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f38254c;

        public b(int i11) {
            this.f38254c = i11;
            this.f38252a = i11 / ArrayTable.this.columnList.size();
            this.f38253b = i11 % ArrayTable.this.columnList.size();
        }

        @Override // com.google.common.collect.b1.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f38253b);
        }

        @Override // com.google.common.collect.b1.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f38252a);
        }

        @Override // com.google.common.collect.b1.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f38252a, this.f38253b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends com.google.common.collect.a<V> {
        public c(int i11) {
            super(i11);
        }

        @Override // com.google.common.collect.a
        public V a(int i11) {
            return (V) ArrayTable.this.getValue(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<K, V> extends Maps.k<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f38257a;

        /* JADX INFO: compiled from: source.java */
        public class a extends com.google.common.collect.b<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f38258a;

            public a(int i11) {
                this.f38258a = i11;
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.d(this.f38258a);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.f(this.f38258a);
            }

            @Override // com.google.common.collect.b, java.util.Map.Entry
            public V setValue(V v11) {
                return (V) d.this.g(this.f38258a, v11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends com.google.common.collect.a<Map.Entry<K, V>> {
            public b(int i11) {
                super(i11);
            }

            @Override // com.google.common.collect.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(int i11) {
                return d.this.c(i11);
            }
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f38257a = immutableMap;
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        @Override // com.google.common.collect.Maps.k
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> c(int i11) {
            com.google.common.base.m.n(i11, size());
            return new a(i11);
        }

        @Override // com.google.common.collect.Maps.k, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f38257a.containsKey(obj);
        }

        public K d(int i11) {
            return this.f38257a.keySet().asList().get(i11);
        }

        public abstract String e();

        public abstract V f(int i11);

        public abstract V g(int i11, V v11);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f38257a.get(obj);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f38257a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f38257a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k11, V v11) {
            Integer num = this.f38257a.get(k11);
            if (num != null) {
                return g(num.intValue(), v11);
            }
            throw new IllegalArgumentException(e() + " " + k11 + " not in " + this.f38257a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f38257a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends d<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f38261b;

        public e(int i11) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f38261b = i11;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i11) {
            return (V) ArrayTable.this.at(i11, this.f38261b);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V g(int i11, V v11) {
            return (V) ArrayTable.this.set(i11, this.f38261b, v11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class f extends d<C, Map<R, V>> {
        public f() {
            super(ArrayTable.this.columnKeyToIndex, null);
        }

        public /* synthetic */ f(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int i11) {
            return new e(i11);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c11, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<R, V> g(int i11, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends d<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f38264b;

        public g(int i11) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f38264b = i11;
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String e() {
            return "Column";
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V f(int i11) {
            return (V) ArrayTable.this.at(this.f38264b, i11);
        }

        @Override // com.google.common.collect.ArrayTable.d
        public V g(int i11, V v11) {
            return (V) ArrayTable.this.set(this.f38264b, i11, v11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class h extends d<R, Map<C, V>> {
        public h() {
            super(ArrayTable.this.rowKeyToIndex, null);
        }

        public /* synthetic */ h(ArrayTable arrayTable, a aVar) {
            this();
        }

        @Override // com.google.common.collect.ArrayTable.d
        public String e() {
            return "Row";
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int i11) {
            return new g(i11);
        }

        @Override // com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r11, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<C, V> g(int i11, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableList.size(), immutableList2.size()));
        this.array = vArr;
        for (int i11 = 0; i11 < this.rowList.size(); i11++) {
            V[] vArr2 = arrayTable.array[i11];
            System.arraycopy(vArr2, 0, vArr[i11], 0, vArr2.length);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ArrayTable(b1<R, C, ? extends V> b1Var) {
        this(b1Var.rowKeySet(), b1Var.columnKeySet());
        putAll(b1Var);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> immutableListCopyOf = ImmutableList.copyOf(iterable);
        this.rowList = immutableListCopyOf;
        ImmutableList<C> immutableListCopyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = immutableListCopyOf2;
        com.google.common.base.m.d(immutableListCopyOf.isEmpty() == immutableListCopyOf2.isEmpty());
        this.rowKeyToIndex = Maps.j(immutableListCopyOf);
        this.columnKeyToIndex = Maps.j(immutableListCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableListCopyOf.size(), immutableListCopyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(b1<R, C, ? extends V> b1Var) {
        return b1Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) b1Var) : new ArrayTable<>(b1Var);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public b1.a<R, C, V> getCell(int i11) {
        return new b(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i11) {
        return at(i11 / this.columnList.size(), i11 % this.columnList.size());
    }

    public V at(int i11, int i12) {
        com.google.common.base.m.n(i11, this.rowList.size());
        com.google.common.base.m.n(i12, this.columnList.size());
        return this.array[i11][i12];
    }

    @Override // com.google.common.collect.i
    public Iterator<b1.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public Set<b1.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c11) {
        com.google.common.base.m.p(c11);
        Integer num = this.columnKeyToIndex.get(c11);
        return num == null ? Collections.emptyMap() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.b1
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.common.collect.i
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.common.collect.i
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.common.collect.i
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V v11 : vArr) {
                if (com.google.common.base.j.a(obj, v11)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public V erase(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // com.google.common.collect.i
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.i
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.common.collect.i
    public V put(R r11, C c11, V v11) {
        com.google.common.base.m.p(r11);
        com.google.common.base.m.p(c11);
        Integer num = this.rowKeyToIndex.get(r11);
        com.google.common.base.m.l(num != null, "Row %s not in %s", r11, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c11);
        com.google.common.base.m.l(num2 != null, "Column %s not in %s", c11, this.columnList);
        return set(num.intValue(), num2.intValue(), v11);
    }

    @Override // com.google.common.collect.i
    public void putAll(b1<? extends R, ? extends C, ? extends V> b1Var) {
        super.putAll(b1Var);
    }

    @Override // com.google.common.collect.i
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.b1
    public Map<C, V> row(R r11) {
        com.google.common.base.m.p(r11);
        Integer num = this.rowKeyToIndex.get(r11);
        return num == null ? Collections.emptyMap() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.common.collect.i, com.google.common.collect.b1
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.common.collect.b1
    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.h hVar = this.rowMap;
        if (hVar != null) {
            return hVar;
        }
        ArrayTable<R, C, V>.h hVar2 = new h(this, null);
        this.rowMap = hVar2;
        return hVar2;
    }

    public V set(int i11, int i12, V v11) {
        com.google.common.base.m.n(i11, this.rowList.size());
        com.google.common.base.m.n(i12, this.columnList.size());
        V[] vArr = this.array[i11];
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    @Override // com.google.common.collect.b1
    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i11 = 0; i11 < this.rowList.size(); i11++) {
            V[] vArr2 = this.array[i11];
            System.arraycopy(vArr2, 0, vArr[i11], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // com.google.common.collect.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.i
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.i
    public Iterator<V> valuesIterator() {
        return new c(size());
    }
}

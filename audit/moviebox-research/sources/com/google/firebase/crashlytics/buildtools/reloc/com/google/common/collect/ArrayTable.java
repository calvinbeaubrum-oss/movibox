package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class ArrayTable<R, C, V> extends z<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ArrayTable<R, C, V>.f columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient ArrayTable<R, C, V>.h rowMap;

    /* JADX INFO: compiled from: source.java */
    public class a extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c<p7.a<R, C, V>> {
        public a(int i11) {
            super(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p7.a<R, C, V> a(int i11) {
            return ArrayTable.this.getCell(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b extends Tables.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f39265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f39267c;

        public b(int i11) {
            this.f39267c = i11;
            this.f39265a = i11 / ArrayTable.this.columnList.size();
            this.f39266b = i11 % ArrayTable.this.columnList.size();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public C getColumnKey() {
            return (C) ArrayTable.this.columnList.get(this.f39266b);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public R getRowKey() {
            return (R) ArrayTable.this.rowList.get(this.f39265a);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7.a
        public V getValue() {
            return (V) ArrayTable.this.at(this.f39265a, this.f39266b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class c extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c<V> {
        public c(int i11) {
            super(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
        public V a(int i11) {
            return (V) ArrayTable.this.getValue(i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class d<K, V> extends Maps.h<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<K, Integer> f39270a;

        /* JADX INFO: compiled from: source.java */
        public class a extends q<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f39271a;

            public a(int i11) {
                this.f39271a = i11;
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.c(this.f39271a);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public V getValue() {
                return (V) d.this.e(this.f39271a);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
            public V setValue(V v11) {
                return (V) d.this.f(this.f39271a, v11);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public class b extends com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c<Map.Entry<K, V>> {
            public b(int i11) {
                super(i11);
            }

            @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(int i11) {
                return d.this.a(i11);
            }
        }

        public d(ImmutableMap<K, Integer> immutableMap) {
            this.f39270a = immutableMap;
        }

        public /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this(immutableMap);
        }

        public Map.Entry<K, V> a(int i11) {
            com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, size());
            return new a(i11);
        }

        public K c(int i11) {
            return this.f39270a.keySet().asList().get(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f39270a.containsKey(obj);
        }

        public abstract String d();

        public abstract V e(int i11);

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new b(size());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h
        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return x1.c(size(), 16, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.c0
                @Override // java.util.function.IntFunction
                public final Object apply(int i11) {
                    return this.f39679a.a(i11);
                }
            });
        }

        public abstract V f(int i11, V v11);

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            Integer num = this.f39270a.get(obj);
            if (num == null) {
                return null;
            }
            return e(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f39270a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f39270a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k11, V v11) {
            Integer num = this.f39270a.get(k11);
            if (num != null) {
                return f(num.intValue(), v11);
            }
            throw new IllegalArgumentException(d() + " " + k11 + " not in " + this.f39270a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.Maps.h, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f39270a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class e extends d<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39274b;

        public e(int i11) {
            super(ArrayTable.this.rowKeyToIndex, null);
            this.f39274b = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public V e(int i11) {
            return (V) ArrayTable.this.at(i11, this.f39274b);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public V f(int i11, V v11) {
            return (V) ArrayTable.this.set(i11, this.f39274b, v11);
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

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<R, V> e(int i11) {
            return new e(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C c11, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int i11, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class g extends d<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f39277b;

        public g(int i11) {
            super(ArrayTable.this.columnKeyToIndex, null);
            this.f39277b = i11;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public String d() {
            return "Column";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public V e(int i11) {
            return (V) ArrayTable.this.at(this.f39277b, i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public V f(int i11, V v11) {
            return (V) ArrayTable.this.set(this.f39277b, i11, v11);
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

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        public String d() {
            return "Row";
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Map<C, V> e(int i11) {
            return new g(i11);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R r11, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ArrayTable.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int i11, Map<C, V> map) {
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
    private ArrayTable(p7<R, C, V> p7Var) {
        this(p7Var.rowKeySet(), p7Var.columnKeySet());
        putAll(p7Var);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> immutableListCopyOf = ImmutableList.copyOf(iterable);
        this.rowList = immutableListCopyOf;
        ImmutableList<C> immutableListCopyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = immutableListCopyOf2;
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.d(immutableListCopyOf.isEmpty() == immutableListCopyOf2.isEmpty());
        this.rowKeyToIndex = Maps.h(immutableListCopyOf);
        this.columnKeyToIndex = Maps.h(immutableListCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableListCopyOf.size(), immutableListCopyOf2.size()));
        eraseAll();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(p7<R, C, V> p7Var) {
        return p7Var instanceof ArrayTable ? new ArrayTable<>((ArrayTable) p7Var) : new ArrayTable<>(p7Var);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p7.a<R, C, V> getCell(int i11) {
        return new b(i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V getValue(int i11) {
        return at(i11 / this.columnList.size(), i11 % this.columnList.size());
    }

    public V at(int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, this.rowList.size());
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i12, this.columnList.size());
        return this.array[i11][i12];
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Iterator<p7.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Set<p7.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Spliterator<p7.a<R, C, V>> cellSpliterator() {
        return x1.c(size(), 273, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.b0
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                return this.f39670a.getCell(i11);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Map<R, V> column(C c11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        Integer num = this.columnKeyToIndex.get(c11);
        return num == null ? ImmutableMap.of() : new e(num.intValue());
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.f fVar = this.columnMap;
        if (fVar != null) {
            return fVar;
        }
        ArrayTable<R, C, V>.f fVar2 = new f(this, null);
        this.columnMap = fVar2;
        return fVar2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean contains(Object obj, Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsColumn(Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsRow(Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean containsValue(Object obj) {
        for (V[] vArr : this.array) {
            for (V v11 : vArr) {
                if (com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(obj, v11)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public V put(R r11, C c11, V v11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        Integer num = this.rowKeyToIndex.get(r11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(num != null, "Row %s not in %s", r11, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c11);
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.k(num2 != null, "Column %s not in %s", c11, this.columnList);
        return set(num.intValue(), num2.intValue(), v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public void putAll(p7<? extends R, ? extends C, ? extends V> p7Var) {
        super.putAll(p7Var);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    @Deprecated
    public V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public Map<C, V> row(R r11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
        Integer num = this.rowKeyToIndex.get(r11);
        return num == null ? ImmutableMap.of() : new g(num.intValue());
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
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
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i11, this.rowList.size());
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.l(i12, this.columnList.size());
        V[] vArr = this.array[i11];
        V v12 = vArr[i12];
        vArr[i12] = v11;
        return v12;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
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

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public Spliterator<V> valuesSpliterator() {
        return x1.c(size(), 16, new IntFunction() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.a0
            @Override // java.util.function.IntFunction
            public final Object apply(int i11) {
                return this.f39666a.getValue(i11);
            }
        });
    }
}

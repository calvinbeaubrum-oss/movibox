package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final int[] rowCounts;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;
    private final V[][] values;

    /* JADX INFO: compiled from: source.java */
    public final class Column extends ImmutableArrayMap<R, V> {
        private final int columnIndex;

        public Column(int i11) {
            super(DenseImmutableTable.this.columnCounts[i11]);
            this.columnIndex = i11;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i11) {
            return (V) DenseImmutableTable.this.values[i11][this.columnIndex];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        public ColumnMap() {
            super(DenseImmutableTable.this.columnCounts.length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, V> getValue(int i11) {
            return new Column(i11);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        private final int size;

        /* JADX INFO: compiled from: source.java */
        public class a extends AbstractIterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f38312c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f38313d;

            public a() {
                this.f38313d = ImmutableArrayMap.this.keyToIndex().size();
            }

            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a() {
                int i11 = this.f38312c;
                while (true) {
                    this.f38312c = i11 + 1;
                    int i12 = this.f38312c;
                    if (i12 >= this.f38313d) {
                        return b();
                    }
                    Object value = ImmutableArrayMap.this.getValue(i12);
                    if (value != null) {
                        return Maps.i(ImmutableArrayMap.this.getKey(this.f38312c), value);
                    }
                    i11 = this.f38312c;
                }
            }
        }

        public ImmutableArrayMap(int i11) {
            this.size = i11;
        }

        public final boolean a() {
            return this.size == keyToIndex().size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> createKeySet() {
            return a() ? keyToIndex().keySet() : super.createKeySet();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public g1<Map.Entry<K, V>> entryIterator() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public V get(Object obj) {
            Integer num = keyToIndex().get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public K getKey(int i11) {
            return keyToIndex().keySet().asList().get(i11);
        }

        public abstract V getValue(int i11);

        public abstract ImmutableMap<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class Row extends ImmutableArrayMap<C, V> {
        private final int rowIndex;

        public Row(int i11) {
            super(DenseImmutableTable.this.rowCounts[i11]);
            this.rowIndex = i11;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public V getValue(int i11) {
            return (V) DenseImmutableTable.this.values[this.rowIndex][i11];
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, Integer> keyToIndex() {
            return DenseImmutableTable.this.columnKeyToIndex;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        public RowMap() {
            super(DenseImmutableTable.this.rowCounts.length);
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<C, V> getValue(int i11) {
            return new Row(i11);
        }

        @Override // com.google.common.collect.ImmutableMap
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public ImmutableMap<R, Integer> keyToIndex() {
            return DenseImmutableTable.this.rowKeyToIndex;
        }
    }

    public DenseImmutableTable(ImmutableList<b1.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, immutableSet.size(), immutableSet2.size()));
        ImmutableMap<R, Integer> immutableMapJ = Maps.j(immutableSet);
        this.rowKeyToIndex = immutableMapJ;
        ImmutableMap<C, Integer> immutableMapJ2 = Maps.j(immutableSet2);
        this.columnKeyToIndex = immutableMapJ2;
        this.rowCounts = new int[immutableMapJ.size()];
        this.columnCounts = new int[immutableMapJ2.size()];
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            b1.a<R, C, V> aVar = immutableList.get(i11);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            Integer num = this.rowKeyToIndex.get(rowKey);
            Objects.requireNonNull(num);
            int iIntValue = num.intValue();
            Integer num2 = this.columnKeyToIndex.get(columnKey);
            Objects.requireNonNull(num2);
            int iIntValue2 = num2.intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[iIntValue][iIntValue2], aVar.getValue());
            this.values[iIntValue][iIntValue2] = aVar.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i11] = iIntValue;
            iArr2[i11] = iIntValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new RowMap();
        this.columnMap = new ColumnMap();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public V get(Object obj, Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public b1.a<R, C, V> getCell(int i11) {
        int i12 = this.cellRowIndices[i11];
        int i13 = this.cellColumnIndices[i11];
        R r11 = rowKeySet().asList().get(i12);
        C c11 = columnKeySet().asList().get(i13);
        V v11 = this.values[i12][i13];
        Objects.requireNonNull(v11);
        return ImmutableTable.cellOf(r11, c11, v11);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public V getValue(int i11) {
        V v11 = this.values[this.cellRowIndices[i11]][this.cellColumnIndices[i11]];
        Objects.requireNonNull(v11);
        return v11;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }

    @Override // com.google.common.collect.RegularImmutableTable, com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public int size() {
        return this.cellRowIndices.length;
    }
}

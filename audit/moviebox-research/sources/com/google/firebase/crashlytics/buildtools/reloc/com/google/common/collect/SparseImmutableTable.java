package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = new SparseImmutableTable(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    public SparseImmutableTable(ImmutableList<p7.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap immutableMapH = Maps.h(immutableSet);
        LinkedHashMap linkedHashMapO = Maps.o();
        t7<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            linkedHashMapO.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapO2 = Maps.o();
        t7<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            linkedHashMapO2.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i11 = 0; i11 < immutableList.size(); i11++) {
            p7.a<R, C, V> aVar = immutableList.get(i11);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            V value = aVar.getValue();
            iArr[i11] = ((Integer) immutableMapH.get(rowKey)).intValue();
            Map map = (Map) linkedHashMapO.get(rowKey);
            iArr2[i11] = map.size();
            Object objPut = map.put(columnKey, value);
            if (objPut != null) {
                throw new IllegalArgumentException("Duplicate value for row=" + rowKey + ", column=" + columnKey + ": " + value + ", " + objPut);
            }
            ((Map) linkedHashMapO2.get(columnKey)).put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(linkedHashMapO.size());
        for (Map.Entry entry : linkedHashMapO.entrySet()) {
            bVar.d(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(linkedHashMapO2.size());
        for (Map.Entry entry2 : linkedHashMapO2.entrySet()) {
            bVar2.d(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        ImmutableMap immutableMapH = Maps.h(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        t7<p7.a<R, C, V>> it = cellSet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = ((Integer) immutableMapH.get(it.next().getColumnKey())).intValue();
            i11++;
        }
        return ImmutableTable.SerializedForm.create(this, this.cellRowIndices, iArr);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.RegularImmutableTable
    public p7.a<R, C, V> getCell(int i11) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i11]);
        ImmutableMap<C, V> value = entry.getValue();
        Map.Entry<C, V> entry2 = value.entrySet().asList().get(this.cellColumnInRowIndices[i11]);
        return ImmutableTable.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.RegularImmutableTable
    public V getValue(int i11) {
        ImmutableMap<C, V> immutableMap = this.rowMap.values().asList().get(this.cellRowIndices[i11]);
        return immutableMap.values().asList().get(this.cellColumnInRowIndices[i11]);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.RegularImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public int size() {
        return this.cellRowIndices.length;
    }
}

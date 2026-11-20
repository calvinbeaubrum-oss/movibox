package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    public SingletonImmutableTable(b1.a<R, C, V> aVar) {
        this(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
    }

    public SingletonImmutableTable(R r11, C c11, V v11) {
        this.singleRowKey = (R) com.google.common.base.m.p(r11);
        this.singleColumnKey = (C) com.google.common.base.m.p(c11);
        this.singleValue = (V) com.google.common.base.m.p(v11);
    }

    @Override // com.google.common.collect.ImmutableTable
    /* JADX INFO: renamed from: column, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<R, V> mo150column(C c11) {
        com.google.common.base.m.p(c11);
        return containsColumn(c11) ? ImmutableMap.of(this.singleRowKey, (Object) this.singleValue) : ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public ImmutableSet<b1.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.i
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.b1
    public int size() {
        return 1;
    }
}

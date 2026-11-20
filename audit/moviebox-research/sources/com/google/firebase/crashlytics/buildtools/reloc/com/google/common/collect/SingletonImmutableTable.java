package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    public SingletonImmutableTable(p7.a<R, C, V> aVar) {
        this(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
    }

    public SingletonImmutableTable(R r11, C c11, V v11) {
        this.singleRowKey = (R) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(r11);
        this.singleColumnKey = (C) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        this.singleValue = (V) com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(v11);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable
    /* JADX INFO: renamed from: column, reason: merged with bridge method [inline-methods] */
    public ImmutableMap<R, V> mo154column(C c11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(c11);
        return containsColumn(c11) ? ImmutableMap.of(this.singleRowKey, (Object) this.singleValue) : ImmutableMap.of();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public ImmutableSet<p7.a<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable
    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.z
    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, (Object) this.singleValue));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableTable, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.p7
    public int size() {
        return 1;
    }
}

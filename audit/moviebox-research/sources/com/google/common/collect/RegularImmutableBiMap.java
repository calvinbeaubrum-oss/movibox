package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Object f38555a;
    final transient Object[] alternatingKeysAndValues;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient int f38556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient int f38557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient RegularImmutableBiMap<V, K> f38558d;

    /* JADX WARN: Multi-variable type inference failed */
    private RegularImmutableBiMap() {
        this.f38555a = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f38556b = 0;
        this.f38557c = 0;
        this.f38558d = this;
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i11, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.f38555a = obj;
        this.alternatingKeysAndValues = objArr;
        this.f38556b = 1;
        this.f38557c = i11;
        this.f38558d = regularImmutableBiMap;
    }

    public RegularImmutableBiMap(Object[] objArr, int i11) {
        this.alternatingKeysAndValues = objArr;
        this.f38557c = i11;
        this.f38556b = 0;
        int iChooseTableSize = i11 >= 2 ? ImmutableSet.chooseTableSize(i11) : 0;
        this.f38555a = RegularImmutableMap.createHashTableOrThrow(objArr, i11, iChooseTableSize, 0);
        this.f38558d = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTableOrThrow(objArr, i11, iChooseTableSize, 1), objArr, i11, this);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f38556b, this.f38557c);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f38556b, this.f38557c));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        V v11 = (V) RegularImmutableMap.get(this.f38555a, this.alternatingKeysAndValues, this.f38557c, this.f38556b, obj);
        if (v11 == null) {
            return null;
        }
        return v11;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.k
    public ImmutableBiMap<V, K> inverse() {
        return this.f38558d;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f38557c;
    }
}

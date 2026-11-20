package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class JdkBackedImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableList<Map.Entry<K, V>> f39418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient JdkBackedImmutableBiMap<V, K> f39419b;
    private final Map<V, K> backwardDelegate;
    private final Map<K, V> forwardDelegate;

    /* JADX INFO: compiled from: source.java */
    public final class InverseEntries extends ImmutableList<Map.Entry<V, K>> {
        public InverseEntries() {
        }

        @Override // java.util.List
        public Map.Entry<V, K> get(int i11) {
            Map.Entry entry = (Map.Entry) JdkBackedImmutableBiMap.this.f39418a.get(i11);
            return Maps.g(entry.getValue(), entry.getKey());
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return JdkBackedImmutableBiMap.this.f39418a.size();
        }
    }

    public JdkBackedImmutableBiMap(ImmutableList<Map.Entry<K, V>> immutableList, Map<K, V> map, Map<V, K> map2) {
        this.f39418a = immutableList;
        this.forwardDelegate = map;
        this.backwardDelegate = map2;
    }

    public static <K, V> ImmutableBiMap<K, V> create(int i11, Map.Entry<K, V>[] entryArr) {
        HashMap mapN = Maps.n(i11);
        HashMap mapN2 = Maps.n(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            ImmutableMapEntry immutableMapEntryMakeImmutable = RegularImmutableMap.makeImmutable(entryArr[i12]);
            entryArr[i12] = immutableMapEntryMakeImmutable;
            Object objPutIfAbsent = mapN.putIfAbsent(immutableMapEntryMakeImmutable.getKey(), immutableMapEntryMakeImmutable.getValue());
            if (objPutIfAbsent != null) {
                throw ImmutableMap.conflictException("key", immutableMapEntryMakeImmutable.getKey() + "=" + objPutIfAbsent, entryArr[i12]);
            }
            Object objPutIfAbsent2 = mapN2.putIfAbsent(immutableMapEntryMakeImmutable.getValue(), immutableMapEntryMakeImmutable.getKey());
            if (objPutIfAbsent2 != null) {
                throw ImmutableMap.conflictException(AppMeasurementSdk.ConditionalUserProperty.VALUE, objPutIfAbsent2 + "=" + immutableMapEntryMakeImmutable.getValue(), entryArr[i12]);
            }
        }
        return new JdkBackedImmutableBiMap(ImmutableList.asImmutableList(entryArr, i11), mapN, mapN2);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.f39418a);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.forwardDelegate.get(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableBiMap, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.d0
    public ImmutableBiMap<V, K> inverse() {
        JdkBackedImmutableBiMap<V, K> jdkBackedImmutableBiMap = this.f39419b;
        if (jdkBackedImmutableBiMap != null) {
            return jdkBackedImmutableBiMap;
        }
        JdkBackedImmutableBiMap<V, K> jdkBackedImmutableBiMap2 = new JdkBackedImmutableBiMap<>(new InverseEntries(), this.backwardDelegate, this.forwardDelegate);
        this.f39419b = jdkBackedImmutableBiMap2;
        jdkBackedImmutableBiMap2.f39419b = this;
        return jdkBackedImmutableBiMap2;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f39418a.size();
    }
}

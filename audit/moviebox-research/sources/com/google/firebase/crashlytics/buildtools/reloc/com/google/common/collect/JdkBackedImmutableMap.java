package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class JdkBackedImmutableMap<K, V> extends ImmutableMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Map<K, V> f39420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient ImmutableList<Map.Entry<K, V>> f39421b;

    public JdkBackedImmutableMap(Map<K, V> map, ImmutableList<Map.Entry<K, V>> immutableList) {
        this.f39420a = map;
        this.f39421b = immutableList;
    }

    public static /* synthetic */ void c(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableMap<K, V> create(int i11, Map.Entry<K, V>[] entryArr) {
        HashMap mapN = Maps.n(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            ImmutableMapEntry immutableMapEntryMakeImmutable = RegularImmutableMap.makeImmutable(entryArr[i12]);
            entryArr[i12] = immutableMapEntryMakeImmutable;
            Object objPutIfAbsent = mapN.putIfAbsent(immutableMapEntryMakeImmutable.getKey(), entryArr[i12].getValue());
            if (objPutIfAbsent != null) {
                throw ImmutableMap.conflictException("key", entryArr[i12], entryArr[i12].getKey() + "=" + objPutIfAbsent);
            }
        }
        return new JdkBackedImmutableMap(mapN, ImmutableList.asImmutableList(entryArr, i11));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.f39421b);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new ImmutableMapKeySet(this);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public ImmutableCollection<V> createValues() {
        return new ImmutableMapValues(this);
    }

    @Override // java.util.Map
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(biConsumer);
        this.f39421b.forEach(new Consumer() { // from class: com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.o5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                JdkBackedImmutableMap.c(biConsumer, (Map.Entry) obj);
            }
        });
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.f39420a.get(obj);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f39421b.size();
    }
}

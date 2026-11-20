package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class o2<K, V> extends q2<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q2, com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.t2
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k11, V v11) {
        return delegate().putIfAbsent(k11, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k11, V v11) {
        return delegate().replace(k11, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k11, V v11, V v12) {
        return delegate().replace(k11, v11, v12);
    }
}

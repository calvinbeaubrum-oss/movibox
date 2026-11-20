package com.google.common.collect;

import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class s<K, V> extends u<K, V> implements ConcurrentMap<K, V> {
    @Override // com.google.common.collect.u, com.google.common.collect.x
    /* JADX INFO: renamed from: delegate */
    public abstract ConcurrentMap<K, V> u();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V putIfAbsent(K k11, V v11) {
        return u().putIfAbsent(k11, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        return u().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public V replace(K k11, V v11) {
        return u().replace(k11, v11);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(K k11, V v11, V v12) {
        return u().replace(k11, v11, v12);
    }
}

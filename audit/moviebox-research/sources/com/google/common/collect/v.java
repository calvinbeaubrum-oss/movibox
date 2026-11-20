package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class v<K, V> extends x implements Map.Entry<K, V> {
    public boolean equals(Object obj) {
        return u().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return u().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return u().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return u().hashCode();
    }

    public V setValue(V v11) {
        return u().setValue(v11);
    }

    public boolean standardEquals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.common.base.j.a(getKey(), entry.getKey()) && com.google.common.base.j.a(getValue(), entry.getValue());
    }

    public abstract Map.Entry<K, V> u();
}

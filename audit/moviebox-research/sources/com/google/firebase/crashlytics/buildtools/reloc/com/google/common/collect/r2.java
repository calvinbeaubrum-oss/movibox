package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class r2<K, V> extends t2 implements Map.Entry<K, V> {
    public boolean equals(Object obj) {
        return f().equals(obj);
    }

    public abstract Map.Entry<K, V> f();

    @Override // java.util.Map.Entry
    public K getKey() {
        return f().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return f().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return f().hashCode();
    }

    public V setValue(V v11) {
        return f().setValue(v11);
    }

    public boolean standardEquals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getKey(), entry.getKey()) && com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.g.a(getValue(), entry.getValue());
    }
}

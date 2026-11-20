package com.bumptech.glide.util;

import androidx.collection.a;
import androidx.collection.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends a<K, V> {
    private int hashCode;

    @Override // androidx.collection.v0, java.util.Map
    public void clear() {
        this.hashCode = 0;
        super.clear();
    }

    @Override // androidx.collection.v0, java.util.Map
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = super.hashCode();
        }
        return this.hashCode;
    }

    @Override // androidx.collection.v0, java.util.Map
    public V put(K k11, V v11) {
        this.hashCode = 0;
        return (V) super.put(k11, v11);
    }

    @Override // androidx.collection.v0
    public void putAll(v0<? extends K, ? extends V> v0Var) {
        this.hashCode = 0;
        super.putAll(v0Var);
    }

    @Override // androidx.collection.v0
    public V removeAt(int i11) {
        this.hashCode = 0;
        return (V) super.removeAt(i11);
    }

    @Override // androidx.collection.v0
    public V setValueAt(int i11, V v11) {
        this.hashCode = 0;
        return (V) super.setValueAt(i11, v11);
    }
}

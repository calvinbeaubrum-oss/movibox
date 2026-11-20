package com.bumptech.glide.repackaged.com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    final K key;
    final V value;

    public ImmutableEntry(K k11, V v11) {
        this.key = k11;
        this.value = v11;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final V setValue(V v11) {
        throw new UnsupportedOperationException();
    }
}

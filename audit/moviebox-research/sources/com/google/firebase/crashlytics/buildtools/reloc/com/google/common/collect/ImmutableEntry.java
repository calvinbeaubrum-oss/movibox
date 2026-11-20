package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
class ImmutableEntry<K, V> extends q<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    public ImmutableEntry(K k11, V v11) {
        this.key = k11;
        this.value = v11;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect.q, java.util.Map.Entry
    public final V setValue(V v11) {
        throw new UnsupportedOperationException();
    }
}

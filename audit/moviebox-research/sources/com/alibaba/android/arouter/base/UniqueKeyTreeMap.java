package com.alibaba.android.arouter.base;

import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class UniqueKeyTreeMap<K, V> extends TreeMap<K, V> {
    private String tipText;

    public UniqueKeyTreeMap(String str) {
        this.tipText = str;
    }

    @Override // java.util.TreeMap, java.util.AbstractMap, java.util.Map
    public V put(K k11, V v11) {
        if (containsKey(k11)) {
            throw new RuntimeException(String.format(this.tipText, k11));
        }
        return (V) super.put(k11, v11);
    }
}

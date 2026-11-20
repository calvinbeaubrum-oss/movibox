package io.reactivex.rxjava3.internal.util;

import java.util.HashMap;
import java.util.Map;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum HashMapSupplier implements k<Map<Object, Object>> {
    INSTANCE;

    public static <K, V> k<Map<K, V>> asSupplier() {
        return INSTANCE;
    }

    @Override // k10.k
    public Map<Object, Object> get() {
        return new HashMap();
    }
}

package com.google.common.collect;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface k<K, V> extends Map<K, V> {
    k<V, K> inverse();
}

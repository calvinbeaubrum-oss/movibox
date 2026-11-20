package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a0<K, V> extends u<K, V> implements SortedMap<K, V> {
    public static int u(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator == null ? ((Comparable) obj).compareTo(obj2) : comparator.compare(obj, obj2);
    }
}

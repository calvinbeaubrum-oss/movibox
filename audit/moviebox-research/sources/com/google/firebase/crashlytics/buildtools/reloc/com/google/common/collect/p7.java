package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface p7<R, C, V> {

    /* JADX INFO: compiled from: source.java */
    public interface a<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    V get(Object obj, Object obj2);

    V put(R r11, C c11, V v11);

    Map<C, V> row(R r11);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();
}

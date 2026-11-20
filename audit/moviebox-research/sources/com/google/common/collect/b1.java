package com.google.common.collect;

import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b1<R, C, V> {

    /* JADX INFO: compiled from: source.java */
    public interface a<R, C, V> {
        C getColumnKey();

        R getRowKey();

        V getValue();
    }

    Set<a<R, C, V>> cellSet();

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    Map<C, V> row(R r11);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();
}

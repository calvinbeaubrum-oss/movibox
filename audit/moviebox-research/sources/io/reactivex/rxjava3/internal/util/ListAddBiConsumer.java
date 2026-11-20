package io.reactivex.rxjava3.internal.util;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum ListAddBiConsumer implements k10.c<List, Object, List> {
    INSTANCE;

    public static <T> k10.c<List<T>, T, List<T>> instance() {
        return INSTANCE;
    }

    @Override // k10.c
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}

package io.reactivex.rxjava3.internal.util;

import java.util.ArrayList;
import java.util.List;
import k10.k;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum ArrayListSupplier implements k<List<Object>>, k10.h<Object, List<Object>> {
    INSTANCE;

    public static <T, O> k10.h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static <T> k<List<T>> asSupplier() {
        return INSTANCE;
    }

    @Override // k10.h
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // k10.k
    public List<Object> get() {
        return new ArrayList();
    }
}

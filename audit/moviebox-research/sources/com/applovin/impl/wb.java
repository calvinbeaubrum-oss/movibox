package com.applovin.impl;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wb {
    public static Object a(Iterable iterable, Object obj) {
        return xb.a(iterable.iterator(), obj);
    }

    private static Object a(List list) {
        return list.get(list.size() - 1);
    }

    private static Collection a(Iterable iterable) {
        return iterable instanceof Collection ? (Collection) iterable : ic.a(iterable.iterator());
    }

    public static Object b(Iterable iterable) {
        if (!(iterable instanceof List)) {
            return xb.b(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return a(list);
    }

    public static Object[] c(Iterable iterable) {
        return a(iterable).toArray();
    }

    public static String d(Iterable iterable) {
        return xb.d(iterable.iterator());
    }
}

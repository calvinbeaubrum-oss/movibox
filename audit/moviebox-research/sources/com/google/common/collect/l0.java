package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class l0 {
    public static Object a(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    public static Object[] c(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            a(objArr[i12], i12);
        }
        return objArr;
    }

    public static Object[] d(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            objArr[i11] = it.next();
            i11++;
        }
        return objArr;
    }

    public static <T> T[] e(T[] tArr, int i11) {
        return (T[]) p0.c(tArr, i11);
    }

    public static Object[] f(Collection<?> collection) {
        return d(collection, new Object[collection.size()]);
    }

    public static <T> T[] g(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) e(tArr, size);
        }
        d(collection, tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    public static <T> T[] h(Object[] objArr, int i11, int i12, T[] tArr) {
        com.google.common.base.m.u(i11, i11 + i12, objArr.length);
        if (tArr.length < i12) {
            tArr = (T[]) e(tArr, i12);
        } else if (tArr.length > i12) {
            tArr[i12] = null;
        }
        System.arraycopy(objArr, i11, tArr, 0, i12);
        return tArr;
    }
}

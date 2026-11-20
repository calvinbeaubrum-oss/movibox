package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gg {
    public static Object a(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i11);
    }

    public static Object[] a(Object... objArr) {
        return a(objArr, objArr.length);
    }

    public static Object[] a(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            a(objArr[i12], i12);
        }
        return objArr;
    }

    public static Object[] b(Object[] objArr, int i11) {
        return mh.a(objArr, i11);
    }
}

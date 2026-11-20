package com.applovin.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class mh {
    public static Map a() {
        return w3.a();
    }

    public static Object[] a(Object[] objArr, int i11) {
        return (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i11);
    }

    public static Object[] a(Object[] objArr, int i11, int i12, Object[] objArr2) {
        return Arrays.copyOfRange(objArr, i11, i12, objArr2.getClass());
    }
}

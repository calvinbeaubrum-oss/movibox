package com.google.common.collect;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class p0 {
    public static <T> T[] a(Object[] objArr, int i11, int i12, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i11, i12, tArr.getClass());
    }

    public static <E extends Enum<E>> Class<E> b(E e11) {
        return e11.getDeclaringClass();
    }

    public static <T> T[] c(T[] tArr, int i11) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i11);
    }

    public static <K, V> Map<K, V> d(int i11) {
        return CompactHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> e(int i11) {
        return CompactHashSet.createWithExpectedSize(i11);
    }

    public static <K, V> Map<K, V> f(int i11) {
        return CompactLinkedHashMap.createWithExpectedSize(i11);
    }

    public static <E> Set<E> g(int i11) {
        return CompactLinkedHashSet.createWithExpectedSize(i11);
    }

    public static <E> Set<E> h() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> i() {
        return CompactHashMap.create();
    }

    public static MapMaker j(MapMaker mapMaker) {
        return mapMaker.l();
    }
}

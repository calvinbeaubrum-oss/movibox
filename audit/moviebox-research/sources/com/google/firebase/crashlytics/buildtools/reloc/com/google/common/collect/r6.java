package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class r6 {
    public static <T> T[] a(T[] tArr, int i11) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11));
    }

    public static <K, V> Map<K, V> b(int i11) {
        return Maps.n(i11);
    }

    public static <E> Set<E> c(int i11) {
        return Sets.e(i11);
    }

    public static <K, V> Map<K, V> d(int i11) {
        return Maps.p(i11);
    }

    public static <E> Set<E> e(int i11) {
        return Sets.g(i11);
    }

    public static <E> Set<E> f() {
        return Sets.f();
    }

    public static <K, V> Map<K, V> g() {
        return Maps.o();
    }

    public static MapMaker h(MapMaker mapMaker) {
        return mapMaker.l();
    }
}

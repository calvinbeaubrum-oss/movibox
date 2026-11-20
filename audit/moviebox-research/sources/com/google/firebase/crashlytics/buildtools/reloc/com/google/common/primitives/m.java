package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.primitives;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f39880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f39881b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        a(map, map2, Boolean.TYPE, Boolean.class);
        a(map, map2, Byte.TYPE, Byte.class);
        a(map, map2, Character.TYPE, Character.class);
        a(map, map2, Double.TYPE, Double.class);
        a(map, map2, Float.TYPE, Float.class);
        a(map, map2, Integer.TYPE, Integer.class);
        a(map, map2, Long.TYPE, Long.class);
        a(map, map2, Short.TYPE, Short.class);
        a(map, map2, Void.TYPE, Void.class);
        f39880a = Collections.unmodifiableMap(map);
        f39881b = Collections.unmodifiableMap(map2);
    }

    public static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static Set<Class<?>> b() {
        return f39881b.keySet();
    }

    public static <T> Class<T> c(Class<T> cls) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cls);
        Class<T> cls2 = (Class) f39881b.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static <T> Class<T> d(Class<T> cls) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.n(cls);
        Class<T> cls2 = (Class) f39880a.get(cls);
        return cls2 == null ? cls : cls2;
    }
}

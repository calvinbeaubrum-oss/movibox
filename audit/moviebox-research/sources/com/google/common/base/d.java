package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f38169a = new WeakHashMap();

    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> cls) {
        Map<String, WeakReference<? extends Enum<?>>> mapC;
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> map = f38169a;
        synchronized (map) {
            try {
                mapC = map.get(cls);
                if (mapC == null) {
                    mapC = c(cls);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mapC;
    }

    public static <T extends Enum<T>> Optional<T> b(Class<T> cls, String str) {
        m.p(cls);
        m.p(str);
        return l.b(cls, str);
    }

    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> c(Class<T> cls) {
        HashMap map = new HashMap();
        for (Enum r11 : EnumSet.allOf(cls)) {
            map.put(r11.name(), new WeakReference(r11));
        }
        f38169a.put(cls, map);
        return map;
    }
}

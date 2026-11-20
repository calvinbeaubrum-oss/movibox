package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f38181a = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f38182b = c();

    /* JADX INFO: compiled from: source.java */
    public static final class b implements k {
        public b() {
        }
    }

    public static String a(String str) {
        if (e(str)) {
            return null;
        }
        return str;
    }

    public static <T extends Enum<T>> Optional<T> b(Class<T> cls, String str) {
        WeakReference<? extends Enum<?>> weakReference = d.a(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static k c() {
        return new b();
    }

    public static String d(String str) {
        return str == null ? "" : str;
    }

    public static boolean e(String str) {
        return str == null || str.isEmpty();
    }
}

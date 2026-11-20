package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f41219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?> f41220b = a("libcore.io.Memory");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f41221c;

    static {
        f41221c = (f41219a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    public static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> b() {
        return f41220b;
    }

    public static boolean c() {
        return f41219a || !(f41220b == null || f41221c);
    }
}

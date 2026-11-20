package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f41383a = c();

    public static p a() {
        p pVarB = b("getEmptyRegistry");
        return pVarB != null ? pVarB : p.f41386d;
    }

    public static final p b(String str) {
        Class<?> cls = f41383a;
        if (cls == null) {
            return null;
        }
        try {
            return (p) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}

package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0 f41423a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0 f41424b = new t0();

    public static s0 a() {
        return f41423a;
    }

    public static s0 b() {
        return f41424b;
    }

    public static s0 c() {
        try {
            return (s0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

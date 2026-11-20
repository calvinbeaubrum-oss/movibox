package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f41346a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i0 f41347b = new j0();

    public static i0 a() {
        return f41346a;
    }

    public static i0 b() {
        return f41347b;
    }

    public static i0 c() {
        try {
            return (i0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

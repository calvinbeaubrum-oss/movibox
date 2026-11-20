package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q<?> f41415a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q<?> f41416b = c();

    public static q<?> a() {
        q<?> qVar = f41416b;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static q<?> b() {
        return f41415a;
    }

    public static q<?> c() {
        try {
            return (q) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}

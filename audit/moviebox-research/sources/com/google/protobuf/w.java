package com.google.protobuf;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class w implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f41428a = new w();

    public static w c() {
        return f41428a;
    }

    @Override // com.google.protobuf.m0
    public l0 a(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (l0) GeneratedMessageLite.E(cls.asSubclass(GeneratedMessageLite.class)).x();
        } catch (Exception e11) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e11);
        }
    }

    @Override // com.google.protobuf.m0
    public boolean b(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }
}

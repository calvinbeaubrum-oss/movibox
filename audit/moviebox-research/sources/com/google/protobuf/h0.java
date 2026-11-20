package com.google.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V> f41281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K f41282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V f41283c;

    /* JADX INFO: compiled from: source.java */
    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WireFormat.FieldType f41284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f41285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WireFormat.FieldType f41286c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final V f41287d;

        public a(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
            this.f41284a = fieldType;
            this.f41285b = k11;
            this.f41286c = fieldType2;
            this.f41287d = v11;
        }
    }

    public h0(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        this.f41281a = new a<>(fieldType, k11, fieldType2, v11);
        this.f41282b = k11;
        this.f41283c = v11;
    }

    public static <K, V> int b(a<K, V> aVar, K k11, V v11) {
        return u.d(aVar.f41284a, 1, k11) + u.d(aVar.f41286c, 2, v11);
    }

    public static <K, V> h0<K, V> d(WireFormat.FieldType fieldType, K k11, WireFormat.FieldType fieldType2, V v11) {
        return new h0<>(fieldType, k11, fieldType2, v11);
    }

    public static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k11, V v11) throws IOException {
        u.z(codedOutputStream, aVar.f41284a, 1, k11);
        u.z(codedOutputStream, aVar.f41286c, 2, v11);
    }

    public int a(int i11, K k11, V v11) {
        return CodedOutputStream.V(i11) + CodedOutputStream.D(b(this.f41281a, k11, v11));
    }

    public a<K, V> c() {
        return this.f41281a;
    }
}

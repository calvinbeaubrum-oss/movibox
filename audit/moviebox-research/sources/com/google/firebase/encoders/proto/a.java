package com.google.firebase.encoders.proto;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f40592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Protobuf.IntEncoding f40593b = Protobuf.IntEncoding.DEFAULT;

    /* JADX INFO: renamed from: com.google.firebase.encoders.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0444a implements Protobuf {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f40594b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Protobuf.IntEncoding f40595c;

        public C0444a(int i11, Protobuf.IntEncoding intEncoding) {
            this.f40594b = i11;
            this.f40595c = intEncoding;
        }

        @Override // java.lang.annotation.Annotation
        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // java.lang.annotation.Annotation
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Protobuf)) {
                return false;
            }
            Protobuf protobuf = (Protobuf) obj;
            return this.f40594b == protobuf.tag() && this.f40595c.equals(protobuf.intEncoding());
        }

        @Override // java.lang.annotation.Annotation
        public int hashCode() {
            return (14552422 ^ this.f40594b) + (this.f40595c.hashCode() ^ 2041407134);
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public Protobuf.IntEncoding intEncoding() {
            return this.f40595c;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.f40594b;
        }

        @Override // java.lang.annotation.Annotation
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f40594b + "intEncoding=" + this.f40595c + ')';
        }
    }

    public static a b() {
        return new a();
    }

    public Protobuf a() {
        return new C0444a(this.f40592a, this.f40593b);
    }

    public a c(int i11) {
        this.f40592a = i11;
        return this;
    }
}

package com.google.zxing.aztec.encoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f41495b = new d(null, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f41496a;

    public f(f fVar) {
        this.f41496a = fVar;
    }

    public final f a(int i11, int i12) {
        return new d(this, i11, i12);
    }

    public final f b(int i11, int i12) {
        return new b(this, i11, i12);
    }

    public abstract void c(hm.a aVar, byte[] bArr);

    public final f d() {
        return this.f41496a;
    }
}

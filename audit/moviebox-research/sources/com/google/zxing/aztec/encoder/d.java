package com.google.zxing.aztec.encoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final short f41487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final short f41488d;

    public d(f fVar, int i11, int i12) {
        super(fVar);
        this.f41487c = (short) i11;
        this.f41488d = (short) i12;
    }

    @Override // com.google.zxing.aztec.encoder.f
    public void c(hm.a aVar, byte[] bArr) {
        aVar.c(this.f41487c, this.f41488d);
    }

    public String toString() {
        short s11 = this.f41487c;
        short s12 = this.f41488d;
        return '<' + Integer.toBinaryString((s11 & ((1 << s12) - 1)) | (1 << s12) | (1 << this.f41488d)).substring(1) + '>';
    }
}

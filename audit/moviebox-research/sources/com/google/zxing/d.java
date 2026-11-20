package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f41501c;

    public d(e eVar) {
        super(eVar.d(), eVar.a());
        this.f41501c = eVar;
    }

    @Override // com.google.zxing.e
    public byte[] b() {
        byte[] bArrB = this.f41501c.b();
        int iD = d() * a();
        byte[] bArr = new byte[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            bArr[i11] = (byte) (255 - (bArrB[i11] & 255));
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] c(int i11, byte[] bArr) {
        byte[] bArrC = this.f41501c.c(i11, bArr);
        int iD = d();
        for (int i12 = 0; i12 < iD; i12++) {
            bArrC[i12] = (byte) (255 - (bArrC[i12] & 255));
        }
        return bArrC;
    }

    @Override // com.google.zxing.e
    public e e() {
        return this.f41501c;
    }

    @Override // com.google.zxing.e
    public boolean f() {
        return this.f41501c.f();
    }

    @Override // com.google.zxing.e
    public e g() {
        return new d(this.f41501c.g());
    }
}

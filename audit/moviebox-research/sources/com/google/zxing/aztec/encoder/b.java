package com.google.zxing.aztec.encoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41485d;

    public b(f fVar, int i11, int i12) {
        super(fVar);
        this.f41484c = i11;
        this.f41485d = i12;
    }

    @Override // com.google.zxing.aztec.encoder.f
    public void c(hm.a aVar, byte[] bArr) {
        int i11 = this.f41485d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0 || (i12 == 31 && i11 <= 62)) {
                aVar.c(31, 5);
                if (i11 > 62) {
                    aVar.c(i11 - 31, 16);
                } else if (i12 == 0) {
                    aVar.c(Math.min(i11, 31), 5);
                } else {
                    aVar.c(i11 - 31, 5);
                }
            }
            aVar.c(bArr[this.f41484c + i12], 8);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(this.f41484c);
        sb2.append("::");
        sb2.append((this.f41484c + this.f41485d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}

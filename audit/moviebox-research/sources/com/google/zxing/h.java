package com.google.zxing;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class h extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f41529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f41532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f41533g;

    public h(byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11) {
        super(i15, i16);
        if (i13 + i15 > i11 || i14 + i16 > i12) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f41529c = bArr;
        this.f41530d = i11;
        this.f41531e = i12;
        this.f41532f = i13;
        this.f41533g = i14;
        if (z11) {
            h(i15, i16);
        }
    }

    @Override // com.google.zxing.e
    public byte[] b() {
        int iD = d();
        int iA = a();
        int i11 = this.f41530d;
        if (iD == i11 && iA == this.f41531e) {
            return this.f41529c;
        }
        int i12 = iD * iA;
        byte[] bArr = new byte[i12];
        int i13 = (this.f41533g * i11) + this.f41532f;
        if (iD == i11) {
            System.arraycopy(this.f41529c, i13, bArr, 0, i12);
            return bArr;
        }
        for (int i14 = 0; i14 < iA; i14++) {
            System.arraycopy(this.f41529c, i13, bArr, i14 * iD, iD);
            i13 += this.f41530d;
        }
        return bArr;
    }

    @Override // com.google.zxing.e
    public byte[] c(int i11, byte[] bArr) {
        if (i11 < 0 || i11 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i11);
        }
        int iD = d();
        if (bArr == null || bArr.length < iD) {
            bArr = new byte[iD];
        }
        System.arraycopy(this.f41529c, ((i11 + this.f41533g) * this.f41530d) + this.f41532f, bArr, 0, iD);
        return bArr;
    }

    public final void h(int i11, int i12) {
        byte[] bArr = this.f41529c;
        int i13 = (this.f41533g * this.f41530d) + this.f41532f;
        int i14 = 0;
        while (i14 < i12) {
            int i15 = (i11 / 2) + i13;
            int i16 = (i13 + i11) - 1;
            int i17 = i13;
            while (i17 < i15) {
                byte b11 = bArr[i17];
                bArr[i17] = bArr[i16];
                bArr[i16] = b11;
                i17++;
                i16--;
            }
            i14++;
            i13 += this.f41530d;
        }
    }
}

package com.bytedance.sdk.component.pFF.sc.pFF;

import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class qr extends We {
    final transient int[] Qj;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    final transient byte[][] f26945qr;

    public qr(sc scVar, int i11) {
        super(null);
        Ol.sc(scVar.pFF, 0L, i11);
        ExN exN = scVar.f26946sc;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            int i15 = exN.zY;
            int i16 = exN.pFF;
            if (i15 == i16) {
                throw new AssertionError("s.limit == s.pos");
            }
            i13 += i15 - i16;
            i14++;
            exN = exN.TRI;
        }
        this.f26945qr = new byte[i14][];
        this.Qj = new int[i14 * 2];
        ExN exN2 = scVar.f26946sc;
        int i17 = 0;
        while (i12 < i11) {
            byte[][] bArr = this.f26945qr;
            bArr[i17] = exN2.f26941sc;
            int i18 = exN2.zY;
            int i19 = exN2.pFF;
            i12 += i18 - i19;
            if (i12 > i11) {
                i12 = i11;
            }
            int[] iArr = this.Qj;
            iArr[i17] = i12;
            iArr[bArr.length + i17] = i19;
            exN2.We = true;
            i17++;
            exN2 = exN2.TRI;
        }
    }

    private We ExN() {
        return new We(We());
    }

    private int pFF(int i11) {
        int iBinarySearch = Arrays.binarySearch(this.Qj, 0, this.f26945qr.length, i11 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public byte[] We() {
        int[] iArr = this.Qj;
        byte[][] bArr = this.f26945qr;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            int[] iArr2 = this.Qj;
            int i13 = iArr2[length + i11];
            int i14 = iArr2[i11];
            System.arraycopy(this.f26945qr[i11], i13, bArr2, i12, i14 - i12);
            i11++;
            i12 = i14;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof We) {
            We we2 = (We) obj;
            if (we2.zY() == zY() && sc(0, we2, 0, zY())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public int hashCode() {
        int i11 = this.ExN;
        if (i11 != 0) {
            return i11;
        }
        int length = this.f26945qr.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i12 < length) {
            byte[] bArr = this.f26945qr[i12];
            int[] iArr = this.Qj;
            int i15 = iArr[length + i12];
            int i16 = iArr[i12];
            int i17 = (i16 - i13) + i15;
            while (i15 < i17) {
                i14 = (i14 * 31) + bArr[i15];
                i15++;
            }
            i12++;
            i13 = i16;
        }
        this.ExN = i14;
        return i14;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public String pFF() {
        return ExN().pFF();
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public byte sc(int i11) {
        Ol.sc(this.Qj[this.f26945qr.length - 1], i11, 1L);
        int iPFF = pFF(i11);
        int i12 = iPFF == 0 ? 0 : this.Qj[iPFF - 1];
        int[] iArr = this.Qj;
        byte[][] bArr = this.f26945qr;
        return bArr[iPFF][(i11 - i12) + iArr[bArr.length + iPFF]];
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public We sc(int i11, int i12) {
        return ExN().sc(i11, i12);
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public String sc() {
        return ExN().sc();
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public boolean sc(int i11, We we2, int i12, int i13) {
        if (i11 < 0 || i11 > zY() - i13) {
            return false;
        }
        int iPFF = pFF(i11);
        while (i13 > 0) {
            int i14 = iPFF == 0 ? 0 : this.Qj[iPFF - 1];
            int iMin = Math.min(i13, ((this.Qj[iPFF] - i14) + i14) - i11);
            int[] iArr = this.Qj;
            byte[][] bArr = this.f26945qr;
            if (!we2.sc(i12, bArr[iPFF], (i11 - i14) + iArr[bArr.length + iPFF], iMin)) {
                return false;
            }
            i11 += iMin;
            i12 += iMin;
            i13 -= iMin;
            iPFF++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public boolean sc(int i11, byte[] bArr, int i12, int i13) {
        if (i11 < 0 || i11 > zY() - i13 || i12 < 0 || i12 > bArr.length - i13) {
            return false;
        }
        int iPFF = pFF(i11);
        while (i13 > 0) {
            int i14 = iPFF == 0 ? 0 : this.Qj[iPFF - 1];
            int iMin = Math.min(i13, ((this.Qj[iPFF] - i14) + i14) - i11);
            int[] iArr = this.Qj;
            byte[][] bArr2 = this.f26945qr;
            if (!Ol.sc(bArr2[iPFF], (i11 - i14) + iArr[bArr2.length + iPFF], bArr, i12, iMin)) {
                return false;
            }
            i11 += iMin;
            i12 += iMin;
            i13 -= iMin;
            iPFF++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public String toString() {
        return ExN().toString();
    }

    @Override // com.bytedance.sdk.component.pFF.sc.pFF.We
    public int zY() {
        return this.Qj[this.f26945qr.length - 1];
    }
}

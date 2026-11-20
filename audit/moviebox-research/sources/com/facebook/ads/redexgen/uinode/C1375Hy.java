package com.facebook.ads.redexgen.uinode;

import androidx.core.view.MotionEventCompat;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1375Hy {
    public byte[] A00;
    public int A01;
    public int A02;
    public int A03;

    public C1375Hy() {
    }

    public C1375Hy(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public C1375Hy(byte[] bArr, int i11) {
        this.A00 = bArr;
        this.A02 = i11;
    }

    private void A00() {
        int i11;
        int i12 = this.A03;
        AbstractC1351Ha.A04(i12 >= 0 && (i12 < (i11 = this.A02) || (i12 == i11 && this.A01 == 0)));
    }

    public final int A01() {
        return ((this.A02 - this.A03) * 8) - this.A01;
    }

    public final int A02() {
        AbstractC1351Ha.A04(this.A01 == 0);
        return this.A03;
    }

    public final int A03() {
        return (this.A03 * 8) + this.A01;
    }

    public final int A04(int i11) {
        int i12;
        if (i11 == 0) {
            return 0;
        }
        int i13 = 0;
        this.A01 += i11;
        while (true) {
            i12 = this.A01;
            if (i12 <= 8) {
                break;
            }
            int i14 = i12 - 8;
            this.A01 = i14;
            byte[] bArr = this.A00;
            int i15 = this.A03;
            this.A03 = i15 + 1;
            i13 |= (bArr[i15] & 255) << i14;
        }
        byte[] bArr2 = this.A00;
        int i16 = this.A03;
        int i17 = (i13 | ((bArr2[i16] & 255) >> (8 - i12))) & ((-1) >>> (32 - i11));
        if (i12 == 8) {
            this.A01 = 0;
            this.A03 = i16 + 1;
        }
        A00();
        return i17;
    }

    public final void A05() {
        if (this.A01 == 0) {
            return;
        }
        this.A01 = 0;
        this.A03++;
        A00();
    }

    public final void A06() {
        int i11 = this.A01 + 1;
        this.A01 = i11;
        if (i11 == 8) {
            this.A01 = 0;
            this.A03++;
        }
        A00();
    }

    public final void A07(int i11) {
        int i12 = i11 / 8;
        this.A03 = i12;
        this.A01 = i11 - (i12 * 8);
        A00();
    }

    public final void A08(int i11) {
        int i12 = i11 / 8;
        int i13 = this.A03 + i12;
        this.A03 = i13;
        int i14 = this.A01 + (i11 - (i12 * 8));
        this.A01 = i14;
        if (i14 > 7) {
            this.A03 = i13 + 1;
            this.A01 = i14 - 8;
        }
        A00();
    }

    public final void A09(int i11) {
        AbstractC1351Ha.A04(this.A01 == 0);
        this.A03 += i11;
        A00();
    }

    public final void A0A(int i11, int i12) {
        if (i12 < 32) {
            i11 &= (1 << i12) - 1;
        }
        int iMin = Math.min(8 - this.A01, i12);
        int i13 = this.A01;
        int i14 = (8 - i13) - iMin;
        int i15 = (MotionEventCompat.ACTION_POINTER_INDEX_MASK >> i13) | ((1 << i14) - 1);
        byte[] bArr = this.A00;
        int i16 = this.A03;
        byte b11 = (byte) (bArr[i16] & i15);
        bArr[i16] = b11;
        bArr[i16] = (byte) (b11 | ((i11 >>> (i12 - iMin)) << i14));
        int i17 = i12 - iMin;
        int i18 = i16 + 1;
        while (i17 > 8) {
            this.A00[i18] = (byte) (i11 >>> (i17 - 8));
            i17 -= 8;
            i18++;
        }
        int i19 = 8 - i17;
        byte[] bArr2 = this.A00;
        byte b12 = (byte) (bArr2[i18] & ((1 << i19) - 1));
        bArr2[i18] = b12;
        bArr2[i18] = (byte) (b12 | ((i11 & ((1 << i17) - 1)) << i19));
        A08(i12);
        A00();
    }

    public final void A0B(byte[] bArr) {
        A0C(bArr, bArr.length);
    }

    public final void A0C(byte[] bArr, int i11) {
        this.A00 = bArr;
        this.A03 = 0;
        this.A01 = 0;
        this.A02 = i11;
    }

    public final void A0D(byte[] bArr, int i11, int i12) {
        int i13 = (i12 >> 3) + i11;
        while (i11 < i13) {
            byte[] bArr2 = this.A00;
            int i14 = this.A03;
            int i15 = i14 + 1;
            this.A03 = i15;
            byte b11 = bArr2[i14];
            int i16 = this.A01;
            bArr[i11] = (byte) (b11 << i16);
            bArr[i11] = (byte) (((255 & bArr2[i15]) >> (8 - i16)) | bArr[i11]);
            i11++;
        }
        int i17 = i12 & 7;
        if (i17 == 0) {
            return;
        }
        bArr[i13] = (byte) (bArr[i13] & (255 >> i17));
        int i18 = this.A01;
        if (i18 + i17 > 8) {
            int i19 = bArr[i13];
            byte[] bArr3 = this.A00;
            int i21 = this.A03;
            this.A03 = i21 + 1;
            bArr[i13] = (byte) (i19 | ((bArr3[i21] & 255) << i18));
            this.A01 = i18 - 8;
        }
        int i22 = this.A01 + i17;
        this.A01 = i22;
        byte[] bArr4 = this.A00;
        int i23 = this.A03;
        bArr[i13] = (byte) (bArr[i13] | ((byte) (((255 & bArr4[i23]) >> (8 - i22)) << (8 - i17))));
        if (i22 == 8) {
            this.A01 = 0;
            this.A03 = i23 + 1;
        }
        A00();
    }

    public final void A0E(byte[] bArr, int i11, int i12) {
        AbstractC1351Ha.A04(this.A01 == 0);
        System.arraycopy(this.A00, this.A03, bArr, i11, i12);
        this.A03 += i12;
        A00();
    }

    public final boolean A0F() {
        boolean z11 = (this.A00[this.A03] & (128 >> this.A01)) != 0;
        A06();
        return z11;
    }
}

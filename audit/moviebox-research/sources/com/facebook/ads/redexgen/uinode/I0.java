package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class I0 {
    public static String[] A04 = {"BtHKr", "GAfuq", "1TcIbYyYGpE6Ekv4glvvfZz9bC", "q9fmd3d0ImW5Daxca", "ooOXUvpeMSptobOLnq6qd7gNdq", "VwsWXVZM3brBJlmy9", "pSziVAe", "zUHU2CyO73eexnRwL2LOOWJW4Jr0bcWv"};
    public int A00;
    public int A01;
    public int A02;
    public byte[] A03;

    public I0(byte[] bArr, int i11, int i12) {
        A08(bArr, i11, i12);
    }

    private int A00() {
        int i11 = 0;
        while (!A0A()) {
            i11++;
        }
        return ((1 << i11) - 1) + (i11 > 0 ? A05(i11) : 0);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002c  */
    private void A01() {
        boolean z11;
        int i11 = this.A02;
        if (i11 >= 0) {
            int i12 = this.A01;
            if (A04[1].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "f06qvbC";
            strArr[0] = "HuIz9";
            if (i11 < i12 || (i11 == i12 && this.A00 == 0)) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else {
            z11 = false;
        }
        AbstractC1351Ha.A04(z11);
    }

    private boolean A02(int i11) {
        if (2 <= i11 && i11 < this.A01) {
            byte[] bArr = this.A03;
            byte b11 = bArr[i11];
            String[] strArr = A04;
            if (strArr[6].length() != strArr[0].length()) {
                String[] strArr2 = A04;
                strArr2[5] = "Jod3dkhqFQ8qWj2s5";
                strArr2[3] = "0zxF2BZpdiUX5xaGz";
                if (b11 == 3 && bArr[i11 - 2] == 0) {
                    byte b12 = bArr[i11 - 1];
                    String[] strArr3 = A04;
                    if (strArr3[6].length() != strArr3[0].length()) {
                        String[] strArr4 = A04;
                        strArr4[6] = "lQKXp2Z";
                        strArr4[0] = "Kosug";
                        if (b12 == 0) {
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        }
        return false;
    }

    public final int A03() {
        int iA00 = A00();
        return (iA00 % 2 == 0 ? -1 : 1) * ((iA00 + 1) / 2);
    }

    public final int A04() {
        return A00();
    }

    public final int A05(int i11) {
        int i12;
        int i13 = 0;
        this.A00 += i11;
        while (true) {
            i12 = this.A00;
            int i14 = 2;
            if (i12 <= 8) {
                break;
            }
            int i15 = i12 - 8;
            this.A00 = i15;
            byte[] bArr = this.A03;
            int i16 = this.A02;
            i13 |= (bArr[i16] & 255) << i15;
            if (!A02(i16 + 1)) {
                i14 = 1;
            }
            this.A02 = i16 + i14;
        }
        byte[] bArr2 = this.A03;
        int i17 = this.A02;
        int i18 = bArr2[i17] & 255;
        String[] strArr = A04;
        if (strArr[5].length() != strArr[3].length()) {
            throw new RuntimeException();
        }
        A04[7] = "CI85ryy9UuGcWp4q0bXmx78DrLL4QG6i";
        int i19 = (i13 | (i18 >> (8 - i12))) & ((-1) >>> (32 - i11));
        if (i12 == 8) {
            this.A00 = 0;
            this.A02 = i17 + (A02(i17 + 1) ? 2 : 1);
        }
        A01();
        return i19;
    }

    public final void A06() {
        int i11 = this.A00 + 1;
        this.A00 = i11;
        if (i11 == 8) {
            this.A00 = 0;
            int i12 = this.A02;
            this.A02 = i12 + (A02(i12 + 1) ? 2 : 1);
        }
        A01();
    }

    public final void A07(int i11) {
        int i12 = this.A02;
        int i13 = i11 / 8;
        int i14 = this.A02 + i13;
        this.A02 = i14;
        int i15 = this.A00 + (i11 - (i13 * 8));
        this.A00 = i15;
        if (i15 > 7) {
            int i16 = i14 + 1;
            String[] strArr = A04;
            if (strArr[2].length() != strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "WKnUhbHg5PXpVOXLjQbslPOixC";
            strArr2[4] = "5elOCNAU3UTje1WUqtoqjArHkZ";
            this.A02 = i16;
            this.A00 = i15 - 8;
        }
        int i17 = i12 + 1;
        while (i17 <= this.A02) {
            if (A02(i17)) {
                this.A02++;
                i17 += 2;
            }
            i17++;
        }
        A01();
    }

    public final void A08(byte[] bArr, int i11, int i12) {
        this.A03 = bArr;
        this.A02 = i11;
        this.A01 = i12;
        this.A00 = 0;
        A01();
    }

    public final boolean A09() {
        int i11 = this.A02;
        int i12 = this.A00;
        int i13 = 0;
        while (this.A02 < this.A01 && !A0A()) {
            i13++;
        }
        boolean z11 = this.A02 == this.A01;
        this.A02 = i11;
        this.A00 = i12;
        return !z11 && A0B((i13 * 2) + 1);
    }

    public final boolean A0A() {
        boolean z11 = (this.A03[this.A02] & (128 >> this.A00)) != 0;
        A06();
        return z11;
    }

    public final boolean A0B(int i11) {
        int i12 = this.A02;
        int i13 = i11 / 8;
        int i14 = this.A02 + i13;
        int i15 = (this.A00 + i11) - (i13 * 8);
        if (i15 > 7) {
            i14++;
            i15 -= 8;
        }
        int i16 = i12 + 1;
        while (i16 <= i14 && i14 < this.A01) {
            if (A02(i16)) {
                i14++;
                i16 += 2;
            }
            i16++;
        }
        int i17 = this.A01;
        if (i14 >= i17) {
            return i14 == i17 && i15 == 0;
        }
        return true;
    }
}

package com.facebook.ads.redexgen.uinode;

import android.graphics.Bitmap;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class G8 {
    public static String[] A09 = {"Ae51WtdtbsQ7oHVSUK2kH2lkhYtCD", "qx7lDBYo1odo5Y55vJBjPuPd0SCIUsyA", "8Fm6CMM7j8ObWzEih", "Wlrw6QUG7RBgeIlzL5kKGv4h4BsSo73q", "KMN6ZJtdLdMqvcVUA0dmI7c1fz02SP9b", "8oEfNfnBPUmBxW5HI", "jCL3JtrXJCo63I6Hw50xrAvVkRQtnXEj", "6zRYHFDNSsaLRa7ASpeJIQcC6Xopjreo"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final C1376Hz A07 = new C1376Hz();
    public final int[] A08 = new int[256];

    /* JADX INFO: Access modifiers changed from: private */
    public void A03(C1376Hz c1376Hz, int i11) {
        int iA06;
        int iA07;
        int iA0G;
        if (i11 < 4) {
            return;
        }
        c1376Hz.A0Z(3);
        int i12 = i11 - 4;
        if (!((c1376Hz.A0E() & 128) != 0)) {
            iA06 = this.A07.A06();
            iA07 = this.A07.A07();
            if (iA06 < iA07) {
                return;
            } else {
                return;
            }
        }
        String[] strArr = A09;
        if (strArr[4].charAt(22) == strArr[7].charAt(22)) {
            String[] strArr2 = A09;
            strArr2[2] = "m4TsyqBzkyxUuct48";
            strArr2[5] = "zfIYrv7wq9TBAE9Jz";
            if (i12 < 7 || (iA0G = c1376Hz.A0G()) < 4) {
                return;
            }
            this.A01 = c1376Hz.A0I();
            this.A00 = c1376Hz.A0I();
            this.A07.A0W(iA0G - 4);
            i12 -= 7;
            iA06 = this.A07.A06();
            iA07 = this.A07.A07();
            if (iA06 < iA07 || i12 <= 0) {
                return;
            }
            int iMin = Math.min(i12, iA07 - iA06);
            C1376Hz c1376Hz2 = this.A07;
            String[] strArr3 = A09;
            if (strArr3[4].charAt(22) == strArr3[7].charAt(22)) {
                A09[6] = "1YWr3OwQ0jPjYWbciqj9BosGRiIvHZyi";
                c1376Hz.A0c(c1376Hz2.A00, iA06, iMin);
                this.A07.A0Y(iA06 + iMin);
                return;
            }
        }
        throw new RuntimeException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(C1376Hz c1376Hz, int i11) {
        if (i11 < 19) {
            return;
        }
        this.A05 = c1376Hz.A0I();
        this.A04 = c1376Hz.A0I();
        c1376Hz.A0Z(11);
        this.A02 = c1376Hz.A0I();
        this.A03 = c1376Hz.A0I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(C1376Hz c1376Hz, int i11) {
        if (i11 % 5 != 2) {
            return;
        }
        c1376Hz.A0Z(2);
        Arrays.fill(this.A08, 0);
        int i12 = i11 / 5;
        for (int i13 = 0; i13 < i12; i13++) {
            int iA0E = c1376Hz.A0E();
            int iA0E2 = c1376Hz.A0E();
            int iA0E3 = c1376Hz.A0E();
            int iA0E4 = c1376Hz.A0E();
            this.A08[iA0E] = (c1376Hz.A0E() << 24) | (IF.A06((int) (((double) iA0E2) + (((double) (iA0E3 - 128)) * 1.402d)), 0, 255) << 16) | (IF.A06((int) ((((double) iA0E2) - (((double) (iA0E4 - 128)) * 0.34414d)) - (((double) (iA0E3 - 128)) * 0.71414d)), 0, 255) << 8) | IF.A06((int) (((double) iA0E2) + (((double) (iA0E4 - 128)) * 1.772d)), 0, 255);
        }
        this.A06 = true;
    }

    public final C1314Fn A06() {
        if (this.A05 == 0 || this.A04 == 0 || this.A01 == 0 || this.A00 == 0 || this.A07.A07() == 0 || this.A07.A06() != this.A07.A07()) {
            return null;
        }
        boolean z11 = this.A06;
        if (A09[6].charAt(24) == 'V') {
            throw new RuntimeException();
        }
        A09[1] = "nq70zeHujM7cnH9A4IhpB5iOObfNW5He";
        if (!z11) {
            return null;
        }
        this.A07.A0Y(0);
        int[] iArr = new int[this.A01 * this.A00];
        int i11 = 0;
        while (i11 < iArr.length) {
            int iA0E = this.A07.A0E();
            if (iA0E != 0) {
                iArr[i11] = this.A08[iA0E];
                i11++;
            } else {
                int iA0E2 = this.A07.A0E();
                if (iA0E2 != 0) {
                    int iA0E3 = (iA0E2 & 64) == 0 ? iA0E2 & 63 : ((iA0E2 & 63) << 8) | this.A07.A0E();
                    Arrays.fill(iArr, i11, i11 + iA0E3, (iA0E2 & 128) == 0 ? 0 : this.A08[this.A07.A0E()]);
                    i11 += iA0E3;
                }
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.A01, this.A00, Bitmap.Config.ARGB_8888);
        float f11 = this.A02;
        int i12 = this.A05;
        float f12 = f11 / i12;
        float f13 = this.A03;
        int i13 = this.A04;
        return new C1314Fn(bitmapCreateBitmap, f12, 0, f13 / i13, 0, this.A01 / i12, this.A00 / i13);
    }

    public final void A07() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0W(0);
        this.A06 = false;
    }
}

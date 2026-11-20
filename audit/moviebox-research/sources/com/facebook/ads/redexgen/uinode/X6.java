package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X6 implements InterfaceC1259Cy {
    public static byte[] A0H;
    public static String[] A0I = {"aRSbhnMLIcOzj", "ArMoJofeV0W2c5eK3C8YvO0k1qJSW4Bu", "08qFCQPWLGI3uv5FT5gA6GEjfGrW3Yqx", "08xirDFjjs8oqtTIfBkr", "oUVAEbDN9zve", "EoNb", "rtTHy9LVM9SlY", "UaKoPz55Hu2hTR949azFeJYsN1lXPKTw"};
    public static final byte[] A0J;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public long A06;
    public C4 A07;
    public C4 A08;
    public C4 A09;
    public String A0A;
    public boolean A0B;
    public boolean A0C;
    public final C1375Hy A0D;
    public final C1376Hz A0E;
    public final String A0F;
    public final boolean A0G;

    static {
        A06();
        A0J = new byte[]{73, 68, 51};
    }

    public X6(boolean z11) {
        this(z11, null);
    }

    public X6(boolean z11, String str) {
        this.A0D = new C1375Hy(new byte[7]);
        this.A0E = new C1376Hz(Arrays.copyOf(A0J, 10));
        A03();
        this.A0G = z11;
        this.A0F = str;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 124);
        }
        return new String(bArrCopyOfRange);
    }

    private void A01() throws C11849v {
        this.A0D.A07(0);
        if (this.A0C) {
            this.A0D.A08(10);
        } else {
            int iA04 = this.A0D.A04(2) + 1;
            if (iA04 != 2) {
                Log.w(A00(22, 10, 59), A00(32, 28, 25) + iA04 + A00(0, 22, 57));
                iA04 = 2;
            }
            int iA05 = this.A0D.A04(4);
            this.A0D.A08(1);
            byte[] bArrA07 = AbstractC1355He.A07(iA04, iA05, this.A0D.A04(3));
            Pair<Integer, Integer> pairA03 = AbstractC1355He.A03(bArrA07);
            Format formatA07 = Format.A07(this.A0A, A00(75, 15, 35), null, -1, -1, ((Integer) pairA03.second).intValue(), ((Integer) pairA03.first).intValue(), Collections.singletonList(bArrA07), null, 0, this.A0F);
            this.A05 = 1024000000 / ((long) formatA07.A0C);
            this.A09.A5n(formatA07);
            this.A0C = true;
        }
        this.A0D.A08(4);
        int iA06 = (this.A0D.A04(13) - 2) - 5;
        if (this.A0B) {
            iA06 -= 2;
        }
        A07(this.A09, this.A05, 0, iA06);
    }

    private void A02() {
        this.A08.AFR(this.A0E, 10);
        this.A0E.A0Y(6);
        A07(this.A08, 0L, 10, this.A0E.A0D() + 10);
    }

    private void A03() {
        this.A03 = 0;
        this.A00 = 0;
        this.A01 = 256;
    }

    private void A04() {
        this.A03 = 2;
        this.A00 = 0;
    }

    private void A05() {
        this.A03 = 1;
        this.A00 = A0J.length;
        this.A02 = 0;
        this.A0E.A0Y(0);
    }

    public static void A06() {
        A0H = new byte[]{-31, -43, Ascii.ETB, 42, 41, -43, Ascii.SYN, 40, 40, 42, 34, Ascii.RS, 35, Ascii.FS, -43, -10, -10, -8, -43, 1, -8, -29, -8, Ascii.ESC, 43, 42, 9, Ascii.FS, Ascii.CAN, Ascii.ESC, Ascii.FS, 41, -39, -6, 9, -6, -8, 9, -6, -7, -75, -10, 10, -7, -2, 4, -75, 4, -9, -1, -6, -8, 9, -75, 9, Ascii.SO, 5, -6, -49, -75, 34, 49, 49, 45, 42, 36, 34, 53, 42, 48, 47, -16, 42, 37, -12, 0, Ascii.DC4, 3, 8, Ascii.SO, -50, Ascii.FF, Ascii.SI, -45, 0, -52, Ascii.VT, 0, 19, Ascii.FF};
    }

    private void A07(C4 c11, long j11, int i11, int i12) {
        this.A03 = 3;
        this.A00 = i11;
        this.A07 = c11;
        this.A04 = j11;
        this.A02 = i12;
    }

    private void A08(C1376Hz c1376Hz) {
        byte[] bArr = c1376Hz.A00;
        int iA06 = c1376Hz.A06();
        int iA07 = c1376Hz.A07();
        while (iA06 < iA07) {
            int i11 = iA06 + 1;
            int i12 = bArr[iA06] & 255;
            int i13 = this.A01;
            if (i13 == 512 && i12 >= 240 && i12 != 255) {
                this.A0B = (i12 & 1) == 0;
                A04();
                c1376Hz.A0Y(i11);
                return;
            }
            switch (i13 | i12) {
                case 329:
                    this.A01 = 768;
                    iA06 = i11;
                    break;
                case 511:
                    this.A01 = 512;
                    iA06 = i11;
                    break;
                case 836:
                    this.A01 = 1024;
                    iA06 = i11;
                    break;
                case 1075:
                    A05();
                    c1376Hz.A0Y(i11);
                    break;
                default:
                    if (i13 != 256) {
                        this.A01 = 256;
                        iA06 = i11 - 1;
                    } else {
                        iA06 = i11;
                    }
                    break;
            }
            return;
        }
        c1376Hz.A0Y(iA06);
    }

    private void A09(C1376Hz c1376Hz) {
        int iMin = Math.min(c1376Hz.A04(), this.A02 - this.A00);
        this.A07.AFR(c1376Hz, iMin);
        int i11 = this.A00 + iMin;
        this.A00 = i11;
        int i12 = this.A02;
        if (i11 == i12) {
            this.A07.AFS(this.A06, 1, i12, 0, null);
            this.A06 += this.A04;
            A03();
        }
    }

    private boolean A0A(C1376Hz c1376Hz, byte[] bArr, int i11) {
        int iMin = Math.min(c1376Hz.A04(), i11 - this.A00);
        c1376Hz.A0c(bArr, this.A00, iMin);
        int i12 = this.A00 + iMin;
        this.A00 = i12;
        return i12 == i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) throws C11849v {
        while (c1376Hz.A04() > 0) {
            switch (this.A03) {
                case 0:
                    A08(c1376Hz);
                    break;
                case 1:
                    if (A0A(c1376Hz, this.A0E.A00, 10)) {
                        A02();
                    }
                    break;
                case 2:
                    if (A0A(c1376Hz, this.A0D.A00, this.A0B ? 7 : 5)) {
                        A01();
                    }
                    break;
                case 3:
                    A09(c1376Hz);
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A0A = dc2.A04();
        this.A09 = interfaceC1235Bu.AGi(dc2.A03(), 1);
        if (!this.A0G) {
            this.A08 = new C1767Xl();
            return;
        }
        dc2.A05();
        C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 4);
        this.A08 = c4AGi;
        if (A0I[4].length() != 12) {
            throw new RuntimeException();
        }
        A0I[5] = "GBp";
        c4AGi.A5n(Format.A0B(dc2.A04(), A00(60, 15, 69), null, -1, null));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        this.A06 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        A03();
    }
}

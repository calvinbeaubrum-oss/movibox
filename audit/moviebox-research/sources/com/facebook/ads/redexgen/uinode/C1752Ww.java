package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ww, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1752Ww implements DD {
    public static byte[] A0C;
    public static String[] A0D = {"wYbCHe4PqE0rUTWdo8mFq0UBpfkRDoC", "CuNoFwrXbx7Fup1Bnz4crpheboHEAq61", "i4a35YUA6bJnEiUQjLdSeulU0LA5VC2", "DQj4nZO33GsRRuNygGqDxWwIbU", "NTzjfKAdqL5R4ni", "Zn", "9Rh66LtnIoGSEkHARJ7O", "nCQ56kMXgmV4b9DPw80w9mtudgrGO1uA"};
    public int A00;
    public int A01;
    public int A02;
    public long A04;
    public IB A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public final InterfaceC1259Cy A0A;
    public final C1375Hy A0B = new C1375Hy(new byte[10]);
    public int A03 = 0;

    static {
        A02();
    }

    public C1752Ww(InterfaceC1259Cy interfaceC1259Cy) {
        this.A0A = interfaceC1259Cy;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0D;
            if (strArr[6].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[6] = "tGST5WGrXasfnynKry2Y";
            strArr2[4] = "X7BCEDGkhqj2a0M";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 105);
            i14++;
        }
    }

    private void A01() {
        this.A0B.A07(0);
        this.A04 = C.TIME_UNSET;
        if (this.A08) {
            this.A0B.A08(4);
            long jA04 = ((long) this.A0B.A04(3)) << 30;
            this.A0B.A08(1);
            long jA05 = jA04 | ((long) (this.A0B.A04(15) << 15));
            this.A0B.A08(1);
            long jA06 = jA05 | ((long) this.A0B.A04(15));
            this.A0B.A08(1);
            if (!this.A09 && this.A07) {
                this.A0B.A08(4);
                long jA07 = ((long) this.A0B.A04(3)) << 30;
                this.A0B.A08(1);
                long jA08 = jA07 | ((long) (this.A0B.A04(15) << 15));
                this.A0B.A08(1);
                long jA09 = jA08 | ((long) this.A0B.A04(15));
                this.A0B.A08(1);
                this.A05.A07(jA09);
                this.A09 = true;
            }
            this.A04 = this.A05.A07(jA06);
        }
    }

    public static void A02() {
        A0C = new byte[]{-37, 40, 42, 45, 32, -37, Ascii.GS, 52, 47, 32, 46, -44, -23, -9, -42, -23, -27, -24, -23, -10, -14, Ascii.VT, 2, Ascii.NAK, Ascii.CR, 2, 0, 17, 2, 1, -67, Ascii.DLE, 17, -2, Ascii.SI, 17, -67, 0, Ascii.FF, 1, 2, -67, Ascii.CR, Ascii.SI, 2, 3, 6, Ascii.NAK, -41, -67, 40, 65, 56, 75, 67, 56, 54, 71, 56, 55, -13, 70, 71, 52, 69, 71, -13, 60, 65, 55, 60, 54, 52, 71, 66, 69, -13, 69, 56, 52, 55, 60, 65, 58, -13, 56, 75, 71, 56, 65, 55, 56, 55, -13, 59, 56, 52, 55, 56, 69, -2, Ascii.ETB, Ascii.SO, 33, Ascii.EM, Ascii.SO, Ascii.FF, Ascii.GS, Ascii.SO, Ascii.CR, -55, Ascii.FS, Ascii.GS, 10, Ascii.ESC, Ascii.GS, -55, Ascii.DC2, Ascii.ETB, Ascii.CR, Ascii.DC2, Ascii.FF, 10, Ascii.GS, Ascii.CAN, Ascii.ESC, -29, -55, Ascii.SO, 33, Ascii.EM, Ascii.SO, Ascii.FF, Ascii.GS, Ascii.SO, Ascii.CR, -55};
    }

    private void A03(int i11) {
        this.A03 = i11;
        this.A00 = 0;
    }

    private boolean A04() {
        this.A0B.A07(0);
        int iA04 = this.A0B.A04(24);
        if (iA04 != 1) {
            Log.w(A00(11, 9, 27), A00(20, 30, 52) + iA04);
            this.A02 = -1;
            return false;
        }
        this.A0B.A08(8);
        int iA05 = this.A0B.A04(16);
        this.A0B.A08(5);
        this.A06 = this.A0B.A0F();
        this.A0B.A08(2);
        this.A08 = this.A0B.A0F();
        this.A07 = this.A0B.A0F();
        this.A0B.A08(6);
        int iA06 = this.A0B.A04(8);
        this.A01 = iA06;
        if (iA05 == 0) {
            this.A02 = -1;
        } else {
            this.A02 = ((iA05 + 6) - 9) - iA06;
        }
        return true;
    }

    private boolean A05(C1376Hz c1376Hz, byte[] bArr, int i11) {
        int iMin = Math.min(c1376Hz.A04(), i11 - this.A00);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c1376Hz.A0Z(iMin);
        } else {
            c1376Hz.A0c(bArr, this.A00, iMin);
        }
        int i12 = this.A00 + iMin;
        this.A00 = i12;
        return i12 == i11;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00db  */
    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void A4S(C1376Hz c1376Hz, boolean z11) throws C11849v {
        if (z11) {
            int i11 = this.A03;
            String strA00 = A00(11, 9, 27);
            switch (i11) {
                case 2:
                    Log.w(strA00, A00(50, 50, 106));
                    break;
                case 3:
                    int i12 = this.A02;
                    String[] strArr = A0D;
                    if (strArr[1].charAt(7) != strArr[7].charAt(7)) {
                        A0D[3] = "iT6qZLxrsL5nFXzA5eMWRbmPpry";
                        if (i12 != -1) {
                            Log.w(strA00, A00(100, 37, 64) + this.A02 + A00(0, 11, 82));
                        }
                    } else {
                        String[] strArr2 = A0D;
                        strArr2[6] = "yVWHAKGbYqdJQnId175P";
                        strArr2[4] = "7JSMzt33eVYw0UR";
                        if (i12 != -1) {
                            Log.w(strA00, A00(100, 37, 64) + this.A02 + A00(0, 11, 82));
                        }
                    }
                    this.A0A.ADs();
                    break;
            }
            A03(1);
        }
        while (c1376Hz.A04() > 0) {
            switch (this.A03) {
                case 0:
                    c1376Hz.A0Z(c1376Hz.A04());
                    break;
                case 1:
                    if (A05(c1376Hz, this.A0B.A00, 9)) {
                        A03(A04() ? 2 : 0);
                    }
                    break;
                case 2:
                    if (A05(c1376Hz, this.A0B.A00, Math.min(10, this.A01)) && A05(c1376Hz, null, this.A01)) {
                        A01();
                        this.A0A.ADt(this.A04, this.A06);
                        A03(3);
                    }
                    break;
                case 3:
                    int iA04 = c1376Hz.A04();
                    String[] strArr3 = A0D;
                    if (strArr3[0].length() != strArr3[2].length()) {
                        throw new RuntimeException();
                    }
                    A0D[3] = "hjut4LIYfO6UEnzCC4LSiWMZuOq2ZkQ";
                    int i13 = this.A02;
                    int i14 = i13 != -1 ? iA04 - i13 : 0;
                    if (i14 > 0) {
                        iA04 -= i14;
                        c1376Hz.A0X(c1376Hz.A06() + iA04);
                    }
                    this.A0A.A4R(c1376Hz);
                    int i15 = this.A02;
                    if (i15 != -1) {
                        int i16 = i15 - iA04;
                        this.A02 = i16;
                        if (i16 == 0) {
                            this.A0A.ADs();
                            A03(1);
                        }
                    }
                    break;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void A8q(IB ib2, InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        this.A05 = ib2;
        this.A0A.A4p(interfaceC1235Bu, dc2);
    }

    @Override // com.facebook.ads.redexgen.uinode.DD
    public final void AFg() {
        this.A03 = 0;
        this.A00 = 0;
        this.A09 = false;
        this.A0A.AFg();
    }
}

package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class X0 implements InterfaceC1259Cy {
    public static byte[] A0E;
    public static String[] A0F = {"NvpEV7R7ZS5uNQ5TFb57EvhjwIZCTQku", "DdUDSiCrGQUoEviiVingxcQFfwNbDa", "hetlnsRY2wqGSQpiRITV", "h6jp2Z", "H3YUjFwBN5I", "HDGGogJPAHFPfOUxVzLcmHcfpTDLo", "fvYnB4Gz7ZvwaQ8Y4EtF6ZMgsdzNJKEV", "DcduA0DmY9P8nwkm6XpLf73k0ckt"};
    public long A00;
    public long A01;
    public C4 A02;
    public D3 A03;
    public String A04;
    public boolean A05;
    public final D7 A0B;
    public final boolean[] A0D = new boolean[3];
    public final D4 A0A = new D4(32, 128);
    public final D4 A08 = new D4(33, 128);
    public final D4 A06 = new D4(34, 128);
    public final D4 A07 = new D4(39, 128);
    public final D4 A09 = new D4(40, 128);
    public final C1376Hz A0C = new C1376Hz();

    static {
        A02();
    }

    public X0(D7 d11) {
        this.A0B = d11;
    }

    public static Format A00(String str, D4 d11, D4 d12, D4 d13) {
        byte[] bArr = new byte[d11.A00 + d12.A00 + d13.A00];
        System.arraycopy(d11.A01, 0, bArr, 0, d11.A00);
        System.arraycopy(d12.A01, 0, bArr, d11.A00, d12.A00);
        System.arraycopy(d13.A01, 0, bArr, d11.A00 + d12.A00, d13.A00);
        I0 i11 = new I0(d12.A01, 0, d12.A00);
        i11.A07(44);
        int iA05 = i11.A05(3);
        i11.A06();
        i11.A07(88);
        i11.A07(8);
        int i12 = 0;
        for (int i13 = 0; i13 < iA05; i13++) {
            if (i11.A0A()) {
                i12 += 89;
            }
            if (i11.A0A()) {
                i12 += 8;
            }
        }
        i11.A07(i12);
        if (iA05 > 0) {
            i11.A07((8 - iA05) * 2);
        }
        i11.A04();
        int iA04 = i11.A04();
        if (iA04 == 3) {
            i11.A06();
        }
        int iA06 = i11.A04();
        int iA07 = i11.A04();
        if (A0F[1].length() == 12) {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[4] = "a8PzOvYW3xW";
        strArr[2] = "i4yWj6LgSPQERWLdQfta";
        if (i11.A0A()) {
            int iA08 = i11.A04();
            int iA09 = i11.A04();
            int iA010 = i11.A04();
            int iA011 = i11.A04();
            iA06 -= (iA08 + iA09) * ((iA04 == 1 || iA04 == 2) ? 2 : 1);
            iA07 -= (iA010 + iA011) * (iA04 == 1 ? 2 : 1);
        }
        i11.A04();
        i11.A04();
        int iA012 = i11.A04();
        for (int i14 = i11.A0A() ? 0 : iA05; i14 <= iA05; i14++) {
            i11.A04();
            i11.A04();
            i11.A04();
        }
        i11.A04();
        i11.A04();
        i11.A04();
        i11.A04();
        i11.A04();
        i11.A04();
        if (i11.A0A() && i11.A0A()) {
            A05(i11);
        }
        i11.A07(2);
        if (i11.A0A()) {
            i11.A07(8);
            i11.A04();
            i11.A04();
            i11.A06();
        }
        A06(i11);
        if (i11.A0A()) {
            for (int i15 = 0; i15 < i11.A04(); i15++) {
                i11.A07(iA012 + 4 + 1);
            }
        }
        i11.A07(2);
        float f11 = 1.0f;
        if (i11.A0A() && i11.A0A()) {
            int iA013 = i11.A05(8);
            if (iA013 == 255) {
                int iA014 = i11.A05(16);
                int iA015 = i11.A05(16);
                if (iA014 != 0 && iA015 != 0) {
                    f11 = iA014 / iA015;
                }
            } else {
                float[] fArr = AbstractC1372Hv.A04;
                String[] strArr2 = A0F;
                if (strArr2[4].length() == strArr2[2].length()) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0F;
                strArr3[4] = "Mq8kmMTSiz0";
                strArr3[2] = "TBAE07oWZ5Khy7farxDr";
                if (iA013 < fArr.length) {
                    f11 = AbstractC1372Hv.A04[iA013];
                } else {
                    Log.w(A01(0, 10, 24), A01(10, 35, 2) + iA013);
                }
            }
        }
        String strA01 = A01(45, 10, 17);
        List listSingletonList = Collections.singletonList(bArr);
        if (A0F[3].length() != 6) {
            String[] strArr4 = A0F;
            strArr4[7] = "REKIidOCsv4ptzsgivtfnGOww6JG";
            strArr4[5] = "T94vPaWVm7jdMSWQElc8luWGTOlSo";
            return Format.A03(str, strA01, null, -1, -1, iA06, iA07, -1.0f, listSingletonList, -1, f11, null);
        }
        String[] strArr5 = A0F;
        strArr5[7] = "W2GdBlThEFkhmpYhDIzNH9YY1BaI";
        strArr5[5] = "0yDCfDeoWht2juYgXJKTHBbNY9ana";
        return Format.A03(str, strA01, null, -1, -1, iA06, iA07, -1.0f, listSingletonList, -1, f11, null);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        String[] strArr = A0F;
        if (strArr[4].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A0F[3] = "YNSDJ1";
        A0E = new byte[]{121, 3, 7, 4, 99, 84, 80, 85, 84, 67, 126, 69, 78, 83, 91, 78, 72, 95, 78, 79, Ascii.VT, 74, 88, 91, 78, 72, 95, 116, 89, 74, 95, 66, 68, 116, 66, 79, 72, Ascii.VT, 93, 74, 71, 94, 78, 17, Ascii.VT, 78, 81, 92, 93, 87, Ascii.ETB, 80, 93, 78, 91};
    }

    private void A03(long j11, int i11, int i12, long j12) {
        if (this.A05) {
            this.A03.A02(j11, i11);
        } else {
            this.A0A.A04(i12);
            this.A08.A04(i12);
            this.A06.A04(i12);
            if (this.A0A.A03() && this.A08.A03() && this.A06.A03()) {
                this.A02.A5n(A00(this.A04, this.A0A, this.A08, this.A06));
                this.A05 = true;
            }
        }
        if (this.A07.A04(i12)) {
            D4 d11 = this.A07;
            if (A0F[1].length() == 12) {
                throw new RuntimeException();
            }
            A0F[3] = "Yba7mj";
            this.A0C.A0b(this.A07.A01, AbstractC1372Hv.A02(d11.A01, this.A07.A00));
            this.A0C.A0Z(5);
            this.A0B.A02(j12, this.A0C);
        }
        if (this.A09.A04(i12)) {
            this.A0C.A0b(this.A09.A01, AbstractC1372Hv.A02(this.A09.A01, this.A09.A00));
            this.A0C.A0Z(5);
            this.A0B.A02(j12, this.A0C);
        }
    }

    private void A04(long j11, int i11, int i12, long j12) {
        if (this.A05) {
            this.A03.A03(j11, i11, i12, j12);
        } else {
            this.A0A.A01(i12);
            this.A08.A01(i12);
            this.A06.A01(i12);
        }
        this.A07.A01(i12);
        this.A09.A01(i12);
    }

    public static void A05(I0 i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            int i13 = 0;
            while (i13 < 6) {
                int i14 = 1;
                if (i11.A0A()) {
                    int iMin = Math.min(64, 1 << ((i12 << 1) + 4));
                    if (i12 > 1) {
                        i11.A03();
                    }
                    for (int i15 = 0; i15 < iMin; i15++) {
                        i11.A03();
                    }
                } else {
                    i11.A04();
                }
                if (i12 == 3) {
                    i14 = 3;
                }
                i13 += i14;
            }
        }
    }

    public static void A06(I0 i11) {
        int iA04 = i11.A04();
        boolean zA0A = false;
        int i12 = 0;
        for (int i13 = 0; i13 < iA04; i13++) {
            if (i13 != 0) {
                zA0A = i11.A0A();
            }
            if (zA0A) {
                i11.A06();
                i11.A04();
                for (int i14 = 0; i14 <= i12; i14++) {
                    if (i11.A0A()) {
                        i11.A06();
                    }
                }
            } else {
                int iA05 = i11.A04();
                int iA06 = i11.A04();
                i12 = iA05 + iA06;
                for (int i15 = 0; i15 < iA05; i15++) {
                    i11.A04();
                    i11.A06();
                }
                for (int i16 = 0; i16 < iA06; i16++) {
                    i11.A04();
                    i11.A06();
                }
            }
        }
    }

    private void A07(byte[] bArr, int i11, int i12) {
        if (this.A05) {
            this.A03.A04(bArr, i11, i12);
        } else {
            this.A0A.A02(bArr, i11, i12);
            this.A08.A02(bArr, i11, i12);
            this.A06.A02(bArr, i11, i12);
        }
        this.A07.A02(bArr, i11, i12);
        this.A09.A02(bArr, i11, i12);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4R(C1376Hz c1376Hz) {
        while (true) {
            int iA04 = c1376Hz.A04();
            if (A0F[1].length() == 12) {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[0] = "AvzYB124iDQiX3hdxqfkLksaQ25q0Ga1";
            strArr[6] = "Nv2bR4D3VQ28suo5ivBlL2099SuCEJEb";
            if (iA04 <= 0) {
                return;
            }
            int iA06 = c1376Hz.A06();
            int iA07 = c1376Hz.A07();
            byte[] bArr = c1376Hz.A00;
            this.A01 += (long) c1376Hz.A04();
            this.A02.AFR(c1376Hz, c1376Hz.A04());
            while (iA06 < iA07) {
                int iA05 = AbstractC1372Hv.A04(bArr, iA06, iA07, this.A0D);
                if (iA05 == iA07) {
                    A07(bArr, iA06, iA07);
                    return;
                }
                int iA00 = AbstractC1372Hv.A00(bArr, iA05);
                int i11 = iA05 - iA06;
                if (i11 > 0) {
                    A07(bArr, iA06, iA05);
                }
                int i12 = iA07 - iA05;
                long j11 = this.A01 - ((long) i12);
                A03(j11, i12, i11 < 0 ? -i11 : 0, this.A00);
                A04(j11, i12, iA00, this.A00);
                iA06 = iA05 + 3;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void A4p(InterfaceC1235Bu interfaceC1235Bu, DC dc2) {
        dc2.A05();
        this.A04 = dc2.A04();
        C4 c4AGi = interfaceC1235Bu.AGi(dc2.A03(), 2);
        this.A02 = c4AGi;
        this.A03 = new D3(c4AGi);
        this.A0B.A03(interfaceC1235Bu, dc2);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADs() {
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void ADt(long j11, boolean z11) {
        this.A00 = j11;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1259Cy
    public final void AFg() {
        AbstractC1372Hv.A0B(this.A0D);
        this.A0A.A00();
        this.A08.A00();
        this.A06.A00();
        this.A07.A00();
        this.A09.A00();
        this.A03.A01();
        this.A01 = 0L;
    }
}

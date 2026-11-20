package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XC extends AbstractC1252Co {
    public static byte[] A05;
    public static String[] A06 = {"yJHQcBl4f4L", "G0ieIp3rn9VMbRQq", "FaSr", "diNTGhkPk6T4rZ0cbtlCtFUtzgnoDDOW", "ZsfK02RsUHO", "uQbwEIiYvgO", "fIpYaZEOmsgiiOCz2AK4PDqwDhI8GLBw", "t90Xt1PXy7A3GvR50K3KPdbeyD"};
    public int A00;
    public C1254Cq A01;
    public C1256Cs A02;
    public C1257Cu A03;
    public boolean A04;

    static {
        A04();
    }

    public static int A00(byte b11, int i11, int i12) {
        return (b11 >> i12) & (255 >>> (8 - i11));
    }

    public static int A01(byte b11, C1254Cq c1254Cq) {
        return !c1254Cq.A04[A00(b11, c1254Cq.A00, 1)].A03 ? c1254Cq.A02.A03 : c1254Cq.A02.A04;
    }

    private final C1254Cq A02(C1376Hz c1376Hz) throws IOException {
        if (this.A03 == null) {
            this.A03 = AbstractC1258Cv.A04(c1376Hz);
            return null;
        }
        if (this.A02 == null) {
            this.A02 = AbstractC1258Cv.A03(c1376Hz);
            return null;
        }
        byte[] bArr = new byte[c1376Hz.A07()];
        System.arraycopy(c1376Hz.A00, 0, bArr, 0, c1376Hz.A07());
        Ct[] ctArrA0C = AbstractC1258Cv.A0C(c1376Hz, this.A03.A05);
        return new C1254Cq(this.A03, this.A02, bArr, ctArrA0C, AbstractC1258Cv.A00(ctArrA0C.length - 1));
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A05 = new byte[]{88, 76, 93, 80, 86, Ascii.SYN, 79, 86, 75, 91, 80, 74};
    }

    public static void A05(C1376Hz c1376Hz, long j11) {
        c1376Hz.A0X(c1376Hz.A07() + 4);
        c1376Hz.A00[c1376Hz.A07() - 4] = (byte) (j11 & 255);
        c1376Hz.A00[c1376Hz.A07() - 3] = (byte) ((j11 >>> 8) & 255);
        c1376Hz.A00[c1376Hz.A07() - 2] = (byte) ((j11 >>> 16) & 255);
        c1376Hz.A00[c1376Hz.A07() - 1] = (byte) (255 & (j11 >>> 24));
    }

    public static boolean A06(C1376Hz c1376Hz) {
        try {
            return AbstractC1258Cv.A0A(1, c1376Hz, true);
        } catch (C11849v unused) {
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final long A07(C1376Hz c1376Hz) {
        if ((c1376Hz.A00[0] & 1) == 1) {
            return -1L;
        }
        int iA01 = A01(c1376Hz.A00[0], this.A01);
        int i11 = this.A04 ? (this.A00 + iA01) / 4 : 0;
        A05(c1376Hz, i11);
        this.A04 = true;
        if (A06[2].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[6] = "lV1SPFBYbG5lxAnFlWta4jj5erMHhp00";
        strArr[3] = "grWENQhpkSsLY54DCH6OLJaVWIdWM4Dq";
        this.A00 = iA01;
        return i11;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final void A08(long j11) {
        super.A08(j11);
        this.A04 = j11 != 0;
        C1257Cu c1257Cu = this.A03;
        this.A00 = c1257Cu != null ? c1257Cu.A03 : 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final void A09(boolean z11) {
        super.A09(z11);
        if (z11) {
            this.A01 = null;
            this.A03 = null;
            this.A02 = null;
        }
        this.A00 = 0;
        this.A04 = false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final boolean A0A(C1376Hz c1376Hz, long j11, C1251Cn c1251Cn) throws InterruptedException, IOException {
        if (this.A01 != null) {
            return false;
        }
        C1254Cq c1254CqA02 = A02(c1376Hz);
        this.A01 = c1254CqA02;
        if (c1254CqA02 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.A01.A02.A09);
        arrayList.add(this.A01.A03);
        c1251Cn.A00 = Format.A07(null, A03(0, 12, 20), null, this.A01.A02.A02, -1, this.A01.A02.A05, (int) this.A01.A02.A06, arrayList, null, 0, null);
        return true;
    }
}

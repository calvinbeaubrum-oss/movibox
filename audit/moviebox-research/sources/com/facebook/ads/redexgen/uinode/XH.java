package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XH extends AbstractC1252Co {
    public static byte[] A02;
    public static String[] A03 = {"8dTWvXK8tch0WiEnFvHb8QUOTjgSOqY9", "GP5XsFGUIcP3F8wb7eo6", "CqCUMDrIKsNfOt03xA9INRdZ8", "ntm6pkiJXJn0b4vYMFRbAtYqalurqDmt", "MKNWZ4ceQqyXKZHhShlPBWdiS", "qmQfSGtBK4Bh2Swsb", "DS4", "jEA"};
    public XI A00;
    public C1363Hm A01;

    static {
        A03();
    }

    private int A00(C1376Hz c1376Hz) {
        int i11 = (c1376Hz.A00[2] & 255) >> 4;
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                int i12 = i11 - 2;
                String[] strArr = A03;
                if (strArr[3].charAt(11) == strArr[0].charAt(11)) {
                    A03[1] = "m7WV3F64xJdvTLT";
                    return 576 << i12;
                }
                String[] strArr2 = A03;
                strArr2[6] = "ZGd";
                strArr2[7] = "V9k";
                return 576 << i12;
            case 6:
            case 7:
                c1376Hz.A0Z(4);
                c1376Hz.A0O();
                String[] strArr3 = A03;
                if (strArr3[3].charAt(11) != strArr3[0].charAt(11)) {
                    throw new RuntimeException();
                }
                String[] strArr4 = A03;
                strArr4[6] = "ycs";
                strArr4[7] = "AJV";
                int iA0E = i11 == 6 ? c1376Hz.A0E() : c1376Hz.A0I();
                c1376Hz.A0Y(0);
                return iA0E + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 12);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-97, -77, -94, -89, -83, 109, -92, -86, -97, -95};
    }

    public static boolean A04(C1376Hz c1376Hz) {
        return c1376Hz.A04() >= 5 && c1376Hz.A0E() == 127 && c1376Hz.A0M() == 1179402563;
    }

    public static boolean A05(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final long A07(C1376Hz c1376Hz) {
        if (A05(c1376Hz.A00)) {
            return A00(c1376Hz);
        }
        return -1L;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final void A09(boolean z11) {
        super.A09(z11);
        if (z11) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1252Co
    public final boolean A0A(C1376Hz c1376Hz, long j11, C1251Cn c1251Cn) throws InterruptedException, IOException {
        byte[] bArr = c1376Hz.A00;
        if (this.A01 == null) {
            this.A01 = new C1363Hm(bArr, 17);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 9, c1376Hz.A07());
            bArrCopyOfRange[4] = -128;
            c1251Cn.A00 = Format.A07(null, A02(0, 10, 50), null, -1, this.A01.A00(), this.A01.A01, this.A01.A06, Collections.singletonList(bArrCopyOfRange), null, 0, null);
            return true;
        }
        if ((bArr[0] & Ascii.DEL) == 3) {
            XI xi2 = new XI(this);
            this.A00 = xi2;
            xi2.A01(c1376Hz);
            return true;
        }
        if (!A05(bArr)) {
            return true;
        }
        XI xi3 = this.A00;
        if (A03[5].length() != 17) {
            throw new RuntimeException();
        }
        A03[1] = "qWJSCS9yuHod5mMI2FbA5J9U";
        if (xi3 != null) {
            xi3.A00(j11);
            c1251Cn.A01 = this.A00;
        }
        return false;
    }
}

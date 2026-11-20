package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class DF {
    public static byte[] A00;

    static {
        A02();
    }

    public static C1741Wl A00(InterfaceC1234Bt interfaceC1234Bt) throws InterruptedException, IOException {
        AbstractC1351Ha.A01(interfaceC1234Bt);
        C1376Hz c1376Hz = new C1376Hz(16);
        if (DE.A00(interfaceC1234Bt, c1376Hz).A00 != IF.A08(A01(111, 4, 112))) {
            return null;
        }
        int iA02 = 0;
        interfaceC1234Bt.ADv(c1376Hz.A00, 0, 4);
        c1376Hz.A0Y(0);
        int iA08 = c1376Hz.A08();
        int iA09 = IF.A08(A01(195, 4, 13));
        String strA01 = A01(199, 15, 13);
        if (iA08 != iA09) {
            Log.e(strA01, A01(115, 25, 27) + iA08);
            return null;
        }
        DE deA00 = DE.A00(interfaceC1234Bt, c1376Hz);
        while (deA00.A00 != IF.A08(A01(218, 4, 32))) {
            interfaceC1234Bt.A3W((int) deA00.A01);
            deA00 = DE.A00(interfaceC1234Bt, c1376Hz);
        }
        AbstractC1351Ha.A04(deA00.A01 >= 16);
        interfaceC1234Bt.ADv(c1376Hz.A00, 0, 16);
        c1376Hz.A0Y(0);
        int iA0C = c1376Hz.A0C();
        int iA0C2 = c1376Hz.A0C();
        int iA0B = c1376Hz.A0B();
        int iA0B2 = c1376Hz.A0B();
        int iA0C3 = c1376Hz.A0C();
        int iA0C4 = c1376Hz.A0C();
        int i11 = (iA0C2 * iA0C4) / 8;
        if (iA0C3 != i11) {
            throw new C11849v(A01(57, 26, 48) + i11 + A01(10, 7, 62) + iA0C3);
        }
        switch (iA0C) {
            case 1:
            case 65534:
                iA02 = IF.A02(iA0C4);
                break;
            case 3:
                if (iA0C4 == 32) {
                    iA02 = 4;
                }
                break;
            default:
                Log.e(strA01, A01(166, 29, 30) + iA0C);
                return null;
        }
        if (iA02 == 0) {
            Log.e(strA01, A01(140, 26, 101) + iA0C4 + A01(0, 10, 35) + iA0C);
            return null;
        }
        interfaceC1234Bt.A3W(((int) deA00.A01) - 16);
        return new C1741Wl(iA0C2, iA0B, iA0B2, iA0C3, iA0C4, iA02);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{39, 97, 104, 117, 39, 115, 126, 119, 98, 39, 33, 58, 125, 117, 110, 32, 58, 123, 80, 77, 86, 83, Ascii.CAN, 81, 75, Ascii.CAN, 76, 87, 87, Ascii.CAN, 84, 89, 74, 95, 93, Ascii.CAN, Ascii.DLE, 70, 10, Ascii.DEL, 122, 19, 17, Ascii.CAN, 76, 87, Ascii.CAN, 75, 83, 81, 72, 3, Ascii.CAN, 81, 92, 2, Ascii.CAN, 81, 108, 100, 113, 119, 96, 113, 112, 52, 118, 120, 123, 119, Ascii.DEL, 52, 117, 120, 125, 115, 122, 121, 113, 122, 96, 46, 52, 103, 73, 64, 65, 92, 71, 64, 73, Ascii.SO, 91, 64, 69, 64, 65, 89, 64, Ascii.SO, 121, 111, 120, Ascii.SO, 77, 70, 91, 64, 69, Ascii.DC4, Ascii.SO, 6, Ascii.GS, Ascii.DC2, Ascii.DC2, 106, 81, 76, 74, 79, 79, 80, 77, 75, 90, 91, Ascii.US, 109, 118, 121, 121, Ascii.US, 89, 80, 77, 82, 94, 75, 5, Ascii.US, Ascii.DC4, 47, 50, 52, 49, 49, 46, 51, 53, 36, 37, 97, Ascii.SYN, 0, Ascii.ETB, 97, 35, 40, 53, 97, 37, 36, 49, 53, 41, 97, 111, 84, 73, 79, 74, 74, 85, 72, 78, 95, 94, Ascii.SUB, 109, 123, 108, Ascii.SUB, 92, 85, 72, 87, 91, 78, Ascii.SUB, 78, 67, 74, 95, 0, Ascii.SUB, 126, 104, Ascii.DEL, 108, 126, 72, 95, 97, 76, 72, 77, 76, 91, 123, 76, 72, 77, 76, 91, 10, Ascii.SI, Ascii.SUB, Ascii.SI, 98, 105, 112, 36};
    }

    public static void A03(InterfaceC1234Bt interfaceC1234Bt, C1741Wl c1741Wl) throws InterruptedException, IOException {
        AbstractC1351Ha.A01(interfaceC1234Bt);
        AbstractC1351Ha.A01(c1741Wl);
        interfaceC1234Bt.AFM();
        C1376Hz c1376Hz = new C1376Hz(8);
        DE deA00 = DE.A00(interfaceC1234Bt, c1376Hz);
        while (deA00.A00 != IF.A08(A01(214, 4, 74))) {
            Log.w(A01(199, 15, 13), A01(83, 28, 10) + deA00.A00);
            long j11 = deA00.A01 + 8;
            if (deA00.A00 == IF.A08(A01(111, 4, 112))) {
                j11 = 12;
            }
            if (j11 > 2147483647L) {
                throw new C11849v(A01(17, 40, 28) + deA00.A00);
            }
            interfaceC1234Bt.AGP((int) j11);
            deA00 = DE.A00(interfaceC1234Bt, c1376Hz);
        }
        interfaceC1234Bt.AGP(8);
        c1741Wl.A06(interfaceC1234Bt.A7i(), deA00.A01);
    }
}

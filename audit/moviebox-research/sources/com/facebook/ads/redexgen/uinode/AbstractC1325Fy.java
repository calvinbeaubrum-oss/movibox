package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1325Fy {
    public static byte[] A00;
    public static String[] A01 = {"UAa0Z", "y84zlLC7EVblAi9s6IjzDwtWlv", "hWSmc3nAoC6lO20JdXQ8UQAJh4", "HAxIJdFwG2BHjJ6kBVBijNmfixc4v4eM", "sMFPtSIIwmEBUNkX5nfAspCddytOxG7k", "XuEZcwrwjFPAmN9wFCdffjeuCf3K5K0k", "0bJFkLVdjL4ExnLkyIfxNw93FYOhEgu9", "GtmYUKm65Uny9K5bn1TkELKUpeSnjSJ3"};
    public static final int A02;
    public static final int A03;

    static {
        A02();
        A03 = IF.A08(A01(11, 4, 88));
        A02 = IF.A08(A01(7, 4, 86));
    }

    public static int A00(C1376Hz c1376Hz) {
        int i11 = 0;
        while (c1376Hz.A04() != 0) {
            int iA0E = c1376Hz.A0E();
            i11 += iA0E;
            if (iA0E != 255) {
                return i11;
            }
        }
        if (A01[0].length() != 5) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[2] = "XY7JbweA6fzPXsut6MPl2wkiFN";
        strArr[1] = "9Cope1RtGoIRUkWui2tRq11YR8";
        return -1;
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{56, Ascii.RS, Ascii.SUB, 46, Ascii.SI, Ascii.DC2, Ascii.ETB, 37, 53, 38, 80, 40, 46, 86, 91, 108, 84, 86, 79, 79, 86, 81, 88, Ascii.US, 77, 90, 82, 94, 86, 81, 91, 90, 77, Ascii.US, 80, 89, Ascii.US, 82, 94, 83, 89, 80, 77, 82, 90, 91, Ascii.US, 108, 122, 118, Ascii.US, 113, 126, 115, Ascii.US, 74, 81, 86, 75, 17};
    }

    public static void A03(long j11, C1376Hz c1376Hz, C4[] c4Arr) {
        while (c1376Hz.A04() > 1) {
            int iA00 = A00(c1376Hz);
            int iA01 = A00(c1376Hz);
            int iA06 = c1376Hz.A06();
            if (A01[3].charAt(16) != 'B') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[4] = "sJRWMhzWyXWsYNwcYdMxu9waYeZJW4nD";
            strArr[5] = "JDck5DNLGL8VXNpOftdo1S17ghv9bSuy";
            int iA07 = iA06 + iA01;
            if (iA01 == -1 || iA01 > c1376Hz.A04()) {
                Log.w(A01(0, 7, 76), A01(15, 45, 8));
                iA07 = c1376Hz.A07();
            } else if (iA00 == 4 && iA01 >= 8) {
                int iA0E = c1376Hz.A0E();
                int iA0I = c1376Hz.A0I();
                int iA08 = iA0I == 49 ? c1376Hz.A08() : 0;
                int iA0E2 = c1376Hz.A0E();
                if (iA0I == 47) {
                    c1376Hz.A0Z(1);
                }
                boolean z11 = iA0E == 181 && (iA0I == 49 || iA0I == 47) && iA0E2 == 3;
                if (iA0I == 49) {
                    z11 &= iA08 == A03 || iA08 == A02;
                }
                if (z11) {
                    int iA0E3 = c1376Hz.A0E() & 31;
                    c1376Hz.A0Z(1);
                    int i11 = iA0E3 * 3;
                    int iA09 = c1376Hz.A06();
                    for (C4 c11 : c4Arr) {
                        c1376Hz.A0Y(iA09);
                        c11.AFR(c1376Hz, i11);
                        c11.AFS(j11, 1, i11, 0, null);
                    }
                }
            }
            c1376Hz.A0Y(iA07);
        }
    }
}

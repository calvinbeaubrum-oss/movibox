package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1240Cb {
    public static byte[] A00;
    public static String[] A01 = {"vniJFRP", "oJtPNZwcQG6hLH64wW6tXvk3sbQ9WwGW", "zry57w6QfhfaFpFxdZgKHC1xYn", "fo4QeY", "i9CLNlynjhorIFu8zs9NEh7lWGRKe1E6", "M5SbcVIJ6zX6bTvbAFwxovtl6mtBjy6T", "O1VKgn8XNf4GQEXWcT9RCCs6YBao3Pp0", "jcDd8FEzgCzhSc3FOh8Nko0kxmmUpCTh"};

    static {
        A03();
    }

    public static C1239Ca A00(byte[] bArr) {
        C1376Hz c1376Hz = new C1376Hz(bArr);
        if (c1376Hz.A07() < 32) {
            return null;
        }
        c1376Hz.A0Y(0);
        if (c1376Hz.A08() != c1376Hz.A04() + 4 || c1376Hz.A08() != CJ.A0s) {
            return null;
        }
        int iA01 = CJ.A01(c1376Hz.A08());
        if (iA01 > 1) {
            Log.w(A01(0, 12, 98), A01(12, 26, 36) + iA01);
            return null;
        }
        UUID uuid = new UUID(c1376Hz.A0L(), c1376Hz.A0L());
        if (iA01 == 1) {
            int iA0H = c1376Hz.A0H() * 16;
            if (A01[0].length() == 21) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "thpi9L";
            strArr[2] = "TMAT5NZ1bWTkNSNpNaLonMSfAF";
            c1376Hz.A0Z(iA0H);
        }
        int iA0H2 = c1376Hz.A0H();
        if (iA0H2 != c1376Hz.A04()) {
            return null;
        }
        byte[] bArr2 = new byte[iA0H2];
        c1376Hz.A0c(bArr2, 0, iA0H2);
        return new C1239Ca(uuid, iA01, bArr2);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static UUID A02(byte[] bArr) {
        C1239Ca c1239CaA00 = A00(bArr);
        if (c1239CaA00 == null) {
            return null;
        }
        return c1239CaA00.A01;
    }

    public static void A03() {
        A00 = new byte[]{-28, 7, 7, -4, -43, 8, 3, 1, -23, 8, -3, 0, -85, -60, -55, -53, -58, -58, -59, -56, -54, -69, -70, 118, -58, -55, -55, -66, 118, -52, -69, -56, -55, -65, -59, -60, -112, 118};
    }
}

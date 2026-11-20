package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1552Pa implements Runnable {
    public static byte[] A01;
    public static String[] A02 = {"uduF7y1C8f4BfvOCO4Bbq6znZfD289wY", "LfQQ99tGpIYoqROwWovpCF40OXz0xcCP", "pe2RdaJtvVEZmLt4Dkt9DCEmAABN", "zCkDdi8MMPMgBKhzCwwd8Y", "gpXsz89N0H7wm", "U57X7XmLFZehOxidvs2iHeLBOkC7", "VomEcvnoa3iVV8u", "uRkqt"};
    public final /* synthetic */ C11649a A00;

    static {
        A01();
    }

    public RunnableC1552Pa(C11649a c11649a) {
        this.A00 = c11649a;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {-28, -9, -14, -13, -3, -34, -6, -17, 7, -16, -17, -15, -7, -45, 0, 0, -3, 0};
        String[] strArr = A02;
        if (strArr[2].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[2] = "IRUmVXxJ3xpLtoKGmKUObZK1jjqw";
        strArr2[5] = "FvpPsD11YfGqSvfesnropeXaLbJS";
        A01 = bArr;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A00.A0X.ADX(A00(0, 18, 98));
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }
}

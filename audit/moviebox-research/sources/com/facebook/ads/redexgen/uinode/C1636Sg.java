package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1636Sg extends KT {
    public static byte[] A01;
    public static String[] A02 = {"aQtlI1Us5cYHMsIV", "ql6TdDFLVKaOF", "ILd0cBh", "B0sTrIURZDTgtQOqZ9wP44Me", "PUGSIMdaF2lm0BEktB", "ig45kctSq2tkP", "eb7l2wEenDPHh06UHeaR81tCSX", "F61vU5UciYvMkd8uRJU0Fm"};
    public final /* synthetic */ C9Q A00;

    static {
        A02();
    }

    public C1636Sg(C9Q c9q) {
        this.A00 = c9q;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[3].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            A02[7] = "csAIefbP6dEHufce3C5MSz";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 117);
            i14++;
        }
    }

    public static void A02() {
        A01 = new byte[]{67, 86, 81, 82, 92, Ascii.CR, 91, 82, 99, 82, 95, Ascii.CR, 96, 97, 78, 95, 97, 82, 81, Ascii.CR, 93, 89, 78, 102, 86, 91, 84};
    }

    @Override // com.facebook.ads.redexgen.uinode.KT
    public final void A06() {
        if (this.A00.A08) {
            return;
        }
        this.A00.A0G(A00(0, 27, 120));
    }
}

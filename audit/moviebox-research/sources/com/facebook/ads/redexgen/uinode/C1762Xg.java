package com.facebook.ads.redexgen.uinode;

import android.util.Pair;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1762Xg extends C6 {
    public static byte[] A03;
    public static String[] A04 = {"NGxGYCc4p5LcUzQMJWyw5DiDSRjOQe9F", "UCFVtk8FFiQwlTHXhlKlMorjx3xQRwUs", "gTYsvz0mqVjOzoMK", "3KonftsBU2Jf7i08alR6FL8DBvSTG56H", "D2cphfoCJeCyY12qt8LourkPjJ4neP20", "nKjfLlw2BnKut4cvipNa", "Z1RdCfwuszFRU44UcECPMtJ2BxVCI0wR", ""};
    public static final int[] A05;
    public int A00;
    public boolean A01;
    public boolean A02;

    static {
        A01();
        A05 = new int[]{5512, 11025, 22050, 44100};
    }

    public C1762Xg(C4 c11) {
        super(c11);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        int i14 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A04[6].charAt(5) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "nNsRewLEUEMjLhcIGLcqJY6DWywwxHcp";
            strArr[3] = "fafmuFk897DEXRggqTinAcDDyPNFBZka";
            if (i14 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 126);
            i14++;
        }
    }

    public static void A01() {
        A03 = new byte[]{39, 91, 74, 79, 85, 6, 76, 85, 88, 83, 71, 90, 6, 84, 85, 90, 6, 89, 91, 86, 86, 85, 88, 90, 75, 74, 32, 6, 48, 68, 51, 56, 62, -2, 54, 6, 0, 0, -4, 48, 59, 48, 70, -33, -13, -30, -25, -19, -83, -27, -75, -81, -81, -85, -21, -22, -33, -11, -24, -4, -21, -16, -10, -74, -12, -9, -69, -24, -76, -13, -24, -5, -12, 41, 61, 44, 49, 55, -9, 53, 56, 45, 47};
    }

    @Override // com.facebook.ads.redexgen.uinode.C6
    public final void A0B(C1376Hz c1376Hz, long j11) throws C11849v {
        if (this.A00 == 2) {
            int iA04 = c1376Hz.A04();
            super.A00.AFR(c1376Hz, iA04);
            super.A00.AFS(j11, 1, iA04, 0, null);
            return;
        }
        int iA0E = c1376Hz.A0E();
        if (A04[2].length() != 16) {
            throw new RuntimeException();
        }
        A04[7] = "";
        if (iA0E != 0 || this.A01) {
            if (this.A00 != 10 || iA0E == 1) {
                int iA05 = c1376Hz.A04();
                super.A00.AFR(c1376Hz, iA05);
                super.A00.AFS(j11, 1, iA05, 0, null);
                return;
            }
            return;
        }
        byte[] bArr = new byte[c1376Hz.A04()];
        c1376Hz.A0c(bArr, 0, bArr.length);
        Pair<Integer, Integer> pairA03 = AbstractC1355He.A03(bArr);
        super.A00.A5n(Format.A07(null, A00(58, 15, 9), null, -1, -1, ((Integer) pairA03.second).intValue(), ((Integer) pairA03.first).intValue(), Collections.singletonList(bArr), null, 0, null));
        this.A01 = true;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0086  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a2  */
    @Override // com.facebook.ads.redexgen.uinode.C6
    public final boolean A0C(C1376Hz c1376Hz) throws C1758Xc {
        int i11;
        if (this.A02) {
            if (A04[4].charAt(28) != 'G') {
                A04[1] = "XJizbdJnEvbAe8rCZCbZRYx6n8uD67e5";
                c1376Hz.A0Z(1);
                return true;
            }
            throw new RuntimeException();
        }
        int iA0E = c1376Hz.A0E();
        if (A04[2].length() == 16) {
            A04[5] = "dXuDB62giJCeOUzZyzuh";
            int i12 = (iA0E >> 4) & 15;
            this.A00 = i12;
            if (i12 == 2) {
                super.A00.A5n(Format.A07(null, A00(73, 10, 74), null, -1, -1, 1, A05[(iA0E >> 2) & 3], null, null, 0, null));
                this.A01 = true;
            } else if (i12 == 7 || i12 == 8) {
                String strA00 = i12 == 7 ? A00(28, 15, 81) : A00(43, 15, 0);
                int i13 = iA0E & 1;
                if (A04[1].charAt(9) != '8') {
                    A04[2] = "aabLL8EV5C3yGzSa";
                    if (i13 == 1) {
                        i11 = 2;
                    } else {
                        i11 = 3;
                    }
                } else if (i13 == 1) {
                    i11 = 2;
                } else {
                    i11 = 3;
                }
                super.A00.A5n(Format.A06(null, strA00, null, -1, -1, 1, 8000, i11, null, null, 0, null));
                this.A01 = true;
            } else if (i12 != 10) {
                throw new C1758Xc(A00(0, 28, 104) + this.A00);
            }
            this.A02 = true;
            return true;
        }
        throw new RuntimeException();
    }
}

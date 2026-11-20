package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1757Xb extends C6 {
    public static byte[] A05;
    public static String[] A06 = {"S6oix22WW3XrOL6PgcbxfAkEtHdPkPhf", "4OWz7hl1Zq8qyI8tM", "clV1g7mDIxTidmwZ1CuuG8s1lTi1VXAM", "4pPGx9", "ltKNubnfMHDxlo41G", "61sVTIAUswj0oFXzD6", "V6Pb0wOPN8cWCdQmqK9dHxyDUr6EkDd0", "qXRSabgl4tCI0bSRqPqCbhaUnodlSpfB"};
    public int A00;
    public int A01;
    public boolean A02;
    public final C1376Hz A03;
    public final C1376Hz A04;

    static {
        A01();
    }

    public C1757Xb(C4 c11) {
        super(c11);
        this.A04 = new C1376Hz(AbstractC1372Hv.A03);
        this.A03 = new C1376Hz(4);
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{71, 120, 117, 116, 126, 49, 119, 126, 99, 124, 112, 101, 49, Ascii.DEL, 126, 101, 49, 98, 100, 97, 97, 126, 99, 101, 116, 117, 43, 49, 39, 56, 53, 52, 62, 126, 48, 39, 50};
    }

    @Override // com.facebook.ads.redexgen.uinode.C6
    public final void A0B(C1376Hz c1376Hz, long j11) throws C11849v {
        int iA0E = c1376Hz.A0E();
        long jA09 = j11 + (((long) c1376Hz.A09()) * 1000);
        if (iA0E == 0 && !this.A02) {
            C1376Hz c1376Hz2 = new C1376Hz(new byte[c1376Hz.A04()]);
            c1376Hz.A0c(c1376Hz2.A00, 0, c1376Hz.A04());
            IH ihA00 = IH.A00(c1376Hz2);
            this.A01 = ihA00.A02;
            super.A00.A5n(Format.A03(null, A00(28, 9, Worker.WHAT_QUIT), null, -1, -1, ihA00.A03, ihA00.A01, -1.0f, ihA00.A04, -1, ihA00.A00, null));
            this.A02 = true;
            return;
        }
        if (iA0E == 1 && this.A02) {
            byte[] bArr = this.A03.A00;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i11 = 4 - this.A01;
            int i12 = 0;
            while (c1376Hz.A04() > 0) {
                c1376Hz.A0c(this.A03.A00, i11, this.A01);
                this.A03.A0Y(0);
                int iA0H = this.A03.A0H();
                this.A04.A0Y(0);
                super.A00.AFR(this.A04, 4);
                super.A00.AFR(c1376Hz, iA0H);
                i12 = i12 + 4 + iA0H;
            }
            super.A00.AFS(jA09, this.A00 != 1 ? 0 : 1, i12, 0, null);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C6
    public final boolean A0C(C1376Hz c1376Hz) throws C1758Xc {
        int iA0E = c1376Hz.A0E();
        int i11 = (iA0E >> 4) & 15;
        int i12 = iA0E & 15;
        if (i12 != 7) {
            throw new C1758Xc(A00(0, 28, 46) + i12);
        }
        this.A00 = i11;
        if (A06[2].charAt(25) == 'v') {
            throw new RuntimeException();
        }
        A06[5] = "9goNtADcrLhK1amHV7";
        return i11 != 5;
    }
}

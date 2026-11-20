package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class WO implements C4 {
    public static String[] A0F = {"J778k2tN1A71aNteuaiayf8W9Cwuw9", "SddvXAFvjaaaNZPS5hBFE72C4u8NAkzU", "DlS6L0Rs4yOHZbnixJzGuxf7gpgZ1", "jQlCDwUBXdtP", "ybgFHcAQFxf90xR6S9k4k72uXmSANsHZ", "TXMpPdQfareL1guTNfB0PsKfFvbJoTHv", "R2X9ywuliv1XsGmKXBlkokivcnsZ5nAf", "17XTwjN4yTPZEt52JUGlNgZMXTvW6CfX"};
    public long A00;
    public long A01;
    public Format A02;
    public Format A03;
    public F9 A04;
    public F9 A05;
    public F9 A06;
    public FA A07;
    public boolean A08;
    public boolean A09;
    public final int A0A;
    public final F7 A0B;
    public final F8 A0C;
    public final InterfaceC1338Gm A0D;
    public final C1376Hz A0E;

    public WO(InterfaceC1338Gm interfaceC1338Gm) {
        this.A0D = interfaceC1338Gm;
        int iA7D = interfaceC1338Gm.A7D();
        this.A0A = iA7D;
        this.A0C = new F8();
        this.A0B = new F7();
        this.A0E = new C1376Hz(32);
        F9 f11 = new F9(0L, iA7D);
        this.A04 = f11;
        this.A05 = f11;
        this.A06 = f11;
    }

    private int A00(int i11) {
        if (!this.A06.A02) {
            this.A06.A02(this.A0D.A3X(), new F9(this.A06.A03, this.A0A));
        }
        return Math.min(i11, (int) (this.A06.A03 - this.A01));
    }

    public static Format A01(Format format, long j11) {
        if (format == null) {
            return null;
        }
        if (A0F[5].charAt(18) == 'x') {
            throw new RuntimeException();
        }
        A0F[5] = "lOB1PW6jUN1Flr4ublIocLHYYSFUXZqB";
        return (j11 == 0 || format.A0G == Long.MAX_VALUE) ? format : format.A0H(format.A0G + j11);
    }

    private void A02(int i11) {
        long j11 = this.A01 + ((long) i11);
        this.A01 = j11;
        if (j11 == this.A06.A03) {
            this.A06 = this.A06.A00;
        }
    }

    private void A03(long j11) {
        while (j11 >= this.A05.A03) {
            this.A05 = this.A05.A00;
        }
    }

    private void A04(long j11) {
        if (j11 == -1) {
            return;
        }
        while (j11 >= this.A04.A03) {
            this.A0D.AEW(this.A04.A01);
            this.A04 = this.A04.A01();
        }
        if (this.A05.A04 < this.A04.A04) {
            this.A05 = this.A04;
        }
    }

    private void A05(long j11, ByteBuffer byteBuffer, int i11) {
        A03(j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (this.A05.A03 - j11));
            byteBuffer.put(this.A05.A01.A01, this.A05.A00(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            if (j11 == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A06(long j11, byte[] bArr, int i11) {
        A03(j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (this.A05.A03 - j11));
            System.arraycopy(this.A05.A01.A01, this.A05.A00(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            if (j11 == this.A05.A03) {
                this.A05 = this.A05.A00;
            }
        }
    }

    private void A07(C1773Xr c1773Xr, F7 f11) {
        int iA0I;
        long j11 = f11.A01;
        this.A0E.A0W(1);
        A06(j11, this.A0E.A00, 1);
        long j12 = j11 + 1;
        byte b11 = this.A0E.A00[0];
        boolean z11 = (b11 & 128) != 0;
        int i11 = b11 & Ascii.DEL;
        if (c1773Xr.A02.A04 == null) {
            c1773Xr.A02.A04 = new byte[16];
        }
        A06(j12, c1773Xr.A02.A04, i11);
        long j13 = j12 + ((long) i11);
        if (z11) {
            this.A0E.A0W(2);
            A06(j13, this.A0E.A00, 2);
            j13 += 2;
            iA0I = this.A0E.A0I();
        } else {
            iA0I = 1;
            if (A0F[4].charAt(3) != 'F') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "qfwCamou4xH4TsJy70kUYaPJ1paRPrQS";
            strArr[6] = "GMGbKrn5SK4TcHFeKaSIsaM2NwTeIDah";
        }
        int[] iArr = c1773Xr.A02.A06;
        if (iArr == null || iArr.length < iA0I) {
            iArr = new int[iA0I];
        }
        int[] iArr2 = c1773Xr.A02.A07;
        if (A0F[1].charAt(27) == 'T') {
            throw new RuntimeException();
        }
        A0F[3] = "l74rmj1cvzMl";
        if (iArr2 == null || iArr2.length < iA0I) {
            iArr2 = new int[iA0I];
            if (A0F[3].length() != 12) {
                A0F[5] = "mTjJh6O10GTQKtsNTzpZkGXCEgBidJyY";
            } else {
                String[] strArr2 = A0F;
                strArr2[2] = "gGnYbSzqov18WRGS84osGLTli7oQ4";
                strArr2[0] = "bcZjTvBd8pDqGicoFFRFmeT3NfcxuZ";
            }
        }
        if (z11) {
            int i12 = iA0I * 6;
            this.A0E.A0W(i12);
            A06(j13, this.A0E.A00, i12);
            j13 += (long) i12;
            this.A0E.A0Y(0);
            for (int i13 = 0; i13 < iA0I; i13++) {
                iArr[i13] = this.A0E.A0I();
                iArr2[i13] = this.A0E.A0H();
            }
        } else {
            iArr[0] = 0;
            iArr2[0] = f11.A00 - ((int) (j13 - f11.A01));
        }
        C3 c11 = f11.A02;
        c1773Xr.A02.A03(iA0I, iArr, iArr2, c11.A03, c1773Xr.A02.A04, c11.A01, c11.A02, c11.A00);
        int i14 = (int) (j13 - f11.A01);
        f11.A01 += (long) i14;
        f11.A00 -= i14;
    }

    private void A08(F9 f11) {
        if (f11.A02) {
            boolean z11 = this.A06.A02;
            int i11 = (z11 ? 1 : 0) + (((int) (this.A06.A04 - f11.A04)) / this.A0A);
            if (A0F[5].charAt(18) == 'x') {
                throw new RuntimeException();
            }
            A0F[1] = "iejtrz5gn5ypfg4If5spWIciPKrb2ZMM";
            C1337Gl[] c1337GlArr = new C1337Gl[i11];
            for (int i12 = 0; i12 < c1337GlArr.length; i12++) {
                c1337GlArr[i12] = f11.A01;
                f11 = f11.A01();
            }
            this.A0D.AEX(c1337GlArr);
        }
    }

    private final void A09(boolean z11) {
        this.A0C.A0H(z11);
        A08(this.A04);
        F9 f11 = new F9(0L, this.A0A);
        this.A04 = f11;
        this.A05 = f11;
        this.A06 = f11;
        this.A01 = 0L;
        this.A0D.AGj();
    }

    public final int A0A() {
        return this.A0C.A07();
    }

    public final int A0B() {
        return this.A0C.A05();
    }

    public final int A0C() {
        return this.A0C.A06();
    }

    public final int A0D(long j11, boolean z11, boolean z12) {
        return this.A0C.A08(j11, z11, z12);
    }

    public final int A0E(C11789p c11789p, C1773Xr c1773Xr, boolean z11, boolean z12, long j11) {
        switch (this.A0C.A09(c11789p, c1773Xr, z11, z12, this.A02, this.A0B)) {
            case C.RESULT_FORMAT_READ /* -5 */:
                this.A02 = c11789p.A00;
                return -5;
            case C.RESULT_BUFFER_READ /* -4 */:
                if (c1773Xr.A04()) {
                    return -4;
                }
                if (c1773Xr.A00 < j11) {
                    String[] strArr = A0F;
                    if (strArr[2].length() == strArr[0].length()) {
                        throw new RuntimeException();
                    }
                    A0F[3] = "3oC8GcXqxYNt";
                    c1773Xr.A00(Integer.MIN_VALUE);
                }
                if (c1773Xr.A0A()) {
                    A07(c1773Xr, this.A0B);
                }
                c1773Xr.A09(this.A0B.A00);
                A05(this.A0B.A01, c1773Xr.A01, this.A0B.A00);
                return -4;
            case C.RESULT_NOTHING_READ /* -3 */:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A0F() {
        return this.A0C.A0B();
    }

    public final Format A0G() {
        return this.A0C.A0E();
    }

    public final void A0H() {
        A04(this.A0C.A0A());
    }

    public final void A0I() {
        A09(false);
    }

    public final void A0J() {
        this.A0C.A0F();
        this.A05 = this.A04;
    }

    public final void A0K(long j11, boolean z11, boolean z12) {
        A04(this.A0C.A0D(j11, z11, z12));
    }

    public final void A0L(FA fa2) {
        this.A07 = fa2;
    }

    public final boolean A0M() {
        return this.A0C.A0I();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void A5n(Format format) {
        Format formatA01 = A01(format, this.A00);
        boolean zA0K = this.A0C.A0K(formatA01);
        this.A03 = format;
        this.A08 = false;
        FA fa2 = this.A07;
        if (fa2 == null || !zA0K) {
            return;
        }
        fa2.ADS(formatA01);
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final int AFQ(InterfaceC1234Bt interfaceC1234Bt, int i11, boolean z11) throws InterruptedException, IOException {
        int i12 = interfaceC1234Bt.read(this.A06.A01.A01, this.A06.A00(this.A01), A00(i11));
        if (i12 != -1) {
            A02(i12);
            return i12;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void AFR(C1376Hz c1376Hz, int i11) {
        while (i11 > 0) {
            int iA00 = A00(i11);
            c1376Hz.A0c(this.A06.A01.A01, this.A06.A00(this.A01), iA00);
            i11 -= iA00;
            A02(iA00);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C4
    public final void AFS(long j11, int i11, int i12, int i13, C3 c11) {
        if (this.A08) {
            A5n(this.A03);
        }
        if (this.A09) {
            if ((i11 & 1) == 0 || !this.A0C.A0J(j11)) {
                return;
            } else {
                this.A09 = false;
            }
        }
        this.A0C.A0G(j11 + this.A00, i11, (this.A01 - ((long) i12)) - ((long) i13), i12, c11);
    }
}

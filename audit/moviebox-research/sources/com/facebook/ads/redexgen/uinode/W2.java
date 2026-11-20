package com.facebook.ads.redexgen.uinode;

import com.applovin.exoplayer2.common.base.Ascii;
import com.transsion.gslb.Worker;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W2 implements InterfaceC1338Gm {
    public static byte[] A08;
    public int A00;
    public int A01;
    public int A02;
    public C1337Gl[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final C1337Gl[] A07;

    static {
        A01();
    }

    public W2(boolean z11, int i11) {
        this(z11, i11, 0);
    }

    public W2(boolean z11, int i11, int i12) {
        AbstractC1351Ha.A03(i11 > 0);
        AbstractC1351Ha.A03(i12 >= 0);
        this.A05 = z11;
        this.A04 = i11;
        this.A01 = i12;
        this.A03 = new C1337Gl[i12 + 100];
        if (i12 > 0) {
            this.A06 = new byte[i12 * i11];
            for (int i13 = 0; i13 < i12; i13++) {
                this.A03[i13] = new C1337Gl(this.A06, i13 * i11);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new C1337Gl[1];
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{100, 104, 40, 19, Ascii.CAN, 5, Ascii.CR, Ascii.CAN, Ascii.RS, 9, Ascii.CAN, Ascii.EM, 93, Ascii.FS, 17, 17, Ascii.DC2, Ascii.RS, Ascii.FS, 9, Ascii.DC4, Ascii.DC2, 19, 71, 93};
    }

    public final synchronized int A02() {
        return this.A00 * this.A04;
    }

    public final synchronized void A03() {
        if (this.A05) {
            A04(0);
        }
    }

    public final synchronized void A04(int i11) {
        boolean z11 = i11 < this.A02;
        this.A02 = i11;
        if (z11) {
            AGj();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1338Gm
    public final synchronized C1337Gl A3X() {
        C1337Gl c1337Gl;
        this.A00++;
        int i11 = this.A01;
        if (i11 > 0) {
            C1337Gl[] c1337GlArr = this.A03;
            int i12 = i11 - 1;
            this.A01 = i12;
            c1337Gl = c1337GlArr[i12];
            c1337GlArr[i12] = null;
        } else {
            c1337Gl = new C1337Gl(new byte[this.A04], 0);
        }
        return c1337Gl;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1338Gm
    public final int A7D() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1338Gm
    public final synchronized void AEW(C1337Gl c1337Gl) {
        C1337Gl[] c1337GlArr = this.A07;
        c1337GlArr[0] = c1337Gl;
        AEX(c1337GlArr);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1338Gm
    public final synchronized void AEX(C1337Gl[] c1337GlArr) {
        int i11 = this.A01;
        int length = c1337GlArr.length + i11;
        C1337Gl[] c1337GlArr2 = this.A03;
        if (length >= c1337GlArr2.length) {
            this.A03 = (C1337Gl[]) Arrays.copyOf(c1337GlArr2, Math.max(c1337GlArr2.length * 2, i11 + c1337GlArr.length));
        }
        for (C1337Gl c1337Gl : c1337GlArr) {
            if (c1337Gl.A01 != this.A06 && c1337Gl.A01.length != this.A04) {
                throw new IllegalArgumentException(A00(2, 23, Worker.WHAT_QUIT) + System.identityHashCode(c1337Gl.A01) + A00(0, 2, 91) + System.identityHashCode(this.A06) + A00(0, 2, 91) + c1337Gl.A01.length + A00(0, 2, 91) + this.A04);
            }
            C1337Gl[] c1337GlArr3 = this.A03;
            int i12 = this.A01;
            this.A01 = i12 + 1;
            c1337GlArr3[i12] = c1337Gl;
        }
        this.A00 -= c1337GlArr.length;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1338Gm
    public final synchronized void AGj() {
        int iMax = Math.max(0, IF.A04(this.A02, this.A04) - this.A00);
        int i11 = this.A01;
        if (iMax >= i11) {
            return;
        }
        if (this.A06 != null) {
            int i12 = 0;
            int i13 = i11 - 1;
            while (i12 <= i13) {
                C1337Gl c1337Gl = this.A03[i12];
                if (c1337Gl.A01 == this.A06) {
                    i12++;
                } else {
                    C1337Gl c1337Gl2 = this.A03[i13];
                    if (c1337Gl2.A01 != this.A06) {
                        i13--;
                    } else {
                        C1337Gl[] c1337GlArr = this.A03;
                        c1337GlArr[i12] = c1337Gl2;
                        c1337GlArr[i13] = c1337Gl;
                        i13--;
                        i12++;
                    }
                }
            }
            iMax = Math.max(iMax, i12);
            if (iMax >= this.A01) {
                return;
            }
        }
        Arrays.fill(this.A03, iMax, this.A01, (Object) null);
        this.A01 = iMax;
    }
}

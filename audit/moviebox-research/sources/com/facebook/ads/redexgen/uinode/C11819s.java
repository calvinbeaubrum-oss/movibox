package com.facebook.ads.redexgen.uinode;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.thirdparty.source.TrackGroupArray;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11819s {
    public static byte[] A0F;
    public long A00;
    public C11819s A01;
    public C11829t A02;
    public TrackGroupArray A03;
    public C1336Gk A04;
    public boolean A05;
    public boolean A06;
    public C1336Gk A07;
    public final WP A08;
    public final Object A09;
    public final FB[] A0A;
    public final boolean[] A0B;
    public final InterfaceC1293Eq A0C;
    public final AbstractC1335Gj A0D;
    public final AA[] A0E;

    static {
        A01();
    }

    public C11819s(AA[] aaArr, long j11, AbstractC1335Gj abstractC1335Gj, InterfaceC1338Gm interfaceC1338Gm, InterfaceC1293Eq interfaceC1293Eq, Object obj, C11829t c11829t) {
        this.A0E = aaArr;
        this.A00 = j11 - c11829t.A03;
        this.A0D = abstractC1335Gj;
        this.A0C = interfaceC1293Eq;
        this.A09 = AbstractC1351Ha.A01(obj);
        this.A02 = c11829t;
        this.A0A = new FB[aaArr.length];
        this.A0B = new boolean[aaArr.length];
        WP wpA4k = interfaceC1293Eq.A4k(c11829t.A04, interfaceC1338Gm);
        this.A08 = c11829t.A02 != Long.MIN_VALUE ? new CI(wpA4k, true, 0L, c11829t.A02) : wpA4k;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 30);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0F = new byte[]{79, 103, 102, 107, 99, 82, 103, 112, 107, 109, 102, 74, 109, 110, 102, 103, 112, 81, 100, 115, 104, 110, 101, 33, 115, 100, 109, 100, 96, 114, 100, 33, 103, 96, 104, 109, 100, 101, 47};
    }

    private void A02(C1336Gk c1336Gk) {
        for (int i11 = 0; i11 < c1336Gk.A00; i11++) {
            boolean zA00 = c1336Gk.A00(i11);
            InterfaceC1332Gg interfaceC1332GgA00 = c1336Gk.A01.A00(i11);
            if (zA00 && interfaceC1332GgA00 != null) {
                interfaceC1332GgA00.A5U();
            }
        }
    }

    private void A03(C1336Gk c1336Gk) {
        C1336Gk c1336Gk2 = this.A07;
        this.A07 = c1336Gk;
        if (c1336Gk != null) {
            A02(c1336Gk);
        }
    }

    private void A04(FB[] fbArr) {
        int i11 = 0;
        while (true) {
            AA[] aaArr = this.A0E;
            if (i11 >= aaArr.length) {
                return;
            }
            if (aaArr[i11].A8C() == 5 && this.A04.A00(i11)) {
                fbArr[i11] = new WU();
            }
            i11++;
        }
    }

    private void A05(FB[] fbArr) {
        int i11 = 0;
        while (true) {
            AA[] aaArr = this.A0E;
            if (i11 >= aaArr.length) {
                return;
            }
            if (aaArr[i11].A8C() == 5) {
                fbArr[i11] = null;
            }
            i11++;
        }
    }

    public final long A06() {
        if (this.A06) {
            return this.A08.A7U();
        }
        return 0L;
    }

    public final long A07() {
        return this.A00;
    }

    public final long A08(long j11) {
        return j11 - A07();
    }

    public final long A09(long j11) {
        return A07() + j11;
    }

    public final long A0A(long j11, boolean z11) {
        return A0B(j11, z11, new boolean[this.A0E.length]);
    }

    public final long A0B(long j11, boolean z11, boolean[] zArr) {
        int i11 = 0;
        while (true) {
            boolean z12 = false;
            if (i11 >= this.A04.A00) {
                break;
            }
            boolean[] zArr2 = this.A0B;
            if (!z11 && this.A04.A02(this.A07, i11)) {
                z12 = true;
            }
            zArr2[i11] = z12;
            i11++;
        }
        A05(this.A0A);
        A03(this.A04);
        C1333Gh c1333Gh = this.A04.A01;
        long jAFm = this.A08.AFm(c1333Gh.A01(), this.A0B, this.A0A, zArr, j11);
        A04(this.A0A);
        this.A05 = false;
        int i12 = 0;
        while (true) {
            FB[] fbArr = this.A0A;
            if (i12 >= fbArr.length) {
                return jAFm;
            }
            if (fbArr[i12] != null) {
                AbstractC1351Ha.A04(this.A04.A00(i12));
                if (this.A0E[i12].A8C() != 5) {
                    this.A05 = true;
                }
            } else {
                AbstractC1351Ha.A04(c1333Gh.A00(i12) == null);
            }
            i12++;
        }
    }

    public final long A0C(boolean z11) {
        if (!this.A06) {
            return this.A02.A03;
        }
        long jA6D = this.A08.A6D();
        return (jA6D == Long.MIN_VALUE && z11) ? this.A02.A01 : jA6D;
    }

    public final void A0D() {
        A03(null);
        try {
            if (this.A02.A02 != Long.MIN_VALUE) {
                this.A0C.AEa(((CI) this.A08).A05);
            } else {
                this.A0C.AEa(this.A08);
            }
        } catch (RuntimeException e11) {
            Log.e(A00(0, 17, 28), A00(17, 22, 31), e11);
        }
    }

    public final void A0E(float f11) throws C11669c {
        this.A06 = true;
        this.A03 = this.A08.A8B();
        A0I(f11);
        long jA0A = A0A(this.A02.A03, false);
        this.A00 += this.A02.A03 - jA0A;
        this.A02 = this.A02.A01(jA0A);
    }

    public final void A0F(long j11) {
        this.A08.A4T(A08(j11));
    }

    public final void A0G(long j11) {
        if (this.A06) {
            this.A08.AER(A08(j11));
        }
    }

    public final boolean A0H() {
        return this.A06 && (!this.A05 || this.A08.A6D() == Long.MIN_VALUE);
    }

    public final boolean A0I(float f11) throws C11669c {
        C1336Gk c1336GkA0T = this.A0D.A0T(this.A0E, this.A03);
        if (c1336GkA0T.A01(this.A07)) {
            return false;
        }
        this.A04 = c1336GkA0T;
        for (InterfaceC1332Gg interfaceC1332Gg : c1336GkA0T.A01.A01()) {
            if (interfaceC1332Gg != null) {
                interfaceC1332Gg.ACc(f11);
            }
        }
        return true;
    }
}

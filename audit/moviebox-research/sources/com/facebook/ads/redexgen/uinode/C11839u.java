package com.facebook.ads.redexgen.uinode;

import android.util.Pair;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C11839u {
    public static String[] A0C = {"Lb1", "HAO", "yCHPPE9w0w81YCKuxFE6L9DmrxkJ2tU0", "DWgdxvM8Y7BV8jWWEqdgbbwmU3UKZQmt", "Bgm", "OOw1FrSehBTCipzYy8xUBx5", "Tcr4i3yvYCwS9F", "vvoyvovICPFY35FJOKkJE7b"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public C11819s A04;
    public C11819s A05;
    public C11819s A06;
    public AH A07;
    public Object A08;
    public boolean A09;
    public final AF A0A = new AF();
    public final AG A0B = new AG();

    private long A00(int i11) {
        int iA04;
        Object obj = this.A07.A0A(i11, this.A0A, true).A03;
        int i12 = this.A0A.A00;
        Object obj2 = this.A08;
        if (obj2 != null && (iA04 = this.A07.A04(obj2)) != -1 && this.A07.A09(iA04, this.A0A).A00 == i12) {
            return this.A03;
        }
        for (C11819s c11819sA0E = A0E(); c11819sA0E != null; c11819sA0E = c11819sA0E.A01) {
            if (c11819sA0E.A09.equals(obj)) {
                return c11819sA0E.A02.A04.A03;
            }
        }
        for (C11819s c11819sA0E2 = A0E(); c11819sA0E2 != null; c11819sA0E2 = c11819sA0E2.A01) {
            int iA05 = this.A07.A04(c11819sA0E2.A09);
            if (iA05 != -1 && this.A07.A09(iA05, this.A0A).A00 == i12) {
                return c11819sA0E2.A02.A04.A03;
            }
        }
        long j11 = this.A02;
        this.A02 = 1 + j11;
        return j11;
    }

    private C11829t A01(int i11, int i12, int i13, long j11, long j12) {
        C1291Eo c1291Eo = new C1291Eo(i11, i12, i13, j12);
        boolean zA0A = A0A(c1291Eo, Long.MIN_VALUE);
        boolean zA0B = A0B(c1291Eo, zA0A);
        return new C11829t(c1291Eo, i13 == this.A0A.A02(i12) ? this.A0A.A06() : 0L, Long.MIN_VALUE, j11, this.A07.A09(c1291Eo.A02, this.A0A).A0A(c1291Eo.A00, c1291Eo.A01), zA0A, zA0B);
    }

    private C11829t A02(int i11, long j11, long j12) {
        C1291Eo c1291Eo = new C1291Eo(i11, j12);
        this.A07.A09(c1291Eo.A02, this.A0A);
        int iA04 = this.A0A.A04(j11);
        long jA09 = iA04 == -1 ? Long.MIN_VALUE : this.A0A.A09(iA04);
        boolean zA0A = A0A(c1291Eo, jA09);
        return new C11829t(c1291Eo, j11, jA09, C.TIME_UNSET, jA09 == Long.MIN_VALUE ? this.A0A.A07() : jA09, zA0A, A0B(c1291Eo, zA0A));
    }

    private C11829t A03(C11819s c11819s, long j11) {
        long jLongValue;
        C11829t c11829t = c11819s.A02;
        if (c11829t.A06) {
            int iA03 = this.A07.A03(c11829t.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            if (iA03 == -1) {
                return null;
            }
            int i11 = this.A07.A0A(iA03, this.A0A, true).A00;
            Object obj = this.A0A.A03;
            long j12 = c11829t.A04.A03;
            if (this.A07.A0B(i11, this.A0B).A00 == iA03) {
                Pair<Integer, Long> pairA08 = this.A07.A08(this.A0B, this.A0A, i11, C.TIME_UNSET, Math.max(0L, (c11819s.A07() + c11829t.A01) - j11));
                if (pairA08 == null) {
                    return null;
                }
                iA03 = ((Integer) pairA08.first).intValue();
                jLongValue = ((Long) pairA08.second).longValue();
                if (c11819s.A01 == null || !c11819s.A01.A09.equals(obj)) {
                    j12 = this.A02;
                    this.A02 = j12 + 1;
                } else {
                    j12 = c11819s.A01.A02.A04.A03;
                    String[] strArr = A0C;
                    if (strArr[5].length() == strArr[7].length()) {
                        String[] strArr2 = A0C;
                        strArr2[4] = "1Mi";
                        strArr2[1] = "4wM";
                    }
                }
            } else {
                jLongValue = 0;
            }
            return A06(A07(iA03, jLongValue, j12), jLongValue, jLongValue);
        }
        C1291Eo c1291Eo = c11829t.A04;
        this.A07.A09(c1291Eo.A02, this.A0A);
        if (c1291Eo.A01()) {
            int i12 = c1291Eo.A00;
            int iA01 = this.A0A.A01(i12);
            if (iA01 == -1) {
                return null;
            }
            int iA04 = this.A0A.A03(i12, c1291Eo.A01);
            if (iA04 >= iA01) {
                return A02(c1291Eo.A02, c11829t.A00, c1291Eo.A03);
            }
            if (this.A0A.A0E(i12, iA04)) {
                return A01(c1291Eo.A02, i12, iA04, c11829t.A00, c1291Eo.A03);
            }
            return null;
        }
        long j13 = c11829t.A02;
        String[] strArr3 = A0C;
        if (strArr3[6].length() == strArr3[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0C;
        strArr4[4] = "Mkh";
        strArr4[1] = "LRN";
        if (j13 != Long.MIN_VALUE) {
            int iA05 = this.A0A.A05(c11829t.A02);
            if (iA05 == -1) {
                return A02(c1291Eo.A02, c11829t.A02, c1291Eo.A03);
            }
            int iA02 = this.A0A.A02(iA05);
            if (this.A0A.A0E(iA05, iA02)) {
                return A01(c1291Eo.A02, iA05, iA02, c11829t.A02, c1291Eo.A03);
            }
            return null;
        }
        int iA00 = this.A0A.A00();
        if (iA00 == 0) {
            return null;
        }
        int i13 = iA00 - 1;
        if (this.A0A.A09(i13) == Long.MIN_VALUE) {
            AF af2 = this.A0A;
            if (A0C[3].charAt(17) == 'q') {
                String[] strArr5 = A0C;
                strArr5[6] = "v4RqMCCMyohjhj";
                strArr5[0] = "VaJ";
                if (!af2.A0D(i13)) {
                    int iA06 = this.A0A.A02(i13);
                    if (!this.A0A.A0E(i13, iA06)) {
                        String[] strArr6 = A0C;
                        if (strArr6[6].length() == strArr6[0].length()) {
                            return null;
                        }
                        A0C[2] = "nHRVyYi6CwR1mKhXGjDN4SEBRB6Sc1lP";
                        return null;
                    }
                    long jA07 = this.A0A.A07();
                    int i14 = c1291Eo.A02;
                    String[] strArr7 = A0C;
                    if (strArr7[5].length() != strArr7[7].length()) {
                        throw new RuntimeException();
                    }
                    A0C[2] = "rKR9SUNE0wWlvttO7fw3rD4zdQIUaCm2";
                    return A01(i14, i13, iA06, jA07, c1291Eo.A03);
                }
            }
        }
        if (A0C[2].charAt(9) != 'w') {
            return null;
        }
        String[] strArr8 = A0C;
        strArr8[6] = "OaXxy4ZAPPYV9k";
        strArr8[0] = "tU4";
        return null;
        throw new RuntimeException();
    }

    private C11829t A04(C11829t c11829t, C1291Eo c1291Eo) {
        long jA07;
        long j11 = c11829t.A03;
        long j12 = c11829t.A02;
        boolean zA0A = A0A(c1291Eo, j12);
        boolean zA0B = A0B(c1291Eo, zA0A);
        this.A07.A09(c1291Eo.A02, this.A0A);
        if (c1291Eo.A01()) {
            jA07 = this.A0A.A0A(c1291Eo.A00, c1291Eo.A01);
        } else {
            jA07 = j12 == Long.MIN_VALUE ? this.A0A.A07() : j12;
        }
        return new C11829t(c1291Eo, j11, j12, c11829t.A00, jA07, zA0A, zA0B);
    }

    private C11829t A05(C11859w c11859w) {
        return A06(c11859w.A04, c11859w.A01, c11859w.A02);
    }

    private C11829t A06(C1291Eo c1291Eo, long j11, long j12) {
        this.A07.A09(c1291Eo.A02, this.A0A);
        if (!c1291Eo.A01()) {
            return A02(c1291Eo.A02, j12, c1291Eo.A03);
        }
        if (this.A0A.A0E(c1291Eo.A00, c1291Eo.A01)) {
            return A01(c1291Eo.A02, c1291Eo.A00, c1291Eo.A01, j11, c1291Eo.A03);
        }
        return null;
    }

    private C1291Eo A07(int i11, long j11, long j12) {
        this.A07.A09(i11, this.A0A);
        int iA05 = this.A0A.A05(j11);
        return iA05 == -1 ? new C1291Eo(i11, j12) : new C1291Eo(i11, iA05, this.A0A.A02(iA05), j12);
    }

    private boolean A08() {
        C11819s c11819sA0E = A0E();
        if (c11819sA0E == null) {
            return true;
        }
        while (true) {
            int iA03 = this.A07.A03(c11819sA0E.A02.A04.A02, this.A0A, this.A0B, this.A01, this.A09);
            while (c11819sA0E.A01 != null && !c11819sA0E.A02.A06) {
                c11819sA0E = c11819sA0E.A01;
            }
            if (iA03 == -1 || c11819sA0E.A01 == null) {
                break;
            }
            int i11 = c11819sA0E.A01.A02.A04.A02;
            if (A0C[3].charAt(17) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[4] = "04e";
            strArr[1] = "fTm";
            if (i11 != iA03) {
                break;
            }
            c11819sA0E = c11819sA0E.A01;
        }
        boolean zA0S = A0S(c11819sA0E);
        c11819sA0E.A02 = A04(c11819sA0E.A02, c11819sA0E.A02.A04);
        return (zA0S && A0P()) ? false : true;
    }

    private boolean A09(C11819s c11819s, C11829t c11829t) {
        C11829t c11829t2 = c11819s.A02;
        return c11829t2.A03 == c11829t.A03 && c11829t2.A02 == c11829t.A02 && c11829t2.A04.equals(c11829t.A04);
    }

    private boolean A0A(C1291Eo c1291Eo, long j11) {
        int iA00 = this.A07.A09(c1291Eo.A02, this.A0A).A00();
        if (iA00 == 0) {
            return true;
        }
        int i11 = iA00 - 1;
        boolean zA01 = c1291Eo.A01();
        if (this.A0A.A09(i11) != Long.MIN_VALUE) {
            return !zA01 && j11 == Long.MIN_VALUE;
        }
        int iA01 = this.A0A.A01(i11);
        if (A0C[3].charAt(17) != 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "dZB";
        strArr[1] = "bbK";
        if (iA01 == -1) {
            return false;
        }
        if (zA01 && c1291Eo.A00 == i11 && c1291Eo.A01 == iA01 + (-1)) {
            return true;
        }
        return !zA01 && this.A0A.A02(i11) == iA01;
    }

    private boolean A0B(C1291Eo c1291Eo, boolean z11) {
        return !this.A07.A0B(this.A07.A09(c1291Eo.A02, this.A0A).A00, this.A0B).A08 && this.A07.A0F(c1291Eo.A02, this.A0A, this.A0B, this.A01, this.A09) && z11;
    }

    public final C11819s A0C() {
        C11819s c11819s = this.A05;
        if (c11819s != null) {
            if (c11819s == this.A06) {
                this.A06 = c11819s.A01;
            }
            this.A05.A0D();
            int i11 = this.A00 - 1;
            this.A00 = i11;
            if (i11 == 0) {
                this.A04 = null;
                this.A08 = this.A05.A09;
                this.A03 = this.A05.A02.A04.A03;
            }
            C11819s c11819s2 = this.A05.A01;
            if (A0C[3].charAt(17) != 'q') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[5] = "umGBE5C5CuHWhY73AVgogVf";
            strArr[7] = "vM8t2ZsrAby17UFg4572Zd2";
            this.A05 = c11819s2;
        } else {
            C11819s c11819s3 = this.A04;
            this.A05 = c11819s3;
            this.A06 = c11819s3;
        }
        return this.A05;
    }

    public final C11819s A0D() {
        C11819s c11819s = this.A06;
        AbstractC1351Ha.A04((c11819s == null || c11819s.A01 == null) ? false : true);
        C11819s c11819s2 = this.A06.A01;
        this.A06 = c11819s2;
        return c11819s2;
    }

    public final C11819s A0E() {
        return A0P() ? this.A05 : this.A04;
    }

    public final C11819s A0F() {
        return this.A04;
    }

    public final C11819s A0G() {
        return this.A05;
    }

    public final C11819s A0H() {
        return this.A06;
    }

    public final C11829t A0I(long j11, C11859w c11859w) {
        C11819s c11819s = this.A04;
        return c11819s == null ? A05(c11859w) : A03(c11819s, j11);
    }

    public final C11829t A0J(C11829t c11829t, int i11) {
        return A04(c11829t, c11829t.A04.A00(i11));
    }

    public final WP A0K(AA[] aaArr, AbstractC1335Gj abstractC1335Gj, InterfaceC1338Gm interfaceC1338Gm, InterfaceC1293Eq interfaceC1293Eq, Object obj, C11829t c11829t) {
        long jA07;
        C11819s c11819s = this.A04;
        if (c11819s == null) {
            jA07 = c11829t.A03;
        } else {
            jA07 = c11819s.A07() + this.A04.A02.A01;
            String[] strArr = A0C;
            if (strArr[6].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[5] = "XFCrwzIN7SxWEMf0fznSlHt";
            strArr2[7] = "zDOSpelqL3O1zvPqWZMR4dG";
        }
        C11819s c11819s2 = new C11819s(aaArr, jA07, abstractC1335Gj, interfaceC1338Gm, interfaceC1293Eq, obj, c11829t);
        if (this.A04 != null) {
            AbstractC1351Ha.A04(A0P());
            this.A04.A01 = c11819s2;
        }
        this.A08 = null;
        this.A04 = c11819s2;
        this.A00++;
        return c11819s2.A08;
    }

    public final C1291Eo A0L(int i11, long j11) {
        return A07(i11, j11, A00(i11));
    }

    public final void A0M(long j11) {
        C11819s c11819s = this.A04;
        if (c11819s != null) {
            c11819s.A0G(j11);
        }
    }

    public final void A0N(AH ah2) {
        this.A07 = ah2;
    }

    public final void A0O(boolean z11) {
        C11819s c11819sA0E = A0E();
        if (c11819sA0E != null) {
            this.A08 = z11 ? c11819sA0E.A09 : null;
            this.A03 = c11819sA0E.A02.A04.A03;
            c11819sA0E.A0D();
            A0S(c11819sA0E);
        } else if (!z11) {
            this.A08 = null;
        }
        this.A05 = null;
        this.A04 = null;
        this.A06 = null;
        this.A00 = 0;
    }

    public final boolean A0P() {
        return this.A05 != null;
    }

    public final boolean A0Q() {
        C11819s c11819s = this.A04;
        return c11819s == null || (!c11819s.A02.A05 && this.A04.A0H() && this.A04.A02.A01 != C.TIME_UNSET && this.A00 < 100);
    }

    public final boolean A0R(int i11) {
        this.A01 = i11;
        return A08();
    }

    public final boolean A0S(C11819s c11819s) {
        AbstractC1351Ha.A04(c11819s != null);
        boolean z11 = false;
        String[] strArr = A0C;
        if (strArr[4].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[4] = "VEc";
        strArr2[1] = "0t0";
        this.A04 = c11819s;
        while (c11819s.A01 != null) {
            c11819s = c11819s.A01;
            if (c11819s == this.A06) {
                this.A06 = this.A05;
                z11 = true;
            }
            c11819s.A0D();
            this.A00--;
        }
        this.A04.A01 = null;
        return z11;
    }

    public final boolean A0T(WP wp2) {
        C11819s c11819s = this.A04;
        return c11819s != null && c11819s.A08 == wp2;
    }

    public final boolean A0U(C1291Eo c1291Eo, long j11) {
        int iA03 = c1291Eo.A02;
        C11819s c11819s = null;
        for (C11819s c11819sA0E = A0E(); c11819sA0E != null; c11819sA0E = c11819sA0E.A01) {
            if (c11819s == null) {
                C11829t c11829t = c11819sA0E.A02;
                if (A0C[3].charAt(17) != 'q') {
                    throw new RuntimeException();
                }
                String[] strArr = A0C;
                strArr[6] = "pn8srZEQfSJzxw";
                strArr[0] = "zNd";
                c11819sA0E.A02 = A0J(c11829t, iA03);
            } else {
                if (iA03 == -1 || !c11819sA0E.A09.equals(this.A07.A0A(iA03, this.A0A, true).A03)) {
                    return true ^ A0S(c11819s);
                }
                C11829t c11829tA03 = A03(c11819s, j11);
                if (c11829tA03 == null) {
                    return true ^ A0S(c11819s);
                }
                c11819sA0E.A02 = A0J(c11819sA0E.A02, iA03);
                if (!A09(c11819sA0E, c11829tA03)) {
                    boolean zA0S = A0S(c11819s);
                    String[] strArr2 = A0C;
                    if (strArr2[4].length() != strArr2[1].length()) {
                        return true ^ zA0S;
                    }
                    String[] strArr3 = A0C;
                    strArr3[5] = "009NTdXku0rfOoGLKxDbxOM";
                    strArr3[7] = "1WlPwvG5U3NzzyaZC20RJwC";
                    return true ^ zA0S;
                }
            }
            if (c11819sA0E.A02.A06) {
                iA03 = this.A07.A03(iA03, this.A0A, this.A0B, this.A01, this.A09);
            }
            c11819s = c11819sA0E;
        }
        return true;
    }

    public final boolean A0V(boolean z11) {
        this.A09 = z11;
        return A08();
    }
}

package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.fragment.app.FragmentTransaction;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.internal.androidx.support.v7.widget.LinearLayoutManager$SavedState;
import com.facebook.ads.internal.util.parcelable.WrappedParcelable;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1821Zo extends AbstractC10614o implements AnonymousClass50 {
    public static byte[] A0F;
    public static String[] A0G = {"VKH6HNPW", "5SG7ZkmA1SrYT5HpW6e3lHPIEdQjCnoY", "GUFAcNFlkHbDslOxTlAKu2zM5da70L8W", "8EarDdUd0wjX", "ogiAdIZLqFL2ODTGKcli7xbzAuQZVFku", "k0c9canuweazyFazM74f3pFcokchiBr", "yJQv9VjGutzUoxdr6", "vBYUiSK7FkagYmvZS"};
    public int A00;
    public int A01;
    public int A02;
    public LinearLayoutManager$SavedState A03;
    public C4Y A04;
    public boolean A05;
    public int A06;
    public C4T A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final C4R A0D;
    public final C4S A0E;

    static {
        A0V();
    }

    public C1821Zo(Context context) {
        this(context, 1, false);
    }

    public C1821Zo(Context context, int i11, boolean z11) {
        this.A0A = false;
        this.A05 = false;
        this.A0C = false;
        this.A0B = true;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A03 = null;
        this.A0D = new C4R(this);
        this.A0E = new C4S();
        this.A06 = 2;
        A2A(i11);
        A0h(z11);
        A1R(true);
    }

    private final int A04(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53) {
        if (A0W() == 0 || i11 == 0) {
            return 0;
        }
        this.A07.A0B = true;
        A29();
        int i12 = i11 > 0 ? 1 : -1;
        int iAbs = Math.abs(i11);
        A0Y(i12, iAbs, true, anonymousClass53);
        int iA08 = this.A07.A07 + A08(c10684w, this.A07, anonymousClass53, false);
        if (iA08 < 0) {
            return 0;
        }
        int i13 = iAbs > iA08 ? i12 * iA08 : i11;
        this.A04.A0J(-i13);
        this.A07.A04 = i13;
        return i13;
    }

    private int A05(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53, boolean z11) {
        int iA07 = this.A04.A07() - i11;
        if (iA07 <= 0) {
            return 0;
        }
        int i12 = -A04(-iA07, c10684w, anonymousClass53);
        int i13 = i11 + i12;
        if (z11) {
            int iA08 = this.A04.A07();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            A0G[0] = "DiKLRwr5Jced9h1IWYQQBSe";
            int i14 = iA08 - i13;
            if (i14 > 0) {
                this.A04.A0J(i14);
                return i14 + i12;
            }
        }
        return i12;
    }

    private int A06(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53, boolean z11) {
        int iA0A;
        int iA0A2 = i11 - this.A04.A0A();
        if (iA0A2 <= 0) {
            return 0;
        }
        int i12 = -A04(iA0A2, c10684w, anonymousClass53);
        int i13 = i11 + i12;
        if (!z11 || (iA0A = i13 - this.A04.A0A()) <= 0) {
            return i12;
        }
        this.A04.A0J(-iA0A);
        return i12 - iA0A;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    /* JADX WARN: Code duplicated, block: B:41:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0033 A[EDGE_INSN: B:47:0x0033->B:16:0x0033 BREAK  A[LOOP:0: B:9:0x001d->B:48:0x001d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x001d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x001d A[SYNTHETIC] */
    private final int A08(C10684w c10684w, C4T c4t, AnonymousClass53 anonymousClass53, boolean z11) {
        boolean z12;
        int i11 = c4t.A00;
        if (c4t.A07 != Integer.MIN_VALUE) {
            if (c4t.A00 < 0) {
                c4t.A07 += c4t.A00;
            }
            A0e(c10684w, c4t);
        }
        int i12 = c4t.A00 + c4t.A02;
        C4S c4s = this.A0E;
        while (true) {
            if ((!c4t.A09 && i12 <= 0) || !c4t.A05(anonymousClass53)) {
                break;
            }
            c4s.A00();
            A2D(c10684w, anonymousClass53, c4t, c4s);
            if (c4s.A01) {
                break;
            }
            c4t.A06 += c4s.A00 * c4t.A05;
            if (!c4s.A03 || this.A07.A08 != null || !anonymousClass53.A07()) {
                c4t.A00 -= c4s.A00;
                i12 -= c4s.A00;
            }
            if (c4t.A07 != Integer.MIN_VALUE) {
                c4t.A07 += c4s.A00;
                if (c4t.A00 < 0) {
                    int i13 = c4t.A07;
                    int i14 = c4t.A00;
                    if (A0G[0].length() != 7) {
                        A0G[5] = "4Yaap7YPoeEmBfNVznjneaOXF1T3Chf";
                        c4t.A07 = i13 + i14;
                    }
                }
                A0e(c10684w, c4t);
                if (z11) {
                    z12 = c4s.A02;
                    if (A0G[0].length() != 7) {
                        A0G[1] = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov";
                        if (z12) {
                            break;
                        }
                    }
                }
            } else if (z11) {
                z12 = c4s.A02;
                if (A0G[0].length() != 7) {
                    A0G[1] = "BoRZmQ3r1kYFEVrzuprqJgVQBsgHE2ov";
                    if (z12) {
                        break;
                        break;
                    }
                }
            }
            throw new RuntimeException();
        }
        return i11 - c4t.A00;
    }

    private int A09(AnonymousClass53 anonymousClass53) {
        if (A0W() != 0) {
            A29();
            return AnonymousClass57.A00(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        if (A0G[5].length() != 31) {
            throw new RuntimeException();
        }
        A0G[5] = "JS1EmTokFkofHdCiZDqGUekHou375gK";
        return 0;
    }

    private int A0A(AnonymousClass53 anonymousClass53) {
        if (A0W() == 0) {
            return 0;
        }
        A29();
        return AnonymousClass57.A02(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B, this.A05);
    }

    private int A0B(AnonymousClass53 anonymousClass53) {
        if (A0W() != 0) {
            A29();
            return AnonymousClass57.A01(anonymousClass53, this.A04, A0R(!this.A0B, true), A0Q(!this.A0B, true), this, this.A0B);
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[2] = "SnDsIEYZVkVP365fclIsQ2wSHS1GnuqA";
        strArr2[4] = "cd1sjhoNq3y2dBxKlbos6To2J3BafTHs";
        return 0;
    }

    private final int A0C(AnonymousClass53 anonymousClass53) {
        if (anonymousClass53.A06()) {
            return this.A04.A0B();
        }
        return 0;
    }

    private View A0D() {
        return A0H(0, A0W());
    }

    private View A0E() {
        return A0H(A0W() - 1, -1);
    }

    private View A0F() {
        return A0t(this.A05 ? 0 : A0W() - 1);
    }

    private View A0G() {
        return A0t(this.A05 ? A0W() - 1 : 0);
    }

    private final View A0H(int i11, int i12) {
        byte b11;
        int i13;
        int i14;
        A29();
        if (i12 > i11) {
            b11 = 1;
        } else {
            b11 = i12 < i11 ? (byte) -1 : (byte) 0;
        }
        if (b11 == 0) {
            View viewA0t = A0t(i11);
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0G[5] = "tEP4S10y6AtQbDA9ff3H424KLTnX0k7";
            return viewA0t;
        }
        if (this.A04.A0F(A0t(i11)) < this.A04.A0A()) {
            i13 = 16644;
            i14 = 16388;
        } else {
            i13 = 4161;
            i14 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return this.A00 == 0 ? super.A04.A00(i11, i12, i13, i14) : super.A05.A00(i11, i12, i13, i14);
    }

    private final View A0J(int i11, int i12, boolean z11, boolean z12) {
        A29();
        int i13 = z11 ? 24579 : 320;
        int i14 = z12 ? 320 : 0;
        int i15 = this.A00;
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "NnwW0AnvRBQDKBAe7Vp9NN4SqY6y39Zg";
        strArr[4] = "snWQRfIRwdJNOSPMdDWVpUmegwlUrdsl";
        return i15 == 0 ? super.A04.A00(i11, i12, i13, i14) : super.A05.A00(i11, i12, i13, i14);
    }

    private View A0K(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return A28(c10684w, anonymousClass53, 0, A0W(), anonymousClass53.A03());
    }

    private View A0L(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return A28(c10684w, anonymousClass53, A0W() - 1, -1, anonymousClass53.A03());
    }

    private View A0M(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0D() : A0E();
    }

    private View A0N(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0E() : A0D();
    }

    private View A0O(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0K(c10684w, anonymousClass53) : A0L(c10684w, anonymousClass53);
    }

    private View A0P(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        return this.A05 ? A0L(c10684w, anonymousClass53) : A0K(c10684w, anonymousClass53);
    }

    private View A0Q(boolean z11, boolean z12) {
        return this.A05 ? A0J(0, A0W(), z11, z12) : A0J(A0W() - 1, -1, z11, z12);
    }

    private View A0R(boolean z11, boolean z12) {
        return this.A05 ? A0J(A0W() - 1, -1, z11, z12) : A0J(0, A0W(), z11, z12);
    }

    private final C4T A0S() {
        return new C4T();
    }

    public static String A0T(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    private void A0U() {
        if (this.A00 == 1 || !A2F()) {
            this.A05 = this.A0A;
            return;
        }
        boolean z11 = !this.A0A;
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[6] = "rvopS3hSB7itRsuyG";
        strArr2[7] = "9RTUShXs4ZXrU4n03";
        this.A05 = z11;
    }

    public static void A0V() {
        A0F = new byte[]{Ascii.RS, Ascii.EM, 1, Ascii.SYN, Ascii.ESC, Ascii.RS, 19, 87, Ascii.CAN, 5, Ascii.RS, Ascii.DC2, Ascii.EM, 3, Ascii.SYN, 3, Ascii.RS, Ascii.CAN, Ascii.EM, 77};
    }

    private void A0W(int i11, int i12) {
        this.A07.A00 = this.A04.A07() - i12;
        this.A07.A03 = this.A05 ? -1 : 1;
        this.A07.A01 = i11;
        this.A07.A05 = 1;
        this.A07.A06 = i12;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0X(int i11, int i12) {
        this.A07.A00 = i12 - this.A04.A0A();
        this.A07.A01 = i11;
        this.A07.A03 = this.A05 ? 1 : -1;
        this.A07.A05 = -1;
        this.A07.A06 = i12;
        this.A07.A07 = Integer.MIN_VALUE;
    }

    private void A0Y(int i11, int i12, boolean z11, AnonymousClass53 anonymousClass53) {
        int iA0A;
        this.A07.A09 = A0i();
        this.A07.A02 = A0C(anonymousClass53);
        this.A07.A05 = i11;
        if (i11 == 1) {
            this.A07.A02 += this.A04.A08();
            View viewA0F = A0F();
            this.A07.A03 = this.A05 ? -1 : 1;
            this.A07.A01 = A0p(viewA0F) + this.A07.A03;
            this.A07.A06 = this.A04.A0C(viewA0F);
            iA0A = this.A04.A0C(viewA0F) - this.A04.A07();
        } else {
            View viewA0G = A0G();
            this.A07.A02 += this.A04.A0A();
            this.A07.A03 = this.A05 ? 1 : -1;
            this.A07.A01 = A0p(viewA0G) + this.A07.A03;
            this.A07.A06 = this.A04.A0F(viewA0G);
            iA0A = (-this.A04.A0F(viewA0G)) + this.A04.A0A();
        }
        this.A07.A00 = i12;
        if (z11) {
            this.A07.A00 -= iA0A;
        }
        this.A07.A07 = iA0A;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        A0G[1] = "rmKnvh8FAT7bzRdUkYGsCRYa1fX1DRoz";
    }

    private void A0Z(C4R c4r) {
        A0W(c4r.A01, c4r.A00);
    }

    private void A0a(C4R c4r) {
        A0X(c4r.A01, c4r.A00);
    }

    private void A0b(C10684w c10684w, int i11) {
        int iA0W = A0W();
        if (i11 < 0) {
            return;
        }
        int iA06 = this.A04.A06() - i11;
        if (this.A05) {
            for (int i12 = 0; i12 < iA0W; i12++) {
                View viewA0t = A0t(i12);
                if (this.A04.A0F(viewA0t) < iA06 || this.A04.A0H(viewA0t) < iA06) {
                    A0d(c10684w, 0, i12);
                    return;
                }
            }
            return;
        }
        for (int i13 = iA0W - 1; i13 >= 0; i13--) {
            View viewA0t2 = A0t(i13);
            if (this.A04.A0F(viewA0t2) < iA06 || this.A04.A0H(viewA0t2) < iA06) {
                A0d(c10684w, iA0W - 1, i13);
                return;
            }
        }
    }

    private void A0c(C10684w c10684w, int i11) {
        if (i11 < 0) {
            return;
        }
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[0] = "66";
        int iA0W = A0W();
        if (!this.A05) {
            for (int i12 = 0; i12 < iA0W; i12++) {
                View viewA0t = A0t(i12);
                int iA0C = this.A04.A0C(viewA0t);
                if (A0G[3].length() == 28) {
                    throw new RuntimeException();
                }
                A0G[1] = "ET87P0AumYMcjI6vylu4qFXoEmTHeXod";
                if (iA0C > i11 || this.A04.A0G(viewA0t) > i11) {
                    A0d(c10684w, 0, i12);
                    return;
                }
            }
            return;
        }
        for (int i13 = iA0W - 1; i13 >= 0; i13--) {
            View viewA0t2 = A0t(i13);
            if (this.A04.A0C(viewA0t2) <= i11) {
                C4Y c4y = this.A04;
                String[] strArr2 = A0G;
                if (strArr2[6].length() == strArr2[7].length()) {
                    A0G[3] = "uDZbJl3GZvnd0";
                    if (c4y.A0G(viewA0t2) <= i11) {
                    }
                } else if (c4y.A0G(viewA0t2) <= i11) {
                }
            }
            A0d(c10684w, iA0W - 1, i13);
            return;
        }
    }

    private void A0d(C10684w c10684w, int i11, int i12) {
        if (i11 == i12) {
            return;
        }
        if (i12 <= i11) {
            while (i11 > i12) {
                A14(i11, c10684w);
                i11--;
            }
        } else {
            for (int i13 = i12 - 1; i13 >= i11; i13--) {
                A14(i13, c10684w);
            }
        }
    }

    private void A0e(C10684w c10684w, C4T c4t) {
        if (!c4t.A0B || c4t.A09) {
            return;
        }
        int i11 = c4t.A05;
        String[] strArr = A0G;
        if (strArr[6].length() == strArr[7].length()) {
            String[] strArr2 = A0G;
            strArr2[2] = "M7iaeQoExhHh03f7x1XNzmreS2Lq1zJK";
            strArr2[4] = "3weclwG7n9RXAySrMV3Jn51LrKgutG4n";
            if (i11 != -1) {
                A0c(c10684w, c4t.A07);
                return;
            }
            int i12 = c4t.A07;
            if (A0G[1].charAt(30) == 'o') {
                A0G[3] = "CiNTyTfZO3PW6tP";
                A0b(c10684w, i12);
                return;
            }
        }
        throw new RuntimeException();
    }

    private void A0f(C10684w c10684w, AnonymousClass53 anonymousClass53, int i11, int i12) {
        if (!anonymousClass53.A08() || A0W() == 0 || anonymousClass53.A07() || !A22()) {
            return;
        }
        int iA0D = 0;
        int iA0D2 = 0;
        List<AnonymousClass56> listA0J = c10684w.A0J();
        int size = listA0J.size();
        int iA0p = A0p(A0t(0));
        for (int i13 = 0; i13 < size; i13++) {
            AnonymousClass56 anonymousClass56 = listA0J.get(i13);
            if (!anonymousClass56.A0a()) {
                if (((anonymousClass56.A0I() < iA0p) != this.A05 ? (byte) -1 : (byte) 1) == -1) {
                    iA0D += this.A04.A0D(anonymousClass56.A0H);
                } else {
                    iA0D2 += this.A04.A0D(anonymousClass56.A0H);
                }
            }
        }
        this.A07.A08 = listA0J;
        if (iA0D > 0) {
            A0X(A0p(A0G()), i11);
            this.A07.A02 = iA0D;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c10684w, this.A07, anonymousClass53, false);
        }
        if (iA0D2 > 0) {
            A0W(A0p(A0F()), i12);
            this.A07.A02 = iA0D2;
            this.A07.A00 = 0;
            this.A07.A04();
            A08(c10684w, this.A07, anonymousClass53, false);
        }
        this.A07.A08 = null;
    }

    private void A0g(C10684w c10684w, AnonymousClass53 anonymousClass53, C4R c4r) {
        if (A0k(anonymousClass53, c4r)) {
            return;
        }
        boolean zA0j = A0j(c10684w, anonymousClass53, c4r);
        String[] strArr = A0G;
        if (strArr[2].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A0G[3] = "XDJ2jDWhUW9a7iN";
        if (zA0j) {
            return;
        }
        c4r.A02();
        c4r.A01 = this.A0C ? anonymousClass53.A03() - 1 : 0;
    }

    private final void A0h(boolean z11) {
        A1y(null);
        if (z11 == this.A0A) {
            return;
        }
        this.A0A = z11;
        A0y();
    }

    private final boolean A0i() {
        return this.A04.A09() == 0 && this.A04.A06() == 0;
    }

    private boolean A0j(C10684w c10684w, AnonymousClass53 anonymousClass53, C4R c4r) {
        if (A0W() == 0) {
            return false;
        }
        View viewA0s = A0s();
        if (viewA0s != null && c4r.A06(viewA0s, anonymousClass53)) {
            c4r.A05(viewA0s);
            return true;
        }
        if (this.A08 != this.A0C) {
            return false;
        }
        View viewA0O = c4r.A02 ? A0O(c10684w, anonymousClass53) : A0P(c10684w, anonymousClass53);
        if (viewA0O == null) {
            return false;
        }
        c4r.A04(viewA0O);
        if (!anonymousClass53.A07() && A22()) {
            if (this.A04.A0F(viewA0O) >= this.A04.A07() || this.A04.A0C(viewA0O) < this.A04.A0A()) {
                c4r.A00 = c4r.A02 ? this.A04.A07() : this.A04.A0A();
            }
        }
        return true;
    }

    private boolean A0k(AnonymousClass53 anonymousClass53, C4R c4r) {
        int i11;
        int iA0F;
        if (anonymousClass53.A07() || (i11 = this.A01) == -1) {
            return false;
        }
        if (i11 < 0 || i11 >= anonymousClass53.A03()) {
            this.A01 = -1;
            this.A02 = Integer.MIN_VALUE;
            return false;
        }
        c4r.A01 = this.A01;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            c4r.A02 = this.A03.A02;
            if (c4r.A02) {
                c4r.A00 = this.A04.A07() - this.A03.A00;
            } else {
                c4r.A00 = this.A04.A0A() + this.A03.A00;
            }
            return true;
        }
        if (this.A02 != Integer.MIN_VALUE) {
            c4r.A02 = this.A05;
            if (this.A05) {
                c4r.A00 = this.A04.A07() - this.A02;
            } else {
                c4r.A00 = this.A04.A0A() + this.A02;
            }
            return true;
        }
        View viewA1m = A1m(this.A01);
        if (viewA1m == null) {
            if (A0W() > 0) {
                boolean z11 = this.A01 < A0p(A0t(0));
                boolean z12 = this.A05;
                if (A0G[1].charAt(30) != 'o') {
                    throw new RuntimeException();
                }
                String[] strArr = A0G;
                strArr[2] = "1tNDA9T9nSDYektAgKE77gOe81bMFJSk";
                strArr[4] = "TZYqXNdWGZVKxzfIQyf7YZEk7yb7IRTm";
                c4r.A02 = z11 == z12;
            }
            c4r.A02();
        } else {
            if (this.A04.A0D(viewA1m) > this.A04.A0B()) {
                c4r.A02();
                return true;
            }
            if (this.A04.A0F(viewA1m) - this.A04.A0A() < 0) {
                c4r.A00 = this.A04.A0A();
                c4r.A02 = false;
                return true;
            }
            if (this.A04.A07() - this.A04.A0C(viewA1m) < 0) {
                c4r.A00 = this.A04.A07();
                c4r.A02 = true;
                return true;
            }
            if (c4r.A02) {
                int iA0C = this.A04.A0C(viewA1m);
                C4Y c4y = this.A04;
                String[] strArr2 = A0G;
                if (strArr2[2].charAt(4) == strArr2[4].charAt(4)) {
                    throw new RuntimeException();
                }
                A0G[3] = "ZbIhQvVoqDIGDPkO0OlvW9zioDplzu";
                iA0F = iA0C + c4y.A05();
            } else {
                iA0F = this.A04.A0F(viewA1m);
            }
            c4r.A00 = iA0F;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public int A1d(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53) {
        if (this.A00 == 1) {
            return 0;
        }
        return A04(i11, c10684w, anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public int A1e(int i11, C10684w c10684w, AnonymousClass53 anonymousClass53) {
        if (this.A00 == 0) {
            return 0;
        }
        int iA04 = A04(i11, c10684w, anonymousClass53);
        String[] strArr = A0G;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A0G[3] = "CDnF1shpb";
        return iA04;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1f(AnonymousClass53 anonymousClass53) {
        return A09(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1g(AnonymousClass53 anonymousClass53) {
        return A0A(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1h(AnonymousClass53 anonymousClass53) {
        return A0B(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1i(AnonymousClass53 anonymousClass53) {
        return A09(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1j(AnonymousClass53 anonymousClass53) {
        return A0A(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final int A1k(AnonymousClass53 anonymousClass53) {
        return A0B(anonymousClass53);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final Parcelable A1l() {
        if (this.A03 != null) {
            return new WrappedParcelable(new LinearLayoutManager$SavedState(this.A03));
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (A0W() > 0) {
            A29();
            boolean z11 = this.A08 ^ this.A05;
            linearLayoutManager$SavedState.A02 = z11;
            if (z11) {
                View viewA0F = A0F();
                linearLayoutManager$SavedState.A00 = this.A04.A07() - this.A04.A0C(viewA0F);
                linearLayoutManager$SavedState.A01 = A0p(viewA0F);
            } else {
                View viewA0G = A0G();
                linearLayoutManager$SavedState.A01 = A0p(viewA0G);
                linearLayoutManager$SavedState.A00 = this.A04.A0F(viewA0G) - this.A04.A0A();
            }
        } else {
            linearLayoutManager$SavedState.A00();
        }
        return new WrappedParcelable(linearLayoutManager$SavedState);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final View A1m(int i11) {
        int iA0W = A0W();
        if (iA0W == 0) {
            return null;
        }
        int iA0p = i11 - A0p(A0t(0));
        if (iA0p >= 0 && iA0p < iA0W) {
            View viewA0t = A0t(iA0p);
            if (A0p(viewA0t) == i11) {
                return viewA0t;
            }
        }
        return super.A1m(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public View A1n(View view, int i11, C10684w c10684w, AnonymousClass53 anonymousClass53) {
        int iA27;
        A0U();
        if (A0W() == 0 || (iA27 = A27(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        A29();
        A29();
        A0Y(iA27, (int) (this.A04.A0B() * 0.33333334f), false, anonymousClass53);
        this.A07.A07 = Integer.MIN_VALUE;
        this.A07.A0B = false;
        A08(c10684w, this.A07, anonymousClass53, true);
        View viewA0N = iA27 == -1 ? A0N(c10684w, anonymousClass53) : A0M(c10684w, anonymousClass53);
        View viewA0G = iA27 == -1 ? A0G() : A0F();
        boolean zHasFocusable = viewA0G.hasFocusable();
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[2] = "JGtMOr7ZHjmwUVfbInfaZmEhr0nxGN38";
        strArr[4] = "jCrgpf8bwQbyd1C9u6FfAt5OnK6gBhSa";
        if (!zHasFocusable) {
            return viewA0N;
        }
        if (viewA0N == null) {
            return null;
        }
        return viewA0G;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public C10624p A1o() {
        return new C10624p(-2, -2);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public void A1p(int i11) {
        this.A01 = i11;
        this.A02 = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1q(int i11, int i12, AnonymousClass53 anonymousClass53, InterfaceC10594m interfaceC10594m) {
        if (this.A00 != 0) {
            i11 = i12;
        }
        if (A0W() == 0 || i11 == 0) {
            return;
        }
        A29();
        A0Y(i11 > 0 ? 1 : -1, Math.abs(i11), true, anonymousClass53);
        A2E(anonymousClass53, this.A07, interfaceC10594m);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1r(int i11, InterfaceC10594m interfaceC10594m) {
        boolean z11;
        int i12;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.A01()) {
            A0U();
            z11 = this.A05;
            int i13 = this.A01;
            String[] strArr = A0G;
            if (strArr[6].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0G[1] = "j12HxmlCdcFNOCf90EDMVBFIs8rsuaoM";
            i12 = i13 == -1 ? z11 ? i11 - 1 : 0 : this.A01;
        } else {
            z11 = this.A03.A02;
            i12 = this.A03.A01;
        }
        int i14 = z11 ? -1 : 1;
        for (int i15 = 0; i15 < this.A06 && i12 >= 0 && i12 < i11; i15++) {
            interfaceC10594m.A3S(i12, 0);
            i12 += i14;
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1s(Parcelable parcelable) {
        if (parcelable instanceof WrappedParcelable) {
            ClassLoader classLoader = getClass().getClassLoader();
            if (A0G[1].charAt(30) == 'o') {
                A0G[1] = "tHEWx5U9TGfOm0s3U2zrO5nR7UMaVIoI";
                if (classLoader == null) {
                    return;
                }
                if (A0G[5].length() == 31) {
                    A0G[3] = "tm";
                    Parcelable parcelableUnwrap = ((WrappedParcelable) parcelable).unwrap(classLoader);
                    if (parcelableUnwrap instanceof LinearLayoutManager$SavedState) {
                        this.A03 = (LinearLayoutManager$SavedState) parcelableUnwrap;
                        A0y();
                        return;
                    }
                    return;
                }
            }
            throw new RuntimeException();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1t(AccessibilityEvent accessibilityEvent) {
        super.A1t(accessibilityEvent);
        if (A0W() > 0) {
            accessibilityEvent.setFromIndex(A24());
            int iA25 = A25();
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[3] = "9E5bhv9RVKulu";
            accessibilityEvent.setToIndex(iA25);
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:79:0x0208  */
    /* JADX WARN: Code duplicated, block: B:80:0x020b  */
    /* JADX WARN: Code duplicated, block: B:81:0x021c  */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public void A1u(C10684w c10684w, AnonymousClass53 anonymousClass53) {
        int i11;
        int i12;
        int i13;
        View viewA1m;
        int iA0F;
        int iA07;
        String[] strArr;
        int i14 = -1;
        if (!(this.A03 == null && this.A01 == -1) && anonymousClass53.A03() == 0) {
            A1I(c10684w);
            return;
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.A01()) {
            this.A01 = this.A03.A01;
        }
        A29();
        this.A07.A0B = false;
        A0U();
        View viewA0s = A0s();
        if (!this.A0D.A03 || this.A01 != -1 || this.A03 != null) {
            this.A0D.A03();
            this.A0D.A02 = this.A05 ^ this.A0C;
            A0g(c10684w, anonymousClass53, this.A0D);
            C4R c4r = this.A0D;
            if (A0G[3].length() == 28) {
                throw new RuntimeException();
            }
            A0G[0] = "pP9DXN24lJAGcvrzmJLzNvbz";
            c4r.A03 = true;
        } else if (viewA0s != null && (this.A04.A0F(viewA0s) >= this.A04.A07() || this.A04.A0C(viewA0s) <= this.A04.A0A())) {
            this.A0D.A05(viewA0s);
        }
        int iA0C = A0C(anonymousClass53);
        if (this.A07.A04 >= 0) {
            i11 = 0;
        } else {
            i11 = iA0C;
            iA0C = 0;
        }
        int iA0A = i11 + this.A04.A0A();
        int iA08 = iA0C + this.A04.A08();
        if (anonymousClass53.A07()) {
            int i15 = this.A01;
            String[] strArr2 = A0G;
            if (strArr2[6].length() != strArr2[7].length()) {
                A0G[1] = "HnPzY03honFOjhYT25K5WFAFMhFIclok";
                if (i15 != -1) {
                    if (this.A02 != Integer.MIN_VALUE && (viewA1m = A1m(i15)) != null) {
                        if (this.A05) {
                            iA07 = this.A04.A07() - this.A04.A0C(viewA1m);
                            strArr = A0G;
                            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                                A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
                                iA0F = iA07 - this.A02;
                            } else {
                                String[] strArr3 = A0G;
                                strArr3[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
                                strArr3[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
                                iA0F = iA07 - this.A02;
                            }
                        } else {
                            iA0F = this.A02 - (this.A04.A0F(viewA1m) - this.A04.A0A());
                        }
                        if (iA0F > 0) {
                            iA0A += iA0F;
                        } else {
                            iA08 -= iA0F;
                        }
                    }
                }
            } else {
                String[] strArr4 = A0G;
                strArr4[2] = "wwbDuuRcKwQkcLvBFtW9wuMbOUuGYFzY";
                strArr4[4] = "YequbpJjhMyIl9uyXvP2gytASLo9xZ7L";
                if (i15 != -1) {
                    if (this.A02 != Integer.MIN_VALUE) {
                        if (this.A05) {
                            iA07 = this.A04.A07() - this.A04.A0C(viewA1m);
                            strArr = A0G;
                            if (strArr[2].charAt(4) != strArr[4].charAt(4)) {
                                A0G[5] = "r3FnQil1r32czyLALUutLd0XCkxYZ4G";
                                iA0F = iA07 - this.A02;
                            } else {
                                String[] strArr5 = A0G;
                                strArr5[2] = "sdmiyO1ExKOYMO2wbr6XNnW0K6t4WoaH";
                                strArr5[4] = "ty9AfnxQn4ghzZPCSImQPyrccPhuEwJu";
                                iA0F = iA07 - this.A02;
                            }
                        } else {
                            iA0F = this.A02 - (this.A04.A0F(viewA1m) - this.A04.A0A());
                        }
                        if (iA0F > 0) {
                            iA0A += iA0F;
                        } else {
                            iA08 -= iA0F;
                        }
                    }
                }
            }
        }
        if (this.A0D.A02) {
            if (this.A05) {
                i14 = 1;
            }
        } else if (!this.A05) {
            i14 = 1;
        }
        A2C(c10684w, anonymousClass53, this.A0D, i14);
        A1H(c10684w);
        this.A07.A09 = A0i();
        this.A07.A0A = anonymousClass53.A07();
        if (this.A0D.A02) {
            A0a(this.A0D);
            this.A07.A02 = iA0A;
            A08(c10684w, this.A07, anonymousClass53, false);
            i13 = this.A07.A06;
            int i16 = this.A07.A01;
            if (this.A07.A00 > 0) {
                iA08 += this.A07.A00;
            }
            A0Z(this.A0D);
            this.A07.A02 = iA08;
            this.A07.A01 += this.A07.A03;
            A08(c10684w, this.A07, anonymousClass53, false);
            i12 = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i17 = this.A07.A00;
                A0X(i16, i13);
                this.A07.A02 = i17;
                A08(c10684w, this.A07, anonymousClass53, false);
                i13 = this.A07.A06;
            }
        } else {
            A0Z(this.A0D);
            this.A07.A02 = iA08;
            A08(c10684w, this.A07, anonymousClass53, false);
            i12 = this.A07.A06;
            int i18 = this.A07.A01;
            if (this.A07.A00 > 0) {
                iA0A += this.A07.A00;
            }
            A0a(this.A0D);
            this.A07.A02 = iA0A;
            this.A07.A01 += this.A07.A03;
            A08(c10684w, this.A07, anonymousClass53, false);
            i13 = this.A07.A06;
            if (this.A07.A00 > 0) {
                int i19 = this.A07.A00;
                A0W(i18, i12);
                this.A07.A02 = i19;
                A08(c10684w, this.A07, anonymousClass53, false);
                i12 = this.A07.A06;
            }
        }
        if (A0W() > 0) {
            if (this.A05 ^ this.A0C) {
                int iA05 = A05(i12, c10684w, anonymousClass53, true);
                int i21 = i13 + iA05;
                int i22 = i12 + iA05;
                int iA06 = A06(i21, c10684w, anonymousClass53, false);
                i13 = i21 + iA06;
                i12 = i22 + iA06;
            } else {
                int iA09 = A06(i13, c10684w, anonymousClass53, true);
                int i23 = i13 + iA09;
                int i24 = i12 + iA09;
                int iA010 = A05(i24, c10684w, anonymousClass53, false);
                i13 = i23 + iA010;
                i12 = i24 + iA010;
            }
        }
        A0f(c10684w, anonymousClass53, i13, i12);
        if (anonymousClass53.A07()) {
            this.A0D.A03();
        } else {
            this.A04.A0I();
        }
        this.A08 = this.A0C;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public void A1v(AnonymousClass53 anonymousClass53) {
        super.A1v(anonymousClass53);
        this.A03 = null;
        this.A01 = -1;
        this.A02 = Integer.MIN_VALUE;
        this.A0D.A03();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1w(C1278Eb c1278Eb, C10684w c10684w) {
        super.A1w(c1278Eb, c10684w);
        if (this.A09) {
            A1I(c10684w);
            c10684w.A0P();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public void A1x(C1278Eb c1278Eb, AnonymousClass53 anonymousClass53, int i11) {
        C1820Zn c1820Zn = new C1820Zn(c1278Eb.getContext());
        c1820Zn.A0A(i11);
        A1L(c1820Zn);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final void A1y(String str) {
        if (this.A03 == null) {
            super.A1y(str);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final boolean A1z() {
        if (A0Y() != 1073741824 && A0i() != 1073741824) {
            boolean zA1S = A1S();
            if (A0G[0].length() == 7) {
                throw new RuntimeException();
            }
            A0G[0] = "ZYU5Lu8KJdo1W8";
            if (zA1S) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final boolean A20() {
        return this.A00 == 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public final boolean A21() {
        return this.A00 == 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10614o
    public boolean A22() {
        return this.A03 == null && this.A08 == this.A0C;
    }

    public final int A23() {
        View viewA0J = A0J(0, A0W(), true, false);
        if (viewA0J == null) {
            return -1;
        }
        return A0p(viewA0J);
    }

    public final int A24() {
        View viewA0J = A0J(0, A0W(), false, true);
        if (viewA0J == null) {
            return -1;
        }
        return A0p(viewA0J);
    }

    public final int A25() {
        View viewA0J = A0J(A0W() - 1, -1, false, true);
        if (viewA0J == null) {
            return -1;
        }
        return A0p(viewA0J);
    }

    public final int A26() {
        return this.A00;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0061, code lost:
    
        if (r4 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        if (r4 == 1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0072, code lost:
    
        if (A2F() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0075, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A27(int i11) {
        switch (i11) {
            case 1:
                int i12 = this.A00;
                String[] strArr = A0G;
                if (strArr[6].length() == strArr[7].length()) {
                    A0G[3] = "tdW2fzf";
                    break;
                }
                break;
            case 2:
                return (this.A00 != 1 && A2F()) ? -1 : 1;
            case 17:
                return this.A00 == 0 ? -1 : Integer.MIN_VALUE;
            case 33:
                return this.A00 == 1 ? -1 : Integer.MIN_VALUE;
            case 66:
                return this.A00 == 0 ? 1 : Integer.MIN_VALUE;
            case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                int i13 = this.A00;
                if (A0G[1].charAt(30) != 'o') {
                    throw new RuntimeException();
                }
                A0G[3] = "6DQtaB3lJkGKNvmH8s9QQc68TsOBLDE";
                return i13 == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public View A28(C10684w c10684w, AnonymousClass53 anonymousClass53, int i11, int i12, int i13) {
        A29();
        View view = null;
        View view2 = null;
        int iA0A = this.A04.A0A();
        int iA07 = this.A04.A07();
        int i14 = i12 > i11 ? 1 : -1;
        while (i11 != i12) {
            View viewA0t = A0t(i11);
            int iA0p = A0p(viewA0t);
            if (iA0p >= 0 && iA0p < i13) {
                if (((C10624p) viewA0t.getLayoutParams()).A02()) {
                    if (view == null) {
                        view = viewA0t;
                    }
                } else {
                    if (this.A04.A0F(viewA0t) < iA07 && this.A04.A0C(viewA0t) >= iA0A) {
                        return viewA0t;
                    }
                    if (view2 == null) {
                        view2 = viewA0t;
                    }
                }
            }
            i11 += i14;
        }
        return view2 != null ? view2 : view;
    }

    public final void A29() {
        if (this.A07 == null) {
            this.A07 = A0S();
        }
        if (this.A04 == null) {
            this.A04 = C4Y.A02(this, this.A00);
        }
    }

    public final void A2A(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException(A0T(0, 20, 1) + i11);
        }
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[1] = "wMuOUB68W5cmyVCUMue198JFnL9Wkeot";
        A1y(null);
        if (i11 == this.A00) {
            return;
        }
        this.A00 = i11;
        this.A04 = null;
        A0y();
    }

    public final void A2B(int i11, int i12) {
        this.A01 = i11;
        this.A02 = i12;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.A03;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.A00();
        }
        A0y();
        if (A0G[1].charAt(30) != 'o') {
            throw new RuntimeException();
        }
        A0G[3] = "tDl3kZGUKMTs";
    }

    public void A2C(C10684w c10684w, AnonymousClass53 anonymousClass53, C4R c4r, int i11) {
    }

    public void A2D(C10684w c10684w, AnonymousClass53 anonymousClass53, C4T c4t, C4S c4s) {
        int iA0g;
        int iA0E;
        int iA0e;
        int iA0E2;
        View viewA03 = c4t.A03(c10684w);
        if (viewA03 == null) {
            c4s.A01 = true;
            return;
        }
        C10624p c10624p = (C10624p) viewA03.getLayoutParams();
        if (c4t.A08 == null) {
            if (this.A05 == (c4t.A05 == -1)) {
                A17(viewA03);
            } else {
                A19(viewA03, 0);
            }
        } else {
            if (this.A05 == (c4t.A05 == -1)) {
                A16(viewA03);
            } else {
                A18(viewA03, 0);
            }
        }
        A1A(viewA03, 0, 0);
        c4s.A00 = this.A04.A0D(viewA03);
        if (this.A00 == 1) {
            if (A2F()) {
                iA0E2 = A0h() - A0f();
                iA0e = iA0E2 - this.A04.A0E(viewA03);
            } else {
                iA0e = A0e();
                iA0E2 = this.A04.A0E(viewA03) + iA0e;
            }
            if (c4t.A05 == -1) {
                iA0E = c4t.A06;
                iA0g = c4t.A06 - c4s.A00;
            } else {
                iA0g = c4t.A06;
                iA0E = c4t.A06 + c4s.A00;
            }
        } else {
            iA0g = A0g();
            iA0E = this.A04.A0E(viewA03) + iA0g;
            if (c4t.A05 == -1) {
                iA0E2 = c4t.A06;
                iA0e = c4t.A06 - c4s.A00;
            } else {
                iA0e = c4t.A06;
                iA0E2 = c4t.A06 + c4s.A00;
            }
        }
        A1B(viewA03, iA0e, iA0g, iA0E2, iA0E);
        if (c10624p.A02() || c10624p.A01()) {
            c4s.A03 = true;
        }
        c4s.A02 = viewA03.hasFocusable();
    }

    public void A2E(AnonymousClass53 anonymousClass53, C4T c4t, InterfaceC10594m interfaceC10594m) {
        int i11 = c4t.A01;
        if (i11 < 0 || i11 >= anonymousClass53.A03()) {
            return;
        }
        interfaceC10594m.A3S(i11, Math.max(0, c4t.A07));
    }

    public final boolean A2F() {
        return A0a() == 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass50
    public final PointF A4O(int i11) {
        if (A0W() == 0) {
            return null;
        }
        int i12 = (i11 < A0p(A0t(0))) != this.A05 ? -1 : 1;
        int i13 = this.A00;
        if (A0G[0].length() == 7) {
            throw new RuntimeException();
        }
        A0G[5] = "5EjIyJt0kzQOvAP28HqeuGPqaebz9kN";
        return i13 == 0 ? new PointF(i12, 0.0f) : new PointF(0.0f, i12);
    }
}

package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import android.widget.FrameLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9Q, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9Q extends AbstractC1648Ss {
    public static byte[] A0L;
    public static String[] A0M = {"Mriq29lS8vjEPztqvg4mnlhqPa1pf4jw", "J0ebGdEZD5oKohgNzUxMA3JiHaSF4bRJ", "IT9tvlYp44pYwsfxgtsksFS", "El43mrOkb3qqMjbYlNbneDDC3riKbt8u", "SsyQgLhJr8BA6K4Jeu0226NIXlotTSUK", "5pKSfcHcmxRzGJ6MCKbxSHPk9j0pnkgf", "vZ9Xs81YGHnjRjGsoTeSsIOHxP", "Y9Sammkz"};
    public OL A00;
    public Q7 A01;
    public QM A02;
    public boolean A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public final C5T A09;
    public final SF A0A;
    public final SA A0B;
    public final C9I A0C;
    public final AbstractC1572Pu A0D;
    public final AbstractC1570Ps A0E;
    public final AbstractC1539On A0F;
    public final O7 A0G;
    public final NX A0H;
    public final NQ A0I;
    public final C1444Kw A0J;
    public final KP A0K;

    static {
        A08();
    }

    public C9Q(C1795Yn c1795Yn, InterfaceC1483Mj interfaceC1483Mj, J2 j11, AbstractC1898b5 abstractC1898b5, C11006c c11006c, MC mc2) {
        super(c1795Yn, interfaceC1483Mj, j11, abstractC1898b5, c11006c, mc2);
        this.A09 = new C1637Sh(this);
        NX nx2 = new NX() { // from class: com.facebook.ads.redexgen.X.9X
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C1513Nn c1513Nn) {
                this.A00.A07 = true;
            }
        };
        this.A0H = nx2;
        O7 o11 = new O7() { // from class: com.facebook.ads.redexgen.X.9V
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(O8 o12) {
                this.A00.A08 = true;
                this.A00.A0P();
            }
        };
        this.A0G = o11;
        AbstractC1539On abstractC1539On = new AbstractC1539On() { // from class: com.facebook.ads.redexgen.X.9U
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(AnonymousClass98 anonymousClass98) {
            }
        };
        this.A0F = abstractC1539On;
        NQ nq2 = new NQ() { // from class: com.facebook.ads.redexgen.X.9T
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(AnonymousClass93 anonymousClass93) {
                this.A00.A0F(anonymousClass93);
                this.A00.A0E(anonymousClass93);
                this.A00.A00.A0C(anonymousClass93);
            }
        };
        this.A0I = nq2;
        AbstractC1572Pu abstractC1572Pu = new AbstractC1572Pu() { // from class: com.facebook.ads.redexgen.X.9S
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A03(C9H c9h) {
                C9Q c9q = this.A00;
                c9q.A0D(c9h, c9q.A0B.getState() != RB.A06, false);
            }
        };
        this.A0D = abstractC1572Pu;
        C9R c9r = new C9R(this);
        this.A0E = c9r;
        boolean z11 = false;
        this.A07 = false;
        this.A08 = false;
        this.A06 = false;
        this.A05 = false;
        this.A04 = false;
        SA sa2 = new SA(super.A03);
        this.A0B = sa2;
        sa2.setFunnelLoggingHandler(super.A05);
        sa2.getEventBus().A03(nx2, o11, abstractC1539On, nq2, abstractC1572Pu, c9r);
        C9I c9i = new C9I(super.A03, super.A04, sa2, super.A01.A12());
        this.A0C = c9i;
        if (C1384Ih.A1X(super.A03)) {
            this.A0A = new SF(super.A03, super.A04, sa2, super.A01.A12(), c9i, null);
        } else {
            this.A0A = null;
        }
        this.A01 = new Q7(super.A03, super.A09, super.A01.A0T(), mc2);
        this.A0J = new C1444Kw(super.A03, super.A05);
        this.A0K = new KP(super.A03);
        A07();
        sa2.setVideoURI(super.A02.A0S(super.A01.A0x().A0D().A08()));
        A05();
        int iA03 = super.A01.A0x().A0D().A03();
        if (C1384Ih.A1w(super.A03)) {
            this.A05 = iA03 == 0;
        } else {
            this.A05 = iA03 <= 0;
        }
        if (super.A01.A0x().A0M() && super.A01.A0x().A0D().A02() > 0) {
            z11 = true;
        }
        this.A03 = z11;
        AbstractC1462Lo.A0M(this, super.A01.A0w().A01().A07(true));
        if (C1384Ih.A1q(super.A03)) {
            super.A07.setProgressSpinnerInvisible(true);
        }
    }

    private OL A00(int i11) {
        return OM.A00(new OO(super.A03, super.A04, super.A08, super.A01, this.A0B, super.A0A, super.A06).A0E(super.A07.getToolbarHeight()).A0H(super.A07).A0D(i11).A0F(this.A0J).A0I(this.A0K).A0K(), null, true);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0L, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        this.A0B.postDelayed(new C1636Sg(this), C1384Ih.A0K(super.A03));
    }

    private void A05() {
        this.A0B.postDelayed(new C1635Sf(this), C1384Ih.A0L(super.A03));
    }

    private void A06() {
        this.A05 = true;
        super.A07.A04();
        OL ol2 = this.A00;
        if (ol2 != null) {
            ol2.A0y();
        }
    }

    private void A07() {
        this.A0B.A0c(this.A0K);
        this.A0B.A0c(this.A0J);
        if (!TextUtils.isEmpty(super.A01.A0x().A0D().A07())) {
            C7R c7r = new C7R(super.A03);
            this.A0B.A0c(c7r);
            c7r.setImage(super.A01.A0x().A0D().A07());
        }
        C7C c7c = new C7C(super.A03, true, super.A05);
        this.A0B.A0c(c7c);
        this.A0B.A0c(new L7(c7c, QZ.A03, true));
        this.A0B.A0c(new C7H(super.A03));
    }

    public static void A08() {
        A0L = new byte[]{-3, Ascii.NAK, 7, 5, Ascii.NAK, -1};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(C9H c9h, boolean z11, boolean z12) {
        if (this.A06) {
            return;
        }
        if (A0M[6].length() != 26) {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[2] = "N5ZIPH8mvSXK1CHoPTlSEsF";
        strArr[7] = "PVGkj9Ta";
        this.A06 = true;
        if (!this.A05) {
            A06();
        }
        OL ol2 = this.A00;
        if (ol2 != null) {
            ol2.A0B(c9h);
        }
        super.A07.setToolbarActionMessage(A03(0, 0, 25));
        A0H(z11, z12);
        super.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0E(AnonymousClass93 anonymousClass93) {
        if (this.A0B.getState() == RB.A02 && C1384Ih.A1D(super.A03)) {
            this.A0B.postDelayed(new C1638Si(this, anonymousClass93), 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0F(AnonymousClass93 anonymousClass93) {
        int iA00 = anonymousClass93.A00();
        if (this.A03) {
            int iA02 = super.A01.A0x().A0D().A02() - (iA00 / 1000);
            if (!ViewOnClickListenerC1667Tl.A08(super.A01)) {
                if (iA02 > 0) {
                    super.A07.setToolbarActionMessage(super.A01.A11().A02().replace(A03(0, 6, 74), String.valueOf(iA02)));
                } else {
                    super.A07.setToolbarActionMessage(A03(0, 0, 25));
                }
            }
            if (iA02 <= 0) {
                String[] strArr = A0M;
                if (strArr[2].length() == strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0M;
                strArr2[0] = "PXM0w4DTcyhv6xVVxlaJPbpxowOdlGPl";
                strArr2[4] = "ZagmJHoPVKqTZKI94Zh80WtjAbW4VeCE";
                A0H(false, false);
            }
        }
        float fMin = iA00 / Math.min(super.A01.A0x().A0D().A03() * 1000.0f, this.A0B.getDuration());
        super.A07.setProgress(100.0f * fMin);
        if (fMin < 1.0f || this.A05) {
            return;
        }
        A06();
        super.A07.setToolbarActionMode(getCloseButtonStyle());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(String str) {
        int currentPositionInMillis = 0;
        int duration = 0;
        SA sa2 = this.A0B;
        if (sa2 != null) {
            currentPositionInMillis = sa2.getCurrentPositionInMillis();
            duration = this.A0B.getDuration();
            this.A0B.A0Z(3);
        }
        super.A03.A0E().A2z(str);
        if (C1384Ih.A1E(super.A03)) {
            A0D(new C9H(currentPositionInMillis, duration), false, true);
            return;
        }
        MC mc2 = super.A08;
        if (A0M[3].charAt(0) == 'z') {
            throw new RuntimeException();
        }
        A0M[3] = "uhCmlX27t5rzSWT78KYVdoY12DutI5Be";
        mc2.A43(super.A09.A6y());
        super.A08.A43(super.A09.A6u());
    }

    private synchronized void A0H(boolean z11, boolean z12) {
        if (this.A03 && !z11 && !z12) {
            super.A08.A43(super.A09.A5s());
            this.A01.A05();
            this.A03 = false;
            OL ol2 = this.A00;
            if (ol2 != null) {
                ol2.A0w();
            }
            return;
        }
        this.A03 = false;
    }

    private int getCloseButtonStyle() {
        OL ol2 = this.A00;
        if (ol2 != null) {
            return ol2.getCloseButtonStyle();
        }
        return 0;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final void A0Q() {
        AbstractC1462Lo.A0L(this.A00);
        AbstractC1462Lo.A0L(super.A07);
        this.A0B.setVolume(super.A01.A0x().A0D().A09() ? 0.0f : 1.0f);
        this.A0B.A0b(QM.A02, 20);
        OL ol2 = this.A00;
        if (ol2 != null && this.A03) {
            ol2.A0x();
        }
        OL ol3 = this.A00;
        if (ol3 != null && !this.A05) {
            ol3.A0z();
        }
        A04();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final void A0S(C5V c5v) {
        c5v.A0N(this.A09);
        OL olA00 = A00(c5v.A0J().getResources().getConfiguration().orientation);
        this.A00 = olA00;
        addView(olA00, AbstractC1648Ss.A0E);
        addView(super.A07, new FrameLayout.LayoutParams(-1, super.A07.getToolbarHeight()));
        AbstractC1462Lo.A0H(this.A00);
        AbstractC1462Lo.A0H(super.A07);
        OL ol2 = this.A00;
        setUpFullscreenMode(ol2 != null && ol2.A11());
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss
    public final boolean A0T() {
        OL ol2 = this.A00;
        return ol2 != null && ol2.A12(this.A03);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACW(boolean z11) {
        if (this.A0B.A0i()) {
            return;
        }
        this.A02 = this.A0B.getVideoStartReason();
        this.A04 = z11;
        this.A0B.A0e(false, 13);
    }

    @Override // com.facebook.ads.redexgen.uinode.MD
    public final void ACu(boolean z11) {
        QM qm2;
        if (this.A0B.A0j() || this.A06 || this.A0B.getState() == RB.A06 || (qm2 = this.A02) == null) {
            return;
        }
        if (!this.A04 || z11) {
            SA sa2 = this.A0B;
            String[] strArr = A0M;
            if (strArr[0].charAt(8) == strArr[4].charAt(8)) {
                throw new RuntimeException();
            }
            A0M[1] = "5vrQw9TAnlgebYwA7tbvLzoGHglPMjBr";
            sa2.A0b(qm2, 19);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1648Ss, com.facebook.ads.redexgen.uinode.MD
    public final void onDestroy() {
        super.onDestroy();
        if (C1384Ih.A1W(super.A03)) {
            super.A03.A0A().AGk(this.A0B);
        }
        OL ol2 = this.A00;
        if (ol2 != null) {
            ol2.A0v();
        }
        SA sa2 = this.A0B;
        if (sa2 != null) {
            if (!this.A06) {
                sa2.A0a(QH.A05);
            }
            this.A0B.getEventBus().A04(this.A0H, this.A0G, this.A0F, this.A0I, this.A0D, this.A0E);
            this.A0B.A0V();
        }
        SF sf2 = this.A0A;
        if (sf2 != null) {
            sf2.A0C();
        }
        this.A0C.A0i();
    }

    public void setServerSideRewardHandler(Q7 q11) {
        this.A01 = q11;
    }
}

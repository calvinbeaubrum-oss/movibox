package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class T4 extends PQ {
    public static byte[] A0W;
    public static String[] A0X = {"zF", "YuhgBsbCJ4GENG72FYuTSQ3UxVCmrs0t", "RSfzcHToFNO8jc1tX2m0S0AZ0vbf9kKl", TtmlNode.TAG_P, "lGjhRdALEILVIUsiuWCm6MXJK2R8L6Co", "wXQvDYR5huLQKlTsBS5mG0rN7ygrQvR2", "AYgBJnzxyMi9rrwHO3oB8yOhTSWVLxNu", "3k2Jytm7iEKA6X2jmmGhgFSNDYaf4AHR"};
    public static final int A0Y;
    public static final int A0Z;
    public static final int A0a;
    public static final int A0b;
    public static final int A0c;
    public static final int A0d;
    public static final int A0e;
    public static final int A0f;
    public static final int A0g;
    public static final int A0h;
    public C1P A00;
    public L9 A01;
    public QM A02;
    public KI A03;
    public boolean A04;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public final int A08;
    public final int A09;
    public final int A0A;
    public final int A0B;
    public final C1795Yn A0C;
    public final AbstractC1514No A0D;
    public final ViewOnClickListenerC1667Tl A0E;
    public final InterfaceC1555Pd A0F;
    public final Q5 A0G;
    public final SF A0H;
    public final SA A0I;
    public final C9I A0J;
    public final AbstractC1572Pu A0K;
    public final AbstractC1570Ps A0L;
    public final AbstractC1539On A0M;
    public final O7 A0N;
    public final NX A0O;
    public final NQ A0P;
    public final LX A0Q;
    public final C1444Kw A0R;
    public final KP A0S;
    public final KA A0T;
    public final boolean A0U;
    public final boolean A0V;

    static {
        A0D();
        A0b = (int) (LD.A02 * 48.0f);
        int iA01 = AbstractC10112p.A01(-1, 77);
        A0Z = iA01;
        A0g = (int) (LD.A02 * 26.0f);
        A0h = (int) (LD.A02 * 12.0f);
        A0d = (int) (LD.A02 * 12.0f);
        A0e = (int) (LD.A02 * 44.0f);
        A0c = (int) (LD.A02 * 8.0f);
        A0f = (int) (LD.A02 * 16.0f);
        A0a = AbstractC10112p.A01(iA01, 90);
        A0Y = (int) (LD.A02 * 4.0f);
    }

    public T4(C1795Yn c1795Yn, J2 j11, AbstractC1898b5 abstractC1898b5, C11006c c11006c, InterfaceC1483Mj interfaceC1483Mj, int i11, MC mc2, JA ja2, int i12, int i13, int i14, boolean z11, int i15, boolean z12, boolean z13, boolean z14, InterfaceC1555Pd interfaceC1555Pd) {
        super(c1795Yn, interfaceC1483Mj, j11, abstractC1898b5, i11, z13, z14, mc2);
        this.A04 = false;
        this.A05 = false;
        this.A07 = false;
        AV av2 = new AV(this);
        this.A0O = av2;
        AO ao2 = new AO(this);
        this.A0N = ao2;
        A9 a11 = new A9(this);
        this.A0M = a11;
        A4 a12 = new A4(this);
        this.A0P = a12;
        A3 a13 = new A3(this);
        this.A0K = a13;
        A2 a14 = new A2(this);
        this.A0L = a14;
        this.A0C = c1795Yn;
        this.A0R = new C1444Kw(c1795Yn, ja2);
        this.A0S = new KP(c1795Yn);
        this.A0A = i15;
        this.A0V = z12;
        this.A09 = i12;
        this.A0B = i13;
        this.A0F = interfaceC1555Pd;
        this.A08 = i14;
        this.A0U = z11;
        this.A0G = new Q5(c1795Yn, j11, super.A05);
        this.A00 = i13 == 1 ? super.A05.A0w().A01() : super.A05.A0w().A00();
        SA sa2 = new SA(c1795Yn);
        this.A0I = sa2;
        sa2.getEventBus().A03(av2, ao2, a11, a12, a13, a14);
        C9I c9i = new C9I(c1795Yn, j11, sa2, abstractC1898b5.A12());
        this.A0J = c9i;
        A0C();
        sa2.setVideoURI(c11006c.A0S(super.A05.A0x().A0D().A08()));
        A0B();
        C1663Th c1663ThA05 = A05();
        this.A0D = c1663ThA05;
        KA ka2 = new KA(c1663ThA05, LogSeverity.WARNING_VALUE, 100, 0);
        this.A0T = ka2;
        ka2.A3Y(true, false);
        this.A0Q = new LX(true);
        A0E();
        ViewOnClickListenerC1667Tl cTAButton = c1663ThA05.getCTAButton();
        this.A0E = cTAButton;
        AbstractC1462Lo.A0G(1001, cTAButton);
        A0A();
        A09();
        c1663ThA05.bringToFront();
        if (C1384Ih.A1W(c1795Yn)) {
            c1795Yn.A0A().AGv(sa2, super.A05.A12(), true);
        }
        if (C1384Ih.A1X(c1795Yn)) {
            this.A0H = new SF(c1795Yn, j11, sa2, super.A05.A12(), c9i, null);
        } else {
            this.A0H = null;
        }
    }

    private C1663Th A05() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        C1663Th c1663Th = new C1663Th(this.A0C, A0b, super.A05.A0x().A0E().A00() == C1L.A05, getColors(), super.A05.A0x().A0F().A06(), super.A05.A0P().equals(A08(37, 14, 125)) ? QP.A04.A02() : A08(0, 37, 58), super.A07, super.A09, super.A0B, super.A08, super.A05.A0y());
        AbstractC1462Lo.A0G(PointerIconCompat.TYPE_TEXT, c1663Th);
        c1663Th.A0A(this.A0B);
        addView(c1663Th, layoutParams);
        c1663Th.setInfo(super.A05.A0x().A0E(), super.A05.A0x().A0F(), super.A05.A12(), super.A05.A10().A01(), null);
        return c1663Th;
    }

    public static String A08(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0W, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 44);
        }
        return new String(bArrCopyOfRange);
    }

    private void A09() {
        this.A0S.A06(-1, A0Z);
        KP kp2 = this.A0S;
        int i11 = A0h;
        kp2.setPadding(i11, i11, i11, i11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0g);
        layoutParams.addRule(12);
        addView(this.A0S, layoutParams);
    }

    private void A0A() {
        C1444Kw c1444Kw = this.A0R;
        int i11 = A0d;
        c1444Kw.setPadding(i11, i11, i11, i11);
        int i12 = A0e;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i12, i12);
        layoutParams.setMargins(0, MB.A00, A0c, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        addView(this.A0I, new RelativeLayout.LayoutParams(-1, -1));
        addView(this.A0R, layoutParams);
    }

    private void A0B() {
        postDelayed(new T7(this), C1384Ih.A0L(this.A0C));
    }

    private void A0C() {
        this.A0I.A0c(this.A0S);
        this.A0I.A0c(this.A0R);
        if (!TextUtils.isEmpty(super.A05.A0x().A0D().A07())) {
            C7R c7r = new C7R(this.A0C);
            this.A0I.A0c(c7r);
            c7r.setImage(super.A05.A0x().A0D().A07());
        }
        this.A0I.A0c(new C7H(this.A0C));
    }

    public static void A0D() {
        A0W = new byte[]{-55, -43, -45, -108, -52, -57, -55, -53, -56, -43, -43, -47, -108, -57, -54, -39, -108, -49, -44, -38, -53, -40, -39, -38, -49, -38, -49, -57, -46, -108, -55, -46, -49, -55, -47, -53, -54, Ascii.ESC, Ascii.SO, 32, 10, Ascii.ESC, Ascii.CR, Ascii.SO, Ascii.CR, 8, Ascii.US, Ascii.DC2, Ascii.CR, Ascii.SO, Ascii.CAN};
    }

    private final void A0E() {
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null) {
            KI ki2 = this.A03;
            if (ki2 != null) {
                this.A0Q.A0I(ki2);
            }
            C1P c1pA01 = super.A05.A0w().A01();
            this.A0Q.A0I(new KC(this.A0D.getCTAButton(), LogSeverity.NOTICE_VALUE, -1, c1pA01.A09(true)));
            int i11 = A0Z;
            int i12 = A0a;
            int i13 = A0Y;
            this.A0Q.A0I(new KM(this.A0D.getCTAButton(), LogSeverity.NOTICE_VALUE, AbstractC1462Lo.A08(i11, i12, i13), AbstractC1462Lo.A05(c1pA01.A08(true), i13)));
            this.A0Q.A0I(new KF(expandableLayout, 150, false));
            this.A0Q.A9R(this.A0I);
            this.A0Q.A0H(2300);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0G(AnonymousClass93 anonymousClass93) {
        if (this.A0I.getState() == RB.A02 && C1384Ih.A1D(this.A0C)) {
            postDelayed(new T6(this, anonymousClass93), 5000L);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A0z() {
        L9 l11 = this.A01;
        if (l11 != null) {
            l11.A06();
        }
        if (C1384Ih.A1W(this.A0C)) {
            this.A0C.A0A().AGk(this.A0I);
        }
        SF sf2 = this.A0H;
        if (sf2 != null) {
            sf2.A0C();
        }
        SA sa2 = this.A0I;
        if (sa2 != null) {
            sa2.getEventBus().A04(this.A0O, this.A0N, this.A0M, this.A0P, this.A0K, this.A0L);
            AbstractC1462Lo.A0H(this.A0I);
            this.A0I.A0V();
        }
        this.A0J.A0i();
        View[] viewArr = new View[3];
        viewArr[0] = this.A0I;
        KP kp2 = this.A0S;
        String[] strArr = A0X;
        if (strArr[0].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        A0X[2] = "4e1dr9g4n9kT22ZIdoKy0n8REVoGbgbF";
        viewArr[1] = kp2;
        viewArr[2] = this.A0R;
        AbstractC1462Lo.A0a(viewArr);
        super.A0B.A0V();
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A10() {
        this.A0C.A0E().A4F();
        this.A04 = true;
        AbstractC1462Lo.A0T(this);
        AbstractC1462Lo.A0H(this.A0I);
        AbstractC1462Lo.A0a(this.A0I, this.A0S, this.A0R);
        Pair<Q4, View> pairA03 = this.A0G.A03(this.A0E);
        View view = (View) pairA03.second;
        AbstractC1462Lo.A0G(1101, view);
        switch (PR.A00[((Q4) pairA03.first).ordinal()]) {
            case 1:
                this.A0D.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, MB.A00, 0, 0);
                layoutParams.addRule(2, this.A0D.getId());
                addView(view, layoutParams);
                break;
            case 2:
                AbstractC1462Lo.A0a(this.A0D);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                int i11 = A0f;
                layoutParams2.setMargins(i11, i11, i11, i11);
                addView(view, layoutParams2);
                break;
        }
        if (this.A08 != 0 || !this.A0U) {
            this.A05 = true;
            this.A0F.AD7(true);
            return;
        }
        if (this.A0V) {
            this.A0F.AGq();
        }
        L9 l11 = new L9(this.A0A, 100.0f, 100L, new Handler(Looper.getMainLooper()), new T5(this));
        this.A01 = l11;
        l11.A07();
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A11() {
        this.A0I.setVolume(super.A05.A0x().A0D().A09() ? 0.0f : 1.0f);
        this.A0I.A0b(QM.A02, 20);
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A12(boolean z11) {
        L9 l11 = this.A01;
        if (l11 != null) {
            l11.A06();
        }
        if (this.A0I.A0i()) {
            return;
        }
        this.A02 = this.A0I.getVideoStartReason();
        this.A06 = z11;
        this.A0I.A0e(false, 13);
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final void A13(boolean z11) {
        QM qm2;
        L9 l11 = this.A01;
        if (l11 != null && !l11.A05()) {
            L9 l12 = this.A01;
            if (A0X[5].charAt(17) != 'S') {
                throw new RuntimeException();
            }
            String[] strArr = A0X;
            strArr[7] = "pObqmm4LdTsqTcUgL7kozPbufRCkwYZC";
            strArr[6] = "5szeP9lNqMFVM0rzjOQcuK8NUDwg7u3G";
            l12.A07();
        }
        if (this.A04 || this.A0I.getState() == RB.A06 || (qm2 = this.A02) == null) {
            return;
        }
        if (!this.A06 || z11) {
            this.A0I.A0b(qm2, 19);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final boolean A14() {
        return (this.A08 == 2 || !super.A05.A0x().A0O() || this.A04) ? false : true;
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public final boolean A15() {
        return this.A04;
    }

    public C1P getColors() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public C1554Pc getFullScreenAdStyle() {
        return new C1554Pc(true, C1554Pc.A06, super.A05.A0w().A01(), ViewOnClickListenerC1667Tl.A08(super.A05), super.A05.A0w().A01().A07(true), super.A05.A0x().A0D().A07());
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ
    public C1454Lg getTouchDataRecorder() {
        return super.A08;
    }

    @Override // com.facebook.ads.redexgen.uinode.PQ, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        C1P c1pA00;
        super.onConfigurationChanged(configuration);
        if (this.A04) {
            return;
        }
        if (configuration.orientation == 1) {
            c1pA00 = super.A05.A0w().A01();
        } else {
            C1C c1cA0w = super.A05.A0w();
            if (A0X[4].charAt(4) != 'R') {
                throw new RuntimeException();
            }
            A0X[1] = "uYIsd2DhsQ91Wp0xmXJ9348eeMLtSRMf";
            c1pA00 = c1cA0w.A00();
        }
        this.A00 = c1pA00;
        this.A0E.setViewShowsOverMedia(true);
        this.A0E.setUpButtonColors(this.A00);
        this.A0D.A0A(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        View expandableLayout = this.A0D.getExpandableLayout();
        if (expandableLayout != null && z11 && this.A03 == null) {
            KI ki2 = new KI(expandableLayout, LogSeverity.NOTICE_VALUE, expandableLayout.getHeight(), 0);
            this.A03 = ki2;
            this.A0Q.A0I(ki2);
            this.A0Q.A0G();
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z11) {
        super.onWindowFocusChanged(z11);
        if (z11) {
            A13(false);
        } else {
            A12(false);
        }
    }
}

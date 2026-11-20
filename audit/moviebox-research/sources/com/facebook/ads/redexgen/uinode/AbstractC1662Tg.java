package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.logging.type.LogSeverity;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1662Tg extends OL implements OE {
    public static byte[] A08;
    public static String[] A09 = {"1qM0UqBuKeNFs4931PZdKXfB5ZchECK5", "3ZSmcCEAG5Dz0dWrJNlp2MNszP7YT25A", "Vrvau7r1HMpQKQXhvyVkTfJZAsfHOW4A", "oVRoE2FdK0le1s2SfNIozg00Kc9sH4MP", "npYoVlwUwM4clRwIxvjz9nauDkw8jySV", "7Yuh663Y", "kkRlGGIMUj7iwn7pYEfT9Vq54HRzcbQk", "UynwTjbvMY6JmtelA"};
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;
    public static final int A0E;
    public static final int A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public LX A00;
    public KI A01;
    public KA A02;
    public final AbstractC1898b5 A03;
    public final C1G A04;
    public final MC A05;
    public final AbstractC1514No A06;
    public final OG A07;

    static {
        A0D();
        A0D = (int) (LD.A02 * 48.0f);
        A0H = (int) (LD.A02 * 16.0f);
        A0A = (int) (LD.A02 * 4.0f);
        A0G = (int) (LD.A02 * 44.0f);
        A0E = (int) (LD.A02 * 8.0f);
        A0F = (int) (LD.A02 * 12.0f);
        A0J = (int) (LD.A02 * 12.0f);
        A0I = (int) (LD.A02 * 26.0f);
        int iA01 = AbstractC10112p.A01(-1, 77);
        A0B = iA01;
        A0C = AbstractC10112p.A01(iA01, 90);
    }

    public AbstractC1662Tg(OP op2, boolean z11) {
        super(op2, z11);
        AbstractC1898b5 abstractC1898b5A04 = op2.A04();
        this.A03 = abstractC1898b5A04;
        this.A07 = OG.A01(op2.A05(), abstractC1898b5A04, this);
        this.A04 = abstractC1898b5A04.A0x();
        this.A06 = A0B(op2);
        MB mbA08 = op2.A08();
        this.A05 = op2.A09();
        if (mbA08 != null) {
            mbA08.setLayoutParams(new RelativeLayout.LayoutParams(-1, mbA08.getToolbarHeight()));
            mbA08.setPageDetailsVisible(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:14:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:17:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:9:0x005c  */
    private C1663Th A0B(OP op2) {
        String strA0C;
        C1663Th c1663Th;
        boolean z11;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (!op2.A04().A0P().equals(A0C(37, 14, 56))) {
            if (A09[5].length() != 7) {
                A09[7] = "aLegEIjbGKC4WYI41vdDU1g9u";
                strA0C = A0C(0, 37, 124);
                C1795Yn c1795YnA05 = op2.A05();
                int i11 = A0D;
                if (this.A04.A0E().A00() == C1L.A05) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                c1663Th = new C1663Th(c1795YnA05, i11, z11, getColors(), this.A04.A0F().A06(), strA0C, op2.A06(), op2.A09(), op2.A0B(), op2.A07(), op2.A04().A0y());
                this.A02 = new KA(c1663Th, LogSeverity.WARNING_VALUE, 100, 0);
                AbstractC1462Lo.A0K(c1663Th);
                c1663Th.A0A(op2.A00());
                if (C1384Ih.A0y(op2.A05())) {
                    c1663Th.A09();
                    if (op2.A08() != null) {
                        op2.A08().setCTAClickListener(getCtaButton());
                    }
                }
                addView(c1663Th, layoutParams);
                c1663Th.getCTAButton().A0A(this.A03, op2.A08());
                return c1663Th;
            }
            throw new RuntimeException();
        }
        QP qp2 = QP.A04;
        if (A09[7].length() != 22) {
            String[] strArr = A09;
            strArr[6] = "Ca3psE1IPVUhCMreDaAATfbsplsRsoNT";
            strArr[1] = "q1VyT2b1NhDnFBLs9y9UP0y4iho0jP8D";
            strA0C = qp2.A02();
            C1795Yn c1795YnA06 = op2.A05();
            int i12 = A0D;
            if (this.A04.A0E().A00() == C1L.A05) {
                z11 = true;
            } else {
                z11 = false;
            }
            c1663Th = new C1663Th(c1795YnA06, i12, z11, getColors(), this.A04.A0F().A06(), strA0C, op2.A06(), op2.A09(), op2.A0B(), op2.A07(), op2.A04().A0y());
            this.A02 = new KA(c1663Th, LogSeverity.WARNING_VALUE, 100, 0);
            AbstractC1462Lo.A0K(c1663Th);
            c1663Th.A0A(op2.A00());
            if (C1384Ih.A0y(op2.A05())) {
                c1663Th.A09();
                if (op2.A08() != null) {
                    op2.A08().setCTAClickListener(getCtaButton());
                }
            }
            addView(c1663Th, layoutParams);
            c1663Th.getCTAButton().A0A(this.A03, op2.A08());
            return c1663Th;
        }
        throw new RuntimeException();
    }

    public static String A0C(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A08 = new byte[]{9, 5, 7, 68, Ascii.FF, Ascii.VT, 9, Ascii.SI, 8, 5, 5, 1, 68, Ascii.VT, Ascii.SO, Ascii.EM, 68, 3, 4, Ascii.RS, Ascii.SI, Ascii.CAN, Ascii.EM, Ascii.RS, 3, Ascii.RS, 3, Ascii.VT, 6, 68, 9, 6, 3, 9, 1, Ascii.SI, Ascii.SO, 92, 75, 89, 79, 92, 74, 75, 74, 113, 88, 71, 74, 75, 65};
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public void A0v() {
        super.A0v();
        this.A07.A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public void A10(C1G c1g, String str, double d11, Bundle bundle) {
        super.A10(c1g, str, d11, bundle);
        this.A06.setInfo(c1g.A0E(), c1g.A0F(), str, this.A03.A10().A01(), null);
    }

    public final int A13(MB mb2) {
        return mb2 == null ? MB.A00 : mb2.getToolbarHeight();
    }

    public void A14() {
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout != null) {
            LX lx2 = new LX(true);
            this.A00 = lx2;
            KI ki2 = this.A01;
            if (ki2 != null) {
                lx2.A0I(ki2);
            }
            C1P c1pA01 = this.A03.A0w().A01();
            this.A00.A0I(new KC(getAdDetailsView().getCTAButton(), LogSeverity.NOTICE_VALUE, -1, c1pA01.A09(true)));
            int i11 = A0B;
            int i12 = A0C;
            int i13 = A0A;
            this.A00.A0I(new KM(getAdDetailsView().getCTAButton(), LogSeverity.NOTICE_VALUE, AbstractC1462Lo.A08(i11, i12, i13), AbstractC1462Lo.A05(c1pA01.A08(true), i13)));
            this.A00.A0I(new KF(expandableLayout, 150, false));
            this.A00.A0H(2300);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.OE
    public final void AC9() {
        this.A05.A43(getAdDataBundle().A0L());
    }

    public AbstractC1898b5 getAdDataBundle() {
        return this.A03;
    }

    public KA getAdDetailsAnimation() {
        return this.A02;
    }

    public AbstractC1514No getAdDetailsView() {
        return this.A06;
    }

    public C1G getAdInfo() {
        return this.A04;
    }

    public LX getAnimationPlugin() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getAdDetailsView().A0A(configuration.orientation);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        View expandableLayout = getAdDetailsView().getExpandableLayout();
        if (expandableLayout == null || !z11) {
            return;
        }
        KI ki2 = this.A01;
        if (A09[2].charAt(30) != '4') {
            throw new RuntimeException();
        }
        A09[0] = "AO2Vor543jhYYkt1oYijcT7buZTkR3eI";
        if (ki2 == null) {
            KI ki3 = new KI(expandableLayout, LogSeverity.NOTICE_VALUE, expandableLayout.getHeight(), 0);
            this.A01 = ki3;
            this.A00.A0I(ki3);
            this.A00.A0G();
        }
    }
}

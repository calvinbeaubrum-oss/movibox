package com.facebook.ads.redexgen.uinode;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1658Tc extends OL implements OE {
    public static byte[] A05;
    public static final int A06;
    public final AbstractC1898b5 A00;
    public final MC A01;
    public final OG A02;
    public final C1538Om A03;
    public final C1566Po A04;

    static {
        A01();
        A06 = Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public C1658Tc(OP op2, boolean z11) {
        int id2;
        int iA01;
        super(op2, z11);
        this.A01 = op2.A09();
        AbstractC1898b5 abstractC1898b5A04 = op2.A04();
        this.A00 = abstractC1898b5A04;
        C1538Om c1538Om = new C1538Om(op2.A05(), op2.A02());
        this.A03 = c1538Om;
        c1538Om.A01(getTitleDescContainer(), z11);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.setMargins(OL.A07, OL.A07, OL.A07, OL.A07);
        getCtaButton().setLayoutParams(layoutParams);
        if (op2.A0C()) {
            C1566Po c1566Po = new C1566Po(op2.A05());
            this.A04 = c1566Po;
            c1566Po.setPageDetails(op2.A04().A10());
            AbstractC1462Lo.A0G(PointerIconCompat.TYPE_CROSSHAIR, c1566Po);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(2, getCtaButton().getId());
            layoutParams2.setMargins(OL.A07, OL.A07 - (OL.A07 / 2), OL.A07, 0);
            c1566Po.setLayoutParams(layoutParams2);
            id2 = c1566Po.getId();
            iA01 = op2.A01() - (OL.A07 / 2);
        } else {
            id2 = getCtaButton().getId();
            iA01 = op2.A01();
            this.A04 = null;
        }
        FrameLayout frameLayout = new FrameLayout(op2.A05());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams3.addRule(10);
        layoutParams3.addRule(2, id2);
        layoutParams3.setMargins(0, iA01, 0, 0);
        frameLayout.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 17;
        layoutParams4.setMargins(OL.A07, 0, OL.A07, 0);
        frameLayout.addView(c1538Om, layoutParams4);
        addView(frameLayout);
        View view = this.A04;
        if (view != null) {
            addView(view);
        }
        addView(getCtaButton());
        getCtaButton().A0A(op2.A04(), op2.A08());
        View viewA02 = op2.A02();
        OG ogA01 = OG.A01(op2.A05(), abstractC1898b5A04, this);
        this.A02 = ogA01;
        OF ofA09 = ogA01.A09(abstractC1898b5A04);
        op2.A05().A0F().A00(ofA09.A01);
        if (viewA02 != null && ofA09.A00) {
            getCtaButton().setCreativeAsCtaLoggingHelper(ogA01);
            viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.OV
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.A00.A13(view2);
                }
            });
        } else if (viewA02 != null && C1384Ih.A16(getAdContextWrapper())) {
            AbstractC1511Nl.A00(viewA02, C1384Ih.A17(getAdContextWrapper()), new OW(this));
        }
        if (C1384Ih.A0y(op2.A05())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (op2.A08() != null) {
                op2.A08().setCTAClickListener(getCtaButton());
            }
        }
        if (this.A04 == null || !C1384Ih.A0z(op2.A05())) {
            return;
        }
        this.A04.setOnClickListener(getCtaButton());
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] ^ i13) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{52, 48, 60, 58, 56};
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A02() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A0D() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0v() {
        super.A0v();
        this.A02.A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A10(C1G c1g, String str, double d11, Bundle bundle) {
        super.A10(c1g, str, d11, bundle);
        if (d11 > 0.0d) {
            this.A03.A00((int) (((double) (A06 - (OL.A07 * 2))) / d11));
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A11() {
        return false;
    }

    public final /* synthetic */ void A13(View view) {
        getCtaButton().A09(A00(0, 5, 75));
    }

    @Override // com.facebook.ads.redexgen.uinode.OE
    public final void AC9() {
        this.A01.A43(this.A00.A0L());
    }
}

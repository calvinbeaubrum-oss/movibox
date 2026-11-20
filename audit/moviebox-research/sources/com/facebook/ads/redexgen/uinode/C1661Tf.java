package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.PointerIconCompat;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1661Tf extends OL implements OE {
    public static byte[] A03;
    public final AbstractC1898b5 A00;
    public final MC A01;
    public final OG A02;

    static {
        A01();
    }

    public C1661Tf(OP op2, boolean z11) {
        super(op2, true);
        this.A01 = op2.A09();
        AbstractC1898b5 abstractC1898b5A04 = op2.A04();
        this.A00 = abstractC1898b5A04;
        RelativeLayout relativeLayout = new RelativeLayout(op2.A05());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        AbstractC1462Lo.A0R(relativeLayout, getAdContextWrapper());
        LinearLayout linearLayout = new LinearLayout(op2.A05());
        linearLayout.setOrientation(!z11 ? 1 : 0);
        linearLayout.setGravity(80);
        AbstractC1462Lo.A0K(linearLayout);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(OL.A07, 0, OL.A07, OL.A07);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(z11 ? -2 : -1, -2);
        layoutParams3.setMargins(z11 ? OL.A07 : 0, z11 ? 0 : OL.A07, 0, 0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(z11 ? 0 : -1, -2);
        layoutParams4.setMargins(0, 0, 0, 0);
        layoutParams4.weight = 1.0f;
        linearLayout.addView(getTitleDescContainer(), layoutParams4);
        OG ogA01 = OG.A01(op2.A05(), abstractC1898b5A04, this);
        this.A02 = ogA01;
        OF ofA09 = ogA01.A09(abstractC1898b5A04);
        op2.A05().A0F().A00(ofA09.A01);
        if (op2.A0C() && !z11) {
            C1566Po c1566Po = new C1566Po(op2.A05());
            c1566Po.setPageDetails(op2.A04().A10());
            int iA04 = this.A06.A04().A0w().A00().A04(true);
            c1566Po.A02(iA04, iA04);
            AbstractC1462Lo.A0G(PointerIconCompat.TYPE_CROSSHAIR, c1566Po);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams5.setMargins(0, OL.A07, 0, 0);
            linearLayout.addView(c1566Po, layoutParams5);
            if (C1384Ih.A0z(op2.A05())) {
                c1566Po.setOnClickListener(getCtaButton());
            }
        }
        linearLayout.addView(getCtaButton(), layoutParams3);
        relativeLayout.addView(linearLayout, layoutParams2);
        getCtaButton().A0A(op2.A04(), op2.A08());
        View viewA02 = op2.A02();
        if (viewA02 != null && (ofA09.A00 || C1384Ih.A16(getAdContextWrapper()))) {
            FrameLayout.LayoutParams layoutParams6 = z11 ? new FrameLayout.LayoutParams(-2, -1) : new FrameLayout.LayoutParams(-1, -2);
            layoutParams6.gravity = 17;
            FrameLayout frameLayout = new FrameLayout(op2.A05());
            frameLayout.addView(viewA02, layoutParams6);
            addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
            if (ofA09.A00) {
                getCtaButton().setCreativeAsCtaLoggingHelper(ogA01);
                viewA02.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.OJ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.A00.A13(view);
                    }
                });
            } else {
                AbstractC1511Nl.A00(viewA02, C1384Ih.A17(getAdContextWrapper()), new OK(this));
            }
        } else if (viewA02 != null) {
            addView(viewA02, new RelativeLayout.LayoutParams(-1, -1));
        }
        addView(relativeLayout, layoutParams);
        if (C1384Ih.A0y(op2.A05())) {
            getTitleDescContainer().setCTAClickListener(getCtaButton());
            if (op2.A08() != null) {
                op2.A08().setCTAClickListener(getCtaButton());
            }
        }
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-22, -18, -30, -24, -26};
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0v() {
        super.A0v();
        this.A02.A0A();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A10(C1G c1g, String str, double d11, Bundle bundle) {
        super.A10(c1g, str, d11, bundle);
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A11() {
        return true;
    }

    public final /* synthetic */ void A13(View view) {
        getCtaButton().A09(A00(0, 5, 88));
    }

    @Override // com.facebook.ads.redexgen.uinode.OE
    public final void AC9() {
        this.A01.A43(this.A00.A0L());
    }
}

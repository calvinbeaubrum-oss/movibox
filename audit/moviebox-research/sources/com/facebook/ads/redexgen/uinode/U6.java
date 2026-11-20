package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.Explode;
import android.transition.TransitionSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class U6 extends AbstractC1488Mo {
    public static final int A03 = (int) (LD.A02 * 8.0f);
    public final RelativeLayout A00;
    public final C2S A01;
    public final C1795Yn A02;

    public U6(C1795Yn c1795Yn, J2 j11, String str, C09701a c09701a, MD md2, MC mc2) {
        super(c1795Yn, j11, str, c09701a, md2, mc2);
        this.A02 = c1795Yn;
        this.A01 = C2T.A00(c1795Yn.A01());
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.A00 = relativeLayout;
        addView(relativeLayout, new RelativeLayout.LayoutParams(-1, -1));
        AbstractC1462Lo.A0M(relativeLayout, -1728053248);
        relativeLayout.setOnClickListener(new ViewOnClickListenerC1493Mt(this));
    }

    public static RelativeLayout.LayoutParams A0B(boolean z11) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, z11 ? -1 : -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    private void A0C() {
        if (Build.VERSION.SDK_INT < 21) {
            AbstractC1462Lo.A0T(this);
            return;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(new ChangeBounds()).addTransition(new Explode());
        AbstractC1462Lo.A0V(this, transitionSet);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0L() {
        C2W c2wA0A = this.A01.A0A();
        N3 n11 = new N3(this.A02);
        n11.setInfo(EnumC1470Lw.HIDE_AD, this.A01.A0H(), this.A01.A0G());
        n11.setOnClickListener(new ViewOnClickListenerC1494Mu(this));
        C2W c2wA0B = this.A01.A0B();
        N3 n12 = new N3(this.A02);
        n12.setInfo(EnumC1470Lw.REPORT_AD, this.A01.A0L(), this.A01.A0K());
        n12.setOnClickListener(new ViewOnClickListenerC1495Mv(this));
        N3 n13 = new N3(this.A02);
        n13.setInfo(EnumC1470Lw.AD_CHOICES_ICON, this.A01.A0M(), "");
        n13.setOnClickListener(new ViewOnClickListenerC1496Mw(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        linearLayout.setOrientation(1);
        int i11 = A03;
        linearLayout.setPadding(i11 * 2, i11, i11 * 2, i11);
        AbstractC1462Lo.A0M(linearLayout, -1);
        if (!c2wA0A.A05().isEmpty()) {
            linearLayout.addView(n11, layoutParams);
        }
        if (!c2wA0B.A05().isEmpty()) {
            linearLayout.addView(n12, layoutParams);
        }
        linearLayout.addView(n13, layoutParams);
        A0C();
        this.A00.removeAllViews();
        this.A00.addView(linearLayout, A0B(false));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0M() {
        AbstractC1462Lo.A0I(this);
        this.A00.removeAllViews();
        AbstractC1462Lo.A0J(this);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0N(C2W c2w, C2U c2u) {
        if (c2u == C2U.A04) {
            return;
        }
        boolean z11 = c2u == C2U.A05;
        C1487Mn c1487MnA0M = new C1486Mm(this.A02, this.A0B).A0I(z11 ? this.A01.A0F() : this.A01.A0E()).A0H(this.A01.A0D()).A0F(c2w.A04()).A0E(z11 ? EnumC1470Lw.REPORT_AD : EnumC1470Lw.HIDE_AD).A0D(z11 ? -552389 : -13272859).A0G(this.A0A != null ? this.A0A.A01() : "").A0M();
        AbstractC1462Lo.A0M(c1487MnA0M, -1);
        AbstractC1462Lo.A0T(this);
        this.A00.removeAllViews();
        this.A00.addView(c1487MnA0M, A0B(true));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final void A0O(C2W c2w, C2U c2u) {
        boolean z11 = c2u == C2U.A05;
        N6 n11 = new N6(this.A02, c2w, this.A0B, z11 ? this.A01.A0L() : this.A01.A0H(), z11 ? EnumC1470Lw.REPORT_AD : EnumC1470Lw.HIDE_AD);
        n11.setClickable(true);
        AbstractC1462Lo.A0M(n11, -1);
        int i11 = A03;
        n11.setPadding(i11 * 2, i11, i11 * 2, i11);
        A0C();
        this.A00.removeAllViews();
        this.A00.addView(n11, A0B(false));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1488Mo
    public final boolean A0P() {
        return false;
    }
}

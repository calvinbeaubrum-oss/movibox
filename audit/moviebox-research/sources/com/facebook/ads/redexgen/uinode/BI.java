package com.facebook.ads.redexgen.uinode;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.logging.type.LogSeverity;
import com.transsion.gslb.Worker;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BI extends AbstractC1662Tg {
    public static byte[] A0F;
    public static String[] A0G = {"QUFYIN7o4MSHfMbcaqgxGqdg8oING", "Qixa92rp7KQSHPhBId3L5m9SXc6gxNRP", "TUKhftCqFUFv9xNbjbPA3CLhBIkdW", "aNiMBj1VMT3xct4Co4hWzqTsg", "QYSCqyZ4CS", "VjIbmM2G6pRRrYhuKIf6SOzC6eQUF7eo", "KFJXOgKoK7JNlCBWMf", "dachHr6cLZKwbIDqTeRsc0FgbmZCJ"};
    public View A00;
    public View A01;
    public C1795Yn A02;
    public L9 A03;
    public MB A04;
    public Q5 A05;
    public KA A06;
    public boolean A07;
    public boolean A08;
    public final MC A09;
    public final O0 A0A;
    public final O1 A0B;
    public final SA A0C;
    public final KP A0D;
    public final AtomicBoolean A0E;

    static {
        A08();
    }

    public BI(OP op2) {
        super(op2, false);
        this.A0E = new AtomicBoolean(false);
        this.A08 = false;
        this.A07 = false;
        this.A02 = op2.A05();
        this.A04 = op2.A08();
        View view = new View(this.A02);
        this.A01 = view;
        AbstractC1462Lo.A0K(view);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(0, 0);
        layoutParams.addRule(13);
        addView(this.A01, layoutParams);
        A05();
        MC mcA09 = op2.A09();
        this.A09 = mcA09;
        OA.A00(op2.A05(), this, getAdInfo().A0D().A07());
        SA saA01 = A01(op2);
        this.A0C = saA01;
        getAdDetailsView().bringToFront();
        KP kpA02 = A02(op2);
        this.A0D = kpA02;
        A14();
        this.A05 = new Q5(this.A02, op2.A06(), getAdDataBundle());
        C1660Te c1660Te = new C1660Te(this);
        this.A0A = c1660Te;
        this.A0B = new O1(op2, getAdDataBundle(), saA01, kpA02, getAdDetailsView(), mcA09, c1660Te);
        OF ofA09 = super.A07.A09(getAdDataBundle());
        this.A02.A0F().A00(ofA09.A01);
        if (ofA09.A00) {
            getCtaButton().setCreativeAsCtaLoggingHelper(super.A07);
            saA01.getVideoImplView().setOnClickListener(new OS(this));
        } else if (C1384Ih.A18(getAdContextWrapper())) {
            AbstractC1511Nl.A00(saA01.getVideoImplView(), C1384Ih.A19(getAdContextWrapper()), new OT(this));
        }
    }

    private SA A01(OP op2) {
        SA sa2 = (SA) op2.A02();
        int iA13 = A13(op2.A08());
        ImageView imageView = (ImageView) op2.A03();
        imageView.setPadding(AbstractC1662Tg.A0F, AbstractC1662Tg.A0F, AbstractC1662Tg.A0F, AbstractC1662Tg.A0F);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractC1662Tg.A0G, AbstractC1662Tg.A0G);
        layoutParams.setMargins(0, iA13, AbstractC1662Tg.A0E, 0);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(13);
        addView(sa2, layoutParams2);
        sa2.addView(imageView, layoutParams);
        return sa2;
    }

    private KP A02(OP op2) {
        KP kpA0A = op2.A0A();
        kpA0A.A06(-1, AbstractC1662Tg.A0B);
        kpA0A.setPadding(AbstractC1662Tg.A0J, AbstractC1662Tg.A0J, AbstractC1662Tg.A0J, AbstractC1662Tg.A0J);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1662Tg.A0I);
        layoutParams.addRule(12);
        addView(kpA0A, layoutParams);
        return kpA0A;
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 13);
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A0E();
            this.A0C.A0d(getAnimationPlugin());
        }
    }

    private void A05() {
        MB mb2 = this.A04;
        if (mb2 == null) {
            return;
        }
        this.A06 = new KA(mb2, LogSeverity.WARNING_VALUE, -mb2.getToolbarHeight(), 0);
    }

    private void A06() {
        new JA(getAdDataBundle().A12(), getAdEventManager()).A04(J9.A0r, null);
        if (getAdInfo().A0O()) {
            this.A0E.set(true);
            AbstractC1462Lo.A0T(this);
            AbstractC1462Lo.A0H(this.A0C);
            AbstractC1462Lo.A0a(this.A0C, this.A0D, this.A0B, this.A00);
            AbstractC1462Lo.A0L(this.A04);
            Q5 q11 = this.A05;
            ViewOnClickListenerC1667Tl ctaButton = getCtaButton();
            String[] strArr = A0G;
            if (strArr[2].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            A0G[3] = "FxfG3zWETYKhpCEsP1aqGpvXk";
            Pair<Q4, View> pairA03 = q11.A03(ctaButton);
            this.A00 = (View) pairA03.second;
            switch (OU.A00[((Q4) pairA03.first).ordinal()]) {
                case 1:
                    getAdDetailsView().setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.setMargins(0, A13(this.A04), 0, 0);
                    layoutParams.addRule(2, getAdDetailsView().getId());
                    addView(this.A00, layoutParams);
                    break;
                case 2:
                    AbstractC1462Lo.A0a(getAdDetailsView());
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(AbstractC1662Tg.A0H, AbstractC1662Tg.A0H, AbstractC1662Tg.A0H, AbstractC1662Tg.A0H);
                    addView(this.A00, layoutParams2);
                    break;
            }
            if (getAdInfo().A0G().A00() >= 0) {
                this.A07 = true;
                MB mb2 = this.A04;
                if (mb2 != null) {
                    mb2.setToolbarActionMode(2);
                    this.A04.setProgressImmediate(0.0f);
                }
                L9 l11 = new L9((int) getAdInfo().A0G().A00(), 20.0f, 20L, new Handler(Looper.getMainLooper()), new C1659Td(this));
                this.A03 = l11;
                l11.A07();
            }
        }
    }

    private void A07() {
        KA ka2 = this.A06;
        if (ka2 != null) {
            ka2.A3Y(true, false);
        }
        if (getAdDetailsAnimation() != null) {
            getAdDetailsAnimation().A3Y(true, false);
        }
    }

    public static void A08() {
        A0F = new byte[]{-53, -60, -39, -56, -30, -42, -41, -60, -43, -41, -52, -47, -54, -30, -60, -47, -52, -48, -60, -41, -52, -46, -47, -42, -30, -45, -49, -60, -36, -56, -57, -51, -48, -44, -58, -32, -45, -58, -40, -62, -45, -59, -32, -44, -60, -45, -58, -58, -49, -32, -44, -55, -48, -40, -49, -53, -75, -57, -45, -71, -62, -72, -45, -73, -75, -58, -72, -45, -57, -68, -61, -53, -62};
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0B(C9H c9h) {
        super.A0B(c9h);
        A06();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final void A0C(AnonymousClass93 anonymousClass93) {
        super.A0C(anonymousClass93);
        int duration = this.A0C.getDuration() - anonymousClass93.A00();
        if (getAnimationPlugin() != null) {
            if (A0G[1].charAt(18) != '3') {
                throw new RuntimeException();
            }
            A0G[5] = "xiBnzSw2W6K3rvYkwdUGMYXv5m3ZqRWR";
            if (duration >= 3000 || !getAnimationPlugin().A0J()) {
                return;
            }
            getAnimationPlugin().A0F();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1662Tg, com.facebook.ads.redexgen.uinode.OL
    public final void A0v() {
        super.A0v();
        A04();
        this.A04 = null;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1662Tg, com.facebook.ads.redexgen.uinode.OL
    public final void A10(C1G c1g, String str, double d11, Bundle bundle) {
        super.A10(c1g, str, d11, bundle);
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!bundle.getBoolean(A03(0, 31, 118), false)) {
            A07();
        }
        if (bundle.getBoolean(A03(55, 18, Worker.WHAT_SYNC_DATA), false)) {
            A06();
        }
        if (bundle.getBoolean(A03(31, 24, 116), false)) {
            O1 o11 = this.A0B;
            if (A0G[1].charAt(18) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "jjtMTZWEM7Dg1szUnnnmuTjwvMhej";
            strArr[0] = "cexdZia4vusGbXInA5fVVHDcQrSB4";
            o11.A07(this);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A11() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x004a  */
    @Override // com.facebook.ads.redexgen.uinode.OL
    public final boolean A12(boolean z11) {
        boolean zA0O;
        if (!z11 || this.A08) {
            zA0O = getAdInfo().A0O();
            if (A0G[5].charAt(17) != 'k') {
                A0G[1] = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor";
                if (!zA0O && !this.A0E.get()) {
                    this.A0C.A0a(QH.A08);
                    return true;
                }
            }
        } else {
            boolean z12 = this.A0E.get();
            String[] strArr = A0G;
            if (strArr[7].length() != strArr[4].length()) {
                String[] strArr2 = A0G;
                strArr2[2] = "IfEmWBIDBUNw5tL7YhS4lNzldGhzw";
                strArr2[0] = "8CoNQoXVMdzgwU1krh95bRLsSKKH4";
                if (!z12) {
                    this.A0B.A07(this);
                    return true;
                }
                zA0O = getAdInfo().A0O();
                if (A0G[5].charAt(17) != 'k') {
                    A0G[1] = "YRUjLZqfjvY5EOxU383ujQcW8j7gUgor";
                    return !zA0O ? false : false;
                }
            }
        }
        throw new RuntimeException();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1662Tg
    public final void A14() {
        super.A14();
        if (getAnimationPlugin() != null) {
            getAnimationPlugin().A9R(this.A0C);
        }
    }

    public final boolean A15() {
        return getAdInfo().A0O();
    }

    @Override // com.facebook.ads.redexgen.uinode.OL
    public int getCloseButtonStyle() {
        if (this.A07) {
            return 2;
        }
        if (!A15() || this.A0E.get()) {
            return super.getCloseButtonStyle();
        }
        return 1;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC1662Tg, com.facebook.ads.redexgen.uinode.OL, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}

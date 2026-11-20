package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZQ extends AbstractC09600q {
    public static byte[] A03;
    public View A00;
    public final C5P A01;
    public final EQ A02;

    static {
        A03();
    }

    public ZQ(C5P c5p) {
        this.A02 = c5p.A09();
        this.A01 = c5p;
    }

    public static String A02(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-23, 7, Ascii.DC4, Ascii.DC4, Ascii.NAK, Ascii.SUB, -58, Ascii.SYN, Ascii.CAN, Ascii.VT, Ascii.EM, Ascii.VT, Ascii.DC4, Ascii.SUB, -58, Ascii.DC4, Ascii.ESC, Ascii.DC2, Ascii.DC2, -58, 7, 10, -4, Ascii.SI, Ascii.VT, Ascii.GS};
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0C() {
        this.A02.A0E().A3o();
        KK.A00(new ZS(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0D() {
        this.A02.A0E().A3r();
        KK.A00(new ZR(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0E(View view) {
        if (view == null) {
            throw new IllegalStateException(A02(0, 26, 113));
        }
        this.A02.A0E().A3q();
        this.A00 = view;
        this.A01.A07().removeAllViews();
        this.A01.A07().addView(this.A00);
        if (this.A00 instanceof C1674Ts) {
            AbstractC1407Ji.A01(this.A01.A05(), this.A00, this.A01.A0A());
        }
        FR frA08 = this.A01.A08();
        if (frA08 != null) {
            frA08.A0I();
        }
        KK.A00(new ZT(this));
        C5P c5p = this.A01;
        c5p.A0B(c5p.A07(), this.A00);
        if (Build.VERSION.SDK_INT < 18 || !C1384Ih.A11(this.A01.A07().getContext())) {
            return;
        }
        final C1506Ng c1506Ng = new C1506Ng();
        this.A01.A0D(c1506Ng);
        c1506Ng.A0C(this.A01.getPlacementId());
        c1506Ng.A0B(this.A01.A07().getContext().getPackageName());
        if (this.A01.A08() != null && this.A01.A08().A0H() != null) {
            c1506Ng.A09(this.A01.A08().A0H().A0C());
        }
        View view2 = this.A00;
        if (view2 instanceof C1674Ts) {
            c1506Ng.A0A(((C1674Ts) view2).getViewabilityChecker());
        }
        this.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.5Z
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view3) {
                if (this.A00.A00 != null) {
                    c1506Ng.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
                    C1506Ng c1506Ng2 = c1506Ng;
                    c1506Ng2.A0D(!c1506Ng2.A0E());
                }
                return true;
            }
        });
        this.A00.getOverlay().add(c1506Ng);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0F(InterfaceC09590p interfaceC09590p) {
        this.A02.A0E().A3p(this.A01.A08() != null);
        if (this.A01.A08() != null) {
            this.A01.A08().A0J();
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC09600q
    public final void A0G(C1401Jb c1401Jb) {
        this.A02.A0E().A2m(C1453Lf.A01(this.A01.A04()), c1401Jb.A03().getErrorCode(), c1401Jb.A04());
        KK.A00(new ZU(this, c1401Jb));
    }
}

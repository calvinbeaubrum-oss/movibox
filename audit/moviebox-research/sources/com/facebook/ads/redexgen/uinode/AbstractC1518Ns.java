package com.facebook.ads.redexgen.uinode;

import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1518Ns {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.ads.redexgen.X.3n] */
    public static C10353n A00(final OP op2, final V2 v11, final String str, final BQ bq2) {
        final boolean z11 = true;
        return new BK(op2, v11, z11, str, bq2) { // from class: com.facebook.ads.redexgen.X.3n
            public ViewOnClickListenerC1667Tl A00;
            public C1567Pp A01;
            public final J2 A02 = this.A0I.A05().A01().A09();
            public final V2 A03;
            public final BQ A04;
            public final String A05;
            public static final int A07 = (int) (LD.A02 * (-4.0f));
            public static final int A06 = (int) (LD.A02 * 6.0f);

            {
                this.A03 = v11;
                this.A05 = str;
                this.A04 = bq2;
                v11.A1K(this);
            }

            @Override // com.facebook.ads.redexgen.uinode.TS
            public void setupNativeCtaExtension(C1567Pp c1567Pp) {
                this.A01 = c1567Pp;
                int iA0M = C1384Ih.A0M(this.A0I.A05());
                C1P c1pA01 = this.A03.A0z().A0w().A01();
                ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl = new ViewOnClickListenerC1667Tl(this.A0I.A05(), this.A03.A0z().A0L(), c1pA01, this.A02, NW.getDummyListener(), this.A04.A0b(), this.A03.A19(), this.A03.A0z() == null ? null : this.A03.A0z().A0y());
                this.A00 = viewOnClickListenerC1667Tl;
                viewOnClickListenerC1667Tl.setCta(c1567Pp.A03().A0F(), this.A05, new HashMap());
                this.A03.A1K(this.A00);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (iA0M == 1) {
                    layoutParams.addRule(12);
                    AbstractC1462Lo.A0P(this.A00, A06, 5, c1pA01.A09(false));
                    ((BK) this).A06.addView(this.A00, layoutParams);
                } else if (iA0M == 2) {
                    layoutParams.addRule(3, ((BK) this).A06.getId());
                    layoutParams.setMargins(0, A07, 0, 0);
                    addView(this.A00, 0, layoutParams);
                    ((BK) this).A06.bringToFront();
                }
            }
        };
    }
}

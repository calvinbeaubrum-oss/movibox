package com.facebook.ads.redexgen.uinode;

import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ox, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1549Ox {
    public static B4 A00(final OP op2, int i11, final String str, final C1631Sb c1631Sb) {
        return i11 == 1 ? new B4(op2, str, c1631Sb) { // from class: com.facebook.ads.redexgen.X.3Q
            public static final int A00 = (int) (LD.A02 * 20.0f);
            public static final int A01 = (int) (LD.A02 * 16.0f);

            @Override // com.facebook.ads.redexgen.uinode.OL
            public final boolean A01() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.uinode.B4
            public final void A19(C1795Yn c1795Yn) {
                O9 titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                titleDescContainer.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                titleDescContainer.setPadding(0, 0, 0, A00);
                getCtaButton().setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                LinearLayout linearLayout = new LinearLayout(c1795Yn);
                AbstractC1462Lo.A0S(linearLayout, new ColorDrawable(-1));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(3, getMediaContainer().getId());
                linearLayout.setLayoutParams(layoutParams);
                linearLayout.setOrientation(1);
                int i12 = A01;
                linearLayout.setPadding(i12, i12, i12, i12);
                linearLayout.addView(titleDescContainer);
                linearLayout.addView(getCtaButton());
                addView(getMediaContainer());
                addView(linearLayout);
            }
        } : new B4(op2, str, c1631Sb) { // from class: com.facebook.ads.redexgen.X.3b
            public static final int A00 = (int) (LD.A02 * 12.0f);

            @Override // com.facebook.ads.redexgen.uinode.OL
            public final boolean A00() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.uinode.B4, com.facebook.ads.redexgen.uinode.OL
            public final boolean A0D() {
                return false;
            }

            @Override // com.facebook.ads.redexgen.uinode.B4
            public final void A19(C1795Yn c1795Yn) {
                O9 titleDescContainer = getTitleDescContainer();
                titleDescContainer.setAlignment(3);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(8, getMediaContainer().getId());
                titleDescContainer.setLayoutParams(layoutParams);
                int i12 = A00;
                titleDescContainer.setPadding(i12, i12, i12, i12);
                AbstractC1462Lo.A0R(titleDescContainer, getAdContextWrapper());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams2.addRule(3, getMediaContainer().getId());
                getCtaButton().setLayoutParams(layoutParams2);
                addView(getMediaContainer());
                addView(titleDescContainer);
                addView(getCtaButton());
            }
        };
    }
}

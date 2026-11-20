package com.facebook.ads.redexgen.uinode;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ed, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1280Ed extends C1820Zn {
    public final /* synthetic */ C1279Ec A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1280Ed(C1279Ec c1279Ec, Context context) {
        super(context);
        this.A00 = c1279Ec;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn, com.facebook.ads.redexgen.uinode.AnonymousClass51
    public final void A0I(View view, AnonymousClass53 anonymousClass53, C10714z c10714z) {
        C1279Ec c1279Ec = this.A00;
        int[] iArrA0H = c1279Ec.A0H(((ZY) c1279Ec).A00.getLayoutManager(), view);
        int i11 = iArrA0H[0];
        int i12 = iArrA0H[1];
        int iA0M = A0M(Math.max(Math.abs(i11), Math.abs(i12)));
        if (iA0M > 0) {
            c10714z.A04(i11, i12, iA0M, ((C1820Zn) this).A04);
        }
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final float A0J(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final int A0L(int i11) {
        return Math.min(100, super.A0L(i11));
    }
}

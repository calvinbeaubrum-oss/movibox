package com.facebook.ads.redexgen.uinode;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1222Bh extends C1820Zn {
    public final /* synthetic */ C1221Bg A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1222Bh(C1221Bg c1221Bg, C1795Yn c1795Yn) {
        super(c1795Yn);
        this.A00 = c1221Bg;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final float A0J(DisplayMetrics displayMetrics) {
        return this.A00.A00 / displayMetrics.densityDpi;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final int A0K() {
        return -1;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final int A0O(View view, int i11) {
        AbstractC10614o abstractC10614oA08 = A08();
        if (!abstractC10614oA08.A20()) {
            return 0;
        }
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return A0N(abstractC10614oA08.A0k(view) - c10624p.leftMargin, abstractC10614oA08.A0n(view) + c10624p.rightMargin, abstractC10614oA08.A0e(), abstractC10614oA08.A0h() - abstractC10614oA08.A0f(), i11) + this.A00.A02;
    }

    @Override // com.facebook.ads.redexgen.uinode.C1820Zn
    public final PointF A0P(int i11) {
        return this.A00.A4O(i11);
    }
}

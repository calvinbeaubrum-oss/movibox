package com.facebook.ads.redexgen.uinode;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FW extends AbstractC1899b6 {
    public final C1795Yn A00;

    public FW(C3C c3c, List<V2> list, C1795Yn c1795Yn) {
        super(c3c, list, c1795Yn);
        this.A00 = c1795Yn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final UR A0C(ViewGroup viewGroup, int i11) {
        return new UR(new MN(this.A00));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A0H, reason: merged with bridge method [inline-methods] */
    public final void A0D(UR ur2, int i11) {
        super.A0D(ur2, i11);
        MN mn2 = (MN) ur2.A0j();
        MZ mz2 = (MZ) mn2.getImageCardView();
        mz2.setImageDrawable(null);
        A0F(mz2, i11);
        V2 v11 = ((AbstractC1899b6) this).A01.get(i11);
        v11.A11().A0K(this.A00);
        v11.A1N(mn2, mn2);
    }
}

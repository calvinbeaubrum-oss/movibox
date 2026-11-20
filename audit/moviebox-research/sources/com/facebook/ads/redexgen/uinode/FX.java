package com.facebook.ads.redexgen.uinode;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FX extends AbstractC1899b6 {
    public final C1795Yn A00;
    public final JR A01;

    public FX(C1795Yn c1795Yn, C3C c3c, List<V2> list, JR jr2) {
        super(c3c, list, c1795Yn);
        this.A00 = c1795Yn;
        this.A01 = jr2 == null ? new JR() : jr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final UR A0C(ViewGroup viewGroup, int i11) {
        return new UR(new MI(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A0H */
    public final void A0D(UR ur2, int i11) {
        super.A0D(ur2, i11);
        MI mi2 = (MI) ur2.A0j();
        A0F(mi2.getImageCardView(), i11);
        if (((AbstractC1899b6) this).A01.get(i11) != null) {
            mi2.setTitle(((AbstractC1899b6) this).A01.get(i11).getAdHeadline());
            mi2.setSubtitle(((AbstractC1899b6) this).A01.get(i11).getAdLinkDescription());
            mi2.setButtonText(((AbstractC1899b6) this).A01.get(i11).getAdCallToAction());
        }
        V2 v11 = ((AbstractC1899b6) this).A01.get(i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(mi2);
        v11.A1O(mi2, mi2, arrayList);
    }
}

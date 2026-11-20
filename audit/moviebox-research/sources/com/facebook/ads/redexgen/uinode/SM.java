package com.facebook.ads.redexgen.uinode;

import android.view.ViewGroup;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SM extends AbstractC10494c<SK> {
    public final int A00;
    public final C1795Yn A01;
    public final ViewOnClickListenerC1667Tl A02;
    public final List<String> A03;

    public SM(C1795Yn c1795Yn, List<String> list, int i11, ViewOnClickListenerC1667Tl viewOnClickListenerC1667Tl) {
        this.A03 = list;
        this.A00 = i11;
        this.A01 = c1795Yn;
        this.A02 = viewOnClickListenerC1667Tl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final SK A0C(ViewGroup viewGroup, int i11) {
        SL sl2 = new SL(this.A01);
        if (C1384Ih.A12(this.A01)) {
            sl2.setOnClickListener(new Q6(this));
        }
        return new SK(sl2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
    public final void A0D(SK sk2, int i11) {
        String str = this.A03.get(i11);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -1);
        int i12 = this.A00;
        int i13 = i12 * 4;
        if (i11 == 0) {
            i12 = i13;
        }
        marginLayoutParams.setMargins(i12, 0, i11 >= A0E() + (-1) ? this.A00 * 4 : this.A00, 0);
        sk2.A0j().setLayoutParams(marginLayoutParams);
        sk2.A0j().A00(str);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10494c
    public final int A0E() {
        return this.A03.size();
    }
}

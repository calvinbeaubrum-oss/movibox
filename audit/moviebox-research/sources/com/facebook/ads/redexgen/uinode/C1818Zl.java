package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1818Zl extends C4Y {
    public C1818Zl(AbstractC10614o abstractC10614o) {
        super(abstractC10614o, null);
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A06() {
        return this.A02.A0X();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A07() {
        return this.A02.A0X() - this.A02.A0d();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A08() {
        return this.A02.A0d();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A09() {
        return this.A02.A0Y();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0A() {
        return this.A02.A0g();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0B() {
        return (this.A02.A0X() - this.A02.A0g()) - this.A02.A0d();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0C(View view) {
        return this.A02.A0j(view) + ((C10624p) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0D(View view) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return this.A02.A0l(view) + c10624p.topMargin + c10624p.bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0E(View view) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return this.A02.A0m(view) + c10624p.leftMargin + c10624p.rightMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0F(View view) {
        return this.A02.A0o(view) - ((C10624p) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0G(View view) {
        this.A02.A1E(view, true, this.A01);
        return this.A01.bottom;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0H(View view) {
        this.A02.A1E(view, true, this.A01);
        return this.A01.top;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final void A0J(int i11) {
        this.A02.A10(i11);
    }
}

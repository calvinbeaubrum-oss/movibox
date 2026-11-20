package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1819Zm extends C4Y {
    public C1819Zm(AbstractC10614o abstractC10614o) {
        super(abstractC10614o, null);
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A06() {
        return this.A02.A0h();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A07() {
        return this.A02.A0h() - this.A02.A0f();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A08() {
        return this.A02.A0f();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A09() {
        return this.A02.A0i();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0A() {
        return this.A02.A0e();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0B() {
        return (this.A02.A0h() - this.A02.A0e()) - this.A02.A0f();
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0C(View view) {
        return this.A02.A0n(view) + ((C10624p) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0D(View view) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return this.A02.A0m(view) + c10624p.leftMargin + c10624p.rightMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0E(View view) {
        C10624p c10624p = (C10624p) view.getLayoutParams();
        return this.A02.A0l(view) + c10624p.topMargin + c10624p.bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0F(View view) {
        return this.A02.A0k(view) - ((C10624p) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0G(View view) {
        this.A02.A1E(view, true, this.A01);
        return this.A01.right;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final int A0H(View view) {
        this.A02.A1E(view, true, this.A01);
        return this.A01.left;
    }

    @Override // com.facebook.ads.redexgen.uinode.C4Y
    public final void A0J(int i11) {
        this.A02.A0z(i11);
    }
}

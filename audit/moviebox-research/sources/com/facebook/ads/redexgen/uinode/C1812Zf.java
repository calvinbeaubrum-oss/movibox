package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1812Zf implements AnonymousClass59 {
    public final /* synthetic */ AbstractC10614o A00;

    public C1812Zf(AbstractC10614o abstractC10614o) {
        this.A00 = abstractC10614o;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final View A6M(int i11) {
        return this.A00.A0t(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A6O(View view) {
        return this.A00.A0j(view) + ((C10624p) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A6P(View view) {
        return this.A00.A0o(view) - ((C10624p) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A7a() {
        return this.A00.A0X() - this.A00.A0d();
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A7b() {
        return this.A00.A0g();
    }
}

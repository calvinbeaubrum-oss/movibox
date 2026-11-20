package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1813Zg implements AnonymousClass59 {
    public final /* synthetic */ AbstractC10614o A00;

    public C1813Zg(AbstractC10614o abstractC10614o) {
        this.A00 = abstractC10614o;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final View A6M(int i11) {
        return this.A00.A0t(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A6O(View view) {
        return this.A00.A0n(view) + ((C10624p) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A6P(View view) {
        return this.A00.A0k(view) - ((C10624p) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A7a() {
        return this.A00.A0h() - this.A00.A0f();
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass59
    public final int A7b() {
        return this.A00.A0e();
    }
}

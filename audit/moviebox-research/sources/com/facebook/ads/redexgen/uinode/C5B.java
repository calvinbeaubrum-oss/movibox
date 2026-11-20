package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5B {
    public AnonymousClass58 A00 = new AnonymousClass58();
    public final AnonymousClass59 A01;

    public C5B(AnonymousClass59 anonymousClass59) {
        this.A01 = anonymousClass59;
    }

    public final View A00(int i11, int i12, int i13, int i14) {
        int iA7b = this.A01.A7b();
        int iA7a = this.A01.A7a();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        while (i11 != i12) {
            View viewA6M = this.A01.A6M(i11);
            this.A00.A03(iA7b, iA7a, this.A01.A6P(viewA6M), this.A01.A6O(viewA6M));
            if (i13 != 0) {
                this.A00.A01();
                this.A00.A02(i13);
                if (this.A00.A04()) {
                    return viewA6M;
                }
            }
            if (i14 != 0) {
                this.A00.A01();
                this.A00.A02(i14);
                if (this.A00.A04()) {
                    view = viewA6M;
                }
            }
            i11 += i15;
        }
        return view;
    }
}

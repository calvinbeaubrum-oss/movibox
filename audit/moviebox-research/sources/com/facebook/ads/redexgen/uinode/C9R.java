package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C9R extends AbstractC1570Ps {
    public final /* synthetic */ C9Q A00;

    public C9R(C9Q c9q) {
        this.A00 = c9q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C1571Pt c1571Pt) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1559Ph(this));
    }
}

package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class A2 extends AbstractC1570Ps {
    public final /* synthetic */ T4 A00;

    public A2(T4 t11) {
        this.A00 = t11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C1571Pt c1571Pt) {
        new Handler(Looper.getMainLooper()).post(new PS(this));
    }
}

package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9a, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C11649a extends AbstractC1570Ps {
    public final /* synthetic */ C1653Sx A00;

    public C11649a(C1653Sx c1653Sx) {
        this.A00 = c1653Sx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC11578s
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(C1571Pt c1571Pt) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1552Pa(this));
    }
}

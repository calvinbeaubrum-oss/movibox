package com.facebook.ads.redexgen.uinode;

import android.content.Context;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1732Vz implements InterfaceC1345Gt {
    public final Context A00;
    public final InterfaceC1345Gt A01;
    public final HG<? super InterfaceC1346Gu> A02;

    public C1732Vz(Context context, HG<? super InterfaceC1346Gu> hg2, InterfaceC1345Gt interfaceC1345Gt) {
        this.A00 = context.getApplicationContext();
        this.A02 = hg2;
        this.A01 = interfaceC1345Gt;
    }

    public C1732Vz(Context context, String str, HG<? super InterfaceC1346Gu> hg2) {
        this(context, hg2, new AnonymousClass41(str, hg2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1345Gt
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final W0 A4X() {
        return new W0(this.A00, this.A02, this.A01.A4X());
    }
}

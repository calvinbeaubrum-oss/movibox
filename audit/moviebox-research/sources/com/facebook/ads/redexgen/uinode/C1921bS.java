package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1921bS implements AnonymousClass61 {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1916bN A01;
    public final /* synthetic */ C1916bN A02;
    public final /* synthetic */ C8T A03;

    public C1921bS(C1916bN c1916bN, int i11, C8T c8t, C1916bN c1916bN2) {
        this.A01 = c1916bN;
        this.A00 = i11;
        this.A03 = c8t;
        this.A02 = c1916bN2;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAl() {
        this.A01.A0C(this.A00, this.A03);
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAm() {
        this.A01.A00.ABw(this.A02, C1401Jb.A00(AdErrorType.NO_FILL));
    }
}

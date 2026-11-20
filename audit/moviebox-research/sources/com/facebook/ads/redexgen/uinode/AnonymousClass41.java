package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.41, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass41 extends AbstractC1226Bl {
    public final int A00;
    public final int A01;
    public final HG<? super InterfaceC1346Gu> A02;
    public final String A03;
    public final boolean A04;

    public AnonymousClass41(String str, HG<? super InterfaceC1346Gu> hg2) {
        this(str, hg2, 8000, 8000, false);
    }

    public AnonymousClass41(String str, HG<? super InterfaceC1346Gu> hg2, int i11, int i12, boolean z11) {
        this.A03 = str;
        this.A02 = hg2;
        this.A00 = i11;
        this.A01 = i12;
        this.A04 = z11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.uinode.AbstractC1226Bl
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final C1227Bm A01(H5 h11) {
        return new C1227Bm(this.A03, null, this.A02, this.A00, this.A01, this.A04, h11);
    }
}

package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1224Bj implements V1 {
    public NativeAdBase A00;
    public NativeAdListener A01;

    public C1224Bj(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        this.A01 = nativeAdListener;
        this.A00 = nativeAdBase;
    }

    @Override // com.facebook.ads.redexgen.uinode.JH
    public final void AAc() {
        KK.A00(new C1704Ux(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.JH
    public final void AAg() {
        KK.A00(new C1705Uy(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.JH
    public final void ABR(C1401Jb c1401Jb) {
        KK.A00(new V0(this, c1401Jb));
    }

    @Override // com.facebook.ads.redexgen.uinode.JH
    public final void ACA() {
        KK.A00(new C1703Uw(this));
    }

    @Override // com.facebook.ads.redexgen.uinode.V1
    public final void ACF() {
        KK.A00(new C1706Uz(this));
    }
}

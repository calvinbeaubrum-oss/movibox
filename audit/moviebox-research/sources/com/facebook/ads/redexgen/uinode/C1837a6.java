package com.facebook.ads.redexgen.uinode;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.a6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1837a6<K, V> extends AbstractC10202y<K, V> {
    public final /* synthetic */ C1836a5 A00;

    public C1837a6(C1836a5 c1836a5) {
        this.A00 = c1836a5;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final int A04() {
        return ((AnonymousClass31) this.A00).A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final int A05(Object obj) {
        return this.A00.A08(obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final int A06(Object obj) {
        return this.A00.A07(obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final Map<K, V> A07() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final Object A0B(int i11, int i12) {
        return this.A00.A02[(i11 << 1) + i12];
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final V A0C(int i11, V v11) {
        return this.A00.A0C(i11, v11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final void A0D() {
        this.A00.clear();
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final void A0E(int i11) {
        this.A00.A0A(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.AbstractC10202y
    public final void A0F(K k11, V v11) {
        this.A00.put(k11, v11);
    }
}

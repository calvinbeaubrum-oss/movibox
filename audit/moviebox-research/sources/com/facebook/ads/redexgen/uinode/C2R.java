package com.facebook.ads.redexgen.uinode;

import java.io.Serializable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2R, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2R implements Serializable {
    public C2Q A00;
    public C2Q A01;

    public C2R() {
        this(0.5d, 0.5d);
    }

    public C2R(double d11) {
        this(d11, 0.5d);
    }

    public C2R(double d11, double d12) {
        this.A00 = new C2Q(d11);
        this.A01 = new C2Q(d12);
        A02();
    }

    public final C2Q A00() {
        return this.A00;
    }

    public final C2Q A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A06();
        this.A01.A06();
    }

    public final void A03() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A04(double d11, double d12) {
        this.A00.A08(d11, d12);
    }

    public final void A05(double d11, double d12) {
        this.A01.A08(d11, d12);
    }
}

package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1556Pe {
    public String A02;
    public String A03;
    public final C1N A04;
    public final C09701a A05;
    public final C1795Yn A06;
    public C1P A01 = C1P.A01(null);
    public int A00 = 1000;

    public C1556Pe(C1795Yn c1795Yn, C1N c1n, C09701a c09701a) {
        this.A06 = c1795Yn;
        this.A04 = c1n;
        this.A05 = c09701a;
    }

    public final C1556Pe A07(int i11) {
        this.A00 = i11;
        return this;
    }

    public final C1556Pe A08(C1P c1p) {
        this.A01 = c1p;
        return this;
    }

    public final C1556Pe A09(String str) {
        this.A02 = str;
        return this;
    }

    public final C1556Pe A0A(String str) {
        this.A03 = str;
        return this;
    }

    public final C1558Pg A0B() {
        return new C1558Pg(this, null);
    }
}

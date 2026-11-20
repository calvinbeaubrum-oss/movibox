package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1486Mm {
    public int A00;
    public EnumC1470Lw A01;
    public InterfaceC1490Mq A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C1795Yn A0C;
    public boolean A0A = true;
    public boolean A0B = true;
    public boolean A09 = true;
    public boolean A07 = true;
    public boolean A08 = true;

    public C1486Mm(C1795Yn c1795Yn, InterfaceC1490Mq interfaceC1490Mq) {
        this.A0C = c1795Yn;
        this.A02 = interfaceC1490Mq;
    }

    public final C1486Mm A0D(int i11) {
        this.A00 = i11;
        return this;
    }

    public final C1486Mm A0E(EnumC1470Lw enumC1470Lw) {
        this.A01 = enumC1470Lw;
        return this;
    }

    public final C1486Mm A0F(String str) {
        this.A03 = str;
        return this;
    }

    public final C1486Mm A0G(String str) {
        this.A04 = str;
        return this;
    }

    public final C1486Mm A0H(String str) {
        this.A05 = str;
        return this;
    }

    public final C1486Mm A0I(String str) {
        this.A06 = str;
        return this;
    }

    public final C1486Mm A0J(boolean z11) {
        this.A09 = z11;
        return this;
    }

    public final C1486Mm A0K(boolean z11) {
        this.A0A = z11;
        return this;
    }

    public final C1486Mm A0L(boolean z11) {
        this.A0B = z11;
        return this;
    }

    public final C1487Mn A0M() {
        return new C1487Mn(this, null);
    }
}

package com.facebook.ads.redexgen.uinode;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class OO {
    public boolean A00;
    public View A03;
    public V2 A04;
    public MB A05;
    public KP A06;
    public final View A07;
    public final AbstractC1898b5 A08;
    public final C1795Yn A09;
    public final J2 A0A;
    public final C1454Lg A0B;
    public final MC A0C;
    public final RE A0D;
    public int A02 = 0;
    public int A01 = 1;

    public OO(C1795Yn c1795Yn, J2 j11, MC mc2, AbstractC1898b5 abstractC1898b5, View view, RE re2, C1454Lg c1454Lg) {
        this.A09 = c1795Yn;
        this.A0A = j11;
        this.A0C = mc2;
        this.A08 = abstractC1898b5;
        this.A07 = view;
        this.A0D = re2;
        this.A0B = c1454Lg;
    }

    public final OO A0D(int i11) {
        this.A01 = i11;
        return this;
    }

    public final OO A0E(int i11) {
        this.A02 = i11;
        return this;
    }

    public final OO A0F(View view) {
        this.A03 = view;
        return this;
    }

    public final OO A0G(V2 v11) {
        this.A04 = v11;
        return this;
    }

    public final OO A0H(MB mb2) {
        this.A05 = mb2;
        return this;
    }

    public final OO A0I(KP kp2) {
        this.A06 = kp2;
        return this;
    }

    public final OO A0J(boolean z11) {
        this.A00 = z11;
        return this;
    }

    public final OP A0K() {
        return new OP(this);
    }
}

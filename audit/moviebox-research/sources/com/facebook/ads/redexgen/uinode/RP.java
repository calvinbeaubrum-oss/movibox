package com.facebook.ads.redexgen.uinode;

import java.util.Set;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RP {
    public RS A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04;

    public RP(RS rs2, boolean z11, Set<String> set, Set<String> set2, boolean z12) {
        this.A00 = rs2;
        this.A04 = z11;
        this.A02 = set;
        this.A01 = set2;
        this.A03 = z12;
    }

    public final RS A00() {
        return this.A00;
    }

    public final Set<String> A01() {
        return this.A01;
    }

    public final Set<String> A02() {
        return this.A02;
    }

    public final boolean A03() {
        return this.A04;
    }

    public final boolean A04() {
        return this.A03;
    }
}

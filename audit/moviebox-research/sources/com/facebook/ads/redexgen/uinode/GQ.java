package com.facebook.ads.redexgen.uinode;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GQ implements Comparable<GQ> {
    public final int A00;
    public final GM A01;

    public GQ(int i11, GM gm2) {
        this.A00 = i11;
        this.A01 = gm2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(GQ gq2) {
        return this.A00 - gq2.A00;
    }
}

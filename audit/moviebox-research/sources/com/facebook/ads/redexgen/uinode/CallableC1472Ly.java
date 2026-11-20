package com.facebook.ads.redexgen.uinode;

import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class CallableC1472Ly implements Callable<Void> {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int[] A06;

    public CallableC1472Ly(int[] iArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.A06 = iArr;
        this.A05 = i11;
        this.A01 = i12;
        this.A02 = i13;
        this.A04 = i14;
        this.A00 = i15;
        this.A03 = i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        C1682Ua.A00(this.A06, this.A05, this.A01, this.A02, this.A04, this.A00, this.A03);
        return null;
    }
}

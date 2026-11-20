package com.facebook.ads.redexgen.uinode;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ax, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1890ax implements AnonymousClass61 {
    public static String[] A05 = {"SGxBKOT0PnlxeQ2jGccieZy3bFeI", "1PQaT", "uVEahNbfwTxCxKVGO7p", "rVPhbhRBlKfAg8fviAhE", "2ov", "KrP87Bn8e271VzBAE5Wi", "4No2VIB7eIWgh7ub8hExBeYUcY", "mEjh"};
    public final /* synthetic */ AbstractC1898b5 A00;
    public final /* synthetic */ InterfaceC09771h A01;
    public final /* synthetic */ C09781i A02;
    public final /* synthetic */ C1795Yn A03;
    public final /* synthetic */ boolean A04;

    public C1890ax(C09781i c09781i, C1795Yn c1795Yn, boolean z11, AbstractC1898b5 abstractC1898b5, InterfaceC09771h interfaceC09771h) {
        this.A02 = c09781i;
        this.A03 = c1795Yn;
        this.A04 = z11;
        this.A00 = abstractC1898b5;
        this.A01 = interfaceC09771h;
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAl() {
        if (C1384Ih.A1O(this.A03) && this.A04) {
            this.A02.A02.add(PC.A01(this.A03, this.A00, 1, new C1891ay(this)));
            return;
        }
        InterfaceC09771h interfaceC09771h = this.A01;
        if (A05[2].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[5] = "X6BBoGIR5wPjpoFUlFYz";
        strArr[3] = "SlUPa0nBeexeGnx3tyWk";
        interfaceC09771h.AAf();
    }

    @Override // com.facebook.ads.redexgen.uinode.AnonymousClass61
    public final void AAm() {
        this.A01.AAe(AdError.CACHE_ERROR);
    }
}

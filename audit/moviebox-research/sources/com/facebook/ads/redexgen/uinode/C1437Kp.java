package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Kp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1437Kp {
    public static final C1437Kp A04 = new C1437Kp(new C1694Um(), new C1693Ul());
    public final InterfaceC1436Ko A02;
    public final InterfaceC1452Le A03;
    public boolean A01 = true;
    public long A00 = -1;

    public C1437Kp(InterfaceC1452Le interfaceC1452Le, InterfaceC1436Ko interfaceC1436Ko) {
        this.A03 = interfaceC1452Le;
        this.A02 = interfaceC1436Ko;
    }

    public static C1437Kp A00() {
        return A04;
    }

    public final synchronized void A01() {
        this.A01 = false;
        this.A00 = this.A03.A50();
    }

    public final synchronized void A02() {
        this.A00 = -1L;
    }

    public final boolean A03() {
        boolean z11 = true;
        if (this.A02.A7G() != null) {
            return true;
        }
        synchronized (C1437Kp.class) {
            if (this.A01) {
                return true;
            }
            if (this.A00 >= 0 && this.A03.A50() - this.A00 >= 1000) {
                z11 = false;
            }
            return z11;
        }
    }
}

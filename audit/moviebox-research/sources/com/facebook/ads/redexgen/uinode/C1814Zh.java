package com.facebook.ads.redexgen.uinode;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zh, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1814Zh implements InterfaceC10554i {
    public static String[] A01 = {"IP6gXu3Aic9rrZpr", "DSm6OHbiM4aoMyjFh2wy7Spd3inn5axc", "lJd94ygIcpnkIi9oYNWqXg3HQV8t0X4Q", "337I3pVrWHOBtYrFGcdtPHZp8Kpz9VIJ", "vd5lczoeg9gY82TvyWngHoQKFpNC9gt0", "CefcuhKyPhUbDvzsvxPUhaoMgi2Xy5FO", "Qia1n7qQgpdEP2KZeQvga8Xzcvoo51Ij", "UfDKqgBAky8ekVpIbdpaQQPTuf6RISL4"};
    public final /* synthetic */ C1278Eb A00;

    public C1814Zh(C1278Eb c1278Eb) {
        this.A00 = c1278Eb;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC10554i
    public final void AAj(AnonymousClass56 anonymousClass56) {
        anonymousClass56.A0X(true);
        if (anonymousClass56.A06 != null && anonymousClass56.A07 == null) {
            anonymousClass56.A06 = null;
        }
        anonymousClass56.A07 = null;
        if (anonymousClass56.A0A() || this.A00.A1v(anonymousClass56.A0H) || !anonymousClass56.A0c()) {
            return;
        }
        C1278Eb c1278Eb = this.A00;
        if (A01[6].charAt(16) != 'e') {
            throw new RuntimeException();
        }
        A01[0] = "BbBTSQcWyeSpGVnm";
        c1278Eb.removeDetachedView(anonymousClass56.A0H, false);
    }
}

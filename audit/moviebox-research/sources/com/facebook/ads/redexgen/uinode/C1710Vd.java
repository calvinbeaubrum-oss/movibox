package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1710Vd implements InterfaceC1354Hd {
    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1354Hd
    public final C1709Vc A4c(Looper looper, Handler.Callback callback) {
        return new C1709Vc(new Handler(looper, callback));
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1354Hd
    public final long A5T() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1354Hd
    public final long AGs() {
        return SystemClock.uptimeMillis();
    }
}

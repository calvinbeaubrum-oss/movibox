package com.facebook.ads.redexgen.uinode;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1723Vq {
    public H7<? extends H8> A00;
    public IOException A01;
    public final ExecutorService A02;

    public C1723Vq(String str) {
        this.A02 = IF.A0T(str);
    }

    public final <T extends H8> long A04(T t11, H6<T> h11, int i11) {
        Looper looperMyLooper = Looper.myLooper();
        AbstractC1351Ha.A04(looperMyLooper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new H7(this, looperMyLooper, t11, h11, i11, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public final void A05() {
        this.A00.A07(false);
    }

    public final void A06(int i11) throws IOException {
        IOException iOException = this.A01;
        if (iOException != null) {
            throw iOException;
        }
        H7<? extends H8> h11 = this.A00;
        if (h11 != null) {
            if (i11 == Integer.MIN_VALUE) {
                i11 = h11.A03;
            }
            h11.A05(i11);
        }
    }

    public final void A07(H9 h11) {
        H7<? extends H8> h12 = this.A00;
        if (h12 != null) {
            h12.A07(true);
        }
        if (h11 != null) {
            this.A02.execute(new HA(h11));
        }
        this.A02.shutdown();
    }

    public final boolean A08() {
        return this.A00 != null;
    }
}

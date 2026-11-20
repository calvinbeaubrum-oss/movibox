package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ai, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1197Ai {
    public final Handler A00;
    public final InterfaceC1198Aj A01;

    public C1197Ai(Handler handler, InterfaceC1198Aj interfaceC1198Aj) {
        this.A00 = interfaceC1198Aj != null ? (Handler) AbstractC1351Ha.A01(handler) : null;
        this.A01 = interfaceC1198Aj;
    }

    public final void A01(int i11) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1196Ah(this, i11));
        }
    }

    public final void A02(int i11, long j11, long j12) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1194Af(this, i11, j11, j12));
        }
    }

    public final void A03(Format format) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1193Ae(this, format));
        }
    }

    public final void A04(BC bc2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1195Ag(this, bc2));
        }
    }

    public final void A05(BC bc2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1191Ac(this, bc2));
        }
    }

    public final void A06(String str, long j11, long j12) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1192Ad(this, str, j11, j12));
        }
    }
}

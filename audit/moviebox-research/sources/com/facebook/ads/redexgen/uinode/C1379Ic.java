package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.view.Surface;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ic, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1379Ic {
    public final Handler A00;
    public final InterfaceC1380Id A01;

    public C1379Ic(Handler handler, InterfaceC1380Id interfaceC1380Id) {
        this.A00 = interfaceC1380Id != null ? (Handler) AbstractC1351Ha.A01(handler) : null;
        this.A01 = interfaceC1380Id;
    }

    public final void A01(int i11, int i12, int i13, float f11) {
        if (this.A01 != null) {
            this.A00.post(new IZ(this, i11, i12, i13, f11));
        }
    }

    public final void A02(int i11, long j11) {
        if (this.A01 != null) {
            this.A00.post(new IY(this, i11, j11));
        }
    }

    public final void A03(Surface surface) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1377Ia(this, surface));
        }
    }

    public final void A04(Format format) {
        if (this.A01 != null) {
            this.A00.post(new IX(this, format));
        }
    }

    public final void A05(BC bc2) {
        if (this.A01 != null) {
            this.A00.post(new RunnableC1378Ib(this, bc2));
        }
    }

    public final void A06(BC bc2) {
        if (this.A01 != null) {
            this.A00.post(new IV(this, bc2));
        }
    }

    public final void A07(String str, long j11, long j12) {
        if (this.A01 != null) {
            this.A00.post(new IW(this, str, j11, j12));
        }
    }
}

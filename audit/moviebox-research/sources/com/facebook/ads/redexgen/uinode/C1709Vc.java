package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1709Vc implements InterfaceC1364Hn {
    public final Handler A00;

    public C1709Vc(Handler handler) {
        this.A00 = handler;
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final Looper A7L() {
        return this.A00.getLooper();
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final Message AAZ(int i11, int i12, int i13) {
        return this.A00.obtainMessage(i11, i12, i13);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final Message AAa(int i11, int i12, int i13, Object obj) {
        return this.A00.obtainMessage(i11, i12, i13, obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final Message AAb(int i11, Object obj) {
        return this.A00.obtainMessage(i11, obj);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final void AF8(int i11) {
        this.A00.removeMessages(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final boolean AFn(int i11) {
        return this.A00.sendEmptyMessage(i11);
    }

    @Override // com.facebook.ads.redexgen.uinode.InterfaceC1364Hn
    public final boolean AFo(int i11, long j11) {
        return this.A00.sendEmptyMessageAtTime(i11, j11);
    }
}

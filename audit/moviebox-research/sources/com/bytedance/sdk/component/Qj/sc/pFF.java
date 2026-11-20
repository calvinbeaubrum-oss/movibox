package com.bytedance.sdk.component.Qj.sc;

import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.FI;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends FI implements zY {
    private final HandlerThread pFF;

    public pFF(HandlerThread handlerThread, FI.sc scVar) {
        super(handlerThread.getLooper(), scVar);
        this.pFF = handlerThread;
    }

    public void pFF() {
        HandlerThread handlerThread = this.pFF;
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    @Override // com.bytedance.sdk.component.Qj.sc.zY
    public void sc() {
        removeCallbacksAndMessages(null);
        WeakReference<FI.sc> weakReference = this.f27023sc;
        if (weakReference != null) {
            weakReference.clear();
            this.f27023sc = null;
        }
    }

    public void sc(FI.sc scVar) {
        this.f27023sc = new WeakReference<>(scVar);
    }
}

package com.bytedance.sdk.openadsdk.core.zY;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class TRI extends We {
    public TRI(Context context, Sfl sfl, AdSlot adSlot) {
        super(context, sfl, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.zY.We
    public void sc(Context context, Sfl sfl, AdSlot adSlot) {
        pFF pff = new pFF(context, sfl, adSlot);
        this.f28574sc = pff;
        pff.addOnAttachStateChangeListener(this.TRI);
    }

    public com.bytedance.sdk.openadsdk.multipro.pFF.sc zY() {
        zY zYVar = this.f28574sc;
        if (zYVar != null) {
            return ((pFF) zYVar).getVideoModel();
        }
        return null;
    }
}

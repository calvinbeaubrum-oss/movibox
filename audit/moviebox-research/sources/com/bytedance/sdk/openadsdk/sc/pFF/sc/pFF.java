package com.bytedance.sdk.openadsdk.sc.pFF.sc;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.Qj.wjp;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends zY {
    public pFF(@NonNull Context context, Sfl sfl, AdSlot adSlot) {
        super(context, sfl, adSlot);
    }

    public com.bytedance.sdk.openadsdk.multipro.pFF.sc pFF() {
        com.bytedance.sdk.openadsdk.core.Qj.Sfl sfl = this.WH;
        if (sfl != null) {
            return ((wjp) sfl).getVideoModel();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.sc.pFF.sc.zY
    public void sc() {
        wjp wjpVar = new wjp(((zY) this).Qj, this.pFF, ((zY) this).Ol, this.UFX);
        this.WH = wjpVar;
        this.f28677sc.sc(wjpVar.getVideoController());
        zY();
    }
}

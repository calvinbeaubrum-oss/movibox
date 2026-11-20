package com.bytedance.adsdk.ugeno.We.zY;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc implements com.bytedance.adsdk.ugeno.We.sc.We {
    private com.bytedance.adsdk.ugeno.We.sc.zY Ol;

    public pFF(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.We.sc.We
    public void sc(String str) {
        this.f26384sc.sc(this.pFF, this.TRI, this.zY.pFF());
    }

    @Override // com.bytedance.adsdk.ugeno.We.zY.sc
    public boolean sc(Object... objArr) {
        com.bytedance.adsdk.ugeno.We.sc.sc scVarBR = this.pFF.BR();
        if (scVarBR == null) {
            return false;
        }
        com.bytedance.adsdk.ugeno.We.sc.zY zYVarSc = scVarBR.sc(this.TRI);
        this.Ol = zYVarSc;
        if (zYVarSc != null) {
            zYVarSc.sc(this);
            return false;
        }
        scVarBR.sc(this.TRI, new com.bytedance.adsdk.ugeno.We.sc.pFF());
        return false;
    }
}

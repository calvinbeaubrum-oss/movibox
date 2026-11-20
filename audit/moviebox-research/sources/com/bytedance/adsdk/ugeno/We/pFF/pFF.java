package com.bytedance.adsdk.ugeno.We.pFF;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends sc {
    private List<com.bytedance.adsdk.ugeno.We.sc.We> Qj;

    public pFF(com.bytedance.adsdk.ugeno.pFF.zY zYVar, String str, com.bytedance.adsdk.ugeno.We.pFF.sc scVar) {
        super(zYVar, str, scVar);
        this.Qj = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.adsdk.ugeno.We.pFF.sc
    public void sc() {
        com.bytedance.adsdk.ugeno.We.sc.zY zYVarSc;
        Map<String, String> map = this.TRI;
        if (map == null || map.size() <= 0) {
            return;
        }
        String str = this.TRI.get("name");
        com.bytedance.adsdk.ugeno.We.sc.sc scVarBR = this.zY.BR();
        if (scVarBR == null || (zYVarSc = scVarBR.sc(str)) == null) {
            return;
        }
        zYVarSc.sc(str);
    }
}

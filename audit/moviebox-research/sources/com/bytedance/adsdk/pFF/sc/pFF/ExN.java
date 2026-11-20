package com.bytedance.adsdk.pFF.sc.pFF;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends qr<com.bytedance.adsdk.pFF.zY.pFF.We> {
    private final com.bytedance.adsdk.pFF.zY.pFF.We We;

    public ExN(List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We>> list) {
        super(list);
        com.bytedance.adsdk.pFF.zY.pFF.We we2 = list.get(0).f26180sc;
        int iZY = we2 != null ? we2.zY() : 0;
        this.We = new com.bytedance.adsdk.pFF.zY.pFF.We(new float[iZY], new int[iZY]);
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.pFF.zY.pFF.We sc(com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We> scVar, float f11) {
        this.We.sc(scVar.f26180sc, scVar.pFF, f11);
        return this.We;
    }
}

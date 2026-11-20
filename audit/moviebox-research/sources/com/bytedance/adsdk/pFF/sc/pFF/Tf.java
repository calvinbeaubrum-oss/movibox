package com.bytedance.adsdk.pFF.sc.pFF;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Tf extends qr<com.bytedance.adsdk.pFF.qr.zY> {
    private final com.bytedance.adsdk.pFF.qr.zY We;

    public Tf(List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.qr.zY>> list) {
        super(list);
        this.We = new com.bytedance.adsdk.pFF.qr.zY();
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.pFF.qr.zY sc(com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.qr.zY> scVar, float f11) {
        com.bytedance.adsdk.pFF.qr.zY zYVar;
        com.bytedance.adsdk.pFF.qr.zY zYVar2 = scVar.f26180sc;
        if (zYVar2 == null || (zYVar = scVar.pFF) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        com.bytedance.adsdk.pFF.qr.zY zYVar3 = zYVar2;
        com.bytedance.adsdk.pFF.qr.zY zYVar4 = zYVar;
        if (this.zY == null) {
            this.We.sc(com.bytedance.adsdk.pFF.TRI.ExN.sc(zYVar3.sc(), zYVar4.sc(), f11), com.bytedance.adsdk.pFF.TRI.ExN.sc(zYVar3.pFF(), zYVar4.pFF(), f11));
            return this.We;
        }
        scVar.f26179qr.floatValue();
        We();
        Qj();
        throw null;
    }
}

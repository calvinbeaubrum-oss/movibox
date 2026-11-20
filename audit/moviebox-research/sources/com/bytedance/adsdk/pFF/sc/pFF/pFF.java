package com.bytedance.adsdk.pFF.sc.pFF;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends qr<Integer> {
    public pFF(List<com.bytedance.adsdk.pFF.qr.sc<Integer>> list) {
        super(list);
    }

    public int Ol() {
        return zY(zY(), ExN());
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public Integer sc(com.bytedance.adsdk.pFF.qr.sc<Integer> scVar, float f11) {
        return Integer.valueOf(zY(scVar, f11));
    }

    public int zY(com.bytedance.adsdk.pFF.qr.sc<Integer> scVar, float f11) {
        if (scVar.f26180sc == null || scVar.pFF == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.zY == null) {
            return com.bytedance.adsdk.pFF.TRI.pFF.sc(com.bytedance.adsdk.pFF.TRI.ExN.pFF(f11, 0.0f, 1.0f), scVar.f26180sc.intValue(), scVar.pFF.intValue());
        }
        scVar.f26179qr.floatValue();
        We();
        Qj();
        throw null;
    }
}

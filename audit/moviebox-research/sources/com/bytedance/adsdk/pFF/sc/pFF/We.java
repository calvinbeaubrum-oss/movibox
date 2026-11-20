package com.bytedance.adsdk.pFF.sc.pFF;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends qr<Float> {
    public We(List<com.bytedance.adsdk.pFF.qr.sc<Float>> list) {
        super(list);
    }

    public float Ol() {
        return zY(zY(), ExN());
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc
    /* JADX INFO: renamed from: pFF, reason: merged with bridge method [inline-methods] */
    public Float sc(com.bytedance.adsdk.pFF.qr.sc<Float> scVar, float f11) {
        return Float.valueOf(zY(scVar, f11));
    }

    public float zY(com.bytedance.adsdk.pFF.qr.sc<Float> scVar, float f11) {
        if (scVar.f26180sc == null || scVar.pFF == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        if (this.zY == null) {
            return com.bytedance.adsdk.pFF.TRI.ExN.sc(scVar.TRI(), scVar.qr(), f11);
        }
        scVar.f26179qr.floatValue();
        We();
        Qj();
        throw null;
    }
}

package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class n extends PreviewScalingStrategy {
    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public float c(t tVar, t tVar2) {
        if (tVar.f80643a <= 0 || tVar.f80644b <= 0) {
            return 0.0f;
        }
        t tVarH = tVar.h(tVar2);
        float fPow = (tVarH.f80643a * 1.0f) / tVar.f80643a;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f11 = ((tVar2.f80643a * 1.0f) / tVarH.f80643a) * ((tVar2.f80644b * 1.0f) / tVarH.f80644b);
        return fPow * (((1.0f / f11) / f11) / f11);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(t tVar, t tVar2) {
        t tVarH = tVar.h(tVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(tVar);
        sb2.append("; Scaled: ");
        sb2.append(tVarH);
        sb2.append("; Want: ");
        sb2.append(tVar2);
        int i11 = (tVarH.f80643a - tVar2.f80643a) / 2;
        int i12 = (tVarH.f80644b - tVar2.f80644b) / 2;
        return new Rect(-i11, -i12, tVarH.f80643a - i11, tVarH.f80644b - i12);
    }
}

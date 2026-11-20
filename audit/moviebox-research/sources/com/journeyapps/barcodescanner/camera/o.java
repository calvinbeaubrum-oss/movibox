package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import xn.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class o extends PreviewScalingStrategy {
    public static float e(float f11) {
        return f11 < 1.0f ? 1.0f / f11 : f11;
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public float c(t tVar, t tVar2) {
        int i11 = tVar.f80643a;
        if (i11 <= 0 || tVar.f80644b <= 0) {
            return 0.0f;
        }
        float fE = (1.0f / e((i11 * 1.0f) / tVar2.f80643a)) / e((tVar.f80644b * 1.0f) / tVar2.f80644b);
        float fE2 = e(((tVar.f80643a * 1.0f) / tVar.f80644b) / ((tVar2.f80643a * 1.0f) / tVar2.f80644b));
        return fE * (((1.0f / fE2) / fE2) / fE2);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(t tVar, t tVar2) {
        return new Rect(0, 0, tVar2.f80643a, tVar2.f80644b);
    }
}

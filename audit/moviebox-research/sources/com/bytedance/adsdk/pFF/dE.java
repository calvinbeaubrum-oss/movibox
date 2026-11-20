package com.bytedance.adsdk.pFF;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class dE implements Interpolator {
    private final float[] pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final float[] f26168sc;

    public dE(float f11, float f12, float f13, float f14) {
        this(sc(f11, f12, f13, f14));
    }

    public dE(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i11 = (int) (length / 0.002f);
        int i12 = i11 + 1;
        this.f26168sc = new float[i12];
        this.pFF = new float[i12];
        float[] fArr = new float[2];
        for (int i13 = 0; i13 < i12; i13++) {
            pathMeasure.getPosTan((i13 * length) / i11, fArr, null);
            this.f26168sc[i13] = fArr[0];
            this.pFF[i13] = fArr[1];
        }
    }

    private static Path sc(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f11, f12, f13, f14, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f26168sc.length - 1;
        int i11 = 0;
        while (length - i11 > 1) {
            int i12 = (i11 + length) / 2;
            if (f11 < this.f26168sc[i12]) {
                length = i12;
            } else {
                i11 = i12;
            }
        }
        float[] fArr = this.f26168sc;
        float f12 = fArr[length];
        float f13 = fArr[i11];
        float f14 = f12 - f13;
        if (f14 == 0.0f) {
            return this.pFF[i11];
        }
        float f15 = (f11 - f13) / f14;
        float[] fArr2 = this.pFF;
        float f16 = fArr2[i11];
        return f16 + (f15 * (fArr2[length] - f16));
    }
}

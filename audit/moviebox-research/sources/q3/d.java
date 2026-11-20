package q3;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f74274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f74275b;

    public d(float[] fArr) {
        this.f74274a = fArr;
        this.f74275b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f11) {
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f74274a;
        int iMin = Math.min((int) ((fArr.length - 1) * f11), fArr.length - 2);
        float f12 = this.f74275b;
        float f13 = (f11 - (iMin * f12)) / f12;
        float[] fArr2 = this.f74274a;
        float f14 = fArr2[iMin];
        return f14 + (f13 * (fArr2[iMin + 1] - f14));
    }
}

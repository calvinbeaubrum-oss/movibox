package t4;

import android.opengl.Matrix;
import androidx.media3.common.util.GlUtil;
import z3.h0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f76862a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f76863b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h0<float[]> f76864c = new h0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f76865d;

    public static void a(float[] fArr, float[] fArr2) {
        GlUtil.k(fArr);
        float f11 = fArr2[10];
        float f12 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f11 * f11) + (f12 * f12));
        float f13 = fArr2[10];
        fArr[0] = f13 / fSqrt;
        float f14 = fArr2[8];
        fArr[2] = f14 / fSqrt;
        fArr[8] = (-f14) / fSqrt;
        fArr[10] = f13 / fSqrt;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f11 = fArr2[0];
        float f12 = -fArr2[1];
        float f13 = -fArr2[2];
        float length = Matrix.length(f11, f12, f13);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f11 / length, f12 / length, f13 / length);
        } else {
            GlUtil.k(fArr);
        }
    }

    public boolean c(float[] fArr, long j11) {
        float[] fArrJ = this.f76864c.j(j11);
        if (fArrJ == null) {
            return false;
        }
        b(this.f76863b, fArrJ);
        if (!this.f76865d) {
            a(this.f76862a, this.f76863b);
            this.f76865d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f76862a, 0, this.f76863b, 0);
        return true;
    }

    public void d() {
        this.f76864c.c();
        this.f76865d = false;
    }

    public void e(long j11, float[] fArr) {
        this.f76864c.a(j11, fArr);
    }
}

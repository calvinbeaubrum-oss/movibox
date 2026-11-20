package gi;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.j0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f65507a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f65508b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0<float[]> f65509c = new j0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f65510d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
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
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j11) {
        float[] fArrJ = this.f65509c.j(j11);
        if (fArrJ == null) {
            return false;
        }
        b(this.f65508b, fArrJ);
        if (!this.f65510d) {
            a(this.f65507a, this.f65508b);
            this.f65510d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f65507a, 0, this.f65508b, 0);
        return true;
    }

    public void d() {
        this.f65509c.c();
        this.f65510d = false;
    }

    public void e(long j11, float[] fArr) {
        this.f65509c.a(j11, fArr);
    }
}

package c3;

import android.graphics.Color;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<double[]> f14552a = new ThreadLocal<>();

    public static void a(int i11, int i12, int i13, @NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d11 = ((double) i11) / 255.0d;
        double dPow = d11 < 0.04045d ? d11 / 12.92d : Math.pow((d11 + 0.055d) / 1.055d, 2.4d);
        double d12 = ((double) i12) / 255.0d;
        double dPow2 = d12 < 0.04045d ? d12 / 12.92d : Math.pow((d12 + 0.055d) / 1.055d, 2.4d);
        double d13 = ((double) i13) / 255.0d;
        double dPow3 = d13 < 0.04045d ? d13 / 12.92d : Math.pow((d13 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    public static int b(double d11, double d12, double d13) {
        double d14 = (((3.2406d * d11) + ((-1.5372d) * d12)) + ((-0.4986d) * d13)) / 100.0d;
        double d15 = ((((-0.9689d) * d11) + (1.8758d * d12)) + (0.0415d * d13)) / 100.0d;
        double d16 = (((0.0557d * d11) + ((-0.204d) * d12)) + (1.057d * d13)) / 100.0d;
        return Color.rgb(i((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d) * 255.0d), 0, 255), i((int) Math.round((d16 > 0.0031308d ? (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d : 12.92d * d16) * 255.0d), 0, 255));
    }

    public static int c(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb((int) ((Color.alpha(i11) * f12) + (Color.alpha(i12) * f11)), (int) ((Color.red(i11) * f12) + (Color.red(i12) * f11)), (int) ((Color.green(i11) * f12) + (Color.green(i12) * f11)), (int) ((Color.blue(i11) * f12) + (Color.blue(i12) * f11)));
    }

    public static double d(int i11) {
        double[] dArrJ = j();
        e(i11, dArrJ);
        return dArrJ[1] / 100.0d;
    }

    public static void e(int i11, @NonNull double[] dArr) {
        a(Color.red(i11), Color.green(i11), Color.blue(i11), dArr);
    }

    public static int f(int i11, int i12) {
        return 255 - (((255 - i12) * (255 - i11)) / 255);
    }

    public static int g(int i11, int i12) {
        int iAlpha = Color.alpha(i12);
        int iAlpha2 = Color.alpha(i11);
        int iF = f(iAlpha2, iAlpha);
        return Color.argb(iF, h(Color.red(i11), iAlpha2, Color.red(i12), iAlpha, iF), h(Color.green(i11), iAlpha2, Color.green(i12), iAlpha, iF), h(Color.blue(i11), iAlpha2, Color.blue(i12), iAlpha, iF));
    }

    public static int h(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            return 0;
        }
        return (((i11 * 255) * i12) + ((i13 * i14) * (255 - i12))) / (i15 * 255);
    }

    public static int i(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : Math.min(i11, i13);
    }

    public static double[] j() {
        ThreadLocal<double[]> threadLocal = f14552a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int k(int i11, int i12) {
        if (i12 < 0 || i12 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i11 & 16777215) | (i12 << 24);
    }
}

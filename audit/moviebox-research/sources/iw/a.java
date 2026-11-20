package iw;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    public static int[] a(Context context, int i11, int i12, int i13, int i14) {
        return b(context, i11, i12, i13, i14, 0.72f);
    }

    public static int[] b(Context context, int i11, int i12, int i13, int i14, float f11) {
        if (i13 == 0) {
            i13 = tp.f.f77260a.e(context);
        }
        if (i14 == 0) {
            i14 = tp.f.f77260a.c(context);
        }
        float f12 = ((i11 * 1.0f) / i12) * 1.0f;
        int i15 = (int) (f12 < 1.0f ? i13 * f11 : i13 * 0.92f);
        int i16 = (int) (i15 / f12);
        int i17 = (int) (i14 * f11);
        if (i16 > i17) {
            i15 = (int) (i17 * f12);
            i16 = i17;
        }
        return new int[]{i15, i16};
    }
}

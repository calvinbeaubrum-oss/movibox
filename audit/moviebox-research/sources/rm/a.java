package rm;

import com.google.android.gms.common.api.Api;
import com.google.zxing.NotFoundException;
import qm.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f75621b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f75624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int[] f75625f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f75620a = new int[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f75622c = new float[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f75623d = new float[4];

    public a() {
        int[] iArr = new int[8];
        this.f75621b = iArr;
        this.f75624e = new int[iArr.length / 2];
        this.f75625f = new int[iArr.length / 2];
    }

    public static void h(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            float f12 = fArr[i12];
            if (f12 < f11) {
                i11 = i12;
                f11 = f12;
            }
        }
        iArr[i11] = iArr[i11] - 1;
    }

    public static void o(int[] iArr, float[] fArr) {
        int i11 = 0;
        float f11 = fArr[0];
        for (int i12 = 1; i12 < iArr.length; i12++) {
            float f12 = fArr[i12];
            if (f12 > f11) {
                i11 = i12;
                f11 = f12;
            }
        }
        iArr[i11] = iArr[i11] + 1;
    }

    public static boolean p(int[] iArr) {
        int i11 = iArr[0] + iArr[1];
        float f11 = i11 / ((iArr[2] + i11) + iArr[3]);
        if (f11 < 0.7916667f || f11 > 0.89285713f) {
            return false;
        }
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i13 = Integer.MIN_VALUE;
        for (int i14 : iArr) {
            if (i14 > i13) {
                i13 = i14;
            }
            if (i14 < i12) {
                i12 = i14;
            }
        }
        return i13 < i12 * 10;
    }

    public static int q(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i11 = 0; i11 < iArr2.length; i11++) {
            if (q.e(iArr, iArr2[i11], 0.45f) < 0.2f) {
                return i11;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final int[] i() {
        return this.f75621b;
    }

    public final int[] j() {
        return this.f75620a;
    }

    public final int[] k() {
        return this.f75625f;
    }

    public final float[] l() {
        return this.f75623d;
    }

    public final int[] m() {
        return this.f75624e;
    }

    public final float[] n() {
        return this.f75622c;
    }
}

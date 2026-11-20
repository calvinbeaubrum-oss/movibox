package an;

import com.google.android.gms.common.api.Api;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[][] f581c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorCorrectionLevel f582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f583b;

    public d(int i11) {
        this.f582a = ErrorCorrectionLevel.forBits((i11 >> 3) & 3);
        this.f583b = (byte) (i11 & 7);
    }

    public static d a(int i11, int i12) {
        d dVarB = b(i11, i12);
        return dVarB != null ? dVarB : b(i11 ^ 21522, i12 ^ 21522);
    }

    public static d b(int i11, int i12) {
        int iE;
        int[][] iArr = f581c;
        int i13 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i14 = 0;
        for (int[] iArr2 : iArr) {
            int i15 = iArr2[0];
            if (i15 == i11 || i15 == i12) {
                return new d(iArr2[1]);
            }
            int iE2 = e(i11, i15);
            if (iE2 < i13) {
                i14 = iArr2[1];
                i13 = iE2;
            }
            if (i11 != i12 && (iE = e(i12, i15)) < i13) {
                i14 = iArr2[1];
                i13 = iE;
            }
        }
        if (i13 <= 3) {
            return new d(i14);
        }
        return null;
    }

    public static int e(int i11, int i12) {
        return Integer.bitCount(i11 ^ i12);
    }

    public byte c() {
        return this.f583b;
    }

    public ErrorCorrectionLevel d() {
        return this.f582a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f582a == dVar.f582a && this.f583b == dVar.f583b;
    }

    public int hashCode() {
        return (this.f582a.ordinal() << 3) | this.f583b;
    }
}

package qm;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f74834b = {1, 1, 1, 1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f74835c = {3, 1, 1};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f74836d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // qm.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        r.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iB = r.b(zArr, 0, f74834b, true);
        for (int i11 = 0; i11 < length; i11 += 2) {
            int iDigit = Character.digit(str.charAt(i11), 10);
            int iDigit2 = Character.digit(str.charAt(i11 + 1), 10);
            int[] iArr = new int[10];
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = i12 * 2;
                int[][] iArr2 = f74836d;
                iArr[i13] = iArr2[iDigit][i12];
                iArr[i13 + 1] = iArr2[iDigit2][i12];
            }
            iB += r.b(zArr, iB, iArr, true);
        }
        r.b(zArr, iB, f74835c, true);
        return zArr;
    }

    @Override // qm.r
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}

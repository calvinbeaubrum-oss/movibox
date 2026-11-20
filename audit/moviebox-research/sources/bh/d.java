package bh;

import com.google.android.exoplayer2.util.o0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f14138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f14139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f14141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f14142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f14143f;

        public b(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
            this.f14138a = jArr;
            this.f14139b = iArr;
            this.f14140c = i11;
            this.f14141d = jArr2;
            this.f14142e = iArr2;
            this.f14143f = j11;
        }
    }

    public static b a(int i11, long[] jArr, int[] iArr, long j11) {
        int i12 = 8192 / i11;
        int iL = 0;
        for (int i13 : iArr) {
            iL += o0.l(i13, i12);
        }
        long[] jArr2 = new long[iL];
        int[] iArr2 = new int[iL];
        long[] jArr3 = new long[iL];
        int[] iArr3 = new int[iL];
        int i14 = 0;
        int i15 = 0;
        int iMax = 0;
        for (int i16 = 0; i16 < iArr.length; i16++) {
            int i17 = iArr[i16];
            long j12 = jArr[i16];
            while (i17 > 0) {
                int iMin = Math.min(i12, i17);
                jArr2[i15] = j12;
                int i18 = i11 * iMin;
                iArr2[i15] = i18;
                iMax = Math.max(iMax, i18);
                jArr3[i15] = ((long) i14) * j11;
                iArr3[i15] = 1;
                j12 += (long) iArr2[i15];
                i14 += iMin;
                i17 -= iMin;
                i15++;
            }
        }
        return new b(jArr2, iArr2, iMax, jArr3, iArr3, j11 * ((long) i14));
    }
}

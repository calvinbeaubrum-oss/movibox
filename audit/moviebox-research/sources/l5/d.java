package l5;

import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f69835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f69836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long[] f69838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f69839e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f69840f;

        public b(long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
            this.f69835a = jArr;
            this.f69836b = iArr;
            this.f69837c = i11;
            this.f69838d = jArr2;
            this.f69839e = iArr2;
            this.f69840f = j11;
        }
    }

    public static b a(int i11, long[] jArr, int[] iArr, long j11) {
        int i12 = 8192 / i11;
        int iK = 0;
        for (int i13 : iArr) {
            iK += u0.k(i13, i12);
        }
        long[] jArr2 = new long[iK];
        int[] iArr2 = new int[iK];
        long[] jArr3 = new long[iK];
        int[] iArr3 = new int[iK];
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

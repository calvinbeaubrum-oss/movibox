package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f35652a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f35653b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f35654c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int[] f35655d = new int[10];

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f35657b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35658c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f35660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f35662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f35663h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f35664i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final float f35665j;

        public a(int i11, boolean z11, int i12, int i13, int[] iArr, int i14, int i15, int i16, int i17, float f11) {
            this.f35656a = i11;
            this.f35657b = z11;
            this.f35658c = i12;
            this.f35659d = i13;
            this.f35660e = iArr;
            this.f35661f = i14;
            this.f35662g = i15;
            this.f35663h = i16;
            this.f35664i = i17;
            this.f35665j = f11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35667b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f35668c;

        public b(int i11, int i12, boolean z11) {
            this.f35666a = i11;
            this.f35667b = i12;
            this.f35668c = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35670b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35671c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f35672d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35673e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35674f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f35675g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f35676h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f35677i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f35678j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f35679k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f35680l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f35681m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f35682n;

        public c(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11, boolean z11, boolean z12, int i18, int i19, int i21, boolean z13) {
            this.f35669a = i11;
            this.f35670b = i12;
            this.f35671c = i13;
            this.f35672d = i14;
            this.f35673e = i15;
            this.f35674f = i16;
            this.f35675g = i17;
            this.f35676h = f11;
            this.f35677i = z11;
            this.f35678j = z12;
            this.f35679k = i18;
            this.f35680l = i19;
            this.f35681m = i21;
            this.f35682n = z13;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = i11 + 1;
            if (i13 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i14 = byteBuffer.get(i11) & 255;
            if (i12 == 3) {
                if (i14 == 1 && (byteBuffer.get(i13) & Ascii.US) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i11 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i14 == 0) {
                i12++;
            }
            if (i14 != 0) {
                i12 = 0;
            }
            i11 = i13;
        }
    }

    public static int c(byte[] bArr, int i11, int i12, boolean[] zArr) {
        int i13 = i12 - i11;
        com.google.android.exoplayer2.util.a.g(i13 >= 0);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            a(zArr);
            return i11 - 3;
        }
        if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            a(zArr);
            return i11 - 2;
        }
        if (i13 > 2 && zArr[2] && bArr[i11] == 0 && bArr[i11 + 1] == 1) {
            a(zArr);
            return i11 - 1;
        }
        int i14 = i12 - 1;
        int i15 = i11 + 2;
        while (i15 < i14) {
            byte b11 = bArr[i15];
            if ((b11 & 254) == 0) {
                int i16 = i15 - 2;
                if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                    a(zArr);
                    return i16;
                }
                i15 -= 2;
            }
            i15 += 3;
        }
        zArr[0] = i13 <= 2 ? !(i13 != 2 ? !(zArr[1] && bArr[i14] == 1) : !(zArr[2] && bArr[i12 + (-2)] == 0 && bArr[i14] == 1)) : bArr[i12 + (-3)] == 0 && bArr[i12 + (-2)] == 0 && bArr[i14] == 1;
        zArr[1] = i13 <= 1 ? zArr[2] && bArr[i14] == 0 : bArr[i12 + (-2)] == 0 && bArr[i14] == 0;
        zArr[2] = bArr[i14] == 0;
        return i12;
    }

    public static int d(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int e(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i11) {
        return bArr[i11 + 3] & Ascii.US;
    }

    public static boolean g(@Nullable String str, byte b11) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b11 & Ascii.US) == 6) {
            return true;
        }
        return MimeTypes.VIDEO_H265.equals(str) && ((b11 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i11, int i12) {
        return i(bArr, i11 + 2, i12);
    }

    public static a i(byte[] bArr, int i11, int i12) {
        float f11;
        d0 d0Var = new d0(bArr, i11, i12);
        d0Var.l(4);
        int iE = d0Var.e(3);
        d0Var.k();
        int iE2 = d0Var.e(2);
        boolean zD = d0Var.d();
        int iE3 = d0Var.e(5);
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 >= 32) {
                break;
            }
            if (d0Var.d()) {
                i13 |= 1 << i14;
            }
            i14++;
        }
        int[] iArr = new int[6];
        for (int i15 = 0; i15 < 6; i15++) {
            iArr[i15] = d0Var.e(8);
        }
        int iE4 = d0Var.e(8);
        int i16 = 0;
        for (int i17 = 0; i17 < iE; i17++) {
            if (d0Var.d()) {
                i16 += 89;
            }
            if (d0Var.d()) {
                i16 += 8;
            }
        }
        d0Var.l(i16);
        if (iE > 0) {
            d0Var.l((8 - iE) * 2);
        }
        int iH = d0Var.h();
        int iH2 = d0Var.h();
        if (iH2 == 3) {
            d0Var.k();
        }
        int iH3 = d0Var.h();
        int iH4 = d0Var.h();
        if (d0Var.d()) {
            int iH5 = d0Var.h();
            int iH6 = d0Var.h();
            int iH7 = d0Var.h();
            int iH8 = d0Var.h();
            iH3 -= ((iH2 == 1 || iH2 == 2) ? 2 : 1) * (iH5 + iH6);
            iH4 -= (iH2 == 1 ? 2 : 1) * (iH7 + iH8);
        }
        int i18 = iH3;
        d0Var.h();
        d0Var.h();
        int iH9 = d0Var.h();
        for (int i19 = d0Var.d() ? 0 : iE; i19 <= iE; i19++) {
            d0Var.h();
            d0Var.h();
            d0Var.h();
        }
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        d0Var.h();
        if (d0Var.d() && d0Var.d()) {
            n(d0Var);
        }
        d0Var.l(2);
        if (d0Var.d()) {
            d0Var.l(8);
            d0Var.h();
            d0Var.h();
            d0Var.k();
        }
        p(d0Var);
        if (d0Var.d()) {
            for (int i21 = 0; i21 < d0Var.h(); i21++) {
                d0Var.l(iH9 + 5);
            }
        }
        d0Var.l(2);
        float f12 = 1.0f;
        if (d0Var.d()) {
            if (d0Var.d()) {
                int iE5 = d0Var.e(8);
                if (iE5 == 255) {
                    int iE6 = d0Var.e(16);
                    int iE7 = d0Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f12 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = f35653b;
                    if (iE5 < fArr.length) {
                        f12 = fArr[iE5];
                    } else {
                        s.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (d0Var.d()) {
                d0Var.k();
            }
            if (d0Var.d()) {
                d0Var.l(4);
                if (d0Var.d()) {
                    d0Var.l(24);
                }
            }
            if (d0Var.d()) {
                d0Var.h();
                d0Var.h();
            }
            d0Var.k();
            if (d0Var.d()) {
                iH4 *= 2;
            }
            f11 = f12;
        } else {
            f11 = 1.0f;
        }
        return new a(iE2, zD, iE3, i13, iArr, iE4, iH, i18, iH4, f11);
    }

    public static b j(byte[] bArr, int i11, int i12) {
        return k(bArr, i11 + 1, i12);
    }

    public static b k(byte[] bArr, int i11, int i12) {
        d0 d0Var = new d0(bArr, i11, i12);
        int iH = d0Var.h();
        int iH2 = d0Var.h();
        d0Var.k();
        return new b(iH, iH2, d0Var.d());
    }

    public static c l(byte[] bArr, int i11, int i12) {
        return m(bArr, i11 + 1, i12);
    }

    public static c m(byte[] bArr, int i11, int i12) {
        int iH;
        boolean zD;
        boolean z11;
        int iH2;
        float f11;
        int i13;
        d0 d0Var = new d0(bArr, i11, i12);
        int iE = d0Var.e(8);
        int iE2 = d0Var.e(8);
        int iE3 = d0Var.e(8);
        int iH3 = d0Var.h();
        int i14 = 1;
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iH = d0Var.h();
            zD = iH == 3 ? d0Var.d() : false;
            d0Var.h();
            d0Var.h();
            d0Var.k();
            if (d0Var.d()) {
                int i15 = iH != 3 ? 8 : 12;
                int i16 = 0;
                while (i16 < i15) {
                    if (d0Var.d()) {
                        o(d0Var, i16 < 6 ? 16 : 64);
                    }
                    i16++;
                }
            }
        } else {
            iH = 1;
            zD = false;
        }
        int iH4 = d0Var.h() + 4;
        int iH5 = d0Var.h();
        if (iH5 == 0) {
            iH = iH;
            zD = zD;
            iH2 = d0Var.h() + 4;
            z11 = false;
        } else {
            if (iH5 == 1) {
                boolean zD2 = d0Var.d();
                d0Var.g();
                d0Var.g();
                long jH = d0Var.h();
                for (int i17 = 0; i17 < jH; i17++) {
                    d0Var.h();
                }
                z11 = zD2;
            } else {
                z11 = false;
            }
            iH2 = 0;
        }
        int iH6 = d0Var.h();
        d0Var.k();
        int iH7 = d0Var.h() + 1;
        int iH8 = d0Var.h() + 1;
        boolean zD3 = d0Var.d();
        int i18 = (2 - (zD3 ? 1 : 0)) * iH8;
        if (!zD3) {
            d0Var.k();
        }
        d0Var.k();
        int i19 = iH7 * 16;
        int i21 = i18 * 16;
        if (d0Var.d()) {
            int iH9 = d0Var.h();
            int iH10 = d0Var.h();
            int iH11 = d0Var.h();
            int iH12 = d0Var.h();
            if (iH == 0) {
                i13 = 2 - (zD3 ? 1 : 0);
            } else {
                int i22 = iH;
                i14 = i22 == 3 ? 1 : 2;
                i13 = (2 - (zD3 ? 1 : 0)) * (i22 == 1 ? 2 : 1);
            }
            i19 -= (iH9 + iH10) * i14;
            i21 -= (iH11 + iH12) * i13;
        }
        int i23 = i19;
        int i24 = i21;
        float f12 = 1.0f;
        if (d0Var.d() && d0Var.d()) {
            int iE4 = d0Var.e(8);
            if (iE4 == 255) {
                int iE5 = d0Var.e(16);
                int iE6 = d0Var.e(16);
                if (iE5 != 0 && iE6 != 0) {
                    f12 = iE5 / iE6;
                }
                f11 = f12;
            } else {
                float[] fArr = f35653b;
                if (iE4 < fArr.length) {
                    f11 = fArr[iE4];
                } else {
                    s.i("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE4);
                    f11 = 1.0f;
                }
            }
        } else {
            f11 = 1.0f;
        }
        return new c(iE, iE2, iE3, iH3, iH6, i23, i24, f11, zD, zD3, iH4, iH5, iH2, z11);
    }

    public static void n(d0 d0Var) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (d0Var.d()) {
                    int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        d0Var.g();
                    }
                    for (int i14 = 0; i14 < iMin; i14++) {
                        d0Var.g();
                    }
                } else {
                    d0Var.h();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    public static void o(d0 d0Var, int i11) {
        int iG = 8;
        int i12 = 8;
        for (int i13 = 0; i13 < i11; i13++) {
            if (iG != 0) {
                iG = ((d0Var.g() + i12) + 256) % 256;
            }
            if (iG != 0) {
                i12 = iG;
            }
        }
    }

    public static void p(d0 d0Var) {
        int iH = d0Var.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < iH; i13++) {
            if (i13 == 0 || !d0Var.d()) {
                int iH2 = d0Var.h();
                int iH3 = d0Var.h();
                int[] iArr2 = new int[iH2];
                for (int i14 = 0; i14 < iH2; i14++) {
                    iArr2[i14] = d0Var.h() + 1;
                    d0Var.k();
                }
                int[] iArr3 = new int[iH3];
                for (int i15 = 0; i15 < iH3; i15++) {
                    iArr3[i15] = d0Var.h() + 1;
                    d0Var.k();
                }
                i11 = iH2;
                iArr = iArr2;
                i12 = iH3;
                iArrCopyOf = iArr3;
            } else {
                int i16 = i11 + i12;
                int iH4 = (1 - ((d0Var.d() ? 1 : 0) * 2)) * (d0Var.h() + 1);
                int i17 = i16 + 1;
                boolean[] zArr = new boolean[i17];
                for (int i18 = 0; i18 <= i16; i18++) {
                    if (d0Var.d()) {
                        zArr[i18] = true;
                    } else {
                        zArr[i18] = d0Var.d();
                    }
                }
                int[] iArr4 = new int[i17];
                int[] iArr5 = new int[i17];
                int i19 = 0;
                for (int i21 = i12 - 1; i21 >= 0; i21--) {
                    int i22 = iArrCopyOf[i21] + iH4;
                    if (i22 < 0 && zArr[i11 + i21]) {
                        iArr4[i19] = i22;
                        i19++;
                    }
                }
                if (iH4 < 0 && zArr[i16]) {
                    iArr4[i19] = iH4;
                    i19++;
                }
                for (int i23 = 0; i23 < i11; i23++) {
                    int i24 = iArr[i23] + iH4;
                    if (i24 < 0 && zArr[i23]) {
                        iArr4[i19] = i24;
                        i19++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr4, i19);
                int i25 = 0;
                for (int i26 = i11 - 1; i26 >= 0; i26--) {
                    int i27 = iArr[i26] + iH4;
                    if (i27 > 0 && zArr[i26]) {
                        iArr5[i25] = i27;
                        i25++;
                    }
                }
                if (iH4 > 0 && zArr[i16]) {
                    iArr5[i25] = iH4;
                    i25++;
                }
                for (int i28 = 0; i28 < i12; i28++) {
                    int i29 = iArrCopyOf[i28] + iH4;
                    if (i29 > 0 && zArr[i11 + i28]) {
                        iArr5[i25] = i29;
                        i25++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i25);
                iArr = iArrCopyOf2;
                i11 = i19;
                i12 = i25;
            }
        }
    }

    public static int q(byte[] bArr, int i11) {
        int i12;
        synchronized (f35654c) {
            int iD = 0;
            int i13 = 0;
            while (iD < i11) {
                try {
                    iD = d(bArr, iD, i11);
                    if (iD < i11) {
                        int[] iArr = f35655d;
                        if (iArr.length <= i13) {
                            f35655d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f35655d[i13] = iD;
                        iD += 3;
                        i13++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            i12 = i11 - i13;
            int i14 = 0;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                int i17 = f35655d[i16] - i15;
                System.arraycopy(bArr, i15, bArr, i14, i17);
                int i18 = i14 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i14 = i18 + 2;
                bArr[i19] = 0;
                i15 += i17 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i14, i12 - i14);
        }
        return i12;
    }
}

package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f24845a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f24846b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f24847c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int[] f24848d = new int[10];

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24850b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f24851c;

        public a(int i11, int i12, boolean z11) {
            this.f24849a = i11;
            this.f24850b = i12;
            this.f24851c = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f24852a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24853b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f24854c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f24855d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f24856e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f24857f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f24858g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f24859h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f24860i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f24861j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f24862k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f24863l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f24864m;

        public b(int i11, int i12, int i13, int i14, int i15, int i16, float f11, boolean z11, boolean z12, int i17, int i18, int i19, boolean z13) {
            this.f24852a = i11;
            this.f24853b = i12;
            this.f24854c = i13;
            this.f24855d = i14;
            this.f24856e = i15;
            this.f24857f = i16;
            this.f24858g = f11;
            this.f24859h = z11;
            this.f24860i = z12;
            this.f24861j = i17;
            this.f24862k = i18;
            this.f24863l = i19;
            this.f24864m = z13;
        }
    }

    public static int a(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 126) >> 1;
    }

    private static int a(byte[] bArr, int i11, int i12) {
        while (i11 < i12 - 2) {
            if (bArr[i11] == 0 && bArr[i11 + 1] == 0 && bArr[i11 + 2] == 3) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int a(byte[] bArr, int i11, int i12, boolean[] zArr) {
        int i13 = i12 - i11;
        b1.b(i13 >= 0);
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

    private static void a(ch chVar, int i11) {
        int iE = 8;
        int i12 = 8;
        for (int i13 = 0; i13 < i11; i13++) {
            if (iE != 0) {
                iE = ((chVar.e() + i12) + 256) % 256;
            }
            if (iE != 0) {
                i12 = iE;
            }
        }
    }

    public static void a(ByteBuffer byteBuffer) {
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

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static boolean a(String str, byte b11) {
        if (MimeTypes.VIDEO_H264.equals(str) && (b11 & Ascii.US) == 6) {
            return true;
        }
        return MimeTypes.VIDEO_H265.equals(str) && ((b11 & 126) >> 1) == 39;
    }

    public static int b(byte[] bArr, int i11) {
        return bArr[i11 + 3] & Ascii.US;
    }

    public static a b(byte[] bArr, int i11, int i12) {
        ch chVar = new ch(bArr, i11, i12);
        chVar.d(8);
        int iF = chVar.f();
        int iF2 = chVar.f();
        chVar.g();
        return new a(iF, iF2, chVar.c());
    }

    public static int c(byte[] bArr, int i11) {
        int i12;
        synchronized (f24847c) {
            int iA = 0;
            int i13 = 0;
            while (iA < i11) {
                try {
                    iA = a(bArr, iA, i11);
                    if (iA < i11) {
                        int[] iArr = f24848d;
                        if (iArr.length <= i13) {
                            f24848d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f24848d[i13] = iA;
                        iA += 3;
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
                int i17 = f24848d[i16] - i14;
                System.arraycopy(bArr, i14, bArr, i15, i17);
                int i18 = i15 + i17;
                int i19 = i18 + 1;
                bArr[i18] = 0;
                i15 = i18 + 2;
                bArr[i19] = 0;
                i14 += i17 + 3;
            }
            System.arraycopy(bArr, i14, bArr, i15, i12 - i15);
        }
        return i12;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:62:0x0108  */
    /* JADX WARN: Code duplicated, block: B:64:0x010e  */
    /* JADX WARN: Code duplicated, block: B:65:0x0110  */
    /* JADX WARN: Code duplicated, block: B:67:0x0113  */
    /* JADX WARN: Code duplicated, block: B:84:0x016d  */
    public static b c(byte[] bArr, int i11, int i12) {
        int iF;
        boolean zC;
        int iF2;
        boolean z11;
        boolean zC2;
        int i13;
        int i14;
        int i15;
        float f11;
        int i16;
        int i17;
        ch chVar = new ch(bArr, i11, i12);
        chVar.d(8);
        int iB = chVar.b(8);
        int iB2 = chVar.b(8);
        int iB3 = chVar.b(8);
        int iF3 = chVar.f();
        int i18 = 1;
        if (iB == 100 || iB == 110 || iB == 122 || iB == 244 || iB == 44 || iB == 83 || iB == 86 || iB == 118 || iB == 128 || iB == 138) {
            iF = chVar.f();
            zC = iF == 3 ? chVar.c() : false;
            chVar.f();
            chVar.f();
            chVar.g();
            if (chVar.c()) {
                int i19 = iF != 3 ? 8 : 12;
                int i21 = 0;
                while (i21 < i19) {
                    if (chVar.c()) {
                        a(chVar, i21 < 6 ? 16 : 64);
                    }
                    i21++;
                }
            }
        } else {
            iF = 1;
            zC = false;
        }
        int iF4 = chVar.f() + 4;
        int iF5 = chVar.f();
        if (iF5 != 0) {
            if (iF5 == 1) {
                boolean zC3 = chVar.c();
                chVar.e();
                chVar.e();
                zC = zC;
                long jF = chVar.f();
                iF = iF;
                for (int i22 = 0; i22 < jF; i22++) {
                    chVar.f();
                }
                z11 = zC3;
                iF2 = 0;
            } else {
                iF2 = 0;
            }
            chVar.f();
            chVar.g();
            int iF6 = chVar.f() + 1;
            int iF7 = chVar.f() + 1;
            zC2 = chVar.c();
            i13 = 2 - (zC2 ? 1 : 0);
            int i23 = iF7 * i13;
            if (!zC2) {
                chVar.g();
            }
            chVar.g();
            i14 = iF6 * 16;
            i15 = i23 * 16;
            if (chVar.c()) {
                int iF8 = chVar.f();
                int iF9 = chVar.f();
                int iF10 = chVar.f();
                int iF11 = chVar.f();
                if (iF != 0) {
                    i16 = iF;
                    if (i16 == 3) {
                        i17 = 1;
                    } else {
                        i17 = 2;
                    }
                    i13 *= i16 == 1 ? 2 : 1;
                    i18 = i17;
                }
                i14 -= (iF8 + iF9) * i18;
                i15 -= (iF10 + iF11) * i13;
            }
            int i24 = i14;
            int i25 = i15;
            if (chVar.c() || !chVar.c()) {
                f11 = 1.0f;
            } else {
                int iB4 = chVar.b(8);
                if (iB4 == 255) {
                    int iB5 = chVar.b(16);
                    int iB6 = chVar.b(16);
                    if (iB5 == 0 || iB6 == 0) {
                        f11 = 1.0f;
                    } else {
                        f11 = iB5 / iB6;
                    }
                } else {
                    float[] fArr = f24846b;
                    if (iB4 < fArr.length) {
                        f11 = fArr[iB4];
                    } else {
                        pc.d("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iB4);
                        f11 = 1.0f;
                    }
                }
            }
            return new b(iB, iB2, iB3, iF3, i24, i25, f11, zC, zC2, iF4, iF5, iF2, z11);
        }
        iF2 = chVar.f() + 4;
        z11 = false;
        chVar.f();
        chVar.g();
        int iF12 = chVar.f() + 1;
        int iF13 = chVar.f() + 1;
        zC2 = chVar.c();
        i13 = 2 - (zC2 ? 1 : 0);
        int i26 = iF13 * i13;
        if (!zC2) {
            chVar.g();
        }
        chVar.g();
        i14 = iF12 * 16;
        i15 = i26 * 16;
        if (chVar.c()) {
            int iF14 = chVar.f();
            int iF15 = chVar.f();
            int iF16 = chVar.f();
            int iF17 = chVar.f();
            if (iF != 0) {
                i16 = iF;
                if (i16 == 3) {
                    i17 = 1;
                } else {
                    i17 = 2;
                }
                i13 *= i16 == 1 ? 2 : 1;
                i18 = i17;
            }
            i14 -= (iF14 + iF15) * i18;
            i15 -= (iF16 + iF17) * i13;
        }
        int i27 = i14;
        int i28 = i15;
        if (chVar.c()) {
            f11 = 1.0f;
        } else {
            f11 = 1.0f;
        }
        return new b(iB, iB2, iB3, iF3, i27, i28, f11, zC, zC2, iF4, iF5, iF2, z11);
    }
}

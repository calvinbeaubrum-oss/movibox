package a4;

import androidx.annotation.Nullable;
import androidx.media3.common.k;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;
import z3.o;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f366a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[] f367b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f368c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int[] f369d = new int[10];

    /* JADX INFO: renamed from: a4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0019a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f374e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f375f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f376g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int[] f377h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f378i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f379j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f380k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f381l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final float f382m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f383n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f384o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final int f385p;

        public C0019a(int i11, boolean z11, int i12, int i13, int i14, int i15, int i16, int[] iArr, int i17, int i18, int i19, int i21, float f11, int i22, int i23, int i24) {
            this.f370a = i11;
            this.f371b = z11;
            this.f372c = i12;
            this.f373d = i13;
            this.f374e = i14;
            this.f375f = i15;
            this.f376g = i16;
            this.f377h = iArr;
            this.f378i = i17;
            this.f379j = i18;
            this.f380k = i19;
            this.f381l = i21;
            this.f382m = f11;
            this.f383n = i22;
            this.f384o = i23;
            this.f385p = i24;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f388c;

        public b(int i11, int i12, boolean z11) {
            this.f386a = i11;
            this.f387b = i12;
            this.f388c = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f392d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f393e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f394f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f395g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f396h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f397i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f398j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f399k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f400l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f401m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f402n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f403o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f404p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f405q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f406r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final int f407s;

        public c(int i11, int i12, int i13, int i14, int i15, int i16, int i17, float f11, int i18, int i19, boolean z11, boolean z12, int i21, int i22, int i23, boolean z13, int i24, int i25, int i26) {
            this.f389a = i11;
            this.f390b = i12;
            this.f391c = i13;
            this.f392d = i14;
            this.f393e = i15;
            this.f394f = i16;
            this.f395g = i17;
            this.f396h = f11;
            this.f397i = i18;
            this.f398j = i19;
            this.f399k = z11;
            this.f400l = z12;
            this.f401m = i21;
            this.f402n = i22;
            this.f403o = i23;
            this.f404p = z13;
            this.f405q = i24;
            this.f406r = i25;
            this.f407s = i26;
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
        z3.a.g(i13 >= 0);
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

    public static C0019a h(byte[] bArr, int i11, int i12) {
        return i(bArr, i11 + 2, i12);
    }

    public static C0019a i(byte[] bArr, int i11, int i12) {
        int i13;
        float f11;
        int i14;
        int i15;
        int i16;
        int iM;
        a4.b bVar = new a4.b(bArr, i11, i12);
        bVar.l(4);
        int iE = bVar.e(3);
        bVar.k();
        int iE2 = bVar.e(2);
        boolean zD = bVar.d();
        int iE3 = bVar.e(5);
        int i17 = 0;
        for (int i18 = 0; i18 < 32; i18++) {
            if (bVar.d()) {
                i17 |= 1 << i18;
            }
        }
        int[] iArr = new int[6];
        for (int i19 = 0; i19 < 6; i19++) {
            iArr[i19] = bVar.e(8);
        }
        int iE4 = bVar.e(8);
        int i21 = 0;
        for (int i22 = 0; i22 < iE; i22++) {
            if (bVar.d()) {
                i21 += 89;
            }
            if (bVar.d()) {
                i21 += 8;
            }
        }
        bVar.l(i21);
        if (iE > 0) {
            bVar.l((8 - iE) * 2);
        }
        int iH = bVar.h();
        int iH2 = bVar.h();
        if (iH2 == 3) {
            bVar.k();
        }
        int iH3 = bVar.h();
        int iH4 = bVar.h();
        if (bVar.d()) {
            int iH5 = bVar.h();
            int iH6 = bVar.h();
            int iH7 = bVar.h();
            int iH8 = bVar.h();
            iH3 -= ((iH2 == 1 || iH2 == 2) ? 2 : 1) * (iH5 + iH6);
            iH4 -= (iH2 == 1 ? 2 : 1) * (iH7 + iH8);
        }
        int i23 = iH4;
        int i24 = iH3;
        int i25 = i23;
        int iH9 = bVar.h();
        int iH10 = bVar.h();
        int iH11 = bVar.h();
        for (int i26 = bVar.d() ? 0 : iE; i26 <= iE; i26++) {
            bVar.h();
            bVar.h();
            bVar.h();
        }
        bVar.h();
        bVar.h();
        bVar.h();
        bVar.h();
        bVar.h();
        bVar.h();
        if (bVar.d() && bVar.d()) {
            n(bVar);
        }
        bVar.l(2);
        if (bVar.d()) {
            bVar.l(8);
            bVar.h();
            bVar.h();
            bVar.k();
        }
        p(bVar);
        if (bVar.d()) {
            int iH12 = bVar.h();
            for (int i27 = 0; i27 < iH12; i27++) {
                bVar.l(iH11 + 5);
            }
        }
        bVar.l(2);
        int iL = -1;
        float f12 = 1.0f;
        if (bVar.d()) {
            if (bVar.d()) {
                int iE5 = bVar.e(8);
                if (iE5 == 255) {
                    int iE6 = bVar.e(16);
                    int iE7 = bVar.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f12 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = f367b;
                    if (iE5 < fArr.length) {
                        f12 = fArr[iE5];
                    } else {
                        o.h("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (bVar.d()) {
                bVar.k();
            }
            if (bVar.d()) {
                bVar.l(3);
                i15 = bVar.d() ? 1 : 2;
                if (bVar.d()) {
                    int iE8 = bVar.e(8);
                    int iE9 = bVar.e(8);
                    bVar.l(8);
                    iL = k.l(iE8);
                    iM = k.m(iE9);
                } else {
                    iM = -1;
                }
            } else {
                iM = -1;
                i15 = -1;
            }
            if (bVar.d()) {
                bVar.h();
                bVar.h();
            }
            bVar.k();
            if (bVar.d()) {
                i25 *= 2;
            }
            i16 = iM;
            i14 = iL;
            f11 = f12;
            i13 = i25;
        } else {
            i13 = i25;
            f11 = 1.0f;
            i14 = -1;
            i15 = -1;
            i16 = -1;
        }
        return new C0019a(iE2, zD, iE3, i17, iH2, iH9, iH10, iArr, iE4, iH, i24, i13, f11, i14, i15, i16);
    }

    public static b j(byte[] bArr, int i11, int i12) {
        return k(bArr, i11 + 1, i12);
    }

    public static b k(byte[] bArr, int i11, int i12) {
        a4.b bVar = new a4.b(bArr, i11, i12);
        int iH = bVar.h();
        int iH2 = bVar.h();
        bVar.k();
        return new b(iH, iH2, bVar.d());
    }

    public static c l(byte[] bArr, int i11, int i12) {
        return m(bArr, i11 + 1, i12);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:103:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:62:0x0109  */
    /* JADX WARN: Code duplicated, block: B:63:0x0111  */
    /* JADX WARN: Code duplicated, block: B:65:0x0116  */
    /* JADX WARN: Code duplicated, block: B:66:0x011a  */
    /* JADX WARN: Code duplicated, block: B:68:0x011f  */
    /* JADX WARN: Code duplicated, block: B:69:0x0121  */
    /* JADX WARN: Code duplicated, block: B:72:0x0132  */
    /* JADX WARN: Code duplicated, block: B:75:0x013d  */
    /* JADX WARN: Code duplicated, block: B:77:0x0143  */
    /* JADX WARN: Code duplicated, block: B:79:0x014d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0160  */
    /* JADX WARN: Code duplicated, block: B:85:0x0165  */
    /* JADX WARN: Code duplicated, block: B:86:0x0168  */
    /* JADX WARN: Code duplicated, block: B:89:0x0184  */
    /* JADX WARN: Code duplicated, block: B:92:0x018d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0197  */
    /* JADX WARN: Code duplicated, block: B:95:0x019a  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01bf  */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x0168, please report this as an issue */
    public static c m(byte[] bArr, int i11, int i12) {
        int iH;
        boolean z11;
        int i13;
        int i14;
        int iH2;
        boolean z12;
        boolean zD;
        int i15;
        int i16;
        float f11;
        int iM;
        float f12;
        int i17;
        int iL;
        int i18;
        int iE;
        float[] fArr;
        int iE2;
        int iE3;
        int i19;
        int i21;
        int i22;
        int i23;
        a4.b bVar = new a4.b(bArr, i11, i12);
        int iE4 = bVar.e(8);
        int iE5 = bVar.e(8);
        int iE6 = bVar.e(8);
        int iH3 = bVar.h();
        if (iE4 == 100 || iE4 == 110 || iE4 == 122 || iE4 == 244 || iE4 == 44 || iE4 == 83 || iE4 == 86 || iE4 == 118 || iE4 == 128 || iE4 == 138) {
            iH = bVar.h();
            boolean zD2 = iH == 3 ? bVar.d() : false;
            int iH4 = bVar.h();
            int iH5 = bVar.h();
            bVar.k();
            if (bVar.d()) {
                int i24 = iH != 3 ? 8 : 12;
                int i25 = 0;
                while (i25 < i24) {
                    if (bVar.d()) {
                        o(bVar, i25 < 6 ? 16 : 64);
                    }
                    i25++;
                }
            }
            z11 = zD2;
            i13 = iH4;
            i14 = iH5;
        } else {
            iH = 1;
            i13 = 0;
            i14 = 0;
            z11 = false;
        }
        int iH6 = bVar.h() + 4;
        int iH7 = bVar.h();
        if (iH7 != 0) {
            if (iH7 == 1) {
                boolean zD3 = bVar.d();
                bVar.g();
                bVar.g();
                long jH = bVar.h();
                z12 = zD3;
                for (int i26 = 0; i26 < jH; i26++) {
                    bVar.h();
                }
                iH2 = 0;
            } else {
                iH2 = 0;
            }
            int iH8 = bVar.h();
            bVar.k();
            int iH9 = bVar.h() + 1;
            int iH10 = bVar.h() + 1;
            zD = bVar.d();
            int i27 = (2 - (zD ? 1 : 0)) * iH10;
            if (!zD) {
                bVar.k();
            }
            bVar.k();
            i15 = iH9 * 16;
            i16 = i27 * 16;
            if (bVar.d()) {
                int iH11 = bVar.h();
                int iH12 = bVar.h();
                int iH13 = bVar.h();
                int iH14 = bVar.h();
                if (iH == 0) {
                    i23 = 2 - (zD ? 1 : 0);
                    i21 = 1;
                } else {
                    if (iH == 3) {
                        i19 = 1;
                        i21 = 1;
                    } else {
                        i19 = 1;
                        i21 = 2;
                    }
                    if (iH == i19) {
                        i22 = 2;
                    } else {
                        i22 = 1;
                    }
                    i23 = i22 * (2 - (zD ? 1 : 0));
                }
                i15 -= (iH11 + iH12) * i21;
                i16 -= (iH13 + iH14) * i23;
            } else {
                iH7 = iH7;
            }
            f11 = 1.0f;
            if (bVar.d()) {
                if (bVar.d()) {
                    iE = bVar.e(8);
                    if (iE == 255) {
                        iE2 = bVar.e(16);
                        iE3 = bVar.e(16);
                        if (iE2 != 0 && iE3 != 0) {
                            f11 = iE2 / iE3;
                        }
                    } else {
                        fArr = f367b;
                        if (iE < fArr.length) {
                            f11 = fArr[iE];
                        } else {
                            o.h("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE);
                        }
                    }
                }
                if (bVar.d()) {
                    bVar.k();
                }
                if (bVar.d()) {
                    bVar.l(3);
                    if (bVar.d()) {
                        i18 = 1;
                    } else {
                        i18 = 2;
                    }
                    if (bVar.d()) {
                        int iE7 = bVar.e(8);
                        int iE8 = bVar.e(8);
                        bVar.l(8);
                        iL = k.l(iE7);
                        iM = k.m(iE8);
                        i17 = i18;
                        f12 = f11;
                    } else {
                        i17 = i18;
                        f12 = f11;
                        iM = -1;
                        iL = -1;
                    }
                } else {
                    f12 = f11;
                    iM = -1;
                }
                return new c(iE4, iE5, iE6, iH3, iH8, i15, i16, f12, i13, i14, z11, zD, iH6, iH7, iH2, z12, iL, i17, iM);
            }
            iM = -1;
            f12 = 1.0f;
            i17 = -1;
            iL = -1;
            return new c(iE4, iE5, iE6, iH3, iH8, i15, i16, f12, i13, i14, z11, zD, iH6, iH7, iH2, z12, iL, i17, iM);
        }
        iH2 = bVar.h() + 4;
        z12 = false;
        int iH15 = bVar.h();
        bVar.k();
        int iH16 = bVar.h() + 1;
        int iH17 = bVar.h() + 1;
        zD = bVar.d();
        int i28 = (2 - (zD ? 1 : 0)) * iH17;
        if (!zD) {
            bVar.k();
        }
        bVar.k();
        i15 = iH16 * 16;
        i16 = i28 * 16;
        if (bVar.d()) {
            int iH18 = bVar.h();
            int iH19 = bVar.h();
            int iH110 = bVar.h();
            int iH111 = bVar.h();
            if (iH == 0) {
                i23 = 2 - (zD ? 1 : 0);
                i21 = 1;
            } else {
                if (iH == 3) {
                    i19 = 1;
                    i21 = 1;
                } else {
                    i19 = 1;
                    i21 = 2;
                }
                if (iH == i19) {
                    i22 = 2;
                } else {
                    i22 = 1;
                }
                i23 = i22 * (2 - (zD ? 1 : 0));
            }
            i15 -= (iH18 + iH19) * i21;
            i16 -= (iH110 + iH111) * i23;
        } else {
            iH7 = iH7;
        }
        f11 = 1.0f;
        if (bVar.d()) {
            if (bVar.d()) {
                iE = bVar.e(8);
                if (iE == 255) {
                    iE2 = bVar.e(16);
                    iE3 = bVar.e(16);
                    if (iE2 != 0) {
                        f11 = iE2 / iE3;
                    }
                } else {
                    fArr = f367b;
                    if (iE < fArr.length) {
                        f11 = fArr[iE];
                    } else {
                        o.h("NalUnitUtil", "Unexpected aspect_ratio_idc value: " + iE);
                    }
                }
            }
            if (bVar.d()) {
                bVar.k();
            }
            if (bVar.d()) {
                bVar.l(3);
                if (bVar.d()) {
                    i18 = 1;
                } else {
                    i18 = 2;
                }
                if (bVar.d()) {
                    int iE9 = bVar.e(8);
                    int iE10 = bVar.e(8);
                    bVar.l(8);
                    iL = k.l(iE9);
                    iM = k.m(iE10);
                    i17 = i18;
                    f12 = f11;
                } else {
                    i17 = i18;
                    f12 = f11;
                    iM = -1;
                    iL = -1;
                }
            } else {
                f12 = f11;
                iM = -1;
            }
            return new c(iE4, iE5, iE6, iH3, iH15, i15, i16, f12, i13, i14, z11, zD, iH6, iH7, iH2, z12, iL, i17, iM);
        }
        iM = -1;
        f12 = 1.0f;
        i17 = -1;
        iL = -1;
        return new c(iE4, iE5, iE6, iH3, iH15, i15, i16, f12, i13, i14, z11, zD, iH6, iH7, iH2, z12, iL, i17, iM);
    }

    public static void n(a4.b bVar) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (bVar.d()) {
                    int iMin = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        bVar.g();
                    }
                    for (int i14 = 0; i14 < iMin; i14++) {
                        bVar.g();
                    }
                } else {
                    bVar.h();
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    public static void o(a4.b bVar, int i11) {
        int iG = 8;
        int i12 = 8;
        for (int i13 = 0; i13 < i11; i13++) {
            if (iG != 0) {
                iG = ((bVar.g() + i12) + 256) % 256;
            }
            if (iG != 0) {
                i12 = iG;
            }
        }
    }

    public static void p(a4.b bVar) {
        int iH = bVar.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i11 = -1;
        int i12 = -1;
        for (int i13 = 0; i13 < iH; i13++) {
            if (i13 == 0 || !bVar.d()) {
                int iH2 = bVar.h();
                int iH3 = bVar.h();
                int[] iArr2 = new int[iH2];
                int i14 = 0;
                while (i14 < iH2) {
                    iArr2[i14] = (i14 > 0 ? iArr2[i14 - 1] : 0) - (bVar.h() + 1);
                    bVar.k();
                    i14++;
                }
                int[] iArr3 = new int[iH3];
                int i15 = 0;
                while (i15 < iH3) {
                    iArr3[i15] = (i15 > 0 ? iArr3[i15 - 1] : 0) + bVar.h() + 1;
                    bVar.k();
                    i15++;
                }
                i11 = iH2;
                iArr = iArr2;
                i12 = iH3;
                iArrCopyOf = iArr3;
            } else {
                int i16 = i11 + i12;
                int iH4 = (1 - ((bVar.d() ? 1 : 0) * 2)) * (bVar.h() + 1);
                int i17 = i16 + 1;
                boolean[] zArr = new boolean[i17];
                for (int i18 = 0; i18 <= i16; i18++) {
                    if (bVar.d()) {
                        zArr[i18] = true;
                    } else {
                        zArr[i18] = bVar.d();
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
        synchronized (f368c) {
            int iD = 0;
            int i13 = 0;
            while (iD < i11) {
                try {
                    iD = d(bArr, iD, i11);
                    if (iD < i11) {
                        int[] iArr = f369d;
                        if (iArr.length <= i13) {
                            f369d = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f369d[i13] = iD;
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
                int i17 = f369d[i16] - i15;
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

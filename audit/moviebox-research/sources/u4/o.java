package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f78355a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f78356b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f78357c = {64, 112, 128, PsExtractor.AUDIO_STREAM, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f78358d = {8000, 16000, 32000, 64000, 128000, 22050, 44100, 88200, 176400, 352800, 12000, 24000, 48000, 96000, 192000, 384000};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f78359e = {5, 8, 10, 12};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f78360f = {6, 9, 12, 15};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f78361g = {2, 4, 6, 8};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f78362h = {9, 11, 13, 16};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f78363i = {5, 8, 10, 12};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f78364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f78368e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f78369f;

        public b(String str, int i11, int i12, int i13, long j11, int i14) {
            this.f78364a = str;
            this.f78366c = i11;
            this.f78365b = i12;
            this.f78367d = i13;
            this.f78368e = j11;
            this.f78369f = i14;
        }
    }

    public static void a(byte[] bArr, int i11) throws ParserException {
        int i12 = i11 - 2;
        if (((bArr[i11 - 1] & 255) | ((bArr[i12] << 8) & Settings.DEFAULT_INITIAL_WINDOW_SIZE)) != z3.u0.v(bArr, 0, i12, Settings.DEFAULT_INITIAL_WINDOW_SIZE)) {
            throw ParserException.createForMalformedContainer("CRC check failed", null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0060  */
    /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
    public static int b(byte[] bArr) {
        int i11;
        byte b11;
        int i12;
        int i13;
        byte b12;
        boolean z11 = false;
        byte b13 = bArr[0];
        if (b13 != -2) {
            if (b13 == -1) {
                i13 = ((bArr[7] & 3) << 12) | ((bArr[6] & 255) << 4);
                b12 = bArr[9];
            } else if (b13 != 31) {
                i11 = ((bArr[5] & 3) << 12) | ((bArr[6] & 255) << 4);
                b11 = bArr[7];
            } else {
                i13 = ((bArr[6] & 3) << 12) | ((bArr[7] & 255) << 4);
                b12 = bArr[8];
            }
            i12 = (((b12 & 60) >> 2) | i13) + 1;
            z11 = true;
            if (z11) {
                return (i12 * 16) / 14;
            }
            return i12;
        }
        i11 = ((bArr[4] & 3) << 12) | ((bArr[7] & 255) << 4);
        b11 = bArr[6];
        i12 = (((b11 & 240) >> 4) | i11) + 1;
        if (z11) {
            return (i12 * 16) / 14;
        }
        return i12;
    }

    public static int c(int i11) {
        if (i11 == 2147385345 || i11 == -25230976 || i11 == 536864768 || i11 == -14745368) {
            return 1;
        }
        if (i11 == 1683496997 || i11 == 622876772) {
            return 2;
        }
        if (i11 == 1078008818 || i11 == -233094848) {
            return 3;
        }
        return (i11 == 1908687592 || i11 == -398277519) ? 4 : 0;
    }

    public static z3.b0 d(byte[] bArr) {
        byte b11 = bArr[0];
        if (b11 == 127 || b11 == 100 || b11 == 64 || b11 == 113) {
            return new z3.b0(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (e(bArrCopyOf)) {
            for (int i11 = 0; i11 < bArrCopyOf.length - 1; i11 += 2) {
                byte b12 = bArrCopyOf[i11];
                int i12 = i11 + 1;
                bArrCopyOf[i11] = bArrCopyOf[i12];
                bArrCopyOf[i12] = b12;
            }
        }
        z3.b0 b0Var = new z3.b0(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            z3.b0 b0Var2 = new z3.b0(bArrCopyOf);
            while (b0Var2.b() >= 16) {
                b0Var2.r(2);
                b0Var.f(b0Var2.h(14), 14);
            }
        }
        b0Var.n(bArrCopyOf);
        return b0Var;
    }

    public static boolean e(byte[] bArr) {
        byte b11 = bArr[0];
        return b11 == -2 || b11 == -1 || b11 == 37 || b11 == -14 || b11 == -24;
    }

    public static int f(ByteBuffer byteBuffer) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition = byteBuffer.position();
        byte b13 = byteBuffer.get(iPosition);
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b12 = byteBuffer.get(iPosition + 7);
            } else if (b13 != 31) {
                i11 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b11 = byteBuffer.get(iPosition + 5);
            } else {
                i11 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b12 = byteBuffer.get(iPosition + 6);
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b11 = byteBuffer.get(iPosition + 4);
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }

    public static int g(byte[] bArr) {
        int i11;
        byte b11;
        int i12;
        byte b12;
        byte b13 = bArr[0];
        if (b13 != -2) {
            if (b13 == -1) {
                i11 = (bArr[4] & 7) << 4;
                b12 = bArr[7];
            } else if (b13 != 31) {
                i11 = (bArr[4] & 1) << 6;
                b11 = bArr[5];
            } else {
                i11 = (bArr[5] & 7) << 4;
                b12 = bArr[6];
            }
            i12 = b12 & 60;
            return (((i12 >> 2) | i11) + 1) * 32;
        }
        i11 = (bArr[5] & 1) << 6;
        b11 = bArr[4];
        i12 = b11 & 252;
        return (((i12 >> 2) | i11) + 1) * 32;
    }

    public static androidx.media3.common.y h(byte[] bArr, @Nullable String str, @Nullable String str2, int i11, @Nullable DrmInitData drmInitData) {
        z3.b0 b0VarD = d(bArr);
        b0VarD.r(60);
        int i12 = f78355a[b0VarD.h(6)];
        int i13 = f78356b[b0VarD.h(4)];
        int iH = b0VarD.h(5);
        int[] iArr = f78357c;
        int i14 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        b0VarD.r(10);
        return new androidx.media3.common.y.b().X(str).k0(MimeTypes.AUDIO_DTS).K(i14).L(i12 + (b0VarD.h(2) > 0 ? 1 : 0)).l0(i13).R(drmInitData).b0(str2).i0(i11).I();
    }

    public static b i(byte[] bArr) throws ParserException {
        int i11;
        int i12;
        int iH;
        int iH2;
        int i13;
        long jF1;
        int i14;
        z3.b0 b0VarD = d(bArr);
        b0VarD.r(40);
        int iH3 = b0VarD.h(2);
        if (b0VarD.g()) {
            i11 = 20;
            i12 = 12;
        } else {
            i11 = 16;
            i12 = 8;
        }
        b0VarD.r(i12);
        int iH4 = b0VarD.h(i11) + 1;
        boolean zG = b0VarD.g();
        int i15 = 0;
        if (zG) {
            iH = b0VarD.h(2);
            int iH5 = (b0VarD.h(3) + 1) * 512;
            if (b0VarD.g()) {
                b0VarD.r(36);
            }
            int iH6 = b0VarD.h(3) + 1;
            int iH7 = b0VarD.h(3) + 1;
            if (iH6 != 1 || iH7 != 1) {
                throw ParserException.createForUnsupportedContainerFeature("Multiple audio presentations or assets not supported");
            }
            int i16 = iH3 + 1;
            int iH8 = b0VarD.h(i16);
            for (int i17 = 0; i17 < i16; i17++) {
                if (((iH8 >> i17) & 1) == 1) {
                    b0VarD.r(8);
                }
            }
            if (b0VarD.g()) {
                b0VarD.r(2);
                int iH9 = (b0VarD.h(2) + 1) << 2;
                int iH10 = b0VarD.h(2) + 1;
                while (i15 < iH10) {
                    b0VarD.r(iH9);
                    i15++;
                }
            }
            i15 = iH5;
        } else {
            iH = -1;
        }
        b0VarD.r(i11);
        b0VarD.r(12);
        if (zG) {
            if (b0VarD.g()) {
                b0VarD.r(4);
            }
            if (b0VarD.g()) {
                b0VarD.r(24);
            }
            if (b0VarD.g()) {
                b0VarD.s(b0VarD.h(10) + 1);
            }
            b0VarD.r(5);
            int i18 = f78358d[b0VarD.h(4)];
            iH2 = b0VarD.h(8) + 1;
            i13 = i18;
        } else {
            iH2 = -1;
            i13 = -2147483647;
        }
        if (zG) {
            if (iH == 0) {
                i14 = 32000;
            } else if (iH == 1) {
                i14 = 44100;
            } else {
                if (iH != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported reference clock code in DTS HD header: " + iH, null);
                }
                i14 = 48000;
            }
            jF1 = z3.u0.f1(i15, 1000000L, i14);
        } else {
            jF1 = C.TIME_UNSET;
        }
        return new b(MimeTypes.AUDIO_DTS_EXPRESS, iH2, i13, iH4, jF1, 0);
    }

    public static int j(byte[] bArr) {
        z3.b0 b0VarD = d(bArr);
        b0VarD.r(42);
        return b0VarD.h(b0VarD.g() ? 12 : 8) + 1;
    }

    public static b k(byte[] bArr, AtomicInteger atomicInteger) throws ParserException {
        long jF1;
        int iH;
        int i11;
        int i12;
        z3.b0 b0VarD = d(bArr);
        int i13 = b0VarD.h(32) == 1078008818 ? 1 : 0;
        int iM = m(b0VarD, f78359e, true) + 1;
        if (i13 == 0) {
            jF1 = -9223372036854775807L;
            iH = -2147483647;
        } else {
            if (!b0VarD.g()) {
                throw ParserException.createForUnsupportedContainerFeature("Only supports full channel mask-based audio presentation");
            }
            a(bArr, iM);
            int iH2 = b0VarD.h(2);
            if (iH2 == 0) {
                i11 = 512;
            } else if (iH2 == 1) {
                i11 = 480;
            } else {
                if (iH2 != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported base duration index in DTS UHD header: " + iH2, null);
                }
                i11 = 384;
            }
            int iH3 = i11 * (b0VarD.h(3) + 1);
            int iH4 = b0VarD.h(2);
            if (iH4 == 0) {
                i12 = 32000;
            } else if (iH4 == 1) {
                i12 = 44100;
            } else {
                if (iH4 != 2) {
                    throw ParserException.createForMalformedContainer("Unsupported clock rate index in DTS UHD header: " + iH4, null);
                }
                i12 = 48000;
            }
            if (b0VarD.g()) {
                b0VarD.r(36);
            }
            iH = (1 << b0VarD.h(2)) * i12;
            jF1 = z3.u0.f1(iH3, 1000000L, i12);
        }
        int iM2 = 0;
        for (int i14 = 0; i14 < i13; i14++) {
            iM2 += m(b0VarD, f78360f, true);
        }
        if (i13 != 0) {
            atomicInteger.set(m(b0VarD, f78361g, true));
        }
        return new b("audio/vnd.dts.uhd;profile=p2", 2, iH, iM + iM2 + (atomicInteger.get() != 0 ? m(b0VarD, f78362h, true) : 0), jF1, 0);
    }

    public static int l(byte[] bArr) {
        z3.b0 b0VarD = d(bArr);
        b0VarD.r(32);
        return m(b0VarD, f78363i, true) + 1;
    }

    public static int m(z3.b0 b0Var, int[] iArr, boolean z11) {
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 3 && b0Var.g(); i13++) {
            i12++;
        }
        if (z11) {
            int i14 = 0;
            while (i11 < i12) {
                i14 += 1 << iArr[i11];
                i11++;
            }
            i11 = i14;
        }
        return i11 + b0Var.h(iArr[i12]);
    }
}

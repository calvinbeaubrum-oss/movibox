package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f32768a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f32769b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f32771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f32772c;

        public b(int i11, int i12, String str) {
            this.f32770a = i11;
            this.f32771b = i12;
            this.f32772c = str;
        }
    }

    public static byte[] a(int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = -1;
        while (true) {
            int[] iArr = f32768a;
            if (i14 >= iArr.length) {
                break;
            }
            if (i11 == iArr[i14]) {
                i15 = i14;
            }
            i14++;
        }
        int i16 = -1;
        while (true) {
            int[] iArr2 = f32769b;
            if (i13 >= iArr2.length) {
                break;
            }
            if (i12 == iArr2[i13]) {
                i16 = i13;
            }
            i13++;
        }
        if (i11 != -1 && i16 != -1) {
            return b(2, i15, i16);
        }
        throw new IllegalArgumentException("Invalid sample rate or number of channels: " + i11 + ", " + i12);
    }

    public static byte[] b(int i11, int i12, int i13) {
        return new byte[]{(byte) (((i11 << 3) & 248) | ((i12 >> 1) & 7)), (byte) (((i12 << 7) & 128) | ((i13 << 3) & 120))};
    }

    public static int c(com.google.android.exoplayer2.util.b0 b0Var) {
        int iH = b0Var.h(5);
        return iH == 31 ? b0Var.h(6) + 32 : iH;
    }

    public static int d(com.google.android.exoplayer2.util.b0 b0Var) throws ParserException {
        int iH = b0Var.h(4);
        if (iH == 15) {
            return b0Var.h(24);
        }
        if (iH < 13) {
            return f32768a[iH];
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(com.google.android.exoplayer2.util.b0 b0Var, boolean z11) throws ParserException {
        int iC = c(b0Var);
        int iD = d(b0Var);
        int iH = b0Var.h(4);
        String str = "mp4a.40." + iC;
        if (iC == 5 || iC == 29) {
            iD = d(b0Var);
            iC = c(b0Var);
            if (iC == 22) {
                iH = b0Var.h(4);
            }
        }
        if (z11) {
            if (iC != 1 && iC != 2 && iC != 3 && iC != 4 && iC != 6 && iC != 7 && iC != 17) {
                switch (iC) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + iC);
                }
            }
            g(b0Var, iC, iH);
            switch (iC) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iH2 = b0Var.h(2);
                    if (iH2 == 2 || iH2 == 3) {
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported epConfig: " + iH2);
                    }
                    break;
            }
        }
        int i11 = f32769b[iH];
        if (i11 != -1) {
            return new b(iD, i11, str);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b f(byte[] bArr) throws ParserException {
        return e(new com.google.android.exoplayer2.util.b0(bArr), false);
    }

    public static void g(com.google.android.exoplayer2.util.b0 b0Var, int i11, int i12) {
        if (b0Var.g()) {
            com.google.android.exoplayer2.util.s.i("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (b0Var.g()) {
            b0Var.r(14);
        }
        boolean zG = b0Var.g();
        if (i12 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i11 == 6 || i11 == 20) {
            b0Var.r(3);
        }
        if (zG) {
            if (i11 == 22) {
                b0Var.r(16);
            }
            if (i11 == 17 || i11 == 19 || i11 == 20 || i11 == 23) {
                b0Var.r(3);
            }
            b0Var.r(1);
        }
    }
}

package u4;

import androidx.media3.common.ParserException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f78192a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f78193b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f78196c;

        public b(int i11, int i12, String str) {
            this.f78194a = i11;
            this.f78195b = i12;
            this.f78196c = str;
        }
    }

    public static byte[] a(int i11, int i12, int i13) {
        return new byte[]{(byte) (((i11 << 3) & 248) | ((i12 >> 1) & 7)), (byte) (((i12 << 7) & 128) | ((i13 << 3) & 120))};
    }

    public static int b(z3.b0 b0Var) {
        int iH = b0Var.h(5);
        return iH == 31 ? b0Var.h(6) + 32 : iH;
    }

    public static int c(z3.b0 b0Var) throws ParserException {
        int iH = b0Var.h(4);
        if (iH == 15) {
            if (b0Var.b() >= 24) {
                return b0Var.h(24);
            }
            throw ParserException.createForMalformedContainer("AAC header insufficient data", null);
        }
        if (iH < 13) {
            return f78192a[iH];
        }
        throw ParserException.createForMalformedContainer("AAC header wrong Sampling Frequency Index", null);
    }

    public static b d(z3.b0 b0Var, boolean z11) throws ParserException {
        int iB = b(b0Var);
        int iC = c(b0Var);
        int iH = b0Var.h(4);
        String str = "mp4a.40." + iB;
        if (iB == 5 || iB == 29) {
            iC = c(b0Var);
            iB = b(b0Var);
            if (iB == 22) {
                iH = b0Var.h(4);
            }
        }
        if (z11) {
            if (iB != 1 && iB != 2 && iB != 3 && iB != 4 && iB != 6 && iB != 7 && iB != 17) {
                switch (iB) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw ParserException.createForUnsupportedContainerFeature("Unsupported audio object type: " + iB);
                }
            }
            f(b0Var, iB, iH);
            switch (iB) {
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
        int i11 = f78193b[iH];
        if (i11 != -1) {
            return new b(iC, i11, str);
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static b e(byte[] bArr) throws ParserException {
        return d(new z3.b0(bArr), false);
    }

    public static void f(z3.b0 b0Var, int i11, int i12) {
        if (b0Var.g()) {
            z3.o.h("AacUtil", "Unexpected frameLengthFlag = 1");
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

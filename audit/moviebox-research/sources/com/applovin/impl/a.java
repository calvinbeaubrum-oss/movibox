package com.applovin.impl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f17402a = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f17403b = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f17406c;

        private b(int i11, int i12, String str) {
            this.f17404a = i11;
            this.f17405b = i12;
            this.f17406c = str;
        }
    }

    private static int a(ah ahVar) {
        int iA = ahVar.a(5);
        return iA == 31 ? ahVar.a(6) + 32 : iA;
    }

    public static b a(ah ahVar, boolean z11) throws dh {
        int iA = a(ahVar);
        int iB = b(ahVar);
        int iA2 = ahVar.a(4);
        String str = "mp4a.40." + iA;
        if (iA == 5 || iA == 29) {
            iB = b(ahVar);
            iA = a(ahVar);
            if (iA == 22) {
                iA2 = ahVar.a(4);
            }
        }
        if (z11) {
            if (iA != 6 && iA != 7 && iA != 17 && iA != 1 && iA != 2 && iA != 3 && iA != 4) {
                switch (iA) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                        break;
                    default:
                        throw dh.a("Unsupported audio object type: " + iA);
                }
            }
            a(ahVar, iA, iA2);
            switch (iA) {
                case 17:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                    int iA3 = ahVar.a(2);
                    if (iA3 == 2 || iA3 == 3) {
                        throw dh.a("Unsupported epConfig: " + iA3);
                    }
                    break;
            }
        }
        int i11 = f17403b[iA2];
        if (i11 != -1) {
            return new b(iB, i11, str);
        }
        throw dh.a(null, null);
    }

    public static b a(byte[] bArr) {
        return a(new ah(bArr), false);
    }

    private static void a(ah ahVar, int i11, int i12) {
        if (ahVar.f()) {
            pc.d("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (ahVar.f()) {
            ahVar.d(14);
        }
        boolean zF = ahVar.f();
        if (i12 == 0) {
            throw new UnsupportedOperationException();
        }
        if (i11 == 6 || i11 == 20) {
            ahVar.d(3);
        }
        if (zF) {
            if (i11 == 22) {
                ahVar.d(16);
            }
            if (i11 == 17 || i11 == 19 || i11 == 20 || i11 == 23) {
                ahVar.d(3);
            }
            ahVar.d(1);
        }
    }

    public static byte[] a(int i11, int i12, int i13) {
        return new byte[]{(byte) (((i11 << 3) & 248) | ((i12 >> 1) & 7)), (byte) (((i12 << 7) & 128) | ((i13 << 3) & 120))};
    }

    private static int b(ah ahVar) throws dh {
        int iA = ahVar.a(4);
        if (iA == 15) {
            return ahVar.a(24);
        }
        if (iA < 13) {
            return f17402a[iA];
        }
        throw dh.a(null, null);
    }
}

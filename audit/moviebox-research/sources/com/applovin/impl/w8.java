package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w8 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f24075a;
    }

    public static long a(l8 l8Var, a9 a9Var) throws dh {
        l8Var.b();
        l8Var.c(1);
        byte[] bArr = new byte[1];
        l8Var.c(bArr, 0, 1);
        boolean z11 = (bArr[0] & 1) == 1;
        l8Var.c(2);
        int i11 = z11 ? 7 : 6;
        bh bhVar = new bh(i11);
        bhVar.e(n8.a(l8Var, bhVar.c(), 0, i11));
        l8Var.b();
        a aVar = new a();
        if (a(bhVar, a9Var, z11, aVar)) {
            return aVar.f24075a;
        }
        throw dh.a(null, null);
    }

    private static boolean a(int i11, a9 a9Var) {
        return i11 == 0 || i11 == a9Var.f17487i;
    }

    private static boolean a(bh bhVar, int i11) {
        return bhVar.w() == xp.b(bhVar.c(), i11, bhVar.d() - 1, 0);
    }

    private static boolean a(bh bhVar, a9 a9Var, int i11) {
        int iB = b(bhVar, i11);
        return iB != -1 && iB <= a9Var.f17480b;
    }

    public static boolean a(bh bhVar, a9 a9Var, int i11, a aVar) {
        int iD = bhVar.d();
        long jY = bhVar.y();
        long j11 = jY >>> 16;
        if (j11 != i11) {
            return false;
        }
        return b((int) (15 & (jY >> 4)), a9Var) && a((int) ((jY >> 1) & 7), a9Var) && !(((jY & 1) > 1L ? 1 : ((jY & 1) == 1L ? 0 : -1)) == 0) && a(bhVar, a9Var, ((j11 & 1) > 1L ? 1 : ((j11 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(bhVar, a9Var, (int) ((jY >> 12) & 15)) && b(bhVar, a9Var, (int) ((jY >> 8) & 15)) && a(bhVar, iD);
    }

    private static boolean a(bh bhVar, a9 a9Var, boolean z11, a aVar) {
        try {
            long jD = bhVar.D();
            if (!z11) {
                jD *= (long) a9Var.f17480b;
            }
            aVar.f24075a = jD;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean a(l8 l8Var, a9 a9Var, int i11, a aVar) {
        long jD = l8Var.d();
        byte[] bArr = new byte[2];
        l8Var.c(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            l8Var.b();
            l8Var.c((int) (jD - l8Var.f()));
            return false;
        }
        bh bhVar = new bh(16);
        System.arraycopy(bArr, 0, bhVar.c(), 0, 2);
        bhVar.e(n8.a(l8Var, bhVar.c(), 2, 14));
        l8Var.b();
        l8Var.c((int) (jD - l8Var.f()));
        return a(bhVar, a9Var, i11, aVar);
    }

    public static int b(bh bhVar, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return bhVar.w() + 1;
            case 7:
                return bhVar.C() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i11 - 8);
            default:
                return -1;
        }
    }

    private static boolean b(int i11, a9 a9Var) {
        if (i11 <= 7) {
            return i11 == a9Var.f17485g - 1;
        }
        return i11 <= 10 && a9Var.f17485g == 2;
    }

    private static boolean b(bh bhVar, a9 a9Var, int i11) {
        int i12 = a9Var.f17483e;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            return i11 == a9Var.f17484f;
        }
        if (i11 == 12) {
            return bhVar.w() * 1000 == i12;
        }
        if (i11 > 14) {
            return false;
        }
        int iC = bhVar.C();
        if (i11 == 14) {
            iC *= 10;
        }
        return iC == i12;
    }
}

package x5;

import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    public static int a(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] != 71) {
            i11++;
        }
        return i11;
    }

    public static boolean b(byte[] bArr, int i11, int i12, int i13) {
        int i14 = 0;
        for (int i15 = -4; i15 <= 4; i15++) {
            int i16 = (i15 * 188) + i13;
            if (i16 < i11 || i16 >= i12 || bArr[i16] != 71) {
                i14 = 0;
            } else {
                i14++;
                if (i14 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long c(z3.c0 c0Var, int i11, int i12) {
        c0Var.U(i11);
        if (c0Var.a() < 5) {
            return C.TIME_UNSET;
        }
        int iQ = c0Var.q();
        if ((8388608 & iQ) != 0 || ((2096896 & iQ) >> 8) != i12 || (iQ & 32) == 0 || c0Var.H() < 7 || c0Var.a() < 7 || (c0Var.H() & 16) != 16) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[6];
        c0Var.l(bArr, 0, 6);
        return d(bArr);
    }

    public static long d(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}

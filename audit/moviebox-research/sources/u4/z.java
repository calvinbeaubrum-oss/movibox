package u4;

import androidx.media3.common.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f78414a;
    }

    public static boolean a(z3.c0 c0Var, c0 c0Var2, int i11) {
        int iJ = j(c0Var, i11);
        return iJ != -1 && iJ <= c0Var2.f78220b;
    }

    public static boolean b(z3.c0 c0Var, int i11) {
        return c0Var.H() == z3.u0.y(c0Var.e(), i11, c0Var.f() - 1, 0);
    }

    public static boolean c(z3.c0 c0Var, c0 c0Var2, boolean z11, a aVar) {
        try {
            long jO = c0Var.O();
            if (!z11) {
                jO *= (long) c0Var2.f78220b;
            }
            aVar.f78414a = jO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(z3.c0 c0Var, c0 c0Var2, int i11, a aVar) {
        int iF = c0Var.f();
        long J = c0Var.J();
        long j11 = J >>> 16;
        if (j11 != i11) {
            return false;
        }
        return g((int) (15 & (J >> 4)), c0Var2) && f((int) ((J >> 1) & 7), c0Var2) && !(((J & 1) > 1L ? 1 : ((J & 1) == 1L ? 0 : -1)) == 0) && c(c0Var, c0Var2, ((j11 & 1) > 1L ? 1 : ((j11 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(c0Var, c0Var2, (int) ((J >> 12) & 15)) && e(c0Var, c0Var2, (int) ((J >> 8) & 15)) && b(c0Var, iF);
    }

    public static boolean e(z3.c0 c0Var, c0 c0Var2, int i11) {
        int i12 = c0Var2.f78223e;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            return i11 == c0Var2.f78224f;
        }
        if (i11 == 12) {
            return c0Var.H() * 1000 == i12;
        }
        if (i11 > 14) {
            return false;
        }
        int iN = c0Var.N();
        if (i11 == 14) {
            iN *= 10;
        }
        return iN == i12;
    }

    public static boolean f(int i11, c0 c0Var) {
        return i11 == 0 || i11 == c0Var.f78227i;
    }

    public static boolean g(int i11, c0 c0Var) {
        if (i11 <= 7) {
            return i11 == c0Var.f78225g - 1;
        }
        return i11 <= 10 && c0Var.f78225g == 2;
    }

    public static boolean h(t tVar, c0 c0Var, int i11, a aVar) throws IOException {
        long peekPosition = tVar.getPeekPosition();
        byte[] bArr = new byte[2];
        tVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            tVar.resetPeekPosition();
            tVar.advancePeekPosition((int) (peekPosition - tVar.getPosition()));
            return false;
        }
        z3.c0 c0Var2 = new z3.c0(16);
        System.arraycopy(bArr, 0, c0Var2.e(), 0, 2);
        c0Var2.T(v.c(tVar, c0Var2.e(), 2, 14));
        tVar.resetPeekPosition();
        tVar.advancePeekPosition((int) (peekPosition - tVar.getPosition()));
        return d(c0Var2, c0Var, i11, aVar);
    }

    public static long i(t tVar, c0 c0Var) throws IOException {
        tVar.resetPeekPosition();
        tVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        tVar.peekFully(bArr, 0, 1);
        boolean z11 = (bArr[0] & 1) == 1;
        tVar.advancePeekPosition(2);
        int i11 = z11 ? 7 : 6;
        z3.c0 c0Var2 = new z3.c0(i11);
        c0Var2.T(v.c(tVar, c0Var2.e(), 0, i11));
        tVar.resetPeekPosition();
        a aVar = new a();
        if (c(c0Var2, c0Var, z11, aVar)) {
            return aVar.f78414a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(z3.c0 c0Var, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return c0Var.H() + 1;
            case 7:
                return c0Var.N() + 1;
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
}

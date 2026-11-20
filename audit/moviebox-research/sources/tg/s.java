package tg;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class s {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f77076a;
    }

    public static boolean a(com.google.android.exoplayer2.util.c0 c0Var, v vVar, int i11) {
        int iJ = j(c0Var, i11);
        return iJ != -1 && iJ <= vVar.f77081b;
    }

    public static boolean b(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        return c0Var.D() == o0.u(c0Var.d(), i11, c0Var.e() - 1, 0);
    }

    public static boolean c(com.google.android.exoplayer2.util.c0 c0Var, v vVar, boolean z11, a aVar) {
        try {
            long jK = c0Var.K();
            if (!z11) {
                jK *= (long) vVar.f77081b;
            }
            aVar.f77076a = jK;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(com.google.android.exoplayer2.util.c0 c0Var, v vVar, int i11, a aVar) {
        int iE = c0Var.e();
        long jF = c0Var.F();
        long j11 = jF >>> 16;
        if (j11 != i11) {
            return false;
        }
        return g((int) (15 & (jF >> 4)), vVar) && f((int) ((jF >> 1) & 7), vVar) && !(((jF & 1) > 1L ? 1 : ((jF & 1) == 1L ? 0 : -1)) == 0) && c(c0Var, vVar, ((j11 & 1) > 1L ? 1 : ((j11 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(c0Var, vVar, (int) ((jF >> 12) & 15)) && e(c0Var, vVar, (int) ((jF >> 8) & 15)) && b(c0Var, iE);
    }

    public static boolean e(com.google.android.exoplayer2.util.c0 c0Var, v vVar, int i11) {
        int i12 = vVar.f77084e;
        if (i11 == 0) {
            return true;
        }
        if (i11 <= 11) {
            return i11 == vVar.f77085f;
        }
        if (i11 == 12) {
            return c0Var.D() * 1000 == i12;
        }
        if (i11 > 14) {
            return false;
        }
        int iJ = c0Var.J();
        if (i11 == 14) {
            iJ *= 10;
        }
        return iJ == i12;
    }

    public static boolean f(int i11, v vVar) {
        return i11 == 0 || i11 == vVar.f77088i;
    }

    public static boolean g(int i11, v vVar) {
        if (i11 <= 7) {
            return i11 == vVar.f77086g - 1;
        }
        return i11 <= 10 && vVar.f77086g == 2;
    }

    public static boolean h(m mVar, v vVar, int i11, a aVar) throws IOException {
        long peekPosition = mVar.getPeekPosition();
        byte[] bArr = new byte[2];
        mVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i11) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
            return false;
        }
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(16);
        System.arraycopy(bArr, 0, c0Var.d(), 0, 2);
        c0Var.O(o.c(mVar, c0Var.d(), 2, 14));
        mVar.resetPeekPosition();
        mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
        return d(c0Var, vVar, i11, aVar);
    }

    public static long i(m mVar, v vVar) throws IOException {
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        mVar.peekFully(bArr, 0, 1);
        boolean z11 = (bArr[0] & 1) == 1;
        mVar.advancePeekPosition(2);
        int i11 = z11 ? 7 : 6;
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(i11);
        c0Var.O(o.c(mVar, c0Var.d(), 0, i11));
        mVar.resetPeekPosition();
        a aVar = new a();
        if (c(c0Var, vVar, z11, aVar)) {
            return aVar.f77076a;
        }
        throw ParserException.createForMalformedContainer(null, null);
    }

    public static int j(com.google.android.exoplayer2.util.c0 c0Var, int i11) {
        switch (i11) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i11 - 2);
            case 6:
                return c0Var.D() + 1;
            case 7:
                return c0Var.J() + 1;
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

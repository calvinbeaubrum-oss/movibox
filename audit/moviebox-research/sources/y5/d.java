package y5;

import android.util.Pair;
import androidx.media3.common.ParserException;
import java.io.IOException;
import u4.t;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f81220a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f81221b;

        public a(int i11, long j11) {
            this.f81220a = i11;
            this.f81221b = j11;
        }

        public static a a(t tVar, c0 c0Var) throws IOException {
            tVar.peekFully(c0Var.e(), 0, 8);
            c0Var.U(0);
            return new a(c0Var.q(), c0Var.x());
        }
    }

    public static boolean a(t tVar) throws IOException {
        c0 c0Var = new c0(8);
        int i11 = a.a(tVar, c0Var).f81220a;
        if (i11 != 1380533830 && i11 != 1380333108) {
            return false;
        }
        tVar.peekFully(c0Var.e(), 0, 4);
        c0Var.U(0);
        int iQ = c0Var.q();
        if (iQ == 1463899717) {
            return true;
        }
        o.c("WavHeaderReader", "Unsupported form type: " + iQ);
        return false;
    }

    public static c b(t tVar) throws IOException {
        byte[] bArr;
        c0 c0Var = new c0(16);
        a aVarD = d(1718449184, tVar, c0Var);
        z3.a.g(aVarD.f81221b >= 16);
        tVar.peekFully(c0Var.e(), 0, 16);
        c0Var.U(0);
        int iZ = c0Var.z();
        int iZ2 = c0Var.z();
        int iY = c0Var.y();
        int iY2 = c0Var.y();
        int iZ3 = c0Var.z();
        int iZ4 = c0Var.z();
        int i11 = ((int) aVarD.f81221b) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            tVar.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = u0.f81843f;
        }
        tVar.skipFully((int) (tVar.getPeekPosition() - tVar.getPosition()));
        return new c(iZ, iZ2, iY, iY2, iZ3, iZ4, bArr);
    }

    public static long c(t tVar) throws IOException {
        c0 c0Var = new c0(8);
        a aVarA = a.a(tVar, c0Var);
        if (aVarA.f81220a != 1685272116) {
            tVar.resetPeekPosition();
            return -1L;
        }
        tVar.advancePeekPosition(8);
        c0Var.U(0);
        tVar.peekFully(c0Var.e(), 0, 8);
        long jV = c0Var.v();
        tVar.skipFully(((int) aVarA.f81221b) + 8);
        return jV;
    }

    public static a d(int i11, t tVar, c0 c0Var) throws IOException {
        a aVarA = a.a(tVar, c0Var);
        while (aVarA.f81220a != i11) {
            o.h("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f81220a);
            long j11 = aVarA.f81221b;
            long j12 = 8 + j11;
            if (j11 % 2 != 0) {
                j12 = 9 + j11;
            }
            if (j12 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + aVarA.f81220a);
            }
            tVar.skipFully((int) j12);
            aVarA = a.a(tVar, c0Var);
        }
        return aVarA;
    }

    public static Pair<Long, Long> e(t tVar) throws IOException {
        tVar.resetPeekPosition();
        a aVarD = d(1684108385, tVar, new c0(8));
        tVar.skipFully(8);
        return Pair.create(Long.valueOf(tVar.getPosition()), Long.valueOf(aVarD.f81221b));
    }
}

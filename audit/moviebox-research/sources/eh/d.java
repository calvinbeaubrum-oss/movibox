package eh;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.io.IOException;
import tg.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f64207b;

        public a(int i11, long j11) {
            this.f64206a = i11;
            this.f64207b = j11;
        }

        public static a a(m mVar, c0 c0Var) throws IOException {
            mVar.peekFully(c0Var.d(), 0, 8);
            c0Var.P(0);
            return new a(c0Var.n(), c0Var.t());
        }
    }

    public static boolean a(m mVar) throws IOException {
        c0 c0Var = new c0(8);
        int i11 = a.a(mVar, c0Var).f64206a;
        if (i11 != 1380533830 && i11 != 1380333108) {
            return false;
        }
        mVar.peekFully(c0Var.d(), 0, 4);
        c0Var.P(0);
        int iN = c0Var.n();
        if (iN == 1463899717) {
            return true;
        }
        s.c("WavHeaderReader", "Unsupported form type: " + iN);
        return false;
    }

    public static c b(m mVar) throws IOException {
        byte[] bArr;
        c0 c0Var = new c0(16);
        a aVarD = d(1718449184, mVar, c0Var);
        com.google.android.exoplayer2.util.a.g(aVarD.f64207b >= 16);
        mVar.peekFully(c0Var.d(), 0, 16);
        c0Var.P(0);
        int iV = c0Var.v();
        int iV2 = c0Var.v();
        int iU = c0Var.u();
        int iU2 = c0Var.u();
        int iV3 = c0Var.v();
        int iV4 = c0Var.v();
        int i11 = ((int) aVarD.f64207b) - 16;
        if (i11 > 0) {
            byte[] bArr2 = new byte[i11];
            mVar.peekFully(bArr2, 0, i11);
            bArr = bArr2;
        } else {
            bArr = o0.f35613f;
        }
        mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
        return new c(iV, iV2, iU, iU2, iV3, iV4, bArr);
    }

    public static long c(m mVar) throws IOException {
        c0 c0Var = new c0(8);
        a aVarA = a.a(mVar, c0Var);
        if (aVarA.f64206a != 1685272116) {
            mVar.resetPeekPosition();
            return -1L;
        }
        mVar.advancePeekPosition(8);
        c0Var.P(0);
        mVar.peekFully(c0Var.d(), 0, 8);
        long jR = c0Var.r();
        mVar.skipFully(((int) aVarA.f64207b) + 8);
        return jR;
    }

    public static a d(int i11, m mVar, c0 c0Var) throws IOException {
        a aVarA = a.a(mVar, c0Var);
        while (aVarA.f64206a != i11) {
            s.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f64206a);
            long j11 = aVarA.f64207b + 8;
            if (j11 > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + aVarA.f64206a);
            }
            mVar.skipFully((int) j11);
            aVarA = a.a(mVar, c0Var);
        }
        return aVarA;
    }

    public static Pair<Long, Long> e(m mVar) throws IOException {
        mVar.resetPeekPosition();
        a aVarD = d(1684108385, mVar, new c0(8));
        mVar.skipFully(8);
        return Pair.create(Long.valueOf(mVar.getPosition()), Long.valueOf(aVarD.f64207b));
    }
}

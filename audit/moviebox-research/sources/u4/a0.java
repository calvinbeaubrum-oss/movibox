package u4;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public c0 f78197a;

        public a(@Nullable c0 c0Var) {
            this.f78197a = c0Var;
        }
    }

    public static boolean a(t tVar) throws IOException {
        z3.c0 c0Var = new z3.c0(4);
        tVar.peekFully(c0Var.e(), 0, 4);
        return c0Var.J() == 1716281667;
    }

    public static int b(t tVar) throws IOException {
        tVar.resetPeekPosition();
        z3.c0 c0Var = new z3.c0(2);
        tVar.peekFully(c0Var.e(), 0, 2);
        int iN = c0Var.N();
        if ((iN >> 2) == 16382) {
            tVar.resetPeekPosition();
            return iN;
        }
        tVar.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(t tVar, boolean z11) throws IOException {
        Metadata metadataA = new h0().a(tVar, z11 ? null : g5.b.f65404b);
        if (metadataA == null || metadataA.length() == 0) {
            return null;
        }
        return metadataA;
    }

    @Nullable
    public static Metadata d(t tVar, boolean z11) throws IOException {
        tVar.resetPeekPosition();
        long peekPosition = tVar.getPeekPosition();
        Metadata metadataC = c(tVar, z11);
        tVar.skipFully((int) (tVar.getPeekPosition() - peekPosition));
        return metadataC;
    }

    public static boolean e(t tVar, a aVar) throws IOException {
        tVar.resetPeekPosition();
        z3.b0 b0Var = new z3.b0(new byte[4]);
        tVar.peekFully(b0Var.f81757a, 0, 4);
        boolean zG = b0Var.g();
        int iH = b0Var.h(7);
        int iH2 = b0Var.h(24) + 4;
        if (iH == 0) {
            aVar.f78197a = h(tVar);
        } else {
            c0 c0Var = aVar.f78197a;
            if (c0Var == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f78197a = c0Var.b(f(tVar, iH2));
            } else if (iH == 4) {
                aVar.f78197a = c0Var.c(j(tVar, iH2));
            } else if (iH == 6) {
                z3.c0 c0Var2 = new z3.c0(iH2);
                tVar.readFully(c0Var2.e(), 0, iH2);
                c0Var2.V(4);
                aVar.f78197a = c0Var.a(ImmutableList.of(PictureFrame.fromPictureBlock(c0Var2)));
            } else {
                tVar.skipFully(iH2);
            }
        }
        return zG;
    }

    public static c0.a f(t tVar, int i11) throws IOException {
        z3.c0 c0Var = new z3.c0(i11);
        tVar.readFully(c0Var.e(), 0, i11);
        return g(c0Var);
    }

    public static c0.a g(z3.c0 c0Var) {
        c0Var.V(1);
        int iK = c0Var.K();
        long jF = ((long) c0Var.f()) + ((long) iK);
        int i11 = iK / 18;
        long[] jArrCopyOf = new long[i11];
        long[] jArrCopyOf2 = new long[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            long jA = c0Var.A();
            if (jA == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                break;
            }
            jArrCopyOf[i12] = jA;
            jArrCopyOf2[i12] = c0Var.A();
            c0Var.V(2);
        }
        c0Var.V((int) (jF - ((long) c0Var.f())));
        return new c0.a(jArrCopyOf, jArrCopyOf2);
    }

    public static c0 h(t tVar) throws IOException {
        byte[] bArr = new byte[38];
        tVar.readFully(bArr, 0, 38);
        return new c0(bArr, 4);
    }

    public static void i(t tVar) throws IOException {
        z3.c0 c0Var = new z3.c0(4);
        tVar.readFully(c0Var.e(), 0, 4);
        if (c0Var.J() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    public static List<String> j(t tVar, int i11) throws IOException {
        z3.c0 c0Var = new z3.c0(i11);
        tVar.readFully(c0Var.e(), 0, i11);
        c0Var.V(4);
        return Arrays.asList(u0.k(c0Var, false, false).f78397b);
    }
}

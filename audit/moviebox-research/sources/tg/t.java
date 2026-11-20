package tg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public v f77077a;

        public a(@Nullable v vVar) {
            this.f77077a = vVar;
        }
    }

    public static boolean a(m mVar) throws IOException {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(4);
        mVar.peekFully(c0Var.d(), 0, 4);
        return c0Var.F() == 1716281667;
    }

    public static int b(m mVar) throws IOException {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(2);
        mVar.peekFully(c0Var.d(), 0, 2);
        int iJ = c0Var.J();
        if ((iJ >> 2) == 16382) {
            mVar.resetPeekPosition();
            return iJ;
        }
        mVar.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(m mVar, boolean z11) throws IOException {
        Metadata metadataA = new y().a(mVar, z11 ? null : kh.b.f68568b);
        if (metadataA == null || metadataA.length() == 0) {
            return null;
        }
        return metadataA;
    }

    @Nullable
    public static Metadata d(m mVar, boolean z11) throws IOException {
        mVar.resetPeekPosition();
        long peekPosition = mVar.getPeekPosition();
        Metadata metadataC = c(mVar, z11);
        mVar.skipFully((int) (mVar.getPeekPosition() - peekPosition));
        return metadataC;
    }

    public static boolean e(m mVar, a aVar) throws IOException {
        mVar.resetPeekPosition();
        com.google.android.exoplayer2.util.b0 b0Var = new com.google.android.exoplayer2.util.b0(new byte[4]);
        mVar.peekFully(b0Var.f35543a, 0, 4);
        boolean zG = b0Var.g();
        int iH = b0Var.h(7);
        int iH2 = b0Var.h(24) + 4;
        if (iH == 0) {
            aVar.f77077a = h(mVar);
        } else {
            v vVar = aVar.f77077a;
            if (vVar == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f77077a = vVar.b(g(mVar, iH2));
            } else if (iH == 4) {
                aVar.f77077a = vVar.c(j(mVar, iH2));
            } else if (iH == 6) {
                com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(iH2);
                mVar.readFully(c0Var.d(), 0, iH2);
                c0Var.Q(4);
                aVar.f77077a = vVar.a(ImmutableList.of(PictureFrame.fromPictureBlock(c0Var)));
            } else {
                mVar.skipFully(iH2);
            }
        }
        return zG;
    }

    public static v.a f(com.google.android.exoplayer2.util.c0 c0Var) {
        c0Var.Q(1);
        int iG = c0Var.G();
        long jE = ((long) c0Var.e()) + ((long) iG);
        int i11 = iG / 18;
        long[] jArrCopyOf = new long[i11];
        long[] jArrCopyOf2 = new long[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            long jW = c0Var.w();
            if (jW == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i12);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i12);
                break;
            }
            jArrCopyOf[i12] = jW;
            jArrCopyOf2[i12] = c0Var.w();
            c0Var.Q(2);
        }
        c0Var.Q((int) (jE - ((long) c0Var.e())));
        return new v.a(jArrCopyOf, jArrCopyOf2);
    }

    public static v.a g(m mVar, int i11) throws IOException {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(i11);
        mVar.readFully(c0Var.d(), 0, i11);
        return f(c0Var);
    }

    public static v h(m mVar) throws IOException {
        byte[] bArr = new byte[38];
        mVar.readFully(bArr, 0, 38);
        return new v(bArr, 4);
    }

    public static void i(m mVar) throws IOException {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(4);
        mVar.readFully(c0Var.d(), 0, 4);
        if (c0Var.F() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    public static List<String> j(m mVar, int i11) throws IOException {
        com.google.android.exoplayer2.util.c0 c0Var = new com.google.android.exoplayer2.util.c0(i11);
        mVar.readFully(c0Var.d(), 0, i11);
        c0Var.Q(4);
        return Arrays.asList(h0.j(c0Var, false, false).f77039b);
    }
}

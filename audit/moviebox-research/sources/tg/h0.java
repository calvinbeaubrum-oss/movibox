package tg;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f77033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f77034b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f77035c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f77036d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f77037e;

        public a(int i11, int i12, long[] jArr, int i13, boolean z11) {
            this.f77033a = i11;
            this.f77034b = i12;
            this.f77035c = jArr;
            this.f77036d = i13;
            this.f77037e = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f77038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f77039b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f77040c;

        public b(String str, String[] strArr, int i11) {
            this.f77038a = str;
            this.f77039b = strArr;
            this.f77040c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f77041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f77042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f77043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f77044d;

        public c(boolean z11, int i11, int i12, int i13) {
            this.f77041a = z11;
            this.f77042b = i11;
            this.f77043c = i12;
            this.f77044d = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f77045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f77046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f77047c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f77048d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f77049e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f77050f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f77051g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f77052h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f77053i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f77054j;

        public d(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11, byte[] bArr) {
            this.f77045a = i11;
            this.f77046b = i12;
            this.f77047c = i13;
            this.f77048d = i14;
            this.f77049e = i15;
            this.f77050f = i16;
            this.f77051g = i17;
            this.f77052h = i18;
            this.f77053i = z11;
            this.f77054j = bArr;
        }
    }

    public static int a(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    public static long b(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    @Nullable
    public static Metadata c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            String[] strArrU0 = o0.U0(str, "=");
            if (strArrU0.length != 2) {
                com.google.android.exoplayer2.util.s.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrU0[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new com.google.android.exoplayer2.util.c0(Base64.decode(strArrU0[1], 0))));
                } catch (RuntimeException e11) {
                    com.google.android.exoplayer2.util.s.j("VorbisUtil", "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new VorbisComment(strArrU0[0], strArrU0[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static a d(g0 g0Var) throws ParserException {
        if (g0Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + g0Var.b(), null);
        }
        int iD = g0Var.d(16);
        int iD2 = g0Var.d(24);
        long[] jArr = new long[iD2];
        boolean zC = g0Var.c();
        long jB = 0;
        if (zC) {
            int iD3 = g0Var.d(5) + 1;
            int i11 = 0;
            while (i11 < iD2) {
                int iD4 = g0Var.d(a(iD2 - i11));
                for (int i12 = 0; i12 < iD4 && i11 < iD2; i12++) {
                    jArr[i11] = iD3;
                    i11++;
                }
                iD3++;
            }
        } else {
            boolean zC2 = g0Var.c();
            for (int i13 = 0; i13 < iD2; i13++) {
                if (!zC2) {
                    jArr[i13] = g0Var.d(5) + 1;
                } else if (g0Var.c()) {
                    jArr[i13] = g0Var.d(5) + 1;
                } else {
                    jArr[i13] = 0;
                }
            }
        }
        int iD5 = g0Var.d(4);
        if (iD5 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + iD5, null);
        }
        if (iD5 == 1 || iD5 == 2) {
            g0Var.e(32);
            g0Var.e(32);
            int iD6 = g0Var.d(4) + 1;
            g0Var.e(1);
            if (iD5 != 1) {
                jB = ((long) iD2) * ((long) iD);
            } else if (iD != 0) {
                jB = b(iD2, iD);
            }
            g0Var.e((int) (jB * ((long) iD6)));
        }
        return new a(iD, iD2, jArr, iD5, zC);
    }

    public static void e(g0 g0Var) throws ParserException {
        int iD = g0Var.d(6) + 1;
        for (int i11 = 0; i11 < iD; i11++) {
            int iD2 = g0Var.d(16);
            if (iD2 == 0) {
                g0Var.e(8);
                g0Var.e(16);
                g0Var.e(16);
                g0Var.e(6);
                g0Var.e(8);
                int iD3 = g0Var.d(4) + 1;
                for (int i12 = 0; i12 < iD3; i12++) {
                    g0Var.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = g0Var.d(5);
                int[] iArr = new int[iD4];
                int i13 = -1;
                for (int i14 = 0; i14 < iD4; i14++) {
                    int iD5 = g0Var.d(4);
                    iArr[i14] = iD5;
                    if (iD5 > i13) {
                        i13 = iD5;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = g0Var.d(3) + 1;
                    int iD6 = g0Var.d(2);
                    if (iD6 > 0) {
                        g0Var.e(8);
                    }
                    for (int i17 = 0; i17 < (1 << iD6); i17++) {
                        g0Var.e(8);
                    }
                }
                g0Var.e(2);
                int iD7 = g0Var.d(4);
                int i18 = 0;
                int i19 = 0;
                for (int i21 = 0; i21 < iD4; i21++) {
                    i18 += iArr2[iArr[i21]];
                    while (i19 < i18) {
                        g0Var.e(iD7);
                        i19++;
                    }
                }
            }
        }
    }

    public static void f(int i11, g0 g0Var) throws ParserException {
        int iD = g0Var.d(6) + 1;
        for (int i12 = 0; i12 < iD; i12++) {
            int iD2 = g0Var.d(16);
            if (iD2 != 0) {
                com.google.android.exoplayer2.util.s.c("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = g0Var.c() ? g0Var.d(4) + 1 : 1;
                if (g0Var.c()) {
                    int iD4 = g0Var.d(8) + 1;
                    for (int i13 = 0; i13 < iD4; i13++) {
                        int i14 = i11 - 1;
                        g0Var.e(a(i14));
                        g0Var.e(a(i14));
                    }
                }
                if (g0Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        g0Var.e(4);
                    }
                }
                for (int i16 = 0; i16 < iD3; i16++) {
                    g0Var.e(8);
                    g0Var.e(8);
                    g0Var.e(8);
                }
            }
        }
    }

    public static c[] g(g0 g0Var) {
        int iD = g0Var.d(6) + 1;
        c[] cVarArr = new c[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            cVarArr[i11] = new c(g0Var.c(), g0Var.d(16), g0Var.d(16), g0Var.d(8));
        }
        return cVarArr;
    }

    public static void h(g0 g0Var) throws ParserException {
        int iD = g0Var.d(6) + 1;
        for (int i11 = 0; i11 < iD; i11++) {
            if (g0Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            g0Var.e(24);
            g0Var.e(24);
            g0Var.e(24);
            int iD2 = g0Var.d(6) + 1;
            g0Var.e(8);
            int[] iArr = new int[iD2];
            for (int i12 = 0; i12 < iD2; i12++) {
                iArr[i12] = ((g0Var.c() ? g0Var.d(5) : 0) * 8) + g0Var.d(3);
            }
            for (int i13 = 0; i13 < iD2; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        g0Var.e(8);
                    }
                }
            }
        }
    }

    public static b i(com.google.android.exoplayer2.util.c0 c0Var) throws ParserException {
        return j(c0Var, true, true);
    }

    public static b j(com.google.android.exoplayer2.util.c0 c0Var, boolean z11, boolean z12) throws ParserException {
        if (z11) {
            m(3, c0Var, false);
        }
        String strA = c0Var.A((int) c0Var.t());
        int length = strA.length();
        long jT = c0Var.t();
        String[] strArr = new String[(int) jT];
        int length2 = length + 15;
        for (int i11 = 0; i11 < jT; i11++) {
            String strA2 = c0Var.A((int) c0Var.t());
            strArr[i11] = strA2;
            length2 = length2 + 4 + strA2.length();
        }
        if (z12 && (c0Var.D() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new b(strA, strArr, length2 + 1);
    }

    public static d k(com.google.android.exoplayer2.util.c0 c0Var) throws ParserException {
        m(1, c0Var, false);
        int iU = c0Var.u();
        int iD = c0Var.D();
        int iU2 = c0Var.u();
        int iQ = c0Var.q();
        if (iQ <= 0) {
            iQ = -1;
        }
        int iQ2 = c0Var.q();
        if (iQ2 <= 0) {
            iQ2 = -1;
        }
        int iQ3 = c0Var.q();
        if (iQ3 <= 0) {
            iQ3 = -1;
        }
        int iD2 = c0Var.D();
        return new d(iU, iD, iU2, iQ, iQ2, iQ3, (int) Math.pow(2.0d, iD2 & 15), (int) Math.pow(2.0d, (iD2 & 240) >> 4), (c0Var.D() & 1) > 0, Arrays.copyOf(c0Var.d(), c0Var.f()));
    }

    public static c[] l(com.google.android.exoplayer2.util.c0 c0Var, int i11) throws ParserException {
        m(5, c0Var, false);
        int iD = c0Var.D() + 1;
        g0 g0Var = new g0(c0Var.d());
        g0Var.e(c0Var.e() * 8);
        for (int i12 = 0; i12 < iD; i12++) {
            d(g0Var);
        }
        int iD2 = g0Var.d(6) + 1;
        for (int i13 = 0; i13 < iD2; i13++) {
            if (g0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        e(g0Var);
        h(g0Var);
        f(i11, g0Var);
        c[] cVarArrG = g(g0Var);
        if (g0Var.c()) {
            return cVarArrG;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static boolean m(int i11, com.google.android.exoplayer2.util.c0 c0Var, boolean z11) throws ParserException {
        if (c0Var.a() < 7) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + c0Var.a(), null);
        }
        if (c0Var.D() != i11) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i11), null);
        }
        if (c0Var.D() == 118 && c0Var.D() == 111 && c0Var.D() == 114 && c0Var.D() == 98 && c0Var.D() == 105 && c0Var.D() == 115) {
            return true;
        }
        if (z11) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}

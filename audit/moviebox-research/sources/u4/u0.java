package u4;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.extractor.metadata.flac.PictureFrame;
import androidx.media3.extractor.metadata.vorbis.VorbisComment;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0 {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f78396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f78397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78398c;

        public a(String str, String[] strArr, int i11) {
            this.f78396a = str;
            this.f78397b = strArr;
            this.f78398c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f78399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78402d;

        public b(boolean z11, int i11, int i12, int i13) {
            this.f78399a = z11;
            this.f78400b = i11;
            this.f78401c = i12;
            this.f78402d = i13;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f78403a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f78404b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f78405c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f78406d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f78407e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f78408f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f78409g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f78410h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f78411i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f78412j;

        public c(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, boolean z11, byte[] bArr) {
            this.f78403a = i11;
            this.f78404b = i12;
            this.f78405c = i13;
            this.f78406d = i14;
            this.f78407e = i15;
            this.f78408f = i16;
            this.f78409g = i17;
            this.f78410h = i18;
            this.f78411i = z11;
            this.f78412j = bArr;
        }
    }

    @Nullable
    public static int[] a(int i11) {
        if (i11 == 3) {
            return new int[]{0, 2, 1};
        }
        if (i11 == 5) {
            return new int[]{0, 2, 1, 3, 4};
        }
        if (i11 == 6) {
            return new int[]{0, 2, 1, 5, 3, 4};
        }
        if (i11 == 7) {
            return new int[]{0, 2, 1, 6, 5, 3, 4};
        }
        if (i11 != 8) {
            return null;
        }
        return new int[]{0, 2, 1, 7, 5, 6, 3, 4};
    }

    public static int b(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i12++;
            i11 >>>= 1;
        }
        return i12;
    }

    public static long c(long j11, long j12) {
        return (long) Math.floor(Math.pow(j11, 1.0d / j12));
    }

    @Nullable
    public static Metadata d(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = list.get(i11);
            String[] strArrP1 = z3.u0.p1(str, "=");
            if (strArrP1.length != 2) {
                z3.o.h("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrP1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new z3.c0(Base64.decode(strArrP1[1], 0))));
                } catch (RuntimeException e11) {
                    z3.o.i("VorbisUtil", "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new VorbisComment(strArrP1[0], strArrP1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static ImmutableList<byte[]> e(byte[] bArr) {
        z3.c0 c0Var = new z3.c0(bArr);
        c0Var.V(1);
        int i11 = 0;
        while (c0Var.a() > 0 && c0Var.j() == 255) {
            i11 += 255;
            c0Var.V(1);
        }
        int iH = i11 + c0Var.H();
        int i12 = 0;
        while (c0Var.a() > 0 && c0Var.j() == 255) {
            i12 += 255;
            c0Var.V(1);
        }
        int iH2 = i12 + c0Var.H();
        byte[] bArr2 = new byte[iH];
        int iF = c0Var.f();
        System.arraycopy(bArr, iF, bArr2, 0, iH);
        int i13 = iF + iH + iH2;
        int length = bArr.length - i13;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, i13, bArr3, 0, length);
        return ImmutableList.of(bArr2, bArr3);
    }

    public static void f(t0 t0Var) throws ParserException {
        int iD = t0Var.d(6) + 1;
        for (int i11 = 0; i11 < iD; i11++) {
            int iD2 = t0Var.d(16);
            if (iD2 == 0) {
                t0Var.e(8);
                t0Var.e(16);
                t0Var.e(16);
                t0Var.e(6);
                t0Var.e(8);
                int iD3 = t0Var.d(4) + 1;
                for (int i12 = 0; i12 < iD3; i12++) {
                    t0Var.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = t0Var.d(5);
                int[] iArr = new int[iD4];
                int i13 = -1;
                for (int i14 = 0; i14 < iD4; i14++) {
                    int iD5 = t0Var.d(4);
                    iArr[i14] = iD5;
                    if (iD5 > i13) {
                        i13 = iD5;
                    }
                }
                int i15 = i13 + 1;
                int[] iArr2 = new int[i15];
                for (int i16 = 0; i16 < i15; i16++) {
                    iArr2[i16] = t0Var.d(3) + 1;
                    int iD6 = t0Var.d(2);
                    if (iD6 > 0) {
                        t0Var.e(8);
                    }
                    for (int i17 = 0; i17 < (1 << iD6); i17++) {
                        t0Var.e(8);
                    }
                }
                t0Var.e(2);
                int iD7 = t0Var.d(4);
                int i18 = 0;
                int i19 = 0;
                for (int i21 = 0; i21 < iD4; i21++) {
                    i18 += iArr2[iArr[i21]];
                    while (i19 < i18) {
                        t0Var.e(iD7);
                        i19++;
                    }
                }
            }
        }
    }

    public static void g(int i11, t0 t0Var) throws ParserException {
        int iD = t0Var.d(6) + 1;
        for (int i12 = 0; i12 < iD; i12++) {
            int iD2 = t0Var.d(16);
            if (iD2 != 0) {
                z3.o.c("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = t0Var.c() ? t0Var.d(4) + 1 : 1;
                if (t0Var.c()) {
                    int iD4 = t0Var.d(8) + 1;
                    for (int i13 = 0; i13 < iD4; i13++) {
                        int i14 = i11 - 1;
                        t0Var.e(b(i14));
                        t0Var.e(b(i14));
                    }
                }
                if (t0Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i15 = 0; i15 < i11; i15++) {
                        t0Var.e(4);
                    }
                }
                for (int i16 = 0; i16 < iD3; i16++) {
                    t0Var.e(8);
                    t0Var.e(8);
                    t0Var.e(8);
                }
            }
        }
    }

    public static b[] h(t0 t0Var) {
        int iD = t0Var.d(6) + 1;
        b[] bVarArr = new b[iD];
        for (int i11 = 0; i11 < iD; i11++) {
            bVarArr[i11] = new b(t0Var.c(), t0Var.d(16), t0Var.d(16), t0Var.d(8));
        }
        return bVarArr;
    }

    public static void i(t0 t0Var) throws ParserException {
        int iD = t0Var.d(6) + 1;
        for (int i11 = 0; i11 < iD; i11++) {
            if (t0Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            t0Var.e(24);
            t0Var.e(24);
            t0Var.e(24);
            int iD2 = t0Var.d(6) + 1;
            t0Var.e(8);
            int[] iArr = new int[iD2];
            for (int i12 = 0; i12 < iD2; i12++) {
                iArr[i12] = ((t0Var.c() ? t0Var.d(5) : 0) * 8) + t0Var.d(3);
            }
            for (int i13 = 0; i13 < iD2; i13++) {
                for (int i14 = 0; i14 < 8; i14++) {
                    if ((iArr[i13] & (1 << i14)) != 0) {
                        t0Var.e(8);
                    }
                }
            }
        }
    }

    public static a j(z3.c0 c0Var) throws ParserException {
        return k(c0Var, true, true);
    }

    public static a k(z3.c0 c0Var, boolean z11, boolean z12) throws ParserException {
        if (z11) {
            o(3, c0Var, false);
        }
        String strE = c0Var.E((int) c0Var.x());
        int length = strE.length();
        long jX = c0Var.x();
        String[] strArr = new String[(int) jX];
        int length2 = length + 15;
        for (int i11 = 0; i11 < jX; i11++) {
            String strE2 = c0Var.E((int) c0Var.x());
            strArr[i11] = strE2;
            length2 = length2 + 4 + strE2.length();
        }
        if (z12 && (c0Var.H() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new a(strE, strArr, length2 + 1);
    }

    public static c l(z3.c0 c0Var) throws ParserException {
        o(1, c0Var, false);
        int iY = c0Var.y();
        int iH = c0Var.H();
        int iY2 = c0Var.y();
        int iU = c0Var.u();
        if (iU <= 0) {
            iU = -1;
        }
        int iU2 = c0Var.u();
        if (iU2 <= 0) {
            iU2 = -1;
        }
        int iU3 = c0Var.u();
        if (iU3 <= 0) {
            iU3 = -1;
        }
        int iH2 = c0Var.H();
        return new c(iY, iH, iY2, iU, iU2, iU3, (int) Math.pow(2.0d, iH2 & 15), (int) Math.pow(2.0d, (iH2 & 240) >> 4), (c0Var.H() & 1) > 0, Arrays.copyOf(c0Var.e(), c0Var.g()));
    }

    public static b[] m(z3.c0 c0Var, int i11) throws ParserException {
        o(5, c0Var, false);
        int iH = c0Var.H() + 1;
        t0 t0Var = new t0(c0Var.e());
        t0Var.e(c0Var.f() * 8);
        for (int i12 = 0; i12 < iH; i12++) {
            n(t0Var);
        }
        int iD = t0Var.d(6) + 1;
        for (int i13 = 0; i13 < iD; i13++) {
            if (t0Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        f(t0Var);
        i(t0Var);
        g(i11, t0Var);
        b[] bVarArrH = h(t0Var);
        if (t0Var.c()) {
            return bVarArrH;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static void n(t0 t0Var) throws ParserException {
        long jC;
        if (t0Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + t0Var.b(), null);
        }
        int iD = t0Var.d(16);
        int iD2 = t0Var.d(24);
        int iD3 = 0;
        if (t0Var.c()) {
            t0Var.e(5);
            while (iD3 < iD2) {
                iD3 += t0Var.d(b(iD2 - iD3));
            }
        } else {
            boolean zC = t0Var.c();
            while (iD3 < iD2) {
                if (!zC) {
                    t0Var.e(5);
                } else if (t0Var.c()) {
                    t0Var.e(5);
                }
                iD3++;
            }
        }
        int iD4 = t0Var.d(4);
        if (iD4 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + iD4, null);
        }
        if (iD4 == 1 || iD4 == 2) {
            t0Var.e(32);
            t0Var.e(32);
            int iD5 = t0Var.d(4) + 1;
            t0Var.e(1);
            if (iD4 == 1) {
                jC = iD != 0 ? c(iD2, iD) : 0L;
            } else {
                jC = ((long) iD) * ((long) iD2);
            }
            t0Var.e((int) (jC * ((long) iD5)));
        }
    }

    public static boolean o(int i11, z3.c0 c0Var, boolean z11) throws ParserException {
        if (c0Var.a() < 7) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + c0Var.a(), null);
        }
        if (c0Var.H() != i11) {
            if (z11) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i11), null);
        }
        if (c0Var.H() == 118 && c0Var.H() == 111 && c0Var.H() == 114 && c0Var.H() == 98 && c0Var.H() == 105 && c0Var.H() == 115) {
            return true;
        }
        if (z11) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}

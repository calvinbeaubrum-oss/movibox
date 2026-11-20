package com.google.zxing.qrcode.encoder;

import an.f;
import com.google.android.gms.common.api.Api;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import hm.g;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f41581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f41582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorCorrectionLevel f41583d;

    /* JADX INFO: compiled from: source.java */
    public enum VersionSize {
        SMALL("version 1-9"),
        MEDIUM("version 10-26"),
        LARGE("version 27-40");

        private final String description;

        VersionSize(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f41585b;

        static {
            int[] iArr = new int[Mode.values().length];
            f41585b = iArr;
            try {
                iArr[Mode.KANJI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41585b[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f41585b[Mode.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41585b[Mode.BYTE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41585b[Mode.ECI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[VersionSize.values().length];
            f41584a = iArr2;
            try {
                iArr2[VersionSize.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41584a[VersionSize.MEDIUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41584a[VersionSize.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Mode f41586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f41587b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41588c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41589d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f41590e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41591f;

        public b(Mode mode, int i11, int i12, int i13, b bVar, f fVar) {
            this.f41586a = mode;
            this.f41587b = i11;
            Mode mode2 = Mode.BYTE;
            int i14 = (mode == mode2 || bVar == null) ? i12 : bVar.f41588c;
            this.f41588c = i14;
            this.f41589d = i13;
            this.f41590e = bVar;
            boolean z11 = false;
            int characterCountBits = bVar != null ? bVar.f41591f : 0;
            if ((mode == mode2 && bVar == null && i14 != 0) || (bVar != null && i14 != bVar.f41588c)) {
                z11 = true;
            }
            characterCountBits = (bVar == null || mode != bVar.f41586a || z11) ? characterCountBits + mode.getCharacterCountBits(fVar) + 4 : characterCountBits;
            int i15 = a.f41585b[mode.ordinal()];
            if (i15 == 1) {
                characterCountBits += 13;
            } else if (i15 == 2) {
                characterCountBits += i13 == 1 ? 6 : 11;
            } else if (i15 == 3) {
                characterCountBits += i13 != 1 ? i13 == 2 ? 7 : 10 : 4;
            } else if (i15 == 4) {
                characterCountBits += MinimalEncoder.this.f41582c.c(MinimalEncoder.this.f41580a.substring(i11, i13 + i11), i12).length * 8;
                if (z11) {
                    characterCountBits += 12;
                }
            }
            this.f41591f = characterCountBits;
        }

        public /* synthetic */ b(MinimalEncoder minimalEncoder, Mode mode, int i11, int i12, int i13, b bVar, f fVar, a aVar) {
            this(mode, i11, i12, i13, bVar, fVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f41593a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f41594b;

        /* JADX INFO: compiled from: source.java */
        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Mode f41596a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f41597b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f41598c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f41599d;

            public a(Mode mode, int i11, int i12, int i13) {
                this.f41596a = mode;
                this.f41597b = i11;
                this.f41598c = i12;
                this.f41599d = i13;
            }

            public final void d(hm.a aVar) throws WriterException {
                aVar.c(this.f41596a.getBits(), 4);
                if (this.f41599d > 0) {
                    aVar.c(e(), this.f41596a.getCharacterCountBits(c.this.f41594b));
                }
                if (this.f41596a == Mode.ECI) {
                    aVar.c(MinimalEncoder.this.f41582c.e(this.f41598c), 8);
                } else if (this.f41599d > 0) {
                    String str = MinimalEncoder.this.f41580a;
                    int i11 = this.f41597b;
                    com.google.zxing.qrcode.encoder.a.c(str.substring(i11, this.f41599d + i11), this.f41596a, aVar, MinimalEncoder.this.f41582c.d(this.f41598c));
                }
            }

            public final int e() {
                if (this.f41596a != Mode.BYTE) {
                    return this.f41599d;
                }
                g gVar = MinimalEncoder.this.f41582c;
                String str = MinimalEncoder.this.f41580a;
                int i11 = this.f41597b;
                return gVar.c(str.substring(i11, this.f41599d + i11), this.f41598c).length;
            }

            public final int f(f fVar) {
                int iE;
                int i11;
                int characterCountBits = this.f41596a.getCharacterCountBits(fVar);
                int i12 = characterCountBits + 4;
                int i13 = a.f41585b[this.f41596a.ordinal()];
                if (i13 != 1) {
                    int i14 = 0;
                    if (i13 == 2) {
                        int i15 = this.f41599d;
                        i11 = i12 + ((i15 / 2) * 11);
                        if (i15 % 2 == 1) {
                            i14 = 6;
                        }
                    } else if (i13 == 3) {
                        int i16 = this.f41599d;
                        i11 = i12 + ((i16 / 3) * 10);
                        int i17 = i16 % 3;
                        if (i17 == 1) {
                            i14 = 4;
                        } else if (i17 == 2) {
                            i14 = 7;
                        }
                    } else {
                        if (i13 != 4) {
                            return i13 != 5 ? i12 : characterCountBits + 12;
                        }
                        iE = e() * 8;
                    }
                    return i11 + i14;
                }
                iE = this.f41599d * 13;
                return i12 + iE;
            }

            public final String g(String str) {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < str.length(); i11++) {
                    if (str.charAt(i11) < ' ' || str.charAt(i11) > '~') {
                        sb2.append('.');
                    } else {
                        sb2.append(str.charAt(i11));
                    }
                }
                return sb2.toString();
            }

            public String toString() {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f41596a);
                sb2.append('(');
                if (this.f41596a == Mode.ECI) {
                    sb2.append(MinimalEncoder.this.f41582c.d(this.f41598c).displayName());
                } else {
                    String str = MinimalEncoder.this.f41580a;
                    int i11 = this.f41597b;
                    sb2.append(g(str.substring(i11, this.f41599d + i11)));
                }
                sb2.append(')');
                return sb2.toString();
            }
        }

        public c(f fVar, b bVar) {
            int i11;
            int i12;
            int i13 = 0;
            boolean z11 = false;
            while (true) {
                i11 = 1;
                if (bVar == null) {
                    break;
                }
                int i14 = i13 + bVar.f41589d;
                b bVar2 = bVar.f41590e;
                boolean z12 = (bVar.f41586a == Mode.BYTE && bVar2 == null && bVar.f41588c != 0) || !(bVar2 == null || bVar.f41588c == bVar2.f41588c);
                z11 = z12 ? true : z11;
                if (bVar2 == null || bVar2.f41586a != bVar.f41586a || z12) {
                    this.f41593a.add(0, new a(bVar.f41586a, bVar.f41587b, bVar.f41588c, i14));
                    i14 = 0;
                }
                if (z12) {
                    this.f41593a.add(0, new a(Mode.ECI, bVar.f41587b, bVar.f41588c, 0));
                }
                bVar = bVar2;
                i13 = i14;
            }
            if (MinimalEncoder.this.f41581b) {
                a aVar = this.f41593a.get(0);
                if (aVar != null) {
                    Mode mode = aVar.f41596a;
                    Mode mode2 = Mode.ECI;
                    if (mode != mode2 && z11) {
                        this.f41593a.add(0, new a(mode2, 0, 0, 0));
                    }
                }
                this.f41593a.add(this.f41593a.get(0).f41596a == Mode.ECI ? 1 : 0, new a(Mode.FNC1_FIRST_POSITION, 0, 0, 0));
            }
            int iJ = fVar.j();
            int i15 = a.f41584a[MinimalEncoder.m(fVar).ordinal()];
            if (i15 == 1) {
                i12 = 9;
            } else if (i15 != 2) {
                i11 = 27;
                i12 = 40;
            } else {
                i11 = 10;
                i12 = 26;
            }
            int iD = d(fVar);
            while (iJ < i12 && !com.google.zxing.qrcode.encoder.a.v(iD, f.i(iJ), MinimalEncoder.this.f41583d)) {
                iJ++;
            }
            while (iJ > i11 && com.google.zxing.qrcode.encoder.a.v(iD, f.i(iJ - 1), MinimalEncoder.this.f41583d)) {
                iJ--;
            }
            this.f41594b = f.i(iJ);
        }

        public void b(hm.a aVar) throws WriterException {
            Iterator<a> it = this.f41593a.iterator();
            while (it.hasNext()) {
                it.next().d(aVar);
            }
        }

        public int c() {
            return d(this.f41594b);
        }

        public final int d(f fVar) {
            Iterator<a> it = this.f41593a.iterator();
            int iF = 0;
            while (it.hasNext()) {
                iF += it.next().f(fVar);
            }
            return iF;
        }

        public f e() {
            return this.f41594b;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            a aVar = null;
            for (a aVar2 : this.f41593a) {
                if (aVar != null) {
                    sb2.append(",");
                }
                sb2.append(aVar2.toString());
                aVar = aVar2;
            }
            return sb2.toString();
        }
    }

    public MinimalEncoder(String str, Charset charset, boolean z11, ErrorCorrectionLevel errorCorrectionLevel) {
        this.f41580a = str;
        this.f41581b = z11;
        this.f41582c = new g(str, charset, -1);
        this.f41583d = errorCorrectionLevel;
    }

    public static c i(String str, f fVar, Charset charset, boolean z11, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return new MinimalEncoder(str, charset, z11, errorCorrectionLevel).h(fVar);
    }

    public static int k(Mode mode) {
        int i11;
        if (mode == null || (i11 = a.f41585b[mode.ordinal()]) == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 3) {
            return 2;
        }
        if (i11 == 4) {
            return 3;
        }
        throw new IllegalStateException("Illegal mode " + mode);
    }

    public static f l(VersionSize versionSize) {
        int i11 = a.f41584a[versionSize.ordinal()];
        if (i11 != 1) {
            return i11 != 2 ? f.i(40) : f.i(26);
        }
        return f.i(9);
    }

    public static VersionSize m(f fVar) {
        if (fVar.j() <= 9) {
            return VersionSize.SMALL;
        }
        return fVar.j() <= 26 ? VersionSize.MEDIUM : VersionSize.LARGE;
    }

    public static boolean n(char c11) {
        return com.google.zxing.qrcode.encoder.a.p(c11) != -1;
    }

    public static boolean o(char c11) {
        return com.google.zxing.qrcode.encoder.a.s(String.valueOf(c11));
    }

    public static boolean p(char c11) {
        return c11 >= '0' && c11 <= '9';
    }

    public void e(b[][][] bVarArr, int i11, b bVar) {
        b[] bVarArr2 = bVarArr[i11 + bVar.f41589d][bVar.f41588c];
        int iK = k(bVar.f41586a);
        b bVar2 = bVarArr2[iK];
        if (bVar2 == null || bVar2.f41591f > bVar.f41591f) {
            bVarArr2[iK] = bVar;
        }
    }

    public void f(f fVar, b[][][] bVarArr, int i11, b bVar) {
        int i12;
        int iG = this.f41582c.g();
        int iF = this.f41582c.f();
        if (iF < 0 || !this.f41582c.a(this.f41580a.charAt(i11), iF)) {
            iF = 0;
        } else {
            iG = iF + 1;
        }
        int i13 = iG;
        for (int i14 = iF; i14 < i13; i14++) {
            if (this.f41582c.a(this.f41580a.charAt(i11), i14)) {
                e(bVarArr, i11, new b(this, Mode.BYTE, i11, i14, 1, bVar, fVar, null));
            }
        }
        Mode mode = Mode.KANJI;
        if (g(mode, this.f41580a.charAt(i11))) {
            e(bVarArr, i11, new b(this, mode, i11, 0, 1, bVar, fVar, null));
        }
        int length = this.f41580a.length();
        Mode mode2 = Mode.ALPHANUMERIC;
        if (g(mode2, this.f41580a.charAt(i11))) {
            int i15 = i11 + 1;
            e(bVarArr, i11, new b(this, mode2, i11, 0, (i15 >= length || !g(mode2, this.f41580a.charAt(i15))) ? 1 : 2, bVar, fVar, null));
        }
        Mode mode3 = Mode.NUMERIC;
        if (g(mode3, this.f41580a.charAt(i11))) {
            int i16 = 0;
            int i17 = i11 + 1;
            if (i17 >= length || !g(mode3, this.f41580a.charAt(i17))) {
                i12 = 1;
            } else {
                int i18 = i11 + 2;
                i12 = (i18 >= length || !g(mode3, this.f41580a.charAt(i18))) ? 2 : 3;
            }
            e(bVarArr, i11, new b(this, mode3, i11, i16, i12, bVar, fVar, null));
        }
    }

    public boolean g(Mode mode, char c11) {
        int i11 = a.f41585b[mode.ordinal()];
        if (i11 == 1) {
            return o(c11);
        }
        if (i11 == 2) {
            return n(c11);
        }
        if (i11 != 3) {
            return i11 == 4;
        }
        return p(c11);
    }

    public c h(f fVar) throws WriterException {
        if (fVar != null) {
            c cVarJ = j(fVar);
            if (com.google.zxing.qrcode.encoder.a.v(cVarJ.c(), l(m(cVarJ.e())), this.f41583d)) {
                return cVarJ;
            }
            throw new WriterException("Data too big for version" + fVar);
        }
        f[] fVarArr = {l(VersionSize.SMALL), l(VersionSize.MEDIUM), l(VersionSize.LARGE)};
        c[] cVarArr = {j(fVarArr[0]), j(fVarArr[1]), j(fVarArr[2])};
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i12 = -1;
        for (int i13 = 0; i13 < 3; i13++) {
            int iC = cVarArr[i13].c();
            if (com.google.zxing.qrcode.encoder.a.v(iC, fVarArr[i13], this.f41583d) && iC < i11) {
                i12 = i13;
                i11 = iC;
            }
        }
        if (i12 >= 0) {
            return cVarArr[i12];
        }
        throw new WriterException("Data too big for any version");
    }

    public c j(f fVar) throws WriterException {
        int length = this.f41580a.length();
        b[][][] bVarArr = (b[][][]) Array.newInstance((Class<?>) b.class, length + 1, this.f41582c.g(), 4);
        f(fVar, bVarArr, 0, null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < this.f41582c.g(); i12++) {
                for (int i13 = 0; i13 < 4; i13++) {
                    b bVar = bVarArr[i11][i12][i13];
                    if (bVar != null && i11 < length) {
                        f(fVar, bVarArr, i11, bVar);
                    }
                }
            }
        }
        int i14 = -1;
        int i15 = -1;
        int i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i17 = 0; i17 < this.f41582c.g(); i17++) {
            for (int i18 = 0; i18 < 4; i18++) {
                b bVar2 = bVarArr[length][i17][i18];
                if (bVar2 != null && bVar2.f41591f < i16) {
                    i16 = bVar2.f41591f;
                    i14 = i17;
                    i15 = i18;
                }
            }
        }
        if (i14 >= 0) {
            return new c(fVar, bVarArr[length][i14][i15]);
        }
        throw new WriterException("Internal error: failed to encode \"" + this.f41580a + "\"");
    }
}

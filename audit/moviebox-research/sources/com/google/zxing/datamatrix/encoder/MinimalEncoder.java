package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import hm.m;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import nm.j;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f41508a = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* JADX INFO: compiled from: source.java */
    public enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f41510b;

        static {
            int[] iArr = new int[SymbolShapeHint.values().length];
            f41510b = iArr;
            try {
                iArr[SymbolShapeHint.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41510b[SymbolShapeHint.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f41509a = iArr2;
            try {
                iArr2[Mode.ASCII.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f41509a[Mode.B256.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f41509a[Mode.C40.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f41509a[Mode.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f41509a[Mode.X12.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f41509a[Mode.EDF.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int[] f41511g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, 174, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int[] f41512h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, 144, 174, 204, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int[] f41513i = {5, 10, 16, 33, 32, 49};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f41514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Mode f41515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41517d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f41518e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f41519f;

        /* JADX WARN: Code duplicated, block: B:42:0x0073 A[PHI: r10
  0x0073: PHI (r10v12 int) = (r10v8 int), (r10v8 int), (r10v8 int), (r10v15 int), (r10v15 int), (r10v15 int) binds: [B:55:0x0093, B:57:0x0097, B:59:0x009b, B:38:0x006b, B:40:0x006f, B:41:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:43:0x0076 A[PHI: r10
  0x0076: PHI (r10v10 int) = (r10v5 int), (r10v5 int), (r10v5 int), (r10v8 int), (r10v15 int), (r10v15 int) binds: [B:69:0x00bb, B:71:0x00bf, B:73:0x00c3, B:52:0x008e, B:32:0x0060, B:34:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
        public b(c cVar, Mode mode, int i11, int i12, b bVar) {
            this.f41514a = cVar;
            this.f41515b = mode;
            this.f41516c = i11;
            this.f41517d = i12;
            this.f41518e = bVar;
            int iJ = bVar != null ? bVar.f41519f : 0;
            Mode modeT = t();
            switch (a.f41509a[mode.ordinal()]) {
                case 1:
                    iJ = (cVar.a(i11) || MinimalEncoder.k(cVar.charAt(i11), cVar.f())) ? iJ + 2 : iJ + 1;
                    if (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == Mode.X12) {
                        iJ++;
                    }
                    break;
                case 2:
                    iJ = (modeT == Mode.B256 && g() != 250) ? iJ + 1 : iJ + 2;
                    if (modeT == Mode.ASCII) {
                        iJ++;
                    } else if (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == Mode.X12) {
                        iJ += 2;
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    Mode mode2 = Mode.X12;
                    if (mode == mode2) {
                        iJ += 2;
                    } else {
                        iJ += MinimalEncoder.j(cVar, i11, mode == Mode.C40, new int[1]) * 2;
                    }
                    if (modeT == Mode.ASCII || modeT == Mode.B256) {
                        iJ++;
                    } else if (modeT != mode && (modeT == Mode.C40 || modeT == Mode.TEXT || modeT == mode2)) {
                        iJ += 2;
                    }
                    break;
                case 6:
                    iJ = (modeT != Mode.ASCII && modeT != Mode.B256) ? (modeT != Mode.C40 && modeT != Mode.TEXT && modeT != Mode.X12) ? iJ + 3 : iJ + 5 : iJ + 4;
                    break;
            }
            this.f41519f = iJ;
        }

        public /* synthetic */ b(c cVar, Mode mode, int i11, int i12, b bVar, a aVar) {
            this(cVar, mode, i11, i12, bVar);
        }

        public static byte[] h(int i11) {
            return new byte[]{(byte) i11};
        }

        public static byte[] i(int i11, int i12) {
            return new byte[]{(byte) i11, (byte) i12};
        }

        public static int j(boolean z11, int i11, char c11, int i12) {
            if (c11 == i12) {
                return 27;
            }
            if (z11) {
                if (c11 <= 31) {
                    return c11;
                }
                if (c11 == ' ') {
                    return 3;
                }
                if (c11 <= '/') {
                    return c11 - '!';
                }
                if (c11 <= '9') {
                    return c11 - ',';
                }
                if (c11 <= '@') {
                    return c11 - '+';
                }
                if (c11 <= 'Z') {
                    return c11 - '3';
                }
                if (c11 <= '_') {
                    return c11 - 'E';
                }
                return c11 <= 127 ? c11 - '`' : c11;
            }
            if (c11 != 0) {
                if (i11 == 0 && c11 <= 3) {
                    return c11 - 1;
                }
                if (i11 == 1 && c11 <= 31) {
                    return c11;
                }
                if (c11 == ' ') {
                    return 3;
                }
                if (c11 >= '!' && c11 <= '/') {
                    return c11 - '!';
                }
                if (c11 >= '0' && c11 <= '9') {
                    return c11 - ',';
                }
                if (c11 >= ':' && c11 <= '@') {
                    return c11 - '+';
                }
                if (c11 >= 'A' && c11 <= 'Z') {
                    return c11 - '@';
                }
                if (c11 >= '[' && c11 <= '_') {
                    return c11 - 'E';
                }
                if (c11 != '`') {
                    if (c11 < 'a' || c11 > 'z') {
                        return (c11 < '{' || c11 > 127) ? c11 : c11 - '`';
                    }
                    return c11 - 'S';
                }
            }
            return 0;
        }

        public static int v(char c11, boolean z11, int i11) {
            if (!(z11 && MinimalEncoder.l(c11)) && (z11 || !MinimalEncoder.n(c11))) {
                return (!(z11 && MinimalEncoder.m(c11, i11)) && (z11 || !MinimalEncoder.o(c11, i11))) ? 2 : 1;
            }
            return 0;
        }

        public static int w(char c11) {
            if (c11 == '\r') {
                return 0;
            }
            if (c11 == '*') {
                return 1;
            }
            if (c11 == '>') {
                return 2;
            }
            if (c11 == ' ') {
                return 3;
            }
            if (c11 < '0' || c11 > '9') {
                return (c11 < 'A' || c11 > 'Z') ? c11 : c11 - '3';
            }
            return c11 - ',';
        }

        public static void y(byte[] bArr, int i11, int i12, int i13, int i14) {
            int i15 = ((i12 & 255) * 1600) + ((i13 & 255) * 40) + (i14 & 255) + 1;
            bArr[i11] = (byte) (i15 / 256);
            bArr[i11 + 1] = (byte) (i15 % 256);
        }

        public int g() {
            int i11 = 0;
            for (b bVar = this; bVar != null && bVar.f41515b == Mode.B256 && i11 <= 250; bVar = bVar.f41518e) {
                i11++;
            }
            return i11;
        }

        public byte[] k(boolean z11, int i11) {
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < this.f41517d; i12++) {
                char cCharAt = this.f41514a.charAt(this.f41516c + i12);
                if ((z11 && j.h(cCharAt)) || (!z11 && j.j(cCharAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z11, 0, cCharAt, i11)));
                } else if (MinimalEncoder.k(cCharAt, i11)) {
                    char c11 = (char) ((cCharAt & 255) - 128);
                    if (!(z11 && j.h(c11)) && (z11 || !j.j(c11))) {
                        arrayList.add((byte) 1);
                        arrayList.add(Byte.valueOf(Ascii.RS));
                        int iV = v(c11, z11, i11);
                        arrayList.add(Byte.valueOf((byte) iV));
                        arrayList.add(Byte.valueOf((byte) j(z11, iV, c11, i11)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add(Byte.valueOf(Ascii.RS));
                        arrayList.add(Byte.valueOf((byte) j(z11, 0, c11, i11)));
                    }
                } else {
                    int iV2 = v(cCharAt, z11, i11);
                    arrayList.add(Byte.valueOf((byte) iV2));
                    arrayList.add(Byte.valueOf((byte) j(z11, iV2, cCharAt, i11)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i13 = 0;
            for (int i14 = 0; i14 < arrayList.size(); i14 += 3) {
                y(bArr, i13, ((Byte) arrayList.get(i14)).byteValue() & 255, ((Byte) arrayList.get(i14 + 1)).byteValue() & 255, ((Byte) arrayList.get(i14 + 2)).byteValue() & 255);
                i13 += 2;
            }
            return bArr;
        }

        public int l(int i11) {
            return r(i11) - i11;
        }

        public byte[] m() {
            switch (a.f41509a[this.f41515b.ordinal()]) {
                case 1:
                    if (this.f41514a.a(this.f41516c)) {
                        return i(241, this.f41514a.b(this.f41516c) + 1);
                    }
                    if (MinimalEncoder.k(this.f41514a.charAt(this.f41516c), this.f41514a.f())) {
                        return i(235, this.f41514a.charAt(this.f41516c) - 127);
                    }
                    if (this.f41517d == 2) {
                        return h(((this.f41514a.charAt(this.f41516c) - '0') * 10) + this.f41514a.charAt(this.f41516c + 1) + 82);
                    }
                    return this.f41514a.h(this.f41516c) ? h(232) : h(this.f41514a.charAt(this.f41516c) + 1);
                case 2:
                    return h(this.f41514a.charAt(this.f41516c));
                case 3:
                    return k(true, this.f41514a.f());
                case 4:
                    return k(false, this.f41514a.f());
                case 5:
                    return x();
                case 6:
                    return n();
                default:
                    return new byte[0];
            }
        }

        public byte[] n() {
            int iCeil = (int) Math.ceil(((double) this.f41517d) / 4.0d);
            byte[] bArr = new byte[iCeil * 3];
            int i11 = this.f41516c;
            int iMin = Math.min((this.f41517d + i11) - 1, this.f41514a.length() - 1);
            for (int i12 = 0; i12 < iCeil; i12 += 3) {
                int[] iArr = new int[4];
                for (int i13 = 0; i13 < 4; i13++) {
                    if (i11 <= iMin) {
                        iArr[i13] = this.f41514a.charAt(i11) & '?';
                        i11++;
                    } else {
                        iArr[i13] = i11 == iMin + 1 ? 31 : 0;
                    }
                }
                int i14 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i12] = (byte) ((i14 >> 16) & 255);
                bArr[i12 + 1] = (byte) ((i14 >> 8) & 255);
                bArr[i12 + 2] = (byte) (i14 & 255);
            }
            return bArr;
        }

        public Mode o() {
            if (this.f41515b == Mode.EDF) {
                if (this.f41517d < 4) {
                    return Mode.ASCII;
                }
                int iP = p();
                if (iP > 0 && l(this.f41519f + iP) <= 2 - iP) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f41515b;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f41516c + this.f41517d >= this.f41514a.length() && l(this.f41519f) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f41519f + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f41515b;
        }

        public int p() {
            int length = this.f41514a.length();
            int i11 = this.f41516c + this.f41517d;
            int i12 = length - i11;
            if (i12 <= 4 && i11 < length) {
                if (i12 == 1) {
                    return MinimalEncoder.k(this.f41514a.charAt(i11), this.f41514a.f()) ? 0 : 1;
                }
                if (i12 == 2) {
                    if (!MinimalEncoder.k(this.f41514a.charAt(i11), this.f41514a.f())) {
                        int i13 = i11 + 1;
                        if (!MinimalEncoder.k(this.f41514a.charAt(i13), this.f41514a.f())) {
                            return (j.f(this.f41514a.charAt(i11)) && j.f(this.f41514a.charAt(i13))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i12 == 3) {
                    if (j.f(this.f41514a.charAt(i11)) && j.f(this.f41514a.charAt(i11 + 1)) && !MinimalEncoder.k(this.f41514a.charAt(i11 + 2), this.f41514a.f())) {
                        return 2;
                    }
                    return (j.f(this.f41514a.charAt(i11 + 1)) && j.f(this.f41514a.charAt(i11 + 2)) && !MinimalEncoder.k(this.f41514a.charAt(i11), this.f41514a.f())) ? 2 : 0;
                }
                if (j.f(this.f41514a.charAt(i11)) && j.f(this.f41514a.charAt(i11 + 1)) && j.f(this.f41514a.charAt(i11 + 2)) && j.f(this.f41514a.charAt(i11 + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        public byte[] q() {
            int[] iArr = a.f41509a;
            switch (iArr[t().ordinal()]) {
                case 1:
                case 2:
                    int i11 = iArr[this.f41515b.ordinal()];
                    if (i11 == 2) {
                        return h(231);
                    }
                    if (i11 == 3) {
                        return h(230);
                    }
                    if (i11 == 4) {
                        return h(239);
                    }
                    if (i11 == 5) {
                        return h(238);
                    }
                    if (i11 == 6) {
                        return h(240);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    if (this.f41515b != t()) {
                        switch (iArr[this.f41515b.ordinal()]) {
                            case 1:
                                return h(254);
                            case 2:
                                return i(254, 231);
                            case 3:
                                return i(254, 230);
                            case 4:
                                return i(254, 239);
                            case 5:
                                return i(254, 238);
                            case 6:
                                return i(254, 240);
                        }
                    }
                    break;
            }
            return new byte[0];
        }

        public int r(int i11) {
            int i12 = a.f41510b[this.f41514a.l().ordinal()];
            if (i12 == 1) {
                for (int i13 : f41512h) {
                    if (i13 >= i11) {
                        return i13;
                    }
                }
            } else if (i12 == 2) {
                for (int i14 : f41513i) {
                    if (i14 >= i11) {
                        return i14;
                    }
                }
            }
            for (int i15 : f41511g) {
                if (i15 >= i11) {
                    return i15;
                }
            }
            int[] iArr = f41511g;
            return iArr[iArr.length - 1];
        }

        public Mode s() {
            return this.f41515b;
        }

        public Mode t() {
            b bVar = this.f41518e;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        public Mode u() {
            b bVar = this.f41518e;
            return bVar == null ? Mode.ASCII : bVar.f41515b;
        }

        public byte[] x() {
            int i11 = (this.f41517d / 3) * 2;
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12 += 2) {
                int i13 = (i12 / 2) * 3;
                y(bArr, i12, w(this.f41514a.charAt(this.f41516c + i13)), w(this.f41514a.charAt(this.f41516c + i13 + 1)), w(this.f41514a.charAt(this.f41516c + i13 + 2)));
            }
            return bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c extends m {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SymbolShapeHint f41520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41521d;

        public c(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12) {
            super(str, charset, i11);
            this.f41520c = symbolShapeHint;
            this.f41521d = i12;
        }

        public /* synthetic */ c(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12, a aVar) {
            this(str, charset, i11, symbolShapeHint, i12);
        }

        public final int k() {
            return this.f41521d;
        }

        public final SymbolShapeHint l() {
            return this.f41520c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f41522a;

        public d(b bVar) {
            int i11;
            c cVar = bVar.f41514a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i12 = 0;
            int iC = ((bVar.f41515b == Mode.C40 || bVar.f41515b == Mode.TEXT || bVar.f41515b == Mode.X12) && bVar.o() != Mode.ASCII) ? c(b.h(254), arrayList) : 0;
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f41518e) {
                iC += c(bVar2.m(), arrayList);
                if (bVar2.f41518e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (iC <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) iC));
                            i11 = iC + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (iC % 250)));
                            arrayList.add(0, Byte.valueOf((byte) ((iC / 250) + 249)));
                            i11 = iC + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i11));
                    }
                    c(bVar2.q(), arrayList);
                    iC = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.f() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i13)).intValue(), ((Integer) arrayList3.get(i13)).intValue());
            }
            int iR = bVar.r(arrayList.size());
            if (arrayList.size() < iR) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < iR) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f41522a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f41522a;
                if (i12 >= bArr.length) {
                    return;
                }
                bArr[i12] = ((Byte) arrayList.get(i12)).byteValue();
                i12++;
            }
        }

        public static void a(List<Byte> list, int i11, int i12) {
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i11 + i13;
                int iByteValue = (list.get(i14).byteValue() & 255) + (((i14 + 1) * 149) % 255) + 1;
                if (iByteValue > 255) {
                    iByteValue += InputDeviceCompat.SOURCE_ANY;
                }
                list.set(i14, Byte.valueOf((byte) iByteValue));
            }
        }

        public static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        public static int d(int i11) {
            int i12 = (i11 * 149) % 253;
            int i13 = i12 + TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            return i13 <= 254 ? i13 : i12 - 124;
        }

        public byte[] b() {
            return this.f41522a;
        }
    }

    public static void e(b[][] bVarArr, b bVar) {
        int i11 = bVar.f41516c + bVar.f41517d;
        if (bVarArr[i11][bVar.o().ordinal()] == null || bVarArr[i11][bVar.o().ordinal()].f41519f > bVar.f41519f) {
            bVarArr[i11][bVar.o().ordinal()] = bVar;
        }
    }

    public static void f(c cVar, b[][] bVarArr, int i11, b bVar) {
        if (cVar.a(i11)) {
            e(bVarArr, new b(cVar, Mode.ASCII, i11, 1, bVar, null));
            return;
        }
        char cCharAt = cVar.charAt(i11);
        char c11 = 0;
        if (bVar == null || bVar.o() != Mode.EDF) {
            if (j.f(cCharAt) && cVar.g(i11, 2) && j.f(cVar.charAt(i11 + 1))) {
                e(bVarArr, new b(cVar, Mode.ASCII, i11, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, Mode.ASCII, i11, 1, bVar, null));
            }
            Mode[] modeArr = {Mode.C40, Mode.TEXT};
            int i12 = 0;
            while (i12 < 2) {
                Mode mode = modeArr[i12];
                int[] iArr = new int[1];
                if (j(cVar, i11, mode == Mode.C40, iArr) > 0) {
                    e(bVarArr, new b(cVar, mode, i11, iArr[c11], bVar, null));
                }
                i12++;
                c11 = 0;
            }
            if (cVar.g(i11, 3) && j.k(cVar.charAt(i11)) && j.k(cVar.charAt(i11 + 1)) && j.k(cVar.charAt(i11 + 2))) {
                e(bVarArr, new b(cVar, Mode.X12, i11, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, Mode.B256, i11, 1, bVar, null));
        }
        int i13 = 0;
        while (i13 < 3) {
            int i14 = i11 + i13;
            if (!cVar.g(i14, 1) || !j.i(cVar.charAt(i14))) {
                break;
            }
            i13++;
            e(bVarArr, new b(cVar, Mode.EDF, i11, i13, bVar, null));
        }
        if (i13 == 3 && cVar.g(i11, 4) && j.i(cVar.charAt(i11 + 3))) {
            e(bVarArr, new b(cVar, Mode.EDF, i11, 4, bVar, null));
        }
    }

    public static byte[] g(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12) {
        return i(new c(str, charset, i11, symbolShapeHint, i12, null)).b();
    }

    public static String h(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint) {
        int i12;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i12 = 5;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i12 = 6;
        } else {
            i12 = 0;
        }
        return new String(g(str, charset, i11, symbolShapeHint, i12), StandardCharsets.ISO_8859_1);
    }

    public static d i(c cVar) {
        int length = cVar.length();
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        int i11 = 0;
        f(cVar, bVarArr, 0, null);
        for (int i12 = 1; i12 <= length; i12++) {
            for (int i13 = 0; i13 < 6; i13++) {
                b bVar = bVarArr[i12][i13];
                if (bVar != null && i12 < length) {
                    f(cVar, bVarArr, i12, bVar);
                }
            }
            for (int i14 = 0; i14 < 6; i14++) {
                bVarArr[i12 - 1][i14] = null;
            }
        }
        int i15 = -1;
        int i16 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        while (i11 < 6) {
            b bVar2 = bVarArr[length][i11];
            if (bVar2 != null) {
                int i17 = (i11 < 1 || i11 > 3) ? bVar2.f41519f : bVar2.f41519f + 1;
                if (i17 < i16) {
                    i15 = i11;
                    i16 = i17;
                }
            }
            i11++;
        }
        if (i15 >= 0) {
            return new d(bVarArr[length][i15]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    public static int j(c cVar, int i11, boolean z11, int[] iArr) {
        int i12 = 0;
        for (int i13 = i11; i13 < cVar.length(); i13++) {
            if (cVar.a(i13)) {
                iArr[0] = 0;
                return 0;
            }
            char cCharAt = cVar.charAt(i13);
            if ((z11 && j.h(cCharAt)) || (!z11 && j.j(cCharAt))) {
                i12++;
            } else if (k(cCharAt, cVar.f())) {
                int i14 = cCharAt & 255;
                i12 = (i14 < 128 || (!(z11 && j.h((char) (i14 + (-128)))) && (z11 || !j.j((char) (i14 + (-128)))))) ? i12 + 4 : i12 + 3;
            } else {
                i12 += 2;
            }
            if (i12 % 3 == 0 || ((i12 - 2) % 3 == 0 && i13 + 1 == cVar.length())) {
                iArr[0] = (i13 - i11) + 1;
                return (int) Math.ceil(((double) i12) / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    public static boolean k(char c11, int i11) {
        return c11 != i11 && c11 >= 128 && c11 <= 255;
    }

    public static boolean l(char c11) {
        return c11 <= 31;
    }

    public static boolean m(char c11, int i11) {
        for (char c12 : f41508a) {
            if (c12 == c11) {
                return true;
            }
        }
        return c11 == i11;
    }

    public static boolean n(char c11) {
        return l(c11);
    }

    public static boolean o(char c11, int i11) {
        return m(c11, i11);
    }
}

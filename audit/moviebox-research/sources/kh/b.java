package kh;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.android.exoplayer2.util.b0;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import gh.d;
import gh.f;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f68568b = new a() { // from class: kh.a
        @Override // kh.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            return b.z(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f68569a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean evaluate(int i11, int i12, int i13, int i14, int i15);
    }

    /* JADX INFO: renamed from: kh.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0739b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f68570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f68571b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f68572c;

        public C0739b(int i11, boolean z11, int i12) {
            this.f68570a = i11;
            this.f68571b = z11;
            this.f68572c = i12;
        }
    }

    public b() {
        this(null);
    }

    public b(@Nullable a aVar) {
        this.f68569a = aVar;
    }

    public static int A(c0 c0Var, int i11) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int i12 = iE;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iE + i11) {
                return i11;
            }
            if ((bArrD[i12] & 255) == 255 && bArrD[i13] == 0) {
                System.arraycopy(bArrD, i12 + 2, bArrD, i13, (i11 - (i12 - iE)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    public static boolean B(c0 c0Var, int i11, int i12, boolean z11) {
        int iG;
        long jG;
        int iJ;
        int i13;
        int iE = c0Var.e();
        while (true) {
            try {
                boolean z12 = true;
                if (c0Var.a() < i12) {
                    c0Var.P(iE);
                    return true;
                }
                if (i11 >= 3) {
                    iG = c0Var.n();
                    jG = c0Var.F();
                    iJ = c0Var.J();
                } else {
                    iG = c0Var.G();
                    jG = c0Var.G();
                    iJ = 0;
                }
                if (iG == 0 && jG == 0 && iJ == 0) {
                    c0Var.P(iE);
                    return true;
                }
                if (i11 == 4 && !z11) {
                    if ((8421504 & jG) != 0) {
                        c0Var.P(iE);
                        return false;
                    }
                    jG = (((jG >> 24) & 255) << 21) | (jG & 255) | (((jG >> 8) & 255) << 7) | (((jG >> 16) & 255) << 14);
                }
                if (i11 == 4) {
                    i13 = (iJ & 64) != 0 ? 1 : 0;
                    if ((iJ & 1) == 0) {
                        z12 = false;
                    }
                } else {
                    if (i11 == 3) {
                        i13 = (iJ & 32) != 0 ? 1 : 0;
                        if ((iJ & 128) == 0) {
                        }
                    } else {
                        i13 = 0;
                    }
                    z12 = false;
                }
                if (z12) {
                    i13 += 4;
                }
                if (jG < i13) {
                    c0Var.P(iE);
                    return false;
                }
                if (c0Var.a() < jG) {
                    c0Var.P(iE);
                    return false;
                }
                c0Var.Q((int) jG);
            } catch (Throwable th2) {
                c0Var.P(iE);
                throw th2;
            }
        }
    }

    public static byte[] d(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? o0.f35613f : Arrays.copyOfRange(bArr, i11, i12);
    }

    public static ApicFrame f(c0 c0Var, int i11, int i12) throws UnsupportedEncodingException {
        int iY;
        String strE;
        int iD = c0Var.D();
        String strV = v(iD);
        int i13 = i11 - 1;
        byte[] bArr = new byte[i13];
        c0Var.j(bArr, 0, i13);
        if (i12 == 2) {
            strE = "image/" + com.google.common.base.a.e(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(strE)) {
                strE = "image/jpeg";
            }
            iY = 2;
        } else {
            iY = y(bArr, 0);
            strE = com.google.common.base.a.e(new String(bArr, 0, iY, "ISO-8859-1"));
            if (strE.indexOf(47) == -1) {
                strE = "image/" + strE;
            }
        }
        int i14 = bArr[iY + 1] & 255;
        int i15 = iY + 2;
        int iX = x(bArr, i15, iD);
        return new ApicFrame(strE, new String(bArr, i15, iX - i15, strV), i14, d(bArr, iX + u(iD), i13));
    }

    public static BinaryFrame g(c0 c0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame h(c0 c0Var, int i11, int i12, boolean z11, int i13, @Nullable a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.P(iY + 1);
        int iN = c0Var.n();
        int iN2 = c0Var.n();
        long jF = c0Var.F();
        long j11 = jF == 4294967295L ? -1L : jF;
        long jF2 = c0Var.F();
        long j12 = jF2 == 4294967295L ? -1L : jF2;
        ArrayList arrayList = new ArrayList();
        int i14 = iE + i11;
        while (c0Var.e() < i14) {
            Id3Frame id3FrameK = k(i12, c0Var, z11, i13, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iN, iN2, j11, j12, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame i(c0 c0Var, int i11, int i12, boolean z11, int i13, @Nullable a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.P(iY + 1);
        int iD = c0Var.D();
        boolean z12 = (iD & 2) != 0;
        boolean z13 = (iD & 1) != 0;
        int iD2 = c0Var.D();
        String[] strArr = new String[iD2];
        for (int i14 = 0; i14 < iD2; i14++) {
            int iE2 = c0Var.e();
            int iY2 = y(c0Var.d(), iE2);
            strArr[i14] = new String(c0Var.d(), iE2, iY2 - iE2, "ISO-8859-1");
            c0Var.P(iY2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = iE + i11;
        while (c0Var.e() < i15) {
            Id3Frame id3FrameK = k(i12, c0Var, z11, i13, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z12, z13, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame j(c0 c0Var, int i11) throws UnsupportedEncodingException {
        if (i11 < 4) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        byte[] bArr = new byte[3];
        c0Var.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        c0Var.j(bArr2, 0, i12);
        int iX = x(bArr2, 0, iD);
        String str2 = new String(bArr2, 0, iX, strV);
        int iU = iX + u(iD);
        return new CommentFrame(str, str2, p(bArr2, iU, x(bArr2, iU, iD), strV));
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0198  */
    /* JADX WARN: Code duplicated, block: B:140:0x01a9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:141:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:146:0x01c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:147:0x01c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:151:0x01db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:152:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ea A[Catch: all -> 0x0122, UnsupportedEncodingException -> 0x0218, Merged into TryCatch #0 {all -> 0x0122, UnsupportedEncodingException -> 0x0218, blocks: (B:91:0x011c, B:159:0x01f4, B:162:0x0218, B:95:0x0127, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112 }] */
    @Nullable
    public static Id3Frame k(int i11, c0 c0Var, boolean z11, int i12, @Nullable a aVar) {
        int iH;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Id3Frame id3FrameG;
        int iD = c0Var.D();
        int iD2 = c0Var.D();
        int iD3 = c0Var.D();
        int iD4 = i11 >= 3 ? c0Var.D() : 0;
        if (i11 == 4) {
            iH = c0Var.H();
            if (!z11) {
                iH = (((iH >> 24) & 255) << 21) | (iH & 255) | (((iH >> 8) & 255) << 7) | (((iH >> 16) & 255) << 14);
            }
        } else {
            iH = i11 == 3 ? c0Var.H() : c0Var.G();
        }
        int iA = iH;
        int iJ = i11 >= 3 ? c0Var.J() : 0;
        if (iD == 0 && iD2 == 0 && iD3 == 0 && iD4 == 0 && iA == 0 && iJ == 0) {
            c0Var.P(c0Var.f());
            return null;
        }
        int iE = c0Var.e() + iA;
        if (iE > c0Var.f()) {
            s.i("Id3Decoder", "Frame size exceeds remaining tag data");
            c0Var.P(c0Var.f());
            return null;
        }
        if (aVar != null) {
            i13 = iE;
            if (!aVar.evaluate(i11, iD, iD2, iD3, iD4)) {
                c0Var.P(i13);
                return null;
            }
        } else {
            i13 = iE;
        }
        if (i11 == 3) {
            int i14 = iJ;
            z13 = (i14 & 128) != 0;
            z14 = (i14 & 64) != 0;
            z12 = (i14 & 32) != 0;
            z16 = z13;
            z15 = false;
        } else {
            int i15 = iJ;
            if (i11 == 4) {
                boolean z17 = (i15 & 64) != 0;
                boolean z18 = (i15 & 8) != 0;
                boolean z19 = (i15 & 4) != 0;
                z15 = (i15 & 2) != 0;
                boolean z21 = (i15 & 1) != 0;
                z12 = z17;
                z13 = z21;
                z16 = z18;
                z14 = z19;
            } else {
                z12 = false;
                z13 = false;
                z14 = false;
                z15 = false;
                z16 = false;
            }
        }
        if (z16 || z14) {
            s.i(r4, "Skipping unsupported compressed or encrypted frame");
            c0Var.P(i13);
            return null;
        }
        if (z12) {
            iA--;
            c0Var.Q(1);
        }
        if (z13) {
            iA -= 4;
            c0Var.Q(4);
        }
        if (z15) {
            iA = A(c0Var, iA);
        }
        try {
            if (iD == 84 && iD2 == 88 && iD3 == 88 && (i11 == 2 || iD4 == 88)) {
                id3FrameG = r(c0Var, iA);
            } else if (iD == 84) {
                id3FrameG = q(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
            } else if (iD == 87 && iD2 == 88 && iD3 == 88 && (i11 == 2 || iD4 == 88)) {
                id3FrameG = t(c0Var, iA);
            } else if (iD == 87) {
                id3FrameG = s(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
            } else if (iD == 80 && iD2 == 82 && iD3 == 73 && iD4 == 86) {
                id3FrameG = o(c0Var, iA);
            } else if (iD == 71 && iD2 == 69 && iD3 == 79 && (iD4 == 66 || i11 == 2)) {
                id3FrameG = l(c0Var, iA);
            } else if (i11 == 2) {
                if (iD == 80 && iD2 == 73 && iD3 == 67) {
                    id3FrameG = f(c0Var, iA, i11);
                } else if (iD != 67 && iD2 == 79 && iD3 == 77 && (iD4 == 77 || i11 == 2)) {
                    id3FrameG = j(c0Var, iA);
                } else if (iD != 67 && iD2 == 72 && iD3 == 65 && iD4 == 80) {
                    id3FrameG = h(c0Var, iA, i11, z11, i12, aVar);
                } else if (iD != 67 && iD2 == 84 && iD3 == 79 && iD4 == 67) {
                    id3FrameG = i(c0Var, iA, i11, z11, i12, aVar);
                } else if (iD != 77 && iD2 == 76 && iD3 == 76 && iD4 == 84) {
                    id3FrameG = n(c0Var, iA);
                } else {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                }
            } else if (iD == 65 && iD2 == 80 && iD3 == 73 && iD4 == 67) {
                id3FrameG = f(c0Var, iA, i11);
            } else if (iD != 67) {
                if (iD != 67) {
                    if (iD != 67) {
                        if (iD != 77) {
                            id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                        } else {
                            id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                        }
                    } else if (iD != 77) {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    } else {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    }
                } else if (iD != 67) {
                    if (iD != 77) {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    } else {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    }
                } else if (iD != 77) {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                } else {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                }
            } else if (iD != 67) {
                if (iD != 67) {
                    if (iD != 77) {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    } else {
                        id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                    }
                } else if (iD != 77) {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                } else {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                }
            } else if (iD != 67) {
                if (iD != 77) {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                } else {
                    id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
                }
            } else if (iD != 77) {
                id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
            } else {
                id3FrameG = g(c0Var, iA, w(i11, iD, iD2, iD3, iD4));
            }
            if (id3FrameG == null) {
                s.i("Id3Decoder", "Failed to decode frame: id=" + w(i11, iD, iD2, iD3, iD4) + ", frameSize=" + iA);
            }
            c0Var.P(i13);
            return id3FrameG;
        } catch (UnsupportedEncodingException unused) {
            s.i(r4, "Unsupported character encoding");
            return null;
        } finally {
            c0Var.P(i13);
        }
    }

    public static GeobFrame l(c0 c0Var, int i11) throws UnsupportedEncodingException {
        int iD = c0Var.D();
        String strV = v(iD);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.j(bArr, 0, i12);
        int iY = y(bArr, 0);
        String str = new String(bArr, 0, iY, "ISO-8859-1");
        int i13 = iY + 1;
        int iX = x(bArr, i13, iD);
        String strP = p(bArr, i13, iX, strV);
        int iU = iX + u(iD);
        int iX2 = x(bArr, iU, iD);
        return new GeobFrame(str, strP, p(bArr, iU, iX2, strV), d(bArr, iX2 + u(iD), i12));
    }

    @Nullable
    public static C0739b m(c0 c0Var) {
        if (c0Var.a() < 10) {
            s.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iG = c0Var.G();
        boolean z11 = false;
        if (iG != 4801587) {
            s.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iG)));
            return null;
        }
        int iD = c0Var.D();
        c0Var.Q(1);
        int iD2 = c0Var.D();
        int iC = c0Var.C();
        if (iD == 2) {
            if ((iD2 & 64) != 0) {
                s.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iD == 3) {
            if ((iD2 & 64) != 0) {
                int iN = c0Var.n();
                c0Var.Q(iN);
                iC -= iN + 4;
            }
        } else {
            if (iD != 4) {
                s.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iD);
                return null;
            }
            if ((iD2 & 64) != 0) {
                int iC2 = c0Var.C();
                c0Var.Q(iC2 - 4);
                iC -= iC2;
            }
            if ((iD2 & 16) != 0) {
                iC -= 10;
            }
        }
        if (iD < 4 && (iD2 & 128) != 0) {
            z11 = true;
        }
        return new C0739b(iD, z11, iC);
    }

    public static MlltFrame n(c0 c0Var, int i11) {
        int iJ = c0Var.J();
        int iG = c0Var.G();
        int iG2 = c0Var.G();
        int iD = c0Var.D();
        int iD2 = c0Var.D();
        b0 b0Var = new b0();
        b0Var.m(c0Var);
        int i12 = ((i11 - 10) * 8) / (iD + iD2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int iH = b0Var.h(iD);
            int iH2 = b0Var.h(iD2);
            iArr[i13] = iH;
            iArr2[i13] = iH2;
        }
        return new MlltFrame(iJ, iG, iG2, iArr, iArr2);
    }

    public static PrivFrame o(c0 c0Var, int i11) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        int iY = y(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iY, "ISO-8859-1"), d(bArr, iY + 1, i11));
    }

    public static String p(byte[] bArr, int i11, int i12, String str) throws UnsupportedEncodingException {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, str);
    }

    @Nullable
    public static TextInformationFrame q(c0 c0Var, int i11, String str) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.j(bArr, 0, i12);
        return new TextInformationFrame(str, null, new String(bArr, 0, x(bArr, 0, iD), strV));
    }

    @Nullable
    public static TextInformationFrame r(c0 c0Var, int i11) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.j(bArr, 0, i12);
        int iX = x(bArr, 0, iD);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iD);
        return new TextInformationFrame("TXXX", str, p(bArr, iU, x(bArr, iU, iD), strV));
    }

    public static UrlLinkFrame s(c0 c0Var, int i11, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        return new UrlLinkFrame(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    public static UrlLinkFrame t(c0 c0Var, int i11) throws UnsupportedEncodingException {
        if (i11 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.j(bArr, 0, i12);
        int iX = x(bArr, 0, iD);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iD);
        return new UrlLinkFrame("WXXX", str, p(bArr, iU, y(bArr, iU), "ISO-8859-1"));
    }

    public static int u(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    public static String v(int i11) {
        if (i11 == 1) {
            return C.UTF16_NAME;
        }
        if (i11 != 2) {
            return i11 != 3 ? "ISO-8859-1" : "UTF-8";
        }
        return "UTF-16BE";
    }

    public static String w(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    public static int x(byte[] bArr, int i11, int i12) {
        int iY = y(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return iY;
        }
        while (iY < bArr.length - 1) {
            if ((iY - i11) % 2 == 0 && bArr[iY + 1] == 0) {
                return iY;
            }
            iY = y(bArr, iY + 1);
        }
        return bArr.length;
    }

    public static int y(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    public static /* synthetic */ boolean z(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    @Override // gh.f
    @Nullable
    public Metadata b(d dVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata e(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        c0 c0Var = new c0(bArr, i11);
        C0739b c0739bM = m(c0Var);
        if (c0739bM == null) {
            return null;
        }
        int iE = c0Var.e();
        int i12 = c0739bM.f68570a == 2 ? 6 : 10;
        int iA = c0739bM.f68572c;
        if (c0739bM.f68571b) {
            iA = A(c0Var, c0739bM.f68572c);
        }
        c0Var.O(iE + iA);
        boolean z11 = false;
        if (!B(c0Var, c0739bM.f68570a, i12, false)) {
            if (c0739bM.f68570a != 4 || !B(c0Var, 4, i12, true)) {
                s.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + c0739bM.f68570a);
                return null;
            }
            z11 = true;
        }
        while (c0Var.a() >= i12) {
            Id3Frame id3FrameK = k(c0739bM.f68570a, c0Var, z11, i12, this.f68569a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }
}

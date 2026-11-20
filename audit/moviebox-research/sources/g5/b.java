package g5;

import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.f0;
import androidx.media3.extractor.metadata.id3.ApicFrame;
import androidx.media3.extractor.metadata.id3.BinaryFrame;
import androidx.media3.extractor.metadata.id3.ChapterFrame;
import androidx.media3.extractor.metadata.id3.ChapterTocFrame;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.GeobFrame;
import androidx.media3.extractor.metadata.id3.Id3Frame;
import androidx.media3.extractor.metadata.id3.MlltFrame;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import androidx.media3.extractor.metadata.id3.TextInformationFrame;
import androidx.media3.extractor.metadata.id3.UrlLinkFrame;
import c5.c;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import z3.b0;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f65404b = new a() { // from class: g5.a
        @Override // g5.b.a
        public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
            return b.A(i11, i12, i13, i14, i15);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f65405a;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        boolean evaluate(int i11, int i12, int i13, int i14, int i15);
    }

    /* JADX INFO: renamed from: g5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0681b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f65407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f65408c;

        public C0681b(int i11, boolean z11, int i12) {
            this.f65406a = i11;
            this.f65407b = z11;
            this.f65408c = i12;
        }
    }

    public b() {
        this(null);
    }

    public b(@Nullable a aVar) {
        this.f65405a = aVar;
    }

    public static /* synthetic */ boolean A(int i11, int i12, int i13, int i14, int i15) {
        return false;
    }

    public static int B(c0 c0Var, int i11) {
        byte[] bArrE = c0Var.e();
        int iF = c0Var.f();
        int i12 = iF;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= iF + i11) {
                return i11;
            }
            if ((bArrE[i12] & 255) == 255 && bArrE[i13] == 0) {
                System.arraycopy(bArrE, i12 + 2, bArrE, i13, (i11 - (i12 - iF)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    public static boolean C(c0 c0Var, int i11, int i12, boolean z11) {
        int iK;
        long jK;
        int iN;
        int i13;
        int iF = c0Var.f();
        while (true) {
            try {
                boolean z12 = true;
                if (c0Var.a() < i12) {
                    c0Var.U(iF);
                    return true;
                }
                if (i11 >= 3) {
                    iK = c0Var.q();
                    jK = c0Var.J();
                    iN = c0Var.N();
                } else {
                    iK = c0Var.K();
                    jK = c0Var.K();
                    iN = 0;
                }
                if (iK == 0 && jK == 0 && iN == 0) {
                    c0Var.U(iF);
                    return true;
                }
                if (i11 == 4 && !z11) {
                    if ((8421504 & jK) != 0) {
                        c0Var.U(iF);
                        return false;
                    }
                    jK = (((jK >> 24) & 255) << 21) | (jK & 255) | (((jK >> 8) & 255) << 7) | (((jK >> 16) & 255) << 14);
                }
                if (i11 == 4) {
                    i13 = (iN & 64) != 0 ? 1 : 0;
                    if ((iN & 1) == 0) {
                        z12 = false;
                    }
                } else {
                    if (i11 == 3) {
                        i13 = (iN & 32) != 0 ? 1 : 0;
                        if ((iN & 128) == 0) {
                        }
                    } else {
                        i13 = 0;
                    }
                    z12 = false;
                }
                if (z12) {
                    i13 += 4;
                }
                if (jK < i13) {
                    c0Var.U(iF);
                    return false;
                }
                if (c0Var.a() < jK) {
                    c0Var.U(iF);
                    return false;
                }
                c0Var.V((int) jK);
            } catch (Throwable th2) {
                c0Var.U(iF);
                throw th2;
            }
        }
    }

    public static byte[] d(byte[] bArr, int i11, int i12) {
        return i12 <= i11 ? u0.f81843f : Arrays.copyOfRange(bArr, i11, i12);
    }

    public static ApicFrame f(c0 c0Var, int i11, int i12) {
        int iZ;
        String str;
        int iH = c0Var.H();
        Charset charsetW = w(iH);
        int i13 = i11 - 1;
        byte[] bArr = new byte[i13];
        c0Var.l(bArr, 0, i13);
        if (i12 == 2) {
            str = "image/" + com.google.common.base.a.e(new String(bArr, 0, 3, com.google.common.base.c.f38164b));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            iZ = 2;
        } else {
            iZ = z(bArr, 0);
            String strE = com.google.common.base.a.e(new String(bArr, 0, iZ, com.google.common.base.c.f38164b));
            if (strE.indexOf(47) == -1) {
                str = "image/" + strE;
            } else {
                str = strE;
            }
        }
        int i14 = bArr[iZ + 1] & 255;
        int i15 = iZ + 2;
        int iY = y(bArr, i15, iH);
        return new ApicFrame(str, new String(bArr, i15, iY - i15, charsetW), i14, d(bArr, iY + v(iH), i13));
    }

    public static BinaryFrame g(c0 c0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        c0Var.l(bArr, 0, i11);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame h(c0 c0Var, int i11, int i12, boolean z11, int i13, @Nullable a aVar) {
        int iF = c0Var.f();
        int iZ = z(c0Var.e(), iF);
        String str = new String(c0Var.e(), iF, iZ - iF, com.google.common.base.c.f38164b);
        c0Var.U(iZ + 1);
        int iQ = c0Var.q();
        int iQ2 = c0Var.q();
        long J = c0Var.J();
        long j11 = J == 4294967295L ? -1L : J;
        long J2 = c0Var.J();
        long j12 = J2 == 4294967295L ? -1L : J2;
        ArrayList arrayList = new ArrayList();
        int i14 = iF + i11;
        while (c0Var.f() < i14) {
            Id3Frame id3FrameK = k(i12, c0Var, z11, i13, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iQ, iQ2, j11, j12, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame i(c0 c0Var, int i11, int i12, boolean z11, int i13, @Nullable a aVar) {
        int iF = c0Var.f();
        int iZ = z(c0Var.e(), iF);
        String str = new String(c0Var.e(), iF, iZ - iF, com.google.common.base.c.f38164b);
        c0Var.U(iZ + 1);
        int iH = c0Var.H();
        boolean z12 = (iH & 2) != 0;
        boolean z13 = (iH & 1) != 0;
        int iH2 = c0Var.H();
        String[] strArr = new String[iH2];
        for (int i14 = 0; i14 < iH2; i14++) {
            int iF2 = c0Var.f();
            int iZ2 = z(c0Var.e(), iF2);
            strArr[i14] = new String(c0Var.e(), iF2, iZ2 - iF2, com.google.common.base.c.f38164b);
            c0Var.U(iZ2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i15 = iF + i11;
        while (c0Var.f() < i15) {
            Id3Frame id3FrameK = k(i12, c0Var, z11, i13, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z12, z13, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame j(c0 c0Var, int i11) {
        if (i11 < 4) {
            return null;
        }
        int iH = c0Var.H();
        Charset charsetW = w(iH);
        byte[] bArr = new byte[3];
        c0Var.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i12 = i11 - 4;
        byte[] bArr2 = new byte[i12];
        c0Var.l(bArr2, 0, i12);
        int iY = y(bArr2, 0, iH);
        String str2 = new String(bArr2, 0, iY, charsetW);
        int iV = iY + v(iH);
        return new CommentFrame(str, str2, p(bArr2, iV, y(bArr2, iV, iH), charsetW));
    }

    /* JADX WARN: Code duplicated, block: B:137:0x019b  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:145:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:150:0x01c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:151:0x01c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:155:0x01de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:156:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:161:0x01ed A[Catch: all -> 0x011f, Exception -> 0x0122, OutOfMemoryError -> 0x0125, TRY_LEAVE, TryCatch #2 {Exception -> 0x0122, OutOfMemoryError -> 0x0125, all -> 0x011f, blocks: (B:91:0x0119, B:99:0x012a, B:106:0x0140, B:108:0x0148, B:116:0x0162, B:125:0x017a, B:136:0x0195, B:143:0x01a7, B:149:0x01b6, B:154:0x01ce, B:160:0x01e8, B:161:0x01ed), top: B:171:0x010f }] */
    @Nullable
    public static Id3Frame k(int i11, c0 c0Var, boolean z11, int i12, @Nullable a aVar) {
        int iL;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        Id3Frame id3FrameG;
        int iH = c0Var.H();
        int iH2 = c0Var.H();
        int iH3 = c0Var.H();
        int iH4 = i11 >= 3 ? c0Var.H() : 0;
        if (i11 == 4) {
            iL = c0Var.L();
            if (!z11) {
                iL = (((iL >> 24) & 255) << 21) | (iL & 255) | (((iL >> 8) & 255) << 7) | (((iL >> 16) & 255) << 14);
            }
        } else {
            iL = i11 == 3 ? c0Var.L() : c0Var.K();
        }
        int iB = iL;
        int iN = i11 >= 3 ? c0Var.N() : 0;
        Id3Frame id3Frame = null;
        if (iH == 0 && iH2 == 0 && iH3 == 0 && iH4 == 0 && iB == 0 && iN == 0) {
            c0Var.U(c0Var.g());
            return null;
        }
        int iF = c0Var.f() + iB;
        if (iF > c0Var.g()) {
            o.h("Id3Decoder", "Frame size exceeds remaining tag data");
            c0Var.U(c0Var.g());
            return null;
        }
        if (aVar != null) {
            i13 = iF;
            if (!aVar.evaluate(i11, iH, iH2, iH3, iH4)) {
                c0Var.U(i13);
                return null;
            }
        } else {
            i13 = iF;
        }
        if (i11 == 3) {
            boolean z17 = (iN & 128) != 0;
            z14 = (iN & 64) != 0;
            z16 = z17;
            z15 = false;
            z13 = (iN & 32) != 0;
            z12 = z16;
        } else if (i11 == 4) {
            z13 = (iN & 64) != 0;
            boolean z18 = (iN & 8) != 0;
            boolean z19 = (iN & 4) != 0;
            z15 = (iN & 2) != 0;
            z16 = (iN & 1) != 0;
            z12 = z18;
            z14 = z19;
        } else {
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
            z16 = false;
        }
        if (z12 || z14) {
            o.h("Id3Decoder", "Skipping unsupported compressed or encrypted frame");
            c0Var.U(i13);
            return null;
        }
        if (z13) {
            iB--;
            c0Var.V(1);
        }
        if (z16) {
            iB -= 4;
            c0Var.V(4);
        }
        if (z15) {
            iB = B(c0Var, iB);
        }
        try {
            if (iH == 84 && iH2 == 88 && iH3 == 88 && (i11 == 2 || iH4 == 88)) {
                id3FrameG = s(c0Var, iB);
            } else if (iH == 84) {
                id3FrameG = q(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
            } else if (iH == 87 && iH2 == 88 && iH3 == 88 && (i11 == 2 || iH4 == 88)) {
                id3FrameG = u(c0Var, iB);
            } else if (iH == 87) {
                id3FrameG = t(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
            } else if (iH == 80 && iH2 == 82 && iH3 == 73 && iH4 == 86) {
                id3FrameG = o(c0Var, iB);
            } else if (iH == 71 && iH2 == 69 && iH3 == 79 && (iH4 == 66 || i11 == 2)) {
                id3FrameG = l(c0Var, iB);
            } else if (i11 == 2) {
                if (iH == 80 && iH2 == 73 && iH3 == 67) {
                    id3FrameG = f(c0Var, iB, i11);
                } else if (iH != 67 && iH2 == 79 && iH3 == 77 && (iH4 == 77 || i11 == 2)) {
                    id3FrameG = j(c0Var, iB);
                } else if (iH != 67 && iH2 == 72 && iH3 == 65 && iH4 == 80) {
                    id3FrameG = h(c0Var, iB, i11, z11, i12, aVar);
                } else if (iH != 67 && iH2 == 84 && iH3 == 79 && iH4 == 67) {
                    id3FrameG = i(c0Var, iB, i11, z11, i12, aVar);
                } else if (iH != 77 && iH2 == 76 && iH3 == 76 && iH4 == 84) {
                    id3FrameG = n(c0Var, iB);
                } else {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                }
            } else if (iH == 65 && iH2 == 80 && iH3 == 73 && iH4 == 67) {
                id3FrameG = f(c0Var, iB, i11);
            } else if (iH != 67) {
                if (iH != 67) {
                    if (iH != 67) {
                        if (iH != 77) {
                            id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                        } else {
                            id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                        }
                    } else if (iH != 77) {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    } else {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    }
                } else if (iH != 67) {
                    if (iH != 77) {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    } else {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    }
                } else if (iH != 77) {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                } else {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                }
            } else if (iH != 67) {
                if (iH != 67) {
                    if (iH != 77) {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    } else {
                        id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                    }
                } else if (iH != 77) {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                } else {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                }
            } else if (iH != 67) {
                if (iH != 77) {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                } else {
                    id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
                }
            } else if (iH != 77) {
                id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
            } else {
                id3FrameG = g(c0Var, iB, x(i11, iH, iH2, iH3, iH4));
            }
            c0Var.U(i13);
            id3Frame = id3FrameG;
            e = null;
        } catch (Exception e11) {
            e = e11;
        } catch (OutOfMemoryError e12) {
            e = e12;
        } finally {
            c0Var.U(i13);
        }
        if (id3Frame == null) {
            o.i("Id3Decoder", "Failed to decode frame: id=" + x(i11, iH, iH2, iH3, iH4) + ", frameSize=" + iB, e);
        }
        return id3Frame;
    }

    public static GeobFrame l(c0 c0Var, int i11) {
        int iH = c0Var.H();
        Charset charsetW = w(iH);
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.l(bArr, 0, i12);
        int iZ = z(bArr, 0);
        String strT = f0.t(new String(bArr, 0, iZ, com.google.common.base.c.f38164b));
        int i13 = iZ + 1;
        int iY = y(bArr, i13, iH);
        String strP = p(bArr, i13, iY, charsetW);
        int iV = iY + v(iH);
        int iY2 = y(bArr, iV, iH);
        return new GeobFrame(strT, strP, p(bArr, iV, iY2, charsetW), d(bArr, iY2 + v(iH), i12));
    }

    @Nullable
    public static C0681b m(c0 c0Var) {
        if (c0Var.a() < 10) {
            o.h("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iK = c0Var.K();
        boolean z11 = false;
        if (iK != 4801587) {
            o.h("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iK)));
            return null;
        }
        int iH = c0Var.H();
        c0Var.V(1);
        int iH2 = c0Var.H();
        int iG = c0Var.G();
        if (iH == 2) {
            if ((iH2 & 64) != 0) {
                o.h("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iH == 3) {
            if ((iH2 & 64) != 0) {
                int iQ = c0Var.q();
                c0Var.V(iQ);
                iG -= iQ + 4;
            }
        } else {
            if (iH != 4) {
                o.h("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iH);
                return null;
            }
            if ((iH2 & 64) != 0) {
                int iG2 = c0Var.G();
                c0Var.V(iG2 - 4);
                iG -= iG2;
            }
            if ((iH2 & 16) != 0) {
                iG -= 10;
            }
        }
        if (iH < 4 && (iH2 & 128) != 0) {
            z11 = true;
        }
        return new C0681b(iH, z11, iG);
    }

    public static MlltFrame n(c0 c0Var, int i11) {
        int iN = c0Var.N();
        int iK = c0Var.K();
        int iK2 = c0Var.K();
        int iH = c0Var.H();
        int iH2 = c0Var.H();
        b0 b0Var = new b0();
        b0Var.m(c0Var);
        int i12 = ((i11 - 10) * 8) / (iH + iH2);
        int[] iArr = new int[i12];
        int[] iArr2 = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int iH3 = b0Var.h(iH);
            int iH4 = b0Var.h(iH2);
            iArr[i13] = iH3;
            iArr2[i13] = iH4;
        }
        return new MlltFrame(iN, iK, iK2, iArr, iArr2);
    }

    public static PrivFrame o(c0 c0Var, int i11) {
        byte[] bArr = new byte[i11];
        c0Var.l(bArr, 0, i11);
        int iZ = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iZ, com.google.common.base.c.f38164b), d(bArr, iZ + 1, i11));
    }

    public static String p(byte[] bArr, int i11, int i12, Charset charset) {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, charset);
    }

    @Nullable
    public static TextInformationFrame q(c0 c0Var, int i11, String str) {
        if (i11 < 1) {
            return null;
        }
        int iH = c0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.l(bArr, 0, i12);
        return new TextInformationFrame(str, (String) null, r(bArr, iH, 0));
    }

    public static ImmutableList<String> r(byte[] bArr, int i11, int i12) {
        if (i12 >= bArr.length) {
            return ImmutableList.of("");
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int iY = y(bArr, i12, i11);
        while (i12 < iY) {
            aVarBuilder.a(new String(bArr, i12, iY - i12, w(i11)));
            i12 = v(i11) + iY;
            iY = y(bArr, i12, i11);
        }
        ImmutableList<String> immutableListM = aVarBuilder.m();
        return immutableListM.isEmpty() ? ImmutableList.of("") : immutableListM;
    }

    @Nullable
    public static TextInformationFrame s(c0 c0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int iH = c0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.l(bArr, 0, i12);
        int iY = y(bArr, 0, iH);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iY, w(iH)), r(bArr, iH, iY + v(iH)));
    }

    public static UrlLinkFrame t(c0 c0Var, int i11, String str) {
        byte[] bArr = new byte[i11];
        c0Var.l(bArr, 0, i11);
        return new UrlLinkFrame(str, null, new String(bArr, 0, z(bArr, 0), com.google.common.base.c.f38164b));
    }

    @Nullable
    public static UrlLinkFrame u(c0 c0Var, int i11) {
        if (i11 < 1) {
            return null;
        }
        int iH = c0Var.H();
        int i12 = i11 - 1;
        byte[] bArr = new byte[i12];
        c0Var.l(bArr, 0, i12);
        int iY = y(bArr, 0, iH);
        String str = new String(bArr, 0, iY, w(iH));
        int iV = iY + v(iH);
        return new UrlLinkFrame("WXXX", str, p(bArr, iV, z(bArr, iV), com.google.common.base.c.f38164b));
    }

    public static int v(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    public static Charset w(int i11) {
        if (i11 == 1) {
            return com.google.common.base.c.f38168f;
        }
        if (i11 != 2) {
            return i11 != 3 ? com.google.common.base.c.f38164b : com.google.common.base.c.f38165c;
        }
        return com.google.common.base.c.f38166d;
    }

    public static String x(int i11, int i12, int i13, int i14, int i15) {
        return i11 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15));
    }

    public static int y(byte[] bArr, int i11, int i12) {
        int iZ = z(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return iZ;
        }
        while (iZ < bArr.length - 1) {
            if ((iZ - i11) % 2 == 0 && bArr[iZ + 1] == 0) {
                return iZ;
            }
            iZ = z(bArr, iZ + 1);
        }
        return bArr.length;
    }

    public static int z(byte[] bArr, int i11) {
        while (i11 < bArr.length) {
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
        return bArr.length;
    }

    @Override // c5.c
    @Nullable
    public Metadata b(c5.b bVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata e(byte[] bArr, int i11) {
        ArrayList arrayList = new ArrayList();
        c0 c0Var = new c0(bArr, i11);
        C0681b c0681bM = m(c0Var);
        if (c0681bM == null) {
            return null;
        }
        int iF = c0Var.f();
        int i12 = c0681bM.f65406a == 2 ? 6 : 10;
        int iB = c0681bM.f65408c;
        if (c0681bM.f65407b) {
            iB = B(c0Var, c0681bM.f65408c);
        }
        c0Var.T(iF + iB);
        boolean z11 = false;
        if (!C(c0Var, c0681bM.f65406a, i12, false)) {
            if (c0681bM.f65406a != 4 || !C(c0Var, 4, i12, true)) {
                o.h("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + c0681bM.f65406a);
                return null;
            }
            z11 = true;
        }
        while (c0Var.a() >= i12) {
            Id3Frame id3FrameK = k(c0681bM.f65406a, c0Var, z11, i12, this.f65405a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }
}

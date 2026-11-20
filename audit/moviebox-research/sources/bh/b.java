package bh;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.google.android.exoplayer2.util.w;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mvel2.ast.ASTNode;
import tg.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f14105a = o0.n0("OpusHead");

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f14109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f14110e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f14111f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c0 f14112g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14113h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f14114i;

        public a(c0 c0Var, c0 c0Var2, boolean z11) throws ParserException {
            this.f14112g = c0Var;
            this.f14111f = c0Var2;
            this.f14110e = z11;
            c0Var2.P(12);
            this.f14106a = c0Var2.H();
            c0Var.P(12);
            this.f14114i = c0Var.H();
            tg.o.a(c0Var.n() == 1, "first_chunk must be 1");
            this.f14107b = -1;
        }

        public boolean a() {
            int i11 = this.f14107b + 1;
            this.f14107b = i11;
            if (i11 == this.f14106a) {
                return false;
            }
            this.f14109d = this.f14110e ? this.f14111f.I() : this.f14111f.F();
            if (this.f14107b == this.f14113h) {
                this.f14108c = this.f14112g.H();
                this.f14112g.Q(4);
                int i12 = this.f14114i - 1;
                this.f14114i = i12;
                this.f14113h = i12 > 0 ? this.f14112g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: bh.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0145b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f14116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f14117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f14118d;

        public C0145b(String str, byte[] bArr, long j11, long j12) {
            this.f14115a = str;
            this.f14116b = bArr;
            this.f14117c = j11;
            this.f14118d = j12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        int a();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p[] f14119a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public m1 f14120b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14121c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14122d = 0;

        public d(int i11) {
            this.f14119a = new p[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14123a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14124b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f14125c;

        public e(bh.a.b bVar, m1 m1Var) {
            c0 c0Var = bVar.f14104b;
            this.f14125c = c0Var;
            c0Var.P(12);
            int iH = c0Var.H();
            if (MimeTypes.AUDIO_RAW.equals(m1Var.f33445m)) {
                int iE0 = o0.e0(m1Var.B, m1Var.f33458z);
                if (iH == 0 || iH % iE0 != 0) {
                    s.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iE0 + ", stsz sample size: " + iH);
                    iH = iE0;
                }
            }
            this.f14123a = iH == 0 ? -1 : iH;
            this.f14124b = c0Var.H();
        }

        @Override // bh.b.c
        public int a() {
            return this.f14123a;
        }

        @Override // bh.b.c
        public int getSampleCount() {
            return this.f14124b;
        }

        @Override // bh.b.c
        public int readNextSampleSize() {
            int i11 = this.f14123a;
            return i11 == -1 ? this.f14125c.H() : i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f14126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f14127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14130e;

        public f(bh.a.b bVar) {
            c0 c0Var = bVar.f14104b;
            this.f14126a = c0Var;
            c0Var.P(12);
            this.f14128c = c0Var.H() & 255;
            this.f14127b = c0Var.H();
        }

        @Override // bh.b.c
        public int a() {
            return -1;
        }

        @Override // bh.b.c
        public int getSampleCount() {
            return this.f14127b;
        }

        @Override // bh.b.c
        public int readNextSampleSize() {
            int i11 = this.f14128c;
            if (i11 == 8) {
                return this.f14126a.D();
            }
            if (i11 == 16) {
                return this.f14126a.J();
            }
            int i12 = this.f14129d;
            this.f14129d = i12 + 1;
            if (i12 % 2 != 0) {
                return this.f14130e & 15;
            }
            int iD = this.f14126a.D();
            this.f14130e = iD;
            return (iD & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f14132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14133c;

        public g(int i11, long j11, int i12) {
            this.f14131a = i11;
            this.f14132b = j11;
            this.f14133c = i12;
        }
    }

    public static List<r> A(bh.a.C0144a c0144a, x xVar, long j11, @Nullable DrmInitData drmInitData, boolean z11, boolean z12, com.google.common.base.f<o, o> fVar) throws ParserException {
        o oVarApply;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < c0144a.f14103d.size(); i11++) {
            bh.a.C0144a c0144a2 = c0144a.f14103d.get(i11);
            if (c0144a2.f14100a == 1953653099 && (oVarApply = fVar.apply(z(c0144a2, (bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1836476516)), j11, drmInitData, z11, z12))) != null) {
                arrayList.add(v(oVarApply, (bh.a.C0144a) com.google.android.exoplayer2.util.a.e(((bh.a.C0144a) com.google.android.exoplayer2.util.a.e(((bh.a.C0144a) com.google.android.exoplayer2.util.a.e(c0144a2.f(1835297121))).f(1835626086))).f(1937007212)), xVar));
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> B(bh.a.b bVar) {
        c0 c0Var = bVar.f14104b;
        c0Var.P(8);
        Metadata metadataC = null;
        Metadata metadataU = null;
        while (c0Var.a() >= 8) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            if (iN2 == 1835365473) {
                c0Var.P(iE);
                metadataC = C(c0Var, iE + iN);
            } else if (iN2 == 1936553057) {
                c0Var.P(iE);
                metadataU = u(c0Var, iE + iN);
            }
            c0Var.P(iE + iN);
        }
        return Pair.create(metadataC, metadataU);
    }

    @Nullable
    public static Metadata C(c0 c0Var, int i11) {
        c0Var.Q(8);
        e(c0Var);
        while (c0Var.e() < i11) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            if (c0Var.n() == 1768715124) {
                c0Var.P(iE);
                return l(c0Var, iE + iN);
            }
            c0Var.P(iE + iN);
        }
        return null;
    }

    public static void D(c0 c0Var, int i11, int i12, int i13, int i14, int i15, @Nullable DrmInitData drmInitData, d dVar, int i16) throws ParserException {
        String str;
        DrmInitData drmInitData2;
        byte[] bArr;
        float f11;
        List<byte[]> list;
        String str2;
        int i17 = i12;
        int i18 = i13;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        d dVar2 = dVar;
        c0Var.P(i17 + 16);
        c0Var.Q(16);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        c0Var.Q(50);
        int iE = c0Var.e();
        int iIntValue = i11;
        if (iIntValue == 1701733238) {
            Pair<Integer, p> pairS = s(c0Var, i17, i18);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((p) pairS.second).f14241b);
                dVar2.f14119a[i16] = (p) pairS.second;
            }
            c0Var.P(iE);
        }
        String str3 = MimeTypes.VIDEO_H263;
        if (iIntValue == 1831958048) {
            str = MimeTypes.VIDEO_MPEG;
        } else {
            str = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        }
        float fQ = 1.0f;
        byte[] bArrR = null;
        String str4 = null;
        List<byte[]> listOf = null;
        int i19 = -1;
        int iB = -1;
        int i21 = -1;
        int iC = -1;
        ByteBuffer byteBufferA = null;
        C0145b c0145bI = null;
        boolean z11 = false;
        while (true) {
            if (iE - i17 >= i18) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                break;
            }
            c0Var.P(iE);
            int iE2 = c0Var.e();
            String str5 = str3;
            int iN = c0Var.n();
            if (iN == 0) {
                drmInitData2 = drmInitDataCopyWithSchemeType;
                if (c0Var.e() - i17 == i18) {
                    break;
                }
            } else {
                drmInitData2 = drmInitDataCopyWithSchemeType;
            }
            tg.o.a(iN > 0, "childAtomSize must be positive");
            int iN2 = c0Var.n();
            if (iN2 == 1635148611) {
                tg.o.a(str == null, null);
                c0Var.P(iE2 + 8);
                com.google.android.exoplayer2.video.a aVarB = com.google.android.exoplayer2.video.a.b(c0Var);
                listOf = aVarB.f35710a;
                dVar2.f14121c = aVarB.f35711b;
                if (!z11) {
                    fQ = aVarB.f35714e;
                }
                str4 = aVarB.f35715f;
                str2 = MimeTypes.VIDEO_H264;
            } else if (iN2 == 1752589123) {
                tg.o.a(str == null, null);
                c0Var.P(iE2 + 8);
                com.google.android.exoplayer2.video.f fVarA = com.google.android.exoplayer2.video.f.a(c0Var);
                listOf = fVarA.f35739a;
                dVar2.f14121c = fVarA.f35740b;
                if (!z11) {
                    fQ = fVarA.f35743e;
                }
                str4 = fVarA.f35744f;
                str2 = MimeTypes.VIDEO_H265;
            } else {
                if (iN2 == 1685480259 || iN2 == 1685485123) {
                    iJ2 = iJ2;
                    iIntValue = iIntValue;
                    bArr = bArrR;
                    f11 = fQ;
                    list = listOf;
                    com.google.android.exoplayer2.video.d dVarA = com.google.android.exoplayer2.video.d.a(c0Var);
                    if (dVarA != null) {
                        str4 = dVarA.f35724c;
                        str = "video/dolby-vision";
                    }
                } else if (iN2 == 1987076931) {
                    tg.o.a(str == null, null);
                    str2 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                } else {
                    if (iN2 == 1635135811) {
                        tg.o.a(str == null, null);
                        str2 = "video/av01";
                    } else if (iN2 == 1668050025) {
                        if (byteBufferA == null) {
                            byteBufferA = a();
                        }
                        ByteBuffer byteBuffer = byteBufferA;
                        byteBuffer.position(21);
                        byteBuffer.putShort(c0Var.z());
                        byteBuffer.putShort(c0Var.z());
                        byteBufferA = byteBuffer;
                    } else if (iN2 == 1835295606) {
                        if (byteBufferA == null) {
                            byteBufferA = a();
                        }
                        ByteBuffer byteBuffer2 = byteBufferA;
                        short sZ = c0Var.z();
                        short sZ2 = c0Var.z();
                        short sZ3 = c0Var.z();
                        short sZ4 = c0Var.z();
                        short sZ5 = c0Var.z();
                        List<byte[]> list2 = listOf;
                        short sZ6 = c0Var.z();
                        byte[] bArr2 = bArrR;
                        short sZ7 = c0Var.z();
                        float f12 = fQ;
                        short sZ8 = c0Var.z();
                        long jF = c0Var.F();
                        long jF2 = c0Var.F();
                        byteBuffer2.position(1);
                        byteBuffer2.putShort(sZ5);
                        byteBuffer2.putShort(sZ6);
                        byteBuffer2.putShort(sZ);
                        byteBuffer2.putShort(sZ2);
                        byteBuffer2.putShort(sZ3);
                        byteBuffer2.putShort(sZ4);
                        byteBuffer2.putShort(sZ7);
                        byteBuffer2.putShort(sZ8);
                        byteBuffer2.putShort((short) (jF / 10000));
                        byteBuffer2.putShort((short) (jF2 / 10000));
                        byteBufferA = byteBuffer2;
                        listOf = list2;
                        bArrR = bArr2;
                        fQ = f12;
                    } else {
                        iJ2 = iJ2;
                        iIntValue = iIntValue;
                        bArr = bArrR;
                        f11 = fQ;
                        list = listOf;
                        if (iN2 == 1681012275) {
                            tg.o.a(str == null, null);
                            str = str5;
                        } else if (iN2 == 1702061171) {
                            tg.o.a(str == null, null);
                            c0145bI = i(c0Var, iE2);
                            String str6 = c0145bI.f14115a;
                            byte[] bArr3 = c0145bI.f14116b;
                            listOf = bArr3 != null ? ImmutableList.of(bArr3) : list;
                            str = str6;
                            bArrR = bArr;
                            fQ = f11;
                        } else if (iN2 == 1885434736) {
                            fQ = q(c0Var, iE2);
                            listOf = list;
                            bArrR = bArr;
                            z11 = true;
                        } else {
                            if (iN2 == 1937126244) {
                                bArrR = r(c0Var, iE2, iN);
                                listOf = list;
                            } else if (iN2 == 1936995172) {
                                int iD = c0Var.D();
                                c0Var.Q(3);
                                if (iD == 0) {
                                    int iD2 = c0Var.D();
                                    if (iD2 == 0) {
                                        i19 = 0;
                                    } else if (iD2 == 1) {
                                        i19 = 1;
                                    } else if (iD2 == 2) {
                                        i19 = 2;
                                    } else if (iD2 == 3) {
                                        i19 = 3;
                                    }
                                }
                            } else if (iN2 == 1668246642) {
                                int iN3 = c0Var.n();
                                if (iN3 == 1852009592 || iN3 == 1852009571) {
                                    int iJ3 = c0Var.J();
                                    int iJ4 = c0Var.J();
                                    c0Var.Q(2);
                                    boolean z12 = iN == 19 && (c0Var.D() & 128) != 0;
                                    iB = com.google.android.exoplayer2.video.c.b(iJ3);
                                    i21 = z12 ? 1 : 2;
                                    iC = com.google.android.exoplayer2.video.c.c(iJ4);
                                } else {
                                    s.i("AtomParsers", "Unsupported color type: " + bh.a.a(iN3));
                                }
                            }
                            fQ = f11;
                        }
                    }
                    iE += iN;
                    i17 = i12;
                    i18 = i13;
                    dVar2 = dVar;
                    str3 = str5;
                    drmInitDataCopyWithSchemeType = drmInitData2;
                    iIntValue = iIntValue;
                    iJ2 = iJ2;
                }
                listOf = list;
                bArrR = bArr;
                fQ = f11;
                iE += iN;
                i17 = i12;
                i18 = i13;
                dVar2 = dVar;
                str3 = str5;
                drmInitDataCopyWithSchemeType = drmInitData2;
                iIntValue = iIntValue;
                iJ2 = iJ2;
            }
            str = str2;
            iE += iN;
            i17 = i12;
            i18 = i13;
            dVar2 = dVar;
            str3 = str5;
            drmInitDataCopyWithSchemeType = drmInitData2;
            iIntValue = iIntValue;
            iJ2 = iJ2;
        }
        int i22 = iJ2;
        byte[] bArr4 = bArrR;
        float f13 = fQ;
        List<byte[]> list3 = listOf;
        if (str == null) {
            return;
        }
        m1.b bVarM = new m1.b().R(i14).e0(str).I(str4).j0(iJ).Q(i22).a0(f13).d0(i15).b0(bArr4).h0(i19).T(list3).M(drmInitData2);
        int i23 = iB;
        int i24 = i21;
        int i25 = iC;
        if (i23 != -1 || i24 != -1 || i25 != -1 || byteBufferA != null) {
            bVarM.J(new com.google.android.exoplayer2.video.c(i23, i24, i25, byteBufferA != null ? byteBufferA.array() : null));
        }
        if (c0145bI != null) {
            bVarM.G(Ints.l(c0145bI.f14117c)).Z(Ints.l(c0145bI.f14118d));
        }
        dVar.f14120b = bVarM.E();
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[o0.q(4, 0, length)] && jArr[o0.q(jArr.length - 4, 0, length)] < j13 && j13 <= j11;
    }

    public static int c(c0 c0Var, int i11, int i12, int i13) throws ParserException {
        int iE = c0Var.e();
        tg.o.a(iE >= i12, null);
        while (iE - i12 < i13) {
            c0Var.P(iE);
            int iN = c0Var.n();
            tg.o.a(iN > 0, "childAtomSize must be positive");
            if (c0Var.n() == i11) {
                return iE;
            }
            iE += iN;
        }
        return -1;
    }

    public static int d(int i11) {
        if (i11 == 1936684398) {
            return 1;
        }
        if (i11 == 1986618469) {
            return 2;
        }
        if (i11 == 1952807028 || i11 == 1935832172 || i11 == 1937072756 || i11 == 1668047728) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    public static void e(c0 c0Var) {
        int iE = c0Var.e();
        c0Var.Q(4);
        if (c0Var.n() != 1751411826) {
            iE += 4;
        }
        c0Var.P(iE);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0166  */
    /* JADX WARN: Code duplicated, block: B:102:0x016f  */
    /* JADX WARN: Code duplicated, block: B:103:0x0171  */
    /* JADX WARN: Code duplicated, block: B:106:0x0180  */
    /* JADX WARN: Code duplicated, block: B:110:0x019c  */
    /* JADX WARN: Code duplicated, block: B:115:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:147:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:153:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:155:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:171:0x0303 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x0303 A[SYNTHETIC] */
    public static void f(c0 c0Var, int i11, int i12, int i13, int i14, String str, boolean z11, @Nullable DrmInitData drmInitData, d dVar, int i15) throws ParserException {
        int iJ;
        int iE;
        int iN;
        int iH;
        String str2;
        String str3;
        int i16;
        String str4;
        C0145b c0145bI;
        String str5;
        List<byte[]> listOf;
        int iN2;
        boolean z12;
        int iN3;
        int iC;
        byte[] bArr;
        int i17 = i12;
        int i18 = i13;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        c0Var.P(i17 + 16);
        if (z11) {
            iJ = c0Var.J();
            c0Var.Q(6);
        } else {
            c0Var.Q(8);
            iJ = 0;
        }
        if (iJ == 0 || iJ == 1) {
            int iJ2 = c0Var.J();
            c0Var.Q(6);
            iE = c0Var.E();
            c0Var.P(c0Var.e() - 4);
            iN = c0Var.n();
            if (iJ == 1) {
                c0Var.Q(16);
            }
            iH = iJ2;
        } else {
            if (iJ != 2) {
                return;
            }
            c0Var.Q(16);
            iE = (int) Math.round(c0Var.l());
            iH = c0Var.H();
            c0Var.Q(20);
            iN = 0;
        }
        int iE2 = c0Var.e();
        int iIntValue = i11;
        if (iIntValue == 1701733217) {
            Pair<Integer, p> pairS = s(c0Var, i17, i18);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((p) pairS.second).f14241b);
                dVar.f14119a[i15] = (p) pairS.second;
            }
            c0Var.P(iE2);
        }
        if (iIntValue == 1633889587) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (iIntValue == 1700998451) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (iIntValue == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue == 1685353315) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (iIntValue == 1685353320 || iIntValue == 1685353324) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (iIntValue == 1685353317) {
            str2 = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (iIntValue == 1685353336) {
            str2 = "audio/vnd.dts.uhd;profile=p2";
        } else if (iIntValue == 1935764850) {
            str2 = MimeTypes.AUDIO_AMR_NB;
        } else {
            if (iIntValue != 1935767394) {
                str3 = MimeTypes.AUDIO_RAW;
                if (iIntValue == 1819304813 || iIntValue == 1936684916) {
                    i16 = 2;
                } else if (iIntValue == 1953984371) {
                    i16 = ASTNode.DEOP;
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (iIntValue == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (iIntValue == 1634492771) {
                    str2 = MimeTypes.AUDIO_ALAC;
                } else if (iIntValue == 1634492791) {
                    str2 = MimeTypes.AUDIO_ALAW;
                } else if (iIntValue == 1970037111) {
                    str2 = MimeTypes.AUDIO_MLAW;
                } else if (iIntValue == 1332770163) {
                    str2 = MimeTypes.AUDIO_OPUS;
                } else if (iIntValue == 1716281667) {
                    str2 = MimeTypes.AUDIO_FLAC;
                } else if (iIntValue == 1835823201) {
                    str2 = MimeTypes.AUDIO_TRUEHD;
                } else {
                    i16 = -1;
                    str3 = null;
                }
                str4 = str3;
                c0145bI = null;
                str5 = null;
                listOf = null;
                while (iE2 - i17 < i18) {
                    c0Var.P(iE2);
                    iN2 = c0Var.n();
                    if (iN2 > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    tg.o.a(z12, "childAtomSize must be positive");
                    iN3 = c0Var.n();
                    if (iN3 == 1835557187) {
                        int i19 = iN2 - 13;
                        byte[] bArr2 = new byte[i19];
                        c0Var.P(iE2 + 13);
                        c0Var.j(bArr2, 0, i19);
                        listOf = ImmutableList.of(bArr2);
                    } else {
                        if (iN3 != 1702061171 || (z11 && iN3 == 2002876005)) {
                            if (iN3 == 1702061171) {
                                iC = iE2;
                            } else {
                                iC = c(c0Var, 1702061171, iE2, iN2);
                            }
                            if (iC != -1) {
                                c0145bI = i(c0Var, iC);
                                str4 = c0145bI.f14115a;
                                bArr = c0145bI.f14116b;
                                if (bArr != null) {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        com.google.android.exoplayer2.audio.a.b bVarF = com.google.android.exoplayer2.audio.a.f(bArr);
                                        iE = bVarF.f32770a;
                                        iH = bVarF.f32771b;
                                        str5 = bVarF.f32772c;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        } else if (iN3 == 1684103987) {
                            c0Var.P(iE2 + 8);
                            dVar.f14120b = com.google.android.exoplayer2.audio.b.c(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                        } else if (iN3 == 1684366131) {
                            c0Var.P(iE2 + 8);
                            dVar.f14120b = com.google.android.exoplayer2.audio.b.g(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                        } else if (iN3 == 1684103988) {
                            c0Var.P(iE2 + 8);
                            dVar.f14120b = com.google.android.exoplayer2.audio.c.b(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                        } else if (iN3 == 1684892784) {
                            if (iN <= 0) {
                                throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + iN, null);
                            }
                            iE = iN;
                            iH = 2;
                        } else if (iN3 == 1684305011) {
                            dVar.f14120b = new m1.b().R(i14).e0(str4).H(iH).f0(iE).M(drmInitDataCopyWithSchemeType).V(str).E();
                        } else if (iN3 == 1682927731) {
                            int i21 = iN2 - 8;
                            byte[] bArr3 = f14105a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i21);
                            c0Var.P(iE2 + 8);
                            c0Var.j(bArrCopyOf, bArr3.length, i21);
                            listOf = com.google.android.exoplayer2.audio.c0.a(bArrCopyOf);
                        } else if (iN3 == 1684425825) {
                            byte[] bArr4 = new byte[iN2 - 8];
                            bArr4[0] = 102;
                            bArr4[1] = 76;
                            bArr4[2] = 97;
                            bArr4[3] = 67;
                            c0Var.P(iE2 + 12);
                            c0Var.j(bArr4, 4, iN2 - 12);
                            listOf = ImmutableList.of(bArr4);
                        } else if (iN3 == 1634492771) {
                            int i22 = iN2 - 12;
                            byte[] bArr5 = new byte[i22];
                            c0Var.P(iE2 + 12);
                            c0Var.j(bArr5, 0, i22);
                            Pair<Integer, Integer> pairH = com.google.android.exoplayer2.util.f.h(bArr5);
                            int iIntValue2 = ((Integer) pairH.first).intValue();
                            int iIntValue3 = ((Integer) pairH.second).intValue();
                            listOf = ImmutableList.of(bArr5);
                            iH = iIntValue3;
                            iE = iIntValue2;
                        }
                        iE2 += iN2;
                        i17 = i12;
                        i18 = i13;
                    }
                    iE2 += iN2;
                    i17 = i12;
                    i18 = i13;
                }
                if (dVar.f14120b == null || str4 == null) {
                }
                m1.b bVarV = new m1.b().R(i14).e0(str4).I(str5).H(iH).f0(iE).Y(i16).T(listOf).M(drmInitDataCopyWithSchemeType).V(str);
                if (c0145bI != null) {
                    bVarV.G(Ints.l(c0145bI.f14117c)).Z(Ints.l(c0145bI.f14118d));
                }
                dVar.f14120b = bVarV.E();
                return;
            }
            str2 = MimeTypes.AUDIO_AMR_WB;
        }
        str3 = str2;
        i16 = -1;
        str4 = str3;
        c0145bI = null;
        str5 = null;
        listOf = null;
        while (iE2 - i17 < i18) {
            c0Var.P(iE2);
            iN2 = c0Var.n();
            if (iN2 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            tg.o.a(z12, "childAtomSize must be positive");
            iN3 = c0Var.n();
            if (iN3 == 1835557187) {
                int i110 = iN2 - 13;
                byte[] bArr6 = new byte[i110];
                c0Var.P(iE2 + 13);
                c0Var.j(bArr6, 0, i110);
                listOf = ImmutableList.of(bArr6);
            } else {
                if (iN3 != 1702061171) {
                    if (iN3 == 1702061171) {
                        iC = iE2;
                    } else {
                        iC = c(c0Var, 1702061171, iE2, iN2);
                    }
                    if (iC != -1) {
                        c0145bI = i(c0Var, iC);
                        str4 = c0145bI.f14115a;
                        bArr = c0145bI.f14116b;
                        if (bArr != null) {
                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                com.google.android.exoplayer2.audio.a.b bVarF2 = com.google.android.exoplayer2.audio.a.f(bArr);
                                iE = bVarF2.f32770a;
                                iH = bVarF2.f32771b;
                                str5 = bVarF2.f32772c;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                    }
                } else {
                    if (iN3 == 1702061171) {
                        iC = iE2;
                    } else {
                        iC = c(c0Var, 1702061171, iE2, iN2);
                    }
                    if (iC != -1) {
                        c0145bI = i(c0Var, iC);
                        str4 = c0145bI.f14115a;
                        bArr = c0145bI.f14116b;
                        if (bArr != null) {
                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                com.google.android.exoplayer2.audio.a.b bVarF3 = com.google.android.exoplayer2.audio.a.f(bArr);
                                iE = bVarF3.f32770a;
                                iH = bVarF3.f32771b;
                                str5 = bVarF3.f32772c;
                            }
                            listOf = ImmutableList.of(bArr);
                        }
                    }
                }
                iE2 += iN2;
                i17 = i12;
                i18 = i13;
            }
            iE2 += iN2;
            i17 = i12;
            i18 = i13;
        }
        if (dVar.f14120b == null) {
        }
    }

    @Nullable
    public static Pair<Integer, p> g(c0 c0Var, int i11, int i12) throws ParserException {
        int i13 = i11 + 8;
        String strA = null;
        Integer numValueOf = null;
        int i14 = -1;
        int i15 = 0;
        while (i13 - i11 < i12) {
            c0Var.P(i13);
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            if (iN2 == 1718775137) {
                numValueOf = Integer.valueOf(c0Var.n());
            } else if (iN2 == 1935894637) {
                c0Var.Q(4);
                strA = c0Var.A(4);
            } else if (iN2 == 1935894633) {
                i14 = i13;
                i15 = iN;
            }
            i13 += iN;
        }
        if (!C.CENC_TYPE_cenc.equals(strA) && !C.CENC_TYPE_cbc1.equals(strA) && !C.CENC_TYPE_cens.equals(strA) && !C.CENC_TYPE_cbcs.equals(strA)) {
            return null;
        }
        tg.o.a(numValueOf != null, "frma atom is mandatory");
        tg.o.a(i14 != -1, "schi atom is mandatory");
        p pVarT = t(c0Var, i14, i15, strA);
        tg.o.a(pVarT != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (p) o0.j(pVarT));
    }

    @Nullable
    public static Pair<long[], long[]> h(bh.a.C0144a c0144a) {
        bh.a.b bVarG = c0144a.g(1701606260);
        if (bVarG == null) {
            return null;
        }
        c0 c0Var = bVarG.f14104b;
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        int iH = c0Var.H();
        long[] jArr = new long[iH];
        long[] jArr2 = new long[iH];
        for (int i11 = 0; i11 < iH; i11++) {
            jArr[i11] = iC == 1 ? c0Var.I() : c0Var.F();
            jArr2[i11] = iC == 1 ? c0Var.w() : c0Var.n();
            if (c0Var.z() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            c0Var.Q(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static C0145b i(c0 c0Var, int i11) {
        c0Var.P(i11 + 12);
        c0Var.Q(1);
        j(c0Var);
        c0Var.Q(2);
        int iD = c0Var.D();
        if ((iD & 128) != 0) {
            c0Var.Q(2);
        }
        if ((iD & 64) != 0) {
            c0Var.Q(c0Var.D());
        }
        if ((iD & 32) != 0) {
            c0Var.Q(2);
        }
        c0Var.Q(1);
        j(c0Var);
        String strH = w.h(c0Var.D());
        if (MimeTypes.AUDIO_MPEG.equals(strH) || MimeTypes.AUDIO_DTS.equals(strH) || MimeTypes.AUDIO_DTS_HD.equals(strH)) {
            return new C0145b(strH, null, -1L, -1L);
        }
        c0Var.Q(4);
        long jF = c0Var.F();
        long jF2 = c0Var.F();
        c0Var.Q(1);
        int iJ = j(c0Var);
        byte[] bArr = new byte[iJ];
        c0Var.j(bArr, 0, iJ);
        return new C0145b(strH, bArr, jF2 > 0 ? jF2 : -1L, jF > 0 ? jF : -1L);
    }

    public static int j(c0 c0Var) {
        int iD = c0Var.D();
        int i11 = iD & 127;
        while ((iD & 128) == 128) {
            iD = c0Var.D();
            i11 = (i11 << 7) | (iD & 127);
        }
        return i11;
    }

    public static int k(c0 c0Var) {
        c0Var.P(16);
        return c0Var.n();
    }

    @Nullable
    public static Metadata l(c0 c0Var, int i11) {
        c0Var.Q(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var.e() < i11) {
            Metadata.Entry entryC = h.c(c0Var);
            if (entryC != null) {
                arrayList.add(entryC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> m(c0 c0Var) {
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        c0Var.Q(iC == 0 ? 8 : 16);
        long jF = c0Var.F();
        c0Var.Q(iC == 0 ? 4 : 8);
        int iJ = c0Var.J();
        return Pair.create(Long.valueOf(jF), "" + ((char) (((iJ >> 10) & 31) + 96)) + ((char) (((iJ >> 5) & 31) + 96)) + ((char) ((iJ & 31) + 96)));
    }

    @Nullable
    public static Metadata n(bh.a.C0144a c0144a) {
        bh.a.b bVarG = c0144a.g(1751411826);
        bh.a.b bVarG2 = c0144a.g(1801812339);
        bh.a.b bVarG3 = c0144a.g(1768715124);
        if (bVarG == null || bVarG2 == null || bVarG3 == null || k(bVarG.f14104b) != 1835299937) {
            return null;
        }
        c0 c0Var = bVarG2.f14104b;
        c0Var.P(12);
        int iN = c0Var.n();
        String[] strArr = new String[iN];
        for (int i11 = 0; i11 < iN; i11++) {
            int iN2 = c0Var.n();
            c0Var.Q(4);
            strArr[i11] = c0Var.A(iN2 - 8);
        }
        c0 c0Var2 = bVarG3.f14104b;
        c0Var2.P(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var2.a() > 8) {
            int iE = c0Var2.e();
            int iN3 = c0Var2.n();
            int iN4 = c0Var2.n() - 1;
            if (iN4 < 0 || iN4 >= iN) {
                s.i("AtomParsers", "Skipped metadata with unknown key index: " + iN4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = h.f(c0Var2, iE + iN3, strArr[iN4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            c0Var2.P(iE + iN3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void o(c0 c0Var, int i11, int i12, int i13, d dVar) {
        c0Var.P(i12 + 16);
        if (i11 == 1835365492) {
            c0Var.x();
            String strX = c0Var.x();
            if (strX != null) {
                dVar.f14120b = new m1.b().R(i13).e0(strX).E();
            }
        }
    }

    public static long p(c0 c0Var) {
        c0Var.P(8);
        c0Var.Q(bh.a.c(c0Var.n()) != 0 ? 16 : 8);
        return c0Var.F();
    }

    public static float q(c0 c0Var, int i11) {
        c0Var.P(i11 + 8);
        return c0Var.H() / c0Var.H();
    }

    @Nullable
    public static byte[] r(c0 c0Var, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            c0Var.P(i13);
            int iN = c0Var.n();
            if (c0Var.n() == 1886547818) {
                return Arrays.copyOfRange(c0Var.d(), i13, iN + i13);
            }
            i13 += iN;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, p> s(c0 c0Var, int i11, int i12) throws ParserException {
        Pair<Integer, p> pairG;
        int iE = c0Var.e();
        while (iE - i11 < i12) {
            c0Var.P(iE);
            int iN = c0Var.n();
            tg.o.a(iN > 0, "childAtomSize must be positive");
            if (c0Var.n() == 1936289382 && (pairG = g(c0Var, iE, iN)) != null) {
                return pairG;
            }
            iE += iN;
        }
        return null;
    }

    @Nullable
    public static p t(c0 c0Var, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            c0Var.P(i15);
            int iN = c0Var.n();
            if (c0Var.n() == 1952804451) {
                int iC = bh.a.c(c0Var.n());
                c0Var.Q(1);
                if (iC == 0) {
                    c0Var.Q(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int iD = c0Var.D();
                    i13 = iD & 15;
                    i14 = (iD & 240) >> 4;
                }
                boolean z11 = c0Var.D() == 1;
                int iD2 = c0Var.D();
                byte[] bArr2 = new byte[16];
                c0Var.j(bArr2, 0, 16);
                if (z11 && iD2 == 0) {
                    int iD3 = c0Var.D();
                    bArr = new byte[iD3];
                    c0Var.j(bArr, 0, iD3);
                }
                return new p(z11, str, iD2, bArr2, i14, i13, bArr);
            }
            i15 += iN;
        }
    }

    @Nullable
    public static Metadata u(c0 c0Var, int i11) {
        c0Var.Q(12);
        while (c0Var.e() < i11) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            if (c0Var.n() == 1935766900) {
                if (iN < 14) {
                    return null;
                }
                c0Var.Q(5);
                int iD = c0Var.D();
                if (iD != 12 && iD != 13) {
                    return null;
                }
                float f11 = iD == 12 ? 240.0f : 120.0f;
                c0Var.Q(1);
                return new Metadata(new SmtaMetadataEntry(f11, c0Var.D()));
            }
            c0Var.P(iE + iN);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0249  */
    /* JADX WARN: Code duplicated, block: B:111:0x028a  */
    /* JADX WARN: Code duplicated, block: B:112:0x028d  */
    /* JADX WARN: Code duplicated, block: B:117:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:119:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:138:0x0361  */
    /* JADX WARN: Code duplicated, block: B:141:0x036a  */
    /* JADX WARN: Code duplicated, block: B:151:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:152:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:156:0x03ce  */
    /* JADX WARN: Code duplicated, block: B:158:0x03d8  */
    /* JADX WARN: Code duplicated, block: B:161:0x0401  */
    /* JADX WARN: Code duplicated, block: B:166:0x0413  */
    /* JADX WARN: Code duplicated, block: B:167:0x0415  */
    /* JADX WARN: Code duplicated, block: B:169:0x0419  */
    /* JADX WARN: Code duplicated, block: B:174:0x0435  */
    /* JADX WARN: Code duplicated, block: B:177:0x043a  */
    /* JADX WARN: Code duplicated, block: B:178:0x043d  */
    /* JADX WARN: Code duplicated, block: B:180:0x0440  */
    /* JADX WARN: Code duplicated, block: B:181:0x0443  */
    /* JADX WARN: Code duplicated, block: B:183:0x0446  */
    /* JADX WARN: Code duplicated, block: B:184:0x0448  */
    /* JADX WARN: Code duplicated, block: B:186:0x044c  */
    /* JADX WARN: Code duplicated, block: B:187:0x044f  */
    /* JADX WARN: Code duplicated, block: B:191:0x045e  */
    /* JADX WARN: Code duplicated, block: B:193:0x046c  */
    /* JADX WARN: Code duplicated, block: B:194:0x047c  */
    /* JADX WARN: Code duplicated, block: B:197:0x0484  */
    /* JADX WARN: Code duplicated, block: B:199:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:201:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:202:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:212:0x042a A[EDGE_INSN: B:212:0x042a->B:171:0x042a BREAK  A[LOOP:2: B:154:0x03c9->B:170:0x0423], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:215:0x040b A[ADDED_TO_REGION, EDGE_INSN: B:215:0x040b->B:164:0x040b BREAK  A[LOOP:3: B:159:0x03fb->B:163:0x0406], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:221:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:222:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x017b A[EDGE_INSN: B:224:0x017b->B:63:0x017b BREAK  A[LOOP:7: B:59:0x015e->B:62:0x0166], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:227:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x022e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:50:0x0100  */
    /* JADX WARN: Code duplicated, block: B:53:0x010c A[LOOP:0: B:51:0x0106->B:53:0x010c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x0132  */
    /* JADX WARN: Code duplicated, block: B:58:0x0158  */
    /* JADX WARN: Code duplicated, block: B:60:0x0160  */
    /* JADX WARN: Code duplicated, block: B:62:0x0166 A[LOOP:7: B:59:0x015e->B:62:0x0166, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x019f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x01a1 A[ADDED_TO_REGION, LOOP:8: B:67:0x01a1->B:69:0x01a5, LOOP_START, PHI: r16 r22 r23
  0x01a1: PHI (r16v7 int) = (r16v3 int), (r16v8 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r22v5 int) = (r22v1 int), (r22v6 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r23v3 int) = (r23v1 int), (r23v5 int) binds: [B:66:0x019f, B:69:0x01a5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:73:0x01be  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:80:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:88:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:93:0x0226 A[DONT_INVERT, LOOP:9: B:93:0x0226->B:97:0x0230, LOOP_START, PHI: r16
  0x0226: PHI (r16v4 int) = (r16v3 int), (r16v5 int) binds: [B:92:0x0224, B:97:0x0230] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:94:0x0228  */
    /* JADX WARN: Code duplicated, block: B:97:0x0230 A[LOOP:9: B:93:0x0226->B:97:0x0230, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:98:0x0236 A[EDGE_INSN: B:98:0x0236->B:99:0x0237 BREAK  A[LOOP:9: B:93:0x0226->B:97:0x0230]] */
    public static r v(o oVar, bh.a.C0144a c0144a, x xVar) throws ParserException {
        c fVar;
        boolean z11;
        int iH;
        int iH2;
        int iH3;
        int iA;
        boolean z12;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int iH4;
        int i11;
        int i12;
        int i13;
        int iN;
        int iH5;
        long j11;
        long j12;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        boolean z13;
        int i23;
        o oVar2;
        String str;
        int i24;
        long[] jArr;
        int[] iArr;
        int i25;
        long j13;
        long[] jArr2;
        int[] iArr2;
        long j14;
        int i26;
        boolean zA;
        int i27;
        int i28;
        int nextSampleSize;
        int i29;
        int iH6;
        int iN2;
        int i31;
        long jO0;
        long[] jArr3;
        int i32;
        int i33;
        long[] jArr4;
        boolean z14;
        int[] iArr3;
        int[] iArr4;
        long[] jArr5;
        int i34;
        boolean z15;
        int i35;
        int i36;
        long[] jArr6;
        long[] jArr7;
        int[] iArr5;
        int i37;
        boolean z16;
        long[] jArr8;
        int[] iArr6;
        int i38;
        int[] iArr7;
        long[] jArr9;
        int i39;
        int[] iArr8;
        long j15;
        int i40;
        long j16;
        int i41;
        int i42;
        int[] iArr9;
        int i43;
        int i44;
        int i45;
        long j17;
        boolean z17;
        int i46;
        int i47;
        int i48;
        boolean z18;
        long[] jArr10;
        int[] iArr10;
        bh.a.b bVarG = c0144a.g(1937011578);
        if (bVarG != null) {
            fVar = new e(bVarG, oVar.f14234f);
        } else {
            bh.a.b bVarG2 = c0144a.g(1937013298);
            if (bVarG2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            fVar = new f(bVarG2);
        }
        int sampleCount = fVar.getSampleCount();
        if (sampleCount == 0) {
            return new r(oVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        bh.a.b bVarG3 = c0144a.g(1937007471);
        if (bVarG3 == null) {
            bVarG3 = (bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1668232756));
            z11 = true;
        } else {
            z11 = false;
        }
        c0 c0Var = bVarG3.f14104b;
        c0 c0Var2 = ((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1937011555))).f14104b;
        c0 c0Var3 = ((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1937011827))).f14104b;
        bh.a.b bVarG4 = c0144a.g(1937011571);
        c0 c0Var4 = bVarG4 != null ? bVarG4.f14104b : null;
        bh.a.b bVarG5 = c0144a.g(1668576371);
        c0 c0Var5 = bVarG5 != null ? bVarG5.f14104b : null;
        a aVar = new a(c0Var2, c0Var, z11);
        c0Var3.P(12);
        int iH7 = c0Var3.H() - 1;
        int iH8 = c0Var3.H();
        int iH9 = c0Var3.H();
        if (c0Var5 != null) {
            c0Var5.P(12);
            iH = c0Var5.H();
        } else {
            iH = 0;
        }
        if (c0Var4 != null) {
            c0Var4.P(12);
            iH2 = c0Var4.H();
            if (iH2 > 0) {
                iH3 = c0Var4.H() - 1;
            } else {
                c0Var4 = null;
            }
            iA = fVar.a();
            String str2 = oVar.f14234f.f33445m;
            if (iA == -1 && ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && iH7 == 0 && iH == 0 && iH2 == 0)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i49 = aVar.f14106a;
                jArr10 = new long[i49];
                iArr10 = new int[i49];
                while (aVar.a()) {
                    int i50 = aVar.f14107b;
                    jArr10[i50] = aVar.f14109d;
                    iArr10[i50] = aVar.f14108c;
                }
                bh.d.b bVarA = bh.d.a(iA, jArr10, iArr10, iH9);
                long[] jArr11 = bVarA.f14138a;
                int[] iArr11 = bVarA.f14139b;
                int i51 = bVarA.f14140c;
                long[] jArr12 = bVarA.f14141d;
                int[] iArr12 = bVarA.f14142e;
                long j18 = bVarA.f14143f;
                oVar2 = oVar;
                i24 = sampleCount;
                jArr = jArr11;
                iArr = iArr11;
                i25 = i51;
                iArr2 = iArr12;
                j13 = j18;
                jArr2 = jArr12;
            } else {
                jArrCopyOf = new long[sampleCount];
                iArrCopyOf = new int[sampleCount];
                jArrCopyOf2 = new long[sampleCount];
                iArrCopyOf2 = new int[sampleCount];
                iH4 = iH3;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                iN = 0;
                iH5 = 0;
                j11 = 0;
                j12 = 0;
                i14 = iH;
                i15 = iH9;
                i16 = iH8;
                i17 = iH7;
                i18 = iH2;
                while (true) {
                    i19 = i17;
                    if (i11 < sampleCount) {
                        i21 = i16;
                        i22 = i13;
                        break;
                    }
                    j14 = j12;
                    i26 = i13;
                    zA = true;
                    while (i26 == 0) {
                        zA = aVar.a();
                        if (zA) {
                            break;
                        }
                        int i52 = i16;
                        long j19 = aVar.f14109d;
                        i26 = aVar.f14108c;
                        j14 = j19;
                        i16 = i52;
                        i15 = i15;
                        sampleCount = sampleCount;
                    }
                    i27 = sampleCount;
                    i21 = i16;
                    i28 = i15;
                    if (!zA) {
                        s.i("AtomParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                        sampleCount = i11;
                        i22 = i26;
                        break;
                    }
                    if (c0Var5 != null) {
                        while (iH5 == 0 && i14 > 0) {
                            iH5 = c0Var5.H();
                            iN = c0Var5.n();
                            i14--;
                        }
                        iH5--;
                    }
                    int i53 = iN;
                    jArrCopyOf[i11] = j14;
                    nextSampleSize = fVar.readNextSampleSize();
                    iArrCopyOf[i11] = nextSampleSize;
                    if (nextSampleSize > i12) {
                        i12 = nextSampleSize;
                    }
                    jArrCopyOf2[i11] = j11 + ((long) i53);
                    if (c0Var4 == null) {
                        i29 = 1;
                    } else {
                        i29 = 0;
                    }
                    iArrCopyOf2[i11] = i29;
                    if (i11 == iH4) {
                        iArrCopyOf2[i11] = 1;
                        i18--;
                        if (i18 > 0) {
                            iH4 = ((c0) com.google.android.exoplayer2.util.a.e(c0Var4)).H() - 1;
                        }
                    }
                    int i54 = iH4;
                    j11 += (long) i28;
                    iH6 = i21 - 1;
                    if (iH6 == 0 || i19 <= 0) {
                        iN2 = i28;
                        i31 = i19;
                    } else {
                        iH6 = c0Var3.H();
                        iN2 = c0Var3.n();
                        i31 = i19 - 1;
                    }
                    int i55 = iH6;
                    long j21 = j14 + ((long) iArrCopyOf[i11]);
                    int i56 = i26 - 1;
                    i11++;
                    j12 = j21;
                    iH4 = i54;
                    i15 = iN2;
                    i13 = i56;
                    sampleCount = i27;
                    iN = i53;
                    i17 = i31;
                    i16 = i55;
                }
                long j22 = j11 + ((long) iN);
                if (c0Var5 != null) {
                    z13 = true;
                    break;
                }
                while (true) {
                    if (i14 > 0) {
                        z13 = true;
                        break;
                    }
                    if (c0Var5.H() != 0) {
                        z13 = false;
                        break;
                    }
                    c0Var5.n();
                    i14--;
                }
                if (i18 != 0 && i21 == 0 && i22 == 0 && i19 == 0) {
                    i23 = iH5;
                    if (i23 == 0 && z13) {
                        oVar2 = oVar;
                    }
                    i24 = sampleCount;
                    jArr = jArrCopyOf;
                    iArr = iArrCopyOf;
                    i25 = i12;
                    j13 = j22;
                    jArr2 = jArrCopyOf2;
                    iArr2 = iArrCopyOf2;
                } else {
                    i23 = iH5;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Inconsistent stbl box for track ");
                oVar2 = oVar;
                sb2.append(oVar2.f14229a);
                sb2.append(": remainingSynchronizationSamples ");
                sb2.append(i18);
                sb2.append(", remainingSamplesAtTimestampDelta ");
                sb2.append(i21);
                sb2.append(", remainingSamplesInChunk ");
                sb2.append(i22);
                sb2.append(", remainingTimestampDeltaChanges ");
                sb2.append(i19);
                sb2.append(", remainingSamplesAtTimestampOffset ");
                sb2.append(i23);
                if (z13) {
                    str = "";
                } else {
                    str = ", ctts invalid";
                }
                sb2.append(str);
                s.i("AtomParsers", sb2.toString());
                i24 = sampleCount;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i25 = i12;
                j13 = j22;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            }
            jO0 = o0.O0(j13, 1000000L, oVar2.f14231c);
            jArr3 = oVar2.f14236h;
            if (jArr3 == null) {
                o0.Q0(jArr2, 1000000L, oVar2.f14231c);
                return new r(oVar, jArr, iArr, i25, jArr2, iArr2, jO0);
            }
            if (jArr3.length != 1 && oVar2.f14230b == 1 && jArr2.length >= 2) {
                long j23 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.f14237i))[0];
                long jO1 = j23 + o0.O0(oVar2.f14236h[0], oVar2.f14231c, oVar2.f14232d);
                i32 = i24;
                if (b(jArr2, j13, j23, jO1)) {
                    long jO2 = o0.O0(j23 - jArr2[0], oVar2.f14234f.A, oVar2.f14231c);
                    i33 = i25;
                    long jO3 = o0.O0(j13 - jO1, oVar2.f14234f.A, oVar2.f14231c);
                    if ((jO2 != 0 || jO3 != 0) && jO2 <= 2147483647L && jO3 <= 2147483647L) {
                        xVar.f77096a = (int) jO2;
                        xVar.f77097b = (int) jO3;
                        o0.Q0(jArr2, 1000000L, oVar2.f14231c);
                        return new r(oVar, jArr, iArr, i33, jArr2, iArr2, o0.O0(oVar2.f14236h[0], 1000000L, oVar2.f14232d));
                    }
                }
                jArr4 = oVar2.f14236h;
                if (jArr4.length != 1 && jArr4[0] == 0) {
                    long j24 = ((long[]) com.google.android.exoplayer2.util.a.e(oVar2.f14237i))[0];
                    for (int i57 = 0; i57 < jArr2.length; i57++) {
                        jArr2[i57] = o0.O0(jArr2[i57] - j24, 1000000L, oVar2.f14231c);
                    }
                    return new r(oVar, jArr, iArr, i33, jArr2, iArr2, o0.O0(j13 - j24, 1000000L, oVar2.f14231c));
                }
                if (oVar2.f14230b == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                iArr3 = new int[jArr4.length];
                iArr4 = new int[jArr4.length];
                jArr5 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.f14237i);
                i34 = 0;
                z15 = false;
                i35 = 0;
                i36 = 0;
                while (true) {
                    jArr6 = oVar2.f14236h;
                    if (i34 >= jArr6.length) {
                        break;
                    }
                    long[] jArr13 = jArr;
                    int[] iArr13 = iArr;
                    j17 = jArr5[i34];
                    if (j17 != -1) {
                        i47 = i36;
                        boolean z19 = z15;
                        int i58 = i35;
                        long jO4 = o0.O0(jArr6[i34], oVar2.f14231c, oVar2.f14232d);
                        iArr3[i34] = o0.i(jArr2, j17, true, true);
                        iArr4[i34] = o0.e(jArr2, j17 + jO4, z14, false);
                        while (true) {
                            i48 = iArr3[i34];
                            i46 = iArr4[i34];
                            if (i48 < i46 || (iArr2[i48] & 1) != 0) {
                                break;
                            }
                            iArr3[i34] = i48 + 1;
                        }
                        i35 = i58 + (i46 - i48);
                        if (i47 != i48) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        z17 = z19 | z18;
                    } else {
                        z17 = z15;
                        i46 = i36;
                    }
                    i34++;
                    z15 = z17;
                    i36 = i46;
                    jArr = jArr13;
                    iArr = iArr13;
                }
                jArr7 = jArr;
                iArr5 = iArr;
                boolean z21 = z15;
                i37 = 0;
                z16 = z21 | (i35 != i32);
                if (z16) {
                    jArr8 = new long[i35];
                } else {
                    jArr8 = jArr7;
                }
                if (z16) {
                    iArr6 = new int[i35];
                } else {
                    iArr6 = iArr5;
                }
                if (z16) {
                    i38 = 0;
                } else {
                    i38 = i33;
                }
                if (z16) {
                    iArr7 = new int[i35];
                } else {
                    iArr7 = iArr2;
                }
                jArr9 = new long[i35];
                i39 = i38;
                iArr8 = iArr5;
                j15 = 0;
                i40 = 0;
                while (i37 < oVar2.f14236h.length) {
                    j16 = oVar2.f14237i[i37];
                    i41 = iArr3[i37];
                    int[] iArr14 = iArr3;
                    i42 = iArr4[i37];
                    int[] iArr15 = iArr4;
                    if (z16) {
                        int i59 = i42 - i41;
                        System.arraycopy(jArr7, i41, jArr8, i40, i59);
                        iArr9 = iArr8;
                        System.arraycopy(iArr9, i41, iArr6, i40, i59);
                        System.arraycopy(iArr2, i41, iArr7, i40, i59);
                    } else {
                        iArr9 = iArr8;
                    }
                    i43 = i39;
                    while (i41 < i42) {
                        i44 = i43;
                        int i60 = i42;
                        long[] jArr14 = jArr2;
                        int[] iArr16 = iArr2;
                        int[] iArr17 = iArr7;
                        long j25 = j15;
                        jArr9[i40] = o0.O0(j15, 1000000L, oVar2.f14232d) + o0.O0(Math.max(0L, jArr2[i41] - j16), 1000000L, oVar2.f14231c);
                        if (z16) {
                            i45 = i44;
                            if (iArr6[i40] > i45) {
                                i43 = iArr9[i41];
                            }
                            i40++;
                            i41++;
                            i42 = i60;
                            j15 = j25;
                            jArr2 = jArr14;
                            iArr2 = iArr16;
                            iArr7 = iArr17;
                        } else {
                            i45 = i44;
                        }
                        i43 = i45;
                        i40++;
                        i41++;
                        i42 = i60;
                        j15 = j25;
                        jArr2 = jArr14;
                        iArr2 = iArr16;
                        iArr7 = iArr17;
                    }
                    long[] jArr15 = jArr2;
                    long j26 = j15 + oVar2.f14236h[i37];
                    i37++;
                    i39 = i43;
                    iArr8 = iArr9;
                    j15 = j26;
                    iArr3 = iArr14;
                    jArr2 = jArr15;
                    iArr2 = iArr2;
                    iArr4 = iArr15;
                    jArr7 = jArr7;
                    iArr7 = iArr7;
                }
                return new r(oVar, jArr8, iArr6, i39, jArr9, iArr7, o0.O0(j15, 1000000L, oVar2.f14232d));
            }
            i32 = i24;
            i33 = i25;
            jArr4 = oVar2.f14236h;
            if (jArr4.length != 1) {
            }
            if (oVar2.f14230b == 1) {
                z14 = true;
            } else {
                z14 = false;
            }
            iArr3 = new int[jArr4.length];
            iArr4 = new int[jArr4.length];
            jArr5 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.f14237i);
            i34 = 0;
            z15 = false;
            i35 = 0;
            i36 = 0;
            while (true) {
                jArr6 = oVar2.f14236h;
                if (i34 >= jArr6.length) {
                    break;
                    break;
                }
                long[] jArr16 = jArr;
                int[] iArr18 = iArr;
                j17 = jArr5[i34];
                if (j17 != -1) {
                    i47 = i36;
                    boolean z110 = z15;
                    int i510 = i35;
                    long jO5 = o0.O0(jArr6[i34], oVar2.f14231c, oVar2.f14232d);
                    iArr3[i34] = o0.i(jArr2, j17, true, true);
                    iArr4[i34] = o0.e(jArr2, j17 + jO5, z14, false);
                    while (true) {
                        i48 = iArr3[i34];
                        i46 = iArr4[i34];
                        if (i48 < i46) {
                            break;
                        }
                        break;
                        break;
                        iArr3[i34] = i48 + 1;
                    }
                    i35 = i510 + (i46 - i48);
                    if (i47 != i48) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    z17 = z110 | z18;
                } else {
                    z17 = z15;
                    i46 = i36;
                }
                i34++;
                z15 = z17;
                i36 = i46;
                jArr = jArr16;
                iArr = iArr18;
            }
            jArr7 = jArr;
            iArr5 = iArr;
            boolean z22 = z15;
            i37 = 0;
            z16 = z22 | (i35 != i32);
            if (z16) {
                jArr8 = new long[i35];
            } else {
                jArr8 = jArr7;
            }
            if (z16) {
                iArr6 = new int[i35];
            } else {
                iArr6 = iArr5;
            }
            if (z16) {
                i38 = 0;
            } else {
                i38 = i33;
            }
            if (z16) {
                iArr7 = new int[i35];
            } else {
                iArr7 = iArr2;
            }
            jArr9 = new long[i35];
            i39 = i38;
            iArr8 = iArr5;
            j15 = 0;
            i40 = 0;
            while (i37 < oVar2.f14236h.length) {
                j16 = oVar2.f14237i[i37];
                i41 = iArr3[i37];
                int[] iArr19 = iArr3;
                i42 = iArr4[i37];
                int[] iArr110 = iArr4;
                if (z16) {
                    int i511 = i42 - i41;
                    System.arraycopy(jArr7, i41, jArr8, i40, i511);
                    iArr9 = iArr8;
                    System.arraycopy(iArr9, i41, iArr6, i40, i511);
                    System.arraycopy(iArr2, i41, iArr7, i40, i511);
                } else {
                    iArr9 = iArr8;
                }
                i43 = i39;
                while (i41 < i42) {
                    i44 = i43;
                    int i61 = i42;
                    long[] jArr17 = jArr2;
                    int[] iArr111 = iArr2;
                    int[] iArr112 = iArr7;
                    long j27 = j15;
                    jArr9[i40] = o0.O0(j15, 1000000L, oVar2.f14232d) + o0.O0(Math.max(0L, jArr2[i41] - j16), 1000000L, oVar2.f14231c);
                    if (z16) {
                        i45 = i44;
                        if (iArr6[i40] > i45) {
                            i43 = iArr9[i41];
                        }
                        i40++;
                        i41++;
                        i42 = i61;
                        j15 = j27;
                        jArr2 = jArr17;
                        iArr2 = iArr111;
                        iArr7 = iArr112;
                    } else {
                        i45 = i44;
                    }
                    i43 = i45;
                    i40++;
                    i41++;
                    i42 = i61;
                    j15 = j27;
                    jArr2 = jArr17;
                    iArr2 = iArr111;
                    iArr7 = iArr112;
                }
                long[] jArr18 = jArr2;
                long j28 = j15 + oVar2.f14236h[i37];
                i37++;
                i39 = i43;
                iArr8 = iArr9;
                j15 = j28;
                iArr3 = iArr19;
                jArr2 = jArr18;
                iArr2 = iArr2;
                iArr4 = iArr110;
                jArr7 = jArr7;
                iArr7 = iArr7;
            }
            return new r(oVar, jArr8, iArr6, i39, jArr9, iArr7, o0.O0(j15, 1000000L, oVar2.f14232d));
        }
        iH2 = 0;
        iH3 = -1;
        iA = fVar.a();
        String str3 = oVar.f14234f.f33445m;
        if (iA == -1) {
            z12 = false;
        } else {
            z12 = false;
        }
        if (z12) {
            int i410 = aVar.f14106a;
            jArr10 = new long[i410];
            iArr10 = new int[i410];
            while (aVar.a()) {
                int i512 = aVar.f14107b;
                jArr10[i512] = aVar.f14109d;
                iArr10[i512] = aVar.f14108c;
            }
            bh.d.b bVarA2 = bh.d.a(iA, jArr10, iArr10, iH9);
            long[] jArr19 = bVarA2.f14138a;
            int[] iArr113 = bVarA2.f14139b;
            int i513 = bVarA2.f14140c;
            long[] jArr110 = bVarA2.f14141d;
            int[] iArr114 = bVarA2.f14142e;
            long j110 = bVarA2.f14143f;
            oVar2 = oVar;
            i24 = sampleCount;
            jArr = jArr19;
            iArr = iArr113;
            i25 = i513;
            iArr2 = iArr114;
            j13 = j110;
            jArr2 = jArr110;
        } else {
            jArrCopyOf = new long[sampleCount];
            iArrCopyOf = new int[sampleCount];
            jArrCopyOf2 = new long[sampleCount];
            iArrCopyOf2 = new int[sampleCount];
            iH4 = iH3;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            iN = 0;
            iH5 = 0;
            j11 = 0;
            j12 = 0;
            i14 = iH;
            i15 = iH9;
            i16 = iH8;
            i17 = iH7;
            i18 = iH2;
            while (true) {
                i19 = i17;
                if (i11 < sampleCount) {
                    i21 = i16;
                    i22 = i13;
                    break;
                }
                j14 = j12;
                i26 = i13;
                zA = true;
                while (i26 == 0) {
                    zA = aVar.a();
                    if (zA) {
                        break;
                        break;
                    }
                    int i514 = i16;
                    long j111 = aVar.f14109d;
                    i26 = aVar.f14108c;
                    j14 = j111;
                    i16 = i514;
                    i15 = i15;
                    sampleCount = sampleCount;
                }
                i27 = sampleCount;
                i21 = i16;
                i28 = i15;
                if (!zA) {
                    s.i("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                    sampleCount = i11;
                    i22 = i26;
                    break;
                }
                if (c0Var5 != null) {
                    while (iH5 == 0) {
                        iH5 = c0Var5.H();
                        iN = c0Var5.n();
                        i14--;
                    }
                    iH5--;
                }
                int i515 = iN;
                jArrCopyOf[i11] = j14;
                nextSampleSize = fVar.readNextSampleSize();
                iArrCopyOf[i11] = nextSampleSize;
                if (nextSampleSize > i12) {
                    i12 = nextSampleSize;
                }
                jArrCopyOf2[i11] = j11 + ((long) i515);
                if (c0Var4 == null) {
                    i29 = 1;
                } else {
                    i29 = 0;
                }
                iArrCopyOf2[i11] = i29;
                if (i11 == iH4) {
                    iArrCopyOf2[i11] = 1;
                    i18--;
                    if (i18 > 0) {
                        iH4 = ((c0) com.google.android.exoplayer2.util.a.e(c0Var4)).H() - 1;
                    }
                }
                int i516 = iH4;
                j11 += (long) i28;
                iH6 = i21 - 1;
                if (iH6 == 0) {
                    iN2 = i28;
                    i31 = i19;
                } else {
                    iN2 = i28;
                    i31 = i19;
                }
                int i517 = iH6;
                long j29 = j14 + ((long) iArrCopyOf[i11]);
                int i518 = i26 - 1;
                i11++;
                j12 = j29;
                iH4 = i516;
                i15 = iN2;
                i13 = i518;
                sampleCount = i27;
                iN = i515;
                i17 = i31;
                i16 = i517;
            }
            long j210 = j11 + ((long) iN);
            if (c0Var5 != null) {
                z13 = true;
                break;
            }
            while (true) {
                if (i14 > 0) {
                    z13 = true;
                    break;
                }
                if (c0Var5.H() != 0) {
                    z13 = false;
                    break;
                }
                c0Var5.n();
                i14--;
            }
            if (i18 != 0) {
                i23 = iH5;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Inconsistent stbl box for track ");
                oVar2 = oVar;
                sb3.append(oVar2.f14229a);
                sb3.append(": remainingSynchronizationSamples ");
                sb3.append(i18);
                sb3.append(", remainingSamplesAtTimestampDelta ");
                sb3.append(i21);
                sb3.append(", remainingSamplesInChunk ");
                sb3.append(i22);
                sb3.append(", remainingTimestampDeltaChanges ");
                sb3.append(i19);
                sb3.append(", remainingSamplesAtTimestampOffset ");
                sb3.append(i23);
                if (z13) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb3.append(str);
                s.i("AtomParsers", sb3.toString());
            } else {
                i23 = iH5;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Inconsistent stbl box for track ");
                oVar2 = oVar;
                sb4.append(oVar2.f14229a);
                sb4.append(": remainingSynchronizationSamples ");
                sb4.append(i18);
                sb4.append(", remainingSamplesAtTimestampDelta ");
                sb4.append(i21);
                sb4.append(", remainingSamplesInChunk ");
                sb4.append(i22);
                sb4.append(", remainingTimestampDeltaChanges ");
                sb4.append(i19);
                sb4.append(", remainingSamplesAtTimestampOffset ");
                sb4.append(i23);
                if (z13) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                sb4.append(str);
                s.i("AtomParsers", sb4.toString());
            }
            i24 = sampleCount;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i25 = i12;
            j13 = j210;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        jO0 = o0.O0(j13, 1000000L, oVar2.f14231c);
        jArr3 = oVar2.f14236h;
        if (jArr3 == null) {
            o0.Q0(jArr2, 1000000L, oVar2.f14231c);
            return new r(oVar, jArr, iArr, i25, jArr2, iArr2, jO0);
        }
        if (jArr3.length != 1) {
            i32 = i24;
            i33 = i25;
        } else {
            i32 = i24;
            i33 = i25;
        }
        jArr4 = oVar2.f14236h;
        if (jArr4.length != 1) {
        }
        if (oVar2.f14230b == 1) {
            z14 = true;
        } else {
            z14 = false;
        }
        iArr3 = new int[jArr4.length];
        iArr4 = new int[jArr4.length];
        jArr5 = (long[]) com.google.android.exoplayer2.util.a.e(oVar2.f14237i);
        i34 = 0;
        z15 = false;
        i35 = 0;
        i36 = 0;
        while (true) {
            jArr6 = oVar2.f14236h;
            if (i34 >= jArr6.length) {
                break;
                break;
            }
            long[] jArr111 = jArr;
            int[] iArr115 = iArr;
            j17 = jArr5[i34];
            if (j17 != -1) {
                i47 = i36;
                boolean z111 = z15;
                int i519 = i35;
                long jO6 = o0.O0(jArr6[i34], oVar2.f14231c, oVar2.f14232d);
                iArr3[i34] = o0.i(jArr2, j17, true, true);
                iArr4[i34] = o0.e(jArr2, j17 + jO6, z14, false);
                while (true) {
                    i48 = iArr3[i34];
                    i46 = iArr4[i34];
                    if (i48 < i46) {
                        break;
                        break;
                    }
                    break;
                    break;
                    iArr3[i34] = i48 + 1;
                }
                i35 = i519 + (i46 - i48);
                if (i47 != i48) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                z17 = z111 | z18;
            } else {
                z17 = z15;
                i46 = i36;
            }
            i34++;
            z15 = z17;
            i36 = i46;
            jArr = jArr111;
            iArr = iArr115;
        }
        jArr7 = jArr;
        iArr5 = iArr;
        boolean z23 = z15;
        i37 = 0;
        z16 = z23 | (i35 != i32);
        if (z16) {
            jArr8 = new long[i35];
        } else {
            jArr8 = jArr7;
        }
        if (z16) {
            iArr6 = new int[i35];
        } else {
            iArr6 = iArr5;
        }
        if (z16) {
            i38 = 0;
        } else {
            i38 = i33;
        }
        if (z16) {
            iArr7 = new int[i35];
        } else {
            iArr7 = iArr2;
        }
        jArr9 = new long[i35];
        i39 = i38;
        iArr8 = iArr5;
        j15 = 0;
        i40 = 0;
        while (i37 < oVar2.f14236h.length) {
            j16 = oVar2.f14237i[i37];
            i41 = iArr3[i37];
            int[] iArr116 = iArr3;
            i42 = iArr4[i37];
            int[] iArr117 = iArr4;
            if (z16) {
                int i5110 = i42 - i41;
                System.arraycopy(jArr7, i41, jArr8, i40, i5110);
                iArr9 = iArr8;
                System.arraycopy(iArr9, i41, iArr6, i40, i5110);
                System.arraycopy(iArr2, i41, iArr7, i40, i5110);
            } else {
                iArr9 = iArr8;
            }
            i43 = i39;
            while (i41 < i42) {
                i44 = i43;
                int i62 = i42;
                long[] jArr112 = jArr2;
                int[] iArr118 = iArr2;
                int[] iArr119 = iArr7;
                long j211 = j15;
                jArr9[i40] = o0.O0(j15, 1000000L, oVar2.f14232d) + o0.O0(Math.max(0L, jArr2[i41] - j16), 1000000L, oVar2.f14231c);
                if (z16) {
                    i45 = i44;
                    if (iArr6[i40] > i45) {
                        i43 = iArr9[i41];
                    }
                    i40++;
                    i41++;
                    i42 = i62;
                    j15 = j211;
                    jArr2 = jArr112;
                    iArr2 = iArr118;
                    iArr7 = iArr119;
                } else {
                    i45 = i44;
                }
                i43 = i45;
                i40++;
                i41++;
                i42 = i62;
                j15 = j211;
                jArr2 = jArr112;
                iArr2 = iArr118;
                iArr7 = iArr119;
            }
            long[] jArr113 = jArr2;
            long j212 = j15 + oVar2.f14236h[i37];
            i37++;
            i39 = i43;
            iArr8 = iArr9;
            j15 = j212;
            iArr3 = iArr116;
            jArr2 = jArr113;
            iArr2 = iArr2;
            iArr4 = iArr117;
            jArr7 = jArr7;
            iArr7 = iArr7;
        }
        return new r(oVar, jArr8, iArr6, i39, jArr9, iArr7, o0.O0(j15, 1000000L, oVar2.f14232d));
    }

    public static d w(c0 c0Var, int i11, int i12, String str, @Nullable DrmInitData drmInitData, boolean z11) throws ParserException {
        int i13;
        c0Var.P(12);
        int iN = c0Var.n();
        d dVar = new d(iN);
        for (int i14 = 0; i14 < iN; i14++) {
            int iE = c0Var.e();
            int iN2 = c0Var.n();
            tg.o.a(iN2 > 0, "childAtomSize must be positive");
            int iN3 = c0Var.n();
            if (iN3 == 1635148593 || iN3 == 1635148595 || iN3 == 1701733238 || iN3 == 1831958048 || iN3 == 1836070006 || iN3 == 1752589105 || iN3 == 1751479857 || iN3 == 1932670515 || iN3 == 1211250227 || iN3 == 1987063864 || iN3 == 1987063865 || iN3 == 1635135537 || iN3 == 1685479798 || iN3 == 1685479729 || iN3 == 1685481573 || iN3 == 1685481521) {
                i13 = iE;
                D(c0Var, iN3, i13, iN2, i11, i12, drmInitData, dVar, i14);
            } else if (iN3 == 1836069985 || iN3 == 1701733217 || iN3 == 1633889587 || iN3 == 1700998451 || iN3 == 1633889588 || iN3 == 1835823201 || iN3 == 1685353315 || iN3 == 1685353317 || iN3 == 1685353320 || iN3 == 1685353324 || iN3 == 1685353336 || iN3 == 1935764850 || iN3 == 1935767394 || iN3 == 1819304813 || iN3 == 1936684916 || iN3 == 1953984371 || iN3 == 778924082 || iN3 == 778924083 || iN3 == 1835557169 || iN3 == 1835560241 || iN3 == 1634492771 || iN3 == 1634492791 || iN3 == 1970037111 || iN3 == 1332770163 || iN3 == 1716281667) {
                i13 = iE;
                f(c0Var, iN3, iE, iN2, i11, str, z11, drmInitData, dVar, i14);
            } else {
                if (iN3 == 1414810956 || iN3 == 1954034535 || iN3 == 2004251764 || iN3 == 1937010800 || iN3 == 1664495672) {
                    x(c0Var, iN3, iE, iN2, i11, str, dVar);
                } else if (iN3 == 1835365492) {
                    o(c0Var, iN3, iE, i11, dVar);
                } else if (iN3 == 1667329389) {
                    dVar.f14120b = new m1.b().R(i11).e0(MimeTypes.APPLICATION_CAMERA_MOTION).E();
                }
                i13 = iE;
            }
            c0Var.P(i13 + iN2);
        }
        return dVar;
    }

    public static void x(c0 c0Var, int i11, int i12, int i13, int i14, String str, d dVar) {
        c0Var.P(i12 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableListOf = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = i13 - 16;
                byte[] bArr = new byte[i15];
                c0Var.j(bArr, 0, i15);
                immutableListOf = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == 1937010800) {
                j11 = 0;
            } else {
                if (i11 != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.f14122d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        dVar.f14120b = new m1.b().R(i14).e0(str2).V(str).i0(j11).T(immutableListOf).E();
    }

    public static g y(c0 c0Var) {
        long j11;
        c0Var.P(8);
        int iC = bh.a.c(c0Var.n());
        c0Var.Q(iC == 0 ? 8 : 16);
        int iN = c0Var.n();
        c0Var.Q(4);
        int iE = c0Var.e();
        int i11 = iC == 0 ? 4 : 8;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i13 >= i11) {
                c0Var.Q(i11);
                break;
            }
            if (c0Var.d()[iE + i13] != -1) {
                long jF = iC == 0 ? c0Var.F() : c0Var.I();
                if (jF == 0) {
                    break;
                }
                j11 = jF;
                break;
            }
            i13++;
        }
        c0Var.Q(16);
        int iN2 = c0Var.n();
        int iN3 = c0Var.n();
        c0Var.Q(4);
        int iN4 = c0Var.n();
        int iN5 = c0Var.n();
        if (iN2 == 0 && iN3 == 65536 && iN4 == -65536 && iN5 == 0) {
            i12 = 90;
        } else if (iN2 == 0 && iN3 == -65536 && iN4 == 65536 && iN5 == 0) {
            i12 = 270;
        } else if (iN2 == -65536 && iN3 == 0 && iN4 == 0 && iN5 == -65536) {
            i12 = 180;
        }
        return new g(iN, j11, i12);
    }

    @Nullable
    public static o z(bh.a.C0144a c0144a, bh.a.b bVar, long j11, @Nullable DrmInitData drmInitData, boolean z11, boolean z12) throws ParserException {
        long[] jArr;
        long[] jArr2;
        bh.a.C0144a c0144aF;
        Pair<long[], long[]> pairH;
        bh.a.C0144a c0144a2 = (bh.a.C0144a) com.google.android.exoplayer2.util.a.e(c0144a.f(1835297121));
        int iD = d(k(((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a2.g(1751411826))).f14104b));
        if (iD == -1) {
            return null;
        }
        g gVarY = y(((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a.g(1953196132))).f14104b);
        long jO0 = C.TIME_UNSET;
        long j12 = j11 == C.TIME_UNSET ? gVarY.f14132b : j11;
        long jP = p(bVar.f14104b);
        if (j12 != C.TIME_UNSET) {
            jO0 = o0.O0(j12, 1000000L, jP);
        }
        long j13 = jO0;
        bh.a.C0144a c0144a3 = (bh.a.C0144a) com.google.android.exoplayer2.util.a.e(((bh.a.C0144a) com.google.android.exoplayer2.util.a.e(c0144a2.f(1835626086))).f(1937007212));
        Pair<Long, String> pairM = m(((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a2.g(1835296868))).f14104b);
        d dVarW = w(((bh.a.b) com.google.android.exoplayer2.util.a.e(c0144a3.g(1937011556))).f14104b, gVarY.f14131a, gVarY.f14133c, (String) pairM.second, drmInitData, z12);
        if (z11 || (c0144aF = c0144a.f(1701082227)) == null || (pairH = h(c0144aF)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairH.first;
            jArr2 = (long[]) pairH.second;
            jArr = jArr3;
        }
        if (dVarW.f14120b == null) {
            return null;
        }
        return new o(gVarY.f14131a, iD, ((Long) pairM.first).longValue(), jP, j13, dVarW.f14120b, dVarW.f14122d, dVarW.f14119a, dVarW.f14121c, jArr, jArr2);
    }
}

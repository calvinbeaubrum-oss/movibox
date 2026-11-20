package l5;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.y;
import androidx.media3.container.MdtaMetadataEntry;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.container.Mp4TimestampData;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.mvel2.ast.ASTNode;
import u4.f0;
import u4.g0;
import u4.k0;
import u4.v;
import z3.b0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f69802a = u0.w0("OpusHead");

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f69805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f69806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f69807e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f69808f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c0 f69809g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f69810h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f69811i;

        public a(c0 c0Var, c0 c0Var2, boolean z11) throws ParserException {
            this.f69809g = c0Var;
            this.f69808f = c0Var2;
            this.f69807e = z11;
            c0Var2.U(12);
            this.f69803a = c0Var2.L();
            c0Var.U(12);
            this.f69811i = c0Var.L();
            v.a(c0Var.q() == 1, "first_chunk must be 1");
            this.f69804b = -1;
        }

        public boolean a() {
            int i11 = this.f69804b + 1;
            this.f69804b = i11;
            if (i11 == this.f69803a) {
                return false;
            }
            this.f69806d = this.f69807e ? this.f69808f.M() : this.f69808f.J();
            if (this.f69804b == this.f69810h) {
                this.f69805c = this.f69809g.L();
                this.f69809g.V(4);
                int i12 = this.f69811i - 1;
                this.f69811i = i12;
                this.f69810h = i12 > 0 ? this.f69809g.L() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: l5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0750b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f69812a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f69813b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f69814c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f69815d;

        public C0750b(String str, byte[] bArr, long j11, long j12) {
            this.f69812a = str;
            this.f69813b = bArr;
            this.f69814c = j11;
            this.f69815d = j12;
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
        public final q[] f69816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public y f69817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f69818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f69819d = 0;

        public d(int i11) {
            this.f69816a = new q[i11];
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f69821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f69822c;

        public e(l5.a.b bVar, y yVar) {
            c0 c0Var = bVar.f69801b;
            this.f69822c = c0Var;
            c0Var.U(12);
            int iL = c0Var.L();
            if (MimeTypes.AUDIO_RAW.equals(yVar.f9501m)) {
                int iL0 = u0.l0(yVar.B, yVar.f9514z);
                if (iL == 0 || iL % iL0 != 0) {
                    z3.o.h("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iL0 + ", stsz sample size: " + iL);
                    iL = iL0;
                }
            }
            this.f69820a = iL == 0 ? -1 : iL;
            this.f69821b = c0Var.L();
        }

        @Override // l5.b.c
        public int a() {
            return this.f69820a;
        }

        @Override // l5.b.c
        public int getSampleCount() {
            return this.f69821b;
        }

        @Override // l5.b.c
        public int readNextSampleSize() {
            int i11 = this.f69820a;
            return i11 == -1 ? this.f69822c.L() : i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f69823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f69824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69825c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f69826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f69827e;

        public f(l5.a.b bVar) {
            c0 c0Var = bVar.f69801b;
            this.f69823a = c0Var;
            c0Var.U(12);
            this.f69825c = c0Var.L() & 255;
            this.f69824b = c0Var.L();
        }

        @Override // l5.b.c
        public int a() {
            return -1;
        }

        @Override // l5.b.c
        public int getSampleCount() {
            return this.f69824b;
        }

        @Override // l5.b.c
        public int readNextSampleSize() {
            int i11 = this.f69825c;
            if (i11 == 8) {
                return this.f69823a.H();
            }
            if (i11 == 16) {
                return this.f69823a.N();
            }
            int i12 = this.f69826d;
            this.f69826d = i12 + 1;
            if (i12 % 2 != 0) {
                return this.f69827e & 15;
            }
            int iH = this.f69823a.H();
            this.f69827e = iH;
            return (iH & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f69828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f69829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f69830c;

        public g(int i11, long j11, int i12) {
            this.f69828a = i11;
            this.f69829b = j11;
            this.f69830c = i12;
        }
    }

    @Nullable
    public static p A(l5.a.C0749a c0749a, l5.a.b bVar, long j11, @Nullable DrmInitData drmInitData, boolean z11, boolean z12) throws ParserException {
        long[] jArr;
        long[] jArr2;
        l5.a.C0749a c0749aF;
        Pair<long[], long[]> pairJ;
        l5.a.C0749a c0749a2 = (l5.a.C0749a) z3.a.e(c0749a.f(1835297121));
        int iE = e(m(((l5.a.b) z3.a.e(c0749a2.g(1751411826))).f69801b));
        if (iE == -1) {
            return null;
        }
        g gVarZ = z(((l5.a.b) z3.a.e(c0749a.g(1953196132))).f69801b);
        long jF1 = C.TIME_UNSET;
        long j12 = j11 == C.TIME_UNSET ? gVarZ.f69829b : j11;
        long j13 = r(bVar.f69801b).timescale;
        if (j12 != C.TIME_UNSET) {
            jF1 = u0.f1(j12, 1000000L, j13);
        }
        long j14 = jF1;
        l5.a.C0749a c0749a3 = (l5.a.C0749a) z3.a.e(((l5.a.C0749a) z3.a.e(c0749a2.f(1835626086))).f(1937007212));
        Pair<Long, String> pairO = o(((l5.a.b) z3.a.e(c0749a2.g(1835296868))).f69801b);
        l5.a.b bVarG = c0749a3.g(1937011556);
        if (bVarG == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        d dVarX = x(bVarG.f69801b, gVarZ.f69828a, gVarZ.f69830c, (String) pairO.second, drmInitData, z12);
        if (z11 || (c0749aF = c0749a.f(1701082227)) == null || (pairJ = j(c0749aF)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairJ.first;
            jArr2 = (long[]) pairJ.second;
            jArr = jArr3;
        }
        if (dVarX.f69817b == null) {
            return null;
        }
        return new p(gVarZ.f69828a, iE, ((Long) pairO.first).longValue(), j13, j14, dVarX.f69817b, dVarX.f69819d, dVarX.f69816a, dVarX.f69818c, jArr, jArr2);
    }

    public static List<s> B(l5.a.C0749a c0749a, f0 f0Var, long j11, @Nullable DrmInitData drmInitData, boolean z11, boolean z12, com.google.common.base.f<p, p> fVar) throws ParserException {
        p pVarApply;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < c0749a.f69800d.size(); i11++) {
            l5.a.C0749a c0749a2 = c0749a.f69800d.get(i11);
            if (c0749a2.f69797a == 1953653099 && (pVarApply = fVar.apply(A(c0749a2, (l5.a.b) z3.a.e(c0749a.g(1836476516)), j11, drmInitData, z11, z12))) != null) {
                arrayList.add(w(pVarApply, (l5.a.C0749a) z3.a.e(((l5.a.C0749a) z3.a.e(((l5.a.C0749a) z3.a.e(c0749a2.f(1835297121))).f(1835626086))).f(1937007212)), f0Var));
            }
        }
        return arrayList;
    }

    public static Metadata C(l5.a.b bVar) {
        c0 c0Var = bVar.f69801b;
        c0Var.U(8);
        Metadata metadata = new Metadata(new Metadata.Entry[0]);
        while (c0Var.a() >= 8) {
            int iF = c0Var.f();
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            if (iQ2 == 1835365473) {
                c0Var.U(iF);
                metadata = metadata.copyWithAppendedEntriesFrom(D(c0Var, iF + iQ));
            } else if (iQ2 == 1936553057) {
                c0Var.U(iF);
                metadata = metadata.copyWithAppendedEntriesFrom(n.b(c0Var, iF + iQ));
            } else if (iQ2 == -1451722374) {
                metadata = metadata.copyWithAppendedEntriesFrom(F(c0Var));
            }
            c0Var.U(iF + iQ);
        }
        return metadata;
    }

    @Nullable
    public static Metadata D(c0 c0Var, int i11) {
        c0Var.V(8);
        f(c0Var);
        while (c0Var.f() < i11) {
            int iF = c0Var.f();
            int iQ = c0Var.q();
            if (c0Var.q() == 1768715124) {
                c0Var.U(iF);
                return n(c0Var, iF + iQ);
            }
            c0Var.U(iF + iQ);
        }
        return null;
    }

    public static void E(c0 c0Var, int i11, int i12, int i13, int i14, int i15, @Nullable DrmInitData drmInitData, d dVar, int i16) throws ParserException {
        String str;
        int i17;
        float f11;
        int i18;
        int i19;
        int i21;
        String str2;
        int i22 = i12;
        int i23 = i13;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        d dVar2 = dVar;
        c0Var.U(i22 + 16);
        c0Var.V(16);
        int iN = c0Var.N();
        int iN2 = c0Var.N();
        c0Var.V(50);
        int iF = c0Var.f();
        int iIntValue = i11;
        if (iIntValue == 1701733238) {
            Pair<Integer, q> pairU = u(c0Var, i22, i23);
            if (pairU != null) {
                iIntValue = ((Integer) pairU.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((q) pairU.second).f69940b);
                dVar2.f69816a[i16] = (q) pairU.second;
            }
            c0Var.U(iF);
        }
        String str3 = MimeTypes.VIDEO_H263;
        if (iIntValue == 1831958048) {
            str = MimeTypes.VIDEO_MPEG;
        } else {
            str = iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        }
        float fS = 1.0f;
        int i24 = 8;
        int i25 = 8;
        List<byte[]> listOf = null;
        String str4 = null;
        byte[] bArrT = null;
        int i26 = -1;
        int iL = -1;
        int i27 = -1;
        int iM = -1;
        ByteBuffer byteBufferA = null;
        C0750b c0750bK = null;
        boolean z11 = false;
        while (iF - i22 < i23) {
            c0Var.U(iF);
            int iF2 = c0Var.f();
            int iQ = c0Var.q();
            if (iQ == 0 && c0Var.f() - i22 == i23) {
                break;
            }
            v.a(iQ > 0, "childAtomSize must be positive");
            int iQ2 = c0Var.q();
            if (iQ2 == 1635148611) {
                v.a(str == null, null);
                c0Var.U(iF2 + 8);
                u4.d dVarB = u4.d.b(c0Var);
                List<byte[]> list = dVarB.f78233a;
                dVar2.f69818c = dVarB.f78234b;
                if (!z11) {
                    fS = dVarB.f78242j;
                }
                String str5 = dVarB.f78243k;
                int i28 = dVarB.f78239g;
                int i29 = dVarB.f78240h;
                int i31 = dVarB.f78241i;
                int i32 = dVarB.f78237e;
                str4 = str5;
                iL = i28;
                i27 = i29;
                iM = i31;
                i25 = dVarB.f78238f;
                i24 = i32;
                str2 = MimeTypes.VIDEO_H264;
                listOf = list;
            } else {
                if (iQ2 == 1752589123) {
                    v.a(str == null, null);
                    c0Var.U(iF2 + 8);
                    g0 g0VarA = g0.a(c0Var);
                    List<byte[]> list2 = g0VarA.f78272a;
                    dVar2.f69818c = g0VarA.f78273b;
                    if (!z11) {
                        fS = g0VarA.f78281j;
                    }
                    String str6 = g0VarA.f78282k;
                    int i33 = g0VarA.f78278g;
                    int i34 = g0VarA.f78279h;
                    int i35 = g0VarA.f78280i;
                    i24 = g0VarA.f78276e;
                    int i36 = g0VarA.f78277f;
                    drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                    str4 = str6;
                    iIntValue = iIntValue;
                    iL = i33;
                    i27 = i34;
                    iM = i35;
                    str = MimeTypes.VIDEO_H265;
                    i25 = i36;
                    listOf = list2;
                } else {
                    if (iQ2 == 1685480259 || iQ2 == 1685485123) {
                        drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                        iIntValue = iIntValue;
                        i17 = i25;
                        f11 = fS;
                        i18 = i24;
                        i19 = iL;
                        i21 = iM;
                        u4.n nVarA = u4.n.a(c0Var);
                        if (nVarA != null) {
                            str4 = nVarA.f78351c;
                            str = "video/dolby-vision";
                        }
                    } else if (iQ2 == 1987076931) {
                        v.a(str == null, null);
                        String str7 = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                        c0Var.U(iF2 + 12);
                        c0Var.V(2);
                        int iH = c0Var.H();
                        int i37 = iH >> 4;
                        boolean z12 = (iH & 1) != 0;
                        int iH2 = c0Var.H();
                        int iH3 = c0Var.H();
                        iL = androidx.media3.common.k.l(iH2);
                        i27 = z12 ? 1 : 2;
                        iM = androidx.media3.common.k.m(iH3);
                        drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                        i25 = i37;
                        i24 = i25;
                        iIntValue = iIntValue;
                        str = str7;
                    } else if (iQ2 == 1635135811) {
                        c0Var.U(iF2 + 8);
                        androidx.media3.common.k kVarH = h(c0Var);
                        int i38 = kVarH.f9269e;
                        int i39 = kVarH.f9270f;
                        int i40 = kVarH.f9265a;
                        int i41 = kVarH.f9266b;
                        iM = kVarH.f9267c;
                        i24 = i38;
                        iL = i40;
                        i27 = i41;
                        str2 = "video/av01";
                        i25 = i39;
                    } else if (iQ2 == 1668050025) {
                        if (byteBufferA == null) {
                            byteBufferA = a();
                        }
                        ByteBuffer byteBuffer = byteBufferA;
                        byteBuffer.position(21);
                        byteBuffer.putShort(c0Var.D());
                        byteBuffer.putShort(c0Var.D());
                        byteBufferA = byteBuffer;
                    } else if (iQ2 == 1835295606) {
                        if (byteBufferA == null) {
                            byteBufferA = a();
                        }
                        ByteBuffer byteBuffer2 = byteBufferA;
                        short sD = c0Var.D();
                        short sD2 = c0Var.D();
                        short sD3 = c0Var.D();
                        short sD4 = c0Var.D();
                        short sD5 = c0Var.D();
                        int i42 = i25;
                        short sD6 = c0Var.D();
                        int i43 = i24;
                        short sD7 = c0Var.D();
                        short sD8 = c0Var.D();
                        long J = c0Var.J();
                        long J2 = c0Var.J();
                        byteBuffer2.position(1);
                        byteBuffer2.putShort(sD5);
                        byteBuffer2.putShort(sD6);
                        byteBuffer2.putShort(sD);
                        byteBuffer2.putShort(sD2);
                        byteBuffer2.putShort(sD3);
                        byteBuffer2.putShort(sD4);
                        byteBuffer2.putShort(sD7);
                        byteBuffer2.putShort(sD8);
                        byteBuffer2.putShort((short) (J / 10000));
                        byteBuffer2.putShort((short) (J2 / 10000));
                        byteBufferA = byteBuffer2;
                        i25 = i42;
                        i24 = i43;
                        fS = fS;
                    } else {
                        drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
                        iIntValue = iIntValue;
                        i17 = i25;
                        f11 = fS;
                        i18 = i24;
                        if (iQ2 == 1681012275) {
                            v.a(str == null, null);
                            str = str3;
                        } else if (iQ2 == 1702061171) {
                            v.a(str == null, null);
                            c0750bK = k(c0Var, iF2);
                            String str8 = c0750bK.f69812a;
                            byte[] bArr = c0750bK.f69813b;
                            if (bArr != null) {
                                listOf = ImmutableList.of(bArr);
                            }
                            str = str8;
                        } else if (iQ2 == 1885434736) {
                            fS = s(c0Var, iF2);
                            i25 = i17;
                            i24 = i18;
                            z11 = true;
                        } else if (iQ2 == 1937126244) {
                            bArrT = t(c0Var, iF2, iQ);
                        } else if (iQ2 == 1936995172) {
                            int iH4 = c0Var.H();
                            c0Var.V(3);
                            if (iH4 == 0) {
                                int iH5 = c0Var.H();
                                if (iH5 == 0) {
                                    i26 = 0;
                                } else if (iH5 == 1) {
                                    i26 = 1;
                                } else if (iH5 == 2) {
                                    i26 = 2;
                                } else if (iH5 == 3) {
                                    i26 = 3;
                                }
                            }
                        } else if (iQ2 == 1668246642) {
                            i19 = iL;
                            i21 = iM;
                            if (i19 == -1 && i21 == -1) {
                                int iQ3 = c0Var.q();
                                if (iQ3 == 1852009592 || iQ3 == 1852009571) {
                                    int iN3 = c0Var.N();
                                    int iN4 = c0Var.N();
                                    c0Var.V(2);
                                    boolean z13 = iQ == 19 && (c0Var.H() & 128) != 0;
                                    iL = androidx.media3.common.k.l(iN3);
                                    i27 = z13 ? 1 : 2;
                                    iM = androidx.media3.common.k.m(iN4);
                                } else {
                                    z3.o.h("AtomParsers", "Unsupported color type: " + l5.a.a(iQ3));
                                }
                            }
                            i25 = i17;
                            i24 = i18;
                            fS = f11;
                        } else {
                            i19 = iL;
                            i21 = iM;
                        }
                        i25 = i17;
                        i24 = i18;
                        fS = f11;
                    }
                    iL = i19;
                    iM = i21;
                    i25 = i17;
                    i24 = i18;
                    fS = f11;
                }
                iF += iQ;
                i22 = i12;
                i23 = i13;
                dVar2 = dVar;
                str3 = str3;
                iIntValue = iIntValue;
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
            }
            str = str2;
            iF += iQ;
            i22 = i12;
            i23 = i13;
            dVar2 = dVar;
            str3 = str3;
            iIntValue = iIntValue;
            drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType;
        }
        DrmInitData drmInitData2 = drmInitDataCopyWithSchemeType;
        int i44 = i25;
        float f12 = fS;
        int i45 = i24;
        int i46 = iL;
        int i47 = iM;
        if (str == null) {
            return;
        }
        y.b bVarN = new y.b().W(i14).k0(str).M(str4).r0(iN).V(iN2).g0(f12).j0(i15).h0(bArrT).n0(i26).Y(listOf).R(drmInitData2).N(new androidx.media3.common.k.b().d(i46).c(i27).e(i47).f(byteBufferA != null ? byteBufferA.array() : null).g(i45).b(i44).a());
        if (c0750bK != null) {
            bVarN.K(Ints.l(c0750bK.f69814c)).f0(Ints.l(c0750bK.f69815d));
        }
        dVar.f69817b = bVarN.I();
    }

    @Nullable
    public static Metadata F(c0 c0Var) {
        short sD = c0Var.D();
        c0Var.V(2);
        String strE = c0Var.E(sD);
        int iMax = Math.max(strE.lastIndexOf(43), strE.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(strE.substring(0, iMax)), Float.parseFloat(strE.substring(iMax, strE.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        return jArr[0] <= j12 && j12 < jArr[u0.p(4, 0, length)] && jArr[u0.p(jArr.length - 4, 0, length)] < j13 && j13 <= j11;
    }

    public static boolean c(int i11) {
        return i11 != 1;
    }

    public static int d(c0 c0Var, int i11, int i12, int i13) throws ParserException {
        int iF = c0Var.f();
        v.a(iF >= i12, null);
        while (iF - i12 < i13) {
            c0Var.U(iF);
            int iQ = c0Var.q();
            v.a(iQ > 0, "childAtomSize must be positive");
            if (c0Var.q() == i11) {
                return iF;
            }
            iF += iQ;
        }
        return -1;
    }

    public static int e(int i11) {
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

    public static void f(c0 c0Var) {
        int iF = c0Var.f();
        c0Var.V(4);
        if (c0Var.q() != 1751411826) {
            iF += 4;
        }
        c0Var.U(iF);
    }

    /* JADX WARN: Code duplicated, block: B:131:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:133:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:134:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:140:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:143:0x0218  */
    /* JADX WARN: Code duplicated, block: B:144:0x021e  */
    /* JADX WARN: Code duplicated, block: B:148:0x0238  */
    /* JADX WARN: Code duplicated, block: B:150:0x023f  */
    /* JADX WARN: Code duplicated, block: B:152:0x024a  */
    /* JADX WARN: Code duplicated, block: B:154:0x0252  */
    /* JADX WARN: Code duplicated, block: B:155:0x0257  */
    /* JADX WARN: Code duplicated, block: B:156:0x0262  */
    /* JADX WARN: Code duplicated, block: B:161:0x026e  */
    /* JADX WARN: Code duplicated, block: B:196:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:198:0x03c4  */
    /* JADX WARN: Code duplicated, block: B:200:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:202:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:204:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:205:0x03e6  */
    /* JADX WARN: Code duplicated, block: B:207:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:223:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:224:0x03fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    /* JADX WARN: Code duplicated, block: B:88:0x0139  */
    public static void g(c0 c0Var, int i11, int i12, int i13, int i14, String str, boolean z11, @Nullable DrmInitData drmInitData, d dVar, int i15) throws ParserException {
        int iN;
        int iN2;
        int I;
        int iQ;
        int i16;
        String str2;
        String str3;
        int i17;
        String str4;
        List<byte[]> listOf;
        String str5;
        C0750b c0750bK;
        int iQ2;
        boolean z12;
        int iQ3;
        int iD;
        byte[] bArr;
        int iH;
        byte[] bArr2;
        int iH2;
        int i18;
        byte[] bArr3;
        int i19 = i12;
        int i21 = i13;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        c0Var.U(i19 + 16);
        if (z11) {
            iN = c0Var.N();
            c0Var.V(6);
        } else {
            c0Var.V(8);
            iN = 0;
        }
        if (iN == 0 || iN == 1) {
            iN2 = c0Var.N();
            c0Var.V(6);
            I = c0Var.I();
            c0Var.U(c0Var.f() - 4);
            iQ = c0Var.q();
            if (iN == 1) {
                c0Var.V(16);
            }
            i16 = -1;
        } else {
            if (iN != 2) {
                return;
            }
            c0Var.V(16);
            I = (int) Math.round(c0Var.o());
            iN2 = c0Var.L();
            c0Var.V(4);
            int iL = c0Var.L();
            int iL2 = c0Var.L();
            boolean z13 = (iL2 & 1) != 0;
            boolean z14 = (iL2 & 2) != 0;
            if (z13) {
                if (iL == 32) {
                    i16 = 4;
                } else {
                    i16 = -1;
                }
            } else if (iL == 8) {
                i16 = 3;
            } else if (iL == 16) {
                i16 = z14 ? ASTNode.DEOP : 2;
            } else if (iL == 24) {
                i16 = z14 ? 1342177280 : 21;
            } else if (iL == 32) {
                i16 = z14 ? 1610612736 : 22;
            } else {
                i16 = -1;
            }
            c0Var.V(8);
            iQ = 0;
        }
        int iF = c0Var.f();
        int iIntValue = i11;
        if (iIntValue == 1701733217) {
            Pair<Integer, q> pairU = u(c0Var, i19, i21);
            if (pairU != null) {
                iIntValue = ((Integer) pairU.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((q) pairU.second).f69940b);
                dVar.f69816a[i15] = (q) pairU.second;
            }
            c0Var.U(iF);
        }
        String str6 = "audio/mhm1";
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
                if (iIntValue == 1936684916) {
                    i17 = 2;
                } else if (iIntValue == 1953984371) {
                    i17 = ASTNode.DEOP;
                } else if (iIntValue == 1819304813) {
                    if (i16 == -1) {
                        i17 = 2;
                    } else {
                        i17 = i16;
                    }
                } else if (iIntValue == 778924082 || iIntValue == 778924083) {
                    str2 = MimeTypes.AUDIO_MPEG;
                } else if (iIntValue == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue == 1835560241) {
                    i17 = i16;
                    str3 = "audio/mhm1";
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
                    i17 = i16;
                    str3 = null;
                }
                int i22 = i17;
                str4 = str3;
                listOf = null;
                str5 = null;
                c0750bK = null;
                while (iF - i19 < i21) {
                    c0Var.U(iF);
                    iQ2 = c0Var.q();
                    if (iQ2 > 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    v.a(z12, "childAtomSize must be positive");
                    iQ3 = c0Var.q();
                    if (iQ3 == 1835557187) {
                        c0Var.U(iF + 8);
                        c0Var.V(1);
                        iH2 = c0Var.H();
                        c0Var.V(1);
                        if (Objects.equals(str4, str6)) {
                            i18 = 0;
                            str5 = String.format("mhm1.%02X", Integer.valueOf(iH2));
                        } else {
                            i18 = 0;
                            str5 = String.format("mha1.%02X", Integer.valueOf(iH2));
                        }
                        int iN3 = c0Var.N();
                        bArr3 = new byte[iN3];
                        c0Var.l(bArr3, i18, iN3);
                        if (listOf == null) {
                            listOf = ImmutableList.of(bArr3);
                        } else {
                            listOf = ImmutableList.of(bArr3, listOf.get(i18));
                        }
                    } else {
                        str6 = str6;
                        if (iQ3 == 1835557200) {
                            c0Var.U(iF + 8);
                            iH = c0Var.H();
                            if (iH > 0) {
                                bArr2 = new byte[iH];
                                c0Var.l(bArr2, 0, iH);
                                if (listOf == null) {
                                    listOf = ImmutableList.of(bArr2);
                                } else {
                                    listOf = ImmutableList.of(listOf.get(0), bArr2);
                                }
                            }
                        } else {
                            if (iQ3 != 1702061171 || (z11 && iQ3 == 2002876005)) {
                                if (iQ3 == 1702061171) {
                                    iD = iF;
                                } else {
                                    iD = d(c0Var, 1702061171, iF, iQ2);
                                }
                                if (iD != -1) {
                                    c0750bK = k(c0Var, iD);
                                    str4 = c0750bK.f69812a;
                                    bArr = c0750bK.f69813b;
                                    if (bArr != null) {
                                        if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                            listOf = u4.u0.e(bArr);
                                        } else {
                                            if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                                u4.a.b bVarE = u4.a.e(bArr);
                                                int i23 = bVarE.f78194a;
                                                int i24 = bVarE.f78195b;
                                                str5 = bVarE.f78196c;
                                                I = i23;
                                                iN2 = i24;
                                            }
                                            listOf = ImmutableList.of(bArr);
                                        }
                                    }
                                }
                            } else if (iQ3 == 1684103987) {
                                c0Var.U(iF + 8);
                                dVar.f69817b = u4.b.d(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                            } else if (iQ3 == 1684366131) {
                                c0Var.U(iF + 8);
                                dVar.f69817b = u4.b.h(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                            } else if (iQ3 == 1684103988) {
                                c0Var.U(iF + 8);
                                dVar.f69817b = u4.c.b(c0Var, Integer.toString(i14), str, drmInitDataCopyWithSchemeType);
                            } else if (iQ3 == 1684892784) {
                                if (iQ <= 0) {
                                    throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + iQ, null);
                                }
                                I = iQ;
                                iN2 = 2;
                            } else if (iQ3 == 1684305011 || iQ3 == 1969517683) {
                                dVar.f69817b = new y.b().W(i14).k0(str4).L(iN2).l0(I).R(drmInitDataCopyWithSchemeType).b0(str).I();
                            } else if (iQ3 == 1682927731) {
                                int i25 = iQ2 - 8;
                                byte[] bArr4 = f69802a;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr4, bArr4.length + i25);
                                c0Var.U(iF + 8);
                                c0Var.l(bArrCopyOf, bArr4.length, i25);
                                listOf = k0.a(bArrCopyOf);
                            } else if (iQ3 == 1684425825) {
                                byte[] bArr5 = new byte[iQ2 - 8];
                                bArr5[0] = 102;
                                bArr5[1] = 76;
                                bArr5[2] = 97;
                                bArr5[3] = 67;
                                c0Var.U(iF + 12);
                                c0Var.l(bArr5, 4, iQ2 - 12);
                                listOf = ImmutableList.of(bArr5);
                            } else if (iQ3 == 1634492771) {
                                int i26 = iQ2 - 12;
                                byte[] bArr6 = new byte[i26];
                                c0Var.U(iF + 12);
                                c0Var.l(bArr6, 0, i26);
                                Pair<Integer, Integer> pairE = z3.e.e(bArr6);
                                int iIntValue2 = ((Integer) pairE.first).intValue();
                                iN2 = ((Integer) pairE.second).intValue();
                                listOf = ImmutableList.of(bArr6);
                                I = iIntValue2;
                            }
                            iF += iQ2;
                            i19 = i12;
                            i21 = i13;
                            str6 = str6;
                        }
                    }
                    iF += iQ2;
                    i19 = i12;
                    i21 = i13;
                    str6 = str6;
                }
                if (dVar.f69817b == null || str4 == null) {
                }
                y.b bVarB0 = new y.b().W(i14).k0(str4).M(str5).L(iN2).l0(I).e0(i22).Y(listOf).R(drmInitDataCopyWithSchemeType).b0(str);
                if (c0750bK != null) {
                    bVarB0.K(Ints.l(c0750bK.f69814c)).f0(Ints.l(c0750bK.f69815d));
                }
                dVar.f69817b = bVarB0.I();
                return;
            }
            str2 = MimeTypes.AUDIO_AMR_WB;
        }
        str3 = str2;
        i17 = i16;
        int i27 = i17;
        str4 = str3;
        listOf = null;
        str5 = null;
        c0750bK = null;
        while (iF - i19 < i21) {
            c0Var.U(iF);
            iQ2 = c0Var.q();
            if (iQ2 > 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            v.a(z12, "childAtomSize must be positive");
            iQ3 = c0Var.q();
            if (iQ3 == 1835557187) {
                c0Var.U(iF + 8);
                c0Var.V(1);
                iH2 = c0Var.H();
                c0Var.V(1);
                if (Objects.equals(str4, str6)) {
                    i18 = 0;
                    str5 = String.format("mhm1.%02X", Integer.valueOf(iH2));
                } else {
                    i18 = 0;
                    str5 = String.format("mha1.%02X", Integer.valueOf(iH2));
                }
                int iN4 = c0Var.N();
                bArr3 = new byte[iN4];
                c0Var.l(bArr3, i18, iN4);
                if (listOf == null) {
                    listOf = ImmutableList.of(bArr3);
                } else {
                    listOf = ImmutableList.of(bArr3, listOf.get(i18));
                }
            } else {
                str6 = str6;
                if (iQ3 == 1835557200) {
                    c0Var.U(iF + 8);
                    iH = c0Var.H();
                    if (iH > 0) {
                        bArr2 = new byte[iH];
                        c0Var.l(bArr2, 0, iH);
                        if (listOf == null) {
                            listOf = ImmutableList.of(bArr2);
                        } else {
                            listOf = ImmutableList.of(listOf.get(0), bArr2);
                        }
                    }
                } else {
                    if (iQ3 != 1702061171) {
                        if (iQ3 == 1702061171) {
                            iD = iF;
                        } else {
                            iD = d(c0Var, 1702061171, iF, iQ2);
                        }
                        if (iD != -1) {
                            c0750bK = k(c0Var, iD);
                            str4 = c0750bK.f69812a;
                            bArr = c0750bK.f69813b;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                    listOf = u4.u0.e(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        u4.a.b bVarE2 = u4.a.e(bArr);
                                        int i28 = bVarE2.f78194a;
                                        int i29 = bVarE2.f78195b;
                                        str5 = bVarE2.f78196c;
                                        I = i28;
                                        iN2 = i29;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    } else {
                        if (iQ3 == 1702061171) {
                            iD = iF;
                        } else {
                            iD = d(c0Var, 1702061171, iF, iQ2);
                        }
                        if (iD != -1) {
                            c0750bK = k(c0Var, iD);
                            str4 = c0750bK.f69812a;
                            bArr = c0750bK.f69813b;
                            if (bArr != null) {
                                if (MimeTypes.AUDIO_VORBIS.equals(str4)) {
                                    listOf = u4.u0.e(bArr);
                                } else {
                                    if (MimeTypes.AUDIO_AAC.equals(str4)) {
                                        u4.a.b bVarE3 = u4.a.e(bArr);
                                        int i210 = bVarE3.f78194a;
                                        int i211 = bVarE3.f78195b;
                                        str5 = bVarE3.f78196c;
                                        I = i210;
                                        iN2 = i211;
                                    }
                                    listOf = ImmutableList.of(bArr);
                                }
                            }
                        }
                    }
                    iF += iQ2;
                    i19 = i12;
                    i21 = i13;
                    str6 = str6;
                }
            }
            iF += iQ2;
            i19 = i12;
            i21 = i13;
            str6 = str6;
        }
        if (dVar.f69817b == null) {
        }
    }

    public static androidx.media3.common.k h(c0 c0Var) {
        androidx.media3.common.k.b bVar = new androidx.media3.common.k.b();
        b0 b0Var = new b0(c0Var.e());
        b0Var.p(c0Var.f() * 8);
        b0Var.s(1);
        int iH = b0Var.h(3);
        b0Var.r(6);
        boolean zG = b0Var.g();
        boolean zG2 = b0Var.g();
        if (iH == 2 && zG) {
            bVar.g(zG2 ? 12 : 10);
            bVar.b(zG2 ? 12 : 10);
        } else if (iH <= 2) {
            bVar.g(zG ? 10 : 8);
            bVar.b(zG ? 10 : 8);
        }
        b0Var.r(13);
        b0Var.q();
        int iH2 = b0Var.h(4);
        if (iH2 != 1) {
            z3.o.f("AtomParsers", "Unsupported obu_type: " + iH2);
            return bVar.a();
        }
        if (b0Var.g()) {
            z3.o.f("AtomParsers", "Unsupported obu_extension_flag");
            return bVar.a();
        }
        boolean zG3 = b0Var.g();
        b0Var.q();
        if (zG3 && b0Var.h(8) > 127) {
            z3.o.f("AtomParsers", "Excessive obu_size");
            return bVar.a();
        }
        int iH3 = b0Var.h(3);
        b0Var.q();
        if (b0Var.g()) {
            z3.o.f("AtomParsers", "Unsupported reduced_still_picture_header");
            return bVar.a();
        }
        if (b0Var.g()) {
            z3.o.f("AtomParsers", "Unsupported timing_info_present_flag");
            return bVar.a();
        }
        if (b0Var.g()) {
            z3.o.f("AtomParsers", "Unsupported initial_display_delay_present_flag");
            return bVar.a();
        }
        int iH4 = b0Var.h(5);
        boolean z11 = false;
        for (int i11 = 0; i11 <= iH4; i11++) {
            b0Var.r(12);
            if (b0Var.h(5) > 7) {
                b0Var.q();
            }
        }
        int iH5 = b0Var.h(4);
        int iH6 = b0Var.h(4);
        b0Var.r(iH5 + 1);
        b0Var.r(iH6 + 1);
        if (b0Var.g()) {
            b0Var.r(7);
        }
        b0Var.r(7);
        boolean zG4 = b0Var.g();
        if (zG4) {
            b0Var.r(2);
        }
        if ((b0Var.g() || b0Var.h(1) > 0) && !b0Var.g()) {
            b0Var.r(1);
        }
        if (zG4) {
            b0Var.r(3);
        }
        b0Var.r(3);
        boolean zG5 = b0Var.g();
        if (iH3 == 2 && zG5) {
            b0Var.q();
        }
        if (iH3 != 1 && b0Var.g()) {
            z11 = true;
        }
        if (b0Var.g()) {
            int iH7 = b0Var.h(8);
            int iH8 = b0Var.h(8);
            bVar.d(androidx.media3.common.k.l(iH7)).c(((z11 || iH7 != 1 || iH8 != 13 || b0Var.h(8) != 0) ? b0Var.h(1) : 1) != 1 ? 2 : 1).e(androidx.media3.common.k.m(iH8));
        }
        return bVar.a();
    }

    @Nullable
    public static Pair<Integer, q> i(c0 c0Var, int i11, int i12) throws ParserException {
        int i13 = i11 + 8;
        String strE = null;
        Integer numValueOf = null;
        int i14 = -1;
        int i15 = 0;
        while (i13 - i11 < i12) {
            c0Var.U(i13);
            int iQ = c0Var.q();
            int iQ2 = c0Var.q();
            if (iQ2 == 1718775137) {
                numValueOf = Integer.valueOf(c0Var.q());
            } else if (iQ2 == 1935894637) {
                c0Var.V(4);
                strE = c0Var.E(4);
            } else if (iQ2 == 1935894633) {
                i14 = i13;
                i15 = iQ;
            }
            i13 += iQ;
        }
        if (!C.CENC_TYPE_cenc.equals(strE) && !C.CENC_TYPE_cbc1.equals(strE) && !C.CENC_TYPE_cens.equals(strE) && !C.CENC_TYPE_cbcs.equals(strE)) {
            return null;
        }
        v.a(numValueOf != null, "frma atom is mandatory");
        v.a(i14 != -1, "schi atom is mandatory");
        q qVarV = v(c0Var, i14, i15, strE);
        v.a(qVarV != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (q) u0.i(qVarV));
    }

    @Nullable
    public static Pair<long[], long[]> j(l5.a.C0749a c0749a) {
        l5.a.b bVarG = c0749a.g(1701606260);
        if (bVarG == null) {
            return null;
        }
        c0 c0Var = bVarG.f69801b;
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        int iL = c0Var.L();
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        for (int i11 = 0; i11 < iL; i11++) {
            jArr[i11] = iC == 1 ? c0Var.M() : c0Var.J();
            jArr2[i11] = iC == 1 ? c0Var.A() : c0Var.q();
            if (c0Var.D() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            c0Var.V(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static C0750b k(c0 c0Var, int i11) {
        c0Var.U(i11 + 12);
        c0Var.V(1);
        l(c0Var);
        c0Var.V(2);
        int iH = c0Var.H();
        if ((iH & 128) != 0) {
            c0Var.V(2);
        }
        if ((iH & 64) != 0) {
            c0Var.V(c0Var.H());
        }
        if ((iH & 32) != 0) {
            c0Var.V(2);
        }
        c0Var.V(1);
        l(c0Var);
        String strH = androidx.media3.common.f0.h(c0Var.H());
        if (MimeTypes.AUDIO_MPEG.equals(strH) || MimeTypes.AUDIO_DTS.equals(strH) || MimeTypes.AUDIO_DTS_HD.equals(strH)) {
            return new C0750b(strH, null, -1L, -1L);
        }
        c0Var.V(4);
        long J = c0Var.J();
        long J2 = c0Var.J();
        c0Var.V(1);
        int iL = l(c0Var);
        byte[] bArr = new byte[iL];
        c0Var.l(bArr, 0, iL);
        return new C0750b(strH, bArr, J2 > 0 ? J2 : -1L, J > 0 ? J : -1L);
    }

    public static int l(c0 c0Var) {
        int iH = c0Var.H();
        int i11 = iH & 127;
        while ((iH & 128) == 128) {
            iH = c0Var.H();
            i11 = (i11 << 7) | (iH & 127);
        }
        return i11;
    }

    public static int m(c0 c0Var) {
        c0Var.U(16);
        return c0Var.q();
    }

    @Nullable
    public static Metadata n(c0 c0Var, int i11) {
        c0Var.V(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var.f() < i11) {
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

    public static Pair<Long, String> o(c0 c0Var) {
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        c0Var.V(iC == 0 ? 8 : 16);
        long J = c0Var.J();
        c0Var.V(iC == 0 ? 4 : 8);
        int iN = c0Var.N();
        return Pair.create(Long.valueOf(J), "" + ((char) (((iN >> 10) & 31) + 96)) + ((char) (((iN >> 5) & 31) + 96)) + ((char) ((iN & 31) + 96)));
    }

    @Nullable
    public static Metadata p(l5.a.C0749a c0749a) {
        l5.a.b bVarG = c0749a.g(1751411826);
        l5.a.b bVarG2 = c0749a.g(1801812339);
        l5.a.b bVarG3 = c0749a.g(1768715124);
        if (bVarG == null || bVarG2 == null || bVarG3 == null || m(bVarG.f69801b) != 1835299937) {
            return null;
        }
        c0 c0Var = bVarG2.f69801b;
        c0Var.U(12);
        int iQ = c0Var.q();
        String[] strArr = new String[iQ];
        for (int i11 = 0; i11 < iQ; i11++) {
            int iQ2 = c0Var.q();
            c0Var.V(4);
            strArr[i11] = c0Var.E(iQ2 - 8);
        }
        c0 c0Var2 = bVarG3.f69801b;
        c0Var2.U(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var2.a() > 8) {
            int iF = c0Var2.f();
            int iQ3 = c0Var2.q();
            int iQ4 = c0Var2.q() - 1;
            if (iQ4 < 0 || iQ4 >= iQ) {
                z3.o.h("AtomParsers", "Skipped metadata with unknown key index: " + iQ4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = h.f(c0Var2, iF + iQ3, strArr[iQ4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            c0Var2.U(iF + iQ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void q(c0 c0Var, int i11, int i12, int i13, d dVar) {
        c0Var.U(i12 + 16);
        if (i11 == 1835365492) {
            c0Var.B();
            String strB = c0Var.B();
            if (strB != null) {
                dVar.f69817b = new y.b().W(i13).k0(strB).I();
            }
        }
    }

    public static Mp4TimestampData r(c0 c0Var) {
        long jA;
        long jA2;
        c0Var.U(8);
        if (l5.a.c(c0Var.q()) == 0) {
            jA = c0Var.J();
            jA2 = c0Var.J();
        } else {
            jA = c0Var.A();
            jA2 = c0Var.A();
        }
        return new Mp4TimestampData(jA, jA2, c0Var.J());
    }

    public static float s(c0 c0Var, int i11) {
        c0Var.U(i11 + 8);
        return c0Var.L() / c0Var.L();
    }

    @Nullable
    public static byte[] t(c0 c0Var, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            c0Var.U(i13);
            int iQ = c0Var.q();
            if (c0Var.q() == 1886547818) {
                return Arrays.copyOfRange(c0Var.e(), i13, iQ + i13);
            }
            i13 += iQ;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, q> u(c0 c0Var, int i11, int i12) throws ParserException {
        Pair<Integer, q> pairI;
        int iF = c0Var.f();
        while (iF - i11 < i12) {
            c0Var.U(iF);
            int iQ = c0Var.q();
            v.a(iQ > 0, "childAtomSize must be positive");
            if (c0Var.q() == 1936289382 && (pairI = i(c0Var, iF, iQ)) != null) {
                return pairI;
            }
            iF += iQ;
        }
        return null;
    }

    @Nullable
    public static q v(c0 c0Var, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            c0Var.U(i15);
            int iQ = c0Var.q();
            if (c0Var.q() == 1952804451) {
                int iC = l5.a.c(c0Var.q());
                c0Var.V(1);
                if (iC == 0) {
                    c0Var.V(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int iH = c0Var.H();
                    i13 = iH & 15;
                    i14 = (iH & 240) >> 4;
                }
                boolean z11 = c0Var.H() == 1;
                int iH2 = c0Var.H();
                byte[] bArr2 = new byte[16];
                c0Var.l(bArr2, 0, 16);
                if (z11 && iH2 == 0) {
                    int iH3 = c0Var.H();
                    bArr = new byte[iH3];
                    c0Var.l(bArr, 0, iH3);
                }
                return new q(z11, str, iH2, bArr2, i14, i13, bArr);
            }
            i15 += iQ;
        }
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
    /* JADX WARN: Code duplicated, block: B:199:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:200:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:203:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:205:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:206:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:216:0x042a A[EDGE_INSN: B:216:0x042a->B:171:0x042a BREAK  A[LOOP:2: B:154:0x03c9->B:170:0x0423], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:219:0x040b A[ADDED_TO_REGION, EDGE_INSN: B:219:0x040b->B:164:0x040b BREAK  A[LOOP:3: B:159:0x03fb->B:163:0x0406], REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:225:0x0183 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:226:0x0219 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x017b A[EDGE_INSN: B:228:0x017b->B:63:0x017b BREAK  A[LOOP:7: B:59:0x015e->B:62:0x0166], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x0236 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x022e A[SYNTHETIC] */
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
    public static s w(p pVar, l5.a.C0749a c0749a, f0 f0Var) throws ParserException {
        c fVar;
        boolean z11;
        int iL;
        int iL2;
        int iL3;
        int iA;
        boolean z12;
        long[] jArrCopyOf;
        int[] iArrCopyOf;
        long[] jArrCopyOf2;
        int[] iArrCopyOf2;
        int iL4;
        int i11;
        int i12;
        int i13;
        int iQ;
        int iL5;
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
        p pVar2;
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
        int iL6;
        int iQ2;
        int i31;
        long jF1;
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
        long jF2;
        int i45;
        long j17;
        boolean z17;
        int i46;
        int i47;
        int i48;
        boolean z18;
        long[] jArr10;
        int[] iArr10;
        l5.a.b bVarG = c0749a.g(1937011578);
        if (bVarG != null) {
            fVar = new e(bVarG, pVar.f69933f);
        } else {
            l5.a.b bVarG2 = c0749a.g(1937013298);
            if (bVarG2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            fVar = new f(bVarG2);
        }
        int sampleCount = fVar.getSampleCount();
        if (sampleCount == 0) {
            return new s(pVar, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        l5.a.b bVarG3 = c0749a.g(1937007471);
        if (bVarG3 == null) {
            bVarG3 = (l5.a.b) z3.a.e(c0749a.g(1668232756));
            z11 = true;
        } else {
            z11 = false;
        }
        c0 c0Var = bVarG3.f69801b;
        c0 c0Var2 = ((l5.a.b) z3.a.e(c0749a.g(1937011555))).f69801b;
        c0 c0Var3 = ((l5.a.b) z3.a.e(c0749a.g(1937011827))).f69801b;
        l5.a.b bVarG4 = c0749a.g(1937011571);
        c0 c0Var4 = bVarG4 != null ? bVarG4.f69801b : null;
        l5.a.b bVarG5 = c0749a.g(1668576371);
        c0 c0Var5 = bVarG5 != null ? bVarG5.f69801b : null;
        a aVar = new a(c0Var2, c0Var, z11);
        c0Var3.U(12);
        int iL7 = c0Var3.L() - 1;
        int iL8 = c0Var3.L();
        int iL9 = c0Var3.L();
        if (c0Var5 != null) {
            c0Var5.U(12);
            iL = c0Var5.L();
        } else {
            iL = 0;
        }
        if (c0Var4 != null) {
            c0Var4.U(12);
            iL2 = c0Var4.L();
            if (iL2 > 0) {
                iL3 = c0Var4.L() - 1;
            } else {
                c0Var4 = null;
            }
            iA = fVar.a();
            String str2 = pVar.f69933f.f9501m;
            if (iA == -1 && ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && iL7 == 0 && iL == 0 && iL2 == 0)) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i49 = aVar.f69803a;
                jArr10 = new long[i49];
                iArr10 = new int[i49];
                while (aVar.a()) {
                    int i50 = aVar.f69804b;
                    jArr10[i50] = aVar.f69806d;
                    iArr10[i50] = aVar.f69805c;
                }
                l5.d.b bVarA = l5.d.a(iA, jArr10, iArr10, iL9);
                long[] jArr11 = bVarA.f69835a;
                int[] iArr11 = bVarA.f69836b;
                int i51 = bVarA.f69837c;
                long[] jArr12 = bVarA.f69838d;
                int[] iArr12 = bVarA.f69839e;
                long j18 = bVarA.f69840f;
                pVar2 = pVar;
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
                iL4 = iL3;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                iQ = 0;
                iL5 = 0;
                j11 = 0;
                j12 = 0;
                i14 = iL;
                i15 = iL9;
                i16 = iL8;
                i17 = iL7;
                i18 = iL2;
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
                        long j19 = aVar.f69806d;
                        i26 = aVar.f69805c;
                        j14 = j19;
                        i16 = i52;
                        i15 = i15;
                        sampleCount = sampleCount;
                    }
                    i27 = sampleCount;
                    i21 = i16;
                    i28 = i15;
                    if (!zA) {
                        z3.o.h("AtomParsers", "Unexpected end of chunk data");
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                        jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                        iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                        sampleCount = i11;
                        i22 = i26;
                        break;
                    }
                    if (c0Var5 != null) {
                        while (iL5 == 0 && i14 > 0) {
                            iL5 = c0Var5.L();
                            iQ = c0Var5.q();
                            i14--;
                        }
                        iL5--;
                    }
                    int i53 = iQ;
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
                    if (i11 == iL4) {
                        iArrCopyOf2[i11] = 1;
                        i18--;
                        if (i18 > 0) {
                            iL4 = ((c0) z3.a.e(c0Var4)).L() - 1;
                        }
                    }
                    int i54 = iL4;
                    j11 += (long) i28;
                    iL6 = i21 - 1;
                    if (iL6 == 0 || i19 <= 0) {
                        iQ2 = i28;
                        i31 = i19;
                    } else {
                        iL6 = c0Var3.L();
                        iQ2 = c0Var3.q();
                        i31 = i19 - 1;
                    }
                    int i55 = iL6;
                    long j21 = j14 + ((long) iArrCopyOf[i11]);
                    int i56 = i26 - 1;
                    i11++;
                    j12 = j21;
                    iL4 = i54;
                    i15 = iQ2;
                    i13 = i56;
                    sampleCount = i27;
                    iQ = i53;
                    i17 = i31;
                    i16 = i55;
                }
                long j22 = j11 + ((long) iQ);
                if (c0Var5 != null) {
                    z13 = true;
                    break;
                }
                while (true) {
                    if (i14 > 0) {
                        z13 = true;
                        break;
                    }
                    if (c0Var5.L() != 0) {
                        z13 = false;
                        break;
                    }
                    c0Var5.q();
                    i14--;
                }
                if (i18 != 0 && i21 == 0 && i22 == 0 && i19 == 0) {
                    i23 = iL5;
                    if (i23 == 0 && z13) {
                        pVar2 = pVar;
                    }
                    i24 = sampleCount;
                    jArr = jArrCopyOf;
                    iArr = iArrCopyOf;
                    i25 = i12;
                    j13 = j22;
                    jArr2 = jArrCopyOf2;
                    iArr2 = iArrCopyOf2;
                } else {
                    i23 = iL5;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Inconsistent stbl box for track ");
                pVar2 = pVar;
                sb2.append(pVar2.f69928a);
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
                z3.o.h("AtomParsers", sb2.toString());
                i24 = sampleCount;
                jArr = jArrCopyOf;
                iArr = iArrCopyOf;
                i25 = i12;
                j13 = j22;
                jArr2 = jArrCopyOf2;
                iArr2 = iArrCopyOf2;
            }
            jF1 = u0.f1(j13, 1000000L, pVar2.f69930c);
            jArr3 = pVar2.f69935h;
            if (jArr3 == null) {
                u0.g1(jArr2, 1000000L, pVar2.f69930c);
                return new s(pVar, jArr, iArr, i25, jArr2, iArr2, jF1);
            }
            if (jArr3.length != 1 && pVar2.f69929b == 1 && jArr2.length >= 2) {
                long j23 = ((long[]) z3.a.e(pVar2.f69936i))[0];
                long jF3 = j23 + u0.f1(pVar2.f69935h[0], pVar2.f69930c, pVar2.f69931d);
                i32 = i24;
                if (b(jArr2, j13, j23, jF3)) {
                    long jF4 = u0.f1(j23 - jArr2[0], pVar2.f69933f.A, pVar2.f69930c);
                    i33 = i25;
                    long jF5 = u0.f1(j13 - jF3, pVar2.f69933f.A, pVar2.f69930c);
                    if ((jF4 != 0 || jF5 != 0) && jF4 <= 2147483647L && jF5 <= 2147483647L) {
                        f0Var.f78270a = (int) jF4;
                        f0Var.f78271b = (int) jF5;
                        u0.g1(jArr2, 1000000L, pVar2.f69930c);
                        return new s(pVar, jArr, iArr, i33, jArr2, iArr2, u0.f1(pVar2.f69935h[0], 1000000L, pVar2.f69931d));
                    }
                }
                jArr4 = pVar2.f69935h;
                if (jArr4.length != 1 && jArr4[0] == 0) {
                    long j24 = ((long[]) z3.a.e(pVar2.f69936i))[0];
                    for (int i57 = 0; i57 < jArr2.length; i57++) {
                        jArr2[i57] = u0.f1(jArr2[i57] - j24, 1000000L, pVar2.f69930c);
                    }
                    return new s(pVar, jArr, iArr, i33, jArr2, iArr2, u0.f1(j13 - j24, 1000000L, pVar2.f69930c));
                }
                if (pVar2.f69929b == 1) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                iArr3 = new int[jArr4.length];
                iArr4 = new int[jArr4.length];
                jArr5 = (long[]) z3.a.e(pVar2.f69936i);
                i34 = 0;
                z15 = false;
                i35 = 0;
                i36 = 0;
                while (true) {
                    jArr6 = pVar2.f69935h;
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
                        long jF6 = u0.f1(jArr6[i34], pVar2.f69930c, pVar2.f69931d);
                        iArr3[i34] = u0.h(jArr2, j17, true, true);
                        iArr4[i34] = u0.d(jArr2, j17 + jF6, z14, false);
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
                while (i37 < pVar2.f69935h.length) {
                    j16 = pVar2.f69936i[i37];
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
                        long jF7 = u0.f1(j15, 1000000L, pVar2.f69931d);
                        long[] jArr14 = jArr2;
                        int[] iArr16 = iArr2;
                        jF2 = u0.f1(jArr2[i41] - j16, 1000000L, pVar2.f69930c);
                        int[] iArr17 = iArr7;
                        long j25 = j15;
                        if (c(pVar2.f69929b)) {
                            jF2 = Math.max(0L, jF2);
                        }
                        jArr9[i40] = jF7 + jF2;
                        if (z16) {
                            i45 = i44;
                            if (iArr6[i40] > i45) {
                                i43 = iArr9[i41];
                            }
                            i40++;
                            i41++;
                            i42 = i60;
                            jArr2 = jArr14;
                            iArr2 = iArr16;
                            j15 = j25;
                            iArr7 = iArr17;
                        } else {
                            i45 = i44;
                        }
                        i43 = i45;
                        i40++;
                        i41++;
                        i42 = i60;
                        jArr2 = jArr14;
                        iArr2 = iArr16;
                        j15 = j25;
                        iArr7 = iArr17;
                    }
                    long[] jArr15 = jArr2;
                    long j26 = j15 + pVar2.f69935h[i37];
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
                return new s(pVar, jArr8, iArr6, i39, jArr9, iArr7, u0.f1(j15, 1000000L, pVar2.f69931d));
            }
            i32 = i24;
            i33 = i25;
            jArr4 = pVar2.f69935h;
            if (jArr4.length != 1) {
            }
            if (pVar2.f69929b == 1) {
                z14 = true;
            } else {
                z14 = false;
            }
            iArr3 = new int[jArr4.length];
            iArr4 = new int[jArr4.length];
            jArr5 = (long[]) z3.a.e(pVar2.f69936i);
            i34 = 0;
            z15 = false;
            i35 = 0;
            i36 = 0;
            while (true) {
                jArr6 = pVar2.f69935h;
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
                    long jF8 = u0.f1(jArr6[i34], pVar2.f69930c, pVar2.f69931d);
                    iArr3[i34] = u0.h(jArr2, j17, true, true);
                    iArr4[i34] = u0.d(jArr2, j17 + jF8, z14, false);
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
            while (i37 < pVar2.f69935h.length) {
                j16 = pVar2.f69936i[i37];
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
                    long jF9 = u0.f1(j15, 1000000L, pVar2.f69931d);
                    long[] jArr17 = jArr2;
                    int[] iArr111 = iArr2;
                    jF2 = u0.f1(jArr2[i41] - j16, 1000000L, pVar2.f69930c);
                    int[] iArr112 = iArr7;
                    long j27 = j15;
                    if (c(pVar2.f69929b)) {
                        jF2 = Math.max(0L, jF2);
                    }
                    jArr9[i40] = jF9 + jF2;
                    if (z16) {
                        i45 = i44;
                        if (iArr6[i40] > i45) {
                            i43 = iArr9[i41];
                        }
                        i40++;
                        i41++;
                        i42 = i61;
                        jArr2 = jArr17;
                        iArr2 = iArr111;
                        j15 = j27;
                        iArr7 = iArr112;
                    } else {
                        i45 = i44;
                    }
                    i43 = i45;
                    i40++;
                    i41++;
                    i42 = i61;
                    jArr2 = jArr17;
                    iArr2 = iArr111;
                    j15 = j27;
                    iArr7 = iArr112;
                }
                long[] jArr18 = jArr2;
                long j28 = j15 + pVar2.f69935h[i37];
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
            return new s(pVar, jArr8, iArr6, i39, jArr9, iArr7, u0.f1(j15, 1000000L, pVar2.f69931d));
        }
        iL2 = 0;
        iL3 = -1;
        iA = fVar.a();
        String str3 = pVar.f69933f.f9501m;
        if (iA == -1) {
            z12 = false;
        } else {
            z12 = false;
        }
        if (z12) {
            int i410 = aVar.f69803a;
            jArr10 = new long[i410];
            iArr10 = new int[i410];
            while (aVar.a()) {
                int i512 = aVar.f69804b;
                jArr10[i512] = aVar.f69806d;
                iArr10[i512] = aVar.f69805c;
            }
            l5.d.b bVarA2 = l5.d.a(iA, jArr10, iArr10, iL9);
            long[] jArr19 = bVarA2.f69835a;
            int[] iArr113 = bVarA2.f69836b;
            int i513 = bVarA2.f69837c;
            long[] jArr110 = bVarA2.f69838d;
            int[] iArr114 = bVarA2.f69839e;
            long j110 = bVarA2.f69840f;
            pVar2 = pVar;
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
            iL4 = iL3;
            i11 = 0;
            i12 = 0;
            i13 = 0;
            iQ = 0;
            iL5 = 0;
            j11 = 0;
            j12 = 0;
            i14 = iL;
            i15 = iL9;
            i16 = iL8;
            i17 = iL7;
            i18 = iL2;
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
                    long j111 = aVar.f69806d;
                    i26 = aVar.f69805c;
                    j14 = j111;
                    i16 = i514;
                    i15 = i15;
                    sampleCount = sampleCount;
                }
                i27 = sampleCount;
                i21 = i16;
                i28 = i15;
                if (!zA) {
                    z3.o.h("AtomParsers", "Unexpected end of chunk data");
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                    iArrCopyOf = Arrays.copyOf(iArrCopyOf, i11);
                    jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                    iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i11);
                    sampleCount = i11;
                    i22 = i26;
                    break;
                }
                if (c0Var5 != null) {
                    while (iL5 == 0) {
                        iL5 = c0Var5.L();
                        iQ = c0Var5.q();
                        i14--;
                    }
                    iL5--;
                }
                int i515 = iQ;
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
                if (i11 == iL4) {
                    iArrCopyOf2[i11] = 1;
                    i18--;
                    if (i18 > 0) {
                        iL4 = ((c0) z3.a.e(c0Var4)).L() - 1;
                    }
                }
                int i516 = iL4;
                j11 += (long) i28;
                iL6 = i21 - 1;
                if (iL6 == 0) {
                    iQ2 = i28;
                    i31 = i19;
                } else {
                    iQ2 = i28;
                    i31 = i19;
                }
                int i517 = iL6;
                long j29 = j14 + ((long) iArrCopyOf[i11]);
                int i518 = i26 - 1;
                i11++;
                j12 = j29;
                iL4 = i516;
                i15 = iQ2;
                i13 = i518;
                sampleCount = i27;
                iQ = i515;
                i17 = i31;
                i16 = i517;
            }
            long j210 = j11 + ((long) iQ);
            if (c0Var5 != null) {
                z13 = true;
                break;
            }
            while (true) {
                if (i14 > 0) {
                    z13 = true;
                    break;
                }
                if (c0Var5.L() != 0) {
                    z13 = false;
                    break;
                }
                c0Var5.q();
                i14--;
            }
            if (i18 != 0) {
                i23 = iL5;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Inconsistent stbl box for track ");
                pVar2 = pVar;
                sb3.append(pVar2.f69928a);
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
                z3.o.h("AtomParsers", sb3.toString());
            } else {
                i23 = iL5;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Inconsistent stbl box for track ");
                pVar2 = pVar;
                sb4.append(pVar2.f69928a);
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
                z3.o.h("AtomParsers", sb4.toString());
            }
            i24 = sampleCount;
            jArr = jArrCopyOf;
            iArr = iArrCopyOf;
            i25 = i12;
            j13 = j210;
            jArr2 = jArrCopyOf2;
            iArr2 = iArrCopyOf2;
        }
        jF1 = u0.f1(j13, 1000000L, pVar2.f69930c);
        jArr3 = pVar2.f69935h;
        if (jArr3 == null) {
            u0.g1(jArr2, 1000000L, pVar2.f69930c);
            return new s(pVar, jArr, iArr, i25, jArr2, iArr2, jF1);
        }
        if (jArr3.length != 1) {
            i32 = i24;
            i33 = i25;
        } else {
            i32 = i24;
            i33 = i25;
        }
        jArr4 = pVar2.f69935h;
        if (jArr4.length != 1) {
        }
        if (pVar2.f69929b == 1) {
            z14 = true;
        } else {
            z14 = false;
        }
        iArr3 = new int[jArr4.length];
        iArr4 = new int[jArr4.length];
        jArr5 = (long[]) z3.a.e(pVar2.f69936i);
        i34 = 0;
        z15 = false;
        i35 = 0;
        i36 = 0;
        while (true) {
            jArr6 = pVar2.f69935h;
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
                long jF10 = u0.f1(jArr6[i34], pVar2.f69930c, pVar2.f69931d);
                iArr3[i34] = u0.h(jArr2, j17, true, true);
                iArr4[i34] = u0.d(jArr2, j17 + jF10, z14, false);
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
        while (i37 < pVar2.f69935h.length) {
            j16 = pVar2.f69936i[i37];
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
                long jF11 = u0.f1(j15, 1000000L, pVar2.f69931d);
                long[] jArr112 = jArr2;
                int[] iArr118 = iArr2;
                jF2 = u0.f1(jArr2[i41] - j16, 1000000L, pVar2.f69930c);
                int[] iArr119 = iArr7;
                long j211 = j15;
                if (c(pVar2.f69929b)) {
                    jF2 = Math.max(0L, jF2);
                }
                jArr9[i40] = jF11 + jF2;
                if (z16) {
                    i45 = i44;
                    if (iArr6[i40] > i45) {
                        i43 = iArr9[i41];
                    }
                    i40++;
                    i41++;
                    i42 = i62;
                    jArr2 = jArr112;
                    iArr2 = iArr118;
                    j15 = j211;
                    iArr7 = iArr119;
                } else {
                    i45 = i44;
                }
                i43 = i45;
                i40++;
                i41++;
                i42 = i62;
                jArr2 = jArr112;
                iArr2 = iArr118;
                j15 = j211;
                iArr7 = iArr119;
            }
            long[] jArr113 = jArr2;
            long j212 = j15 + pVar2.f69935h[i37];
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
        return new s(pVar, jArr8, iArr6, i39, jArr9, iArr7, u0.f1(j15, 1000000L, pVar2.f69931d));
    }

    public static d x(c0 c0Var, int i11, int i12, String str, @Nullable DrmInitData drmInitData, boolean z11) throws ParserException {
        int i13;
        c0Var.U(12);
        int iQ = c0Var.q();
        d dVar = new d(iQ);
        for (int i14 = 0; i14 < iQ; i14++) {
            int iF = c0Var.f();
            int iQ2 = c0Var.q();
            v.a(iQ2 > 0, "childAtomSize must be positive");
            int iQ3 = c0Var.q();
            if (iQ3 == 1635148593 || iQ3 == 1635148595 || iQ3 == 1701733238 || iQ3 == 1831958048 || iQ3 == 1836070006 || iQ3 == 1752589105 || iQ3 == 1751479857 || iQ3 == 1932670515 || iQ3 == 1211250227 || iQ3 == 1987063864 || iQ3 == 1987063865 || iQ3 == 1635135537 || iQ3 == 1685479798 || iQ3 == 1685479729 || iQ3 == 1685481573 || iQ3 == 1685481521) {
                i13 = iF;
                E(c0Var, iQ3, i13, iQ2, i11, i12, drmInitData, dVar, i14);
            } else if (iQ3 == 1836069985 || iQ3 == 1701733217 || iQ3 == 1633889587 || iQ3 == 1700998451 || iQ3 == 1633889588 || iQ3 == 1835823201 || iQ3 == 1685353315 || iQ3 == 1685353317 || iQ3 == 1685353320 || iQ3 == 1685353324 || iQ3 == 1685353336 || iQ3 == 1935764850 || iQ3 == 1935767394 || iQ3 == 1819304813 || iQ3 == 1936684916 || iQ3 == 1953984371 || iQ3 == 778924082 || iQ3 == 778924083 || iQ3 == 1835557169 || iQ3 == 1835560241 || iQ3 == 1634492771 || iQ3 == 1634492791 || iQ3 == 1970037111 || iQ3 == 1332770163 || iQ3 == 1716281667) {
                i13 = iF;
                g(c0Var, iQ3, iF, iQ2, i11, str, z11, drmInitData, dVar, i14);
            } else {
                if (iQ3 == 1414810956 || iQ3 == 1954034535 || iQ3 == 2004251764 || iQ3 == 1937010800 || iQ3 == 1664495672) {
                    y(c0Var, iQ3, iF, iQ2, i11, str, dVar);
                } else if (iQ3 == 1835365492) {
                    q(c0Var, iQ3, iF, i11, dVar);
                } else if (iQ3 == 1667329389) {
                    dVar.f69817b = new y.b().W(i11).k0(MimeTypes.APPLICATION_CAMERA_MOTION).I();
                }
                i13 = iF;
            }
            c0Var.U(i13 + iQ2);
        }
        return dVar;
    }

    public static void y(c0 c0Var, int i11, int i12, int i13, int i14, String str, d dVar) {
        c0Var.U(i12 + 16);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableListOf = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = i13 - 16;
                byte[] bArr = new byte[i15];
                c0Var.l(bArr, 0, i15);
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
                dVar.f69819d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        dVar.f69817b = new y.b().W(i14).k0(str2).b0(str).o0(j11).Y(immutableListOf).I();
    }

    public static g z(c0 c0Var) {
        long j11;
        c0Var.U(8);
        int iC = l5.a.c(c0Var.q());
        c0Var.V(iC == 0 ? 8 : 16);
        int iQ = c0Var.q();
        c0Var.V(4);
        int iF = c0Var.f();
        int i11 = iC == 0 ? 4 : 8;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            j11 = C.TIME_UNSET;
            if (i13 >= i11) {
                c0Var.V(i11);
                break;
            }
            if (c0Var.e()[iF + i13] != -1) {
                long J = iC == 0 ? c0Var.J() : c0Var.M();
                if (J == 0) {
                    break;
                }
                j11 = J;
                break;
            }
            i13++;
        }
        c0Var.V(16);
        int iQ2 = c0Var.q();
        int iQ3 = c0Var.q();
        c0Var.V(4);
        int iQ4 = c0Var.q();
        int iQ5 = c0Var.q();
        if (iQ2 == 0 && iQ3 == 65536 && iQ4 == -65536 && iQ5 == 0) {
            i12 = 90;
        } else if (iQ2 == 0 && iQ3 == -65536 && iQ4 == 65536 && iQ5 == 0) {
            i12 = 270;
        } else if (iQ2 == -65536 && iQ3 == 0 && iQ4 == 0 && iQ5 == -65536) {
            i12 = 180;
        }
        return new g(iQ, j11, i12);
    }
}

package y5;

import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.ParserException;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Map;
import u4.l0;
import u4.r;
import u4.r0;
import u4.s;
import u4.t;
import u4.u;
import u4.v0;
import u4.x;
import u4.y;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements s {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final y f81183h = new y() { // from class: y5.a
        @Override // u4.y
        public /* synthetic */ y a(o5.s.a aVar) {
            return x.c(this, aVar);
        }

        @Override // u4.y
        public /* synthetic */ s[] b(Uri uri, Map map) {
            return x.a(this, uri, map);
        }

        @Override // u4.y
        public /* synthetic */ y c(boolean z11) {
            return x.b(this, z11);
        }

        @Override // u4.y
        public final s[] createExtractors() {
            return b.g();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f81184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r0 f81185b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0913b f81188e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f81186c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f81187d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f81189f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f81190g = -1;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements InterfaceC0913b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int[] f81191m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int[] f81192n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f81193a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0 f81194b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y5.c f81195c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f81196d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f81197e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f81198f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f81199g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final androidx.media3.common.y f81200h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f81201i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f81202j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f81203k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f81204l;

        public a(u uVar, r0 r0Var, y5.c cVar) throws ParserException {
            this.f81193a = uVar;
            this.f81194b = r0Var;
            this.f81195c = cVar;
            int iMax = Math.max(1, cVar.f81215c / 10);
            this.f81199g = iMax;
            c0 c0Var = new c0(cVar.f81219g);
            c0Var.z();
            int iZ = c0Var.z();
            this.f81196d = iZ;
            int i11 = cVar.f81214b;
            int i12 = (((cVar.f81217e - (i11 * 4)) * 8) / (cVar.f81218f * i11)) + 1;
            if (iZ == i12) {
                int iK = u0.k(iMax, iZ);
                this.f81197e = new byte[cVar.f81217e * iK];
                this.f81198f = new c0(iK * h(iZ, i11));
                int i13 = ((cVar.f81215c * cVar.f81217e) * 8) / iZ;
                this.f81200h = new androidx.media3.common.y.b().k0(MimeTypes.AUDIO_RAW).K(i13).f0(i13).c0(h(iMax, i11)).L(cVar.f81214b).l0(cVar.f81215c).e0(2).I();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i12 + "; got: " + iZ, null);
        }

        public static int h(int i11, int i12) {
            return i11 * 2 * i12;
        }

        @Override // y5.b.InterfaceC0913b
        public void a(int i11, long j11) {
            this.f81193a.f(new e(this.f81195c, this.f81196d, i11, j11));
            this.f81194b.b(this.f81200h);
        }

        @Override // y5.b.InterfaceC0913b
        public void b(long j11) {
            this.f81201i = 0;
            this.f81202j = j11;
            this.f81203k = 0;
            this.f81204l = 0L;
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0039 A[LOOP:0: B:6:0x001f->B:12:0x0039, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:23:0x003f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:25:0x001c A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0021  */
        /* JADX WARN: Code duplicated, block: B:9:0x0025  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0036 -> B:4:0x001c). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // y5.b.InterfaceC0913b
        public boolean c(u4.t r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f81199g
                int r1 = r6.f81203k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f81196d
                int r0 = z3.u0.k(r0, r1)
                y5.c r1 = r6.f81195c
                int r1 = r1.f81217e
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L1e
            L1c:
                r1 = 1
                goto L1f
            L1e:
                r1 = 0
            L1f:
                if (r1 != 0) goto L3f
                int r2 = r6.f81201i
                if (r2 >= r0) goto L3f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f81197e
                int r5 = r6.f81201i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f81201i
                int r4 = r4 + r2
                r6.f81201i = r4
                goto L1f
            L3f:
                int r7 = r6.f81201i
                y5.c r8 = r6.f81195c
                int r8 = r8.f81217e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f81197e
                z3.c0 r9 = r6.f81198f
                r6.d(r8, r7, r9)
                int r8 = r6.f81201i
                y5.c r9 = r6.f81195c
                int r9 = r9.f81217e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f81201i = r8
                z3.c0 r7 = r6.f81198f
                int r7 = r7.g()
                u4.r0 r8 = r6.f81194b
                z3.c0 r9 = r6.f81198f
                r8.c(r9, r7)
                int r8 = r6.f81203k
                int r8 = r8 + r7
                r6.f81203k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f81199g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r1 == 0) goto L84
                int r7 = r6.f81203k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: y5.b.a.c(u4.t, long):boolean");
        }

        public final void d(byte[] bArr, int i11, c0 c0Var) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.f81195c.f81214b; i13++) {
                    e(bArr, i12, i13, c0Var.e());
                }
            }
            int iG = g(this.f81196d * i11);
            c0Var.U(0);
            c0Var.T(iG);
        }

        public final void e(byte[] bArr, int i11, int i12, byte[] bArr2) {
            y5.c cVar = this.f81195c;
            int i13 = cVar.f81217e;
            int i14 = cVar.f81214b;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int iP = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int iMin = Math.min(bArr[i15 + 2] & 255, 88);
            int i18 = f81192n[iMin];
            int i19 = ((i11 * this.f81196d * i14) + i12) * 2;
            bArr2[i19] = (byte) (iP & 255);
            bArr2[i19 + 1] = (byte) (iP >> 8);
            for (int i21 = 0; i21 < i17 * 2; i21++) {
                byte b11 = bArr[((i21 / 8) * i14 * 4) + i16 + ((i21 / 2) % 4)];
                int i22 = i21 % 2 == 0 ? b11 & Ascii.SI : (b11 & 255) >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i18) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                iP = u0.p(iP + i23, -32768, 32767);
                i19 += i14 * 2;
                bArr2[i19] = (byte) (iP & 255);
                bArr2[i19 + 1] = (byte) (iP >> 8);
                int i24 = iMin + f81191m[i22];
                int[] iArr = f81192n;
                iMin = u0.p(i24, 0, iArr.length - 1);
                i18 = iArr[iMin];
            }
        }

        public final int f(int i11) {
            return i11 / (this.f81195c.f81214b * 2);
        }

        public final int g(int i11) {
            return h(i11, this.f81195c.f81214b);
        }

        public final void i(int i11) {
            long jF1 = this.f81202j + u0.f1(this.f81204l, 1000000L, this.f81195c.f81215c);
            int iG = g(i11);
            this.f81194b.f(jF1, 1, iG, this.f81203k - iG, null);
            this.f81204l += (long) i11;
            this.f81203k -= iG;
        }
    }

    /* JADX INFO: renamed from: y5.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0913b {
        void a(int i11, long j11) throws ParserException;

        void b(long j11);

        boolean c(t tVar, long j11) throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements InterfaceC0913b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f81205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0 f81206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y5.c f81207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final androidx.media3.common.y f81208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f81209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f81210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f81211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f81212h;

        public c(u uVar, r0 r0Var, y5.c cVar, String str, int i11) throws ParserException {
            this.f81205a = uVar;
            this.f81206b = r0Var;
            this.f81207c = cVar;
            int i12 = (cVar.f81214b * cVar.f81218f) / 8;
            if (cVar.f81217e == i12) {
                int i13 = cVar.f81215c;
                int i14 = i13 * i12 * 8;
                int iMax = Math.max(i12, (i13 * i12) / 10);
                this.f81209e = iMax;
                this.f81208d = new androidx.media3.common.y.b().k0(str).K(i14).f0(i14).c0(iMax).L(cVar.f81214b).l0(cVar.f81215c).e0(i11).I();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i12 + "; got: " + cVar.f81217e, null);
        }

        @Override // y5.b.InterfaceC0913b
        public void a(int i11, long j11) {
            this.f81205a.f(new e(this.f81207c, 1, i11, j11));
            this.f81206b.b(this.f81208d);
        }

        @Override // y5.b.InterfaceC0913b
        public void b(long j11) {
            this.f81210f = j11;
            this.f81211g = 0;
            this.f81212h = 0L;
        }

        @Override // y5.b.InterfaceC0913b
        public boolean c(t tVar, long j11) throws IOException {
            int i11;
            int i12;
            long j12 = j11;
            while (j12 > 0 && (i11 = this.f81211g) < (i12 = this.f81209e)) {
                int iD = this.f81206b.d(tVar, (int) Math.min(i12 - i11, j12), true);
                if (iD == -1) {
                    j12 = 0;
                } else {
                    this.f81211g += iD;
                    j12 -= (long) iD;
                }
            }
            y5.c cVar = this.f81207c;
            int i13 = cVar.f81217e;
            int i14 = this.f81211g / i13;
            if (i14 > 0) {
                long jF1 = this.f81210f + u0.f1(this.f81212h, 1000000L, cVar.f81215c);
                int i15 = i14 * i13;
                int i16 = this.f81211g - i15;
                this.f81206b.f(jF1, 1, i15, i16, null);
                this.f81212h += (long) i14;
                this.f81211g = i16;
            }
            return j12 <= 0;
        }
    }

    private void e() {
        z3.a.i(this.f81185b);
        u0.i(this.f81184a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ s[] g() {
        return new s[]{new b()};
    }

    @Override // u4.s
    public boolean b(t tVar) throws IOException {
        return d.a(tVar);
    }

    @Override // u4.s
    public /* synthetic */ s c() {
        return r.a(this);
    }

    @Override // u4.s
    public int d(t tVar, l0 l0Var) throws IOException {
        e();
        int i11 = this.f81186c;
        if (i11 == 0) {
            h(tVar);
            return 0;
        }
        if (i11 == 1) {
            j(tVar);
            return 0;
        }
        if (i11 == 2) {
            i(tVar);
            return 0;
        }
        if (i11 == 3) {
            l(tVar);
            return 0;
        }
        if (i11 == 4) {
            return k(tVar);
        }
        throw new IllegalStateException();
    }

    @Override // u4.s
    public void f(u uVar) {
        this.f81184a = uVar;
        this.f81185b = uVar.track(0, 1);
        uVar.endTracks();
    }

    public final void h(t tVar) throws IOException {
        z3.a.g(tVar.getPosition() == 0);
        int i11 = this.f81189f;
        if (i11 != -1) {
            tVar.skipFully(i11);
            this.f81186c = 4;
        } else {
            if (!d.a(tVar)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            tVar.skipFully((int) (tVar.getPeekPosition() - tVar.getPosition()));
            this.f81186c = 1;
        }
    }

    public final void i(t tVar) throws IOException {
        y5.c cVarB = d.b(tVar);
        int i11 = cVarB.f81213a;
        if (i11 == 17) {
            this.f81188e = new a(this.f81184a, this.f81185b, cVarB);
        } else if (i11 == 6) {
            this.f81188e = new c(this.f81184a, this.f81185b, cVarB, MimeTypes.AUDIO_ALAW, -1);
        } else if (i11 == 7) {
            this.f81188e = new c(this.f81184a, this.f81185b, cVarB, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int iA = v0.a(i11, cVarB.f81218f);
            if (iA == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + cVarB.f81213a);
            }
            this.f81188e = new c(this.f81184a, this.f81185b, cVarB, MimeTypes.AUDIO_RAW, iA);
        }
        this.f81186c = 3;
    }

    public final void j(t tVar) throws IOException {
        this.f81187d = d.c(tVar);
        this.f81186c = 2;
    }

    public final int k(t tVar) throws IOException {
        z3.a.g(this.f81190g != -1);
        return ((InterfaceC0913b) z3.a.e(this.f81188e)).c(tVar, this.f81190g - tVar.getPosition()) ? -1 : 0;
    }

    public final void l(t tVar) throws IOException {
        Pair<Long, Long> pairE = d.e(tVar);
        this.f81189f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j11 = this.f81187d;
        if (j11 != -1 && jLongValue == 4294967295L) {
            jLongValue = j11;
        }
        this.f81190g = ((long) this.f81189f) + jLongValue;
        long length = tVar.getLength();
        if (length != -1 && this.f81190g > length) {
            o.h("WavExtractor", "Data exceeds input length: " + this.f81190g + ", " + length);
            this.f81190g = length;
        }
        ((InterfaceC0913b) z3.a.e(this.f81188e)).a(this.f81189f, this.f81190g);
        this.f81186c = 4;
    }

    @Override // u4.s
    public void release() {
    }

    @Override // u4.s
    public void seek(long j11, long j12) {
        this.f81186c = j11 == 0 ? 0 : 4;
        InterfaceC0913b interfaceC0913b = this.f81188e;
        if (interfaceC0913b != null) {
            interfaceC0913b.b(j12);
        }
    }
}

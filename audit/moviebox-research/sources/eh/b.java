package eh;

import android.net.Uri;
import android.util.Pair;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.i0;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Map;
import tg.a0;
import tg.e0;
import tg.l;
import tg.m;
import tg.n;
import tg.q;
import tg.r;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b implements l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r f64169h = new r() { // from class: eh.a
        @Override // tg.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }

        @Override // tg.r
        public final l[] createExtractors() {
            return b.f();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f64170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f64171b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InterfaceC0662b f64174e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f64172c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f64173d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f64175f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f64176g = -1;

    /* JADX INFO: compiled from: source.java */
    public static final class a implements InterfaceC0662b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int[] f64177m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int[] f64178n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f64179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0 f64180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eh.c f64181c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f64182d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final byte[] f64183e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f64184f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f64185g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final m1 f64186h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f64187i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f64188j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f64189k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f64190l;

        public a(n nVar, e0 e0Var, eh.c cVar) throws ParserException {
            this.f64179a = nVar;
            this.f64180b = e0Var;
            this.f64181c = cVar;
            int iMax = Math.max(1, cVar.f64201c / 10);
            this.f64185g = iMax;
            c0 c0Var = new c0(cVar.f64205g);
            c0Var.v();
            int iV = c0Var.v();
            this.f64182d = iV;
            int i11 = cVar.f64200b;
            int i12 = (((cVar.f64203e - (i11 * 4)) * 8) / (cVar.f64204f * i11)) + 1;
            if (iV == i12) {
                int iL = o0.l(iMax, iV);
                this.f64183e = new byte[cVar.f64203e * iL];
                this.f64184f = new c0(iL * h(iV, i11));
                int i13 = ((cVar.f64201c * cVar.f64203e) * 8) / iV;
                this.f64186h = new m1.b().e0(MimeTypes.AUDIO_RAW).G(i13).Z(i13).W(h(iMax, i11)).H(cVar.f64200b).f0(cVar.f64201c).Y(2).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i12 + "; got: " + iV, null);
        }

        public static int h(int i11, int i12) {
            return i11 * 2 * i12;
        }

        @Override // eh.b.InterfaceC0662b
        public void a(int i11, long j11) {
            this.f64179a.g(new e(this.f64181c, this.f64182d, i11, j11));
            this.f64180b.e(this.f64186h);
        }

        @Override // eh.b.InterfaceC0662b
        public void b(long j11) {
            this.f64187i = 0;
            this.f64188j = j11;
            this.f64189k = 0;
            this.f64190l = 0L;
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
        @Override // eh.b.InterfaceC0662b
        public boolean c(tg.m r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f64185g
                int r1 = r6.f64189k
                int r1 = r6.f(r1)
                int r0 = r0 - r1
                int r1 = r6.f64182d
                int r0 = com.google.android.exoplayer2.util.o0.l(r0, r1)
                eh.c r1 = r6.f64181c
                int r1 = r1.f64203e
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
                int r2 = r6.f64187i
                if (r2 >= r0) goto L3f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.f64183e
                int r5 = r6.f64187i
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L39
                goto L1c
            L39:
                int r4 = r6.f64187i
                int r4 = r4 + r2
                r6.f64187i = r4
                goto L1f
            L3f:
                int r7 = r6.f64187i
                eh.c r8 = r6.f64181c
                int r8 = r8.f64203e
                int r7 = r7 / r8
                if (r7 <= 0) goto L77
                byte[] r8 = r6.f64183e
                com.google.android.exoplayer2.util.c0 r9 = r6.f64184f
                r6.d(r8, r7, r9)
                int r8 = r6.f64187i
                eh.c r9 = r6.f64181c
                int r9 = r9.f64203e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f64187i = r8
                com.google.android.exoplayer2.util.c0 r7 = r6.f64184f
                int r7 = r7.f()
                tg.e0 r8 = r6.f64180b
                com.google.android.exoplayer2.util.c0 r9 = r6.f64184f
                r8.c(r9, r7)
                int r8 = r6.f64189k
                int r8 = r8 + r7
                r6.f64189k = r8
                int r7 = r6.f(r8)
                int r8 = r6.f64185g
                if (r7 < r8) goto L77
                r6.i(r8)
            L77:
                if (r1 == 0) goto L84
                int r7 = r6.f64189k
                int r7 = r6.f(r7)
                if (r7 <= 0) goto L84
                r6.i(r7)
            L84:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: eh.b.a.c(tg.m, long):boolean");
        }

        public final void d(byte[] bArr, int i11, c0 c0Var) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.f64181c.f64200b; i13++) {
                    e(bArr, i12, i13, c0Var.d());
                }
            }
            int iG = g(this.f64182d * i11);
            c0Var.P(0);
            c0Var.O(iG);
        }

        public final void e(byte[] bArr, int i11, int i12, byte[] bArr2) {
            eh.c cVar = this.f64181c;
            int i13 = cVar.f64203e;
            int i14 = cVar.f64200b;
            int i15 = (i11 * i13) + (i12 * 4);
            int i16 = (i14 * 4) + i15;
            int i17 = (i13 / i14) - 4;
            int iQ = (short) (((bArr[i15 + 1] & 255) << 8) | (bArr[i15] & 255));
            int iMin = Math.min(bArr[i15 + 2] & 255, 88);
            int i18 = f64178n[iMin];
            int i19 = ((i11 * this.f64182d * i14) + i12) * 2;
            bArr2[i19] = (byte) (iQ & 255);
            bArr2[i19 + 1] = (byte) (iQ >> 8);
            for (int i21 = 0; i21 < i17 * 2; i21++) {
                byte b11 = bArr[((i21 / 8) * i14 * 4) + i16 + ((i21 / 2) % 4)];
                int i22 = i21 % 2 == 0 ? b11 & Ascii.SI : (b11 & 255) >> 4;
                int i23 = ((((i22 & 7) * 2) + 1) * i18) >> 3;
                if ((i22 & 8) != 0) {
                    i23 = -i23;
                }
                iQ = o0.q(iQ + i23, -32768, 32767);
                i19 += i14 * 2;
                bArr2[i19] = (byte) (iQ & 255);
                bArr2[i19 + 1] = (byte) (iQ >> 8);
                int i24 = iMin + f64177m[i22];
                int[] iArr = f64178n;
                iMin = o0.q(i24, 0, iArr.length - 1);
                i18 = iArr[iMin];
            }
        }

        public final int f(int i11) {
            return i11 / (this.f64181c.f64200b * 2);
        }

        public final int g(int i11) {
            return h(i11, this.f64181c.f64200b);
        }

        public final void i(int i11) {
            long jO0 = this.f64188j + o0.O0(this.f64190l, 1000000L, this.f64181c.f64201c);
            int iG = g(i11);
            this.f64180b.d(jO0, 1, iG, this.f64189k - iG, null);
            this.f64190l += (long) i11;
            this.f64189k -= iG;
        }
    }

    /* JADX INFO: renamed from: eh.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0662b {
        void a(int i11, long j11) throws ParserException;

        void b(long j11);

        boolean c(m mVar, long j11) throws IOException;
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements InterfaceC0662b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f64191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e0 f64192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final eh.c f64193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final m1 f64194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f64195e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f64196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f64197g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f64198h;

        public c(n nVar, e0 e0Var, eh.c cVar, String str, int i11) throws ParserException {
            this.f64191a = nVar;
            this.f64192b = e0Var;
            this.f64193c = cVar;
            int i12 = (cVar.f64200b * cVar.f64204f) / 8;
            if (cVar.f64203e == i12) {
                int i13 = cVar.f64201c;
                int i14 = i13 * i12 * 8;
                int iMax = Math.max(i12, (i13 * i12) / 10);
                this.f64195e = iMax;
                this.f64194d = new m1.b().e0(str).G(i14).Z(i14).W(iMax).H(cVar.f64200b).f0(cVar.f64201c).Y(i11).E();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i12 + "; got: " + cVar.f64203e, null);
        }

        @Override // eh.b.InterfaceC0662b
        public void a(int i11, long j11) {
            this.f64191a.g(new e(this.f64193c, 1, i11, j11));
            this.f64192b.e(this.f64194d);
        }

        @Override // eh.b.InterfaceC0662b
        public void b(long j11) {
            this.f64196f = j11;
            this.f64197g = 0;
            this.f64198h = 0L;
        }

        @Override // eh.b.InterfaceC0662b
        public boolean c(m mVar, long j11) throws IOException {
            int i11;
            int i12;
            long j12 = j11;
            while (j12 > 0 && (i11 = this.f64197g) < (i12 = this.f64195e)) {
                int iB = this.f64192b.b(mVar, (int) Math.min(i12 - i11, j12), true);
                if (iB == -1) {
                    j12 = 0;
                } else {
                    this.f64197g += iB;
                    j12 -= (long) iB;
                }
            }
            eh.c cVar = this.f64193c;
            int i13 = cVar.f64203e;
            int i14 = this.f64197g / i13;
            if (i14 > 0) {
                long jO0 = this.f64196f + o0.O0(this.f64198h, 1000000L, cVar.f64201c);
                int i15 = i14 * i13;
                int i16 = this.f64197g - i15;
                this.f64192b.d(jO0, 1, i15, i16, null);
                this.f64198h += (long) i14;
                this.f64197g = i16;
            }
            return j12 <= 0;
        }
    }

    private void e() {
        com.google.android.exoplayer2.util.a.i(this.f64171b);
        o0.j(this.f64170a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] f() {
        return new l[]{new b()};
    }

    @Override // tg.l
    public boolean b(m mVar) throws IOException {
        return d.a(mVar);
    }

    @Override // tg.l
    public int c(m mVar, a0 a0Var) throws IOException {
        e();
        int i11 = this.f64172c;
        if (i11 == 0) {
            g(mVar);
            return 0;
        }
        if (i11 == 1) {
            i(mVar);
            return 0;
        }
        if (i11 == 2) {
            h(mVar);
            return 0;
        }
        if (i11 == 3) {
            k(mVar);
            return 0;
        }
        if (i11 == 4) {
            return j(mVar);
        }
        throw new IllegalStateException();
    }

    @Override // tg.l
    public void d(n nVar) {
        this.f64170a = nVar;
        this.f64171b = nVar.track(0, 1);
        nVar.endTracks();
    }

    public final void g(m mVar) throws IOException {
        com.google.android.exoplayer2.util.a.g(mVar.getPosition() == 0);
        int i11 = this.f64175f;
        if (i11 != -1) {
            mVar.skipFully(i11);
            this.f64172c = 4;
        } else {
            if (!d.a(mVar)) {
                throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", null);
            }
            mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
            this.f64172c = 1;
        }
    }

    public final void h(m mVar) throws IOException {
        eh.c cVarB = d.b(mVar);
        int i11 = cVarB.f64199a;
        if (i11 == 17) {
            this.f64174e = new a(this.f64170a, this.f64171b, cVarB);
        } else if (i11 == 6) {
            this.f64174e = new c(this.f64170a, this.f64171b, cVarB, MimeTypes.AUDIO_ALAW, -1);
        } else if (i11 == 7) {
            this.f64174e = new c(this.f64170a, this.f64171b, cVarB, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int iA = i0.a(i11, cVarB.f64204f);
            if (iA == 0) {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + cVarB.f64199a);
            }
            this.f64174e = new c(this.f64170a, this.f64171b, cVarB, MimeTypes.AUDIO_RAW, iA);
        }
        this.f64172c = 3;
    }

    public final void i(m mVar) throws IOException {
        this.f64173d = d.c(mVar);
        this.f64172c = 2;
    }

    public final int j(m mVar) throws IOException {
        com.google.android.exoplayer2.util.a.g(this.f64176g != -1);
        return ((InterfaceC0662b) com.google.android.exoplayer2.util.a.e(this.f64174e)).c(mVar, this.f64176g - mVar.getPosition()) ? -1 : 0;
    }

    public final void k(m mVar) throws IOException {
        Pair<Long, Long> pairE = d.e(mVar);
        this.f64175f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j11 = this.f64173d;
        if (j11 != -1 && jLongValue == 4294967295L) {
            jLongValue = j11;
        }
        this.f64176g = ((long) this.f64175f) + jLongValue;
        long length = mVar.getLength();
        if (length != -1 && this.f64176g > length) {
            s.i("WavExtractor", "Data exceeds input length: " + this.f64176g + ", " + length);
            this.f64176g = length;
        }
        ((InterfaceC0662b) com.google.android.exoplayer2.util.a.e(this.f64174e)).a(this.f64175f, this.f64176g);
        this.f64172c = 4;
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f64172c = j11 == 0 ? 0 : 4;
        InterfaceC0662b interfaceC0662b = this.f64174e;
        if (interfaceC0662b != null) {
            interfaceC0662b.b(j12);
        }
    }
}

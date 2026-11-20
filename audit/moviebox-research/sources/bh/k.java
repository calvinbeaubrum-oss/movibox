package bh;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tg.a0;
import tg.b0;
import tg.e0;
import tg.f0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k implements tg.l, b0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final tg.r f14187y = new tg.r() { // from class: bh.i
        @Override // tg.r
        public /* synthetic */ tg.l[] b(Uri uri, Map map) {
            return tg.q.a(this, uri, map);
        }

        @Override // tg.r
        public final tg.l[] createExtractors() {
            return k.n();
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f14189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f14190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c0 f14191d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c0 f14192e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<bh.a.C0144a> f14193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f14194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Metadata.Entry> f14195h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f14196i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f14197j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f14198k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14199l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public c0 f14200m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f14201n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f14202o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f14203p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f14204q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public tg.n f14205r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a[] f14206s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long[][] f14207t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f14208u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f14209v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f14210w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f14211x;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f14212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f14213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e0 f14214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final f0 f14215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f14216e;

        public a(o oVar, r rVar, e0 e0Var) {
            this.f14212a = oVar;
            this.f14213b = rVar;
            this.f14214c = e0Var;
            this.f14215d = MimeTypes.AUDIO_TRUEHD.equals(oVar.f14234f.f33445m) ? new f0() : null;
        }
    }

    public k() {
        this(0);
    }

    public k(int i11) {
        this.f14188a = i11;
        this.f14196i = (i11 & 4) != 0 ? 3 : 0;
        this.f14194g = new m();
        this.f14195h = new ArrayList();
        this.f14192e = new c0(16);
        this.f14193f = new ArrayDeque<>();
        this.f14189b = new c0(x.f35652a);
        this.f14190c = new c0(4);
        this.f14191d = new c0();
        this.f14201n = -1;
        this.f14205r = tg.n.f77074l8;
        this.f14206s = new a[0];
    }

    public static boolean A(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    public static int g(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    public static long[][] h(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            jArr[i11] = new long[aVarArr[i11].f14213b.f14264b];
            jArr2[i11] = aVarArr[i11].f14213b.f14268f[0];
        }
        long j11 = 0;
        int i12 = 0;
        while (i12 < aVarArr.length) {
            long j12 = Long.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < aVarArr.length; i14++) {
                if (!zArr[i14]) {
                    long j13 = jArr2[i14];
                    if (j13 <= j12) {
                        i13 = i14;
                        j12 = j13;
                    }
                }
            }
            int i15 = iArr[i13];
            long[] jArr3 = jArr[i13];
            jArr3[i15] = j11;
            r rVar = aVarArr[i13].f14213b;
            j11 += (long) rVar.f14266d[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr3.length) {
                jArr2[i13] = rVar.f14268f[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    public static int k(r rVar, long j11) {
        int iA = rVar.a(j11);
        return iA == -1 ? rVar.b(j11) : iA;
    }

    public static /* synthetic */ o m(o oVar) {
        return oVar;
    }

    public static /* synthetic */ tg.l[] n() {
        return new tg.l[]{new k()};
    }

    public static long o(r rVar, long j11, long j12) {
        int iK = k(rVar, j11);
        return iK == -1 ? j12 : Math.min(rVar.f14265c[iK], j12);
    }

    public static int s(c0 c0Var) {
        c0Var.P(8);
        int iG = g(c0Var.n());
        if (iG != 0) {
            return iG;
        }
        c0Var.Q(4);
        while (c0Var.a() > 0) {
            int iG2 = g(c0Var.n());
            if (iG2 != 0) {
                return iG2;
            }
        }
        return 0;
    }

    public static boolean z(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    public final void B(a aVar, long j11) {
        r rVar = aVar.f14213b;
        int iA = rVar.a(j11);
        if (iA == -1) {
            iA = rVar.b(j11);
        }
        aVar.f14216e = iA;
    }

    @Override // tg.l
    public boolean b(tg.m mVar) throws IOException {
        return n.d(mVar, (this.f14188a & 2) != 0);
    }

    @Override // tg.l
    public int c(tg.m mVar, a0 a0Var) throws IOException {
        while (true) {
            int i11 = this.f14196i;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return x(mVar, a0Var);
                    }
                    if (i11 == 3) {
                        return y(mVar, a0Var);
                    }
                    throw new IllegalStateException();
                }
                if (w(mVar, a0Var)) {
                    return 1;
                }
            } else if (!v(mVar)) {
                return -1;
            }
        }
    }

    @Override // tg.l
    public void d(tg.n nVar) {
        this.f14205r = nVar;
    }

    @Override // tg.b0
    public long getDurationUs() {
        return this.f14209v;
    }

    @Override // tg.b0
    public b0.a getSeekPoints(long j11) {
        return j(j11, -1);
    }

    public final void i() {
        this.f14196i = 0;
        this.f14199l = 0;
    }

    @Override // tg.b0
    public boolean isSeekable() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0062  */
    /* JADX WARN: Code duplicated, block: B:30:0x0068  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0078  */
    /* JADX WARN: Code duplicated, block: B:39:0x0089  */
    /* JADX WARN: Code duplicated, block: B:41:0x008f  */
    /* JADX WARN: Code duplicated, block: B:43:0x0080 A[EDGE_INSN: B:43:0x0080->B:37:0x0080 BREAK  A[LOOP:0: B:28:0x0063->B:36:0x007d], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x007d A[SYNTHETIC] */
    public b0.a j(long j11, int i11) {
        long j12;
        long j13;
        long jO;
        long j14;
        int i12;
        a[] aVarArr;
        r rVar;
        int iB;
        a[] aVarArr2 = this.f14206s;
        if (aVarArr2.length == 0) {
            return new b0.a(tg.c0.f76995c);
        }
        int i13 = i11 != -1 ? i11 : this.f14208u;
        if (i13 != -1) {
            r rVar2 = aVarArr2[i13].f14213b;
            int iK = k(rVar2, j11);
            if (iK == -1) {
                return new b0.a(tg.c0.f76995c);
            }
            j13 = rVar2.f14268f[iK];
            j12 = rVar2.f14265c[iK];
            if (j13 < j11 && iK < rVar2.f14264b - 1 && (iB = rVar2.b(j11)) != -1 && iB != iK) {
                j14 = rVar2.f14268f[iB];
                jO = rVar2.f14265c[iB];
            }
            if (i11 == -1) {
                i12 = 0;
                while (true) {
                    aVarArr = this.f14206s;
                    if (i12 < aVarArr.length) {
                        break;
                    }
                    if (i12 != this.f14208u) {
                        rVar = aVarArr[i12].f14213b;
                        long jO2 = o(rVar, j13, j12);
                        if (j14 != C.TIME_UNSET) {
                            jO = o(rVar, j14, jO);
                        }
                        j12 = jO2;
                    }
                    i12++;
                }
            }
            tg.c0 c0Var = new tg.c0(j13, j12);
            return j14 == C.TIME_UNSET ? new b0.a(c0Var) : new b0.a(c0Var, new tg.c0(j14, jO));
        }
        j12 = Long.MAX_VALUE;
        j13 = j11;
        jO = -1;
        j14 = -9223372036854775807L;
        if (i11 == -1) {
            i12 = 0;
            while (true) {
                aVarArr = this.f14206s;
                if (i12 < aVarArr.length) {
                    break;
                    break;
                }
                if (i12 != this.f14208u) {
                    rVar = aVarArr[i12].f14213b;
                    long jO3 = o(rVar, j13, j12);
                    if (j14 != C.TIME_UNSET) {
                        jO = o(rVar, j14, jO);
                    }
                    j12 = jO3;
                }
                i12++;
            }
        }
        tg.c0 c0Var2 = new tg.c0(j13, j12);
        if (j14 == C.TIME_UNSET) {
        }
    }

    public final int l(long j11) {
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        boolean z12 = true;
        long j14 = Long.MAX_VALUE;
        while (true) {
            a[] aVarArr = this.f14206s;
            if (i13 >= aVarArr.length) {
                break;
            }
            a aVar = aVarArr[i13];
            int i14 = aVar.f14216e;
            r rVar = aVar.f14213b;
            if (i14 != rVar.f14264b) {
                long j15 = rVar.f14265c[i14];
                long j16 = ((long[][]) o0.j(this.f14207t))[i13][i14];
                long j17 = j15 - j11;
                boolean z13 = j17 < 0 || j17 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z13 && z12) || (z13 == z12 && j17 < j14)) {
                    z12 = z13;
                    j14 = j17;
                    i12 = i13;
                    j13 = j16;
                }
                if (j16 < j12) {
                    z11 = z13;
                    i11 = i13;
                    j12 = j16;
                }
            }
            i13++;
        }
        return (j12 == Long.MAX_VALUE || !z11 || j13 < j12 + 10485760) ? i12 : i11;
    }

    public final void p(tg.m mVar) throws IOException {
        this.f14191d.L(8);
        mVar.peekFully(this.f14191d.d(), 0, 8);
        b.e(this.f14191d);
        mVar.skipFully(this.f14191d.e());
        mVar.resetPeekPosition();
    }

    public final void q(long j11) throws ParserException {
        while (!this.f14193f.isEmpty() && this.f14193f.peek().f14101b == j11) {
            bh.a.C0144a c0144aPop = this.f14193f.pop();
            if (c0144aPop.f14100a == 1836019574) {
                t(c0144aPop);
                this.f14193f.clear();
                this.f14196i = 2;
            } else if (!this.f14193f.isEmpty()) {
                this.f14193f.peek().d(c0144aPop);
            }
        }
        if (this.f14196i != 2) {
            i();
        }
    }

    public final void r() {
        if (this.f14210w != 2 || (this.f14188a & 2) == 0) {
            return;
        }
        this.f14205r.track(0, 4).e(new m1.b().X(this.f14211x == null ? null : new Metadata(this.f14211x)).E());
        this.f14205r.endTracks();
        this.f14205r.g(new b0.b(C.TIME_UNSET));
    }

    @Override // tg.l
    public void release() {
    }

    @Override // tg.l
    public void seek(long j11, long j12) {
        this.f14193f.clear();
        this.f14199l = 0;
        this.f14201n = -1;
        this.f14202o = 0;
        this.f14203p = 0;
        this.f14204q = 0;
        if (j11 == 0) {
            if (this.f14196i != 3) {
                i();
                return;
            } else {
                this.f14194g.g();
                this.f14195h.clear();
                return;
            }
        }
        for (a aVar : this.f14206s) {
            B(aVar, j12);
            f0 f0Var = aVar.f14215d;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    public final void t(bh.a.C0144a c0144a) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        int i11;
        ArrayList arrayList = new ArrayList();
        boolean z11 = this.f14210w == 1;
        tg.x xVar = new tg.x();
        bh.a.b bVarG = c0144a.g(1969517665);
        if (bVarG != null) {
            Pair<Metadata, Metadata> pairB = b.B(bVarG);
            Metadata metadata3 = (Metadata) pairB.first;
            Metadata metadata4 = (Metadata) pairB.second;
            if (metadata3 != null) {
                xVar.c(metadata3);
            }
            metadata = metadata4;
            metadata2 = metadata3;
        } else {
            metadata = null;
            metadata2 = null;
        }
        bh.a.C0144a c0144aF = c0144a.f(1835365473);
        Metadata metadataN = c0144aF != null ? b.n(c0144aF) : null;
        List<r> listA = b.A(c0144a, xVar, C.TIME_UNSET, null, (this.f14188a & 1) != 0, z11, new com.google.common.base.f() { // from class: bh.j
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return k.m((o) obj);
            }
        });
        int size = listA.size();
        long j11 = C.TIME_UNSET;
        long j12 = -9223372036854775807L;
        int i12 = 0;
        int size2 = -1;
        while (i12 < size) {
            r rVar = listA.get(i12);
            if (rVar.f14264b != 0) {
                o oVar = rVar.f14263a;
                long j13 = oVar.f14233e;
                if (j13 == j11) {
                    j13 = rVar.f14270h;
                }
                long jMax = Math.max(j12, j13);
                a aVar = new a(oVar, rVar, this.f14205r.track(i12, oVar.f14230b));
                int i13 = MimeTypes.AUDIO_TRUEHD.equals(oVar.f14234f.f33445m) ? rVar.f14267e * 16 : rVar.f14267e + 30;
                m1.b bVarB = oVar.f14234f.b();
                bVarB.W(i13);
                if (oVar.f14230b == 2 && j13 > 0 && (i11 = rVar.f14264b) > 1) {
                    bVarB.P(i11 / (j13 / 1000000.0f));
                }
                h.k(oVar.f14230b, xVar, bVarB);
                int i14 = oVar.f14230b;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata;
                metadataArr[1] = this.f14195h.isEmpty() ? null : new Metadata(this.f14195h);
                h.l(i14, metadata2, metadataN, bVarB, metadataArr);
                aVar.f14214c.e(bVarB.E());
                if (oVar.f14230b == 2 && size2 == -1) {
                    size2 = arrayList.size();
                }
                arrayList.add(aVar);
                j12 = jMax;
            }
            i12++;
            listA = listA;
            size = size;
            j11 = C.TIME_UNSET;
        }
        this.f14208u = size2;
        this.f14209v = j12;
        a[] aVarArr = (a[]) arrayList.toArray(new a[0]);
        this.f14206s = aVarArr;
        this.f14207t = h(aVarArr);
        this.f14205r.endTracks();
        this.f14205r.g(this);
    }

    public final void u(long j11) {
        if (this.f14197j == 1836086884) {
            int i11 = this.f14199l;
            this.f14211x = new MotionPhotoMetadata(0L, j11, C.TIME_UNSET, j11 + ((long) i11), this.f14198k - ((long) i11));
        }
    }

    public final boolean v(tg.m mVar) throws IOException {
        bh.a.C0144a c0144aPeek;
        if (this.f14199l == 0) {
            if (!mVar.readFully(this.f14192e.d(), 0, 8, true)) {
                r();
                return false;
            }
            this.f14199l = 8;
            this.f14192e.P(0);
            this.f14198k = this.f14192e.F();
            this.f14197j = this.f14192e.n();
        }
        long j11 = this.f14198k;
        if (j11 == 1) {
            mVar.readFully(this.f14192e.d(), 8, 8);
            this.f14199l += 8;
            this.f14198k = this.f14192e.I();
        } else if (j11 == 0) {
            long length = mVar.getLength();
            if (length == -1 && (c0144aPeek = this.f14193f.peek()) != null) {
                length = c0144aPeek.f14101b;
            }
            if (length != -1) {
                this.f14198k = (length - mVar.getPosition()) + ((long) this.f14199l);
            }
        }
        if (this.f14198k < this.f14199l) {
            throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
        }
        if (z(this.f14197j)) {
            long position = mVar.getPosition();
            long j12 = this.f14198k;
            int i11 = this.f14199l;
            long j13 = (position + j12) - ((long) i11);
            if (j12 != i11 && this.f14197j == 1835365473) {
                p(mVar);
            }
            this.f14193f.push(new bh.a.C0144a(this.f14197j, j13));
            if (this.f14198k == this.f14199l) {
                q(j13);
            } else {
                i();
            }
        } else if (A(this.f14197j)) {
            com.google.android.exoplayer2.util.a.g(this.f14199l == 8);
            com.google.android.exoplayer2.util.a.g(this.f14198k <= 2147483647L);
            c0 c0Var = new c0((int) this.f14198k);
            System.arraycopy(this.f14192e.d(), 0, c0Var.d(), 0, 8);
            this.f14200m = c0Var;
            this.f14196i = 1;
        } else {
            u(mVar.getPosition() - ((long) this.f14199l));
            this.f14200m = null;
            this.f14196i = 1;
        }
        return true;
    }

    public final boolean w(tg.m mVar, a0 a0Var) throws IOException {
        boolean z11;
        long j11 = this.f14198k - ((long) this.f14199l);
        long position = mVar.getPosition() + j11;
        c0 c0Var = this.f14200m;
        if (c0Var == null) {
            if (j11 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                mVar.skipFully((int) j11);
            } else {
                a0Var.f76990a = mVar.getPosition() + j11;
                z11 = true;
            }
            q(position);
            return (z11 || this.f14196i == 2) ? false : true;
        }
        mVar.readFully(c0Var.d(), this.f14199l, (int) j11);
        if (this.f14197j == 1718909296) {
            this.f14210w = s(c0Var);
        } else if (!this.f14193f.isEmpty()) {
            this.f14193f.peek().e(new bh.a.b(this.f14197j, c0Var));
        }
        z11 = false;
        q(position);
        if (z11) {
        }
    }

    public final int x(tg.m mVar, a0 a0Var) throws IOException {
        long position = mVar.getPosition();
        if (this.f14201n == -1) {
            int iL = l(position);
            this.f14201n = iL;
            if (iL == -1) {
                return -1;
            }
        }
        a aVar = this.f14206s[this.f14201n];
        e0 e0Var = aVar.f14214c;
        int i11 = aVar.f14216e;
        r rVar = aVar.f14213b;
        long j11 = rVar.f14265c[i11];
        int i12 = rVar.f14266d[i11];
        f0 f0Var = aVar.f14215d;
        long j12 = (j11 - position) + ((long) this.f14202o);
        if (j12 < 0 || j12 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            int i13 = 1;
            a0Var.f76990a = j11;
            return i13;
        }
        if (aVar.f14212a.f14235g == 1) {
            j12 += 8;
            i12 -= 8;
        }
        mVar.skipFully((int) j12);
        o oVar = aVar.f14212a;
        if (oVar.f14238j == 0) {
            if ("audio/ac4".equals(oVar.f14234f.f33445m)) {
                if (this.f14203p == 0) {
                    com.google.android.exoplayer2.audio.c.a(i12, this.f14191d);
                    e0Var.c(this.f14191d, 7);
                    this.f14203p += 7;
                }
                i12 += 7;
            } else if (f0Var != null) {
                f0Var.d(mVar);
            }
            while (true) {
                int i14 = this.f14203p;
                if (i14 >= i12) {
                    break;
                }
                int iB = e0Var.b(mVar, i12 - i14, false);
                this.f14202o += iB;
                this.f14203p += iB;
                this.f14204q -= iB;
            }
        } else {
            byte[] bArrD = this.f14190c.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i15 = aVar.f14212a.f14238j;
            int i16 = 4 - i15;
            while (this.f14203p < i12) {
                int i17 = this.f14204q;
                if (i17 == 0) {
                    mVar.readFully(bArrD, i16, i15);
                    this.f14202o += i15;
                    this.f14190c.P(0);
                    int iN = this.f14190c.n();
                    if (iN < 0) {
                        throw ParserException.createForMalformedContainer("Invalid NAL length", null);
                    }
                    this.f14204q = iN;
                    this.f14189b.P(0);
                    e0Var.c(this.f14189b, 4);
                    this.f14203p += 4;
                    i12 += i16;
                } else {
                    int iB2 = e0Var.b(mVar, i17, false);
                    this.f14202o += iB2;
                    this.f14203p += iB2;
                    this.f14204q -= iB2;
                }
            }
        }
        int i18 = i12;
        r rVar2 = aVar.f14213b;
        long j13 = rVar2.f14268f[i11];
        int i19 = rVar2.f14269g[i11];
        if (f0Var != null) {
            f0Var.c(e0Var, j13, i19, i18, 0, null);
            if (i11 + 1 == aVar.f14213b.f14264b) {
                f0Var.a(e0Var, null);
            }
        } else {
            e0Var.d(j13, i19, i18, 0, null);
        }
        aVar.f14216e++;
        this.f14201n = -1;
        this.f14202o = 0;
        this.f14203p = 0;
        this.f14204q = 0;
        return 0;
    }

    public final int y(tg.m mVar, a0 a0Var) throws IOException {
        int iC = this.f14194g.c(mVar, a0Var, this.f14195h);
        if (iC == 1 && a0Var.f76990a == 0) {
            i();
        }
        return iC;
    }
}

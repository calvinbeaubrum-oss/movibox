package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.f0;
import androidx.media3.common.n0;
import androidx.media3.common.y;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.b3;
import androidx.media3.exoplayer.t1;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.w1;
import androidx.media3.extractor.metadata.icy.IcyHeaders;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p4.k0;
import s4.z;
import u4.e0;
import u4.l0;
import u4.m0;
import u4.r0;
import z3.c0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p implements k, u4.u, Loader.b<b>, Loader.e, s.d {
    public static final Map<String, String> O = A();
    public static final y P = new y.b().X("icy").k0("application/x-icy").I();
    public m0 A;
    public long B;
    public boolean C;
    public int D;
    public boolean E;
    public boolean F;
    public int G;
    public boolean H;
    public long I;
    public long J;
    public boolean K;
    public int L;
    public boolean M;
    public boolean N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f11230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.datasource.a f11231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.c f11232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.m f11233d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m.a f11234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.media3.exoplayer.drm.b.a f11235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f11236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final androidx.media3.exoplayer.upstream.b f11237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f11238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f11239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Loader f11240l = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o f11241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z3.g f11242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Runnable f11243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f11244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f11245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f11246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public k.a f11247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @Nullable
    public IcyHeaders f11248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public s[] f11249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public e[] f11250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f f11254z;

    /* JADX INFO: compiled from: source.java */
    public class a extends e0 {
        public a(m0 m0Var) {
            super(m0Var);
        }

        @Override // u4.e0, u4.m0
        public long getDurationUs() {
            return p.this.B;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class b implements Loader.d, h.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f11257b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c4.m f11258c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final o f11259d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final u4.u f11260e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final z3.g f11261f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f11263h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f11265j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public r0 f11267l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f11268m;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final l0 f11262g = new l0();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f11264i = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f11256a = p4.n.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public c4.g f11266k = g(0);

        public b(Uri uri, androidx.media3.datasource.a aVar, o oVar, u4.u uVar, z3.g gVar) {
            this.f11257b = uri;
            this.f11258c = new c4.m(aVar);
            this.f11259d = oVar;
            this.f11260e = uVar;
            this.f11261f = gVar;
        }

        @Override // androidx.media3.exoplayer.source.h.a
        public void a(c0 c0Var) {
            long jMax = !this.f11268m ? this.f11265j : Math.max(p.this.C(true), this.f11265j);
            int iA = c0Var.a();
            r0 r0Var = (r0) z3.a.e(this.f11267l);
            r0Var.c(c0Var, iA);
            r0Var.f(jMax, 1, iA, 0, null);
            this.f11268m = true;
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void cancelLoad() {
            this.f11263h = true;
        }

        public final c4.g g(long j11) {
            return new c4.g.b().i(this.f11257b).h(j11).f(p.this.f11238j).b(6).e(p.O).a();
        }

        public final void h(long j11, long j12) {
            this.f11262g.f78322a = j11;
            this.f11265j = j12;
            this.f11264i = true;
            this.f11268m = false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x004b */
        @Override // androidx.media3.exoplayer.upstream.Loader.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void load() throws IOException {
            int iD = 0;
            while (iD == 0 && !this.f11263h) {
                long j11 = this.f11262g.f78322a;
                c4.g gVarG = g(j11);
                this.f11266k = gVarG;
                long jA = this.f11258c.a(gVarG);
                if (this.f11263h) {
                    if (iD != 1 && this.f11259d.b() != -1) {
                        this.f11262g.f78322a = this.f11259d.b();
                    }
                    c4.f.a(this.f11258c);
                    return;
                }
                if (jA != -1) {
                    jA += j11;
                    p.this.O();
                }
                long j12 = jA;
                p.this.f11248t = IcyHeaders.parse(this.f11258c.getResponseHeaders());
                androidx.media3.common.l hVar = this.f11258c;
                if (p.this.f11248t != null && p.this.f11248t.metadataInterval != -1) {
                    hVar = new h(this.f11258c, p.this.f11248t.metadataInterval, this);
                    r0 r0VarD = p.this.D();
                    this.f11267l = r0VarD;
                    r0VarD.b(p.P);
                }
                long jB = j11;
                this.f11259d.c(hVar, this.f11257b, this.f11258c.getResponseHeaders(), j11, j12, this.f11260e);
                if (p.this.f11248t != null) {
                    this.f11259d.a();
                }
                if (this.f11264i) {
                    this.f11259d.seek(jB, this.f11265j);
                    this.f11264i = false;
                }
                while (true) {
                    long j13 = jB;
                    while (true) {
                        if (iD != 0 || this.f11263h) {
                            break;
                        }
                        try {
                            this.f11261f.a();
                            iD = this.f11259d.d(this.f11262g);
                            jB = this.f11259d.b();
                            if (jB > p.this.f11239k + j13) {
                                this.f11261f.d();
                                p.this.f11245q.post(p.this.f11244p);
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (iD == 1) {
                    iD = 0;
                } else if (this.f11259d.b() != -1) {
                    this.f11262g.f78322a = this.f11259d.b();
                }
                c4.f.a(this.f11258c);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        void b(long j11, boolean z11, boolean z12);
    }

    /* JADX INFO: compiled from: source.java */
    public final class d implements p4.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11270a;

        public d(int i11) {
            this.f11270a = i11;
        }

        @Override // p4.e0
        public int c(t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return p.this.T(this.f11270a, t1Var, decoderInputBuffer, i11);
        }

        @Override // p4.e0
        public boolean isReady() {
            return p.this.F(this.f11270a);
        }

        @Override // p4.e0
        public void maybeThrowError() throws IOException {
            p.this.N(this.f11270a);
        }

        @Override // p4.e0
        public int skipData(long j11) {
            return p.this.X(this.f11270a, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f11273b;

        public e(int i11, boolean z11) {
            this.f11272a = i11;
            this.f11273b = z11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || e.class != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            return this.f11272a == eVar.f11272a && this.f11273b == eVar.f11273b;
        }

        public int hashCode() {
            return (this.f11272a * 31) + (this.f11273b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f11274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f11275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f11276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f11277d;

        public f(k0 k0Var, boolean[] zArr) {
            this.f11274a = k0Var;
            this.f11275b = zArr;
            int i11 = k0Var.f73574a;
            this.f11276c = new boolean[i11];
            this.f11277d = new boolean[i11];
        }
    }

    public p(Uri uri, androidx.media3.datasource.a aVar, o oVar, androidx.media3.exoplayer.drm.c cVar, androidx.media3.exoplayer.drm.b.a aVar2, androidx.media3.exoplayer.upstream.m mVar, m.a aVar3, c cVar2, androidx.media3.exoplayer.upstream.b bVar, @Nullable String str, int i11, long j11) {
        this.f11230a = uri;
        this.f11231b = aVar;
        this.f11232c = cVar;
        this.f11235g = aVar2;
        this.f11233d = mVar;
        this.f11234f = aVar3;
        this.f11236h = cVar2;
        this.f11237i = bVar;
        this.f11238j = str;
        this.f11239k = i11;
        this.f11241m = oVar;
        this.B = j11;
        this.f11246r = j11 != C.TIME_UNSET;
        this.f11242n = new z3.g();
        this.f11243o = new Runnable() { // from class: p4.y
            @Override // java.lang.Runnable
            public final void run() {
                this.f73618a.J();
            }
        };
        this.f11244p = new Runnable() { // from class: p4.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f73619a.G();
            }
        };
        this.f11245q = u0.A();
        this.f11250v = new e[0];
        this.f11249u = new s[0];
        this.J = C.TIME_UNSET;
        this.D = 1;
    }

    public static Map<String, String> A() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    private boolean E() {
        return this.J != C.TIME_UNSET;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        if (this.N || this.f11252x || !this.f11251w || this.A == null) {
            return;
        }
        for (s sVar : this.f11249u) {
            if (sVar.G() == null) {
                return;
            }
        }
        this.f11242n.d();
        int length = this.f11249u.length;
        n0[] n0VarArr = new n0[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            y yVarI = (y) z3.a.e(this.f11249u[i11].G());
            String str = yVarI.f9501m;
            boolean zO = f0.o(str);
            boolean z11 = zO || f0.s(str);
            zArr[i11] = z11;
            this.f11253y = z11 | this.f11253y;
            IcyHeaders icyHeaders = this.f11248t;
            if (icyHeaders != null) {
                if (zO || this.f11250v[i11].f11273b) {
                    Metadata metadata = yVarI.f9499k;
                    yVarI = yVarI.b().d0(metadata == null ? new Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).I();
                }
                if (zO && yVarI.f9495g == -1 && yVarI.f9496h == -1 && icyHeaders.bitrate != -1) {
                    yVarI = yVarI.b().K(icyHeaders.bitrate).I();
                }
            }
            n0VarArr[i11] = new n0(Integer.toString(i11), yVarI.c(this.f11232c.c(yVarI)));
        }
        this.f11254z = new f(new k0(n0VarArr), zArr);
        this.f11252x = true;
        ((k.a) z3.a.e(this.f11247s)).f(this);
    }

    public final int B() {
        int iH = 0;
        for (s sVar : this.f11249u) {
            iH += sVar.H();
        }
        return iH;
    }

    public final long C(boolean z11) {
        long jMax = Long.MIN_VALUE;
        for (int i11 = 0; i11 < this.f11249u.length; i11++) {
            if (z11 || ((f) z3.a.e(this.f11254z)).f11276c[i11]) {
                jMax = Math.max(jMax, this.f11249u[i11].A());
            }
        }
        return jMax;
    }

    public r0 D() {
        return S(new e(0, true));
    }

    public boolean F(int i11) {
        return !Z() && this.f11249u[i11].L(this.M);
    }

    public final /* synthetic */ void G() {
        if (this.N) {
            return;
        }
        ((k.a) z3.a.e(this.f11247s)).h(this);
    }

    public final /* synthetic */ void H() {
        this.H = true;
    }

    public final void K(int i11) {
        y();
        f fVar = this.f11254z;
        boolean[] zArr = fVar.f11277d;
        if (zArr[i11]) {
            return;
        }
        y yVarA = fVar.f11274a.b(i11).a(0);
        this.f11234f.h(f0.k(yVarA.f9501m), yVarA, 0, null, this.I);
        zArr[i11] = true;
    }

    public final void L(int i11) {
        y();
        boolean[] zArr = this.f11254z.f11275b;
        if (this.K && zArr[i11]) {
            if (this.f11249u[i11].L(false)) {
                return;
            }
            this.J = 0L;
            this.K = false;
            this.F = true;
            this.I = 0L;
            this.L = 0;
            for (s sVar : this.f11249u) {
                sVar.W();
            }
            ((k.a) z3.a.e(this.f11247s)).h(this);
        }
    }

    public void M() throws IOException {
        this.f11240l.j(this.f11233d.a(this.D));
    }

    public void N(int i11) throws IOException {
        this.f11249u[i11].O();
        M();
    }

    public final void O() {
        this.f11245q.post(new Runnable() { // from class: p4.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f73528a.H();
            }
        });
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void o(b bVar, long j11, long j12, boolean z11) {
        c4.m mVar = bVar.f11258c;
        p4.n nVar = new p4.n(bVar.f11256a, bVar.f11266k, mVar.e(), mVar.f(), j11, j12, mVar.d());
        this.f11233d.b(bVar.f11256a);
        this.f11234f.q(nVar, 1, -1, null, 0, null, bVar.f11265j, this.B);
        if (z11) {
            return;
        }
        for (s sVar : this.f11249u) {
            sVar.W();
        }
        if (this.G > 0) {
            ((k.a) z3.a.e(this.f11247s)).h(this);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void n(b bVar, long j11, long j12) {
        m0 m0Var;
        if (this.B == C.TIME_UNSET && (m0Var = this.A) != null) {
            boolean zIsSeekable = m0Var.isSeekable();
            long jC = C(true);
            long j13 = jC == Long.MIN_VALUE ? 0L : jC + 10000;
            this.B = j13;
            this.f11236h.b(j13, zIsSeekable, this.C);
        }
        c4.m mVar = bVar.f11258c;
        p4.n nVar = new p4.n(bVar.f11256a, bVar.f11266k, mVar.e(), mVar.f(), j11, j12, mVar.d());
        this.f11233d.b(bVar.f11256a);
        this.f11234f.t(nVar, 1, -1, null, 0, null, bVar.f11265j, this.B);
        this.M = true;
        ((k.a) z3.a.e(this.f11247s)).h(this);
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public Loader.c k(b bVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        c4.m mVar = bVar.f11258c;
        p4.n nVar = new p4.n(bVar.f11256a, bVar.f11266k, mVar.e(), mVar.f(), j11, j12, mVar.d());
        long jC = this.f11233d.c(new androidx.media3.exoplayer.upstream.m.c(nVar, new p4.o(1, -1, null, 0, null, u0.B1(bVar.f11265j), u0.B1(this.B)), iOException, i11));
        if (jC == C.TIME_UNSET) {
            cVarG = Loader.f11437g;
        } else {
            int iB = B();
            cVarG = z(bVar, iB) ? Loader.g(iB > this.L, jC) : Loader.f11436f;
        }
        boolean z11 = !cVarG.c();
        this.f11234f.v(nVar, 1, -1, null, 0, null, bVar.f11265j, this.B, iOException, z11);
        if (z11) {
            this.f11233d.b(bVar.f11256a);
        }
        return cVarG;
    }

    public final r0 S(e eVar) {
        int length = this.f11249u.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (eVar.equals(this.f11250v[i11])) {
                return this.f11249u[i11];
            }
        }
        s sVarK = s.k(this.f11237i, this.f11232c, this.f11235g);
        sVarK.e0(this);
        int i12 = length + 1;
        e[] eVarArr = (e[]) Arrays.copyOf(this.f11250v, i12);
        eVarArr[length] = eVar;
        this.f11250v = (e[]) u0.j(eVarArr);
        s[] sVarArr = (s[]) Arrays.copyOf(this.f11249u, i12);
        sVarArr[length] = sVarK;
        this.f11249u = (s[]) u0.j(sVarArr);
        return sVarK;
    }

    public int T(int i11, t1 t1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (Z()) {
            return -3;
        }
        K(i11);
        int iT = this.f11249u[i11].T(t1Var, decoderInputBuffer, i12, this.M);
        if (iT == -3) {
            L(i11);
        }
        return iT;
    }

    public void U() {
        if (this.f11252x) {
            for (s sVar : this.f11249u) {
                sVar.S();
            }
        }
        this.f11240l.l(this);
        this.f11245q.removeCallbacksAndMessages(null);
        this.f11247s = null;
        this.N = true;
    }

    public final boolean V(boolean[] zArr, long j11) {
        int length = this.f11249u.length;
        for (int i11 = 0; i11 < length; i11++) {
            s sVar = this.f11249u[i11];
            if (!(this.f11246r ? sVar.Z(sVar.y()) : sVar.a0(j11, false)) && (zArr[i11] || !this.f11253y)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void I(m0 m0Var) {
        this.A = this.f11248t == null ? m0Var : new m0.b(C.TIME_UNSET);
        if (m0Var.getDurationUs() == C.TIME_UNSET && this.B != C.TIME_UNSET) {
            this.A = new a(this.A);
        }
        this.B = this.A.getDurationUs();
        boolean z11 = !this.H && m0Var.getDurationUs() == C.TIME_UNSET;
        this.C = z11;
        this.D = z11 ? 7 : 1;
        this.f11236h.b(this.B, m0Var.isSeekable(), this.C);
        if (this.f11252x) {
            return;
        }
        J();
    }

    public int X(int i11, long j11) {
        if (Z()) {
            return 0;
        }
        K(i11);
        s sVar = this.f11249u[i11];
        int iF = sVar.F(j11, this.M);
        sVar.f0(iF);
        if (iF == 0) {
            L(i11);
        }
        return iF;
    }

    public final void Y() {
        b bVar = new b(this.f11230a, this.f11231b, this.f11241m, this, this.f11242n);
        if (this.f11252x) {
            z3.a.g(E());
            long j11 = this.B;
            if (j11 != C.TIME_UNSET && this.J > j11) {
                this.M = true;
                this.J = C.TIME_UNSET;
                return;
            }
            bVar.h(((m0) z3.a.e(this.A)).getSeekPoints(this.J).f78345a.f78354b, this.J);
            for (s sVar : this.f11249u) {
                sVar.c0(this.J);
            }
            this.J = C.TIME_UNSET;
        }
        this.L = B();
        this.f11234f.z(new p4.n(bVar.f11256a, bVar.f11266k, this.f11240l.m(bVar, this, this.f11233d.a(this.D))), 1, -1, null, 0, null, bVar.f11265j, this.B);
    }

    public final boolean Z() {
        return this.F || E();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean a(w1 w1Var) {
        if (this.M || this.f11240l.h() || this.K) {
            return false;
        }
        if (this.f11252x && this.G == 0) {
            return false;
        }
        boolean zF = this.f11242n.f();
        if (this.f11240l.i()) {
            return zF;
        }
        Y();
        return true;
    }

    @Override // androidx.media3.exoplayer.source.k
    public long b(long j11, b3 b3Var) {
        y();
        if (!this.A.isSeekable()) {
            return 0L;
        }
        m0.a seekPoints = this.A.getSeekPoints(j11);
        return b3Var.a(j11, seekPoints.f78345a.f78353a, seekPoints.f78346b.f78353a);
    }

    @Override // androidx.media3.exoplayer.source.s.d
    public void c(y yVar) {
        this.f11245q.post(this.f11243o);
    }

    @Override // androidx.media3.exoplayer.source.k
    public void discardBuffer(long j11, boolean z11) {
        if (this.f11246r) {
            return;
        }
        y();
        if (E()) {
            return;
        }
        boolean[] zArr = this.f11254z.f11276c;
        int length = this.f11249u.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f11249u[i11].q(j11, z11, zArr[i11]);
        }
    }

    @Override // androidx.media3.exoplayer.source.k
    public long e(z[] zVarArr, boolean[] zArr, p4.e0[] e0VarArr, boolean[] zArr2, long j11) {
        z zVar;
        y();
        f fVar = this.f11254z;
        k0 k0Var = fVar.f11274a;
        boolean[] zArr3 = fVar.f11276c;
        int i11 = this.G;
        int i12 = 0;
        for (int i13 = 0; i13 < zVarArr.length; i13++) {
            p4.e0 e0Var = e0VarArr[i13];
            if (e0Var != null && (zVarArr[i13] == null || !zArr[i13])) {
                int i14 = ((d) e0Var).f11270a;
                z3.a.g(zArr3[i14]);
                this.G--;
                zArr3[i14] = false;
                e0VarArr[i13] = null;
            }
        }
        boolean z11 = !this.f11246r && (!this.E ? j11 == 0 : i11 != 0);
        for (int i15 = 0; i15 < zVarArr.length; i15++) {
            if (e0VarArr[i15] == null && (zVar = zVarArr[i15]) != null) {
                z3.a.g(zVar.length() == 1);
                z3.a.g(zVar.getIndexInTrackGroup(0) == 0);
                int iD = k0Var.d(zVar.getTrackGroup());
                z3.a.g(!zArr3[iD]);
                this.G++;
                zArr3[iD] = true;
                e0VarArr[i15] = new d(iD);
                zArr2[i15] = true;
                if (!z11) {
                    s sVar = this.f11249u[iD];
                    z11 = (sVar.D() == 0 || sVar.a0(j11, true)) ? false : true;
                }
            }
        }
        if (this.G == 0) {
            this.K = false;
            this.F = false;
            if (this.f11240l.i()) {
                s[] sVarArr = this.f11249u;
                int length = sVarArr.length;
                while (i12 < length) {
                    sVarArr[i12].r();
                    i12++;
                }
                this.f11240l.e();
            } else {
                s[] sVarArr2 = this.f11249u;
                int length2 = sVarArr2.length;
                while (i12 < length2) {
                    sVarArr2[i12].W();
                    i12++;
                }
            }
        } else if (z11) {
            j11 = seekToUs(j11);
            while (i12 < e0VarArr.length) {
                if (e0VarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.E = true;
        return j11;
    }

    @Override // u4.u
    public void endTracks() {
        this.f11251w = true;
        this.f11245q.post(this.f11243o);
    }

    @Override // u4.u
    public void f(final m0 m0Var) {
        this.f11245q.post(new Runnable() { // from class: p4.b0
            @Override // java.lang.Runnable
            public final void run() {
                this.f73531a.I(m0Var);
            }
        });
    }

    @Override // androidx.media3.exoplayer.source.k
    public void g(k.a aVar, long j11) {
        this.f11247s = aVar;
        this.f11242n.f();
        Y();
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getBufferedPositionUs() {
        long jC;
        y();
        if (this.M || this.G == 0) {
            return Long.MIN_VALUE;
        }
        if (E()) {
            return this.J;
        }
        if (this.f11253y) {
            int length = this.f11249u.length;
            jC = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                f fVar = this.f11254z;
                if (fVar.f11275b[i11] && fVar.f11276c[i11] && !this.f11249u[i11].K()) {
                    jC = Math.min(jC, this.f11249u[i11].A());
                }
            }
        } else {
            jC = Long.MAX_VALUE;
        }
        if (jC == Long.MAX_VALUE) {
            jC = C(false);
        }
        return jC == Long.MIN_VALUE ? this.I : jC;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // androidx.media3.exoplayer.source.k
    public k0 getTrackGroups() {
        y();
        return this.f11254z.f11274a;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public boolean isLoading() {
        return this.f11240l.i() && this.f11242n.e();
    }

    @Override // androidx.media3.exoplayer.source.k
    public void maybeThrowPrepareError() throws IOException {
        M();
        if (this.M && !this.f11252x) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.e
    public void onLoaderReleased() {
        for (s sVar : this.f11249u) {
            sVar.U();
        }
        this.f11241m.release();
    }

    @Override // androidx.media3.exoplayer.source.k
    public long readDiscontinuity() {
        if (!this.F) {
            return C.TIME_UNSET;
        }
        if (!this.M && B() <= this.L) {
            return C.TIME_UNSET;
        }
        this.F = false;
        return this.I;
    }

    @Override // androidx.media3.exoplayer.source.k, androidx.media3.exoplayer.source.t
    public void reevaluateBuffer(long j11) {
    }

    @Override // androidx.media3.exoplayer.source.k
    public long seekToUs(long j11) {
        y();
        boolean[] zArr = this.f11254z.f11275b;
        if (!this.A.isSeekable()) {
            j11 = 0;
        }
        int i11 = 0;
        this.F = false;
        this.I = j11;
        if (E()) {
            this.J = j11;
            return j11;
        }
        if (this.D != 7 && V(zArr, j11)) {
            return j11;
        }
        this.K = false;
        this.J = j11;
        this.M = false;
        if (this.f11240l.i()) {
            s[] sVarArr = this.f11249u;
            int length = sVarArr.length;
            while (i11 < length) {
                sVarArr[i11].r();
                i11++;
            }
            this.f11240l.e();
        } else {
            this.f11240l.f();
            s[] sVarArr2 = this.f11249u;
            int length2 = sVarArr2.length;
            while (i11 < length2) {
                sVarArr2[i11].W();
                i11++;
            }
        }
        return j11;
    }

    @Override // u4.u
    public r0 track(int i11, int i12) {
        return S(new e(i11, false));
    }

    public final void y() {
        z3.a.g(this.f11252x);
        z3.a.e(this.f11254z);
        z3.a.e(this.A);
    }

    public final boolean z(b bVar, int i11) {
        m0 m0Var;
        if (this.H || !((m0Var = this.A) == null || m0Var.getDurationUs() == C.TIME_UNSET)) {
            this.L = i11;
            return true;
        }
        if (this.f11252x && !Z()) {
            this.K = true;
            return false;
        }
        this.F = this.f11252x;
        this.I = 0L;
        this.L = 0;
        for (s sVar : this.f11249u) {
            sVar.W();
        }
        bVar.h(0L, 0L);
        return true;
    }
}

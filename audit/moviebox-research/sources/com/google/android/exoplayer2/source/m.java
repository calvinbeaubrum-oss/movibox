package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.b3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.n1;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.w;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import nh.d0;
import nh.k0;
import tg.a0;
import tg.b0;
import tg.e0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class m implements h, tg.n, Loader.b<a>, Loader.e, p.d {
    public static final Map<String, String> N = y();
    public static final m1 O = new m1.b().S("icy").e0("application/x-icy").E();
    public boolean B;
    public boolean D;
    public boolean E;
    public int F;
    public boolean G;
    public long H;
    public boolean J;
    public int K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f34255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f34256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f34257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f34258d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j.a f34259f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.b.a f34260g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f34261h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f34262i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public final String f34263j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f34264k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final l f34266m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public h.a f34271r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    public IcyHeaders f34272s;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f34275v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f34276w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f34277x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f34278y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public b0 f34279z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Loader f34265l = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.exoplayer2.util.h f34267n = new com.google.android.exoplayer2.util.h();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Runnable f34268o = new Runnable() { // from class: nh.x
        @Override // java.lang.Runnable
        public final void run() {
            this.f71990a.H();
        }
    };

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Runnable f34269p = new Runnable() { // from class: nh.y
        @Override // java.lang.Runnable
        public final void run() {
            this.f71991a.E();
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Handler f34270q = o0.w();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d[] f34274u = new d[0];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public p[] f34273t = new p[0];
    public long I = C.TIME_UNSET;
    public long A = C.TIME_UNSET;
    public int C = 1;

    /* JADX INFO: compiled from: source.java */
    public final class a implements Loader.d, com.google.android.exoplayer2.source.e.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f34281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i0 f34282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l f34283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final tg.n f34284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.h f34285f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f34287h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f34289j;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @Nullable
        public e0 f34291l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f34292m;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a0 f34286g = new a0();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f34288i = true;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f34280a = nh.n.a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.n f34290k = g(0);

        public a(Uri uri, com.google.android.exoplayer2.upstream.k kVar, l lVar, tg.n nVar, com.google.android.exoplayer2.util.h hVar) {
            this.f34281b = uri;
            this.f34282c = new i0(kVar);
            this.f34283d = lVar;
            this.f34284e = nVar;
            this.f34285f = hVar;
        }

        @Override // com.google.android.exoplayer2.source.e.a
        public void a(c0 c0Var) {
            long jMax = !this.f34292m ? this.f34289j : Math.max(m.this.A(true), this.f34289j);
            int iA = c0Var.a();
            e0 e0Var = (e0) com.google.android.exoplayer2.util.a.e(this.f34291l);
            e0Var.c(c0Var, iA);
            e0Var.d(jMax, 1, iA, 0, null);
            this.f34292m = true;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
            this.f34287h = true;
        }

        public final com.google.android.exoplayer2.upstream.n g(long j11) {
            return new com.google.android.exoplayer2.upstream.n.b().i(this.f34281b).h(j11).f(m.this.f34263j).b(6).e(m.N).a();
        }

        public final void h(long j11, long j12) {
            this.f34286g.f76990a = j11;
            this.f34289j = j12;
            this.f34288i = true;
            this.f34292m = false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x0029 */
        @Override // com.google.android.exoplayer2.upstream.Loader.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void load() throws IOException {
            int iD = 0;
            while (iD == 0 && !this.f34287h) {
                long j11 = this.f34286g.f76990a;
                com.google.android.exoplayer2.upstream.n nVarG = g(j11);
                this.f34290k = nVarG;
                long jA = this.f34282c.a(nVarG);
                if (jA != -1) {
                    jA += j11;
                    m.this.M();
                }
                long j12 = jA;
                m.this.f34272s = IcyHeaders.parse(this.f34282c.getResponseHeaders());
                com.google.android.exoplayer2.upstream.g eVar = this.f34282c;
                if (m.this.f34272s != null && m.this.f34272s.metadataInterval != -1) {
                    eVar = new com.google.android.exoplayer2.source.e(this.f34282c, m.this.f34272s.metadataInterval, this);
                    e0 e0VarB = m.this.B();
                    this.f34291l = e0VarB;
                    e0VarB.e(m.O);
                }
                long jB = j11;
                this.f34283d.c(eVar, this.f34281b, this.f34282c.getResponseHeaders(), j11, j12, this.f34284e);
                if (m.this.f34272s != null) {
                    this.f34283d.a();
                }
                if (this.f34288i) {
                    this.f34283d.seek(jB, this.f34289j);
                    this.f34288i = false;
                }
                while (true) {
                    long j13 = jB;
                    while (true) {
                        if (iD != 0 || this.f34287h) {
                            break;
                        }
                        try {
                            this.f34285f.a();
                            iD = this.f34283d.d(this.f34286g);
                            jB = this.f34283d.b();
                            if (jB > m.this.f34264k + j13) {
                                this.f34285f.d();
                                m.this.f34270q.post(m.this.f34269p);
                            }
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    }
                }
                if (iD == 1) {
                    iD = 0;
                } else if (this.f34283d.b() != -1) {
                    this.f34286g.f76990a = this.f34283d.b();
                }
                com.google.android.exoplayer2.upstream.m.a(this.f34282c);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void b(long j11, boolean z11, boolean z12);
    }

    /* JADX INFO: compiled from: source.java */
    public final class c implements d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34294a;

        public c(int i11) {
            this.f34294a = i11;
        }

        @Override // nh.d0
        public int b(n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            return m.this.R(this.f34294a, n1Var, decoderInputBuffer, i11);
        }

        @Override // nh.d0
        public boolean isReady() {
            return m.this.D(this.f34294a);
        }

        @Override // nh.d0
        public void maybeThrowError() throws IOException {
            m.this.L(this.f34294a);
        }

        @Override // nh.d0
        public int skipData(long j11) {
            return m.this.V(this.f34294a, j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f34297b;

        public d(int i11, boolean z11) {
            this.f34296a = i11;
            this.f34297b = z11;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f34296a == dVar.f34296a && this.f34297b == dVar.f34297b;
        }

        public int hashCode() {
            return (this.f34296a * 31) + (this.f34297b ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k0 f34298a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f34299b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean[] f34300c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean[] f34301d;

        public e(k0 k0Var, boolean[] zArr) {
            this.f34298a = k0Var;
            this.f34299b = zArr;
            int i11 = k0Var.f71941a;
            this.f34300c = new boolean[i11];
            this.f34301d = new boolean[i11];
        }
    }

    public m(Uri uri, com.google.android.exoplayer2.upstream.k kVar, l lVar, com.google.android.exoplayer2.drm.c cVar, com.google.android.exoplayer2.drm.b.a aVar, z zVar, j.a aVar2, b bVar, com.google.android.exoplayer2.upstream.b bVar2, @Nullable String str, int i11) {
        this.f34255a = uri;
        this.f34256b = kVar;
        this.f34257c = cVar;
        this.f34260g = aVar;
        this.f34258d = zVar;
        this.f34259f = aVar2;
        this.f34261h = bVar;
        this.f34262i = bVar2;
        this.f34263j = str;
        this.f34264k = i11;
        this.f34266m = lVar;
    }

    private boolean C() {
        return this.I != C.TIME_UNSET;
    }

    public static Map<String, String> y() {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        return Collections.unmodifiableMap(map);
    }

    public final long A(boolean z11) {
        long jMax = Long.MIN_VALUE;
        for (int i11 = 0; i11 < this.f34273t.length; i11++) {
            if (z11 || ((e) com.google.android.exoplayer2.util.a.e(this.f34278y)).f34300c[i11]) {
                jMax = Math.max(jMax, this.f34273t[i11].z());
            }
        }
        return jMax;
    }

    public e0 B() {
        return Q(new d(0, true));
    }

    public boolean D(int i11) {
        return !X() && this.f34273t[i11].K(this.L);
    }

    public final /* synthetic */ void E() {
        if (this.M) {
            return;
        }
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f34271r)).g(this);
    }

    public final /* synthetic */ void F() {
        this.G = true;
    }

    public final void H() {
        if (this.M || this.f34276w || !this.f34275v || this.f34279z == null) {
            return;
        }
        for (p pVar : this.f34273t) {
            if (pVar.F() == null) {
                return;
            }
        }
        this.f34267n.d();
        int length = this.f34273t.length;
        nh.i0[] i0VarArr = new nh.i0[length];
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            m1 m1VarE = (m1) com.google.android.exoplayer2.util.a.e(this.f34273t[i11].F());
            String str = m1VarE.f33445m;
            boolean zO = w.o(str);
            boolean z11 = zO || w.s(str);
            zArr[i11] = z11;
            this.f34277x = z11 | this.f34277x;
            IcyHeaders icyHeaders = this.f34272s;
            if (icyHeaders != null) {
                if (zO || this.f34274u[i11].f34297b) {
                    Metadata metadata = m1VarE.f33443k;
                    m1VarE = m1VarE.b().X(metadata == null ? new Metadata(icyHeaders) : metadata.copyWithAppendedEntries(icyHeaders)).E();
                }
                if (zO && m1VarE.f33439g == -1 && m1VarE.f33440h == -1 && icyHeaders.bitrate != -1) {
                    m1VarE = m1VarE.b().G(icyHeaders.bitrate).E();
                }
            }
            i0VarArr[i11] = new nh.i0(Integer.toString(i11), m1VarE.c(this.f34257c.a(m1VarE)));
        }
        this.f34278y = new e(new k0(i0VarArr), zArr);
        this.f34276w = true;
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f34271r)).h(this);
    }

    public final void I(int i11) {
        w();
        e eVar = this.f34278y;
        boolean[] zArr = eVar.f34301d;
        if (zArr[i11]) {
            return;
        }
        m1 m1VarC = eVar.f34298a.b(i11).c(0);
        this.f34259f.i(w.k(m1VarC.f33445m), m1VarC, 0, null, this.H);
        zArr[i11] = true;
    }

    public final void J(int i11) {
        w();
        boolean[] zArr = this.f34278y.f34299b;
        if (this.J && zArr[i11]) {
            if (this.f34273t[i11].K(false)) {
                return;
            }
            this.I = 0L;
            this.J = false;
            this.E = true;
            this.H = 0L;
            this.K = 0;
            for (p pVar : this.f34273t) {
                pVar.V();
            }
            ((h.a) com.google.android.exoplayer2.util.a.e(this.f34271r)).g(this);
        }
    }

    public void K() throws IOException {
        this.f34265l.j(this.f34258d.a(this.C));
    }

    public void L(int i11) throws IOException {
        this.f34273t[i11].N();
        K();
    }

    public final void M() {
        this.f34270q.post(new Runnable() { // from class: nh.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f71992a.F();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public void j(a aVar, long j11, long j12, boolean z11) {
        i0 i0Var = aVar.f34282c;
        nh.n nVar = new nh.n(aVar.f34280a, aVar.f34290k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f34258d.b(aVar.f34280a);
        this.f34259f.r(nVar, 1, -1, null, 0, null, aVar.f34289j, this.A);
        if (z11) {
            return;
        }
        for (p pVar : this.f34273t) {
            pVar.V();
        }
        if (this.F > 0) {
            ((h.a) com.google.android.exoplayer2.util.a.e(this.f34271r)).g(this);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public void l(a aVar, long j11, long j12) {
        b0 b0Var;
        if (this.A == C.TIME_UNSET && (b0Var = this.f34279z) != null) {
            boolean zIsSeekable = b0Var.isSeekable();
            long jA = A(true);
            long j13 = jA == Long.MIN_VALUE ? 0L : jA + 10000;
            this.A = j13;
            this.f34261h.b(j13, zIsSeekable, this.B);
        }
        i0 i0Var = aVar.f34282c;
        nh.n nVar = new nh.n(aVar.f34280a, aVar.f34290k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f34258d.b(aVar.f34280a);
        this.f34259f.u(nVar, 1, -1, null, 0, null, aVar.f34289j, this.A);
        this.L = true;
        ((h.a) com.google.android.exoplayer2.util.a.e(this.f34271r)).g(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public Loader.c n(a aVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c cVarG;
        i0 i0Var = aVar.f34282c;
        nh.n nVar = new nh.n(aVar.f34280a, aVar.f34290k, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        long jC = this.f34258d.c(new z.c(nVar, new nh.o(1, -1, null, 0, null, o0.f1(aVar.f34289j), o0.f1(this.A)), iOException, i11));
        if (jC == C.TIME_UNSET) {
            cVarG = Loader.f35232g;
        } else {
            int iZ = z();
            cVarG = x(aVar, iZ) ? Loader.g(iZ > this.K, jC) : Loader.f35231f;
        }
        boolean z11 = !cVarG.c();
        this.f34259f.w(nVar, 1, -1, null, 0, null, aVar.f34289j, this.A, iOException, z11);
        if (z11) {
            this.f34258d.b(aVar.f34280a);
        }
        return cVarG;
    }

    public final e0 Q(d dVar) {
        int length = this.f34273t.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (dVar.equals(this.f34274u[i11])) {
                return this.f34273t[i11];
            }
        }
        p pVarK = p.k(this.f34262i, this.f34257c, this.f34260g);
        pVarK.d0(this);
        int i12 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f34274u, i12);
        dVarArr[length] = dVar;
        this.f34274u = (d[]) o0.k(dVarArr);
        p[] pVarArr = (p[]) Arrays.copyOf(this.f34273t, i12);
        pVarArr[length] = pVarK;
        this.f34273t = (p[]) o0.k(pVarArr);
        return pVarK;
    }

    public int R(int i11, n1 n1Var, DecoderInputBuffer decoderInputBuffer, int i12) {
        if (X()) {
            return -3;
        }
        I(i11);
        int iS = this.f34273t[i11].S(n1Var, decoderInputBuffer, i12, this.L);
        if (iS == -3) {
            J(i11);
        }
        return iS;
    }

    public void S() {
        if (this.f34276w) {
            for (p pVar : this.f34273t) {
                pVar.R();
            }
        }
        this.f34265l.l(this);
        this.f34270q.removeCallbacksAndMessages(null);
        this.f34271r = null;
        this.M = true;
    }

    public final boolean T(boolean[] zArr, long j11) {
        int length = this.f34273t.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (!this.f34273t[i11].Z(j11, false) && (zArr[i11] || !this.f34277x)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void G(b0 b0Var) {
        this.f34279z = this.f34272s == null ? b0Var : new b0.b(C.TIME_UNSET);
        this.A = b0Var.getDurationUs();
        boolean z11 = !this.G && b0Var.getDurationUs() == C.TIME_UNSET;
        this.B = z11;
        this.C = z11 ? 7 : 1;
        this.f34261h.b(this.A, b0Var.isSeekable(), this.B);
        if (this.f34276w) {
            return;
        }
        H();
    }

    public int V(int i11, long j11) {
        if (X()) {
            return 0;
        }
        I(i11);
        p pVar = this.f34273t[i11];
        int iE = pVar.E(j11, this.L);
        pVar.e0(iE);
        if (iE == 0) {
            J(i11);
        }
        return iE;
    }

    public final void W() {
        a aVar = new a(this.f34255a, this.f34256b, this.f34266m, this, this.f34267n);
        if (this.f34276w) {
            com.google.android.exoplayer2.util.a.g(C());
            long j11 = this.A;
            if (j11 != C.TIME_UNSET && this.I > j11) {
                this.L = true;
                this.I = C.TIME_UNSET;
                return;
            }
            aVar.h(((b0) com.google.android.exoplayer2.util.a.e(this.f34279z)).getSeekPoints(this.I).f76991a.f76997b, this.I);
            for (p pVar : this.f34273t) {
                pVar.b0(this.I);
            }
            this.I = C.TIME_UNSET;
        }
        this.K = z();
        this.f34259f.A(new nh.n(aVar.f34280a, aVar.f34290k, this.f34265l.m(aVar, this, this.f34258d.a(this.C))), 1, -1, null, 0, null, aVar.f34289j, this.A);
    }

    public final boolean X() {
        return this.E || C();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long a(long j11, b3 b3Var) {
        w();
        if (!this.f34279z.isSeekable()) {
            return 0L;
        }
        b0.a seekPoints = this.f34279z.getSeekPoints(j11);
        return b3Var.a(j11, seekPoints.f76991a.f76996a, seekPoints.f76992b.f76996a);
    }

    @Override // com.google.android.exoplayer2.source.p.d
    public void b(m1 m1Var) {
        this.f34270q.post(this.f34268o);
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j11) {
        if (this.L || this.f34265l.h() || this.J) {
            return false;
        }
        if (this.f34276w && this.F == 0) {
            return false;
        }
        boolean zF = this.f34267n.f();
        if (this.f34265l.i()) {
            return zF;
        }
        W();
        return true;
    }

    @Override // com.google.android.exoplayer2.source.h
    public void discardBuffer(long j11, boolean z11) {
        w();
        if (C()) {
            return;
        }
        boolean[] zArr = this.f34278y.f34300c;
        int length = this.f34273t.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.f34273t[i11].q(j11, z11, zArr[i11]);
        }
    }

    @Override // com.google.android.exoplayer2.source.h
    public long e(fi.s[] sVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j11) {
        fi.s sVar;
        w();
        e eVar = this.f34278y;
        k0 k0Var = eVar.f34298a;
        boolean[] zArr3 = eVar.f34300c;
        int i11 = this.F;
        int i12 = 0;
        for (int i13 = 0; i13 < sVarArr.length; i13++) {
            d0 d0Var = d0VarArr[i13];
            if (d0Var != null && (sVarArr[i13] == null || !zArr[i13])) {
                int i14 = ((c) d0Var).f34294a;
                com.google.android.exoplayer2.util.a.g(zArr3[i14]);
                this.F--;
                zArr3[i14] = false;
                d0VarArr[i13] = null;
            }
        }
        boolean z11 = !this.D ? j11 == 0 : i11 != 0;
        for (int i15 = 0; i15 < sVarArr.length; i15++) {
            if (d0VarArr[i15] == null && (sVar = sVarArr[i15]) != null) {
                com.google.android.exoplayer2.util.a.g(sVar.length() == 1);
                com.google.android.exoplayer2.util.a.g(sVar.getIndexInTrackGroup(0) == 0);
                int iC = k0Var.c(sVar.getTrackGroup());
                com.google.android.exoplayer2.util.a.g(!zArr3[iC]);
                this.F++;
                zArr3[iC] = true;
                d0VarArr[i15] = new c(iC);
                zArr2[i15] = true;
                if (!z11) {
                    p pVar = this.f34273t[iC];
                    z11 = (pVar.Z(j11, true) || pVar.C() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.J = false;
            this.E = false;
            if (this.f34265l.i()) {
                p[] pVarArr = this.f34273t;
                int length = pVarArr.length;
                while (i12 < length) {
                    pVarArr[i12].r();
                    i12++;
                }
                this.f34265l.e();
            } else {
                p[] pVarArr2 = this.f34273t;
                int length2 = pVarArr2.length;
                while (i12 < length2) {
                    pVarArr2[i12].V();
                    i12++;
                }
            }
        } else if (z11) {
            j11 = seekToUs(j11);
            while (i12 < d0VarArr.length) {
                if (d0VarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.D = true;
        return j11;
    }

    @Override // tg.n
    public void endTracks() {
        this.f34275v = true;
        this.f34270q.post(this.f34268o);
    }

    @Override // com.google.android.exoplayer2.source.h
    public void f(h.a aVar, long j11) {
        this.f34271r = aVar;
        this.f34267n.f();
        W();
    }

    @Override // tg.n
    public void g(final b0 b0Var) {
        this.f34270q.post(new Runnable() { // from class: nh.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f71896a.G(b0Var);
            }
        });
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getBufferedPositionUs() {
        long jA;
        w();
        if (this.L || this.F == 0) {
            return Long.MIN_VALUE;
        }
        if (C()) {
            return this.I;
        }
        if (this.f34277x) {
            int length = this.f34273t.length;
            jA = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                e eVar = this.f34278y;
                if (eVar.f34299b[i11] && eVar.f34300c[i11] && !this.f34273t[i11].J()) {
                    jA = Math.min(jA, this.f34273t[i11].z());
                }
            }
        } else {
            jA = Long.MAX_VALUE;
        }
        if (jA == Long.MAX_VALUE) {
            jA = A(false);
        }
        return jA == Long.MIN_VALUE ? this.H : jA;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public long getNextLoadPositionUs() {
        return getBufferedPositionUs();
    }

    @Override // com.google.android.exoplayer2.source.h
    public k0 getTrackGroups() {
        w();
        return this.f34278y.f34298a;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        return this.f34265l.i() && this.f34267n.e();
    }

    @Override // com.google.android.exoplayer2.source.h
    public void maybeThrowPrepareError() throws IOException {
        K();
        if (this.L && !this.f34276w) {
            throw ParserException.createForMalformedContainer("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.e
    public void onLoaderReleased() {
        for (p pVar : this.f34273t) {
            pVar.T();
        }
        this.f34266m.release();
    }

    @Override // com.google.android.exoplayer2.source.h
    public long readDiscontinuity() {
        if (!this.E) {
            return C.TIME_UNSET;
        }
        if (!this.L && z() <= this.K) {
            return C.TIME_UNSET;
        }
        this.E = false;
        return this.H;
    }

    @Override // com.google.android.exoplayer2.source.h, com.google.android.exoplayer2.source.q
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.h
    public long seekToUs(long j11) {
        w();
        boolean[] zArr = this.f34278y.f34299b;
        if (!this.f34279z.isSeekable()) {
            j11 = 0;
        }
        int i11 = 0;
        this.E = false;
        this.H = j11;
        if (C()) {
            this.I = j11;
            return j11;
        }
        if (this.C != 7 && T(zArr, j11)) {
            return j11;
        }
        this.J = false;
        this.I = j11;
        this.L = false;
        if (this.f34265l.i()) {
            p[] pVarArr = this.f34273t;
            int length = pVarArr.length;
            while (i11 < length) {
                pVarArr[i11].r();
                i11++;
            }
            this.f34265l.e();
        } else {
            this.f34265l.f();
            p[] pVarArr2 = this.f34273t;
            int length2 = pVarArr2.length;
            while (i11 < length2) {
                pVarArr2[i11].V();
                i11++;
            }
        }
        return j11;
    }

    @Override // tg.n
    public e0 track(int i11, int i12) {
        return Q(new d(i11, false));
    }

    public final void w() {
        com.google.android.exoplayer2.util.a.g(this.f34276w);
        com.google.android.exoplayer2.util.a.e(this.f34278y);
        com.google.android.exoplayer2.util.a.e(this.f34279z);
    }

    public final boolean x(a aVar, int i11) {
        b0 b0Var;
        if (this.G || !((b0Var = this.f34279z) == null || b0Var.getDurationUs() == C.TIME_UNSET)) {
            this.K = i11;
            return true;
        }
        if (this.f34276w && !X()) {
            this.J = true;
            return false;
        }
        this.E = this.f34276w;
        this.H = 0L;
        this.K = 0;
        for (p pVar : this.f34273t) {
            pVar.V();
        }
        aVar.h(0L, 0L);
        return true;
    }

    public final int z() {
        int iG = 0;
        for (p pVar : this.f34273t) {
            iG += pVar.G();
        }
        return iG;
    }
}

package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i extends ph.n {
    public static final AtomicInteger M = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public final u1 C;
    public j D;
    public p E;
    public int F;
    public boolean G;
    public volatile boolean H;
    public boolean I;
    public ImmutableList<Integer> J;
    public boolean K;
    public boolean L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f34023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f34024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f34025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f34026n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f34027o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.k f34028p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.n f34029q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final j f34030r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f34031s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f34032t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final k0 f34033u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f34034v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final List<m1> f34035w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final DrmInitData f34036x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final kh.b f34037y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c0 f34038z;

    public i(g gVar, com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, m1 m1Var, boolean z11, @Nullable com.google.android.exoplayer2.upstream.k kVar2, @Nullable com.google.android.exoplayer2.upstream.n nVar2, boolean z12, Uri uri, @Nullable List<m1> list, int i11, @Nullable Object obj, long j11, long j12, long j13, int i12, boolean z13, int i13, boolean z14, boolean z15, k0 k0Var, @Nullable DrmInitData drmInitData, @Nullable j jVar, kh.b bVar, c0 c0Var, boolean z16, u1 u1Var) {
        super(kVar, nVar, m1Var, i11, obj, j11, j12, j13);
        this.A = z11;
        this.f34027o = i12;
        this.L = z13;
        this.f34024l = i13;
        this.f34029q = nVar2;
        this.f34028p = kVar2;
        this.G = nVar2 != null;
        this.B = z12;
        this.f34025m = uri;
        this.f34031s = z15;
        this.f34033u = k0Var;
        this.f34032t = z14;
        this.f34034v = gVar;
        this.f34035w = list;
        this.f34036x = drmInitData;
        this.f34030r = jVar;
        this.f34037y = bVar;
        this.f34038z = c0Var;
        this.f34026n = z16;
        this.C = u1Var;
        this.J = ImmutableList.of();
        this.f34023k = M.getAndIncrement();
    }

    public static com.google.android.exoplayer2.upstream.k g(com.google.android.exoplayer2.upstream.k kVar, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return kVar;
        }
        com.google.android.exoplayer2.util.a.e(bArr2);
        return new a(kVar, bArr, bArr2);
    }

    public static i h(g gVar, com.google.android.exoplayer2.upstream.k kVar, m1 m1Var, long j11, com.google.android.exoplayer2.source.hls.playlist.c cVar, e.C0365e c0365e, Uri uri, @Nullable List<m1> list, int i11, @Nullable Object obj, boolean z11, q qVar, @Nullable i iVar, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z12, u1 u1Var) {
        com.google.android.exoplayer2.upstream.k kVarG;
        com.google.android.exoplayer2.upstream.n nVar;
        boolean z13;
        kh.b bVar;
        c0 c0Var;
        j jVar;
        com.google.android.exoplayer2.source.hls.playlist.c.e eVar = c0365e.f34015a;
        com.google.android.exoplayer2.upstream.n nVarA = new com.google.android.exoplayer2.upstream.n.b().i(m0.e(cVar.f76359a, eVar.f34187a)).h(eVar.f34195j).g(eVar.f34196k).b(c0365e.f34018d ? 8 : 0).a();
        boolean z14 = bArr != null;
        com.google.android.exoplayer2.upstream.k kVarG2 = g(kVar, bArr, z14 ? j((String) com.google.android.exoplayer2.util.a.e(eVar.f34194i)) : null);
        com.google.android.exoplayer2.source.hls.playlist.c.d dVar = eVar.f34188b;
        if (dVar != null) {
            boolean z15 = bArr2 != null;
            byte[] bArrJ = z15 ? j((String) com.google.android.exoplayer2.util.a.e(dVar.f34194i)) : null;
            nVar = new com.google.android.exoplayer2.upstream.n(m0.e(cVar.f76359a, dVar.f34187a), dVar.f34195j, dVar.f34196k);
            kVarG = g(kVar, bArr2, bArrJ);
            z13 = z15;
        } else {
            kVarG = null;
            nVar = null;
            z13 = false;
        }
        long j12 = j11 + eVar.f34191f;
        long j13 = j12 + eVar.f34189c;
        int i12 = cVar.f34167j + eVar.f34190d;
        if (iVar != null) {
            com.google.android.exoplayer2.upstream.n nVar2 = iVar.f34029q;
            boolean z16 = nVar == nVar2 || (nVar != null && nVar2 != null && nVar.f35422a.equals(nVar2.f35422a) && nVar.f35428g == iVar.f34029q.f35428g);
            boolean z17 = uri.equals(iVar.f34025m) && iVar.I;
            bVar = iVar.f34037y;
            c0Var = iVar.f34038z;
            jVar = (z16 && z17 && !iVar.K && iVar.f34024l == i12) ? iVar.D : null;
        } else {
            bVar = new kh.b();
            c0Var = new c0(10);
            jVar = null;
        }
        return new i(gVar, kVarG2, nVarA, m1Var, z14, kVarG, nVar, z13, uri, list, i11, obj, j12, j13, c0365e.f34016b, c0365e.f34017c, !c0365e.f34018d, i12, eVar.f34197l, z11, qVar.a(i12), eVar.f34192g, jVar, bVar, c0Var, z12, u1Var);
    }

    public static byte[] j(String str) {
        if (com.google.common.base.a.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    public static boolean n(e.C0365e c0365e, com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        com.google.android.exoplayer2.source.hls.playlist.c.e eVar = c0365e.f34015a;
        if (eVar instanceof com.google.android.exoplayer2.source.hls.playlist.c.b) {
            return ((com.google.android.exoplayer2.source.hls.playlist.c.b) eVar).f34180m || (c0365e.f34017c == 0 && cVar.f76361c);
        }
        return cVar.f76361c;
    }

    public static boolean u(@Nullable i iVar, Uri uri, com.google.android.exoplayer2.source.hls.playlist.c cVar, e.C0365e c0365e, long j11) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f34025m) && iVar.I) {
            return false;
        }
        return !n(c0365e, cVar) || j11 + c0365e.f34015a.f34191f < iVar.f73813h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.H = true;
    }

    @Override // ph.n
    public boolean f() {
        return this.I;
    }

    public final void i(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, boolean z11, boolean z12) throws IOException {
        com.google.android.exoplayer2.upstream.n nVarE;
        long position;
        long j11;
        boolean z13 = false;
        if (z11) {
            z13 = this.F != 0;
            nVarE = nVar;
        } else {
            nVarE = nVar.e(this.F);
        }
        try {
            tg.f fVarS = s(kVar, nVarE, z12);
            if (z13) {
                fVarS.skipFully(this.F);
            }
            while (!this.H && this.D.a(fVarS)) {
                try {
                    try {
                    } catch (EOFException e11) {
                        if ((this.f73809d.f33438f & 16384) == 0) {
                            throw e11;
                        }
                        this.D.b();
                        position = fVarS.getPosition();
                        j11 = nVar.f35428g;
                    }
                } catch (Throwable th2) {
                    this.F = (int) (fVarS.getPosition() - nVar.f35428g);
                    throw th2;
                }
            }
            position = fVarS.getPosition();
            j11 = nVar.f35428g;
            this.F = (int) (position - j11);
            com.google.android.exoplayer2.upstream.m.a(kVar);
        } catch (Throwable th3) {
            com.google.android.exoplayer2.upstream.m.a(kVar);
            throw th3;
        }
    }

    public int k(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f34026n);
        if (i11 >= this.J.size()) {
            return 0;
        }
        return this.J.get(i11).intValue();
    }

    public void l(p pVar, ImmutableList<Integer> immutableList) {
        this.E = pVar;
        this.J = immutableList;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() throws IOException {
        j jVar;
        com.google.android.exoplayer2.util.a.e(this.E);
        if (this.D == null && (jVar = this.f34030r) != null && jVar.c()) {
            this.D = this.f34030r;
            this.G = false;
        }
        q();
        if (this.H) {
            return;
        }
        if (!this.f34032t) {
            p();
        }
        this.I = !this.H;
    }

    public void m() {
        this.K = true;
    }

    public boolean o() {
        return this.L;
    }

    public final void p() throws IOException {
        i(this.f73814i, this.f73807b, this.A, true);
    }

    public final void q() throws IOException {
        if (this.G) {
            com.google.android.exoplayer2.util.a.e(this.f34028p);
            com.google.android.exoplayer2.util.a.e(this.f34029q);
            i(this.f34028p, this.f34029q, this.B, false);
            this.F = 0;
            this.G = false;
        }
    }

    public final long r(tg.m mVar) throws IOException {
        mVar.resetPeekPosition();
        try {
            this.f34038z.L(10);
            mVar.peekFully(this.f34038z.d(), 0, 10);
            if (this.f34038z.G() != 4801587) {
                return C.TIME_UNSET;
            }
            this.f34038z.Q(3);
            int iC = this.f34038z.C();
            int i11 = iC + 10;
            if (i11 > this.f34038z.b()) {
                byte[] bArrD = this.f34038z.d();
                this.f34038z.L(i11);
                System.arraycopy(bArrD, 0, this.f34038z.d(), 0, 10);
            }
            mVar.peekFully(this.f34038z.d(), 10, iC);
            Metadata metadataE = this.f34037y.e(this.f34038z.d(), iC);
            if (metadataE == null) {
                return C.TIME_UNSET;
            }
            int length = metadataE.length();
            for (int i12 = 0; i12 < length; i12++) {
                Metadata.Entry entry = metadataE.get(i12);
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                        System.arraycopy(privFrame.privateData, 0, this.f34038z.d(), 0, 8);
                        this.f34038z.P(0);
                        this.f34038z.O(8);
                        return this.f34038z.w() & 8589934591L;
                    }
                }
            }
            return C.TIME_UNSET;
        } catch (EOFException unused) {
        }
    }

    public final tg.f s(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, boolean z11) throws IOException {
        long jA = kVar.a(nVar);
        if (z11) {
            try {
                this.f34033u.h(this.f34031s, this.f73812g);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        tg.f fVar = new tg.f(kVar, nVar.f35428g, jA);
        if (this.D == null) {
            long jR = r(fVar);
            fVar.resetPeekPosition();
            j jVar = this.f34030r;
            j jVarG = jVar != null ? jVar.g() : this.f34034v.a(nVar.f35422a, this.f73809d, this.f34035w, this.f34033u, kVar.getResponseHeaders(), fVar, this.C);
            this.D = jVarG;
            if (jVarG.e()) {
                this.E.a0(jR != C.TIME_UNSET ? this.f34033u.b(jR) : this.f73812g);
            } else {
                this.E.a0(0L);
            }
            this.E.M();
            this.D.d(this.E);
        }
        this.E.X(this.f34036x);
        return fVar;
    }

    public void t() {
        this.L = true;
    }
}

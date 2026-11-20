package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Metadata;
import androidx.media3.common.y;
import androidx.media3.extractor.metadata.id3.PrivFrame;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e4.x3;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import u4.t;
import z3.c0;
import z3.i0;
import z3.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends q4.m {
    public static final AtomicInteger N = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public final x3 C;
    public final long D;
    public j E;
    public q F;
    public int G;
    public boolean H;
    public volatile boolean I;
    public boolean J;
    public ImmutableList<Integer> K;
    public boolean L;
    public boolean M;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f10417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f10418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f10419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f10420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f10421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public final androidx.media3.datasource.a f10422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    public final c4.g f10423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    public final j f10424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f10425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f10426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i0 f10427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final g f10428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public final List<y> f10429w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public final DrmInitData f10430x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final g5.b f10431y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c0 f10432z;

    public i(g gVar, androidx.media3.datasource.a aVar, c4.g gVar2, y yVar, boolean z11, @Nullable androidx.media3.datasource.a aVar2, @Nullable c4.g gVar3, boolean z12, Uri uri, @Nullable List<y> list, int i11, @Nullable Object obj, long j11, long j12, long j13, int i12, boolean z13, int i13, boolean z14, boolean z15, i0 i0Var, long j14, @Nullable DrmInitData drmInitData, @Nullable j jVar, g5.b bVar, c0 c0Var, boolean z16, x3 x3Var) {
        super(aVar, gVar2, yVar, i11, obj, j11, j12, j13);
        this.A = z11;
        this.f10421o = i12;
        this.M = z13;
        this.f10418l = i13;
        this.f10423q = gVar3;
        this.f10422p = aVar2;
        this.H = gVar3 != null;
        this.B = z12;
        this.f10419m = uri;
        this.f10425s = z15;
        this.f10427u = i0Var;
        this.D = j14;
        this.f10426t = z14;
        this.f10428v = gVar;
        this.f10429w = list;
        this.f10430x = drmInitData;
        this.f10424r = jVar;
        this.f10431y = bVar;
        this.f10432z = c0Var;
        this.f10420n = z16;
        this.C = x3Var;
        this.K = ImmutableList.of();
        this.f10417k = N.getAndIncrement();
    }

    public static androidx.media3.datasource.a g(androidx.media3.datasource.a aVar, @Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        z3.a.e(bArr2);
        return new a(aVar, bArr, bArr2);
    }

    public static i h(g gVar, androidx.media3.datasource.a aVar, y yVar, long j11, androidx.media3.exoplayer.hls.playlist.b bVar, e.C0098e c0098e, Uri uri, @Nullable List<y> list, int i11, @Nullable Object obj, boolean z11, r rVar, long j12, @Nullable i iVar, @Nullable byte[] bArr, @Nullable byte[] bArr2, boolean z12, x3 x3Var, @Nullable androidx.media3.exoplayer.upstream.g.a aVar2) {
        c4.g gVarA;
        androidx.media3.datasource.a aVarG;
        boolean z13;
        g5.b bVar2;
        c0 c0Var;
        j jVar;
        androidx.media3.exoplayer.hls.playlist.b.e eVar = c0098e.f10410a;
        c4.g gVarA2 = new c4.g.b().i(k0.f(bVar.f68239a, eVar.f10550a)).h(eVar.f10558j).g(eVar.f10559k).b(c0098e.f10413d ? 8 : 0).a();
        boolean z14 = bArr != null;
        androidx.media3.datasource.a aVarG2 = g(aVar, bArr, z14 ? j((String) z3.a.e(eVar.f10557i)) : null);
        androidx.media3.exoplayer.hls.playlist.b.d dVar = eVar.f10551b;
        if (dVar != null) {
            boolean z15 = bArr2 != null;
            byte[] bArrJ = z15 ? j((String) z3.a.e(dVar.f10557i)) : null;
            gVarA = new c4.g.b().i(k0.f(bVar.f68239a, dVar.f10550a)).h(dVar.f10558j).g(dVar.f10559k).a();
            z13 = z15;
            aVarG = g(aVar, bArr2, bArrJ);
        } else {
            gVarA = null;
            aVarG = null;
            z13 = false;
        }
        long j13 = j11 + eVar.f10554f;
        long j14 = j13 + eVar.f10552c;
        int i12 = bVar.f10530j + eVar.f10553d;
        if (iVar != null) {
            c4.g gVar2 = iVar.f10423q;
            boolean z16 = gVarA == gVar2 || (gVarA != null && gVar2 != null && gVarA.f14598a.equals(gVar2.f14598a) && gVarA.f14604g == iVar.f10423q.f14604g);
            boolean z17 = uri.equals(iVar.f10419m) && iVar.J;
            g5.b bVar3 = iVar.f10431y;
            c0 c0Var2 = iVar.f10432z;
            jVar = (z16 && z17 && !iVar.L && iVar.f10418l == i12) ? iVar.E : null;
            bVar2 = bVar3;
            c0Var = c0Var2;
        } else {
            bVar2 = new g5.b();
            c0Var = new c0(10);
            jVar = null;
        }
        return new i(gVar, aVarG2, gVarA2, yVar, z14, aVarG, gVarA, z13, uri, list, i11, obj, j13, j14, c0098e.f10411b, c0098e.f10412c, !c0098e.f10413d, i12, eVar.f10560l, z11, rVar.a(i12), j12, eVar.f10555g, jVar, bVar2, c0Var, z12, x3Var);
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

    public static boolean n(e.C0098e c0098e, androidx.media3.exoplayer.hls.playlist.b bVar) {
        androidx.media3.exoplayer.hls.playlist.b.e eVar = c0098e.f10410a;
        if (eVar instanceof androidx.media3.exoplayer.hls.playlist.b.C0100b) {
            return ((androidx.media3.exoplayer.hls.playlist.b.C0100b) eVar).f10543m || (c0098e.f10412c == 0 && bVar.f68241c);
        }
        return bVar.f68241c;
    }

    public static boolean u(@Nullable i iVar, Uri uri, androidx.media3.exoplayer.hls.playlist.b bVar, e.C0098e c0098e, long j11) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f10419m) && iVar.J) {
            return false;
        }
        return !n(c0098e, bVar) || j11 + c0098e.f10410a.f10554f < iVar.f74329h;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
        this.I = true;
    }

    @Override // q4.m
    public boolean f() {
        return this.J;
    }

    public final void i(androidx.media3.datasource.a aVar, c4.g gVar, boolean z11, boolean z12) throws IOException {
        c4.g gVarE;
        long position;
        long j11;
        boolean z13 = false;
        if (z11) {
            z13 = this.G != 0;
            gVarE = gVar;
        } else {
            gVarE = gVar.e(this.G);
        }
        try {
            u4.j jVarS = s(aVar, gVarE, z12);
            if (z13) {
                jVarS.skipFully(this.G);
            }
            while (!this.I && this.E.a(jVarS)) {
                try {
                    try {
                    } catch (EOFException e11) {
                        if ((this.f74325d.f9494f & 16384) == 0) {
                            throw e11;
                        }
                        this.E.b();
                        position = jVarS.getPosition();
                        j11 = gVar.f14604g;
                    }
                } catch (Throwable th2) {
                    this.G = (int) (jVarS.getPosition() - gVar.f14604g);
                    throw th2;
                }
            }
            position = jVarS.getPosition();
            j11 = gVar.f14604g;
            this.G = (int) (position - j11);
            c4.f.a(aVar);
        } catch (Throwable th3) {
            c4.f.a(aVar);
            throw th3;
        }
    }

    public int k(int i11) {
        z3.a.g(!this.f10420n);
        if (i11 >= this.K.size()) {
            return 0;
        }
        return this.K.get(i11).intValue();
    }

    public void l(q qVar, ImmutableList<Integer> immutableList) {
        this.F = qVar;
        this.K = immutableList;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() throws IOException {
        j jVar;
        z3.a.e(this.F);
        if (this.E == null && (jVar = this.f10424r) != null && jVar.c()) {
            this.E = this.f10424r;
            this.H = false;
        }
        q();
        if (this.I) {
            return;
        }
        if (!this.f10426t) {
            p();
        }
        this.J = !this.I;
    }

    public void m() {
        this.L = true;
    }

    public boolean o() {
        return this.M;
    }

    public final void p() throws IOException {
        i(this.f74330i, this.f74323b, this.A, true);
    }

    public final void q() throws IOException {
        if (this.H) {
            z3.a.e(this.f10422p);
            z3.a.e(this.f10423q);
            i(this.f10422p, this.f10423q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    public final long r(t tVar) throws IOException {
        tVar.resetPeekPosition();
        try {
            this.f10432z.Q(10);
            tVar.peekFully(this.f10432z.e(), 0, 10);
            if (this.f10432z.K() != 4801587) {
                return C.TIME_UNSET;
            }
            this.f10432z.V(3);
            int iG = this.f10432z.G();
            int i11 = iG + 10;
            if (i11 > this.f10432z.b()) {
                byte[] bArrE = this.f10432z.e();
                this.f10432z.Q(i11);
                System.arraycopy(bArrE, 0, this.f10432z.e(), 0, 10);
            }
            tVar.peekFully(this.f10432z.e(), 10, iG);
            Metadata metadataE = this.f10431y.e(this.f10432z.e(), iG);
            if (metadataE == null) {
                return C.TIME_UNSET;
            }
            int length = metadataE.length();
            for (int i12 = 0; i12 < length; i12++) {
                Metadata.Entry entry = metadataE.get(i12);
                if (entry instanceof PrivFrame) {
                    PrivFrame privFrame = (PrivFrame) entry;
                    if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                        System.arraycopy(privFrame.privateData, 0, this.f10432z.e(), 0, 8);
                        this.f10432z.U(0);
                        this.f10432z.T(8);
                        return this.f10432z.A() & 8589934591L;
                    }
                }
            }
            return C.TIME_UNSET;
        } catch (EOFException unused) {
        }
    }

    public final u4.j s(androidx.media3.datasource.a aVar, c4.g gVar, boolean z11) throws IOException {
        long jA = aVar.a(gVar);
        if (z11) {
            try {
                this.f10427u.j(this.f10425s, this.f74328g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e11) {
                throw new IOException(e11);
            }
        }
        u4.j jVar = new u4.j(aVar, gVar.f14604g, jA);
        if (this.E == null) {
            long jR = r(jVar);
            jVar.resetPeekPosition();
            j jVar2 = this.f10424r;
            j jVarG = jVar2 != null ? jVar2.g() : this.f10428v.d(gVar.f14598a, this.f74325d, this.f10429w, this.f10427u, aVar.getResponseHeaders(), jVar, this.C);
            this.E = jVarG;
            if (jVarG.e()) {
                this.F.b0(jR != C.TIME_UNSET ? this.f10427u.b(jR) : this.f74328g);
            } else {
                this.F.b0(0L);
            }
            this.F.N();
            this.E.f(this.F);
        }
        this.F.Y(this.f10430x);
        return jVar;
    }

    public void t() {
        this.M = true;
    }
}

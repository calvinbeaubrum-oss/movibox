package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.FileDataSource;
import com.google.android.exoplayer2.upstream.d0;
import com.google.android.exoplayer2.upstream.e0;
import com.google.android.exoplayer2.upstream.j0;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.o0;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.upstream.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f35287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f35288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final com.google.android.exoplayer2.upstream.k f35289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f35290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f35291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f35292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f35293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f35294h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Uri f35295i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.n f35296j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.n f35297k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.k f35298l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f35299m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f35300n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f35301o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public h f35302p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f35303q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f35304r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f35305s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f35306t;

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements com.google.android.exoplayer2.upstream.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f35307a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.upstream.i.a f35309c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f35311e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public com.google.android.exoplayer2.upstream.k.a f35312f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f35313g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f35314h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f35315i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public com.google.android.exoplayer2.upstream.k.a f35308b = new FileDataSource.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g f35310d = g.f35321a;

        @Override // com.google.android.exoplayer2.upstream.k.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            com.google.android.exoplayer2.upstream.k.a aVar = this.f35312f;
            return d(aVar != null ? aVar.createDataSource() : null, this.f35315i, this.f35314h);
        }

        public a b() {
            com.google.android.exoplayer2.upstream.k.a aVar = this.f35312f;
            return d(aVar != null ? aVar.createDataSource() : null, this.f35315i | 1, -1000);
        }

        public a c() {
            return d(null, this.f35315i | 1, -1000);
        }

        public final a d(@Nullable com.google.android.exoplayer2.upstream.k kVar, int i11, int i12) {
            com.google.android.exoplayer2.upstream.i iVarCreateDataSink;
            Cache cache = (Cache) com.google.android.exoplayer2.util.a.e(this.f35307a);
            if (this.f35311e || kVar == null) {
                iVarCreateDataSink = null;
            } else {
                com.google.android.exoplayer2.upstream.i.a aVar = this.f35309c;
                iVarCreateDataSink = aVar != null ? aVar.createDataSink() : new CacheDataSink.a().a(cache).createDataSink();
            }
            return new a(cache, kVar, this.f35308b.createDataSource(), iVarCreateDataSink, this.f35310d, i11, this.f35313g, i12, null);
        }

        @Nullable
        public Cache e() {
            return this.f35307a;
        }

        public g f() {
            return this.f35310d;
        }

        @Nullable
        public PriorityTaskManager g() {
            return this.f35313g;
        }

        public c h(Cache cache) {
            this.f35307a = cache;
            return this;
        }

        public c i(@Nullable com.google.android.exoplayer2.upstream.k.a aVar) {
            this.f35312f = aVar;
            return this;
        }
    }

    public a(Cache cache, @Nullable com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.k kVar2, @Nullable com.google.android.exoplayer2.upstream.i iVar, @Nullable g gVar, int i11, @Nullable PriorityTaskManager priorityTaskManager, int i12, @Nullable b bVar) {
        this.f35287a = cache;
        this.f35288b = kVar2;
        this.f35291e = gVar == null ? g.f35321a : gVar;
        this.f35292f = (i11 & 1) != 0;
        this.f35293g = (i11 & 2) != 0;
        this.f35294h = (i11 & 4) != 0;
        if (kVar == null) {
            this.f35290d = d0.f35379a;
            this.f35289c = null;
        } else {
            kVar = priorityTaskManager != null ? new e0(kVar, priorityTaskManager, i12) : kVar;
            this.f35290d = kVar;
            this.f35289c = iVar != null ? new j0(kVar, iVar) : null;
        }
    }

    public static Uri j(Cache cache, String str, Uri uri) {
        Uri uriB = l.b(cache.getContentMetadata(str));
        return uriB != null ? uriB : uri;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) throws IOException {
        try {
            String strA = this.f35291e.a(nVar);
            com.google.android.exoplayer2.upstream.n nVarA = nVar.a().f(strA).a();
            this.f35296j = nVarA;
            this.f35295i = j(this.f35287a, strA, nVarA.f35422a);
            this.f35300n = nVar.f35428g;
            int iT = t(nVar);
            boolean z11 = iT != -1;
            this.f35304r = z11;
            if (z11) {
                q(iT);
            }
            if (this.f35304r) {
                this.f35301o = -1L;
            } else {
                long jA = l.a(this.f35287a.getContentMetadata(strA));
                this.f35301o = jA;
                if (jA != -1) {
                    long j11 = jA - nVar.f35428g;
                    this.f35301o = j11;
                    if (j11 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = nVar.f35429h;
            if (jMin != -1) {
                long j12 = this.f35301o;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f35301o = jMin;
            }
            long j13 = this.f35301o;
            if (j13 > 0 || j13 == -1) {
                r(nVarA, false);
            }
            long j14 = nVar.f35429h;
            return j14 != -1 ? j14 : this.f35301o;
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        this.f35296j = null;
        this.f35295i = null;
        this.f35300n = 0L;
        p();
        try {
            f();
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f35288b.e(k0Var);
        this.f35290d.e(k0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() throws IOException {
        com.google.android.exoplayer2.upstream.k kVar = this.f35298l;
        if (kVar == null) {
            return;
        }
        try {
            kVar.close();
        } finally {
            this.f35297k = null;
            this.f35298l = null;
            h hVar = this.f35302p;
            if (hVar != null) {
                this.f35287a.g(hVar);
                this.f35302p = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        return n() ? this.f35290d.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35295i;
    }

    public Cache h() {
        return this.f35287a;
    }

    public g i() {
        return this.f35291e;
    }

    public final void k(Throwable th2) {
        if (m() || (th2 instanceof Cache.CacheException)) {
            this.f35303q = true;
        }
    }

    public final boolean l() {
        return this.f35298l == this.f35290d;
    }

    public final boolean m() {
        return this.f35298l == this.f35288b;
    }

    public final boolean n() {
        return !m();
    }

    public final boolean o() {
        return this.f35298l == this.f35289c;
    }

    public final void p() {
    }

    public final void q(int i11) {
    }

    public final void r(com.google.android.exoplayer2.upstream.n nVar, boolean z11) throws IOException {
        h hVarC;
        long jMin;
        com.google.android.exoplayer2.upstream.n nVarA;
        com.google.android.exoplayer2.upstream.k kVar;
        String str = (String) o0.j(nVar.f35430i);
        if (this.f35304r) {
            hVarC = null;
        } else if (this.f35292f) {
            try {
                hVarC = this.f35287a.c(str, this.f35300n, this.f35301o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            hVarC = this.f35287a.b(str, this.f35300n, this.f35301o);
        }
        if (hVarC == null) {
            kVar = this.f35290d;
            nVarA = nVar.a().h(this.f35300n).g(this.f35301o).a();
        } else if (hVarC.f35325d) {
            Uri uriFromFile = Uri.fromFile((File) o0.j(hVarC.f35326f));
            long j11 = hVarC.f35323b;
            long j12 = this.f35300n - j11;
            long jMin2 = hVarC.f35324c - j12;
            long j13 = this.f35301o;
            if (j13 != -1) {
                jMin2 = Math.min(jMin2, j13);
            }
            nVarA = nVar.a().i(uriFromFile).k(j11).h(j12).g(jMin2).a();
            kVar = this.f35288b;
        } else {
            if (hVarC.c()) {
                jMin = this.f35301o;
            } else {
                jMin = hVarC.f35324c;
                long j14 = this.f35301o;
                if (j14 != -1) {
                    jMin = Math.min(jMin, j14);
                }
            }
            nVarA = nVar.a().h(this.f35300n).g(jMin).a();
            kVar = this.f35289c;
            if (kVar == null) {
                kVar = this.f35290d;
                this.f35287a.g(hVarC);
                hVarC = null;
            }
        }
        this.f35306t = (this.f35304r || kVar != this.f35290d) ? Long.MAX_VALUE : this.f35300n + OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z11) {
            com.google.android.exoplayer2.util.a.g(l());
            if (kVar == this.f35290d) {
                return;
            }
            try {
                f();
            } catch (Throwable th2) {
                if (!((h) o0.j(hVarC)).b()) {
                    throw th2;
                }
                this.f35287a.g(hVarC);
                throw th2;
            }
        }
        if (hVarC != null && hVarC.b()) {
            this.f35302p = hVarC;
        }
        this.f35298l = kVar;
        this.f35297k = nVarA;
        this.f35299m = 0L;
        long jA = kVar.a(nVarA);
        n nVar2 = new n();
        if (nVarA.f35429h == -1 && jA != -1) {
            this.f35301o = jA;
            n.g(nVar2, this.f35300n + jA);
        }
        if (n()) {
            Uri uri = kVar.getUri();
            this.f35295i = uri;
            n.h(nVar2, nVar.f35422a.equals(uri) ^ true ? this.f35295i : null);
        }
        if (o()) {
            this.f35287a.f(str, nVar2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:9:0x001e, B:11:0x0026, B:14:0x002d, B:16:0x003d, B:18:0x0043, B:19:0x0049, B:21:0x005a, B:22:0x005e, B:24:0x0064, B:26:0x006a, B:28:0x0070, B:29:0x007c, B:35:0x0088), top: B:39:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x0086  */
    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        long j11;
        if (i12 == 0) {
            return 0;
        }
        if (this.f35301o == 0) {
            return -1;
        }
        com.google.android.exoplayer2.upstream.n nVar = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(this.f35296j);
        com.google.android.exoplayer2.upstream.n nVar2 = (com.google.android.exoplayer2.upstream.n) com.google.android.exoplayer2.util.a.e(this.f35297k);
        try {
            if (this.f35300n >= this.f35306t) {
                r(nVar, true);
            }
            int i13 = ((com.google.android.exoplayer2.upstream.k) com.google.android.exoplayer2.util.a.e(this.f35298l)).read(bArr, i11, i12);
            if (i13 != -1) {
                if (m()) {
                    this.f35305s += (long) i13;
                }
                long j12 = i13;
                this.f35300n += j12;
                this.f35299m += j12;
                long j13 = this.f35301o;
                if (j13 != -1) {
                    this.f35301o = j13 - j12;
                }
            } else {
                if (!n()) {
                    j11 = this.f35301o;
                    if (j11 <= 0) {
                        if (j11 == -1) {
                        }
                    }
                    f();
                    r(nVar, false);
                    return read(bArr, i11, i12);
                }
                long j14 = nVar2.f35429h;
                if (j14 != -1 && this.f35299m >= j14) {
                    j11 = this.f35301o;
                    if (j11 <= 0) {
                        if (j11 == -1) {
                        }
                    }
                    f();
                    r(nVar, false);
                    return read(bArr, i11, i12);
                }
                s((String) o0.j(nVar.f35430i));
            }
            return i13;
        } catch (Throwable th2) {
            k(th2);
            throw th2;
        }
    }

    public final void s(String str) throws IOException {
        this.f35301o = 0L;
        if (o()) {
            n nVar = new n();
            n.g(nVar, this.f35300n);
            this.f35287a.f(str, nVar);
        }
    }

    public final int t(com.google.android.exoplayer2.upstream.n nVar) {
        if (this.f35293g && this.f35303q) {
            return 0;
        }
        return (this.f35294h && nVar.f35429h == -1) ? 1 : -1;
    }
}

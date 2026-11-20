package androidx.media3.datasource.cache;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.datasource.DataSourceException;
import androidx.media3.datasource.FileDataSource;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f9647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.media3.datasource.a f9648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final androidx.media3.datasource.a f9649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.media3.datasource.a f9650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f9651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f9652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public Uri f9655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public c4.g f9656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public c4.g f9657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public androidx.media3.datasource.a f9658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f9659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f9660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f9661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    public h f9662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f9663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f9664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f9665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f9666t;

    /* JADX INFO: compiled from: source.java */
    public interface b {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements androidx.media3.datasource.a.InterfaceC0090a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f9667a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public c4.c.a f9669c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f9671e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public androidx.media3.datasource.a.InterfaceC0090a f9672f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public PriorityTaskManager f9673g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f9674h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f9675i;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.media3.datasource.a.InterfaceC0090a f9668b = new FileDataSource.b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g f9670d = g.f9681a;

        @Override // androidx.media3.datasource.a.InterfaceC0090a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createDataSource() {
            androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a = this.f9672f;
            return d(interfaceC0090a != null ? interfaceC0090a.createDataSource() : null, this.f9675i, this.f9674h);
        }

        public a b() {
            androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a = this.f9672f;
            return d(interfaceC0090a != null ? interfaceC0090a.createDataSource() : null, this.f9675i | 1, -1000);
        }

        public a c() {
            return d(null, this.f9675i | 1, -1000);
        }

        public final a d(@Nullable androidx.media3.datasource.a aVar, int i11, int i12) {
            c4.c cVarCreateDataSink;
            Cache cache = (Cache) z3.a.e(this.f9667a);
            if (this.f9671e || aVar == null) {
                cVarCreateDataSink = null;
            } else {
                c4.c.a aVar2 = this.f9669c;
                cVarCreateDataSink = aVar2 != null ? aVar2.createDataSink() : new CacheDataSink.a().a(cache).createDataSink();
            }
            return new a(cache, aVar, this.f9668b.createDataSource(), cVarCreateDataSink, this.f9670d, i11, this.f9673g, i12, null);
        }

        @Nullable
        public Cache e() {
            return this.f9667a;
        }

        public g f() {
            return this.f9670d;
        }

        @Nullable
        public PriorityTaskManager g() {
            return this.f9673g;
        }

        public c h(Cache cache) {
            this.f9667a = cache;
            return this;
        }

        public c i(@Nullable androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a) {
            this.f9672f = interfaceC0090a;
            return this;
        }
    }

    public a(Cache cache, @Nullable androidx.media3.datasource.a aVar, androidx.media3.datasource.a aVar2, @Nullable c4.c cVar, @Nullable g gVar, int i11, @Nullable PriorityTaskManager priorityTaskManager, int i12, @Nullable b bVar) {
        this.f9647a = cache;
        this.f9648b = aVar2;
        this.f9651e = gVar == null ? g.f9681a : gVar;
        this.f9652f = (i11 & 1) != 0;
        this.f9653g = (i11 & 2) != 0;
        this.f9654h = (i11 & 4) != 0;
        if (aVar == null) {
            this.f9650d = androidx.media3.datasource.d.f9776a;
            this.f9649c = null;
        } else {
            aVar = priorityTaskManager != null ? new c4.l(aVar, priorityTaskManager, i12) : aVar;
            this.f9650d = aVar;
            this.f9649c = cVar != null ? new c4.n(aVar, cVar) : null;
        }
    }

    public static Uri g(Cache cache, String str, Uri uri) {
        Uri uriB = l.b(cache.getContentMetadata(str));
        return uriB != null ? uriB : uri;
    }

    @Override // androidx.media3.datasource.a
    public long a(c4.g gVar) throws IOException {
        try {
            String strA = this.f9651e.a(gVar);
            c4.g gVarA = gVar.a().f(strA).a();
            this.f9656j = gVarA;
            this.f9655i = g(this.f9647a, strA, gVarA.f14598a);
            this.f9660n = gVar.f14604g;
            int iQ = q(gVar);
            boolean z11 = iQ != -1;
            this.f9664r = z11;
            if (z11) {
                n(iQ);
            }
            if (this.f9664r) {
                this.f9661o = -1L;
            } else {
                long jA = l.a(this.f9647a.getContentMetadata(strA));
                this.f9661o = jA;
                if (jA != -1) {
                    long j11 = jA - gVar.f14604g;
                    this.f9661o = j11;
                    if (j11 < 0) {
                        throw new DataSourceException(2008);
                    }
                }
            }
            long jMin = gVar.f14605h;
            if (jMin != -1) {
                long j12 = this.f9661o;
                if (j12 != -1) {
                    jMin = Math.min(j12, jMin);
                }
                this.f9661o = jMin;
            }
            long j13 = this.f9661o;
            if (j13 > 0 || j13 == -1) {
                o(gVarA, false);
            }
            long j14 = gVar.f14605h;
            return j14 != -1 ? j14 : this.f9661o;
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }

    @Override // androidx.media3.datasource.a
    public void c(c4.o oVar) {
        z3.a.e(oVar);
        this.f9648b.c(oVar);
        this.f9650d.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        this.f9656j = null;
        this.f9655i = null;
        this.f9660n = 0L;
        m();
        try {
            d();
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() throws IOException {
        androidx.media3.datasource.a aVar = this.f9658l;
        if (aVar == null) {
            return;
        }
        try {
            aVar.close();
        } finally {
            this.f9657k = null;
            this.f9658l = null;
            h hVar = this.f9662p;
            if (hVar != null) {
                this.f9647a.g(hVar);
                this.f9662p = null;
            }
        }
    }

    public Cache e() {
        return this.f9647a;
    }

    public g f() {
        return this.f9651e;
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        return k() ? this.f9650d.getResponseHeaders() : Collections.emptyMap();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f9655i;
    }

    public final void h(Throwable th2) {
        if (j() || (th2 instanceof Cache.CacheException)) {
            this.f9663q = true;
        }
    }

    public final boolean i() {
        return this.f9658l == this.f9650d;
    }

    public final boolean j() {
        return this.f9658l == this.f9648b;
    }

    public final boolean k() {
        return !j();
    }

    public final boolean l() {
        return this.f9658l == this.f9649c;
    }

    public final void m() {
    }

    public final void n(int i11) {
    }

    public final void o(c4.g gVar, boolean z11) throws IOException {
        h hVarC;
        long jMin;
        c4.g gVarA;
        androidx.media3.datasource.a aVar;
        String str = (String) u0.i(gVar.f14606i);
        if (this.f9664r) {
            hVarC = null;
        } else if (this.f9652f) {
            try {
                hVarC = this.f9647a.c(str, this.f9660n, this.f9661o);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
        } else {
            hVarC = this.f9647a.b(str, this.f9660n, this.f9661o);
        }
        if (hVarC == null) {
            aVar = this.f9650d;
            gVarA = gVar.a().h(this.f9660n).g(this.f9661o).a();
        } else if (hVarC.f9685d) {
            Uri uriFromFile = Uri.fromFile((File) u0.i(hVarC.f9686f));
            long j11 = hVarC.f9683b;
            long j12 = this.f9660n - j11;
            long jMin2 = hVarC.f9684c - j12;
            long j13 = this.f9661o;
            if (j13 != -1) {
                jMin2 = Math.min(jMin2, j13);
            }
            gVarA = gVar.a().i(uriFromFile).k(j11).h(j12).g(jMin2).a();
            aVar = this.f9648b;
        } else {
            if (hVarC.c()) {
                jMin = this.f9661o;
            } else {
                jMin = hVarC.f9684c;
                long j14 = this.f9661o;
                if (j14 != -1) {
                    jMin = Math.min(jMin, j14);
                }
            }
            gVarA = gVar.a().h(this.f9660n).g(jMin).a();
            aVar = this.f9649c;
            if (aVar == null) {
                aVar = this.f9650d;
                this.f9647a.g(hVarC);
                hVarC = null;
            }
        }
        this.f9666t = (this.f9664r || aVar != this.f9650d) ? Long.MAX_VALUE : this.f9660n + OSSConstants.MIN_PART_SIZE_LIMIT;
        if (z11) {
            z3.a.g(i());
            if (aVar == this.f9650d) {
                return;
            }
            try {
                d();
            } catch (Throwable th2) {
                if (!((h) u0.i(hVarC)).b()) {
                    throw th2;
                }
                this.f9647a.g(hVarC);
                throw th2;
            }
        }
        if (hVarC != null && hVarC.b()) {
            this.f9662p = hVarC;
        }
        this.f9658l = aVar;
        this.f9657k = gVarA;
        this.f9659m = 0L;
        long jA = aVar.a(gVarA);
        n nVar = new n();
        if (gVarA.f14605h == -1 && jA != -1) {
            this.f9661o = jA;
            n.g(nVar, this.f9660n + jA);
        }
        if (k()) {
            Uri uri = aVar.getUri();
            this.f9655i = uri;
            n.h(nVar, gVar.f14598a.equals(uri) ^ true ? this.f9655i : null);
        }
        if (l()) {
            this.f9647a.h(str, nVar);
        }
    }

    public final void p(String str) throws IOException {
        this.f9661o = 0L;
        if (l()) {
            n nVar = new n();
            n.g(nVar, this.f9660n);
            this.f9647a.h(str, nVar);
        }
    }

    public final int q(c4.g gVar) {
        if (this.f9653g && this.f9663q) {
            return 0;
        }
        return (this.f9654h && gVar.f14605h == -1) ? 1 : -1;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x007c A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:9:0x001e, B:11:0x0026, B:14:0x002d, B:16:0x003d, B:18:0x0043, B:19:0x0049, B:21:0x005a, B:22:0x005e, B:24:0x0064, B:26:0x006a, B:28:0x0070, B:29:0x007c, B:35:0x0088), top: B:39:0x001e }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0082  */
    /* JADX WARN: Code duplicated, block: B:33:0x0086  */
    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        long j11;
        if (i12 == 0) {
            return 0;
        }
        if (this.f9661o == 0) {
            return -1;
        }
        c4.g gVar = (c4.g) z3.a.e(this.f9656j);
        c4.g gVar2 = (c4.g) z3.a.e(this.f9657k);
        try {
            if (this.f9660n >= this.f9666t) {
                o(gVar, true);
            }
            int i13 = ((androidx.media3.datasource.a) z3.a.e(this.f9658l)).read(bArr, i11, i12);
            if (i13 != -1) {
                if (j()) {
                    this.f9665s += (long) i13;
                }
                long j12 = i13;
                this.f9660n += j12;
                this.f9659m += j12;
                long j13 = this.f9661o;
                if (j13 != -1) {
                    this.f9661o = j13 - j12;
                }
            } else {
                if (!k()) {
                    j11 = this.f9661o;
                    if (j11 <= 0) {
                        if (j11 == -1) {
                        }
                    }
                    d();
                    o(gVar, false);
                    return read(bArr, i11, i12);
                }
                long j14 = gVar2.f14605h;
                if (j14 != -1 && this.f9659m >= j14) {
                    j11 = this.f9661o;
                    if (j11 <= 0) {
                        if (j11 == -1) {
                        }
                    }
                    d();
                    o(gVar, false);
                    return read(bArr, i11, i12);
                }
                p((String) u0.i(gVar.f14606i));
            }
            return i13;
        } catch (Throwable th2) {
            h(th2);
            throw th2;
        }
    }
}

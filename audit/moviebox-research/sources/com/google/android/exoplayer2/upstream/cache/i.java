package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.cache.a f35328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cache f35329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.n f35330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f35331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f35332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final a f35333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f35334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f35336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f35337j;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(long j11, long j12, long j13);
    }

    public i(com.google.android.exoplayer2.upstream.cache.a aVar, com.google.android.exoplayer2.upstream.n nVar, @Nullable byte[] bArr, @Nullable a aVar2) {
        this.f35328a = aVar;
        this.f35329b = aVar.h();
        this.f35330c = nVar;
        this.f35332e = bArr == null ? new byte[131072] : bArr;
        this.f35333f = aVar2;
        this.f35331d = aVar.i().a(nVar);
        this.f35334g = nVar.f35428g;
    }

    public void a() throws IOException {
        g();
        Cache cache = this.f35329b;
        String str = this.f35331d;
        com.google.android.exoplayer2.upstream.n nVar = this.f35330c;
        this.f35336i = cache.a(str, nVar.f35428g, nVar.f35429h);
        com.google.android.exoplayer2.upstream.n nVar2 = this.f35330c;
        long j11 = nVar2.f35429h;
        if (j11 != -1) {
            this.f35335h = nVar2.f35428g + j11;
        } else {
            long jA = l.a(this.f35329b.getContentMetadata(this.f35331d));
            if (jA == -1) {
                jA = -1;
            }
            this.f35335h = jA;
        }
        a aVar = this.f35333f;
        if (aVar != null) {
            aVar.a(c(), this.f35336i, 0L);
        }
        while (true) {
            long j12 = this.f35335h;
            if (j12 != -1 && this.f35334g >= j12) {
                return;
            }
            g();
            long j13 = this.f35335h;
            long cachedLength = this.f35329b.getCachedLength(this.f35331d, this.f35334g, j13 == -1 ? Long.MAX_VALUE : j13 - this.f35334g);
            if (cachedLength > 0) {
                this.f35334g += cachedLength;
            } else {
                long j14 = -cachedLength;
                if (j14 == Long.MAX_VALUE) {
                    j14 = -1;
                }
                long j15 = this.f35334g;
                this.f35334g = j15 + f(j15, j14);
            }
        }
    }

    public void b() {
        this.f35337j = true;
    }

    public final long c() {
        long j11 = this.f35335h;
        if (j11 == -1) {
            return -1L;
        }
        return j11 - this.f35330c.f35428g;
    }

    public final void d(long j11) {
        this.f35336i += j11;
        a aVar = this.f35333f;
        if (aVar != null) {
            aVar.a(c(), this.f35336i, j11);
        }
    }

    public final void e(long j11) {
        if (this.f35335h == j11) {
            return;
        }
        this.f35335h = j11;
        a aVar = this.f35333f;
        if (aVar != null) {
            aVar.a(c(), this.f35336i, 0L);
        }
    }

    public final long f(long j11, long j12) throws IOException {
        long jA;
        boolean z11 = true;
        boolean z12 = j11 + j12 == this.f35335h || j12 == -1;
        if (j12 != -1) {
            try {
                jA = this.f35328a.a(this.f35330c.a().h(j11).g(j12).a());
            } catch (IOException unused) {
                com.google.android.exoplayer2.upstream.m.a(this.f35328a);
                jA = -1;
                z11 = false;
            }
        } else {
            jA = -1;
            z11 = false;
        }
        if (!z11) {
            g();
            try {
                jA = this.f35328a.a(this.f35330c.a().h(j11).g(-1L).a());
            } catch (IOException e11) {
                com.google.android.exoplayer2.upstream.m.a(this.f35328a);
                throw e11;
            }
        }
        if (z12 && jA != -1) {
            try {
                e(jA + j11);
            } catch (IOException e12) {
                com.google.android.exoplayer2.upstream.m.a(this.f35328a);
                throw e12;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 != -1) {
            g();
            com.google.android.exoplayer2.upstream.cache.a aVar = this.f35328a;
            byte[] bArr = this.f35332e;
            i11 = aVar.read(bArr, 0, bArr.length);
            if (i11 != -1) {
                d(i11);
                i12 += i11;
            }
        }
        if (z12) {
            e(j11 + ((long) i12));
        }
        this.f35328a.close();
        return i12;
    }

    public final void g() throws InterruptedIOException {
        if (this.f35337j) {
            throw new InterruptedIOException();
        }
    }
}

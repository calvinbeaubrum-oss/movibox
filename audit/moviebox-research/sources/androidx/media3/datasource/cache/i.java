package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InterruptedIOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.cache.a f9688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Cache f9689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.g f9690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f9691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f9692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final a f9693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9695h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9696i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f9697j;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(long j11, long j12, long j13);
    }

    public i(androidx.media3.datasource.cache.a aVar, c4.g gVar, @Nullable byte[] bArr, @Nullable a aVar2) {
        this.f9688a = aVar;
        this.f9689b = aVar.e();
        this.f9690c = gVar;
        this.f9692e = bArr == null ? new byte[131072] : bArr;
        this.f9693f = aVar2;
        this.f9691d = aVar.f().a(gVar);
        this.f9694g = gVar.f14604g;
    }

    public void a() throws IOException {
        g();
        Cache cache = this.f9689b;
        String str = this.f9691d;
        c4.g gVar = this.f9690c;
        this.f9696i = cache.a(str, gVar.f14604g, gVar.f14605h);
        c4.g gVar2 = this.f9690c;
        long j11 = gVar2.f14605h;
        if (j11 != -1) {
            this.f9695h = gVar2.f14604g + j11;
        } else {
            long jA = l.a(this.f9689b.getContentMetadata(this.f9691d));
            if (jA == -1) {
                jA = -1;
            }
            this.f9695h = jA;
        }
        a aVar = this.f9693f;
        if (aVar != null) {
            aVar.a(c(), this.f9696i, 0L);
        }
        while (true) {
            long j12 = this.f9695h;
            if (j12 != -1 && this.f9694g >= j12) {
                return;
            }
            g();
            long j13 = this.f9695h;
            long cachedLength = this.f9689b.getCachedLength(this.f9691d, this.f9694g, j13 == -1 ? Long.MAX_VALUE : j13 - this.f9694g);
            if (cachedLength > 0) {
                this.f9694g += cachedLength;
            } else {
                long j14 = -cachedLength;
                if (j14 == Long.MAX_VALUE) {
                    j14 = -1;
                }
                long j15 = this.f9694g;
                this.f9694g = j15 + f(j15, j14);
            }
        }
    }

    public void b() {
        this.f9697j = true;
    }

    public final long c() {
        long j11 = this.f9695h;
        if (j11 == -1) {
            return -1L;
        }
        return j11 - this.f9690c.f14604g;
    }

    public final void d(long j11) {
        this.f9696i += j11;
        a aVar = this.f9693f;
        if (aVar != null) {
            aVar.a(c(), this.f9696i, j11);
        }
    }

    public final void e(long j11) {
        if (this.f9695h == j11) {
            return;
        }
        this.f9695h = j11;
        a aVar = this.f9693f;
        if (aVar != null) {
            aVar.a(c(), this.f9696i, 0L);
        }
    }

    public final long f(long j11, long j12) throws IOException {
        long jA;
        boolean z11 = true;
        boolean z12 = j11 + j12 == this.f9695h || j12 == -1;
        if (j12 != -1) {
            try {
                jA = this.f9688a.a(this.f9690c.a().h(j11).g(j12).a());
            } catch (IOException unused) {
                c4.f.a(this.f9688a);
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
                jA = this.f9688a.a(this.f9690c.a().h(j11).g(-1L).a());
            } catch (IOException e11) {
                c4.f.a(this.f9688a);
                throw e11;
            }
        }
        if (z12 && jA != -1) {
            try {
                e(jA + j11);
            } catch (IOException e12) {
                c4.f.a(this.f9688a);
                throw e12;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 != -1) {
            g();
            androidx.media3.datasource.cache.a aVar = this.f9688a;
            byte[] bArr = this.f9692e;
            i11 = aVar.read(bArr, 0, bArr.length);
            if (i11 != -1) {
                d(i11);
                i12 += i11;
            }
        }
        if (z12) {
            e(j11 + ((long) i12));
        }
        this.f9688a.close();
        return i12;
    }

    public final void g() throws InterruptedIOException {
        if (this.f9697j) {
            throw new InterruptedIOException();
        }
    }
}

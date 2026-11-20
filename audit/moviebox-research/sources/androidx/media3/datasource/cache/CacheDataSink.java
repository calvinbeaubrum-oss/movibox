package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class CacheDataSink implements c4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f9622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public c4.g f9625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f9626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public File f9627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public OutputStream f9628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f9630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f9631j;

    /* JADX INFO: compiled from: source.java */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements c4.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f9632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f9633b = 5242880;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f9634c = com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE;

        public a a(Cache cache) {
            this.f9632a = cache;
            return this;
        }

        @Override // c4.c.a
        public c4.c createDataSink() {
            return new CacheDataSink((Cache) z3.a.e(this.f9632a), this.f9633b, this.f9634c);
        }
    }

    public CacheDataSink(Cache cache, long j11, int i11) {
        z3.a.h(j11 > 0 || j11 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j11 != -1 && j11 < 2097152) {
            z3.o.h("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f9622a = (Cache) z3.a.e(cache);
        this.f9623b = j11 == -1 ? Long.MAX_VALUE : j11;
        this.f9624c = i11;
    }

    @Override // c4.c
    public void a(c4.g gVar) throws CacheDataSinkException {
        z3.a.e(gVar.f14606i);
        if (gVar.f14605h == -1 && gVar.d(2)) {
            this.f9625d = null;
            return;
        }
        this.f9625d = gVar;
        this.f9626e = gVar.d(4) ? this.f9623b : Long.MAX_VALUE;
        this.f9630i = 0L;
        try {
            c(gVar);
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f9628g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            u0.m(this.f9628g);
            this.f9628g = null;
            File file = (File) u0.i(this.f9627f);
            this.f9627f = null;
            this.f9622a.d(file, this.f9629h);
        } catch (Throwable th2) {
            u0.m(this.f9628g);
            this.f9628g = null;
            File file2 = (File) u0.i(this.f9627f);
            this.f9627f = null;
            file2.delete();
            throw th2;
        }
    }

    public final void c(c4.g gVar) throws IOException {
        long j11 = gVar.f14605h;
        this.f9627f = this.f9622a.startFile((String) u0.i(gVar.f14606i), gVar.f14604g + this.f9630i, j11 != -1 ? Math.min(j11 - this.f9630i, this.f9626e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f9627f);
        if (this.f9624c > 0) {
            r rVar = this.f9631j;
            if (rVar == null) {
                this.f9631j = new r(fileOutputStream, this.f9624c);
            } else {
                rVar.a(fileOutputStream);
            }
            this.f9628g = this.f9631j;
        } else {
            this.f9628g = fileOutputStream;
        }
        this.f9629h = 0L;
    }

    @Override // c4.c
    public void close() throws CacheDataSinkException {
        if (this.f9625d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // c4.c
    public void write(byte[] bArr, int i11, int i12) throws CacheDataSinkException {
        c4.g gVar = this.f9625d;
        if (gVar == null) {
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            try {
                if (this.f9629h == this.f9626e) {
                    b();
                    c(gVar);
                }
                int iMin = (int) Math.min(i12 - i13, this.f9626e - this.f9629h);
                ((OutputStream) u0.i(this.f9628g)).write(bArr, i11 + i13, iMin);
                i13 += iMin;
                long j11 = iMin;
                this.f9629h += j11;
                this.f9630i += j11;
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        }
    }
}

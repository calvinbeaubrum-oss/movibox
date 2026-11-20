package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class CacheDataSink implements com.google.android.exoplayer2.upstream.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f35262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f35263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.n f35265d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f35266e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public File f35267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public OutputStream f35268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f35269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f35270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r f35271j;

    /* JADX INFO: compiled from: source.java */
    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super(iOException);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements com.google.android.exoplayer2.upstream.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cache f35272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f35273b = 5242880;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35274c = com.mbridge.msdk.playercommon.exoplayer2.upstream.cache.CacheDataSink.DEFAULT_BUFFER_SIZE;

        public a a(Cache cache) {
            this.f35272a = cache;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.i.a
        public com.google.android.exoplayer2.upstream.i createDataSink() {
            return new CacheDataSink((Cache) com.google.android.exoplayer2.util.a.e(this.f35272a), this.f35273b, this.f35274c);
        }
    }

    public CacheDataSink(Cache cache, long j11, int i11) {
        com.google.android.exoplayer2.util.a.h(j11 > 0 || j11 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        if (j11 != -1 && j11 < 2097152) {
            com.google.android.exoplayer2.util.s.i("CacheDataSink", "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f35262a = (Cache) com.google.android.exoplayer2.util.a.e(cache);
        this.f35263b = j11 == -1 ? Long.MAX_VALUE : j11;
        this.f35264c = i11;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void a(com.google.android.exoplayer2.upstream.n nVar) throws CacheDataSinkException {
        com.google.android.exoplayer2.util.a.e(nVar.f35430i);
        if (nVar.f35429h == -1 && nVar.d(2)) {
            this.f35265d = null;
            return;
        }
        this.f35265d = nVar;
        this.f35266e = nVar.d(4) ? this.f35263b : Long.MAX_VALUE;
        this.f35270i = 0L;
        try {
            c(nVar);
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    public final void b() throws IOException {
        OutputStream outputStream = this.f35268g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            o0.n(this.f35268g);
            this.f35268g = null;
            File file = (File) o0.j(this.f35267f);
            this.f35267f = null;
            this.f35262a.d(file, this.f35269h);
        } catch (Throwable th2) {
            o0.n(this.f35268g);
            this.f35268g = null;
            File file2 = (File) o0.j(this.f35267f);
            this.f35267f = null;
            file2.delete();
            throw th2;
        }
    }

    public final void c(com.google.android.exoplayer2.upstream.n nVar) throws IOException {
        long j11 = nVar.f35429h;
        this.f35267f = this.f35262a.startFile((String) o0.j(nVar.f35430i), nVar.f35428g + this.f35270i, j11 != -1 ? Math.min(j11 - this.f35270i, this.f35266e) : -1L);
        FileOutputStream fileOutputStream = new FileOutputStream(this.f35267f);
        if (this.f35264c > 0) {
            r rVar = this.f35271j;
            if (rVar == null) {
                this.f35271j = new r(fileOutputStream, this.f35264c);
            } else {
                rVar.a(fileOutputStream);
            }
            this.f35268g = this.f35271j;
        } else {
            this.f35268g = fileOutputStream;
        }
        this.f35269h = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void close() throws CacheDataSinkException {
        if (this.f35265d == null) {
            return;
        }
        try {
            b();
        } catch (IOException e11) {
            throw new CacheDataSinkException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public void write(byte[] bArr, int i11, int i12) throws CacheDataSinkException {
        com.google.android.exoplayer2.upstream.n nVar = this.f35265d;
        if (nVar == null) {
            return;
        }
        int i13 = 0;
        while (i13 < i12) {
            try {
                if (this.f35269h == this.f35266e) {
                    b();
                    c(nVar);
                }
                int iMin = (int) Math.min(i12 - i13, this.f35266e - this.f35269h);
                ((OutputStream) o0.j(this.f35268g)).write(bArr, i11 + i13, iMin);
                i13 += iMin;
                long j11 = iMin;
                this.f35269h += j11;
                this.f35270i += j11;
            } catch (IOException e11) {
                throw new CacheDataSinkException(e11);
            }
        }
    }
}
